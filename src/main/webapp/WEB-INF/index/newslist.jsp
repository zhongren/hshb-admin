<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<title>无标题文档</title>
    <link src="${ctx}/staticAdmin/css/css.css" type="text/css" rel="stylesheet">
    <script src="${ctx}/staticAdmin/js/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/staticAdmin/js/js.js" type="text/javascript"></script>
</head>

<body>


<!--head-->
<div class="header">
	<div class="container">
        <div class="logo"><img src="images/logo.png"></div>
        <ul class="nav">
            <li><a href="#">首页</a></li>
            <li class="on"><a href="#">关于和顺</a></li>
            <li><a href="#">信息公示</a></li>
            <li><a href="#">新闻中心</a></li>
            <li><a href="#">人才招聘</a></li>
        </ul>
        <div class="nav_mobile">
            <img src="images/list1.png">        
        </div>
    </div>
	
</div>
<!--/head-->

<!--container-->
<div class="container">
	<div class="con_left">        
        <div class="fast_links">
            <div class="head">新闻中心</div>
            <ul>
                <li><a href="#">中新公用</a></li>
                <li><a href="#">兆润控股</a></li>
                <li><a href="#">和顺环保</a></li>
            </ul>
        </div>    	
    </div><!--/con_left-->
    <div class="con_right">
    	<div class="head">新闻中心-中新公用</div>
        <ul class="news_list">
        	<li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>
            <li><a><span class="date">2012-12-12</span><p>新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题</p></a></li>

        </ul>
        <div class="pages">
        	<a><<上一页</a>
            <a>1</a>
            <a>2</a>
            <a>3</a>
            <a>4</a>
            <a>下一页>></a>
        </div>
    </div><!--/con_right-->
</div>
<!--/container-->

<!--footer-->
<div id="footer">
	<p>江苏和顺环保有限公司</p>
    <p>版权所有<br>苏ICP备13018519号-2</p>
    <p>外部链接：<a href="#">江苏环保厅</a>  <a href="#">苏州环保局</a>  <a href="#">园区环保局</a>  <a href="#">兆润控股</a>  <a href="#">中新公用</a></p>
</div>
<!--/footer-->

</body>
</html>
