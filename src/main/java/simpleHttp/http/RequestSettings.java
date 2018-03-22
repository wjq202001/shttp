package simpleHttp.http;

/**
 * Created by Wang Juqiang on 2018/3/17.
 */
public class RequestSettings {
    private String accept;
    private String charset;
    private String userAgent;
    private int timeOut;
    private String url;
    private HttpMethod method;
    private String contentType;
    private boolean continueOnExceptions;
    private boolean downgrade;

    public void setContinueOnExceptions(boolean continueOnExceptions) {
        this.continueOnExceptions = continueOnExceptions;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public void setDowngrade(boolean downgrade) {
        this.downgrade = downgrade;
    }

    public boolean isContinueOnExceptions() {
        return continueOnExceptions;
    }

    public boolean isDowngrade() {
        return downgrade;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCharset() {
        return charset;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public String getUrl() {
        return url;
    }
}
