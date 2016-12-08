<%--
  Created by IntelliJ IDEA.
  User: ZR
  Date: 2016/12/8
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/js.jsp"/>
<jsp:include page="common/css.jsp"/>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div id="timepickerdemo">
    <input size="16" type="text" value="2012-06-15" readonly class="form_datetime" data-date-format="yyyy-mm-dd">

    <script type="text/javascript">
        $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd',minView:'month'});
    </script>
</div>
</body>
</html>
