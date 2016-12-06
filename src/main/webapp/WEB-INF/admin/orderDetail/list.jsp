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
</head>
<body>
<input type="hidden" id="order_id" value="${order_id}">
<section class="wrapper">
    <div class="row">
        <div class="col-lg-12">
            <section class="panel">
                <header class="panel-heading">
                    ${title}
                </header>

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
<jsp:include page="../common/js.jsp"></jsp:include>
<script src="${ctx}/staticAdmin/modlue/orderDetail/orderDetail.js"></script>
</body>
</html>
