<%--
  Created by IntelliJ IDEA.
  User: HQ
  Date: 2017/1/12
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../common/css.jsp"></jsp:include>
    <jsp:include page="../common/js.jsp"></jsp:include>
    <style type="text/css">
        .table{max-width: 100%;max-height: 100%;min-width: 800px;min-height:600px; }
        .table .left{border-left: 1px solid #ddd;border-right: 1px solid #ddd;}
        .table .right{border-right: 1px solid #ddd;}
        .table .last{border-bottom: 1px solid #ddd;}
    </style>
</head>
<body style="background: none;">
<center>
<div id="table">
<table class="table">
    <tr><td class="left">头像</td><td class="right">111</td></tr>
    <tr><td class="left">ID</td><td class="right">222</td></tr>
    <tr><td class="left">编号</td><td class="right">333</td></tr>
    <tr><td class="left">姓名</td><td class="right"></td></tr>
    <tr><td class="left">性别</td><td class="right"></td></tr>
    <tr><td class="left">部门</td><td class="right"></td></tr>
    <tr><td class="left">职位</td><td class="right"></td></tr>
    <tr><td class="left">手机号</td><td class="right"></td></tr>
    <tr><td class="last left">备注</td><td class="last right"></td></tr>
</table>
</div>
</center>
</body>
</html>
