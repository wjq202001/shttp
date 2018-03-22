package simpleHttp.extentions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wang Juqiang on 2018/3/21.
 */
public class SerializerSelector {
    static Map<Class,Object> serializers = init();
    static Map<Class,Object> init(){
        Map<Class,Object> map = new HashMap<>();
        map.put(FastJsonSerializer.class,new FastJsonSerializer());
        map.put(DefaultInterceptor.class,new DefaultSerializer());
        return map;
    }
    public static Serializer getSerializer(String contentType){
        switch (contentType){
            case "application/json":
                return (FastJsonSerializer) serializers.get(FastJsonSerializer.class);
            default:
                return (DefaultSerializer) serializers.get(DefaultSerializer.class);
        }
    }
}
