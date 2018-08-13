<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="main-header">
      <!-- Logo -->
      <a href="index.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels 收缩菜单后logo显示-->
        <span class="logo-mini">管理</span>
        <!-- logo for regular state and mobile devices 展开菜单后logo显示 -->
        <span class="logo-lg">进销存管理系统</span>
      </a>
      <!-- Header Navbar: style can be found in header.less  顶部导航-->
      <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button 左側菜单收缩按钮-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
          <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <!-- User Account: style can be found in dropdown.less  用户信息展示-->
            <li class="dropdown user user-menu">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <img src="<%=basePath%>dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                <span class="hidden-xs">赵欢欢</span>
              </a>
              <ul class="dropdown-menu">
                <!-- User image -->
                <li class="user-header">
                  <img src="<%=basePath%>dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                  <p>
                 		  赵欢欢 - 网站设计师
                    <small>2017年03月22日</small>
                  </p>
                </li>
                <!-- Menu Footer-->
                <li class="user-footer">
                  <div class="pull-left">
                    <a href="#" class="btn btn-default btn-flat">修改密码</a>
                  </div>
                  <div class="pull-right">
                    <a href="/logout" class="btn btn-default btn-flat">退出登录</a>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
    </header>