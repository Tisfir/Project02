package cn.itcast.exception.controller;

import cn.itcast.exception.domain.Account;
import cn.itcast.exception.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author L.N
 * @create 2021-01-03-15:30
 */
/*请求参数的绑定*/
@Controller
@RequestMapping("/param")
/*
 *请求参数绑定的入门
 * */
public class ParamController {

    @RequestMapping("/testParam")
/*
    //当客户端出现初始jsp时，后台并不会执行，当路径被调用时，方法就会执行，当参数少的时候，就只用这样就可以，
    当参数比较多时，就需要一个javabean对象，此时我们重新创建一个类
*/
    public String testParam(String username,String password){
        System.out.println("执行成功");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);

        return "success";

    }
    /*
     * 请求参数绑定把数据封装到Javabean的类中，在Account.java中
     * */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        /*直接在（）中写Account。java的名字即可这个表示把所有都封装到Account类的account对象下
        *
        *
        * */
        System.out.println("执行成功");
        System.out.println(account);  //b不能加双引号，要不他就会被当成一般的解析之后的字符处理
        return "success";

    }

    /*
    * 自定义类型转换器
    * */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("执行成功");
        System.out.println(user);
        return "success";
    }
    /*
    *测试servlet原生API
    * */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){ //想获得谁，就在方法上面加参数。
        System.out.println("执行成功");
        System.out.println(request); //打印request的地址。

        HttpSession session=request.getSession();
        System.out.println(session);  //session对象用于存储用户会话所需要的信息。

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);  //最大域对象

        System.out.println(response);
        return "success";
    }


}
