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

    <script src="${ctx}/staticAdmin/modlue/market/market_liushui.js"></script>
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
                                <label for="some_class_1">日期：</label>
                                <input type="text" class="some_class"  id="some_class_1" name="s_time1">&nbsp;->
                                <input type="text" class="some_class"  id="some_class_2" name="s_time2">
                            </div>
                            <div class="form-group">
                                <label for="sys_user_id">销售员编号：</label>
                                <input name="s_sys_user_id" type="text" class="form-control" id="sys_user_id" placeholder="请输入编号">
                            </div>



                            <div class="form-group" style="padding-top: 22px;padding-left: 2px">
                                <button onclick="doSearch()" class="btn btn-primary">查询</button>
                            </div>

                            <div class="form-group pull-right" style="padding-top: 22px;"> <a class="btn btn-info" href="${ctx}/market/liushuiPre" target="main">
                                流水查询 </a>
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
</div>
<script type="text/javascript">
    $.datetimepicker.setLocale('ch');

    $('.some_class').datetimepicker({


    });



</script>
</body>
</html>
