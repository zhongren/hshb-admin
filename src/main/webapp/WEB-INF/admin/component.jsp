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
    <input size="16" type="text" readonly class="form_datetime" data-date-format="yyyy-mm-dd">
    <span class="add-on"><i class="icon-th"></i></span>
    <script type="text/javascript">
        $(".form_datetime").val(moment().format("YYYY-MM-DD"));
        $(".form_datetime").datetimepicker(
                {
                    format: 'yyyy-mm-dd',
                    minView: 'month',
                    language: 'zh-CN',
                });
    </script>
</div>
</body>
</html>
