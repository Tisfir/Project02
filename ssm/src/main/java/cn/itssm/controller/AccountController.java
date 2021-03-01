package cn.itssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author L.N
 * @create 2021-01-07-20:12
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("findAll方法没问题，执行了，springmvc 环境成功");
        return "list";
    }
}
