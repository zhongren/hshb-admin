<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>首页</title>
    <link href="${ctx}/staticAdmin/css/css.css" type="text/css" rel="stylesheet">


    <!--Required libraries-->
    <script src="${ctx}/staticAdmin/js/jquery.js" type="text/javascript"></script>
    <!--Include flickerplate-->
    <link href="${ctx}/staticAdmin/css/flickerplate.css" type="text/css" rel="stylesheet">

    <script src="${ctx}/staticAdmin/js/flickerplate.min.js" type="text/javascript"></script>
    <!--Execute flickerplate-->
    <script src="${ctx}/staticAdmin/js/js.js" type="text/javascript"></script>
    <script>
        $(document).ready(function () {
            $('.flicker-example').flicker();
        });
    </script>


</head>

<body style="background:none;">


<!--head-->
<div class="header_index">
    <div class="logo"><img src="${ctx}/staticAdmin/img/logo.png"></div>
    <ul class="nav">
        <li><a href="/">首页</a></li>
        <li><a href="newslist?page=1&typeId=4">关于和顺</a></li>
        <li><a href="newslist?page=1&typeId=2">信息公示</a></li>
        <li><a href="newslist?page=1&typeId=1">新闻中心</a></li>
        <li><a href="newslist?page=1&typeId=3">人才招聘</a></li>
    </ul>
    <div class="tel"><p>服务热线</p><span><img src="${ctx}/staticAdmin/img/400.png"></span></div>
    <div class="nav_mobile">
        <img src="${ctx}/staticAdmin/img/list1.png">
    </div>
</div>
<!--/head-->

<!--banner-->
<div class="flicker-example" data-block-text="false">
    <a>
        <c:forEach var="recommend" items="${indexRecommendList}">
            <a href="content?id=<c:out value="${recommend.id}" />"></a> <li data-background="<c:out value="${recommend.picBig}" />"></li></a>
        </c:forEach>
    </ul>
</div>
<!--/banner-->

<!--container-->
<div class="container">
    <div class="container_left">
        <div class="head">
            <div class="name">新闻中心</div>
            <a href="newslist?page=1&typeId=1" class="more">更多</a>
        </div>
        <ul class="news_list">
            <c:forEach var="news" items="${indexNewsList}">
                <li>
                    <div class="date"><c:out value="${news.displayUpdateTime}"/></div>
                    <a href="content?id=<c:out value="${news.id}" />"><c:out value="${news.name}"/></a></li>
            </c:forEach>
        </ul>
    </div><!--/left-->
    <div class="container_right">
        <div class="head">
            <div class="name">信息公示</div>
            <a href="newslist?page=1&typeId=2" class="more">更多</a>
        </div>
        <ul class="news_list">
            <c:forEach var="info" items="${indexInfosList}">
                <li>
                    <div class="date"><c:out value="${info.displayUpdateTime}"/></div>
                    <a href="content?id=<c:out value="${info.id}" /> "><c:out value="${info.name}"/></a></li>
            </c:forEach>
        </ul>
    </div><!--/right-->
    <div class="container_bottom">
        <div class="head">
            <div class="name">服务项目</div>
        </div>
        <ul class="service_list">
            <c:forEach var="service" items="${indexServicesList}">
                <li><a href="content?id=<c:out value="${service.id}" />"><img src="<c:out value="${service.picSmall}" />">
                    <div class="txt"><h3><c:out value="${service.name}" /></h3></div>
                </a></li>
            </c:forEach>
        </ul>
    </div>
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

<script>
    $(".service_list li").hover(function () {
        $(this).find(".txt").stop().animate({height: "40px"}, 400);
    }, function () {
        $(this).find(".txt").stop().animate({height: "0"}, 400);
    })
</script>


</body>
</html>
