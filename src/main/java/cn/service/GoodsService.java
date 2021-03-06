package cn.service;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.domain.User;
import cn.entity.PageResult;
import cn.entity.Result;

import java.util.List;

public interface GoodsService {
    /*    Goods addGoods(Goods goods);*/
    PageResult searchGoods(Goods goods, Integer pageNum, Integer pageSize);

    Goods findGoodsById(Integer id);
    List<Goods> getAllGoodsIn();
    void addGoods(Goods goods);
    void updateGoods(Goods goods);
    void delGoods(Integer id);

    Result addGoodsAmount(Goods goods);
    Result reduceGoodsAmount(Goods goods);
    Result updateGoodsAmount(GoodsDetail goodsDetail);
    Result delGoodsAmount(GoodsDetail goodsDetail);
    String createGoodsNo();
    Integer checkGoodsExist(String name,String color,String size);
    Goods findGoodsByNCS(String name,String color,String size);
}
