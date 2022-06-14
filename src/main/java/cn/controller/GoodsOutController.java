package cn.controller;

import cn.domain.GoodsIn;
import cn.domain.GoodsOut;
import cn.entity.PageResult;
import cn.entity.Result;
import cn.service.GoodsInService;
import cn.service.GoodsOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goodsOut")
public class GoodsOutController {
    @Autowired
    private GoodsOutService goodsOutService;

    @RequestMapping("/search")
    public ModelAndView searchGoodsOut(GoodsOut goodsout, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        PageResult pageResult = goodsOutService.searchGoodsOut(goodsout, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsOut");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("search", goodsout);
        modelAndView.addObject("pageNUm", pageNum);
        modelAndView.addObject("gourl", request.getRequestURI());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/findGoodsOutById")
    public GoodsOut findGoodsOutById(Integer id) {
/*        System.out.println(10086);
        System.out.println(id);*/
        return goodsOutService.findGoodsOutById(id);
    }

    @ResponseBody
    @RequestMapping("/addGoodsOut")
    public Result addGoodsIn(GoodsOut goodsout) {

        goodsOutService.addGoodsOut(goodsout);
        return new Result(true, "新增成功");
    }

    @ResponseBody
    @RequestMapping("/updateGoodsOut")
    public Result updateGoodsOut(GoodsOut goodsout){
        goodsOutService.updateGoodsOut(goodsout);
        return new Result(true,"修改成功！");
    }

    @ResponseBody
    @RequestMapping("/delGoodsOut")
    public Result delUser(Integer id){
        goodsOutService.delGoodsOut(id);
        return new Result(true,"删除成功");
    }
    @ResponseBody
    @RequestMapping("/createGoodsOutNo")
    public String createGoodsOutNo(){
        return goodsOutService.createGoodsOutNo();
    }
}
