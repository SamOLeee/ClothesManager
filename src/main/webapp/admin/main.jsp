<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
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
        <a href="${pageContext.request.contextPath}/goods/getAllGoodsIn" class="logo">
            <span class="logo-lg"><b>xxxxx系统</b></span>
        </a>
        <!-- 头部导航 -->
        <nav class="navbar navbar-static-top">
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <button type="button" class="btn btn-default" title="个人中心" data-toggle="modal"
                                data-target="#UserCenterModal" onclick="resetUserCenterFrom()"><i class="fa fa-file-o"></i>
                            <a>
                                <img src="${pageContext.request.contextPath}/img/Sauron.jpg" class="user-image"
                                     alt="User Image">
                                <span class="hidden-xs">${USER.name}</span>
                            </a>
                        </button>

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
                    <a href="${pageContext.request.contextPath}/goods/getAllGoodsIn">
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
                    <a href="*">
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
                            <a href="${pageContext.request.contextPath}/goodsOut/search" target="iframe">
                                <i class="fa fa-circle-o"></i>出库管理
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/goodsDetail/searchAll" target="iframe">
                                <i class="fa fa-circle-o"></i>所有明细
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </section>

        <!-- /.sidebar -->
    </aside>
    <!-- 导航侧栏 /-->
    <!-- 内容展示区域 -->
    <div class="content-wrapper">
        <%--<img src="${pageContext.request.contextPath}/img/333.jpg" class="user-image" alt="User Image">--%>
        <iframe width="100%" id="iframe" name="iframe" onload="SetIFrameHeight()" frameborder="0">
        </iframe>
    </div>
</div>
<div class="modal fade" id="UserCenterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabe2">个人中心</h3>
            </div>
            <div class="modal-body">
                <form id="UserCenter">
                    <%--                    <span><input type="hidden" id="ubid" name="id"></span>--%>
                    <table id="UserCenterTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>输入密码</td>
                            <td><input class="form-control"  name="pw" id="usrpw" placeholder="输入密码"
                                       onblur="checkUserVal()" onfocus="changeUserVal()"></td>
                        </tr>
                        <tr>
                            <td>再次输入密码</td>
                            <td><input class="form-control"  name="password" id="enusrpw" placeholder="再次输入密码"
                                       onblur="checkUserVal()" onfocus="changeUserVal()"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red" id="addUsermsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="saveUsermsg"
                        disabled="true"
                        onclick="updateUserPwd(${USER.id})">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>