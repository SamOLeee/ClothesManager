/**
 * 数据展示页面分页插件的参数
 * cur 当前页
 * total 总页数
 * len   显示多少页数
 * pagesize 1页显示多少条数据
 * gourl 页码变化时 跳转的路径
 * targetId 分页插件作用的id
 */
var pageargs = {
    cur: 1,
    total: 0,
    len: 5,
    pagesize: 10,
    gourl: "",
    targetId: 'pagination',
    callback: function (total) {
        var oPages = document.getElementsByClassName('page-index');
        for (var i = 0; i < oPages.length; i++) {
            oPages[i].onclick = function () {
                changePage(this.getAttribute('data-index'), pageargs.pagesize);
            }
        }
        var goPage = document.getElementById('go-search');
        goPage.onclick = function () {
            var index = document.getElementById('yeshu').value;
            if (!index || (+index > total) || (+index < 1)) {
                return;
            }
            changePage(index, pageargs.pagesize);
        }
    }
}


var goodsVO = {
    id: '',
    name: '',
    no: ''
}

var goodsInVO = {
    id: '',
    no: ''
}
var goodsOutVO = {
    id: '',
    no: ''
}
var goodsInDetailVO = {
    id: '',
    name: '',
    no: ''
}
var goodsOutDetailVO = {
    id: '',
    name: '',
    no: ''
}
var goodsAllDetailVO = {
    id: '',
    no: '',
    name: '',
    type: ''
}
/**
 *借阅记录查询栏的查询参数
 * name 图书名称
 * borrower 借阅人
 */
var recordVO = {
    bookname: '',
    borrower: ''
}
var userVO = {
    no: '',
    name: ''
}

//数据展示页面分页插件的页码发送变化时执行
function changePage(pageNo, pageSize) {
    pageargs.cur = pageNo;
    pageargs.pagesize = pageSize;
    document.write("<form action=" + pageargs.gourl + " method=post name=form1 style='display:none'>");
    document.write("<input type=hidden name='pageNum' value=" + pageargs.cur + " >");
    document.write("<input type=hidden name='pageSize' value=" + pageargs.pagesize + " >");
    //如果跳转的是图书信息查询的相关链接，提交图书查询栏中的参数
    if (pageargs.gourl.indexOf("book") >= 0) {
        document.write("<input type=hidden name='id' value=" + bookVO.id + " >");
        document.write("<input type=hidden name='name' value=" + bookVO.name + " >");
        document.write("<input type=hidden name='no' value=" + bookVO.no + " >");
    }
    //如果跳转的是图书记录查询的相关链接，提交图书记录查询栏中的参数
    if (pageargs.gourl.indexOf("user") >= 0) {
        document.write("<input type=hidden name='id' value=" + userVO.id + " >");
        document.write("<input type=hidden name='name' value=" + userVO.name + " >");
    }
    //如果跳转的是图书记录查询的相关链接，提交图书记录查询栏中的参数
    if (pageargs.gourl.indexOf("record") >= 0) {
        document.write("<input type=hidden name='bookname' value=" + recordVO.bookname + " >");
        document.write("<input type=hidden name='borrower' value=" + recordVO.borrower + " >");
    }
    document.write("</form>");
    document.form1.submit();
    pagination(pageargs);
}

