package cn.controller;


import cn.domain.User;
import cn.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.service.UserService;
import cn.entity.Result;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/search")
    public ModelAndView searchUser(User user,Integer pageNum,Integer pageSize){
        if(pageNum == null)
            pageNum = 1;
        if(pageSize == null)
            pageSize = 10;

        PageResult pageResult = userService.searchUser(user,pageNum,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("search",user);
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("gourl","/user/search");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public Result updateUser(User user){
/*        System.out.print(123);
        System.out.println("controller"+user);*/
        userService.updateUser(user);
        return new Result(true,"修改成功！");
    }

    @ResponseBody
    @RequestMapping ("/findUserById")
    public User findUserById(Integer id){
/*        System.out.println(10086);
        System.out.println(id);*/
        return userService.findUserById(id);
    }
}

