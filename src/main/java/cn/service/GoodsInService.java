package cn.service;

import cn.domain.Goods;
import cn.domain.GoodsIn;
import cn.entity.PageResult;

public interface GoodsInService {

    PageResult searchGoodsIn(GoodsIn goodsin, Integer pageNum, Integer pageSize);

    GoodsIn findGoodsInById(Integer id);

    void addGoodsIn(GoodsIn goodsIn);
    void updateGoodsIn(GoodsIn goodsin);
    void delGoodsIn(Integer id);
    String createGoodsInNo();
}
