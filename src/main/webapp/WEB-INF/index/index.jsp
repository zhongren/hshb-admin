<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes"><title>无标题文档</title>
<link href="${ctx}/staticAdmin/css/css.css" type="text/css" rel="stylesheet">


<!--Required libraries-->
    <script src="${ctx}/staticAdmin/js/jquery.js" type="text/javascript"></script>
<!--Include flickerplate-->
    <link href="${ctx}/staticAdmin/css/flickerplate.css"  type="text/css" rel="stylesheet">

    <script src="${ctx}/staticAdmin/js/flickerplate.min.js" type="text/javascript"></script>
<!--Execute flickerplate-->
    <script src="${ctx}/staticAdmin/js/js.js" type="text/javascript"></script>
<script>
	$(document).ready(function(){		
		$('.flicker-example').flicker();
	});
</script>



</head>

<body style="background:none;">


<!--head-->
<div class="header_index">
	<div class="logo"><img src="${ctx}/staticAdmin/img/logo.png"></div>
    <ul class="nav">
    	<li><a href="#">首页</a></li>
    	<li><a href="#">关于和顺</a></li>
        <li><a href="#">信息公示</a></li>
        <li><a href="#">新闻中心</a></li>
        <li><a href="#">人才招聘</a></li>
    </ul>
    <div class="tel"><p>服务热线</p><span><img src="${ctx}/staticAdmin/img/400.png"></span></div>
    <div class="nav_mobile">
    	<img src="${ctx}/staticAdmin/img/list1.png">
    </div>
</div>
<!--/head-->

<!--banner-->
<div class="flicker-example" data-block-text="false">
  <ul>
    <li data-background="${ctx}/staticAdmin/img/banner_3.png"></li>
    <li data-background="${ctx}/staticAdmin/img/banner_3.png"></li>
    <li data-background="${ctx}/staticAdmin/img/banner_3.png"></li>
    <li data-background="${ctx}/staticAdmin/img/banner_5.png"></li>
    <li data-background="${ctx}/staticAdmin/img/banner_5.png"></li>
  </ul>
</div>
<!--/banner-->

<!--container-->
<div class="container">
	<div class="container_left">
    	<div class="head">
        	<div class="name">新闻中心</div>
            <a class="more">更多</a>
        </div>
        <ul class="news_list">
        	<li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
            <li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
            <li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
            <li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
            <li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
        </ul>
    </div><!--/left-->
    <div class="container_right">
    	<div class="head">
        	<div class="name">信息公示</div>
            <a class="more">更多</a>
        </div>
        <ul class="news_list">
        	<li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
            <li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
            <li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
            <li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
            <li><div class="date">2015-12-12</div><a href="#">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</a></li>
        </ul>
    </div><!--/right-->
    <div class="container_bottom">
    	<div class="head"><div class="name">服务项目</div></div>
        <ul class="service_list">
        	<li><a href="#"><img src="${ctx}/staticAdmin/img/service_1.png"><div class="txt"><h3>固废处理</h3></div></a></li>
            <li><a href="#"><img src="${ctx}/staticAdmin/img/service_2.png"><div class="txt"><h3>废液处理</h3></div></a></li>
            <li><a href="#"><img src="${ctx}/staticAdmin/img/service_3.png"><div class="txt"><h3>线路板处理</h3></div></a></li>
            <li><a href="#"><img src="${ctx}/staticAdmin/img/service_4.png"><div class="txt"><h3>覆铜板处理</h3></div></a></li>
        </ul>
    </div>
</div>
<!--/container-->

<!--footer-->
<div id="footer">
	<p>江苏和顺环保有限公司</p>
    <p>版权所有<br>苏ICP备13018519号-2</p>
    <p>外部链接：<a href="#">江苏环保厅</a>  <a href="#">苏州环保局</a>  <a href="#">园区环保局</a>  <a href="#">兆润控股</a>  <a href="#">中新公用</a></p>
</div>
<!--/footer-->

<script>
$(".service_list li").hover(function(){
	$(this).find(".txt").stop().animate({height:"40px"},400);
},function(){
	$(this).find(".txt").stop().animate({height:"0"},400);
})
</script>



</body>
</html>
