<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>出库明细管理</title>
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
    <h3 class="box-title">出库明细管理</h3>
</div>

<div class="box-body">
    <%--新增按钮：如果当前登录用户是管理员，页面展示新增按钮--%>
    <div class="pull-left">
        <div class="form-group form-inline">
            <div class="btn-group">
                <c:if test="${USER.role =='admin'}">
                    <button type="button" class="btn btn-default" title="新建" data-toggle="modal"
                            data-target="#addGoodsOutDetailModal" onclick="resetGoodsOutDetailFrom()"><i
                            class="fa fa-file-o"></i>新增
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
            <form action="${pageContext.request.contextPath}/goodsDetail/searchOutDetail?gioid=${searchOutDetail.gioid}" method="post">
                出库明细id：<input name="iid" value="${searchOutDetail.iid}">&nbsp&nbsp&nbsp&nbsp
                货物名称：<input name="name" value="${searchOutDetail.name}">&nbsp&nbsp&nbsp&nbsp
                货号：<input name="no" value="${searchOutDetail.no}">&nbsp&nbsp&nbsp&nbsp
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
                <th class="sorting_asc">明细id</th>
                <th class="sorting_asc">货物id</th>
                <th class="sorting_asc">外键id</th>
                <th class="sorting">货物名称</th>
                <th class="sorting">货物货号</th>
                <th class="sorting">货物色号</th>
                <th class="sorting">货物尺码</th>
                <th class="sorting">货物数量</th>
                <th class="sorting">货物状态</th>
                <th class="sorting">操作</th>
                <%--                <th>${searchInDetail.gioid}</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageResult2.rows}" var="goodsOutDetail">
                <tr>
                    <td>${goodsOutDetail.iid}</td>
                    <td>${goodsOutDetail.did}</td>
                    <td>${goodsOutDetail.gioid}</td>
                    <td>${goodsOutDetail.name}</td>
                    <td>${goodsOutDetail.no}</td>
                    <td>${goodsOutDetail.color}</td>
                    <td>${goodsOutDetail.size }</td>
                    <td>${goodsOutDetail.amount}</td>

                    <td>
                        <c:if test="${goodsOutDetail.delete == 0}">正常</c:if>
                        <c:if test="${goodsOutDetail.delete == 1}">禁用</c:if>
                    </td>
                    <td class="text-center">
                        <c:if test="${goodsOutDetail.delete == 0 }">
                            <c:if test="${USER.role =='admin'}">
                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                                        data-target="#updateGoodsOutDetailModal"
                                        onclick="findGoodsOutDetailById(${goodsOutDetail.iid})"> 修改
                                </button>
                                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                                        data-target="#delGoodsOutDetailModal"
                                        onclick="delGoodsOutDetail(${goodsOutDetail.iid})"> 删除
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

