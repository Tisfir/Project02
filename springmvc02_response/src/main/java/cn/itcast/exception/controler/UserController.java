package cn.itcast.exception.controler;

import cn.itcast.exception.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author L.N
 * @create 2021-01-04-16:59
 */@Controller
@RequestMapping("/user")
public class UserController {

     @RequestMapping("/testString")
    public String testString(Model model){
         System.out.println("testString方法执行了……");
         //模拟从数据库中查询出一个用户的对象，转发到页面上，就相当于把值取出来
         User user=new User();
         user.setUsername("美美");
         user.setPassword("123");
         user.setAge(30);
         //model对象把数据存起来
         model.addAttribute("user",user);//第二个user是真正的User下你创建的对象
         return "success";
     }

/*返回是void
* 请求转发与重定向有区别，请求转发一次请求，不行编写项目的名称
* 重定向是两次请求
* */
     @RequestMapping("/Void")
     public void testVoid(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
         System.out.println("testvoid方法执行了……");  //当没有写返回值时，默认会去请求请求路径名称的jsp页面如void.jsp

         //编写请求转发的程序
         //httpServletRequest.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(httpServletRequest,httpServletResponse);

         //重定向
         //httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/index.jsp");

         //设置中文乱码
         httpServletResponse.setCharacterEncoding("UTF-8");
         httpServletResponse.setContentType("text/html;charset=UTF-8");
         //直接会进行响应
         httpServletResponse.getWriter().print("你好");
         return;

     }

    /*
    * 使用关键字的方式进行转发或者重定向
    * */
     @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了……");
        //请求的转发q

        //return "forward:/WEB-INF/pages/success.jsp";
         //重定向
         return "redirect:/index.jsp";  //重定向请求不到WEB-INF……下的路径，只能到根目录下面

    }


    /*
     * 模拟异步请求与响应的过程
     * */
    @RequestMapping("/testAjax")
    public @ResponseBody
    User testAjax(@RequestBody User user){
        //只需要返回user对象，就可以将数据封装到他当中,但是这是json对象，需要字符串，这个时候，加一个@responseBody的注解在User前面
        System.out.println("testAjax方法执行了……");
        //客户端发送的ajax请求，传的是json的字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //作响应，模拟假装查询了数据库
        user.setUsername("haha");
        user.setPassword("123");
        user.setAge(40);
        return user;


    }

 }
