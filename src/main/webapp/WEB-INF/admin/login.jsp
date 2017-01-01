<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <title>后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/staticAdmin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/staticAdmin/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${ctx}/staticAdmin/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${ctx}/staticAdmin/css/style.css" rel="stylesheet">
    <link href="${ctx}/staticAdmin/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="${ctx}/staticAdmin/js/html5shiv.js"></script>
    <script src="${ctx}/staticAdmin/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body" >

<div class="container" >

    <form class="form-signin" action="${ctx}/login/deal" method="post" accept-charset="utf-8">
        <h2 class="form-signin-heading">和顺环保后台管理系统</h2>
        <div class="login-wrap">
            <c:if test="${msg != null}">
                <span style="color: red"><c:out value="${msg }"/></span>
            </c:if>
            <input type="text" name="name" class="form-control" placeholder="请输入用户名" autofocus>
            <input type="password" class="form-control" placeholder="请输入密码" name="password">
            <input class="btn btn-lg btn-login btn-block" type="submit" value="登录" />
        </div>
    </form>
</div>



<!-- js placed at the end of the document so the pages load faster -->
<script src="${ctx}/staticAdmin/js/jquery.js"></script>
<script src="${ctx}/staticAdmin/js/bootstrap.min.js"></script>


</body>
</html>


