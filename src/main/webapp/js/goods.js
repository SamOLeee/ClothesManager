function getProjectPath() {
    //获取主机地址之后的目录，如： cloudlibrary/admin/goodss.jsp
    var pathName = window.document.location.pathname;
    //获取带"/"的项目名，如：/cloudlibrary
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    console.log(projectName);
    return projectName;
}


function resetGoodsFrom() {
    $("#saveGoodsmsg").attr("disabled", true);
    $("#addGoodsmsg").html("");
    var url=getProjectPath()+"/goods/createGoodsNo";
    $.get(url,function (response){
        $("#egno").val(response);
    })
    var $vals = $("#addGoods input");
    $vals.each(function () {
        $(this).attr("style", "").val("")
    });
}

function changeGoodsVal() {
    $("#addGoodsmsg").html("")
}


function checkGoodsVal() {
    $("#saveGoodsmsg").attr("disabled", false)
    $("#addGoodsmsg").html("")
    var egname = $("#egname").val();
    var egno = $("#egno").val();
    var egamount = $("#egamount").val();

    if ($.trim(egname) == '') {
        $("#saveGoodsmsg").attr("disabled", true);
        $("#addGoodsmsg").html("货物名称不能为空")
    } else if ($.trim(egno) == '') {
        $("#saveGoodsmsg").attr("disabled", true);
        $("#addGoodsmsg").html("货物货号不能为空")
    }
}

function saveGoods() {
    var url = getProjectPath() + "/goods/addGoods";
    console.log(url);
    $.post(url, $("#addGoods").serialize(), function (response) {
        console.log(response);
        alert(response.message);
        if (response.success == true) {
            window.location.href = getProjectPath() + "/goods/search";
        }
    })
}

function findGoodsById(gid) {
    var url = getProjectPath() + "/goods/findGoodsById?id=" + gid;
    // console.log(url);
    $.get(url, function (response) {
        console.log(url);
        console.log(response);
        $("#ugid").val(response.id);
        $("#ugname").val(response.name);
        $("#ugno").val(response.no);
        $("#ugamount").val(response.amount);
        $("#ugcolor").val(response.color);
        $("#ugsize").val(response.size);
    })
}

function updateGoods() {
    var url = getProjectPath() + "/goods/updateGoods";
    console.log(url);
    $.post(url, $("#updateGoods").serialize(), function (response) {
        alert(response.message);
        if (response.success == true) {
            window.location.href = getProjectPath() + "/goods/search";
        }
    })
}

function delGoods(gid) {
    var url2 = getProjectPath() + "/goods/findGoodsById?id=" + gid;
    $.get(url2, function (res) {
        var r = confirm("是否id为" + gid + "，货物名称为" + res.name + "的货物?");
        console.log(r);
        if (r) {
            var url = getProjectPath() + "/goods/delGoods?id=" + gid;
            $.get(url, function (response) {
                alert(response.message);
                if (response.success == true) {
                    window.location.href = getProjectPath() + "/goods/search";
                }
            })
        }
    })
}
