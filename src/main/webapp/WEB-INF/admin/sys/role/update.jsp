<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <jsp:include page="../../common/css.jsp"></jsp:include>
    <jsp:include page="../../common/js.jsp"></jsp:include>
    <script src="${ctx}/staticAdmin/modlue/sys/roleAdd.js"></script>

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
                        ${title}roleID:${role.p_id}
                        <input type="hidden" id="roleId" value="${role.p_id}">
                    </header>
                </header>
                <div class="panel-body">
                    <form role="form" >
                        <div class="form-group">
                            <font color="red">* </font>
                            <label for="roleName">权限角色名称：</label> <span></span>
                            <input type="text" id="roleName" placeholder="请输入权限角色名称" class="form-control" value="${role.p_name}">
                        </div>
                        <div class="form-group">
                            <font color="red">* </font>
                            <label for="roleDesc">备注信息：</label> <span></span>
                            <input type="text" id="roleDesc" placeholder="请输入备注信息" class="form-control" value="${role.p_desc}">
                        </div>


                        <div >
                            <table id="datatable_tabletools1" class="table table-bordered table-hover ">
                                <%int c = 0;%>
                                <c:forEach  var="p" items="${permList}">
                                    <%if (c % 6 == 0) {%>
                                    <tr>
                                        <%}
                                            c++;%>
                                        <td><div align="left"><input type="checkbox"  class="permission-checkbox" name="perm" value=${p.p_id} > ${p.p_name}</div></td>
                                        <%
                                            if (c % 6 == 0) {
                                        %>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </c:forEach>

                            </table>
                            <div class="form-group">
                                <button class="btn btn-info" onclick="updatePermission()">
                                   修改 <i class="icon-plus"></i>
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
