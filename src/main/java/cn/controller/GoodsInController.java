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


@Controller
@RequestMapping("/goodsIn")
public class GoodsInController {

    @Autowired
    private GoodsInService goodsInService;

    @RequestMapping("/search")
    public ModelAndView searchGoods(GoodsIn goodsin, Integer pageNum, Integer pageSize) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        PageResult pageResult = goodsInService.searchGoodsIn(goodsin, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsIn");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("search", goodsin);
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("gourl", "/goodsIn/search");
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

        goodsInService.addGoodsIn(goodsin);
        return new Result(true, "新增成功");
    }

    @ResponseBody
    @RequestMapping("/updateGoodsIn")
    public Result updateGoodsIn(GoodsIn goodsin){
        goodsInService.updateGoodsIn(goodsin);
        return new Result(true,"修改成功！");
    }

    @ResponseBody
    @RequestMapping("/delGoodsIn")
    public Result delUser(Integer id){
        goodsInService.delGoodsIn(id);
        return new Result(true,"删除成功");
    }
}
