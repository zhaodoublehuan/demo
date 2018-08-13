<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less 左侧菜单内容-->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less 菜单详情ul-->
      <ul class="sidebar-menu">
          <%@include file="recursive.jsp"%>
      </ul>
    </section>
    <!-- /.sidebar -->
</aside>