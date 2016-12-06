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

    <script src="${ctx}/staticAdmin/modlue/scoreshop/scoreshop.js"></script>
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
                            <input type="hidden" id="picUrlVal" value=""/>
                            <label for="m_name">积分商品名称：</label> <span></span>
                            <input type="text" id="m_name" placeholder="请输入名称" class="form-control">
                        </div>

                        <div class="form-group">
                            <label for="m_type">属性：(虚拟/实物)</label> <span></span>
                            <input type="text" id="m_type" placeholder="请输入属性" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="m_score">兑换所需积分：</label> <span></span>
                            <input type="text" id="m_score" placeholder="请输入积分" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="m_type">库存数</label> <span></span>
                            <input type="text" id="m_stock" placeholder="请输入库存" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="m_photo1" class="input input-file state-success">商品图片:</label><br>
                            <input type="button"  class="uploadPicture" name="m_photo1"  value="选择图片" />
                            <!--
                            <label for="picUrl" class="input input-file state-success">商品图片:(400*400)</label>
                            <input type="file" name="uploadify" id="picUrl"/>
                            <label class="error" id="picUrlName" style="display:none"></label>
                            <input type="button" id="picUrlDel" class="btn btn-danger btn-delete" value="删除 "
                                   onClick="delFj('picUrlDel')" style="display:none"/>
                            <span id="picUrlClass"></span>
                            </label>
                            -->

                        </div>

                        <div class="form-group">
                            <label for="editor">商品详情：</label>

                            <textarea id="editor" name="content" style="width:100%;height:500px;">

                        </textarea>

                        </div>

                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="addScoreShop()" class="btn btn-primary">确认添加</button>
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
