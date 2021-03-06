<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <meta charset="utf-8">
    <title>库存管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
    <%--    <script src="${pageContext.request.contextPath}/js/goods.js"></script>--%>
    <%--    <script src="${pageContext.request.contextPath}/js/user.js"></script>--%>
    <%--    <script src="${pageContext.request.contextPath}/js/goodsIn.js"></script>--%>
    <%--    <script src="${pageContext.request.contextPath}/js/goodsOut.js"></script>--%>
    <%--    <script src="${pageContext.request.contextPath}/js/pages.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/timeout.js"></script>

</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box-header with-border">
    <h3 class="box-title">出库管理</h3>
</div>
<div class="box-body">
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-left">
        <div class="has-feedback">
            <form action="${pageContext.request.contextPath}/goodsOut/search" method="post">
                <input name="id" value="${search.id}" placeholder="请输入库单id">&nbsp&nbsp&nbsp&nbsp
                <input name="no" value="${search.no}" placeholder="请输入单据凭证">&nbsp&nbsp&nbsp&nbsp
                <input class="btn btn-default btn-info" type="submit" value="查询">
            </form>
        </div>
    </div>
    <%--新增按钮：如果当前登录用户是管理员，页面展示新增按钮--%>
    <div class="pull-right">
        <div class="form-group form-inline">
            <div class="btn-group">
                <c:if test="${USER.role =='admin'}">
                    <button type="button" class="btn btn-success btn-block" title="新建" data-toggle="modal"
                            data-target="#addGoodsOutModal" onclick="resetGoodsOutFrom('${USER.name}')"><i
                            class="fa fa-file-o"></i>新增
                    </button>
                </c:if>
                <c:if test="${USER.role =='common'}">
                    <button type="button" class="btn btn-success btn-block" onclick="commonUser()">新增</button>
                </c:if>
            </div>
        </div>
    </div>
    <!-- 数据列表 -->
    <div class="table-box">
        <!-- 数据表格 -->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
            <thead>
            <tr>
                <%--                <th class="sorting_asc">出库id</th>--%>
                <th class="sorting">单据凭证</th>
                <th class="sorting">出库仓库</th>
                <th class="sorting">出库时间</th>
                <th class="sorting">经办人</th>
                <th class="sorting">去向</th>
                <th class="sorting">出库单状态</th>
                <th class="sorting">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageResult.rows}" var="goodsOut">
                <tr>
                        <%--                    <td>${goodsOut.id}</td>--%>
                    <td>
                        <c:if test="${goodsOut.delete == 0}">
                            <a href="${pageContext.request.contextPath}/goodsDetail/searchOutDetail?gioid=${goodsOut.id}"
                               target="iframe">
                                <i class="fa fa-circle-o"></i>${goodsOut.no}
                            </a>
                        </c:if>
                        <c:if test="${goodsOut.delete == 1}">
                            ${goodsOut.no}
                        </c:if>
                    </td>
                    <td>${goodsOut.library}</td>
                    <td>${goodsOut.datetime}</td>
                    <td>${goodsOut.operator }</td>
                    <td>${goodsOut.send}</td>
                    <td>
                        <c:if test="${goodsOut.delete == 0}">正常</c:if>
                        <c:if test="${goodsOut.delete == 1}">禁用</c:if>
                    </td>
                    <td class="text-center">
                        <c:if test="${goodsOut.delete == 0 }">
                            <c:if test="${USER.role =='admin'}">
                                <button type="button" class="btn btn-primary btn-xs" data-toggle="modal"
                                        data-target="#updateGoodsOutModal" onclick="findGoodsOutById(${goodsOut.id})">
                                    修改
                                </button>
                                <button type="button" class="btn btn-danger btn-xs" data-toggle="modal"
                                        data-target="#delGoodsOutModal" onclick="delGoodsOut(${goodsOut.id})"> 删除
                                </button>
                            </c:if>
                            <c:if test="${ USER.role =='common'}">
                                <button type="button" class="btn btn-primary btn-xs" onclick="commonUser()">修改</button>
                                &nbsp&nbsp&nbsp&nbsp
                                <button type="button" class="btn btn-danger btn-xs" onclick="commonUser()">删除</button>
                            </c:if>
                        </c:if>

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
<tm-pagination conf="paginationConf"></tm-pagination>

<!-- 新增出库单 -->
<div class="modal fade" id="addGoodsOutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">出库单信息</h3>
            </div>
            <div class="modal-body">
                <form id="addGoodsOut">
                    <span><input type="hidden" id="addid" name="id"></span>
                    <table id="addGoodsOutTab" class="table table-bordered table-striped" width="800px">
                        <%--入库单的id,不展示在页面--%>
                        <tr>
                            <td>单据编号</td>
                            <td><input class="form-control" readonly name="no" id="gono"
                                       onblur="checkGoodsOutVal()" onfocus="changeGoodsOutVal()"></td>
                            <td>出库仓库</td>
                            <td>
                                <select class="form-control" placeholder="所属仓库" name="library" id="golibrary"
                                        onblur="checkGoodsOutVal()" onfocus="changeGoodsOutVal()">
                                    <option value="第一仓库">第一仓库</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>经办人</td>
                            <td><input class="form-control" placeholder="经办人" name="operator" id="gooperator"
                                       onblur="checkGoodsOutVal()" onfocus="changeGoodsOutVal()"></td>
                            <td>去向</td>
                            <td><input class="form-control" placeholder="去向" name="send" id="gosend"
                                       onblur="checkGoodsOutVal()" onfocus="changeGoodsOutVal()"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red" id="addGoodsOutmsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" <%--aria-hidden="true"--%> id="saveGoodsOutmsg"
                        disabled="true"
                        onclick="saveGoodsOut()">保存
                </button>
                <button class="btn btn-default btn-danger" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 编辑出库单 -->
<div class="modal fade" id="updateGoodsOutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabe2">出库单信息</h3>
            </div>
            <div class="modal-body">
                <form id="updateGoodsOut">
                    <table id="updateGoodsOutTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <%--                            <td>出库序号</td>--%>
                            <td><input class="form-control" type="hidden" readonly type="hidden" name="id" id="upgoid">
                            </td>
                            <%--                            <td>出库时间</td>--%>
                            <td><input class="form-control" type="hidden" readonly name="time" id="upgotime"></td>
                        </tr>
                        <tr>
                            <td>单据编号</td>
                            <td><input class="form-control" readonly name="no" id="upgono"></td>
                            <td>出库仓库</td>
                            <td>
                                <select class="form-control" name="library" id="upgolibrary">
                                    <option value="第一仓库">第一仓库</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>经办人</td>
                            <td><input class="form-control" name="operator" id="upgooperator"
                                       onblur="checkGoodsOutVal2()" onfocus="changeGoodsOutVal2()"></td>
                            <td>去向</td>
                            <td><input class="form-control" name="send" id="upgosend"
                                       onblur="checkGoodsOutVal2()" onfocus="changeGoodsOutVal()"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red" id="upaddGoodsOutmsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="upsaveGoodsOutmsg"
                        disabled="true"
                        onclick="updateGoodsOut()">保存
                </button>
                <button class="btn btn-default btn-danger" data-dismiss="modal" aria-hidden="true">关闭</button>
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
    goodsOutVO.id = "${search.id}"
    goodsOutVO.no = "${search.no}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>