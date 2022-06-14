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
</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box-header with-border">
    <h3 class="box-title">入库管理</h3>
</div>
<div class="box-body">
    <%--新增按钮：如果当前登录用户是管理员，页面展示新增按钮--%>
    <div class="pull-left">
        <div class="form-group form-inline">
            <div class="btn-group">
                <c:if test="${USER.role =='admin'}">
                    <button type="button" class="btn btn-default" title="新建" data-toggle="modal"
                            data-target="#addGoodsInModal" onclick="resetGoodsInFrom()"><i class="fa fa-file-o"></i>新增
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
            <form action="${pageContext.request.contextPath}/goodsIn/search" method="post">
                入库id：<input name="id" value="${search.id}">&nbsp&nbsp&nbsp&nbsp
                单据凭证：<input name="no" value="${search.no}">&nbsp&nbsp&nbsp&nbsp
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
                <th class="sorting_asc">入库id</th>
                <th class="sorting">单据凭证</th>
                <th class="sorting">入库仓库</th>
                <th class="sorting">入库时间</th>
                <th class="sorting">经办人</th>
                <th class="sorting">来源</th>
                <th class="sorting">入库单状态</th>
                <th class="sorting">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageResult.rows}" var="goodsIn">
                <tr>
                    <td>${goodsIn.id}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/goodsDetail/searchInDetail?gioid=${goodsIn.id}"
                           target="iframe">
                            <i class="fa fa-circle-o"></i>${goodsIn.no}
                        </a>
                    </td>
                        <%--                    <td><a href="${pageContext.request.contextPath}/goodsDetail/searchInDetail" target="iframe">${goodsIn.no}</a> </td>--%>
                    <td>${goodsIn.library}</td>
                    <td>${goodsIn.datetime}</td>
                    <td>${goodsIn.operator }</td>
                    <td>${goodsIn.source}</td>
                    <td>
                        <c:if test="${goodsIn.delete == 0}">正常</c:if>
                        <c:if test="${goodsIn.delete == 1}">禁用</c:if>
                    </td>
                    <td class="text-center">
                        <c:if test="${goodsIn.delete == 0 }">
                            <c:if test="${USER.role =='admin'}">
                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                                        data-target="#updateGoodsInModal" onclick="findGoodsInById(${goodsIn.id})"> 修改
                                </button>
                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                                        data-target="#delGoodsInModal" onclick="delGoodsIn(${goodsIn.id})"> 删除
                                </button>
                            </c:if>
                            <c:if test="${ USER.role =='common'}">
                                <button type="button" class="btn bg-olive btn-xs" onclick="commonUser()">修改</button>
                                &nbsp&nbsp&nbsp&nbsp
                                <button type="button" class="btn bg-olive btn-xs" onclick="commonUser()">删除</button>
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

<!-- 新增入库单 -->
<div class="modal fade" id="addGoodsInModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">入库单信息</h3>
            </div>
            <div class="modal-body">
                <form id="addGoodsIn">
                    <span><input type="hidden" id="addid" name="id"></span>
                    <table id="addGoodsInTab" class="table table-bordered table-striped" width="800px">
                        <%--入库单的id,不展示在页面--%>
                        <tr>
                            <td>单据编号</td>
                            <td><input class="form-control"  readonly name="no" id="gino"
                                       onblur="checkGoodsInVal()" onfocus="changeGoodsInVal()"></td>
                            <td>入库仓库</td>
                            <td>
                                <select class="form-control" placeholder="所属仓库" name="library" id="gilibrary"
                                        onblur="checkGoodsInVal()" onfocus="changeGoodsInVal()">
                                    <option value="第一仓库">第一仓库</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>经办人</td>
                            <td><input class="form-control" placeholder="经办人" name="operator" id="gioperator"
                                       onblur="checkGoodsInVal()" onfocus="changeGoodsInVal()"></td>
                            <td>来源</td>
                            <td><input class="form-control" placeholder="来源" name="source" id="gisource"
                                       onblur="checkGoodsInVal()" onfocus="changeGoodsInVal()"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red" id="addGoodsInmsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" <%--aria-hidden="true"--%> id="saveGoodsInmsg"
                        disabled="true"
                        onclick="saveGoodsIn()">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 编辑入库单 -->
<div class="modal fade" id="updateGoodsInModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabe2">入库单信息</h3>
            </div>
            <div class="modal-body">
                <form id="updateGoodsIn">
                    <%--                    <span><input type="hidden" id="ubid" name="id"></span>--%>
                    <table id="updateGoodsInTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>入库序号</td>
                            <td><input class="form-control" readonly name="id" id="upgiid"></td>
                            <td>单据编号</td>
                            <td><input class="form-control" readonly name="no" id="upgino"></td>
                        </tr>
                        <tr>
                            <td>入库时间</td>
                            <td><input class="form-control" readonly name="time" id="upgitime"></td>
                            <%--                            <input type="date" class="form-control" name="clothes.goodsIn" value="<fmt:formatDate value="upgitime" pattern="yyyy-MM-dd" />">--%>

                            <td>入库仓库</td>
                            <td>
                                <select class="form-control" name="library" id="upgilibrary">
                                    <option value="第一仓库">第一仓库</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>经办人</td>
                            <td><input class="form-control" name="operator" id="upgioperator"></td>
                            <td>来源</td>
                            <td><input class="form-control" name="source" id="ugsource"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" onclick="updateGoodsIn()">保存
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
    goodsInVO.id = "${search.id}"
    goodsInVO.no = "${search.no}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>