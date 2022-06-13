package cn.service.impl;

import cn.domain.Goods;
import cn.entity.PageResult;
import cn.entity.Result;
import cn.mapper.GoodsMapper;
import cn.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageResult searchGoods(Goods goods, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
//        System.out.println("serviccImpl ====="+goods);
        Page<Goods> page = goodsMapper.searchGoods(goods);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public Goods findGoodsById(Integer id) {
        return goodsMapper.findGoodsById(id);
    }

    public List<Goods> getAllGoodsIn() {
        return goodsMapper.getAllGoodsIn();
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
}
