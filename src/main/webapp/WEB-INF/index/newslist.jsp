<%@ page import="com.lebao.common.dbhelp.page.Page" %>
<%@ page import="com.lebao.vo.NewsVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${newsTypeVo.name}"/></title>
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
            <li><a href="/">首页</a></li>
            <li class="on"><a href="newslist?page=1&typeId=4">关于和顺</a></li>
            <li><a href="newslist?page=1&typeId=2">信息公示</a></li>
            <li><a href="newslist?page=1&typeId=1">新闻中心</a></li>
            <li><a href="newslist?page=1&typeId=3">人才招聘</a></li>
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
                <li><a href="newslist?page=1&typeId=8">中新公用</a></li>
                <li><a href="newslist?page=1&typeId=9">兆润控股</a></li>
                <li><a href="newslist?page=1&typeId=10">和顺环保</a></li>
            </ul>
        </div>
    </div><!--/con_left-->
    <div class="con_right">
        <div class="head"><c:out value="${newsTypeVo.name}"/></div>
        <ul class="news_list">
            <c:forEach var="news" items="${page.data}">
                <li><a href=content?id=<c:out value="${news.id}"/>><span class="date"><c:out
                        value="${news.displayUpdateTime}"/></span>

                    <p><c:out value="${news.name}"/></p></a></li>
            </c:forEach>
        </ul>
        <div class="pages">
            <%
                Page<NewsVo> pageObj = ((Page<NewsVo>) (request.getAttribute("page")));
                int curPage = pageObj.getCurPage();
                int pageCount = pageObj.getPageCount();
            %>
            <%if(pageCount>1){%>
            <%if (curPage > 1) { %>
            <a href="newslist?page=1&typeId=<c:out value="${newsTypeVo.id}"/>">
                首页
            </a>
            <a href="newslist?page=<%=curPage-1%>&typeId=<c:out value="${newsTypeVo.id}"/>">
                &lt;&lt;上一页
            </a>
            <%}%>
            <%for (int i = curPage - 2 > 0 ? curPage - 2 : 1; i <= (curPage + 2 > 5 ? curPage + 2 < pageCount ? curPage + 2 : pageCount : pageCount > 5 ? 5 : pageCount); i++) {%>
            <a href="newslist?page=<%=i%>&typeId=<c:out value="${newsTypeVo.id}"/>" <%=i == curPage ? "id=\"current_page\"" : ""%>><%=i%>
            </a>
            <%}%>
            <%if (curPage < pageCount) {%>
            <a href="newslist?page=<%=curPage+1%>&typeId=<c:out value="${newsTypeVo.id}"/>">下一页&gt;&gt;</a>
            <a href="newslist?page=<%=pageCount%>&typeId=<c:out value="${newsTypeVo.id}"/>">
                末页
            </a>
            <%}%>
            <%}%>
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
