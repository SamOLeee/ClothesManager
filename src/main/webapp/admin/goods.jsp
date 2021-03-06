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
    <h3 class="box-title">货号管理</h3>
</div>
<div class="box-body">
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-left">
        <div class="has-feedback">
            <form action="${pageContext.request.contextPath}/goods/search" method="post">
                <input name="id" value="${search.id}" placeholder="请输入货物id">&nbsp&nbsp&nbsp&nbsp
                <input name="name" value="${search.name}" placeholder="请输入货物名称">&nbsp&nbsp&nbsp&nbsp
                <input name="no" value="${search.no}" placeholder="请输入货号">&nbsp&nbsp&nbsp&nbsp
                <input class="btn btn-default btn-info" type="submit" value="查询">
            </form>
        </div>
    </div>
    <%--新增按钮：如果当前登录用户是管理员，页面展示新增按钮--%>
    <div class="pull-right">
        <div class="form-group form-inline">
            <div class="btn-group">
                <c:if test="${USER.role =='admin'}">
                    <button type="button" class="btn btn-success btn-block " title="新建" data-toggle="modal"
                            data-target="#addGoodsModal" onclick="resetGoodsFrom()"> <i class="fa fa-file-o"></i>新增
                    </button>
                </c:if>
                <c:if test="${USER.role =='common'}">
                    <button type="button" class="btn btn-success btn-block" onclick="commonUser()">新增</button>
                </c:if>
            </div>
        </div>
    </div>
    <!--工具栏 数据搜索 /-->
    <!-- 数据列表 -->
    <div class="table-box">
        <!-- 数据表格 -->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
            <thead>
            <tr>
<%--                <th class="sorting_asc">货物id</th>--%>
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
<%--                    <td>${goods.id}</td>--%>
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
                                <button type="button" class="btn btn-primary btn-xs" data-toggle="modal"
                                        data-target="#updateGoodsModal" onclick="findGoodsById(${goods.id})"> 修改
                                </button>
                                <button type="button" class="btn btn-danger btn-xs" data-toggle="modal"
                                        data-target="#delGoodsModal" onclick="delGoods(${goods.id})"> 删除
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
<div class="modal fade" id="addGoodsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">货号信息</h3>
            </div>
            <div class="modal-body">
                <form id="addGoods">
                    <span><input type="hidden" id="ebid" name="id"></span>
                    <table id="addGoodsTab" class="table table-bordered table-striped" width="800px">
                        <%--货物的id,不展示在页面--%>
                        <tr>
                            <td>货物名称</td>
                            <td><input class="form-control" placeholder="货物名称" name="name" id="egname"
                                       onblur="checkGoodsVal()" onfocus="changeGoodsVal()"></td>
                            <td>货物货号</td>
                            <td><input class="form-control" readonly  name="no" id="egno"></td>
                        </tr>
                        <tr>

                            <td>色号</td>
                            <td>
                                <select class="form-control" id="egcolor" name="color"
                                        onblur="checkGoodsVal()" onfocus="changeGoodsVal()">
                                    <option value="" disabled="disabled" selected="selected">--请选择--</option>
                                    <option value="白色">白色</option>
                                    <option value="黑色">黑色</option>
                                    <option value="红色">红色</option>
                                    <option value="黄色">黄色</option>
                                    <option value="蓝色">蓝色</option>
                                    <option value="绿色">绿色</option>
                                    <option value="青色">青色</option>
                                    <option value="橙色">橙色</option>
                                    <option value="紫色">紫色</option>

                                </select>
                            </td>
                            <td>尺码</td>
                            <td>
                                <select class="form-control" id="egsize" name="size"
                                        onblur="checkGoodsVal()" onfocus="changeGoodsVal()">
                                    <option value="" disabled="disabled" selected="selected">--请选择--</option>
                                    <option value="S">S</option>
                                    <option value="M">M</option>
                                    <option value="L">L</option>
                                    <option value="XL">XL</option>
                                    <option value="XXL">XXL</option>
                                    <option value="XXXL">XXXL</option>
                                    <option value="XXXXL">XXXXL</option>

                                </select>
                            </td>

                        </tr>
                        <tr>
                            <td>货物数量</td>
                            <td>
                                <input class="form-control" readonly name="amount" id="egamount" placeholder="0" value="0">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><span style="color: red" id="addGoodsmsg"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" <%--aria-hidden="true"--%> id="saveGoodsmsg"
                        disabled="true"
                        onclick="saveGoods()">保存
                </button>
                <button class="btn btn-default btn-danger" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 编辑货物 -->
<div class="modal fade" id="updateGoodsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabe2">货号信息</h3>
            </div>
            <div class="modal-body">
                <form id="updateGoods">
                    <table id="updateGoodsTab" class="table table-bordered table-striped" width="800px">
                        <tr type="hidden">
<%--                            <td>货物id</td>--%>
                            <td><input class="form-control"  type="hidden" readonly name="id" id="ugid"></td>
                        </tr>
                        <tr>
                            <td>货物名称</td>
                            <td><input class="form-control"  name="name" id="ugname"
                                       onblur="upcheckGoodsVal()" onfocus="upchangeGoodsVal()"></td>
                            <td>货物货号</td>
                            <td><input class="form-control" readonly name="no" id="ugno"></td>
                        </tr>
                        <tr>
                            <td>色号</td>
                            <td>
                                <select class="form-control" id="ugcolor" name="color"
                                        onblur="upcheckGoodsVal()" onfocus="upchangeGoodsVal()">
                                    <option value="" disabled="disabled" selected="selected">--请选择--</option>
                                    <option value="白色">白色</option>
                                    <option value="黑色">黑色</option>
                                    <option value="红色">红色</option>
                                    <option value="黄色">黄色</option>
                                    <option value="蓝色">蓝色</option>
                                    <option value="绿色">绿色</option>
                                    <option value="青色">青色</option>
                                    <option value="橙色">橙色</option>
                                    <option value="紫色">紫色</option>

                                </select>
                            </td>
                            <td>尺码</td>
                            <td>
                                <select class="form-control" id="ugsize" name="size"
                                        onblur="upcheckGoodsVal()" onfocus="upchangeGoodsVal()">
                                    <option value="" disabled="disabled" selected="selected">--请选择--</option>
                                    <option value="S">S</option>
                                    <option value="M">M</option>
                                    <option value="L">L</option>
                                    <option value="XL">XL</option>
                                    <option value="XXL">XXL</option>
                                    <option value="XXXL">XXXL</option>
                                    <option value="XXXXL">XXXXL</option>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>货物数量</td>
                            <td><input class="form-control" readonly placeholder="货物数量" name="amount" id="ugamount"></td>
                            <td colspan="2"><span style="color: red" id="upaddGoodsmsg"></span></td>
                        </tr>

                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="upsaveGoodsmsg"
                        disabled="true"
                        onclick="updateGoods()">保存
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
    goodsVO.id = "${search.id}"
    goodsVO.name = "${search.name}"
    goodsVO.no = "${search.no}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>