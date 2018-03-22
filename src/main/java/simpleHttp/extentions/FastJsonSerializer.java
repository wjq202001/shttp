package simpleHttp.extentions;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Type;

/**
 * Created by Wang Juqiang on 2018/3/18.
 */
public class FastJsonSerializer implements Serializer {
    @Override
    public String serialize(Object obj, Type type) {

        return JSON.toJSONString(obj, false);
    }

    @Override
    public Object deSerialize(String str, Type type) {
        return JSON.parseObject(str, type);
    }
}
