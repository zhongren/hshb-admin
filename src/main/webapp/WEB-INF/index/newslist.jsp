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
    <title>无标题文档</title>
    <link href="${ctx}/staticAdmin/css/css.css" type="text/css" rel="stylesheet">
    <script src="${ctx}/staticAdmin/js/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/staticAdmin/js/js.js" type="text/javascript"></script>
</head>

<body>


<!--head-->
<div class="header">
    <div class="container">
        <div class="logo"><img src="${ctx}/staticAdmin/img/logo.png"></div>
        <ul class="nav">
            <li><a href="#">首页</a></li>
            <li class="on"><a href="#">关于和顺</a></li>
            <li><a href="#">信息公示</a></li>
            <li><a href="#">新闻中心</a></li>
            <li><a href="#">人才招聘</a></li>
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
            <c:forEach var="news" items="${indexNewsList}">
                <li><a href=content?id=<c:out value="${news.id}"/>><span class="date"><c:out
                        value="${news.displayUpdateTime}"/></span>

                    <p><c:out value="${news.name}"/></p></a></li>
            </c:forEach>
        </ul>
        <div class="pages">
            <%int crtPage = Integer.parseInt((String) (request.getParameter("page")));%>
            <a href="newslist?page=<%=crtPage-1%>"><
                <上一页
            </a>
            <%for (int i = crtPage - 2 > 0 ? crtPage - 2 : 1; i <= (crtPage + 2 > 5 ? crtPage + 2 : 5); i++) {%>
            <a href="newslist?page=<%=i%>" <%=i == crtPage ? "id=\"current_page\"" : ""%>><%=i%>
            </a>
            <%}%>
            <a href="newslist?page=<%=crtPage+1%>">下一页>></a>
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
