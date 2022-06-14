package cn.service;

import cn.domain.GoodsIn;
import cn.domain.GoodsOut;
import cn.entity.PageResult;

public interface GoodsOutService {
    PageResult searchGoodsOut(GoodsOut goodsout, Integer pageNum, Integer pageSize);

    GoodsOut findGoodsOutById(Integer id);

    void addGoodsOut(GoodsOut goodsout);
    void updateGoodsOut(GoodsOut goodsout);
    void delGoodsOut(Integer id);
    String createGoodsOutNo();
}
