<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en" XMLNS="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <jsp:include page="../common/css.jsp"></jsp:include>
    <jsp:include page="../common/js.jsp"></jsp:include>

    <!--<script type="text/javascript" charset="utf-8" src="${ctx}/staticUploadify/jquery.uploadify-3.1.js"></script>
    <link type="text/css" charset="utf-8" href="${ctx}/staticUploadify/uploadify.css" rel="stylesheet">-->
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
        <div class="col-lg-12">
            <section class="panel">
                <header class="panel-heading">
                    <header class="panel-heading">
                        <script>if (p["action"] === "save")document.write("用户添加"); else document.write("用户更新");</script>
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
                        <input type="hidden" id="id" value="${userVo.id}">
                        <div class="form-group">
                            <label class="input input-file state-success">照片</label><br>
                            <input type="button" class="uploadPicture" name="m_user_image"
                                   value="选择图片"/>
                            <c:if test="${userVo.pic!=null&&userVo.pic!=''}">
                                <input type="hidden" id="m_user_image"/>

                                <div style="margin-top: 20px;"><a
                                        href="${userVo.pic}"
                                        target="_blank"><img src="${userVo.pic}" width="80"
                                                             height="80"/></a></div>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label for="m_name">姓名：</label> <span></span>
                            <input type="text" id="m_name" placeholder="请输入姓名" value="${userVo.name}"
                                   class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="m_sex">性别：</label> <span></span>
                            <select name="sex" id="m_sex" class="form-control">
                                <option value="1" <c:if test="${userVo.sex==1}">selected</c:if>>男</option>
                                <option value="0" <c:if test="${userVo.sex==0}">selected</c:if>>女</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <div>
                                <label>部门：</label> <span></span>
                            </div>
                            <%--<select id="m_depart" class="form-control">--%>

                            <%--</select>--%>
                            <div class="col-md-12">
                                <c:forEach var="depart" items="${departmentList}" varStatus="i">
                                <c:if test="${(i.index)%3==0&&i.index>0}"></div>
                            <div style="clear:both;"></div>
                            <div class="col-md-12"></c:if>
                                <div class="col-md-4"><input type="checkbox" class="m_depart"
                                                             value="${depart.id}"
                                                             <c:forEach var="udepart"
                                                                        items="${userVo.departmentList}">
                                                            <c:if test="${udepart.id==depart.id}">checked</c:if>
                                </c:forEach>/><c:out value="${depart.name}"/>
                                </div>
                                </c:forEach>
                            </div>
                            <div style="clear:both;"></div>
                        </div>
                        <div class="form-group">
                            <label for="m_position">职位：</label> <span></span>
                            <select id="m_position" class="form-control">
                                <c:forEach var="position" items="${positionList}" varStatus="i">
                                    <option value="${position.id}" <c:if test="${userVo.position==position.id}">selected</c:if >><c:out value="${position.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="m_edu">学历：</label> <span></span>
                            <select id="m_edu" class="form-control">
                                <c:forEach var="eduLeve" items="${eduLevelList}" varStatus="i">
                                    <option value="${eduLeve.id}" <c:if test="${userVo.eduLevel==eduLeve.id}">selected</c:if >><c:out value="${eduLeve.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="m_phoneNumber">手机号：</label> <span></span>
                            <input type="text" id="m_phoneNumber" placeholder="请输入手机号" class="form-control" value="${userVo.phone}">
                        </div>
                        <div class="form-group">
                            <label for="m_remark">备注：</label> <span></span>
                            <input type="text" id="m_remark" placeholder="请输入备注" class="form-control" value="${userVo.remark}">
                        </div>
                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="edit(p['action']);" class="btn btn-primary">提交
                                </button>
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
