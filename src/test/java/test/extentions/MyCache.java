package test.extentions;

import simpleHttp.extentions.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Wang Juqiang on 2018/3/19.
 */
public class MyCache implements Cache {
    Map<String, Object> cached = new HashMap<>();

    @Override
    public Object loadFromCache(String key, Supplier supplier) {
        if (cached.containsKey(key)) {
            return cached.get(key);
        } else {
            Object obj = supplier.get();
            cached.put(key, obj);
            return obj;
        }

    }
}
