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


    <script src="${ctx}/staticAdmin/modlue/goods/goods.js"></script>
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
                            <input type="hidden" id="m_id" value="${goodsBean.p_id}"/>

                            <label for="m_name">游戏名称：</label> <span></span>
                            <input type="text" id="m_name" placeholder="请输入名称" class="form-control"
                                   value="${goodsBean.p_name}">
                        </div>
                        <div class="form-group">
                            <label for="m_server">游戏区服(用;分隔)：</label> <span></span>
                            <input type="text" id="m_server" placeholder="请输入区服列表" class="form-control"
                                   value="${goodsBean.p_server}">
                        </div>
                        <div class="form-group">
                            <label for="m_type_id">商品类型：</label> <span></span><br>
                            <select name="goodsType" id="m_type_id" onChange="aab()" class="styled hasCustomSelect"
                                    style="border-radius: 4px;border: 1px solid #e2e2e4;box-shadow: none;color: #555;width: 130px;height: 32px">
                                <option value="">商品类型</option>
                                <c:forEach var="c" items="${shoperList}">
                                    <option value="${c.p_id }"
                                            <c:if test="${c.p_id == goodsBean.p_type_id}">selected</c:if> >${c.p_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="m_price">充值单价：</label> <span></span>
                            <input type="text" id="m_price" placeholder="请输入充值单价" class="form-control"
                                   value="${goodsBean.p_price}">
                        </div>

                        <div class="form-group">
                            <label for="m_score">积分<font
                                    style="color: red">充值后返回的积分数</font></label> <span></span>
                            <input type="text" id="m_score" placeholder="请输入积分" class="form-control" value="${goodsBean.p_score}">
                        </div>

                        <div class="form-group">
                            <label for="m_rate_base_user">普通会员充值折扣<font style="color: red">(1 - 9)：</font></label>
                            <span></span>
                            <input type="text" id="m_rate_base_user" placeholder="请输入折扣" class="form-control"
                                   value="${goodsBean.p_rate_base_user}">
                        </div>
                        <div class="form-group">
                            <label for="m_price_base_user">普通会员价<font style="color: red">(普通会员实际充值时的价格)：</font></label>
                            <span></span>
                            <input type="text" id="m_price_base_user" placeholder="请输入普通会员价" class="form-control"
                                   value="${goodsBean.p_price_base_user}">
                        </div>
                        <div class="form-group">
                            <label for="m_rate_hy_user">收费会员充值折扣<font style="color: red">(1 - 9)：</font></label>
                            <span></span>
                            <input type="text" id="m_rate_hy_user" placeholder="请输入折扣" class="form-control"
                                   value="${goodsBean.p_rate_hy_user}">
                        </div>
                        <div class="form-group">
                            <label for="m_price_hy_user">收费会员价<font style="color: red">(收费会员实际充值时的价格)：</font></label>
                            <span></span>
                            <input type="text" id="m_price_hy_user" placeholder="请输入收费会员价" class="form-control"
                                   value="${goodsBean.p_price_hy_user}">
                        </div>
                        <div class="form-group">
                            <label for="m_url">商品链接：</label> <span></span>
                            <input type="text" id="m_url" placeholder="请输入链接" class="form-control"
                                   value="${goodsBean.p_url}">
                        </div>
                        <div class="form-group">
                            <label for="m_photo1" class="input input-file state-success">小图片:(70*60)</label><br>
                            <input type="hidden" id="m_photo1" value="${goodsBean.p_photo1}"/>
                            <input type="button" class="uploadPicture" name="m_photo1" value="选择图片"/>
                            <img src="${goodsBean.p_photo1}" width="80" height="80">

                            <!--
                                                        <input type="file" name="uploadify" id="picUrl" />
                                                        <label class="error" id="picUrlName" style="display:none"></label>
                                                        <input type="button" id="picUrlDel" class="btn btn-danger btn-delete" value="删除 " onClick="delFj1('picUrlDel')" style="display:none"/>
                                                        <span id="picUrlClass"></span>
                                                        </label>
                                                        -->

                        </div>
                        <div class="form-group">
                            <label for="m_photo2" class="input input-file state-success">大图片:(240*140)</label><br>
                            <input type="hidden" id="m_photo2" value="${goodsBean.p_photo2}"/>
                            <input type="button" class="uploadPicture" name="m_photo2" value="选择图片"/>
                            <img src="${goodsBean.p_photo2}" width="80" height="80">
                            <!--
                            <label for="picUrl2" class="input input-file state-success">大图片:(200*200)</label>

                            <input type="file" name="uploadify" id="picUrl2" />
                            <label class="error" id="picUrl2Name" style="display:none"></label>
                            <input type="button" id="picUrl2Del" class="btn btn-danger btn-delete" value="删除 " onClick="delFj2('picUrl2Del')" style="display:none"/>
                            <span id="picUrl2Class"></span>
                            </label>
                            -->
                        </div>

                        <div class="form-group">
                            <label for="editor">商品详情：</label>

                                             <textarea id="editor" name="content" style="width:100%;height:500px;">
                                                 ${goodsBean.p_desc}
                                             </textarea>
                        </div>

                        <div class="form-group">
                            <div class="pull-right">
                                <button type="button" class="btn btn-default">关闭
                                </button>
                                <button type="button" onclick="updGoods()" class="btn btn-primary">确认修改</button>
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
