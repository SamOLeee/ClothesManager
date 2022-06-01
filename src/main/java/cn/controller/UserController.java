package cn.controller;


import cn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.service.UserService;
import cn.entity.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        User u = userService.login(user);
        if(u != null){
            request.getSession().setAttribute("USER",u);
            String role=u.getRole();
            if ("admin".equals(role)) {
                return "redirect:/admin/main.jsp";
            } else {
                return "redirect:/admin/index.jsp";
            }
        }

        request.setAttribute("msg","用户名或密码输入错误！");
        return "forward:/admin/login.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session =request.getSession();
        session.invalidate();
        return "forward:/admin/login.jsp";
    }

    @RequestMapping("/addUser")
    public Result addUser(User user){
        userService.addUser(user);
        return new Result(true,"新增成功");
    }
}

