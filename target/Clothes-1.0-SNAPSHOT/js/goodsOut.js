//获取当前项目的名称
function getProjectPath() {
    //获取主机地址之后的目录，如： cloudlibrary/admin/goodss.jsp
    var pathName = window.document.location.pathname;
    //获取带"/"的项目名，如：/cloudlibrary
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    console.log(projectName);
    return projectName;
}


function resetGoodsOutDetailFrom() {
    $("#saveGoodsOutDetailmsg").attr("disabled", true)
    $("#addGoodsOutDetailmsg").html("")
    var $vals = $("#addGoodsOutDetail input");
    $vals.each(function () {
        $(this).attr("style", "").val("")
    });
}


function changeGoodsOutDetail() {
    $("#addGoodsOutDetailmsg").html("")
}

function checkGoodsOutDetailVal() {
    $("#saveGoodsOutDetailmsg").attr("disabled", false)
    $("#addGoodsOutDetailmsg").html("")
    var godname = $("#godname").val();
    console.log(godname);
    if (godname == null) {
        $("#saveGoodsOutDetailmsg").attr("disabled", true);
        $("#addGoodsOutDetailmsg").html("请选择商品！")
    } /*else if ($.trim(gidamount) == '') {
        $("#saveGoodsInDetailmsg").attr("disabled", true);
        $("#addGoodsInDetailmsg").html("数量不能为空！")
    }*/
}

function changeGoodsOutDetail2() {
    $("#enaddGoodsOutDetailmsg").html("")
}

function checkGoodsOutDetailVal2() {
    $("#ensaveGoodsOutDetailmsg").attr("disabled", false)
    $("#enaddGoodsOutDetailmsg").html("")
    // var gidname = $("#gidname").val();
    var engodamount = $("#engodamount").val();
    /* if (gidname == null) {
         $("#saveGoodsInDetailmsg").attr("disabled", true);
         $("#addGoodsInDetailmsg").html("请选择商品！")
     } else */
    if ($.trim(engodamount) == '') {
        $("#ensaveGoodsOutDetailmsg").attr("disabled", true);
        $("#enaddGoodsOutDetailmsg").html("数量不能为空！")
    }
}

function saveGoodsOutDetail(pageId) {
    var select = document.getElementById("godname");
    var value = select.value;
    var url = getProjectPath() + "/goods/findGoodsById?id=" + value;
    console.log(url);
    console.log(pageId);
    $.get(url, function (response) {
        console.log(response);
        $("#engooid").val(pageId);
        $("#engodname").val(response.name);
        $("#engodno").val(response.no);
        $("#engodamount").val();
        $("#engodcolor").val(response.color);
        $("#engodsize").val(response.size);
        $("#engodtype").val(0);
        $("#engodid").val(response.id);
    })
}


function enSaveGoodsOutDetail(pageId) {
    var url = getProjectPath() + "/goodsDetail/addGoodsDetail";
    console.log(url);

    var id = document.getElementById("engodid").value;
    var amount = document.getElementById("engodamount").value;
    console.log(id);
    console.log(amount);


    $.ajax({
        url: getProjectPath() + "/goods/reduceGoodsAmount",
        type: 'post',
        data: "id=" + id + "&amount=" + amount,
        success: function (data) {
            alert(data.message);
            if (data.success) {
                $.post(url, $("#enAddGoodsOutDetail").serialize(), function (response) {
                    console.log(response);
                    // alert(response.message);
                    if (response.success == true) {
                        window.location.href = getProjectPath() + "/goodsDetail/searchOutDetail?gioid=" + pageId;
                    }
                })
            }
        }
    })
}

function findGoodsOutDetailById(iid) {
    var url = getProjectPath() + "/goodsDetail/findGoodsDetailById?id=" + iid;
    console.log(url);
    $.get(url, function (response) {
        console.log(response);
        $("#upid").val(response.iid);
        $("#upengooid").val(response.gioid);
        $("#upengodname").val(response.name);
        $("#upengodno").val(response.no);
        $("#upengodamount").val(response.amount);
        $("#upengodcolor").val(response.color);
        $("#upengodsize").val(response.size);
        $("#upengodtype").val(response.type);
        $("#upengodid").val(response.did);
    })
}


function changeGoodsOutDetail3() {
    $("#upaddGoodsOutDetailmsg").html("")
}

function checkGoodsOutDetailVal3() {
    $("#upsaveGoodsOutDetailmsg").attr("disabled", false)
    $("#upaddGoodsOutDetailmsg").html("")
    var upengodamount = $("#upengodamount").val();
    if ($.trim(upengodamount) == '') {
        $("#upsaveGoodsOutDetailmsg").attr("disabled", true);
        $("#upaddGoodsOutDetailmsg").html("数量不能为空！")
    }
}

function updateGoodsOutDetail(pageId) {
    var url = getProjectPath() + "/goodsDetail/updateGoodsDetail";
    var iid = document.getElementById("upid").value;
    var name = document.getElementById("upengodname").value;
    var amount = document.getElementById("upengodamount").value;
    var color = document.getElementById("upengodcolor").value;
    var size = document.getElementById("upengodsize").value;
    $.ajax({
        url: getProjectPath() + "/goods/updateGoodsAmount",
        type: 'post',
        data: "iid=" + iid + "&amount=" + amount + "&color=" + color + "&size=" + size + "&name=" + name,
        success: function (data) {
            alert(data.message);
            if (data.success) {
                $.post(url, $("#updateGoodsOutDetail").serialize(), function (response) {
                    if (response.success == true) {
                        window.location.href = getProjectPath() + "/goodsDetail/searchOutDetail?gioid=" + pageId;
                    }
                })
            }
        }
    })
}


function delGoodsOutDetail(id) {
    var url2 = getProjectPath() + "/goodsDetail/findGoodsDetailById?id=" + id;
    $.get(url2, function (res) {
        var r = confirm("是否删除id为" + id + "，货物名为" + res.name + "的明细信息？");
        $.ajax({
            url: getProjectPath() + "/goods/delGoodsAmount",
            type: 'post',
            data: 'iid=' + id,
            success: function (data) {
                alert(data.message);
                if (data.success) {
                    if (r) {
                        var url1 = getProjectPath() + "/goodsDetail/delGoodsDetail?id=" + id;
                        // var url2 = getProjectPath() + "/goodsDetail/findGoodsDetailById?id=" + id;
                        console.log(url2);
                        $.get(url1, function (response) {
                            // alert(response.message);
                            if (response.message) {
                                window.location.href = getProjectPath() + "/goodsDetail/searchOutDetail?gioid=" + res.gioid;
                            }
                        })
                    }
                }
            }
        })
    })
}


