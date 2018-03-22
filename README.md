# shttp
This project is designed to simplify the development of api calls for java. 

You can according the following 2 steps to use this tool:
#Step 1: Define an api interface

@Host(name = "****.api.autohome.com")
public interface DomainApi {
    @Url(path = "/profile/getinfo")
    Info getInfo(@Para(paraName = "id") int id);

    @Url(path = "/profile/getlist")
    Protocol getList(@Para(paraName = "type") int ordertype,
                     @Para(paraName = "orderby") int orderby);
}

#Setp 2: Create an interface proxy and launch a request.

    public void test() {
        DomainApi api = ApiProxyFactory.createInstance(DomainApi.class);
        Info info = api.getInfo(1);
    }

For more featrues, to see the documentation.
