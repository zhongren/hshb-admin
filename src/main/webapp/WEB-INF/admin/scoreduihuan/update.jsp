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

    <script src="${ctx}/staticAdmin/modlue/user/user.js"></script>
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
                                <input type="hidden" id="m_id"  value="${user.p_id}">
                                <input type="hidden" id="m_password"  value="123456789">
                                <form role="form">
                                    <div class="form-group">
                                        <label for="m_phone">手机号码：</label><span></span>
                                        <input type="text" class="form-control" id="m_phone" placeholder="请输入手机号码" value="${user.p_user_phone}">
                                    </div>

                                     <div class="form-group">
                                        <label for="m_real_name">姓名：</label> <span></span>
                                        <input type="text" class="form-control" id="m_real_name" placeholder="请输入姓名" value="${user.p_user_name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="m_account">账号：</label> <span></span>
                                        <input type="text" id="m_account" placeholder="请输入账号" class="form-control" value="${user.p_account}">
                                    </div>

                                    <div class="form-group">
                                        <label for="m_email">邮箱：</label> <span></span>
                                        <input type="text" id="m_email" placeholder="请输入邮箱" class="form-control" value="${user.p_email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="m_email">积分：</label> <span></span>
                                        <input type="text" id="m_point" placeholder="请输入积分" class="form-control" value="${user.p_point}">
                                    </div>
                                    <div class="form-group">
                                        <label for="m_point1">积分分成：(左)</label> <span></span>
                                        <input type="text" id="m_point1" placeholder="请输入左线积分" class="form-control" value="${user.p_point1}">
                                    </div>
                                    <div class="form-group">
                                        <label for="m_point2">积分分成：(右)</label> <span></span>
                                        <input type="text" id="m_point2" placeholder="请输入右线积分" class="form-control" value="${user.p_point2}">
                                    </div>

                                    <div class="form-group">
                                        <label for="m_hy_end_time">会员到期时间：</label> <span></span>
                                        <input type="text" id="m_hy_end_time" placeholder="请输入会员到期时间" class="form-control" value="${user.p_hy_end_time}">
                                    </div>

                                    <div class="form-group">
                                        <button type="button" onclick="updUser()" class="btn btn-primary">确认修改
                                        </button>
                                    </div>
                                </form>
                            </div>
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
