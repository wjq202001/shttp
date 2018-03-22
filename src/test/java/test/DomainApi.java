package test;

import simpleHttp.annotations.Host;
import simpleHttp.annotations.Para;
import simpleHttp.annotations.Url;
import test.models.Info;
import test.models.Protocol;

/**
 * Created by Wang Juqiang on 2018/1/9.
 */
@Host(name = "****.api.autohome.com")
public interface DomainApi {
    @Url(path = "/profile/getinfo")
    Info getInfo(@Para(paraName = "id") int id);

    @Url(path = "/profile/getlist")
    Protocol getList(@Para(paraName = "type") int ordertype,
                     @Para(paraName = "orderby") int orderby);
}
