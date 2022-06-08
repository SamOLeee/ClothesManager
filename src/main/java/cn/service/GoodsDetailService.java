package cn.service;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.entity.PageResult;

public interface GoodsDetailService {
    PageResult searchGoodsInDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize);
    GoodsDetail findGoodsInDetailByNo(String no);
}
