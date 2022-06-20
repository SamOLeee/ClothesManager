// 页面长时间未响应退出登录
$(function(){
    var maxTime = 900; // seconds
    var time = maxTime;
    // 监控界面鼠标键盘操作
    $('body').on('keydown mousemove mousedown', function(e) {
        time = maxTime; // 重置页面返回时间
    });

    var intervalId = setInterval(function() {
        time--;
        if (time <= 0) {
            ShowInvalidLoginMessage();
            clearInterval(intervalId);
        }
    }, 1000)
    function ShowInvalidLoginMessage() {
        var url = getProjectPath();
        //发送请求清楚session
        $.get(url + "/logout" );
        // 到登录界面
        alert("登录超时，请重新登录!");
        window.location.href = url + "/";
    }
});
