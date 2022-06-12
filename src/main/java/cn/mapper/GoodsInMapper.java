package cn.mapper;

import cn.domain.GoodsIn;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsInMapper {
    @Select({"<script>" +
            "select * from goodsIn " +
            "where 1=1 " +
            "<if test=\"id != null\"> AND  gid  like  CONCAT('%',#{id},'%')</if>" +
            "</script>"
    })
    @Results(id ="GoodsInMap" ,value={
            @Result(id = true,column = "gid",property = "id"),
            @Result(column = "goodsIn_no",property = "no"),
            @Result(column = "goodsIn_library",property = "library"),
            @Result(column = "goodsIn_datetime",property = "datetime"),
            @Result(column = "goodsIn_operator",property = "operator"),
            @Result(column = "goodsIn_source",property = "source"),
            @Result(column = "goodsIn_delete",property = "delete")
    })
    Page<GoodsIn> searchGoodsIn(GoodsIn goodsin);

//    @Select("select * from goodsin where gid = #{id}")
//    List<GoodsIn> selectGoodsInById(Integer gid);

    @ResultMap("GoodsInMap")
    @Select("select * from goodsIn where gid=#{id}")
    GoodsIn findGoodsInById(Integer id);

    void addGoodsIn(GoodsIn goodsin);


    void updateGoodsIn(GoodsIn goodsin);
}
