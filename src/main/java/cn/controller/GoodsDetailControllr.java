package cn.controller;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.domain.GoodsIn;
import cn.domain.User;
import cn.entity.PageResult;
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



    @ResponseBody
    @RequestMapping("/findGoodsInDetailByNo")
    public GoodsDetail findGoodsInDetailByNo(String no) {
/*        System.out.println(10086);
        System.out.println(id);*/
        return goodsDetailService.findGoodsInDetailByNo(no);
    }




    @RequestMapping("/searchInDetail")
    public ModelAndView searchGoodsInDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        PageResult pageResult = goodsDetailService.searchGoodsInDetail(goodsDetail, pageNum, pageSize);

        System.out.println(goodsDetail);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsInDetail");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("searchInDetail", goodsDetail);

        System.out.println(goodsDetail.getName());
        System.out.println(goodsDetail.getAmount());
        System.out.println(pageResult.getTotal());

        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("gourl", "/goodsDetail/searchInDetail");
        return modelAndView;
    }

}
