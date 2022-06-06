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
            "<if test=\"gid != null\"> AND  gid  like  CONCAT('%',#{gid},'%')</if>" +
            "</script>"
    })
    @Results(id ="GoodsOutMap" ,value={
            @Result(id = true,column = "gid",property = "gid"),
            @Result(column = "goodsOut_no",property = "no"),
            @Result(column = "goodsOut_library",property = "library"),
            @Result(column = "goodsOut_datetime",property = "datetime"),
            @Result(column = "goodsOut_operator",property = "operator"),
            @Result(column = "goodsOut_goto",property = "Goto"),
            @Result(column = "goodsOut_delete",property = "delete")
    })
    Page<GoodsOut> searchGoodsOut(GoodsOut goodsout);

    @Select("select * from goodsOut where gid=#{gid}")
    @ResultMap("GoodsOutMap")
    GoodsOut findGoodsOutById(Integer id);

    void addGoodsOut(GoodsOut goodsout);
    void updateGoodsOut(GoodsOut goodsout);

    void delGoodsOut(GoodsOut goodsout);
}
