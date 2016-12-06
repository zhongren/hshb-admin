
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <jsp:include page="../common/css.jsp"></jsp:include>
</head>
<body>
<section class="wrapper">
    <div class="row">
        <div class="col-lg-12">
            <section class="panel">
                <header class="panel-heading">
                    ${title}
                </header>
                <div class="panel-body">
                    <div class="form-inline" >
                        <div class="form-group">
                            <label for="name">新闻类型名称：</label>
                            <input name="s_type_name" type="text" class="form-control" id="name" placeholder="请输入名称">
                        </div>
                        <div class="form-group" style="padding-top: 22px;padding-left: 2px">
                            <button onclick="doSearch()" class="btn btn-primary">查询</button>
                        </div>
                     <div class="form-group pull-right" style="padding-top: 22px;"> <a class="btn btn-info" href="${ctx}/newsType/preAdd" target="main">
                         添加 <i class="icon-plus"></i></a>
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
                <h4 class="modal-title" id="myModalLabel">类型删除</h4>
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
                <button id="d" type="button" onclick="" class="btn btn-danger">是</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<jsp:include page="../common/js.jsp"></jsp:include>
<script src="${ctx}/staticAdmin/modlue/newsType/newsType.js"></script>
</body>
</html>