<!-- 新增货物 -->
<div class="modal fade" id="addGoodsOutDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">入库明细信息</h3>
            </div>
            <div class="modal-body">
                <form id="addGoodsOutDetail">
                    <span><input type="hidden" id="ebid" name="id"></span>
                    <table id="addGoodsOutDetailModalTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>入库物品</td>
                            <td>
                                <select class="form-control" id="godname" name="name" onblur="checkGoodsOutDetailVal()"
                                        onfocus="changeGoodsOutDetail()">
                                    <option value="" disabled="disabled" selected="selected">--请选择--</option>
                                    <c:forEach items="${GOODS}" var="goods">
                                        <option value="${goods.id}">${goods.name} / ${goods.size}
                                            / ${goods.color}</option>
                                    </c:forEach>
                                </select>
                            </td>

                        </tr>
                        <%--                        <tr>--%>
                        <%--                            <td>货物数量</td>--%>
                        <%--                            <td>--%>
                        <%--                                <input class="form-control" placeholder="货物数量" name="amount" id="gidamount" value="0"--%>
                        <%--                                       onblur="checkGoodsVal()" onfocus="changeGoodsVal()">--%>
                        <%--                            </td>--%>
                        <%--                        </tr>--%>
                        <tr>
                            <td colspan="2"><span style="color: red" id="addGoodsOutDetailmsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <%--                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"--%>
                <%--                        data-target="#updateGoodsModal" onclick="findGoodsById(${goods.id})"> 修改--%>
                <%--                </button>--%>
                <button class="btn btn-success" data-toggle="modal" data-target="#enAddGoodsOutDetailModal"
                        id="saveGoodsOutDetailmsg"
                        disabled="true"
                        onclick="saveGoodsOutDetail(${searchOutDetail.gioid})">确定
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 确认货物 -->
<div class="modal fade" id="enAddGoodsOutDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel2">确认入库明细信息</h3>
            </div>
            <div class="modal-body">
                <form id="enAddGoodsOutDetail">
                    <span><input type="hidden" id="enobid" name="iid"></span>
                    <table id="enAddGoodsOutDetailTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>出库id</td>
                            <td><input class="form-control" readonly name="gioid" id="engooid"></td>
                            <td>货物id</td>
                            <td><input class="form-control" readonly name="did" id="engodid"></td>
                        </tr>
                        <tr>
                            <td>货物货号</td>
                            <td><input class="form-control" readonly name="no" id="engodno"></td>
                            <td>货物名称</td>
                            <td><input class="form-control" readonly name="name" id="engodname"></td>
                        </tr>
                        <tr>
                            <td>色号</td>
                            <td><input class="form-control" readonly name="color" id="engodcolor"></td>
                            <td>尺码</td>
                            <td><input class="form-control" readonly name="size" id="engodsize"></td>
                        </tr>
                        <tr>
                            <td>类型</td>
                            <td><input class="form-control" readonly name="type" id="engodtype"></td>
                            <td>货物数量</td>
                            <td><input class="form-control" name="amount" id="engodamount"
                                       onblur="checkGoodsOutDetailVal2()" onfocus="changeGoodsOutDetail2()"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red"></span></td>
                            <td colspan="2"><span style="color: red" id="enaddGoodsOutDetailmsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">

                <button class="btn btn-success" data-dismiss="modal" <%--aria-hidden="true"--%>
                        id="ensaveGoodsOutDetailmsg"
                        disabled="true"
                        onclick="enSaveGoodsOutDetail(${searchOutDetail.gioid})">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 编辑货物 -->
<div class="modal fade" id="updateGoodsOutDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabe2">出库单信息</h3>
            </div>
            <div class="modal-body">
                <form id="updateGoodsOutDetail">
                    <span><input type="hidden" id="upid" name="iid"></span>
                    <table id="updateGoodsOutDetailTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>入库id</td>
                            <td><input class="form-control" readonly name="gioid" id="upengooid"></td>
                            <td>货物id</td>
                            <td><input class="form-control" readonly name="did" id="upengodid"></td>
                        </tr>
                        <tr>
                            <td>货物货号</td>
                            <td><input class="form-control" readonly name="no" id="upengodno"></td>
                            <td>货物名称</td>
                            <td><input class="form-control" readonly name="name" id="upengodname"></td>
                        </tr>
                        <tr>
                            <td>色号</td>
                            <td><input class="form-control" readonly name="color" id="upengodcolor"></td>
                            <td>尺码</td>
                            <td><input class="form-control" readonly name="size" id="upengodsize"></td>
                        </tr>
                        <tr>
                            <td>类型</td>
                            <td><input class="form-control" readonly name="type" id="upengodtype"></td>
                            <td>货物数量</td>
                            <td><input class="form-control" name="amount" id="upengodamount"
                            onblur="checkGoodsOutDetailVal3()" onfocus="changeGoodsOutDetail3()"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red"></span></td>
                            <td colspan="2"><span style="color: red" id="upaddGoodsOutDetailmsg"></span></td>
                        </tr>

                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true"id="upsaveGoodsOutDetailmsg"
                        disabled="true" onclick="updateGoodsOutDetail(${searchOutDetail.gioid})">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    /*分页插件展示的总页数*/
    pageargs.total = Math.ceil(${pageResult2.total}/pageargs.pagesize);
    /*分页插件当前的页码*/
    pageargs.cur = ${pageNum}
        /*分页插件页码变化时将跳转到的服务器端的路径*/
        pageargs.gourl = "${gourl}"
    /*保存搜索框中的搜索条件，页码变化时携带之前的搜索条件*/
    goodsOutDetailVO.id = "${searchOutDetail.iid}"
    goodsOutDetailVO.name = "${searchOutDetail.name}"
    goodsOutDetailVO.no = "${searchOutDetail.no}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>