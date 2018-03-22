package simpleHttp.extentions;

import simpleHttp.http.RequestContext;

/**
 * Created by Wang Juqiang on 2018/3/17.
 */
public interface Interceptor {
    void beforeRequest(RequestContext context);

    void endRequest(RequestContext context);

    void onException(RequestContext context);
}
