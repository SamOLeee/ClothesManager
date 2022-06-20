function getProjectPath() {
    //获取主机地址之后的目录，如： cloudlibrary/admin/goodss.jsp
    var pathName = window.document.location.pathname;
    //获取带"/"的项目名，如：/cloudlibrary
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    console.log(projectName);
    return projectName;
}

function resetGoodsInDetailFrom() {
    $("#saveGoodsInDetailmsg").attr("disabled", true)
    $("#addGoodsInDetailmsg").html("")
    var $vals = $("#addGoodsInDetail input");
    $vals.each(function () {
        $(this).attr("style", "").val("")
    });
}


function changeGoodsInDetail() {
    $("#addGoodsInDetailmsg").html("")
}

function checkGoodsInDetailVal() {
    $("#saveGoodsInDetailmsg").attr("disabled", false)
    $("#addGoodsInDetailmsg").html("")
    var gidname = $("#gidname").val();
    // var gidamount = $("#gidamount").val();
    console.log(gidname);
    if (gidname == null) {
        $("#saveGoodsInDetailmsg").attr("disabled", true);
        $("#addGoodsInDetailmsg").html("请选择商品！")
    } /*else if ($.trim(gidamount) == '') {
        $("#saveGoodsInDetailmsg").attr("disabled", true);
        $("#addGoodsInDetailmsg").html("数量不能为空！")
    }*/
}

function changeGoodsInDetail2() {
    $("#enaddGoodsInDetailmsg").html("")
}

function checkGoodsInDetailVal2() {
    $("#ensaveGoodsInDetailmsg").attr("disabled", false)
    $("#enaddGoodsInDetailmsg").html("")
    var engidamount = $("#engidamount").val();
    console.log(gidname);
    if ($.trim(engidamount) == '') {
        $("#ensaveGoodsInDetailmsg").attr("disabled", true);
        $("#enaddGoodsInDetailmsg").html("数量不能为空！")
    }
}

function saveGoodsInDetail(pageId) {
    var select = document.getElementById("gidname");
    var value = select.value;
    var url = getProjectPath() + "/goods/findGoodsById?id=" + value;
    console.log(url);
    console.log(pageId);
    $.get(url, function (response) {
        console.log(response);
        $("#engioid").val(pageId);
        $("#engidname").val(response.name);
        $("#engidno").val(response.no);
        $("#engidamount").val();
        $("#engidcolor").val(response.color);
        $("#engidsize").val(response.size);
        $("#engidtype").val(1);
        $("#engidid").val(response.id);
    })
}


function enSaveGoodsInDetail(pageId) {
    var url = getProjectPath() + "/goodsDetail/addGoodsDetail";
    console.log(url);

    var id = document.getElementById("engidid").value;
    var amount = document.getElementById("engidamount").value;
    console.log(id);
    console.log(amount);

    $.ajax({
        url: getProjectPath() + "/goods/addGoodsAmount",
        type: 'post',
        data: "id=" + id + "&amount=" + amount,
        success: function (data) {
            alert(data.message);
            $.post(url, $("#enAddGoodsInDetail").serialize(), function (response) {
                console.log(response);
                // alert(response.message);
                if (response.success == true) {
                    window.location.href = getProjectPath() + "/goodsDetail/searchInDetail?gioid=" + pageId;
                }
            })
        }
    })
}

function findGoodsInDetailById(iid) {
    var url = getProjectPath() + "/goodsDetail/findGoodsDetailById?id=" + iid;
    console.log(url);
    $.get(url, function (response) {
        console.log(response);
        $("#upid").val(response.iid);
        $("#upengioid").val(response.gioid);
        $("#upengidname").val(response.name);
        $("#upengidno").val(response.no);
        $("#upengidamount").val(response.amount);
        $("#upengidcolor").val(response.color);
        $("#upengidsize").val(response.size);
        $("#upengidtype").val(response.type);
        $("#upengidid").val(response.did);
    })
}

function changeGoodsInDetail3() {
    $("#upaddGoodsInDetailmsg").html("")
}

function checkGoodsInDetailVal3() {
    $("#upsaveGoodsInDetailmsg").attr("disabled", false)
    $("#upaddGoodsInDetailmsg").html("")
    var upengidamount = $("#upengidamount").val();
    if ($.trim(upengidamount) == '') {
        $("#upsaveGoodsInDetailmsg").attr("disabled", true);
        $("#upaddGoodsInDetailmsg").html("数量不能为空！")
    }
}


function updateGoodsDetail(pageId) {
    var url = getProjectPath() + "/goodsDetail/updateGoodsDetail";

    var iid = document.getElementById("upid").value;
    var amount = document.getElementById("upengidamount").value;
    var color = document.getElementById("upengidcolor").value;
    var size = document.getElementById("upengidsize").value;
    var name = document.getElementById("upengidname").value;
    $.ajax({
        url: getProjectPath() + "/goods/updateGoodsAmount",
        type: 'post',
        data: "iid=" + iid + "&amount=" + amount + "&color=" + color + "&size=" + size + "&name=" + name,
        success: function (data) {
            alert(data.message);
            if (data.success) {
                $.post(url, $("#updateGoodsDetail").serialize(), function (response) {
                    if (response.success == true) {
                        window.location.href = getProjectPath() + "/goodsDetail/searchInDetail?gioid=" + pageId;
                    }
                })
            }
        }
    })
}


function delGoodsInDetail(id) {
    var url2 = getProjectPath() + "/goodsDetail/findGoodsDetailById?id=" + id;
    $.get(url2, function (res) {
        var r = confirm("是否删除id为" + id + "，货物名为" + res.name + "的明细信息？");

        $.ajax({
            url: getProjectPath() + "/goods/delGoodsAmount",
            type: 'post',
            data: "iid=" + id,
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
                                window.location.href = getProjectPath() + "/goodsDetail/searchInDetail?gioid=" + res.gioid;
                            }
                        })
                    }
                }
            }
        })
    })
}