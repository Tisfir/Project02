<%--
  Created by IntelliJ IDEA.
  User: liz
  Date: 2021/1/4
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注解的使用</title>
</head>
<body>
<%--常用注解--%>
<%--<a href="/anno/testRequestParam?username=haha">RequestParam</a>--%>
<%--用于第一个的获取--%>
<a href="/anno/testRequestParam?name=haha">RequestParam</a>
<%--如果这里换成name那么前面用@request……的方式--%>

<%--这里的值与前面方法里面string的值必须要一致，username=username，然后后台获取到你这里赋予的haha的值，否则获取不到--%>


<br/>
    <form action="/anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="uname"/><br/>
        用户年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交"/>
    </form>
<a href="/anno/testPathVariable/10">testPathVariable</a>
<a href="/anno/testRequestHeader">testRequestHeader</a>
<a href="/anno/testCookieValue">testCookieValue</a>
<br/>
<form action="/anno/testModelAttribute" method="post">
    用户姓名：<input type="text" name="uname"/><br/>
    用户年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>
    <%--此时表单中有一个date没有提交为null--%>
</form>
<a href="/anno/testSessionAttributes">testSessionAttributes</a>
<a href="/anno/getSessionAttributes">getSessionAttributes</a>
<a href="/anno/delSessionAttributes">delSessionAttributes</a>

</body>
</html>
