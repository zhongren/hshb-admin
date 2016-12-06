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

    <script src="${ctx}/staticAdmin/modlue/adv/adv.js"></script>
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
                            <input type="hidden" id="m_id" value="${AdvBean.p_id}"/>
                            <input type="hidden" id="picUrlVal" value="${AdvBean.p_photo}"/>
                            <label for="m_title">标题：</label> <span></span>
                            <input type="text" id="m_title" placeholder="请输入标题" class="form-control" value="${AdvBean.p_title}">
                        </div>

                        <div class="form-group">
                            <label for="m_url">网址：</label> <span></span>
                            <input type="text" id="m_url" placeholder="请输入网址" class="form-control" value="${AdvBean.p_url}">
                        </div>
                        <div class="form-group">
                            <label for="m_type">广告类型：</label> <span></span><br>
                            <select name="goodsType" id="m_type" onChange="aab()" class="styled hasCustomSelect"
                                    style="border-radius: 4px;border: 1px solid #e2e2e4;box-shadow: none;color: #555;width: 130px;height: 32px">
                                <option value="">广告类型</option>
                                <c:forEach var="t" items="${typerList}">
                                    <option value="${t.p_id }" <c:if test="${t.p_id == AdvBean.p_type}">selected</c:if> >${t.p_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="m_photo" class="input input-file state-success">广告图片:</label><br>
                            <input type="hidden" id="m_photo" value="${AdvBean.p_photo}"/>
                            <input type="button"  class="uploadPicture" name="m_photo"  value="选择图片" />
                            <img src="${AdvBean.p_photo}" width="80" height="80">
                            <!--
                            <label for="picUrl" class="input input-file state-success">广告图片:(400*400)</label>
                            <input type="file" name="uploadify" id="picUrl"/>
                            <label class="error" id="picUrlName" style="display:none"></label>
                            <input type="button" id="picUrlDel" class="btn btn-danger btn-delete" value="删除 "
                                   onClick="delFj('picUrlDel')" style="display:none"/>
                            <span id="picUrlClass"></span>
                            </label>
                            -->
                        </div>
                        <div class="form-group">
                            <label for="m_goods_id">商品id：</label> <span></span>
                            <input type="text" id="m_goods_id" placeholder="请输入商品id" class="form-control" value="${AdvBean.p_goods_id}">
                        </div>
                        <div class="form-group">
                            <label for="m_content">内容：</label> <span></span>
                                                          <textarea id="editor" name="content" style="width:100%;height:500px;">
                                                              ${AdvBean.p_content}
                                                          </textarea>
                            <!--<input type="text" id="m_content" placeholder="请输入内容" class="form-control" value="${AdvBean.p_content}">-->
                        </div>
                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="updAdv()" class="btn btn-primary">确认修改</button>
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
