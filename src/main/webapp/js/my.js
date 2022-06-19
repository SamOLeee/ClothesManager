function resetGoodsFrom() {
    $("#saveGoodsmsg").attr("disabled", true);
    $("#addGoodsmsg").html("");
    var url = getProjectPath() + "/goods/createGoodsNo";
    $.get(url, function (response) {
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
    // var egno = $("#egno").val();
    // var egamount = $("#egamount").val();
    var egcolor = document.getElementById("egcolor").value;
    var egsize = document.getElementById("egsize").value;
    console.log(egname);
    console.log(egcolor);
    console.log(egsize);
    if ($.trim(egname) == '') {
        $("#saveGoodsmsg").attr("disabled", true);
        $("#addGoodsmsg").html("货物名称不能为空！");
    } else if ($.trim(egcolor) == '') {
        $("#saveGoodsmsg").attr("disabled", true);
        $("#addGoodsmsg").html("请选择色号！");
    } else if ($.trim(egsize) == '') {
        $("#saveGoodsmsg").attr("disabled", true);
        $("#addGoodsmsg").html("请选择尺码！");
    } else {
        $.ajax({
            url: getProjectPath() + "/goods/checkGoods",
            type: 'post',
            data: "name=" + egname + "&color=" + egcolor + "&size=" + egsize,
            success: function (data) {
                if (!data.success) {
                    $("#saveGoodsmsg").attr("disabled", true);
                    $("#addGoodsmsg").html(data.message);
                }
            }
        })
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
        var r = confirm("是否删除货号为" + res.no + "，货物名称为" + res.name + "的货物?");
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

////////////////////////////////////////////////
///////////////////////////////////////////////
/////////////////////////////////////////////////////


function resetGoodsInFrom(name) {
    $("#saveGoodsInmsg").attr("disabled", true)
    $("#addGoodsInmsg").html("")
    var url = getProjectPath() + "/goodsIn/createGoodsInNo";
    $.get(url, function (response) {
        $("#gino").val(response);
        $("#gioperator").val(name);
    })
    var $vals = $("#addGoodsIn input");
    $vals.each(function () {
        $(this).attr("style", "").val("")
    });
}

function changeGoodsInVal() {
    $("#addGoodsInmsg").html("")
}

function checkGoodsInVal() {
    $("#saveGoodsInmsg").attr("disabled", false)
    $("#addGoodsInmsg").html("")
    var gino = $("#gino").val();
    var gilibrary = $("#gilibrary").val();
    var gioperator = $("#gioperator").val();
    var gisource = $("#gisource").val();

    if ($.trim(gino) == '') {
        $("#saveGoodsInmsg").attr("disabled", true);
        $("#addGoodsInmsg").html("单据凭证不能为空！")
    } else if ($.trim(gilibrary) == '') {
        $("#saveGoodsInmsg").attr("disabled", true);
        $("#addGoodsInmsg").html("所属仓库不能为空！")
    } else if ($.trim(gioperator) == '') {
        $("#saveGoodsInmsg").attr("disabled", true);
        $("#addGoodsInmsg").html("经办人不能为空！")
    } else if ($.trim(gisource) == '') {
        $("#saveGoodsInmsg").attr("disabled", true);
        $("#addGoodsInmsg").html("来源不能为空！")
    }
}

function saveGoodsIn() {
    var url = getProjectPath() + "/goodsIn/addGoodsIn";
    console.log(url);
    $.post(url, $("#addGoodsIn").serialize(), function (response) {
        console.log(response);
        alert(response.message);
        if (response.success == true) {
            window.location.href = getProjectPath() + "/goodsIn/search";
        }
    })
}


function findGoodsInById(gid) {
    var url = getProjectPath() + "/goodsIn/findGoodsInById?id=" + gid;
    console.log(url);
    $.get(url, function (response) {
        console.log(response);
        $("#upgiid").val(response.id);
        $("#upgino").val(response.no);
        $("#upgitime").val(response.datetime);
        $("#upgilibrary").val(response.library);
        $("#upgioperator").val(response.operator);
        $("#ugsource").val(response.source);
        console.log(response);
    })
}


function updateGoodsIn() {
    var url = getProjectPath() + "/goodsIn/updateGoodsIn";
    $.post(url, $("#updateGoodsIn").serialize(), function (response) {
        alert(response.message);
        if (response.success == true) {
            window.location.href = getProjectPath() + "/goodsIn/search";
        }
    })
}

function delGoodsIn(gid) {
    var url2 = getProjectPath() + "/goodsIn/findGoodsInById?id=" + gid;
    $.get(url2, function (res) {
        var r = confirm("是否删除id为" + gid + "，单据凭证为" + res.no + "入库单?");
        console.log(r);
        if (r) {
            var url = getProjectPath() + "/goodsIn/delGoodsIn?id=" + gid;
            $.get(url, function (response) {
                alert(response.message);
                if (response.success == true) {
                    window.location.href = getProjectPath() + "/goodsIn/search";
                }
            })
        }
    })
}

///////////////////////////////////////////
//////////////////////////////////////////
///////////////////////////////////////////
/////////////////////////////////////////////////


function resetGoodsOutFrom(name) {
    $("#saveGoodsOutmsg").attr("disabled", true)
    $("#addGoodsOutmsg").html("")
    var url = getProjectPath() + "/goodsOut/createGoodsOutNo";
    $.get(url, function (response) {
        $("#gono").val(response);
        $("#gooperator").val(name);
    })
    var $vals = $("#addGoodsOut input");
    $vals.each(function () {
        $(this).attr("style", "").val("")
    });
}

function changeGoodsOutVal() {
    $("#addGoodsOutmsg").html("")
}

function checkGoodsOutVal() {
    $("#saveGoodsOutmsg").attr("disabled", false)
    $("#addGoodsOutmsg").html("")
    var gono = $("#gono").val();
    var golibrary = $("#golibrary").val();
    var gooperator = $("#gooperator").val();
    var gosend = $("#gosend").val();

    if ($.trim(gono) == '') {
        $("#saveGoodsOutmsg").attr("disabled", true);
        $("#addGoodsOutmsg").html("单据凭证不能为空！")
    } else if ($.trim(golibrary) == '') {
        $("#saveGoodsOutmsg").attr("disabled", true);
        $("#addGoodsOutmsg").html("所属仓库不能为空！")
    } else if ($.trim(gooperator) == '') {
        $("#saveGoodsOutmsg").attr("disabled", true);
        $("#addGoodsOutmsg").html("经办人不能为空！")
    } else if ($.trim(gosend) == '') {
        $("#saveGoodsOutmsg").attr("disabled", true);
        $("#addGoodsOutmsg").html("去向不能为空！")
    }
    console.log(gono);
    console.log(golibrary);
    console.log(gooperator);
    console.log(gosend);
}

function saveGoodsOut() {
    var url = getProjectPath() + "/goodsOut/addGoodsOut";
    console.log(url);
    $.post(url, $("#addGoodsOut").serialize(), function (response) {
        console.log(response);
        alert(response.message);
        if (response.success == true) {
            window.location.href = getProjectPath() + "/goodsOut/search";
        }
    })
}


function findGoodsOutById(gid) {
    var url = getProjectPath() + "/goodsOut/findGoodsOutById?id=" + gid;
    console.log(url);
    $.get(url, function (response) {
        console.log(response);
        $("#upgoid").val(response.id);
        $("#upgono").val(response.no);
        $("#upgotime").val(response.datetime);
        $("#upgolibrary").val(response.library);
        $("#upgooperator").val(response.operator);
        $("#upgosend").val(response.send);
        console.log(response);
    })
}

function updateGoodsOut() {
    var url = getProjectPath() + "/goodsOut/updateGoodsOut";
    console.log(url);
    $.post(url, $("#updateGoodsOut").serialize(), function (response) {
        alert(response.message);
        if (response.success == true) {
            window.location.href = getProjectPath() + "/goodsOut/search";
        }
    })
}

function delGoodsOut(gid) {
    var url2 = getProjectPath() + "/goodsOut/findGoodsOutById?id=" + gid;
    $.get(url2, function (res) {
        var r = confirm("是否删除id为" + gid + "，单据凭证为" + res.no + "出库单?");
        console.log(r);
        if (r) {
            var url = getProjectPath() + "/goodsOut/delGoodsOut?id=" + gid;
            $.get(url, function (response) {
                alert(response.message);
                if (response.success == true) {
                    window.location.href = getProjectPath() + "/goodsOut/search";
                }
            })
        }
    })

}

///////////////////////////////////////////
//////////////////////////////////////////
///////////////////////////////////////////
/////////////////////////////////////////////////
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
            if (data.success) {
                $.post(url, $("#enAddGoodsInDetail").serialize(), function (response) {
                    console.log(response);
                    // alert(response.message);
                    if (response.success == true) {
                        window.location.href = getProjectPath() + "/goodsDetail/searchInDetail?gioid=" + pageId;
                    }
                })
            }
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
    var len = upengidamount.length;
    console.log(len);
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
        if (r) {
            $.ajax({
                url: getProjectPath() + "/goods/delGoodsAmount",
                type: 'post',
                data: "iid=" + id,
                success: function (data) {
                    alert(data.message);
                    if (data.success) {

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
            })
        }
    })
}

///////////////////////////////////////////
//////////////////////////////////////////
///////////////////////////////////////////
/////////////////////////////////////////////////


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
    var engodamount = $("#engodamount").val();
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
        if (r) {
            $.ajax({
                url: getProjectPath() + "/goods/delGoodsAmount",
                type: 'post',
                data: 'iid=' + id,
                success: function (data) {
                    alert(data.message);
                    if (data.success) {
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
            })
        }
    })
}

///////////////////////////////////////////
//////////////////////////////////////////
///////////////////////////////////////////
/////////////////////////////////////////////////


//重置添加和编辑窗口中输入框的内容
function resetUserFrom() {
    $("#savemsg").attr("disabled", true)
    $("#addmsg").html("")
    var url = getProjectPath() + "/user/createUserNo";
    $.get(url, function (response) {
        $("#addno").val(response);
    })
    var $vals = $("#addUer input");
    $vals.each(function () {
        $(this).attr("style", "").val("")
    });
}

function resetUserCenterFrom() {
    $("#saveUsermsg").attr("disabled", true)
    $("#addUsermsg").html("")
    var $vals = $("#UserCenter input");
    $vals.each(function () {
        $(this).attr("style", "").val("")
    });
}

function loginOut() {
    var r = confirm("确认注销?");
    if (r) {
        var url = getProjectPath() + "/user/logout";
        $.get(url, function (response) {
            window.location.href = getProjectPath() + response;
        })
    }
}

function changeUserVal() {
    $("#addUsermsg").html("")
}

function checkUserVal() {
    $("#saveUsermsg").attr("disabled", false);
    $("#addUsermsg").html("")
    var usrpw = $("#usrpw").val();
    var enusrpw = $("#enusrpw").val();
    if ($.trim(usrpw) == '') {
        $("#saveUsermsg").attr("disabled", true);
        $("#addUsermsg").html("密码不能为空！")
    } else {
        if ($.trim(enusrpw) == '') {
            $("#saveUsermsg").attr("disabled", true);
            $("#addUsermsg").html("确认密码不能为空！")
        } else if (usrpw != enusrpw) {
            $("#saveUsermsg").attr("disabled", true);
            $("#addUsermsg").html("两次密码不一样，请重新输入！")
        }
    }
}

function updateUserPwd(id) {
    var password = document.getElementById("enusrpw").value;
    var r = confirm("是否将密码修改为 " + password + " ?");
    if (r) {
        $.ajax({
            url: getProjectPath() + "/user/updateUserPwd",
            type: 'post',
            data: "id=" + id + "&password=" + password,
            success: function (data) {
                alert(data.message);
                if (data.success) {
                    alert("信息过期，请重新的登录！");
                    window.location.href = getProjectPath() + "/index.jsp";
                }
            }
        })
    }
}

function findUserById(uid) {
    var url = getProjectPath() + "/user/findUserById?id=" + uid;
    $.get(url, function (response) {
        console.log(response);
        $("#uid").val(response.id);
        $("#uno").val(response.no);
        $("#uname").val(response.name);
        $("#pw").val(response.password);
        $("#urole").val(response.role);
        $("#uemail").val(response.email);
    })
}

function updateUser(id) {
    var r = confirm("是否保存修改?");
    if (r) {
        var url = getProjectPath() + "/user/updateUser";
        var uid = $("#uid").val();
        $.post(url, $("#updateUser").serialize(), function (response) {
            alert(response.message);
            if (response.success == true) {
                if (uid == id) {
                    alert("信息过期，请重新的登录！");
                    window.location.href = getProjectPath() + "/index.jsp";
                } else
                    window.location.href = getProjectPath() + "/user/search";
            }
        })
    }
}

function changeVal() {
    $("#addmsg").html("")
}

function checkVal() {
    $("#savemsg").attr("disabled", false);
    $("#addmsg").html("")
    var adduname = $("#adduname").val();
    var adduemail = $("#adduemail").val();
    var addPw = $("#addPw").val();
    var addrole = document.getElementById("addrole").value;
    console.log(adduname);
    console.log(addrole);

    /*    var addtime = $("#time").val();*/
    if ($.trim(adduname) == '') {
        $("#savemsg").attr("disabled", true);
        $("#addmsg").html("姓名不能为空！")
    } else {
        checkName(adduname);
        if ($.trim(adduemail) == '') {
            $("#savemsg").attr("disabled", true);
            $("#addmsg").html("邮箱不能为空！")
        } else if ($.trim(adduemail) != '') {
            checkEmail(adduemail);
            if ($.trim(addPw) == '') {
                $("#savemsg").attr("disabled", true);
                $("#addmsg").html("密码不能为空！");
            } else if ($.trim(addrole) == '') {
                $("#savemsg").attr("disabled", true);
                $("#addmsg").html("请选择用户权限！")
            }
        }
    }
}


function checkName(name) {
    $.ajax({
        url: getProjectPath() + "/user/checkName",
        type: 'post',
        data: "name=" + name,
        success: function (data) {
            if (data.success != true) {
                $("#savemsg").attr("disabled", true);
                $("#addmsg").html(data.message);
            }
        }
    })
}

function checkEmail(email) {
    $.ajax({
        url: getProjectPath() + "/user/checkEmail",
        type: 'post',
        data: "email=" + email,
        success: function (data) {
            if (data.success != true) {
                $("#savemsg").attr("disabled", true);
                $("#addmsg").html(data.message);
            }
        }
    })
}


function saveUser() {
    var url = getProjectPath() + "/user/addUser";
    console.log(url);
    $.post(url, $("#addUser").serialize(), function (response) {
        console.log(response);
        alert(response.message);
        if (response.success == true) {
            window.location.href = getProjectPath() + "/user/search";
        }
    })
}

function delUser(uid) {
    var url2 = getProjectPath() + "/user/findUserById?id=" + uid;
    $.get(url2, function (res) {
        var r = confirm("是否删除编号为" + res.no + "，名字为" + res.name + "的用户?");
        if (r) {
            var url = getProjectPath() + "/user/delUser?id=" + uid;
            $.get(url, function (response) {
                alert(response.message);
                if (response.success == true) {
                    window.location.href = getProjectPath() + "/user/search";
                }
            })
        }
    })

}

function commonUser() {
    var r = confirm("没有权限");
}

//获取当前项目的名称
function getProjectPath() {
    //获取主机地址之后的目录
    var pathName = window.document.location.pathname;
    //获取带"/"的项目名
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    console.log(projectName);
    return projectName;
}

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


