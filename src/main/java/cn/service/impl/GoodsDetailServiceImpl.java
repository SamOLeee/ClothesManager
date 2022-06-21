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
        Page<GoodsDetail>page=goodsDetailMapper.searchGoodsInDetail(goodsDetail);//获取明细存在page实体类中
        return new PageResult(page.getTotal(),page.getResult());
    }


    @Override
    public GoodsDetail findGoodsDetailById(Integer id){
        return goodsDetailMapper.findGoodsDetailById(id);
    }

    public void addGoodsDetail(GoodsDetail goodsDetail){
        goodsDetailMapper.addGoodsDetail(goodsDetail);
    }

    public void updateGoodsDetail(GoodsDetail goodsDetail){
        goodsDetailMapper.updateGoodsDetail(goodsDetail);
    }

    public void delGoodsDetail(Integer id){
        GoodsDetail goodsDetail=this.findGoodsDetailById(id);
        goodsDetail.setDelete(1);//逻辑删除，将明细的delete修改成0表示删除
        goodsDetailMapper.updateGoodsDetail(goodsDetail);
    }




    @Override
    public PageResult searchGoodsOutDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<GoodsDetail>page=goodsDetailMapper.searchGoodsOutDetail(goodsDetail);
        return new PageResult(page.getTotal(),page.getResult());
    }


    @Override
    public PageResult searchGoodsAllDetail(GoodsDetail goodsDetail, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<GoodsDetail>page=goodsDetailMapper.searchGoodsAllDetail(goodsDetail);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
