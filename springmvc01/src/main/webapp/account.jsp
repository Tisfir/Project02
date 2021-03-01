<%--
  Created by IntelliJ IDEA.
  User: liz
  Date: 2021/1/3
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%--当--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多参数时，getset下的参数获取</title>
</head>
<body>
<%--action中加的是请求路径--%>
<%--  <form action="/param/saveAccount" method="post">
    姓名：<input type="text" name="username"/><br/>
    &lt;%&ndash;里边的name与类当中封装的属性名要保持一致&ndash;%&gt;
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    用户姓名：<input type="text" name="user.uname"/><br/>
    用户年龄：<input type="text" name="user.age"/><br/>
&lt;%&ndash;当用的路径内类中引用了别的类属性，此时的应当如何写:引用对象.变量名如uname  age，然后就可以被封装进去&ndash;%&gt;
    <input type="submit" value="提交"/>  --%>


<%--<form action="/param/saveUser" method="post">
    用户姓名：<input type="text" name="uname"/><br/>
    用户年龄：<input type="text" name="age"/><br/>
    用户生日：<input type="text" name="date"/><br/>
    <input type="submit" value="提交"/>
</form>--%>
<%--用于封装Javabean及乱码解决等等及日期类型转换器等等--%>
<a href="/param/testServlet">测试servlet原生API</a>
</body>
</html>
