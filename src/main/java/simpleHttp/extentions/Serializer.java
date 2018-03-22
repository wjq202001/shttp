package simpleHttp.extentions;

import java.lang.reflect.Type;

/**
 * Created by Wang Juqiang on 2018/3/18.
 */
public interface Serializer {
    String serialize(Object obj, Type type);

    Object deSerialize(String str, Type type);
}
