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

    <!--<script type="text/javascript" charset="utf-8" src="${ctx}/staticUploadify/jquery.uploadify-3.1.js"></script>
    <link type="text/css" charset="utf-8" href="${ctx}/staticUploadify/uploadify.css" rel="stylesheet">-->
    <script src="${ctx}/staticAdmin/modlue/news/news.js"></script>

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
        <div class="col-lg-12">
            <section class="panel">
                <header class="panel-heading">
                    <header class="panel-heading">
                        ${title}
                    </header>
                </header>
                <div class="panel-body">
                    <form role="form">
                        <%--<div class="form-group">
                            <label for="m_id">ID：</label> <span></span>
                            <input type="text" id="m_id" placeholder="请输入ID" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="m_number">编号：</label> <span></span>
                            <input type="text" id="m_number" placeholder="请输入编号" class="form-control">
                        </div>--%>
                        <div class="form-group">
                            <label for="m_name">姓名：</label> <span></span>
                            <input type="text" id="m_name" placeholder="请输入姓名" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="m_sex">性别：</label> <span></span>
                            <select name="sex" id="m_sex" class="form-control">
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="m_depart">部门：</label> <span></span>
                            <select id="m_depart" class="form-control">

                            </select>
                        </div>
                        <div class="form-group">
                            <label for="m_position">职位：</label> <span></span>
                            <select id="m_position" class="form-control">

                            </select>
                        </div>
                            <div class="form-group">
                                <label for="m_edu">学历：</label> <span></span>
                                <select id="m_edu" class="form-control">

                                </select>
                            </div>
                        <div class="form-group">
                            <label for="m_phone">手机号：</label> <span></span>
                            <input type="text" id="m_phone" placeholder="请输入手机号" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="m_remark">备注：</label> <span></span>
                            <input type="text" id="m_remark" placeholder="请输入备注" class="form-control">
                        </div>
                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="save()" class="btn btn-primary">确认添加</button>
                            </div>
                        </div>
                    </form>

                </div>
            </section>
        </div>
    </div>
    <!-- page end-->
</section>

</body>
</html>
