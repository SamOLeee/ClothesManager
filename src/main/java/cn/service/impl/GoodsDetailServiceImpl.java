package cn.service.impl;

import cn.domain.GoodsDetail;
import cn.entity.PageResult;
import cn.mapper.GoodsDetailMapper;
import cn.service.GoodsDetailService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageException;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;


//    @Override
//    public PageResult searchGoods(Goods goods,Integer pageNum,Integer pageSize){
//        PageHelper.startPage(pageNum,pageSize);
//        Page<Goods>page=goodsMapper.searchGoods(goods);
//        return new PageResult(page.getTotal(),page.getResult());
//    }

    @Override
    public PageResult searchGoodsInDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        System.out.println("serviccImpl ====="+goodsDetail);
        Page<GoodsDetail>page=goodsDetailMapper.searchGoodsInDetail(goodsDetail);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public GoodsDetail findGoodsInDetailByNo(String no){
        return goodsDetailMapper.findGoodsInDetailByNo(no);
    }

    public void addGoodsDetail(GoodsDetail goodsDetail){
        goodsDetailMapper.addGoodsDetail(goodsDetail);
    }
}
