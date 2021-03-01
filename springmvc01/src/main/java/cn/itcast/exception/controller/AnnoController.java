package cn.itcast.exception.controller;

import cn.itcast.exception.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

/**
 * @author L.N
 * @create 2021-01-04-13:52
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})  //把msg=美美存储到session与对象当中  这个注解的作用
//requestParam的注解使用
public class AnnoController {
    @RequestMapping(path = "/testRequestParam")
//    public String testRequestParam(String username){   这样在获取值
    public String testRequestParam(@RequestParam(name = "name") String username){  //适用于获取某一个具体的值，并不是请求体
        //和后面用name值得那个一致，将name的值赋给username
        System.out.println("执行中……");
        System.out.println(username);
        return "success";
    }


// 获取到请求体的内容RequestBody
@RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody String body){   //想拿整个请求体的内容
        //和后面用name值得那个一致，将name的值赋给username
        System.out.println("执行中……");
        System.out.println(body);
        return "success";
    }


    // Pathvariable的注解
    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){   //想拿整个请求体的内容
        System.out.println("执行中……");
        System.out.println(id);
        return "success";
    }

    // 获取请求头部信息
    @RequestMapping(path = "/testRequestHeader")
    public String testRequestHeade(@RequestHeader(value = "Accept") String header){   //获取请求头部信息
        System.out.println("执行中……");
        System.out.println(header);
        return "success";
    }


    // 获取请求Cookie的值
    @RequestMapping(path = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){   //获取请求头部信息
        System.out.println("执行中……");
        System.out.println(cookieValue);
        return "success";
    }


    // testModelAttribute的注解
    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute(User user){   //获取请求头部信息
        System.out.println("testModelAttribute执行中……");
        System.out.println(user);
        return "success";
    }
    //该方法会先执行，
    @ModelAttribute
    public User  showUser(String uname){    //如果这里是void就是没有返回值，User一定有返回值
        System.out.println("showUser的方法执行中……");
        //通过用户名查询数据库（模拟）
        User user=new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;

    }

/*testModelAttributes的注解,/*
    model类用于解决耦合度高的问题，
*/

    @RequestMapping(path = "/testSessionAttributes")
    public String testSessionAttributes(Model model){   //获取请求头部信息
        System.out.println("testSessionAttributes执行中……");
        //把这一组键值对底层会存储到request域对象中
        model.addAttribute("msg","美美");
        return "success";
    }
    /*获取值  modelmap 的获取*/
    @RequestMapping(path = "/getSessionAttributes")
    public String testSessionAttributes(ModelMap modelMap){   //获取请求头部信息
        System.out.println("getSessionAttributes执行中……");
        //把这一组键值对底层会存储到request域对象中
        String msg= (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }


    /*清除  modelmap 的获取*/
    @RequestMapping(path = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus sessionStatus){   //获取请求头部信息
        System.out.println("delSessionAttributes执行中……");
        sessionStatus.setComplete();//会清除掉这个
        return "success";
    }
}
