package test.models;

/**
 * Created by Wang Juqiang on 2018/3/18.
 */
public class Protocol<T> {
    private String message;
    private int returnCode;
    private T result;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public T getResult() {
        return result;
    }
}
