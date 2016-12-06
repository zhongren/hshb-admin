<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="perm" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="../../common/css.jsp"></jsp:include>
    <jsp:include page="../../common/js.jsp"></jsp:include>
    <script src="${ctx}/staticAdmin/modlue/sys/role.js"></script>
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


    <div class="row">
        <div class="col-lg-12">
            <section class="panel">
                <header class="panel-heading">
                    ${title}
                </header>
                <div class="panel-body">
                    <div class="form-inline" >
                        <div class="form-group">
                            <label for="name">角色名称：</label>
                            <input name="s_name" type="text" class="form-control" id="name" placeholder="请输入名称">
                        </div>
                        <div class="form-group" style="padding-top: 22px;padding-left: 2px">
                            <button onclick="doSearch()" class="btn btn-primary">查询</button>
                        </div>
                        <div class="form-group pull-right" style="padding-top: 22px;">
                            <perm:hasPermission name="role:add">
                            <a class="btn btn-info" href="${ctx}/role/preAdd" target="main">
                            添加 <i class="icon-plus"></i>
                            </a>
                            </perm:hasPermission>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    </div>
    <!-- page start-->
    <div class="row">
        <div class="col-lg-12">
            <section class="panel">
                <!-- <header class="panel-heading"> </header> -->
                <div class="panel-body">
                    <div class="adv-table">
                        <table class="display table table-bordered table-striped"
                               id="datatable_tabletools">
                            <thead>

                            </thead>
                            <tbody>

                            </tbody>
                            <tfoot>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <!-- page end-->
</section>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">角色删除</h4>
            </div>
            <div class="modal-body">
                <div class="col-lg-12">
                    <section class="panel">
                        <div class="panel-body">
                            <form role="form">
                                <div class="form-group">
                                    <span>确认删除?</span>
                                </div>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
            <div class="modal-footer" >
                <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
                <button id="del" type="button" onclick="" class="btn btn-danger">是</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

</body>
</html>
