<%--
  Created by IntelliJ IDEA.
  User: liz
  Date: 2021/1/4
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定一个单击事件
        $(function () {
            $("#btn").click(function () {
                //alert("hello,btn");
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":30}', //标准的json数据
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器响应的json数据，进行解析，表能拿到这个数据
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            });
        })
    </script>
</head>
<body>
<a href="/user/testString">testString</a>
<a href="/user/testString">testString</a>
<br/>
<a href="/user/Void">testVoid</a>
<br/>
<a href="/user/testForwardOrRedirect">testForwardOrRedirect</a>
<br/>
<%--模拟一个button按钮--%>
<button id="btn">f发送ajax请求</button>
</body>
</html>
