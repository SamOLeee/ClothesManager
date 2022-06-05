<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>货号管理</title>
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
    <h3 class="box-title">货号管理</h3>
</div>
<div class="box-body">
    <%--新增按钮：如果当前登录用户是管理员，页面展示新增按钮--%>

        <div class="pull-left">
            <div class="form-group form-inline">
                <div class="btn-group">
                    <c:if test="${USER.role =='admin'}">
                    <button type="button" class="btn btn-default" title="新建" data-toggle="modal"
                            data-target="#addOrEditModal" onclick="resetFrom()"> 新增
                    </button>
                    </c:if>
                    <c:if test="${USER.role =='common'}">
                        <button type="button" class="btn btn-default" onclick="commonUser()">新增</button>
                    </c:if>
                </div>
            </div>
        </div>

    <%--新增按钮 /--%>
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-right">
        <div class="has-feedback">
            <form action="${pageContext.request.contextPath}/goods/search" method="post">
                货物id：<input name="id" value="${search.id}">&nbsp&nbsp&nbsp&nbsp
                货物名称：<input name="name" value="${search.name}">&nbsp&nbsp&nbsp&nbsp
                货号：<input name="no" value="${search.no}">&nbsp&nbsp&nbsp&nbsp
                <input class="btn btn-default" type="submit" value="查询">
            </form>
        </div>
    </div>
    <!--工具栏 数据搜索 /-->
    <!-- 数据列表 -->
    <div class="table-box">
        <!-- 数据表格 -->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
            <thead>
            <tr>
                <th class="sorting_asc">货物id</th>
                <th class="sorting">货物名称</th>
                <th class="sorting">货物货号</th>
                <th class="sorting">货物色号</th>
                <th class="sorting">货物尺码</th>
                <th class="sorting">货物数量</th>
                <th class="sorting">货物状态</th>
                <th class="sorting">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageResult.rows}" var="goods">
                <tr>
                    <td>${goods.id}</td>
                    <td>${goods.name}</td>
                    <td>${goods.no}</td>
                    <td>${goods.color}</td>

                    <td>${goods.size }</td>
                    <td>${goods.amount}</td>
                    <td>
                        <c:if test="${goods.delete == 0}">正常</c:if>
                        <c:if test="${goods.delete == 1}">禁用</c:if>
                    </td>
                    <td class="text-center">
                        <c:if test="${goods.delete == 0 }">
                            <c:if test="${USER.role =='admin'}">
                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                                        data-target="#borrowModal" onclick="findBookById(${goods.id},'borrow')"> 修改
                                </button>
                                <%--                            <c:if test="${USER.role =='admin'}">--%>
                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                                        data-target="#addOrEditModal" onclick="findBookById(${goods.id},'edit')"> 删除
                                </button>
                            </c:if>

                            <%--                            </c:if>--%>
                            <c:if test="${ USER.role =='common'}">
                                <button type="button" class="btn bg-olive btn-xs" onclick="commonUser()">修改</button>
                                &nbsp&nbsp&nbsp&nbsp
                                <button type="button" class="btn bg-olive btn-xs" onclick="commonUser()">删除</button>
                            </c:if>
                        </c:if>
                            <%--                        <c:if test="${book.status ==1 ||book.status ==2}">
                                                        <button type="button" class="btn bg-olive btn-xs" disabled="true">借阅</button>
                                                    </c:if>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!--数据表格/-->
        <%--分页插件--%>
        <div id="pagination" class="pagination"></div>
    </div>
    <!--数据列表/-->
</div>
<!-- /.box-body -->
<%--引入存放模态窗口的页面--%>
<jsp:include page="/admin/book_modal.jsp"></jsp:include>

<!-- 添加和编辑图书的模态窗口 -->
<div class="modal fade" id="addOrEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 id="myModalLabel">图书信息</h3>
            </div>
            <div class="modal-body">
                <form id="addOrEditBook">
                    <span><input type="hidden" id="ebid" name="id"></span>
                    <table id="addOrEditTab" class="table table-bordered table-striped" width="800px">
                        <%--图书的id,不展示在页面--%>
                        <tr>
                            <td>图书名称</td>
                            <td><input class="form-control" placeholder="图书名称" name="name" id="ebname"></td>
                            <td>标准ISBN</td>
                            <td><input class="form-control" placeholder="标准ISBN" name="isbn" id="ebisbn"></td>
                        </tr>
                        <tr>
                            <td>出版社</td>
                            <td><input class="form-control" placeholder="出版社" name="press" id="ebpress"></td>
                            <td>作者</td>
                            <td><input class="form-control" placeholder="作者" name="author" id="ebauthor"></td>
                        </tr>
                        <tr>
                            <td>书籍页数</td>
                            <td><input class="form-control" placeholder="书籍页数" name="pagination" id="ebpagination"></td>
                            <td>书籍价格<br/></td>
                            <td><input class="form-control" placeholder="书籍价格" name="price" id="ebprice"></td>
                        </tr>
                        <tr>
                            <td>上架状态</td>
                            <td>
                                <select class="form-control" id="ebstatus" name="status">
                                    <option value="0">上架</option>
                                    <option value="3">下架</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="aoe" disabled
                        onclick="addOrEdit()">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    /*分页插件展示的总页数*/
    pageargs.total = Math.ceil(${pageResult.total}/pageargs.pagesize);
    /*分页插件当前的页码*/
    pageargs.cur = ${pageNum}
        /*分页插件页码变化时将跳转到的服务器端的路径*/
        pageargs.gourl = "${gourl}"
    /*保存搜索框中的搜索条件，页码变化时携带之前的搜索条件*/
    bookVO.id = "${search.id}"
    bookVO.name = "${search.name}"
    bookVO.no = "${search.no}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>