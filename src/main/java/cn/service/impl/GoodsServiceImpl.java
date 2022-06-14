package cn.service.impl;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.entity.PageResult;
import cn.entity.Result;
import cn.mapper.GoodsDetailMapper;
import cn.mapper.GoodsMapper;
import cn.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;


    @Override
    public PageResult searchGoods(Goods goods, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
//        System.out.println("serviccImpl ====="+goods);
        Page<Goods> page = goodsMapper.searchGoods(goods);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public GoodsDetail findGoodsDetailById(Integer id) {
        return goodsDetailMapper.findGoodsDetailById(id);
    }

    public Goods findGoodsById(Integer id) {
        return goodsMapper.findGoodsById(id);
    }

    public Goods findGoodsByNCS(String name, String color, String size) {
        return goodsMapper.findGoodsByNCS(name, color, size);
    }


    public List<Goods> getAllGoodsIn() {
        return goodsMapper.getAllGoodsIn();
    }

    public String createGoodsNo() {
        String randomString = RandomStringUtils.randomAlphabetic(5);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String t = dateFormat.format(new Date());
        String goodsNo = randomString + t;
        return goodsNo;
    }

    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }

    public void updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
    }

    public void delGoods(Integer id) {
        Goods goods = this.findGoodsById(id);
        goods.setDelete(1);
        goodsMapper.updateGoods(goods);
    }

    public Result addGoodsAmount(Goods goods) {
        Goods gs = this.findGoodsById(goods.getId());

        gs.setAmount(gs.getAmount() + goods.getAmount());
        goodsMapper.updateGoods(gs);
        return new Result(true, "入库成功！当前 " + gs.getName() + " 的库存量为 " + gs.getAmount() + "件！");
    }


    public Result reduceGoodsAmount(Goods goods) {
        Goods gs = this.findGoodsById(goods.getId());
        System.out.println("gs===" + gs);
        if (gs.getAmount() < goods.getAmount())
            return new Result(false, "库存不足，出库失败！当前 " + gs.getName() + " 的库存量为 " + gs.getAmount() + "件！");
        gs.setAmount(gs.getAmount() - goods.getAmount());
        goodsMapper.updateGoods(gs);
        return new Result(true, "出库成功！当前 " + gs.getName() + " 的库存量为 " + gs.getAmount() + "件！");
    }

    public Result updateGoodsAmount(GoodsDetail goodsDetail) {
        GoodsDetail gsd = this.findGoodsDetailById(goodsDetail.getIid());
        System.out.println("name==" + gsd.getName() + "  color==" + gsd.getColor() + "  size==" + gsd.getSize());
        Goods gs = this.findGoodsByNCS(gsd.getName(), gsd.getColor(), gsd.getSize());
        System.out.println("gsd====" + gsd);
        System.out.println("gs=====" + gs);
        Integer sum = 0;
        if (gsd.getType() == 1) {
            sum = gs.getAmount() - gsd.getAmount() + goodsDetail.getAmount();
            if (sum < 0)
                return new Result(false, "库存不足，修改失败！当前 " + gs.getName() + " 的库存量为 " + gs.getAmount() + " 件！");
        } else {
            sum = gs.getAmount() + gsd.getAmount() - goodsDetail.getAmount();
            if (sum < 0)
                return new Result(false, "库存不足，修改失败！当前 " + gs.getName() + " 的库存量为 " + gs.getAmount() + " 件！");
        }
        gs.setAmount(sum);
        goodsMapper.updateGoods(gs);
        return new Result(true, "修改成功！当前 " + gs.getName() + " 的库存量为 " + sum + " 件！");
    }

    public Result delGoodsAmount(GoodsDetail goodsDetail) {
        GoodsDetail gsd = this.findGoodsDetailById(goodsDetail.getIid());
        System.out.println("name==" + gsd.getName() + "  color==" + gsd.getColor() + "  size==" + gsd.getSize());
        Goods gs = this.findGoodsByNCS(gsd.getName(), gsd.getColor(), gsd.getSize());
        System.out.println("gsd====" + gsd);
        System.out.println("gs=====" + gs);
        Integer sum = 0;
        if (gsd.getType() == 1) {
            sum = gs.getAmount() - gsd.getAmount();
            if (sum < 0)
                return new Result(false, "库存不足，删除失败！当前 " + gs.getName() + " 的库存量为 " + gs.getAmount() + " 件！");
        } else
            sum = gs.getAmount() + gsd.getAmount();
        gs.setAmount(sum);
        goodsMapper.updateGoods(gs);
        return new Result(true, "删除成功！当前 " + gs.getName() + " 的库存量为 " + sum + " 件！");
    }
}
