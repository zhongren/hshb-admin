<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <jsp:include page="common/css.jsp"/>
</head>
<!--main content start-->
<body>
<!--main content end-->
<p>后台管理系统</p>
<jsp:include page="common/js.jsp"/>
<script>
    //owl carousel
    $(document).ready(function () {
        $("#owl-demo").owlCarousel({
            navigation: true,
            slideSpeed: 300,
            paginationSpeed: 400,
            singleItem: true
        });
    });
    //custom select box
    $(function () {
        $('select.styled').customSelect();
    });
</script>
</body>
</html>
