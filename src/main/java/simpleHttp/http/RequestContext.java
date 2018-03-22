package simpleHttp.http;

import java.util.Date;

/**
 * Created by Wang Juqiang on 2018/3/17.
 */
public class RequestContext {
    private Date time;
    private long timeTaken;
    private String url;
    private Exception exception;
    private RequestSettings requestSettings;

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public RequestSettings getRequestSettings() {
        return requestSettings;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Date getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public Exception getException() {
        return exception;
    }

    public RequestContext(RequestSettings requestSettings) {
        this.requestSettings = requestSettings;
        time = new Date();
    }


}
