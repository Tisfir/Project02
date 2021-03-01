package cn.itcast.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author L.N
 * @create 2020-12-31-17:48
 */
@Controller
/*@RequestMappin(path="/test")g如果把它放在累之前，那么在写注解之前，就要加上这里的路径，然后再加上下
面的详细注解路径。例如test/testRequestmapping*/
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello StringMVC");
//        return null;
        return "success";  //返回一个success值  他就会找视图解析器下面的神魔文件，在spring配置文件中
    }
    @RequestMapping(path = "/testRequestmapping")
    /*@RequestMapping(path = "/testRequestmapping",params = {"username=heihei"}这里定义了属性，则在jsp中，必须要书写属性,若写了值，那么值也必须要一致若)  */  //每次应用新的方法时都要写一个新的注解path换成value也可以是一样的
    public String testRequestmapping(){
        System.out.println("测试requestmapping");
        return "success";
    }
}
