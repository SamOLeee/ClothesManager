package cn.controller;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.domain.User;
import cn.entity.PageResult;
import cn.entity.Result;
import cn.service.GoodsService;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/search")
    public ModelAndView searchGoods(Goods goods, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        PageResult pageResult = goodsService.searchGoods(goods, pageNum, pageSize);
        System.out.println(goods);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goods");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("search", goods);
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("gourl", request.getRequestURI());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/findGoodsById")
    public Goods findGoodsById(Integer id) {
/*        System.out.println(10086);
        System.out.println(id);*/
        return goodsService.findGoodsById(id);
    }

    @ResponseBody
    @RequestMapping("/getAllGoodsIn")
//    public List<Goods> getAllGoodsIn(){
//
//        return goodsService.getAllGoodsIn();
//    }
    public void getAllGoodsIn(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("GOODS", goodsService.getAllGoodsIn());
        try {
            response.sendRedirect("/Clothes/admin/main.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public ModelAndView getAllGoodsIn(){
//        ModelAndView modelAndView = new ModelAndView();
//        List<Goods> list=goodsService.getAllGoodsIn();
//        modelAndView.setViewName("goods");
//        modelAndView.addObject("list",list);
//        return modelAndView;
//    }


    @ResponseBody
    @RequestMapping("/addGoods")
    public Result addGoods(Goods goods) {
        try {
            goodsService.addGoods(goods);
            return new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/updateGoods")
    public Result updateGoods(Goods goods) {
        try {
            goodsService.updateGoods(goods);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @RequestMapping("/delGoods")
    public Result delUser(Integer id) {
        try {
            goodsService.delGoods(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @PostMapping("/addGoodsAmount")
    public Result addGoodsAmount(Goods goods) {
        try {
            System.out.println(goods);
            return goodsService.addGoodsAmount(goods);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }


    @ResponseBody
    @PostMapping("/reduceGoodsAmount")
    public Result reduceGoodsAmount(Goods goods) {
        try {
            System.out.println(goods);
            return goodsService.reduceGoodsAmount(goods);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @PostMapping("/updateGoodsAmount")
    public Result updateGoodsAmount(GoodsDetail goodsDetail) {
        try {
            System.out.println("修改明细==== " + goodsDetail);
            return goodsService.updateGoodsAmount(goodsDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @PostMapping("/delGoodsAmount")
    public Result delGoodsAmount(GoodsDetail goodsDetail) {
        try {
            System.out.println("修改明细==== " + goodsDetail);
            return goodsService.delGoodsAmount(goodsDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/createGoodsNo")
    public String createGoodsNo() {
        return goodsService.createGoodsNo();
    }
}
