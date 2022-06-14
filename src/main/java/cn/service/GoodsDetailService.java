package cn.service;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.entity.PageResult;

import java.awt.geom.RectangularShape;
import java.util.List;

public interface GoodsDetailService {
    PageResult searchGoodsInDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize);

    void addGoodsDetail(GoodsDetail goodsDetail);

    GoodsDetail findGoodsDetailById(Integer id);

    void delGoodsDetail(Integer id);

    void updateGoodsDetail(GoodsDetail goodsDetail);


    PageResult searchGoodsOutDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize);

    PageResult searchGoodsAllDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize);
}
