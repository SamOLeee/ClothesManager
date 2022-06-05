package cn.service;

import cn.domain.Goods;
import cn.domain.User;
import cn.entity.PageResult;

public interface GoodsService {
    /*    Goods addGoods(Goods goods);*/
    PageResult searchGoods(Goods goods, Integer pageNum, Integer pageSize);

    Goods findGoodsById(Integer id);
}
