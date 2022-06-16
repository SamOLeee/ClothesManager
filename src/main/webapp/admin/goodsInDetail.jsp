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
    <h3 class="box-title">入库明细管理</h3>
</div>

<div class="box-body">
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-left">
        <div class="has-feedback">
            <form action="${pageContext.request.contextPath}/goodsDetail/searchInDetail?gioid=${searchInDetail.gioid}" method="post">
                <input name="iid" value="${searchInDetail.iid}" placeholder="请输入明细id">&nbsp&nbsp&nbsp&nbsp
                <input name="name" value="${searchInDetail.name}" placeholder="请输入货物名称">&nbsp&nbsp&nbsp&nbsp
                <input name="no" value="${searchInDetail.no}" placeholder="请输入货号">&nbsp&nbsp&nbsp&nbsp
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
                            data-target="#addGoodsInDetailModal" onclick="resetGoodsInDetailFrom()"><i
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
<%--                <th class="sorting_asc">明细id</th>--%>
<%--                <th class="sorting_asc">货物id</th>--%>
<%--                <th class="sorting_asc">外键id</th>--%>
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
            <c:forEach items="${pageResult.rows}" var="goodsInDetail">
                <tr>
<%--                    <td>${goodsInDetail.iid}</td>--%>
<%--                    <td>${goodsInDetail.did}</td>--%>
<%--                    <td>${goodsInDetail.gioid}</td>--%>
                    <td>${goodsInDetail.name}</td>
                    <td>${goodsInDetail.no}</td>
                    <td>${goodsInDetail.color}</td>
                    <td>${goodsInDetail.size }</td>
                    <td>${goodsInDetail.amount}</td>

                    <td>
                        <c:if test="${goodsInDetail.delete == 0}">正常</c:if>
                        <c:if test="${goodsInDetail.delete == 1}">禁用</c:if>
                    </td>
                    <td class="text-center">
                        <c:if test="${goodsInDetail.delete == 0 }">
                            <c:if test="${USER.role =='admin'}">
                                <button type="button" class="btn btn-primary btn-xs" data-toggle="modal"
                                        data-target="#updateGoodsDetailModal" onclick="findGoodsInDetailById(${goodsInDetail.iid})"> 修改
                                </button>
                                <button type="button" class="btn btn-danger btn-xs" data-toggle="modal"
                                        data-target="#delGoodsDetailModal" onclick="delGoodsInDetail(${goodsInDetail.iid})"> 删除
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

<!-- 新增货物 -->
<div class="modal fade" id="addGoodsInDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">入库明细信息</h3>
            </div>
            <div class="modal-body">
                <form id="addGoodsInDetail">
                    <span><input type="hidden" id="ebid" name="id"></span>
                    <table id="addGoodsInDetailModalTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>入库物品</td>
                            <td>
                                <select class="form-control" id="gidname" name="name" onblur="checkGoodsInDetailVal()" onfocus="changeGoodsInDetail()">
                                    <option value="" disabled="disabled" selected="selected">--请选择--</option>
                                    <c:forEach items="${GOODS}" var="goods" >
                                        <option value="${goods.id}">${goods.name} / ${goods.size} / ${goods.color}</option>
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
                            <td colspan="2"><span style="color: red" id="addGoodsInDetailmsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
<%--                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"--%>
<%--                        data-target="#updateGoodsModal" onclick="findGoodsById(${goods.id})"> 修改--%>
<%--                </button>--%>
                <button class="btn btn-success" data-toggle="modal" data-target="#enAddGoodsInDetailModal" id="saveGoodsInDetailmsg"
                        disabled="true" onclick="saveGoodsInDetail(${searchInDetail.gioid})">确定
                </button>
                <button class="btn btn-default btn-danger" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 确认货物 -->
