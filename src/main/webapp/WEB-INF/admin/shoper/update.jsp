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

    <script src="${ctx}/staticKindEditor/kindeditor-all.js"></script>
    <script src="${ctx}/staticKindEditor/lang/zh-CN.js"></script>
    <script src="${ctx}/staticKindEditor/common.js"></script>



    <script src="${ctx}/staticAdmin/modlue/shoper/shoper.js"></script>
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
                        <div class="form-group">
                            <input type="hidden" id="m_id" value="${ShoperBean.p_id}"/>
                            <input type="hidden" id="picUrlVal" value="${ShoperBean.p_photo1}"/>
                            <label for="m_name">商家名称：</label> <span></span>
                            <input type="text" id="m_name" placeholder="请输入商家名称" class="form-control" value="${ShoperBean.p_name}">
                        </div>
                        <div class="form-group">
                            <label for="m_desc">描述：</label> <span></span>
                            <input type="text" id="m_desc" placeholder="请输入商家描述" class="form-control" value="${ShoperBean.p_desc}">
                        </div>
                        <div class="form-group">
                            <label for="m_url">网址：</label> <span></span>
                            <input type="text" id="m_url" placeholder="请输入网址" class="form-control" value="${ShoperBean.p_url}">
                        </div>
                        <div class="form-group">
                            <label for="m_phone">电话号码：</label> <span></span>
                            <input type="text" id="m_phone" placeholder="请输入电话号码" class="form-control" value="${ShoperBean.p_phone}">
                        </div>
                        <div class="form-group">
                            <label for="m_keys">关键字：</label> <span></span>
                            <input type="text" id="m_keys" placeholder="请输入关键字" class="form-control" value="${ShoperBean.p_keys}">
                        </div>
                        <div class="form-group">
                            <label for="m_photo1" class="input input-file state-success">商家图片:(80*80)</label><br>
                            <input type="hidden" id="m_photo1" value="${ShoperBean.p_photo1}"/>
                            <input type="button"  class="uploadPicture" name="m_photo1"  value="选择图片" />
                            <img src="${ShoperBean.p_photo1}" width="80" height="80">
                            <!--
                            <label for="picUrl" class="input input-file state-success">商家图片:(400*400)</label>
                            <input type="file" name="uploadify" id="picUrl"/>
                            <label class="error" id="picUrlName" style="display:none"></label>
                            <input type="button" id="picUrlDel" class="btn btn-danger btn-delete" value="删除 "
                                   onClick="delFj('picUrlDel')" style="display:none"/>
                            <span id="picUrlClass"></span>
                            </label>
                            -->

                        </div>
                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="updShoper()" class="btn btn-primary">确认修改</button>
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
