package simpleHttp.annotations;

import java.lang.annotation.*;

/**
 * Created by Wang Juqiang on 2018/3/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Host {
    /**
     * Url请求的Host
     *
     * @return
     */
    String name();

    String protocol() default "http";

    String hostConfigureKey() default "";
}
