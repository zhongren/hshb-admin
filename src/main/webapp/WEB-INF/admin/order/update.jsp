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
                        <div class="form-group">
                            <input type="hidden" id="m_id" value="${goodsType.p_id}"/>
                            <label for="m_name">类型名称：</label> <span></span>
                            <input type="text" id="m_name" placeholder="请输入名称" class="form-control" value="${goodsType.p_type_name}">
                        </div>
                        <div class="form-group">
                            <label for="m_desc">类型描述：</label> <span></span>
                            <input type="text" id="m_desc" placeholder="请输入描述" class="form-control" value="${goodsType.p_desc}">
                        </div>

                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="updateGoodsType()" class="btn btn-primary">确认修改</button>
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
<script src="${ctx}/staticAdmin/modlue/order/order.js"></script>
<jsp:include page="../common/js.jsp"></jsp:include>
</html>