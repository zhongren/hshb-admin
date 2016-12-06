<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <jsp:include page="common/js.jsp"></jsp:include>
    <script src="${ctx}/staticKindEditor/kindeditor-all.js"></script>
    <script src="${ctx}/staticKindEditor/lang/zh-CN.js"></script>
    <script src="${ctx}/staticKindEditor/common.js"></script>
</head>
<body>




<textarea id="editor_id" name="content" style="width:1000px;height:600px;">
hello
</textarea>
<input type="button"  class="uploadPicture" name="p_photo1"  value="选择图片" />
<input type="button"  class="uploadPicture" name="p_photo2"  value="选择图片" />
</body>
</html>
