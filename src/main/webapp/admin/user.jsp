<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
</head>
<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box-header with-border">
    <h3 class="box-title">用户管理</h3>
</div>
<div class="box-body">
    <!-- 数据表格 -->
    <div class="table-box">
        <!--工具栏-->
        <div class="pull-left">
            <div class="form-group form-inline">
                <div class="btn-group">
                    <button type="button" class="btn btn-default" title="新建" data-toggle="modal"
                            data-target="#addModal" onclick="resetUserFrom()"><i class="fa fa-file-o"></i> 新增
                    </button>
                </div>
            </div>
        </div>
        <div class="box-tools pull-right">
            <div class="has-feedback">
                <form action="${pageContext.request.contextPath}/user/search" method="post">
                    工号：<input name="id" value="${user.id}">&nbsp&nbsp&nbsp&nbsp
                    姓名：<input name="name" value="${user.name}">&nbsp&nbsp&nbsp&nbsp
                    <input class="btn btn-default" type="submit" value="查询">
                </form>
            </div>
        </div>
    </div>
    <!--工具栏/-->
    <!--数据列表-->
    <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
        <thead>
        <tr class="text-center">
            <th>id号</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>权限</th>
            <th>用户状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageResult.rows}" var="user">
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>
                <c:if test="${user.role eq 'admin'}">管理员</c:if>
                <c:if test="${user.role eq 'common'}">普通</c:if>
            </td>
            <td>
                <c:if test="${user.delete == 1}">已禁用 </c:if>
                <c:if test="${user.delete == 0}">正常</c:if>
            </td>
            <%--                <td>${user.hiredate}</td>--%>
            <%--                <td>--%>
            <%--                    <c:if test="${user.status == 0}">--%>
            <%--                        在职--%>
            <%--                    </c:if>--%>
            <%--                    <c:if test="${user.status == 1}">--%>
            <%--                        已离职--%>
            <%--                    </c:if>--%>

            <%--                </td>--%>
            <td class="text-center">
                <c:if test="${user.delete == 0}">
                    <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal"
                            onclick="findUserById(${user.id})">修改
                    </button>
                    &nbsp&nbsp&nbsp&nbsp
                    <button type="button" class="btn bg-olive btn-xs" onclick="delUser(${user.id})">删除</button>
                </c:if>

            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!--数据列表/-->
    <div id="pagination" class="pagination"></div>
</div>
<!-- 数据表格 /-->
</div>
<!-- /.box-body -->
<tm-pagination conf="paginationConf"></tm-pagination>

<!-- 新增窗口 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">用户信息</h3>
            </div>
            <div class="modal-body">
                <form id="addUser">
                    <table class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>姓名</td>
                            <td><input class="form-control" placeholder="姓名" id="adduname" onblur="checkVal()"
                                       onfocus="changeVal()" name="name"></td>
                            <td>邮箱</td>
                            <td><input class="form-control" placeholder="邮箱" id="adduemail" onblur="checkVal()"
                                       onfocus="changeVal()" name="email"></td>
                        </tr>
                        <tr>
                            <%--<td>入职时间</td>
                            <td><input type="date" class="form-control" name="hiredate" id="time"  onchange="checkVal()"></td>--%>
                            <td>登录密码</td>
                            <td><input class="form-control" placeholder="密码" id="addPw" onblur="checkVal()"
                                       onfocus="changeVal()" name="password"></td>
                            <td>用户权限</td>
                            <td>
                                <select class="form-control" name="role" value="USER">
                                    <option value="common">普通</option>
                                    <option value="admin">管理员</option>
                                </select>
                            </td>
                            <td colspan="2"><span style="color: red" id="addmsg"></span></td>
                        </tr>
                        <%--						<tr>--%>
                        <%--							<td>用户权限</td>--%>
                        <%--							<td>--%>
                        <%--								<select class="form-control" name="role" value="USER">--%>
                        <%--									<option value="USER">普通</option>--%>
                        <%--									<option value="ADMIN">管理员</option>--%>
                        <%--								</select>--%>
                        <%--							</td>--%>
                        <%--                            <td colspan="2"><span style="color: red" id="addmsg"></span></td>--%>
                        <%--						</tr>--%>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" <%--aria-hidden="true"--%> id="savemsg"
                        disabled="true"
                        onclick="saveUser()">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabe2">用户信息</h3>
            </div>
            <div class="modal-body">
                <form id="updateUser">
                    <table class="table table-bordered table-striped" width="800px">

                        <tr>
                            <td>姓名</td>
                            <td><input class="form-control" readonly name="name" id="uname"></td>
                            <td>用户id</td>
                            <td><input class="form-control" readonly name="id" id="uid"></td>
                        </tr>
                        <tr>
                            <td>邮箱</td>
                            <td><input class="form-control" readonly name="email" id="uemail">
                            </td>
                            <%-- <td>入职时间</td>
                             <td><input class="form-control" readonly name="hiredate" id="uhire" ></td>--%>
                        </tr>
                        <tr>
                            <td>密码</td>
                            <td><input class="form-control" type="password" name="password" id="pw"></td>
                            <td>用户权限</td>
                            <td>
                                <select class="form-control" id="urole" name="role">
                                    <option value="common">普通</option>
                                    <option value="admin">管理员</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" onclick="updateUser()">保存</button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    //总页数
    pageargs.total =/*Math.ceil(*/${pageResult.total}/*/pageargs.pagesize)*/
        //当前页数
        pageargs.cur = ${pageNum}
            pageargs.gourl = "${gourl}"
    userVO.id = "${search.id}"
    userVO.name = "${search.name}"
    pagination(pageargs);
</script>
</html>