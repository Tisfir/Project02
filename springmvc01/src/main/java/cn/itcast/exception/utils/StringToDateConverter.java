package cn.itcast.exception.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author L.N
 * @create 2021-01-03-18:57
 */
/*
* 把字符串转换成日期
* */

//自定义类型转换器，实现converter接口，接口中指定的泛型即为最终作用的条件
//本列中的泛型填写的是String，Date，最终出现字符串转日期时，该类型转换器生效
public class StringToDateConverter implements Converter<String,Date>{
    //重写接口的抽象方法，参数由泛型决定
    public Date convert(String source){

       /* SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        //类型转换器无法预计使用过程中出现的异常，因此必须在类型转换器内部捕获，不允许抛出，框架无法预计此类异常如何处理
        try{
            date = df.parse(source);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date;*/
       if (source ==null){
           throw new RuntimeException("请您传入数据");
       }
        DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
        try {
            return df.parse(source);
        } catch (Exception e) {
           throw new RuntimeException("您输入的数据有误");
        }

    }
}
