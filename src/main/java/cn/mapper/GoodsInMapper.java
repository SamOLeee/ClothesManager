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
            "<if test=\"no !=null\"> and goodsIn_no like CONCAT('%',#{no},'%') </if>" +
            "</script>"
    })
    @Results(id ="GoodsInMap" ,value={
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名
            @Result(id = true,column = "gid",property = "id"),
            @Result(column = "goodsIn_no",property = "no"),
            @Result(column = "goodsIn_library",property = "library"),
            @Result(column = "goodsIn_datetime",property = "datetime"),
            @Result(column = "goodsIn_operator",property = "operator"),
            @Result(column = "goodsIn_source",property = "source"),
            @Result(column = "goodsIn_delete",property = "delete")
    })
    Page<GoodsIn> searchGoodsIn(GoodsIn goodsin);//查询入库单

//    @Select("select * from goodsin where gid = #{id}")
//    List<GoodsIn> selectGoodsInById(Integer gid);

    @ResultMap("GoodsInMap")
    @Select("select * from goodsIn where gid=#{id}")
    GoodsIn findGoodsInById(Integer id);//根据id查询入库单

    void addGoodsIn(GoodsIn goodsin);//新增入库单


    void updateGoodsIn(GoodsIn goodsin);//更新入库单
}
