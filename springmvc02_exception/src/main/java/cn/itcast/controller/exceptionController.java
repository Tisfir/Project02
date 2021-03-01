package cn.itcast.controller;

import cn.itcast.exception.Sysexception;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author L.N
 * @create 2021-01-07-16:15
 */
@Controller
@RequestMapping("/exception")
public class exceptionController {
    @RequestMapping("/textException")
    public String testException() throws Sysexception{
        System.out.println("textException执行了");
        //模拟异常,有了异常，要想执行要捕获异常，用try catch语句,捕获完扔出自己的异常
        try {
            int a=10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义的异常信息
            throw new Sysexception("查询所有用户出现错误……");
        }
        //
        return "success";
    }
}
