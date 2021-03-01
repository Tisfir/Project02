package cn.itcast.exception.domain;

import java.io.Serializable;

/**
 * @author L.N
 * @create 2021-01-03-15:51
 */
/*
*当需要多个参数对象时，要实现一个序列化的接口。,然后创造参数，实现方法。
*
* */
public class Account implements Serializable {
    private String username;
    private String password;
    private Double money;
    private User user; //这叫Account中包含一个引用类型，引用了其他的类User

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }     //对引用的类型生成getset方法

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
