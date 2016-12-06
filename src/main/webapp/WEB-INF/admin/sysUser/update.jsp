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

    <script src="${ctx}/staticAdmin/modlue/user/sysuser.js"></script>
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
                                <input type="hidden" id="m_id"  value="${sysUser.p_id}">
                                <input type="hidden" id="m_password"  value="123456789">
                                <form role="form">
                                    <div class="form-group">
                                        <label for="m_phone">手机号码：</label><span></span>
                                        <input type="text" class="form-control" id="m_phone" placeholder="请输入手机号码" value="${sysUser.p_phone}">
                                    </div>

                                     <div class="form-group">
                                        <label for="m_real_name">姓名：</label> <span></span>
                                        <input type="text" class="form-control" id="m_real_name" placeholder="请输入姓名" value="${sysUser.p_real_name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="m_account">账号：</label> <span></span>
                                        <input type="text" id="m_account" placeholder="请输入账号" class="form-control" value="${sysUser.p_account}">
                                    </div>

                                    <div class="form-group">
                                        <label for="m_email">邮箱：</label> <span></span>
                                        <input type="text" id="m_email" placeholder="请输入邮箱" class="form-control" value="${sysUser.p_email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="m_role_id">权限角色：</label> <span></span><br>
                                        <select name="newsType" id="m_role_id"
                                                class="styled hasCustomSelect"
                                                style="border-radius: 4px;border: 1px solid #e2e2e4;box-shadow: none;color: #555;width: 130px;height: 32px">
                                            <option value="">权限角色</option>
                                            <c:forEach var="c" items="${roleList}">
                                                <option value="${c.p_id}" <c:if test="${c.p_id == sysUser.p_role_id}">selected</c:if>>${c.p_name}</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <button type="button" onclick="updSysUser()" class="btn btn-primary">确认修改
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
