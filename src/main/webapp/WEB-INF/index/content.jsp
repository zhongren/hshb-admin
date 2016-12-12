<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>无标题文档</title>
    <link href="${ctx}/staticAdmin/css/css.css" type="text/css" rel="stylesheet">
    <script src="${ctx}/staticAdmin/js/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/staticAdmin/js/js.js" type="text/javascript"></script>
</head>

<body>


<!--head-->
<div class="header">
    <div class="container">
        <a class="logo"><img src="${ctx}/staticAdmin/img/logo.png"></a>
        <ul class="nav">
            <li><a href="index">首页</a></li>
            <li class="on"><a href="newslist?page=1&typeId=5">关于和顺</a></li>
            <li><a href="newslist?page=1&typeId=2">信息公示</a></li>
            <li><a href="newslist?page=1&typeId=1">新闻中心</a></li>
            <li><a href="3">人才招聘</a></li>
        </ul>
        <div class="nav_mobile">
            <img src="${ctx}/staticAdmin/img/list1.png">
        </div>
    </div>

</div>
<!--/head-->

<!--container-->
<div class="container">
    <div class="con_left">
        <div class="fast_links">
            <div class="head">关于和顺</div>
            <ul>
                <li><a href="#">快速通道1</a></li>
                <li><a href="#">快速通道2</a></li>
                <li><a href="#">快速通道3</a></li>
                <li><a href="#">快速通道4</a></li>
            </ul>
        </div>
    </div><!--/con_left-->
    <div class="con_right">
        <div class="head"><c:out value="${news.name}" /></div>
        <div class="title"><c:out value="${news.name}" /> </div>
        <div class="content">
            <c:out value="${news.content}" />
        </div>
    </div><!--/con_right-->
</div>
<!--/container-->

<!--footer-->
<div id="footer">
    <p>江苏和顺环保有限公司</p>

    <p>版权所有<br>苏ICP备13018519号-2</p>

    <p>外部链接：<a href="#">江苏环保厅</a> <a href="#">苏州环保局</a> <a href="#">园区环保局</a> <a href="#">兆润控股</a> <a href="#">中新公用</a>
    </p>
</div>
<!--/footer-->

</body>
</html>
