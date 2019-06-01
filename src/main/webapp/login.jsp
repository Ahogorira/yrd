<%--
  Created by IntelliJ IDEA.
  User: 16477
  Date: 2019/5/30
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="script/jquery-1.7.1.min.js"></script>
<script>
    function aa(time) {
        $.ajax({
            url:"/timeTest",
            type:'post',
            data:{'cron':time},
            success:function () {
                alert('ok');
            },
            error:function () {
                alert('error');
            }
        });
    }
</script>
<body>
<form action="/login">
    <input type="text" name="uname"/><br>
    <input type="password" name="upwd"/><br>
    <input type="submit" value="登陆"/>
</form><br>
<button  onclick="aa('1/5 * * * * ?')">time1</button>
<button  onclick="aa('1/10 * * * * ?')">time2</button>
</body>
</html>
