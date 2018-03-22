package test;

import simpleHttp.annotations.Host;
import simpleHttp.annotations.PostBody;
import simpleHttp.annotations.Url;
import simpleHttp.http.HttpMethod;
import test.models.OrderInfo;
import test.models.Protocol;

/**
 * Created by Wang Juqiang on 2018/3/21.
 */
@Host(name = "localhost:4710")
public interface LocalApi {
    @Url(path = "/order/CreateOrder", method = HttpMethod.POST)
    Protocol<String> createOrder(@PostBody(key = "orderInfo") OrderInfo orderInfo);
}
