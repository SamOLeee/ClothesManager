package cn.service;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.entity.PageResult;

import java.util.List;

public interface GoodsDetailService {
    PageResult searchGoodsInDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize);
    void addGoodsDetail(GoodsDetail goodsDetail);
    GoodsDetail findGoodsInDetailByNo(String no);
}
