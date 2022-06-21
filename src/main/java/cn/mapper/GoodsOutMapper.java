package cn.mapper;

import cn.domain.GoodsIn;
import cn.domain.GoodsOut;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GoodsOutMapper {
    @Select({"<script>" +
            "select * from goodsOut " +
            "where 1=1 " +
            "<if test=\"id != null\"> AND  gid  like  CONCAT('%',#{id},'%')</if>" +
            "<if test=\"no !=null\"> and goodsOut_no like CONCAT('%',#{no},'%') </if>" +
            "</script>"
    })
    @Results(id ="GoodsOutMap" ,value={
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名
            @Result(id = true,column = "gid",property = "id"),
            @Result(column = "goodsOut_no",property = "no"),
            @Result(column = "goodsOut_library",property = "library"),
            @Result(column = "goodsOut_datetime",property = "datetime"),
            @Result(column = "goodsOut_operator",property = "operator"),
            @Result(column = "goodsOut_goto",property = "send"),
            @Result(column = "goodsOut_delete",property = "delete")
    })
    Page<GoodsOut> searchGoodsOut(GoodsOut goodsout);//查询出库单

    @Select("select * from goodsOut where gid=#{id}")
    @ResultMap("GoodsOutMap")
    GoodsOut findGoodsOutById(Integer id);//根据id查询出库单

    void addGoodsOut(GoodsOut goodsout);//新增出库单
    void updateGoodsOut(GoodsOut goodsout);//更新出库单
}
