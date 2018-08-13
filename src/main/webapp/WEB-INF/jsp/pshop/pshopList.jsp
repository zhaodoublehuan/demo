<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>供应商管理</title>
    <%@include file="../common/commonTop.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <!-- 顶部导航 -->
    <%@include file="../common/header.jsp" %>
    <!-- 左侧菜单 -->
    <%@include file="../common/left.jsp" %>
    <!-- 内容信息 -->
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                合作商信息
            </h1>
        </section>
        <section class="content">

            <div class="row">
                <section class="col-lg-12 connectedSortable">
                    <div class="box box-info">
                        <div class="box-header">
                            <button class="btn btn-success" onclick="addShopShow()"><i class="fa fa-fw fa-plus"></i>添加合作商</button>
                        </div>
                        <div class="box-body">
                            <table id="shop_table" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>供应商名称</th>
                                    <th>供应商描述</th>
                                    <th>供应商类型</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>

                </section>
            </div>
            <!-- /.row (main row) -->

        </section>
    </div>
    <%@include file="../common/footer.jsp" %>
</div>
<%@include file="addShop.jsp" %>
<%@include file="updateShop.jsp" %>
<%@include file="../common/commonBottom.jsp" %>
<script src="<%=basePath%>js/shop/shop.js"></script>
</body>
</html>
