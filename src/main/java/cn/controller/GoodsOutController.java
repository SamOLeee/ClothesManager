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
    //出库单的显示和查询
    public ModelAndView searchGoodsOut(GoodsOut goodsout, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        //调用service
        PageResult pageResult = goodsOutService.searchGoodsOut(goodsout, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsOut");
        //分页数据信息
        modelAndView.addObject("pageResult", pageResult);
        //数据信息回显示
        modelAndView.addObject("search", goodsout);
        //当前页码数
        modelAndView.addObject("pageNUm", pageNum);
        //分页再次请求的地址
        modelAndView.addObject("gourl", request.getRequestURI());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/findGoodsOutById")
    //根据id查询出库单
    public GoodsOut findGoodsOutById(Integer id) {
/*        System.out.println(10086);
        System.out.println(id);*/
        return goodsOutService.findGoodsOutById(id);
    }

    @ResponseBody
    @RequestMapping("/addGoodsOut")
    //出库单新增
    public Result addGoodsIn(GoodsOut goodsout) {
        try {
            goodsOutService.addGoodsOut(goodsout);
            return new Result(true, "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/updateGoodsOut")
    //出库单修改
    public Result updateGoodsOut(GoodsOut goodsout) {
        try {
            goodsOutService.updateGoodsOut(goodsout);
            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/delGoodsOut")
    //出库单删除，实际上为更新
    public Result delUser(Integer id) {
        try {
            goodsOutService.delGoodsOut(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/createGoodsOutNo")
    //随即生成出库单据凭证
    public String createGoodsOutNo() {
        return goodsOutService.createGoodsOutNo();
    }
}
