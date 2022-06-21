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
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名
            @Result(id = true, column = "goods_id", property = "id"),
            @Result(column = "goods_name", property = "name"),
            @Result(column = "goods_no", property = "no"),
            @Result(column = "goods_color", property = "color"),
            @Result(column = "goods_size", property = "size"),
            @Result(column = "goods_amount", property = "amount"),
            @Result(column = "goods_delete", property = "delete")
    })
    Page<Goods> searchGoods(Goods goods);//查询货物信息


    @Select("select * from goods where goods_id=#{id}")
    @ResultMap("GoodsMap")
    Goods findGoodsById(Integer id);//根据id查询货物

    @Select("select * from goods where goods_name=#{name} and goods_color=#{color} and goods_size=#{size} ")
    @ResultMap("GoodsMap")
    Goods findGoodsByNCS(@Param("name") String name, @Param("color") String color, @Param("size") String size);
    //根据名称、色号、尺码查询货物


    @Select("select * from goods where goods_delete = 0")
    @ResultMap("GoodsMap")
    List<Goods> getAllGoodsIn();//获取所有货物


    @Select("select count(goods_name) from goods where goods_name=#{name} and goods_color=#{color} and goods_size=#{size} ")
    Integer checkGoodsExist(@Param("name") String name, @Param("color") String color, @Param("size") String size);
    //根据名称、色号、尺码判断货物是否存在

    void addGoods(Goods goods);//新增货物

    void updateGoods(Goods goods);//更新货物
}
