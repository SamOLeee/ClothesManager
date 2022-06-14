package cn.controller;


import cn.domain.Goods;
import cn.domain.User;
import cn.entity.PageResult;
import cn.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cn.service.UserService;
import cn.entity.Result;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        User u = userService.login(user);
        List<Goods> goodsList = goodsService.getAllGoodsIn();

        if (u != null) {
            request.getSession().setAttribute("USER", u);
            request.getSession().setAttribute("GOODS", goodsList);
            String role = u.getRole();
            if ("admin".equals(role)) {
                return "redirect:/admin/main.jsp";
            } else {
                return "redirect:/admin/main.jsp";
            }
        }

        request.setAttribute("msg", "用户名或密码输入错误！");
        return "forward:/admin/login.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "forward:/admin/login.jsp";
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public Result addUser(User user) {
        userService.addUser(user);
        return new Result(true, "新增成功");
    }

    @ResponseBody
    @RequestMapping("/checkName")
    public Result checkName(String name) {
        Integer count = userService.checkName(name);
        if (count > 0) {
            return new Result(false, "名字重复!");
        } else {
            return new Result(true, "名字可用!");
        }
    }

    /**
     * 校验用户的邮箱是否已经存在
     *
     * @param email 被校验的用户邮箱
     */
    @ResponseBody
    @RequestMapping("/checkEmail")
    public Result checkEmail(String email) {
        Integer count = userService.checkEmail(email);
        if (count > 0) {
            return new Result(false, "邮箱重复!");
        } else {
            return new Result(true, "邮箱可用!");
        }
    }

    @ResponseBody
    @RequestMapping("/search")
    public ModelAndView searchUser(User user, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        PageResult pageResult = userService.searchUser(user, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("search", user);
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("gourl", request.getRequestURI());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public Result updateUser(User user) {
/*        System.out.print(123);
        System.out.println("controller"+user);*/
        userService.updateUser(user);
        return new Result(true, "修改成功！");
    }

    @ResponseBody
    @RequestMapping("/findUserById")
    public User findUserById(Integer id) {
        System.out.println(10086);
        System.out.println(id);
        return userService.findUserById(id);
    }

    @RequestMapping("/delUser")
    public Result delUser(Integer id) {
        userService.delUser(id);
        return new Result(true, "删除成功");
    }

    @ResponseBody
    @PostMapping("/updateUserPwd")
    public Result updateUserPwd(User user) {
        return userService.updateUserPwd(user);
    }
    @ResponseBody
    @RequestMapping("/createUserNo")
    public String createUserNo(){
        return userService.createUserNo();
    }
}

