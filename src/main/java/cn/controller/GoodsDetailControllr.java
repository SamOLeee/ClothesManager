package cn.controller;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.domain.GoodsIn;
import cn.domain.User;
import cn.entity.PageResult;
import cn.entity.Result;
import cn.service.GoodsDetailService;
import cn.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goodsDetail")
public class GoodsDetailControllr {
    @Autowired
    private GoodsDetailService goodsDetailService;

    @Autowired
    private GoodsService goodsService;

/////入库明细操作
    @RequestMapping("/searchInDetail")
    public ModelAndView searchGoodsInDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        PageResult pageResult = goodsDetailService.searchGoodsInDetail(goodsDetail, pageNum, pageSize);

        System.out.println(goodsDetail);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsInDetail");
        modelAndView.addObject("pageResult", pageResult);
//        modelAndView.addObject("pageId", pageResult);
        modelAndView.addObject("searchInDetail", goodsDetail);

        System.out.println(goodsDetail.getName());
        System.out.println(goodsDetail.getAmount());
        System.out.println(pageResult.getTotal());

        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("gourl", "/goodsDetail/searchInDetail");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/findGoodsDetailById")
    public GoodsDetail findGoodsInDetailById(Integer id){
        System.out.println("查找goodsDetail " + goodsDetailService.findGoodsDetailById(id));
        return goodsDetailService.findGoodsDetailById(id);
    }

    @ResponseBody
    @RequestMapping("/addGoodsInDetail")
    public Result addGoodsDetail(GoodsDetail goodsDetail) {

        goodsDetailService.addGoodsDetail(goodsDetail);
        return new Result(true, "新增成功");
    }


    @ResponseBody
    @RequestMapping("/updateGoodsDetail")
    public Result updateGoodsDetail(GoodsDetail goodsDetail){
        goodsDetailService.updateGoodsDetail(goodsDetail);
        return new Result(true,"修改成功！");
    }

    @ResponseBody
    @RequestMapping("/delGoodsDetail")
    public Result delGoodsDetail(Integer id){
        goodsDetailService.delGoodsDetail(id);
        return new Result(true,"删除成功！");
    }




////////出库明细操作
@RequestMapping("/searchOutDetail")
public ModelAndView searchGoodsOutDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize) {
    if (pageNum == null) pageNum = 1;
    if (pageSize == null) pageSize = 10;

    PageResult pageResult = goodsDetailService.searchGoodsOutDetail(goodsDetail, pageNum, pageSize);

    System.out.println(goodsDetail);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("goodsOutDetail");
    modelAndView.addObject("pageResult2", pageResult);
//        modelAndView.addObject("pageId", pageResult);
    modelAndView.addObject("searchOutDetail", goodsDetail);

    System.out.println(goodsDetail.getName());
    System.out.println(goodsDetail.getAmount());
    System.out.println(pageResult.getTotal());

    modelAndView.addObject("pageNum", pageNum);
    modelAndView.addObject("gourl", "/goodsDetail/searchOutDetail");
    return modelAndView;
}
}
