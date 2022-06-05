package cn.controller;

import cn.domain.Goods;
import cn.domain.User;
import cn.entity.PageResult;
import cn.service.GoodsService;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/search")
    public ModelAndView searchGoods(Goods goods,Integer pageNum,Integer pageSize){
        if(pageNum == null) pageNum=1;
        if(pageSize == null) pageSize=1;

        PageResult pageResult = goodsService.searchGoods(goods,pageNum,pageSize);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("goods");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("search",goods);
        modelAndView.addObject("pageNUm",pageNum);
        modelAndView.addObject("gourl","/goods/search");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping ("/findGoodsById")
    public Goods findUserById(Integer id){
/*        System.out.println(10086);
        System.out.println(id);*/
        return goodsService.findGoodsById(id);
    }
}
