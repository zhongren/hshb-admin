<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <jsp:include page="../common/css.jsp"></jsp:include>
    <jsp:include page="../common/js.jsp"></jsp:include>

    <script type="text/javascript" charset="utf-8" src="${ctx}/staticUploadify/jquery.uploadify-3.1.js"></script>
    <link type="text/css" charset="utf-8" href="${ctx}/staticUploadify/uploadify.css" rel="stylesheet">
    <script src="${ctx}/staticAdmin/modlue/news/news.js"></script>
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
                        ${title}
                    </header>
                </header>
                <div class="panel-body">
                    <form role="form">
                        <input type="hidden" id="picUrlVal" value=""/>

                        <div class="form-group">
                            <label for="m_name">文章标题：</label> <span></span>
                            <input type="text" id="m_name" placeholder="请输入标题" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="m_typeId">文章类型：</label> <span></span><br>
                            <select name="newsType" id="m_typeId" onChange="aab()" class="styled hasCustomSelect"
                                    style="border-radius: 4px;border: 1px solid #e2e2e4;box-shadow: none;color: #555;width: 130px;height: 32px">
                                <option value="">新闻类型</option>
                                <c:forEach var="c" items="${newsTypeList}">
                                    <option value="${c.p_id}">${c.p_type_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">

                            <label for="uploadify">小图片:(80*80)</label> <span></span>
                            <label for="file" class="input input-file state-success">
                            <input type="file" name="uploadify" id="uploadify" />
                                <label class="error" id="advice-required-picUrl2" style="display:none"></label>
                               <!-- <input type="button" id="picUrl2Btn-picUrl" class="btn btn-danger btn-delete" value="删除 " onClick="javascript:delFj('picUrl2Btn-picUrl')" style="display:none"/>-->
                                <span id="picUrl2Class"></span>
                            </label> </div>

                        <div class="form-group">
                            <label for="editor">新闻详情：</label>
                            <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
                        </div>

                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="addNews()" class="btn btn-primary">确认添加</button>
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
