package test;

import org.junit.Test;
import simpleHttp.ApiProxyFactory;
import simpleHttp.extentions.FastJsonSerializer;
import test.extentions.MyCache;
import test.extentions.MyInterceptor;
import test.models.Info;
import test.models.PagedList;
import test.models.Protocol;

/**
 * Created by Wang Juqiang on 2018/3/16.
 */
public class ApiCallTest {
//    @Test
//    public void test() {
//        DomainApi api = ApiProxyFactory.createInstance(DomainApi.class, new FastJsonSerializer(), new MyInterceptor(), new MyCache());
//        Info info = api.getInfo(1);
//    }
//
//    @Test
//    public void test2() {
//        DomainApi api = ApiProxyFactory.createInstance(DomainApi.class, new FastJsonSerializer(), new MyInterceptor(), new MyCache());
//        Protocol<PagedList<Info>> result = api.getList(1,1);
//    }


//    @Test
//    public void postTest() {
//        OrderInfo orderInfo = new OrderInfo();
//        orderInfo.setCityId(110100);
//        orderInfo.setDealerId(1);
//        orderInfo.setUserPhone("老聚");
//        orderInfo.setSpecId(3);
//        LocalApi localApi = ApiProxyFactory.createInstance(LocalApi.class);
//        Protocol p = localApi.createOrder(orderInfo);
//        Assert.assertEquals(0, p.getReturnCode());
//    }


}
