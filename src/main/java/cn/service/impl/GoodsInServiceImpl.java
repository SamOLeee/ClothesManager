package cn.service.impl;

import cn.domain.Goods;
import cn.domain.GoodsIn;
import cn.domain.User;
import cn.entity.PageResult;
import cn.mapper.GoodsInMapper;
import cn.mapper.UserMapper;
import cn.service.GoodsInService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GoodsInServiceImpl implements GoodsInService {

    @Autowired
    private GoodsInMapper goodsInMapper;

    @Override
    public PageResult searchGoodsIn(GoodsIn goodsin, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<GoodsIn> page = goodsInMapper.searchGoodsIn(goodsin);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public void addGoodsIn(GoodsIn goodsin) {
        goodsin.setDatetime(new Date());
        goodsInMapper.addGoodsIn(goodsin);
    }

    public void updateGoodsIn(GoodsIn goodsin) {
        goodsInMapper.updateGoodsIn(goodsin);
    }

    public void delGoodsIn(Integer id) {
        GoodsIn goodsin = this.findGoodsInById(id);
        goodsin.setDelete(1);
        goodsInMapper.updateGoodsIn(goodsin);
    }

    public GoodsIn findGoodsInById(Integer id) {
        return goodsInMapper.findGoodsInById(id);
    }

    public String createGoodsInNo() {
        String randomString = RandomStringUtils.randomAlphanumeric(5);
        String goodsInNo = "RK"+randomString;
        return goodsInNo;
    }
}
