package simpleHttp.annotations;

import java.lang.annotation.*;

/**
 * Created by Wang Juqiang on 2018/3/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface PostBody {
    String key();
}
