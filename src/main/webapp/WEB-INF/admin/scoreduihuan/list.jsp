<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../common/css.jsp"></jsp:include>
    <jsp:include page="../common/js.jsp"></jsp:include>

    <script src="${ctx}/staticAdmin/modlue/scoreduihuan/scoreduihuan.js"></script>
</head>
<body>
<div>
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
                        <div class="form-inline">
                            <div class="form-group">
                                <label for="user_id">会员编号：</label>
                                <input name="s_user_id" type="text" class="form-control" id="user_id" placeholder="请输入电话号码">
                            </div>



                            <div class="form-group" style="padding-top: 22px;padding-left: 2px">
                                <button onclick="doSearch()" class="btn btn-primary">查询</button>
                            </div>
                            <!--
                            <div class="form-group pull-right" style="padding-top: 22px;"> <a class="btn btn-info" href="${ctx}/sysUser/preAdd" target="main">
                                添加 <i class="icon-plus"></i></a>
                            </div>
                            -->
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
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">积分商品兑换</h4>
            </div>
            <div class="modal-body">
                <div class="col-lg-12">
                    <section class="panel">
                        <div class="panel-body">
                            <form role="form">
                                <div class="form-group">
                                    <span>确认兑换?</span>
                                </div>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
            <div class="modal-footer" >
                <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
                <button id="finish" type="button" onclick="" class="btn btn-danger">是</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
</body>
</html>
