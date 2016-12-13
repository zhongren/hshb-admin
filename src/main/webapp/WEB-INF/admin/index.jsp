<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="img/favicon.html">
    <title>后台管理</title>
    <jsp:include page="common/css.jsp"/>
</head>
<body>
<section id="container" class="">
    <!--header start-->
    <header class="header white-bg">
        <div class="sidebar-toggle-box">
            <!--  <div data-original-title="Toggle Navigation" data-placement="right"
                  class="icon-reorder tooltips"></div>-->
            <div data-placement="right"
                 class="icon-reorder tooltips"></div>
        </div>
        <!--logo start-->
        <a href="#" class="logo">后台管理系统<span></span></a>
        <!--logo end-->
        <!--
          <div class="nav notify-row" id="top_menu">

          <ul class="nav top-menu">

              <li class="dropdown"><a data-toggle="dropdown"
                                      class="dropdown-toggle" href="#"> <i class="icon-tasks"></i> <span
                      class="badge bg-success">6</span>
              </a>
                  <ul class="dropdown-menu extended tasks-bar">
                      <div class="notify-arrow notify-arrow-green"></div>
                      <li>
                          <p class="green">You have 6 pending tasks</p>
                      </li>
                      <li><a href="#">
                          <div class="task-info">
                              <div class="desc">Dashboard v1.3</div>
                              <div class="percent">40%</div>
                          </div>
                          <div class="progress progress-striped">
                              <div class="progress-bar progress-bar-success"
                                   role="progressbar" aria-valuenow="40" aria-valuemin="0"
                                   aria-valuemax="100" style="width: 40%">
                                  <span class="sr-only">40% Complete (success)</span>
                              </div>
                          </div>
                      </a></li>
                      <li><a href="#">
                          <div class="task-info">
                              <div class="desc">Database Update</div>
                              <div class="percent">60%</div>
                          </div>
                          <div class="progress progress-striped">
                              <div class="progress-bar progress-bar-warning"
                                   role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                   aria-valuemax="100" style="width: 60%">
                                  <span class="sr-only">60% Complete (warning)</span>
                              </div>
                          </div>
                      </a></li>
                      <li><a href="#">
                          <div class="task-info">
                              <div class="desc">Iphone Development</div>
                              <div class="percent">87%</div>
                          </div>
                          <div class="progress progress-striped">
                              <div class="progress-bar progress-bar-info" role="progressbar"
                                   aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
                                   style="width: 87%">
                                  <span class="sr-only">87% Complete</span>
                              </div>
                          </div>
                      </a></li>
                      <li><a href="#">
                          <div class="task-info">
                              <div class="desc">Mobile App</div>
                              <div class="percent">33%</div>
                          </div>
                          <div class="progress progress-striped">
                              <div class="progress-bar progress-bar-danger"
                                   role="progressbar" aria-valuenow="80" aria-valuemin="0"
                                   aria-valuemax="100" style="width: 33%">
                                  <span class="sr-only">33% Complete (danger)</span>
                              </div>
                          </div>
                      </a></li>
                      <li><a href="#">
                          <div class="task-info">
                              <div class="desc">Dashboard v1.3</div>
                              <div class="percent">45%</div>
                          </div>
                          <div class="progress progress-striped active">
                              <div class="progress-bar" role="progressbar"
                                   aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"
                                   style="width: 45%">
                                  <span class="sr-only">45% Complete</span>
                              </div>
                          </div>

                      </a></li>
                      <li class="external"><a href="#">See All Tasks</a></li>
                  </ul>
              </li>

              <li id="header_inbox_bar" class="dropdown"><a
                      data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
                      class="icon-envelope-alt"></i> <span class="badge bg-important">5</span>
              </a>
                  <ul class="dropdown-menu extended inbox">
                      <div class="notify-arrow notify-arrow-red"></div>
                      <li>
                          <p class="red">You have 5 new messages</p>
                      </li>

                      <li><a href="#">See all messages</a></li>
                  </ul>
              </li>

              <li id="header_notification_bar" class="dropdown"><a
                      data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
                      class="icon-bell-alt"></i> <span class="badge bg-warning">7</span>
              </a>
                  <ul class="dropdown-menu extended notification">
                      <div class="notify-arrow notify-arrow-yellow"></div>
                      <li>
                          <p class="yellow">You have 7 new notifications</p>
                      </li>
                      <li><a href="#"> <span class="label label-danger"><i
                              class="icon-bolt"></i></span> Server #3 overloaded. <span
                              class="small italic">34 mins</span>
                      </a></li>
                      <li><a href="#"> <span class="label label-warning"><i
                              class="icon-bell"></i></span> Server #10 not respoding. <span
                              class="small italic">1 Hours</span>
                      </a></li>
                      <li><a href="#"> <span class="label label-danger"><i
                              class="icon-bolt"></i></span> Database overloaded 24%. <span
                              class="small italic">4 hrs</span>
                      </a></li>
                      <li><a href="#"> <span class="label label-success"><i
                              class="icon-plus"></i></span> New user registered. <span
                              class="small italic">Just now</span>
                      </a></li>
                      <li><a href="#"> <span class="label label-info"><i
                              class="icon-bullhorn"></i></span> Application error. <span
                              class="small italic">10 mins</span>
                      </a></li>
                      <li><a href="#">See all notifications</a></li>
                  </ul>
              </li>

          </ul>

          </div>
        -->
        <div class="top-nav ">
            <!--search & user info start-->
            <ul class="nav pull-right top-menu">
                <!--
                <li><input type="text" class="form-control search"
                           placeholder="Search"></li>
                -->
                <!-- user login dropdown start-->
                <c:if test="${not empty sysUserVo}">
                    <li class="dropdown"><a data-toggle="dropdown"
                                            class="dropdown-toggle" href="#"> <img alt=""
                                                                                   src="${ctx}/staticAdmin/img/avatar1_small.jpg">
                        <span
                                class="username">${sysUserVo.name}</span> <b class="caret"></b>
                    </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="log-arrow-up"></div>
                            <li><a href="javascript:void(0);">用户身份：
                                <c:if test="${sysUserVo.type==1}">
                                    应用管理员</c:if>
                                <c:if test="${sysUserVo.type==0}">
                                    超级管理员</c:if>
                            </a></li>
                            <!--<li class="divider"></li>-->
                            <li><a href="${ctx}/login"><i class="icon-key"></i>退出</a></li>
                        </ul>
                    </li>
                </c:if>
                <!-- user login dropdown end -->
            </ul>
            <!--search & user info end-->
        </div>
    </header>
    <!--header end-->
    <!--sidebar start-->
    <aside>
        <div id="sidebar" class="nav-collapse " tabindex="5000" style="overflow: hidden; outline: none;">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">
                <li class="active"><a class="active" href="${ctx}/sysUser/index" target="main"> <i
                        class="icon-user"></i> <span>用户管理</span>
                </a></li>
                <li class="sub-menu dcjq-parent-li">
                    <a href="javascript:;" class="dcjq-parent">
                        <i class="icon-th"></i>
                        <span>文章管理</span></a>
                    <ul class="sub">
                        <c:if test="${not empty sysUserVo}">
                            <c:if test="${sysUserVo.type==0}">
                                <li><a class="" href="${ctx}/newsType/index" target="main">类型管理</a></li>
                            </c:if>
                        </c:if>
                        <li><a class="" href="${ctx}/news/index" target="main">文章管理</a></li>
                    </ul>
                </li>
                <c:forEach items="${sysMenus}" var="s">
                    <li class="sub-menu dcjq-parent-li">
                        <c:if test="${not empty s.p_url}">
                        <a href="${ctx}/${s.p_url}/list" class="dcjq-parent" target="main">
                            </c:if>
                            <c:if test="${empty s.p_url}">
                            <a href="javascript:;" class="dcjq-parent">
                                </c:if>
                                <i class="${s.p_icon}"></i>
                                <span>${s.p_name}</span>
                                <c:if test="${not empty s.fmenus}">
                                    <span class="dcjq-icon"></span>
                                </c:if>
                            </a>
                            <c:if test="${not empty s.fmenus}">
                            <ul class="sub">
                                <c:forEach items="${s.fmenus}" var="f">
                                    <li><a class="" href="${ctx}/${f.p_url}/list" target="main">${f.p_name}</a></li>
                                </c:forEach>
                            </ul>
                            </c:if>
                    </li>
                </c:forEach>

            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->
    <section id="main-content">
        <iframe src="${ctx}/home" id="ifm" name="main" width="100%" height="100%" frameborder="0"></iframe>
    </section>
</section>
<!-- js placed at the end of the document so the pages load faster -->
<jsp:include page="common/js.jsp"/>
<div class="row">
    <div class="col-lg-12">
        欢迎登陆
    </div>
</div>
<script>
    //owl carousel
    document.getElementById("main-content").style.height = (document.documentElement.clientHeight - 5) + "px";
    $(document).ready(function () {
        $('#sidebar a').click(function () {
            $(this).parent().each(function () {//移除其余非点中状态
                $('#sidebar li').removeClass("active");
            });
            $(this).parents('li').addClass("active");//给所点中的增加样式
        })
    });
</script>

</body>
</html>