package test.extentions;

import simpleHttp.extentions.Interceptor;
import simpleHttp.http.RequestContext;

/**
 * Created by Wang Juqiang on 2018/3/19.
 */
public class MyInterceptor implements Interceptor {
    @Override
    public void beforeRequest(RequestContext context) {
        System.out.println("before request:" + context.getUrl());
    }

    @Override
    public void endRequest(RequestContext context) {
        System.out.println("end request:" + context.getUrl());
    }

    @Override
    public void onException(RequestContext context) {
        System.out.println("exception:" + context.getUrl());
    }
}
