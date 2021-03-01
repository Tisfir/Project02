package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author L.N
 * @create 2021-01-07-16:36
 */
//异常处理器兑现
public class SysExceptionResolver implements HandlerExceptionResolver {
/*
*当controller振奋有异常，他会调出处理器。处理异常业务逻辑。
* */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //准备获取到异常对象
        Sysexception ex=null;
        if (e instanceof Sysexception){
            ex=(Sysexception)e;
        }else {
            e=new Sysexception("系统正在维护");
        }
        //创建ModelAndView对象
        ModelAndView mv =new ModelAndView();
        mv.addObject("errorMessage",ex.getMessage());
        mv.setViewName("error");  //调到error.jsp页面
        return mv;
    }
}
