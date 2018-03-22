package simpleHttp.http;

import simpleHttp.annotations.Host;
import simpleHttp.annotations.Para;
import simpleHttp.annotations.PostBody;
import simpleHttp.annotations.Url;
import simpleHttp.extentions.Cache;
import simpleHttp.extentions.Interceptor;
import simpleHttp.extentions.Serializer;
import simpleHttp.extentions.SerializerSelector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by Wang Juqiang on 2018/3/17.
 */
public class RequestBuiler {
    private Method method;
    private Object[] args;
    private Host host;
    private Url url;
    private String postBody;
    private Type returnType;

    public RequestBuiler(Method method, Object[] args) {
        this.method = method;
        this.args = args;

        Class type = null;
        try {
            Field clazzField = Method.class.getDeclaredField("clazz");
            clazzField.setAccessible(true);
            type = (Class) clazzField.get(method);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        this.host = (Host) type.getAnnotation(Host.class);

        this.url = method.getAnnotation(Url.class);
        this.returnType = method.getGenericReturnType();
    }

    public String getRequestUrl() {
        StringBuilder urlBuilder = new StringBuilder();
        if (host.protocol() == "") {
            urlBuilder.append("//");
        } else {
            urlBuilder.append(host.protocol() + "://");
        }

        urlBuilder.append(host.name());
        urlBuilder.append(url.path());
        urlBuilder.append("?");
        Parameter[] paras = method.getParameters();
        if (paras != null && paras.length > 0) {
            for (int i = 0; i < paras.length; i++) {
                Para para = paras[i].getAnnotation(Para.class);
                if (para != null) {
                    urlBuilder.append(para.paraName() + "=" + args[i].toString());
                }

                if (i != paras.length - 1) {
                    urlBuilder.append("&");
                }
            }
        }
        return urlBuilder.toString();
    }

    private RequestSettings getRequestSettings() {
        RequestSettings requestSettings = new RequestSettings();
        requestSettings.setCharset(this.url.charset());
        requestSettings.setTimeOut(this.url.timeout());
        requestSettings.setAccept(this.url.contentType());
        requestSettings.setContinueOnExceptions(this.url.continueOnExceptions());
        requestSettings.setDowngrade(this.url.downgrade());
        requestSettings.setUrl(this.getRequestUrl());
        requestSettings.setUserAgent("");
        requestSettings.setContentType(this.url.contentType());
        requestSettings.setMethod(this.url.method());
        return requestSettings;
    }

    public Object sendRequest(Interceptor interceptor, Serializer serializer, Cache cache) {
        RequestContext context = this.initRequestContext();
        if (this.url.cacheAble() && cache != null) {
            return cache.loadFromCache(context.getUrl(), () -> this.sendRequest1(context, interceptor, serializer));
        } else return this.sendRequest1(context, interceptor, serializer);
    }

    private Object sendRequest1(RequestContext context, Interceptor interceptor, Serializer serializer) {
        String strResult = "";
        if(serializer==null){
            serializer = SerializerSelector.getSerializer(this.url.contentType());
        }
        boolean retryToSuccess = this.url.retryTimes() == 0;
        int retryTimes = 0;
        while (true) {
            try {
                retryTimes++;
                Date date = new Date();
                if (interceptor != null) {
                    interceptor.beforeRequest(context);
                }
                if (this.url.method().equals(HttpMethod.POST)) {
                    strResult = Requester.post(context.getRequestSettings(), this.getPostBody(serializer));
                } else if (this.url.method().equals(HttpMethod.GET)) {
                    strResult = Requester.get(context.getRequestSettings());
                }

                if (interceptor != null) {
                    long timeTaken = new Date().getTime() - date.getTime();
                    context.setTimeTaken(timeTaken);
                    interceptor.endRequest(context);
                }
                break;
            } catch (Exception e) {
                if (retryTimes >= this.url.retryTimes()
                        || !retryToSuccess) {
                    context.setException(e);
                    if (interceptor != null) {
                        Date date = new Date();
                        long timeTaken = new Date().getTime() - date.getTime();
                        context.setTimeTaken(timeTaken);
                        interceptor.onException(context);
                    }
                    break;
                }
            }
        }


            return serializer.deSerialize(strResult, this.returnType);

    }

    private String getPostBody(Serializer serializer) {
        if(serializer==null){
            serializer = SerializerSelector.getSerializer(this.url.contentType());
        }
        if (this.url.contentType().toLowerCase().equals("application/json")) {
            Parameter[] paras = method.getParameters();
            if (paras != null && paras.length > 0) {
                for (int i = 0; i < paras.length; i++) {
                    PostBody postBody = paras[i].getAnnotation(PostBody.class);
                    if (postBody != null) {
                        return serializer.serialize(args[i], args[i].getClass());
                    }
                }
            }
        } else if (this.url.contentType().toLowerCase().equals("text/plain")) {
            StringBuilder postBodyBuilder = new StringBuilder();
            Parameter[] paras = method.getParameters();
            if (paras != null && paras.length > 0) {
                for (int i = 0; i < paras.length; i++) {
                    PostBody postBody = paras[i].getAnnotation(PostBody.class);
                    if (postBody != null) {
                        postBodyBuilder.append(postBody.key() + "=" + args[i].toString());
                    }
                }
            }
        } else {
            throw new RuntimeException("暂不支持Content-Type of: " + this.url.contentType());
        }
        return "";
    }

    private RequestContext initRequestContext() {
        RequestSettings requestSettings = getRequestSettings();
        RequestContext context = new RequestContext(requestSettings);
        context.setUrl(requestSettings.getUrl());
        return context;
    }
}
