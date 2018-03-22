package simpleHttp.extentions;


import java.util.function.Supplier;

/**
 * Created by Wang Juqiang on 2018/3/18.
 */
public interface Cache {
    Object loadFromCache(String key, Supplier supplier);
}
