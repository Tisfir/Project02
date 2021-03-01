package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author L.N
 * @create 2021-01-07-17:14
 * 自定义拦截器
 */
public class Myinterceptor implements HandlerInterceptor {//没有报错，说明这里边他的方法都帮你实现过了。
    //如果你想用新的，可以重写

    /*
    *预处理，controller方法执行前就走它
    * return true 放行，执行下一个拦截器。如果没有，就执行controller中的方法
    * return false不放行，直接跳转到某某页面，作一些提示信息等等，例如你没权限。
    * */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Myinterceptor执行前……");
        return true;  //如果是false就不会放行，可以让他跳转到某个页面。


        /*request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return false;*/
    }

    /*
    * controller执行完往回跳的时候，controller方法执行后，success.jsp执行前
    * */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Myinterceptor执行后……");
        //也可以指定跳出页面，将上面的request语句放在这里。

    }

    /*
    *success.jsp页面执行之后，该方法会执行。
    *
    * */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("success.jsp执行后……");

    }
}
