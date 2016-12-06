<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <jsp:include page="../common/css.jsp"></jsp:include>
    <jsp:include page="../common/js.jsp"></jsp:include>

    <script src="${ctx}/staticAdmin/modlue/user/personalinfo.js"></script>
</head>
<body>
<section class="wrapper">
    <!-- 提示信息 -->
    <div class="alert alert-danger fade in hidden" id="warning-box">
        <button class="close" data-dismiss="alert">×</button>
        <i class="fa-fw fa fa-warning"></i> <strong id="warning-box-title"></strong><span
            id="warning-box-body"></span>
    </div>
    <div class="alert alert-success fade in hidden" id="success-box">
        <button class="close" data-dismiss="alert">×</button>
        <i class="fa-fw fa fa-warning"></i> <strong id="success-box-title"></strong><span
            id="success-box-body"></span>
    </div>
    <!-- page start-->
    <div class="row">
        <div class="col-lg-6">
            <section class="panel">
                <header class="panel-heading">
                    <header class="panel-heading">
                        ${title}
                    </header>
                </header>
                <div class="panel-body">
                    <div class="col-lg-12">
                        <section class="panel">
                            <div class="panel-body">
                                <form role="form">
                                    <input type="hidden" name="m_userId" value="${user.p_id}>

                                    <div class="form-group" >
                                        <label for="m_oldpass">旧密码：</label> <span></span>
                                        <input type="text" class="form-control" id="m_oldpass" placeholder="请输入旧密码">
                                    </div>
                                    <div class="form-group">
                                        <label for="m_newpass">新密码：</label> <span></span>
                                        <input type="text" id="m_newpass" placeholder="请输入新密码" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="m_newpass2">再次输入新密码：</label> <span></span>
                                        <input type="password" id="m_newpass2" placeholder="请再次输入密码" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <button type="button" onclick="updatePersonalinfo()" class="btn btn-primary">确认修改
                                        </button>
                                    </div>
                                </form>

                        </section>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <!-- page end-->
</section>


</body>
</html>
