<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>xxxxx系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/_all-skins.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    <script type="text/javascript">
        function SetIFrameHeight() {
            var iframeid = document.getElementById("iframe");
            if (document.getElementById) {
                /*设置 内容展示区的高度等于页面可视区的高度*/
                iframeid.height = document.documentElement.clientHeight;
            }
        }
    </script>
</head>

<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">
    <!-- 页面头部 -->
    <header class="main-header">
        <!-- Logo -->
        <a href="${pageContext.request.contextPath}/admin/main.jsp" class="logo">
            <span class="logo-lg"><b>xxxxx系统</b></span>
        </a>
        <!-- 头部导航 -->
        <nav class="navbar navbar-static-top">
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a>
                            <img src="${pageContext.request.contextPath}/img/Sauron.jpg" class="user-image"
                                 alt="User Image">
                            <span class="hidden-xs">${USER.name}</span>
                        </a>
                    </li>
                    <li class="dropdown user user-menu">
                        <a href="${pageContext.request.contextPath}/user/logout">
                            <span class="hidden-xs">注销</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li id="admin-index">
                    <a href="main.jsp">
                        <i class="fa fa-dashboard"></i> <span>首页</span>
                    </a>
                </li>
                <!-- 用户管理 -->
                <li id="admin-login">
                    <a href="${pageContext.request.contextPath}/user/search" target="iframe">
                        <i class="fa fa-circle-o"></i>用户管理
                    </a>
                </li>
                <!-- 货号管理 -->
                <li id="goods-manage">
                    <a href="${pageContext.request.contextPath}/goods/search" target="iframe">
                        <i class="fa fa-circle-o"></i>货号管理
                    </a>
                </li>
                <!-- 库存管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-folder"></i>
                        <span>库存管理</span>
                        <span class="pull-right-container">
				       			<i class="fa fa-angle-left pull-right"></i>
				   		 	</span>
                    </a>
                    <ul class="treeview-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/goodsIn/search" target="iframe">
                                <i class="fa fa-circle-o"></i>入库管理
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/book/searchBorrowed" target="iframe">
                                <i class="fa fa-circle-o"></i>出库管理
                            </a>
                        </li>
<%--                        <li>--%>
<%--                            <a href="${pageContext.request.contextPath}/record/searchRecords" target="iframe">--%>
<%--                                <i class="fa fa-circle-o"></i>借阅记录--%>
<%--                            </a>--%>
<%--                        </li>--%>
                    </ul>
                </li>
            </ul>
        </section>

        <!-- /.sidebar -->
    </aside>
    <!-- 导航侧栏 /-->
    <!-- 内容展示区域 -->
    <div class="content-wrapper" >
            <%--<img src="${pageContext.request.contextPath}/img/333.jpg" class="user-image" alt="User Image">--%>
        <iframe  width="100%" id="iframe" name="iframe" onload="SetIFrameHeight()" frameborder="0" >
        </iframe>
    </div>
</div>
</body>
</html>