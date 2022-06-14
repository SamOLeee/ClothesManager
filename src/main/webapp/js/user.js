
//重置添加和编辑窗口中输入框的内容
function resetUserFrom() {
    $("#savemsg").attr("disabled", true)
    $("#addmsg").html("")
    var url=getProjectPath()+"/user/createUserNo";
    $.get(url,function (response){
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

function updateUser() {
    var url = getProjectPath() + "/user/updateUser";
    $.post(url, $("#updateUser").serialize(), function (response) {
        alert(response.message);
        if (response.success == true) {
            window.location.href = getProjectPath() + "/user/search";
        }
    })
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
    /*    var addtime = $("#time").val();*/
    if ($.trim(adduname) == '') {
        $("#savemsg").attr("disabled", true);
        $("#addmsg").html("姓名不能为空")
    } else {
        checkName(adduname);
        if ($.trim(adduemail) == '') {
            $("#savemsg").attr("disabled", true);
            $("#addmsg").html("邮箱不能为空")
        } else if ($.trim(adduemail) != '') {
            checkEmail(adduemail);
            if ($.trim(addPw) == '') {
                $("#savemsg").attr("disabled", true);
                $("#addmsg").html("密码不能为空")
            }
        }
    }
}


function checkName(name) {
    var url = getProjectPath() + "/user/checkName?name=" + name;
    $.post(url, function (response) {
        if (response.success != true) {
            $("#savemsg").attr("disabled", true);
            $("#addmsg").html(response.message)
        }
    })
}

function checkEmail(email) {
    var url = getProjectPath() + "/user/checkEmail?email=" + email;
    $.post(url, function (response) {
        if (response.success != true) {
            $("#savemsg").attr("disabled", true);
            $("#addmsg").html(response.message)
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
        var r = confirm("是否id为" + uid + "，名字为" + res.name + "的用户?");
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
    //获取主机地址之后的目录，如： cloudlibrary/admin/goodss.jsp
    var pathName = window.document.location.pathname;
    //获取带"/"的项目名，如：/cloudlibrary
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    console.log(projectName);
    return projectName;
}