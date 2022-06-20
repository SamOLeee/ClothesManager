package cn.mapper;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.domain.GoodsIn;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;


@Mapper
public interface GoodsDetailMapper {
    @Results(id = "GoodsDetailMapper", value = {
            @Result(id = true, column = "id", property = "iid"),
            @Result(column = "goodsin", property = "did"),
            @Result(column = "for_id", property = "gioid"),
            @Result(column = "detail_no", property = "no"),
            @Result(column = "detail_name", property = "name"),
            @Result(column = "detail_color", property = "color"),
            @Result(column = "detail_size", property = "size"),
            @Result(column = "detail_amount", property = "amount"),
            @Result(column = "detail_type", property = "type"),
            @Result(column = "detail_delete", property = "delete")
    })

    @Select({"<script> " +
            "select gd.* from goodsin gi,goodsdetail gd " +
            "where gd.for_id=gi.gid " +
//            "and gi.gid=gd.for_id "+
            "and gd.for_id = #{gioid} " +
            "<if test=\"iid !=null\"> and id like CONCAT('%',#{iid},'%') </if>" +
            "<if test=\"name !=null\"> and detail_name like CONCAT('%',#{name},'%') </if>" +
            "<if test=\"no !=null\"> and detail_no like CONCAT('%',#{no},'%') </if>" +
            "and detail_type = 1 " +
            "</script>"
    })
    Page<GoodsDetail> searchGoodsInDetail(GoodsDetail goodsDetail);


    @ResultMap("GoodsDetailMapper")
    @Select({"<script> " +
            "select gd.* from goodsin gi,goodsdetail gd " +
            "where gd.for_id=gi.gid " +
//            "and gi.gid=gd.for_id "+
            "and gd.for_id = #{gioid} " +
            "<if test=\"iid !=null\"> and id like CONCAT('%',#{iid},'%') </if>" +
            "<if test=\"name !=null\"> and detail_name like CONCAT('%',#{name},'%') </if>" +
            "<if test=\"no !=null\"> and detail_no like CONCAT('%',#{no},'%') </if>" +
            "and detail_type = 0 " +
            "</script>"
    })
    Page<GoodsDetail> searchGoodsOutDetail(GoodsDetail goodsDetail);


    @ResultMap("GoodsDetailMapper")
    @Select({"<script> " +
            "select * from goodsdetail " +
            "where 1 = 1 " +
            "<if test=\"iid !=null\"> and id like CONCAT('%',#{iid},'%') </if>" +
            "<if test=\"name !=null\"> and detail_name like CONCAT('%',#{name},'%') </if>" +
            "<if test=\"no !=null\"> and detail_no like CONCAT('%',#{no},'%') </if>" +
            "<if test=\"type!=null\"> and detail_type like CONCAT('%',#{type},'%') </if>" +
            "</script>"
    })
    Page<GoodsDetail> searchGoodsAllDetail(GoodsDetail goodsDetail);

    void addGoodsDetail(GoodsDetail goodsDetail);

    void updateGoodsDetail(GoodsDetail goodsDetail);

    void editGoodsDetail(GoodsDetail goodsDetail);

    @ResultMap("GoodsDetailMapper")
    @Select("select * from goodsdetail where id = #{iid}")
    GoodsDetail findGoodsDetailById(Integer id);
}
