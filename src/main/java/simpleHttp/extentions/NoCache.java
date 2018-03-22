package simpleHttp.extentions;

import java.util.function.Supplier;

/**
 * Created by Wang Juqiang on 2018/3/20.
 */
public class NoCache implements Cache {
    @Override
    public Object loadFromCache(String key, Supplier supplier) {
        return supplier.get();
    }
}
