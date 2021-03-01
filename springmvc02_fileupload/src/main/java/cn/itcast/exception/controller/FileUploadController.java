package cn.itcast.exception.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author L.N
 * @create 2021-01-06-16:19
 */
@Controller
@RequestMapping("/user")
public class FileUploadController {
    /*
     * spring跨服务器文件上传
     * */
    @RequestMapping("/fileupload3")
    public String fileupload3( MultipartFile upload) throws Exception {
        //upload名字必须要与表单上的名字一样
        System.out.println("跨服器文件上传……");
        //不用之前的内容了，不用自己的文件，要跨服务器传，自然也不用requ对象了

        //定义跨服务器文件上传路径
        String path="http://localhost:9090/uploads/";

        //说明上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();

        //把文件名称设置为唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", " ");
        filename=uuid+"_"+filename;

        //完成文件上传

        //创建客户端对象
        Client client = Client.create();
        System.out.println("222");

        // 图片服务器进行连接
        WebResource webResource=client.resource(path + filename);
//        WebResource webResource = client.resource(path + "/" + filename);   //这里不成功，不行,连不上服务器

        System.out.println("333");

        //上面uploads后面有了/,这里就直接加filename
        System.out.println("444");


        //上传文件
        webResource.put(upload.getBytes());
        return "success";
    }





    /*
    * 文件上传
    * */
@RequestMapping("/fileupload1")
    public String fileupload(HttpServletRequest httpServletRequest) throws Exception {
    System.out.println("文件上传……");
//使用fileupload这个组件实现文件上传
    //上传的位置
    String path = httpServletRequest.getSession().getServletContext().getRealPath("/uploads/");//某某路径的绝对路径指的是，上川岛的根目录，
//以后就传达到/uploads 这个文件夹下
    //判断该路径是否存在
    File file =new File(path);
    if (!file.exists()){
        //  创建改文件夹
        file.mkdirs();
    }
    //解析request的对象，获取上传文件项
    DiskFileItemFactory fileItemFactory =new DiskFileItemFactory();  //磁盘文件想工厂
    ServletFileUpload upload =new ServletFileUpload(fileItemFactory);
    //开始解析request对象
    List<FileItem> items = upload.parseRequest(httpServletRequest);//返回的是一个list集合  里边装的全部是文件项
    //遍历
    for (FileItem item:items){
        //拿到每一个item进行判断，当前item是否是上传文件项
        if (item.isFormField()){
            //说明是普通表单项
        }else {
            //说明上传文件项//
            //获取上传文件名称
            String filename = item.getName();
            //把文件名称设置为唯一值，uuid
            String uuid = UUID.randomUUID().toString().replace("-", " ");
            filename=uuid+"_"+filename;
            //完成文件上传
            item.write(new File(path,filename));
            //删除临时文件 大于10kb就有临时文件
            item.delete();
        }
    }

    return "success";
    }




    /*
     * spring文件上传
     * */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest httpServletRequest, MultipartFile upload) throws Exception {
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
        //说明上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();

        //把文件名称设置为唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", " ");
        filename=uuid+"_"+filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));


        return "success";
    }




}
