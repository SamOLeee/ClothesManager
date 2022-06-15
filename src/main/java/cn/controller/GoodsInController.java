package cn.controller;

import cn.domain.Goods;
import cn.domain.GoodsIn;
import cn.entity.PageResult;
import cn.entity.Result;
import cn.service.GoodsInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpClient;


@Controller
@RequestMapping("/goodsIn")
public class GoodsInController {

    @Autowired
    private GoodsInService goodsInService;

    @RequestMapping("/search")
    public ModelAndView searchGoods(GoodsIn goodsin, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        PageResult pageResult = goodsInService.searchGoodsIn(goodsin, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsIn");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("search", goodsin);
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("gourl", request.getRequestURI());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/findGoodsInById")
    public GoodsIn findGoodsInById(Integer id) {
/*        System.out.println(10086);
        System.out.println(id);*/
        return goodsInService.findGoodsInById(id);
    }

    @ResponseBody
    @RequestMapping("/addGoodsIn")
    public Result addGoodsIn(GoodsIn goodsin) {
        try {
            goodsInService.addGoodsIn(goodsin);
            return new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/updateGoodsIn")
    public Result updateGoodsIn(GoodsIn goodsin) {
        try {
            goodsInService.updateGoodsIn(goodsin);
            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/delGoodsIn")
    public Result delUser(Integer id) {
        try {
            goodsInService.delGoodsIn(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/createGoodsInNo")
    public String createGoodsInNo() {
        return goodsInService.createGoodsInNo();
    }
}
