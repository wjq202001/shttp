package simpleHttp.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wang Juqiang on 2018/3/17.
 */
public class TypeHolder {
    static Map<Class, Object> types = new HashMap();

    public static Object getInstance(Class clazz) {
        if (types.containsKey(clazz)) {
            return types.get(clazz);
        } else {
            return null;
        }
    }

    public static void put(Class clazz, Object instance) {
        if (!types.containsKey(clazz)) {
            types.put(clazz, instance);
        }
    }
}
