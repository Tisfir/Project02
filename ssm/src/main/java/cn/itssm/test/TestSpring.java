package cn.itssm.test;

import cn.itssm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author L.N
 * @create 2021-01-08-16:10
 */
public class TestSpring {

    @Test
    public void run1(){

        //加载文件
        ApplicationContext ac= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        //获取对象
        AccountService as = (AccountService) ac.getBean("accountService");//那个注解的名字

        //调用方法
        as.findAll();


    }
}
