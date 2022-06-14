package cn.service.impl;

import cn.domain.GoodsIn;
import cn.domain.GoodsOut;
import cn.entity.PageResult;
import cn.mapper.GoodsInMapper;
import cn.mapper.GoodsOutMapper;
import cn.service.GoodsOutService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GoodsOutServiceImpl implements GoodsOutService {
    @Autowired
    private GoodsOutMapper goodsOutMapper;

    @Override
    public PageResult searchGoodsOut(GoodsOut goodsout, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<GoodsOut> page=goodsOutMapper.searchGoodsOut(goodsout);
        return new PageResult(page.getTotal(),page.getResult());
    }

    public void addGoodsOut(GoodsOut goodsout){
        goodsout.setDatetime(new Date());
        goodsOutMapper.addGoodsOut(goodsout);
    }

    public void updateGoodsOut(GoodsOut goodsout){ goodsOutMapper.updateGoodsOut(goodsout);}

    public void delGoodsOut(Integer id){
        GoodsOut goodsout=this.findGoodsOutById(id);
        goodsout.setDelete(1);
        goodsOutMapper.updateGoodsOut(goodsout);
    }

    public GoodsOut findGoodsOutById(Integer id) {
        return goodsOutMapper.findGoodsOutById(id);
    }

    public String createGoodsOutNo(){
        String randomString = RandomStringUtils.randomAlphanumeric(5);
        String GoodsOutNo = "CK"+randomString;
        return GoodsOutNo;
    }
}
