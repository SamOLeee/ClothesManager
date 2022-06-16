package cn.mapper;

import cn.domain.Goods;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select({"<script>" +
            "select * from goods " +
            "where 1=1 " +
            "<if test=\"id != null\"> AND  goods_id  like  CONCAT('%',#{id},'%')</if>" +
            "<if test=\"name != null\"> AND goods_name like  CONCAT('%', #{name},'%') </if>" +
            "<if test=\"no !=null\"> and goods_no like CONCAT('%',#{no},'%') </if>" +
            "</script>"
    })
    @Results(id = "GoodsMap", value = {
            @Result(id = true, column = "goods_id", property = "id"),
            @Result(column = "goods_name", property = "name"),
            @Result(column = "goods_no", property = "no"),
            @Result(column = "goods_color", property = "color"),
            @Result(column = "goods_size", property = "size"),
            @Result(column = "goods_amount", property = "amount"),
            @Result(column = "goods_delete", property = "delete")
    })
    Page<Goods> searchGoods(Goods goods);


    @Select("select * from goods where goods_id=#{id}")
    @ResultMap("GoodsMap")
    Goods findGoodsById(Integer id);

    @Select("select * from goods where goods_name=#{name} and goods_color=#{color} and goods_size=#{size} ")
    @ResultMap("GoodsMap")
    Goods findGoodsByNCS(@Param("name") String name,@Param("color") String color,@Param("size") String size);


    @Select("select * from goods where goods_delete = 0")
    @ResultMap("GoodsMap")
    List<Goods> getAllGoodsIn();

    void addGoods(Goods goods);

    void updateGoods(Goods goods);
}
