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
    //显示和查询入库单信息
    public ModelAndView searchGoodsIn(GoodsIn goodsin, Integer pageNum, Integer pageSize, HttpServletRequest request) {
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
    //根据id查询入库单
    public GoodsIn findGoodsInById(Integer id) {
/*        System.out.println(10086);
        System.out.println(id);*/
        return goodsInService.findGoodsInById(id);
    }

    @ResponseBody
    @RequestMapping("/addGoodsIn")
    //新增入库单
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
    //更新入库单
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
    //删除入库单，实际为修改入库单
    public Result delGoodsIn(Integer id) {
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
    //随机生成入库单据凭证
    public String createGoodsInNo() {
        return goodsInService.createGoodsInNo();
    }
}
