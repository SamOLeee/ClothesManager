package cn.service.impl;

import cn.domain.Goods;
import cn.domain.User;
import cn.entity.PageResult;
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
    public PageResult searchGoods(Goods goods,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
//        System.out.println("serviccImpl ====="+goods);
        Page<Goods>page=goodsMapper.searchGoods(goods);
        return new PageResult(page.getTotal(),page.getResult());
    }

    public Goods findGoodsById(Integer id) {
        return goodsMapper.findGoodsById(id);
    }

    public List<Goods> getAllGoodsIn(){return goodsMapper.getAllGoodsIn();}

    public void addGoods(Goods goods){
        goodsMapper.addGoods(goods);
    }

    public void updateGoods(Goods goods){goodsMapper.updateGoods(goods);}

    public void delGoods(Integer id){
        Goods goods = this.findGoodsById(id);
        goods.setDelete(1);
        goodsMapper.updateGoods(goods);
    }
}
