package simpleHttp;

import simpleHttp.extentions.Cache;
import simpleHttp.extentions.Interceptor;
import simpleHttp.extentions.Serializer;
import simpleHttp.http.RequestBuiler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Wang Juqiang on 2018/3/16.
 */
public class HttpRequestHandler implements InvocationHandler {
    private Serializer serializer = null;
    private Interceptor interceptor = null;
    private Cache cache = null;

    public HttpRequestHandler(Interceptor interceptor, Serializer serializer, Cache cache) {
        this.interceptor = interceptor;
        this.serializer = serializer;
        this.cache = cache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如果传进来是一个已实现的具体类（本次演示略过此逻辑)
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                return method.invoke(this, args);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            //如果传进来的是一个接口（核心)
        } else {
            return getResponse(method, args);
        }
        return null;
    }

    /**
     * 实现接口的核心方法
     *
     * @param method
     * @param args
     * @return
     */
    public Object getResponse(Method method, Object[] args) {
        RequestBuiler requestBuiler = new RequestBuiler(method, args);
        //TODO
        //如远程http调用
        //如远程方法调用（rmi)
        //....
        return requestBuiler.sendRequest(interceptor, serializer, cache);
    }
}
