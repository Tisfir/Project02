package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author L.N
 * @create 2021-01-07-16:15
 */
@Controller
@RequestMapping("/exception")
public class exceptionController {
    @RequestMapping("/textInterceptor")
    public String textInterceptor(){
        System.out.println("textInterceptor执行了");

        return "success";
    }
}
