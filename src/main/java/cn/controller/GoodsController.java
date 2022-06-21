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
    //显示货物和查询货物
    public ModelAndView searchGoods(Goods goods, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        if (pageNum == null) pageNum = 1;
        if (pageSize == null) pageSize = 10;

        //调用service
        PageResult pageResult = goodsService.searchGoods(goods, pageNum, pageSize);//将货物信息和页码封装在pageResult内
        System.out.println(goods);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goods");
        //分页数据信息
        modelAndView.addObject("pageResult", pageResult);
        //数据信息回显示
        modelAndView.addObject("search", goods);
        //当前页码数
        modelAndView.addObject("pageNum", pageNum);
        //分页再次请求的地址
        modelAndView.addObject("gourl", request.getRequestURI());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/findGoodsById")
    //根据id查找货物
    public Goods findGoodsById(Integer id) {
/*        System.out.println(10086);
        System.out.println(id);*/
        return goodsService.findGoodsById(id);
    }

    @ResponseBody
    @RequestMapping("/getAllGoodsIn")
    public void getAllGoodsIn(HttpServletRequest request, HttpServletResponse response) {
        //获取所有的货物信息并和session做关联
        request.getSession().setAttribute("GOODS", goodsService.getAllGoodsIn());
        try {
            response.sendRedirect("/Clothes/admin/main.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("/addGoods")
    //新增货物
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
    //更新货物信息
    public Result updateGoods(Goods goods) {
        try {
            goodsService.updateGoods(goods);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误！");
        }
    }

    @ResponseBody
    @RequestMapping("/delGoods")
    //逻辑删除货物，实际为修改货物
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
    //库存数量增加
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
    //库存数量减少
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
    //库存数量更新
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
    //删除明细时库存变化
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
    //随机生成货号
    public String createGoodsNo() {
        return goodsService.createGoodsNo();
    }

    @ResponseBody
    @PostMapping("/checkGoods")
    //货物新增时判断货物是否存在
    public Result checkGoods(Goods goods) {
        System.out.println(goods);
        Goods gs = goodsService.findGoodsByNCS(goods.getName(), goods.getColor(), goods.getSize());
        if (gs != null) {
            return new Result(false, "已存在该类型货物!");
        } else {
            return new Result(true, "货物可用!");
        }
    }

    @ResponseBody
    @PostMapping("/checkGoodsExist")
    //货物修改时判断货物是否存在
    public Result checkGoodsExist(Goods goods) {
        System.out.println("修改==="+goods);
        Integer cnt = goodsService.checkGoodsExist(goods.getName(), goods.getColor(), goods.getSize());
        System.out.println("数量==="+cnt);
        if (cnt >= 1) {
            return new Result(false, "已存在该类型货物!");
        } else {
            return new Result(true, "货物可用!");
        }
    }
}
