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

    <!--<script type="text/javascript" charset="utf-8" src="${ctx}/staticUploadify/jquery.uploadify-3.1.js"></script>
    <link type="text/css" charset="utf-8" href="${ctx}/staticUploadify/uploadify.css" rel="stylesheet">-->
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
                        <input type="hidden" id="m_id" value="${news.id}"/>
                        <div class="form-group">
                            <label for="m_recommend">首页滚动：</label> <span></span><br>
                            <select name="newsType" id="m_recommend"  class="styled hasCustomSelect"
                                    style="border-radius: 4px;border: 1px solid #e2e2e4;box-shadow: none;color: #555;width: 130px;height: 32px">
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="m_name">文章标题：</label> <span></span>
                            <input type="text" id="m_name" placeholder="请输入标题" class="form-control" value="${news.name}">
                        </div>
                        <div class="form-group">
                            <label for="m_name">作者：</label> <span></span>
                            <input type="text" id="m_author" placeholder="请输入作者" class="form-control" value="${news.author}">
                        </div>
                        <div class="form-group">
                            <label for="m_typeId">文章类型：</label> <span></span><br>
                            <select name="newsType" id="m_typeId" onChange="aab()" class="styled hasCustomSelect"
                                    style="border-radius: 4px;border: 1px solid #e2e2e4;box-shadow: none;color: #555;width: 130px;height: 32px">
                                <c:forEach var="newsType" items="${newsTypeList}">
                                    <option value="${newsType.id }" <c:if test="${newsType.id == news.typeId}">selected</c:if> >${newsType.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="m_picSmall" class="input input-file state-success">小图片(首页底部)</label><br>
                            <input type="button" class="uploadPicture" name="m_picSmall" value="选择图片"/>
                            <input type="hidden" id="m_picSmall" value=" ${news.picSmall}">
                            <div style="margin-top: 20px;"><a href="${news.picSmall}" target="_blank"><img src="${news.picSmall}" width="80" height="80"></a></div>
                        </div>
                        <div class="form-group">
                            <label for="m_picBig" class="input input-file state-success">大图片(首页滚动广告)</label><br>
                            <input type="button" class="uploadPicture" name="m_picBig" value="选择图片"/>
                            <input type="hidden" id="m_picBig" value=" ${news.picBig}">
                            <div style="margin-top: 20px;"><a href="${news.picBig}" target="_blank"><img src="${news.picBig}" width="80" height="80"></a></div>
                        </div>
                        <div class="form-group">
                            <label for="editor">文章内容：</label>
                            <textarea id="editor" name="m_content" style="width:100%;height:500px;">
                                ${news.content}
                            </textarea>
                        </div>

                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="update()" class="btn btn-primary">确认修改</button>
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
