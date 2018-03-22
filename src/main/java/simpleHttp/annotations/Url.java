package simpleHttp.annotations;

import simpleHttp.http.HttpMethod;

import java.lang.annotation.*;

/**
 * Created by Wang Juqiang on 2018/3/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Url {
    String path();

    int timeout() default 2000;

    String charset() default "utf-8";

    String contentType() default "application/json";

    HttpMethod method() default HttpMethod.GET;

    boolean continueOnExceptions() default false;

    boolean downgrade() default false;

    boolean cacheAble() default false;

    /**
     * 默认值为1，如果设置为0，表示一直重试直到成功
     *
     * @return
     */
    int retryTimes() default 1;
}
