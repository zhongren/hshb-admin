<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="../common/css.jsp"></jsp:include>

    <jsp:include page="../common/js.jsp"></jsp:include>
    <script src="${ctx}/staticAdmin/modlue/order/order.js"></script>
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
                        <!--
                        <div class="form-group">
                            <label for="user_name">用户名：</label>
                            <input name="s_user_name" type="text" class="form-control" id="user_name" placeholder="请输入用户名">
                        </div>
                        -->
                        <div class="form-group">
                            <label for="user_id">用户编号：</label>
                            <input name="s_user_id" type="text" class="form-control" id="user_id" placeholder="请输入编号">
                        </div>
                        <div class="form-group">
                            <label for="order_id">订单号：</label>
                            <input name="s_order_id" type="text" class="form-control" id="order_id" placeholder="请输入订单号">
                        </div>
                        <div class="form-group">
                            <label for="status">状态：</label><br>
                            <select name="s_status" id="status" onChange="aab()" class="styled hasCustomSelect"
                                    style="border-radius: 4px;border: 1px solid #e2e2e4;box-shadow: none;color: #555;width: 130px;height: 32px">
                                <option value="">订单状态</option>
                                 <option value="-1" <c:if test="${state==-1}">selected</c:if> >未付款</option>
                                <option value="0" <c:if test="${state==0}">selected</c:if> >等待充值</option>
                                <option value="1" <c:if test="${state== 1}">selected</c:if> >已完成</option>
                            </select>
                        </div>
                        <div class="form-group" style="padding-top: 22px;padding-left: 2px">
                            <button onclick="doSearch()" class="btn btn-primary">查询</button>
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
                <h4 class="modal-title" id="myModalLabel">完成订单</h4>
            </div>
            <div class="modal-body">
                <div class="col-lg-12">
                    <section class="panel">
                        <div class="panel-body">
                            <form role="form">
                                <div class="form-group">
                                    <span>确认完成?</span>
                                </div>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
            <div class="modal-footer" >
                <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
                <button id="deal" type="button" onclick="" class="btn btn-danger">是</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2">取消订单</h4>
            </div>
            <div class="modal-body">
                <div class="col-lg-12">
                    <section class="panel">
                        <div class="panel-body">
                            <form role="form">
                                <div class="form-group">
                                    <span>订单信息有误,取消订单,并将乐币返还用户</span>
                                </div>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
            <div class="modal-footer" >
                <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
                <button id="cancel" type="button" onclick="" class="btn btn-danger">是</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

</body>
</html>
