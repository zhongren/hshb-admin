<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <title>无标题文档</title>
    <link href="${ctx}/staticAdmin/css/css.css" type="text/css" rel="stylesheet">
    <script src="${ctx}/staticAdmin/js/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/staticAdmin/js/js.js" type="text/javascript"></script>
</head>

<body>


<!--head-->
<div class="header">
    <div class="container">
        <a class="logo"><img src="${ctx}/staticAdmin/img/logo.png"></a>
        <ul class="nav">
            <li><a href="#">首页</a></li>
            <li class="on"><a href="#">关于和顺</a></li>
            <li><a href="#">信息公示</a></li>
            <li><a href="#">新闻中心</a></li>
            <li><a href="#">人才招聘</a></li>
        </ul>
        <div class="nav_mobile">
            <img src="${ctx}/staticAdmin/img/list1.png">
        </div>
    </div>

</div>
<!--/head-->

<!--container-->
<div class="container">
    <div class="con_left">

        <div class="fast_links">
            <div class="head">关于和顺</div>
            <ul>
                <li><a href="#">快速通道1</a></li>
                <li><a href="#">快速通道2</a></li>
                <li><a href="#">快速通道3</a></li>
                <li><a href="#">快速通道4</a></li>
            </ul>
        </div>
    </div><!--/con_left-->
    <div class="con_right">
        <div class="head">关于和顺-公司简介</div>
        <div class="title">标题</div>
        <div class="content">江苏和顺环保有限公司的前身为和顺环保股份有限公司，成立于2000年。
            和顺环保是一家专业从事工业废物处理处置及资源化利用的综合性环保服务商，为企业
            提供安全、迅速的环保服务解决方案。<br>
            公司位于苏州工业园区胜浦镇澄浦路18号，占地面积80亩。<br>
            公司注册资本6000万元，江苏省高新技术企业，银行信用等级AAA，公司通过了
            ISO14000环境管理体系和OHSAS18000职业安全卫生管理体系。<br>
            公司主营业务危险废弃物焚烧、工业废水处理、废线路板及覆铜板综合处置利用等。
            公司拥有一支踏实肯干、勇于创新开拓而且市场经济意识的技术队伍，专业知识结构合理
            （环境工程、化学工程、材料工程、热能工程、机械工程等多个领域），企业技术中心的工程
            应用设备、分析测样仪器齐全，目前公司拥有1项发明专利和9项实用新型专利。<br>
            公司秉承“真诚服务、持续改进、客户满意”的经营理念，确立“工艺达标、变废为宝”
            的服务宗旨。<br>
            经过十多年的发展、技术积淀，公司环保技术工艺日臻成熟、业务辐射不断扩大，实力不
            断增强，已成为江苏省危险废物处置领域内享有一定知名度的公司，已获得“江苏省高新技术
            企业”“中国环境保护产业协会第四届理事会理事（单位）”称号；公司被认定为“苏州市工程
            技术中心”、“苏州市企业技术中心”、“苏州市科技型中小企业”和“苏州市内资研发机构”
            公司被苏州工业园区管委会评为“工业园区环保先进单位”，并多次获得合作单位的“重合同、
            守信用”“先进协作单位”、“优秀服务单位”等荣誉称号。
        </div>
    </div><!--/con_right-->
</div>
<!--/container-->

<!--footer-->
<div id="footer">
    <p>江苏和顺环保有限公司</p>

    <p>版权所有<br>苏ICP备13018519号-2</p>

    <p>外部链接：<a href="#">江苏环保厅</a> <a href="#">苏州环保局</a> <a href="#">园区环保局</a> <a href="#">兆润控股</a> <a href="#">中新公用</a>
    </p>
</div>
<!--/footer-->

</body>
</html>
