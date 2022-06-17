<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>服装库存管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/_all-skins.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
    <script src="${pageContext.request.contextPath}/js/timeout.js"></script>
</head>
<body>
<%--<div class="container"><h2>快捷跳转</h2>--%>
<%--    <div class="row">--%>
<%--        <div class="case-card col-md-4">--%>
<%--            <a href="${pageContext.request.contextPath}/user/search" target="iframe" rel="noopener noreferrer">--%>
<%--                <img src="${pageContext.request.contextPath}/img/user.png">--%>
<%--                <p class="case-card-company">用户管理</p></a>--%>
<%--        </div>--%>
<%--        <div class="case-card col-md-4">--%>
<%--            <a href="${pageContext.request.contextPath}/goods/search" target="iframe" rel="noopener noreferrer">--%>
<%--                <img src="${pageContext.request.contextPath}/img/goods.png">--%>
<%--                <p class="case-card-company">货物管理</p></a>--%>
<%--        </div>--%>
<%--        <div class="case-card col-md-4">--%>
<%--            <a href="${pageContext.request.contextPath}/goodsIn/search" target="iframe" rel="noopener noreferrer">--%>
<%--                <img src="${pageContext.request.contextPath}/img/in.png">--%>
<%--                <p class="case-card-company">入库管理</p></a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<div class="container">
    <h1>
        <font color="#8b008b">
            欢&nbsp&nbsp&nbsp&nbsp迎&nbsp&nbsp&nbsp&nbsp使&nbsp&nbsp&nbsp&nbsp用&nbsp&nbsp&nbsp&nbsp服&nbsp&nbsp&nbsp&nbsp装&nbsp&nbsp&nbsp&nbsp库&nbsp&nbsp&nbsp&nbsp存&nbsp&nbsp&nbsp&nbsp管&nbsp&nbsp&nbsp&nbsp理&nbsp&nbsp&nbsp&nbsp系&nbsp&nbsp&nbsp&nbsp统!
        </font>
    </h1>
    <div class="focus">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators 小圆点-->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
            </ol>

            <!-- Wrapper for slides 轮播图-->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <a href="${pageContext.request.contextPath}/user/search" target="iframe" rel="noopener noreferrer">
                        <img src="${pageContext.request.contextPath}/img/user.jpg">
                        <%--                    <div class="carousel-caption">--%>
                        <%--                        用户管理--%>
                        <%--                    </div>--%>
                    </a>
                </div>
                <div class="item">
                    <a href="${pageContext.request.contextPath}/goods/search" target="iframe" rel="noopener noreferrer">
                        <img src="${pageContext.request.contextPath}/img/goods.jpg">
                        <%--                    <div class="carousel-caption">--%>
                        <%--                        货物管理--%>
                        <%--                    </div>--%>
                    </a>
                </div>
                <div class="item">
                    <a href="${pageContext.request.contextPath}/goodsIn/search" target="iframe"
                       rel="noopener noreferrer">
                        <img src="${pageContext.request.contextPath}/img/goodsIn.jpg">
                        <%--                    <div class="carousel-caption">--%>
                        <%--                        入库管理--%>
                        <%--                    </div>--%>
                    </a>
                </div>
                <div class="item">
                    <a href="${pageContext.request.contextPath}/goodsOut/search" target="iframe"
                       rel="noopener noreferrer">
                        <img src="${pageContext.request.contextPath}/img/goodsOut.jpg">
                        <%--                    <div class="carousel-caption">--%>
                        <%--                        出库管理--%>
                        <%--                    </div>--%>
                    </a>
                </div>
            </div>

            <!-- Controls 左右翻页-->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="left-side" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="right-side" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>
</body>
<script>
    $('.carousel').carousel({
        interval: 2000
    })
</script>
<style>
    .focus {
        width: 700px;
        height: 400px;
        background-color: black;
        margin: 100px auto;
    }

    .carousel,
    .carousel img {
        width: 100%;
        height: 400px !important;
    }
</style>
</html>
