package simpleHttp.extentions;

import java.lang.reflect.Type;

/**
 * Created by Wang Juqiang on 2018/3/20.
 */
public class DefaultSerializer implements Serializer {
    @Override
    public String serialize(Object obj, Type type) {
        if (type != String.class) {
            throw new RuntimeException("默认序列化器只支持字符串类型");
        }
        return obj.toString();
    }

    @Override
    public Object deSerialize(String str, Type type) {
        if (type != String.class) {
            throw new RuntimeException("默认序列化器只支持字符串类型");
        }
        return str;
    }
}
