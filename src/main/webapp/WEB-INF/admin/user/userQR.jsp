<%--
  Created by IntelliJ IDEA.
  User: HQ
  Date: 2017/1/12
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../common/css.jsp"/>
    <jsp:include page="../common/js.jsp"/>
    <style type="text/css">

        .table {
            width: 100%;
            height: 100%;
            font-size:5em;
        }

        .table .left {
            border-left: 1px solid #ddd;
            border-right: 1px solid #ddd;
        }

        .table .right {
            border-right: 1px solid #ddd;
        }

        .table .last {
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body style="background: none;">
<center>
    <div id="table">
        <table class="table">
            <tr>
                <td class="left">头像</td>
                <td class="right"><img src="<c:out value="${user.pic}" />" width="80"
                                       height="80"/>
                    </td>
            </tr>
            <tr>
                <td class="left">ID</td>
                <td class="right"><c:out value="${user.id}" /></td>
            </tr>
            <tr>
                <td class="left">姓名</td>
                <td class="right"><c:out value="${user.name}" /></td>
            </tr>
            <tr>
                <td class="left">性别</td>
                <td class="right">
                    <c:if test="${user.sex==1}">男</c:if>
                    <c:if test="${user.sex==0}">女</c:if>
                </td>
            </tr>
            <tr>
                <td class="left">部门</td>
                <td class="right">  <c:forEach var="depart" items="${user.departmentList}" varStatus="i">
                    <c:out value="${depart.name}" /> |
                </c:forEach></td>
            </tr>
            <tr>
                <td class="left">职位</td>
                <td class="right"><c:out value="${user.positionValue}" /></td>
            </tr>
            <tr>
                <td class="left">手机号</td>
                <td class="right"><c:out value="${user.phone}" /></td>
            </tr>
            <tr>
                <td class="last left">备注</td>
                <td class="last right"><c:out value="${user.remark}" /></td>
            </tr>
        </table>
    </div>
</center>
</body>
</html>
