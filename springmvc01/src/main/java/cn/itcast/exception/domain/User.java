package cn.itcast.exception.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author L.N
 * @create 2021-01-03-16:43
 */
public class User implements Serializable {
    private String uname;
    private Integer age;
    private Date date;  //用于自定义

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
