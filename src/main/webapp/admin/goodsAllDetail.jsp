<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>入库明细管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <%--    <script src="${pageContext.request.contextPath}/js/my.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/goods.js"></script>
    <script src="${pageContext.request.contextPath}/js/user.js"></script>
    <script src="${pageContext.request.contextPath}/js/goodsIn.js"></script>
    <script src="${pageContext.request.contextPath}/js/goodsOut.js"></script>
    <script src="${pageContext.request.contextPath}/js/pages.js"></script>
    <script src="${pageContext.request.contextPath}/js/timeout.js"></script>

</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box-header with-border">
    <h3 class="box-title">所有明细</h3>
</div>

<div class="box-body">
    <%--新增按钮：如果当前登录用户是管理员，页面展示新增按钮--%>
    <%--    <div class="pull-left">--%>
    <%--        <div class="form-group form-inline">--%>
    <%--            <div class="btn-group">--%>
    <%--                <c:if test="${USER.role =='admin'}">--%>
    <%--                    <button type="button" class="btn btn-default" title="新建" data-toggle="modal"--%>
    <%--                            data-target="#addGoodsInDetailModal" onclick="resetGoodsInDetailFrom()"><i--%>
    <%--                            class="fa fa-file-o"></i>新增--%>
    <%--                    </button>--%>
    <%--                </c:if>--%>
    <%--                <c:if test="${USER.role =='common'}">--%>
    <%--                    <button type="button" class="btn btn-default" onclick="commonUser()">新增</button>--%>
    <%--                </c:if>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <%--新增按钮 /--%>
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-right">
        <div class="has-feedback">
            <form action="${pageContext.request.contextPath}/goodsDetail/searchAll" method="post">
                入库明细id：<input name="iid" value="${searchAllDetail.iid}">&nbsp&nbsp&nbsp&nbsp
                货物名称：<input name="name" value="${searchAllDetail.name}">&nbsp&nbsp&nbsp&nbsp
                货号：<input name="no" value="${searchAllDetail.no}">&nbsp&nbsp&nbsp&nbsp
                <%--                明细类型：<input name="type" value="${searchAllDetail.type}"placeholder="0为出库 1为入库">&nbsp&nbsp&nbsp&nbsp--%>
                明细类型：
                <select name="type" value="${searchAllDetail.type}" style="width: 200px;font-size: 18px">
                    <option value="1">入库明细</option>
                    <option value="0">出库明细</option>
                    <option value="">不做选择</option>
                </select>&nbsp&nbsp&nbsp&nbsp


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
<%--                <th class="sorting_asc">明细id</th>--%>
<%--                <th class="sorting_asc">货物id</th>--%>
<%--                <th class="sorting_asc">外键id</th>--%>
                <th class="sorting">货物名称</th>
                <th class="sorting">货物货号</th>
                <th class="sorting">货物色号</th>
                <th class="sorting">货物尺码</th>
                <th class="sorting">货物数量</th>
                <th class="sorting">明细类型</th>
                <th class="sorting">货物状态</th>
                <%--                <th class="sorting">操作</th>--%>
                <%--                <th>${searchInDetail.gioid}</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageResult3.rows}" var="goodsAllDetail">
                <tr>
<%--                    <td>${goodsAllDetail.iid}</td>--%>
<%--                    <td>${goodsAllDetail.did}</td>--%>
<%--                    <td>${goodsAllDetail.gioid}</td>--%>
                    <td>${goodsAllDetail.name}</td>
                    <td>${goodsAllDetail.no}</td>
                    <td>${goodsAllDetail.color}</td>
                    <td>${goodsAllDetail.size }</td>
                    <td>${goodsAllDetail.amount}</td>
                    <td>
                        <c:if test="${goodsAllDetail.type == 1}">入库明细</c:if>
                        <c:if test="${goodsAllDetail.type == 0}">出库明细</c:if>
                    </td>
                    <td>
                        <c:if test="${goodsAllDetail.delete == 0}">正常</c:if>
                        <c:if test="${goodsAllDetail.delete == 1}">禁用</c:if>
                    </td>
                        <%--                    <td class="text-center">--%>
                        <%--                        <c:if test="${goodsInDetail.delete == 0 }">--%>
                        <%--                            <c:if test="${USER.role =='admin'}">--%>
                        <%--                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"--%>
                        <%--                                        data-target="#updateGoodsDetailModal"--%>
                        <%--                                        onclick="findGoodsInDetailById(${goodsInDetail.iid})"> 修改--%>
                        <%--                                </button>--%>
                        <%--                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"--%>
                        <%--                                        data-target="#delGoodsDetailModal"--%>
                        <%--                                        onclick="delGoodsInDetail(${goodsInDetail.iid})"> 删除--%>
                        <%--                                </button>--%>
                        <%--                            </c:if>--%>
                        <%--                            <c:if test="${ USER.role =='common'}">--%>
                        <%--                                <button type="button" class="btn bg-olive btn-xs" onclick="commonUser()">修改</button>--%>
                        <%--                                &nbsp&nbsp&nbsp&nbsp--%>
                        <%--                                <button type="button" class="btn bg-olive btn-xs" onclick="commonUser()">删除</button>--%>
                        <%--                            </c:if>--%>
                        <%--                        </c:if>--%>
                        <%--                    </td>--%>
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


</body>
<script>
    /*分页插件展示的总页数*/
    pageargs.total = Math.ceil(${pageResult3.total}/pageargs.pagesize);
    /*分页插件当前的页码*/
    pageargs.cur = ${pageNum}
        /*分页插件页码变化时将跳转到的服务器端的路径*/
        pageargs.gourl = "${gourl}"
    /*保存搜索框中的搜索条件，页码变化时携带之前的搜索条件*/
    goodsAllDetailVO.id = "${searchAllDetail.iid}"
    goodsAllDetailVO.no = "${searchAllDetail.no}"
    goodsAllDetailVO.name = "${searchAllDetail.name}"
    goodsAllDetailVO.type = "${searchAllDetail.type}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>