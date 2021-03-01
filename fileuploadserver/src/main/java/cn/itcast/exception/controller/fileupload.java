package cn.itcast.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author L.N
 * @create 2021-01-07-15:09
 */
@Controller
public class fileupload {
    @RequestMapping("file")
    public String file(HttpServletRequest httpServletRequest){
        //upload名字必须要与表单上的名字一样
        System.out.println("springMVC文件上传……");
//使用fileupload这个组件实现文件上传
        //上传的位置
        String path = httpServletRequest.getSession().getServletContext().getRealPath("/uploads/");
        //某某路径的绝对路径指的是，上川岛的根目录，
//以后就传达到/uploads 这个文件夹下
        //判断该路径是否存在
        File file =new File(path);
        if (!file.exists()){
            //  创建改文件夹
            file.mkdirs();
        }
        /* 说明上传文件项 */
        return "success";
        }
    }

