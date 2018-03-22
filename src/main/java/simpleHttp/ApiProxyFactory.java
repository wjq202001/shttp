package simpleHttp;

import simpleHttp.extentions.Cache;
import simpleHttp.extentions.Interceptor;
import simpleHttp.extentions.Serializer;

import java.lang.reflect.Proxy;

/**
 * Created by Wang Juqiang on 2018/3/16.
 */
public class ApiProxyFactory {
    private static <T> T newIntance(Class<T> cls, HttpRequestHandler httpRequestHandler) {
        Object newProxyInstance = Proxy.newProxyInstance(
                cls.getClassLoader(),
                new Class[]{cls},
                httpRequestHandler);
        T instance = (T) newProxyInstance;

        return instance;
    }

    public static <T> T createInstance(Class<T> cls) {
        HttpRequestHandler invocationHandler = new HttpRequestHandler(null, null, null);
        return newIntance(cls, invocationHandler);
    }

    public static <T> T createInstance(Class<T> cls, Interceptor interceptor) {

        HttpRequestHandler invocationHandler = new HttpRequestHandler(interceptor, null, null);
        return newIntance(cls, invocationHandler);
    }

    public static <T> T createInstance(Class<T> cls, Serializer serializer) {

        HttpRequestHandler invocationHandler = new HttpRequestHandler(null, serializer, null);
        return newIntance(cls, invocationHandler);
    }

    public static <T> T createInstance(Class<T> cls, Serializer serializer, Interceptor interceptor, Cache cache) {

        HttpRequestHandler invocationHandler = new HttpRequestHandler(interceptor, serializer, cache);
        return newIntance(cls, invocationHandler);
    }

}
