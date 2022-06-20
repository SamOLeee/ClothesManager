package cn.interceptor;

import cn.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ResourcesInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("USER");
        System.out.println(user);
        //获取请求的路径
        String uri = request.getRequestURI();
        //如果用户是已登录状态，判断访问的资源是否有权限
        if (user != null) return true;
        else System.out.println("为空！");
        //对用户登录的相关请求，放行
        if (uri.indexOf("login") >= 0) return true;
        //其他情况都直接跳转到登录页面
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        return false;
    }
}