<div class="modal fade" id="enAddGoodsInDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel2">确认入库明细信息</h3>
            </div>
            <div class="modal-body">
                <form id="enAddGoodsInDetail">
                    <span><input type="hidden" id="enbid" name="iid"></span>
                    <table id="enAddGoodsInDetailTab" class="table table-bordered table-striped" width="800px">
                        <tr type="hidden">
<%--                            <td>入库id</td>--%>
                            <td><input class="form-control" type="hidden" readonly name="gioid" id="engioid"></td>
<%--                            <td>货物id</td>--%>
                            <td><input class="form-control" type="hidden" readonly name="did" id="engidid"></td>
                        </tr>
                        <tr>
                            <td>货物货号</td>
                            <td><input class="form-control" readonly name="no" id="engidno"></td>
                            <td>货物名称</td>
                            <td><input class="form-control" readonly name="name" id="engidname"></td>
                        </tr>
                        <tr>
                            <td>色号</td>
                            <td><input class="form-control" readonly name="color" id="engidcolor" ></td>
                            <td>尺码</td>
                            <td><input class="form-control" readonly name="size" id="engidsize" ></td>
                        </tr>
                        <tr>
                            <td>类型</td>
                            <td><input class="form-control" readonly name="type" id="engidtype" ></td>
                            <td>货物数量</td>
                            <td><input class="form-control" name="amount" id="engidamount"
                                       type="text" maxlength="8"  onkeyup="value=this.value.replace(/\D+/g,'')"
                                       onblur="checkGoodsInDetailVal2()" onfocus="changeGoodsInDetail2()"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red" ></span></td>
                            <td colspan="2"><span style="color: red" id="enaddGoodsInDetailmsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">

                <button class="btn btn-success" data-dismiss="modal" <%--aria-hidden="true"--%> id="ensaveGoodsInDetailmsg"
                        disabled="true"
                        onclick="enSaveGoodsInDetail(${searchInDetail.gioid})">保存
                </button>
                <button class="btn btn-default btn-danger" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 编辑货物 -->
<div class="modal fade" id="updateGoodsDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabe2">入库单信息</h3>
            </div>
            <div class="modal-body">
                <form id="updateGoodsDetail">
                                        <span><input type="hidden" id="upid" name="iid"></span>
                    <table id="updateGoodsDetailTab" class="table table-bordered table-striped" width="800px">
                        <tr type="hidden">
<%--                            <td>入库id</td>--%>
                            <td><input class="form-control" type="hidden" readonly name="gioid" id="upengioid"></td>
<%--                            <td>货物id</td>--%>
                            <td><input class="form-control" type="hidden" readonly name="did" id="upengidid" ></td>
                        </tr>
                        <tr>
                            <td>货物货号</td>
                            <td><input class="form-control" readonly name="no" id="upengidno"></td>
                            <td>货物名称</td>
                            <td><input class="form-control" readonly name="name" id="upengidname"></td>
                        </tr>
                        <tr>
                            <td>色号</td>
                            <td><input class="form-control" readonly name="color" id="upengidcolor" ></td>
                            <td>尺码</td>
                            <td><input class="form-control" readonly name="size" id="upengidsize" ></td>
                        </tr>
                        <tr>
                            <td>类型</td>
                            <td><input class="form-control" readonly name="type" id="upengidtype" ></td>
                            <td>货物数量</td>
                            <td><input class="form-control" name="amount" id="upengidamount"
                                       type="text" maxlength="8"  onkeyup="value=this.value.replace(/\D+/g,'')"
                                       onblur="checkGoodsInDetailVal3()" onfocus="changeGoodsInDetail3()"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red" ></span></td>
                            <td colspan="2"><span style="color: red" id="upaddGoodsInDetailmsg"></span></td>
                        </tr>

                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="upsaveGoodsInDetailmsg"
                        disabled="true" onclick="updateGoodsDetail(${searchInDetail.gioid})">保存
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
    goodsInDetailVO.id = "${searchInDetail.iid}"
    goodsInDetailVO.name = "${searchInDetail.name}"
    goodsInDetailVO.no = "${searchInDetail.no}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>