package cn.mapper;

import cn.domain.GoodsDetail;
import cn.domain.GoodsIn;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;


@Mapper
public interface GoodsDetailMapper {
    @Select("select * from goodsdetail where gid = #{gioid}")
    @Results(id="GoodsDetailMapper",value={
            @Result(id = true, column = "detail_id", property = "id"),
            @Result(column = "gid", property = "gioid"),
            @Result(column = "detail_no", property = "no"),
            @Result(column = "detail_name", property = "name"),
            @Result(column = "detail_color", property = "color"),
            @Result(column = "detail_size", property = "size"),
            @Result(column = "detail_amount", property = "amount"),
            @Result(column = "detail_type", property = "type"),
            @Result(column = "detail_delete", property = "delete")
//            @Result(column = "goodsin.gid",property = "ggid")
    })
    Page<GoodsDetail> searchGoodsInDetail(Integer gid);
//    @Select({"<script>" +
//            "select * from goodsdetail gd,goodsin gi " +
//            "where 1 = 1 " +
////            "AND  detail_id = #{id} " +
//            "AND ' goodsdetail.gid' = #{ggid} " +
//            "AND 'goodsin.gid' = #{gioid} " +
//            "AND detail_type = 1 " +
//            "</script>"
//    })
//    @Select("select gd.* from goodsin gi,goodsdetail gd where gi.gid=#{gioid} and gd.gid=gi.gid and gd.detail_type=1")
//    @Select("select gd.* from goodsin gi,goodsdetail gd where gi.gid=#{gioid} and gd.gid=#{gioid} and gd.gid=gi.gid and gd.detail_type=1")
//    @Select("select * from goodsdetail ")

//    Page<GoodsDetail> searchGoodsInDetail(GoodsDetail goodsDetail);



    @ResultMap("GoodsDetailMapper")
    @Select("select * from goodsdetail where detail_no = #{no}")
    GoodsDetail findGoodsInDetailByNo(String no);
}
