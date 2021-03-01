package cn.itcast.exception;

/**
 * @author L.N
 * @create 2021-01-07-16:07
 * 自定义的异常类
 */
public class Sysexception extends Exception {
    //存储提示信息
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Sysexception(String message) {
        this.message = message;
    }
}
