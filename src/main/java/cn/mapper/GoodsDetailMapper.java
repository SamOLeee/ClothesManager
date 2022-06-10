package cn.mapper;

import cn.domain.Goods;
import cn.domain.GoodsDetail;
import cn.domain.GoodsIn;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;


@Mapper
public interface GoodsDetailMapper {
    @Results(id="GoodsDetailMapper",value={
            @Result(id = true,column = "id", property = "iid"),
            @Result( column = "detail_id", property = "id"),
            @Result(column = "for_id", property = "gioid"),
            @Result(column = "detail_no", property = "no"),
            @Result(column = "detail_name", property = "name"),
            @Result(column = "detail_color", property = "color"),
            @Result(column = "detail_size", property = "size"),
            @Result(column = "detail_amount", property = "amount"),
            @Result(column = "detail_type", property = "type"),
            @Result(column = "detail_delete", property = "delete")
    })
    //select gd.* from goodsin gi,goodsdetail gd where gd.for_id=gi.gid and gi.gid=gd.for_id and gd.for_id = 2 and gd.detail_type=1
    @Select({"<script> " +
            "select gd.* from goodsin gi,goodsdetail gd " +
            "where gd.for_id=gi.gid "+
//            "and gi.gid=gd.for_id "+
            "and gd.for_id = #{gioid} "+
            "and detail_type = 1 " +
            "</script>"
    })
    Page<GoodsDetail> searchGoodsInDetail(GoodsDetail goodsDetail);


    void addGoodsDetail(GoodsDetail goodsDetail);

    @ResultMap("GoodsDetailMapper")
    @Select("select * from goodsdetail where detail_no = #{no}")
    GoodsDetail findGoodsInDetailByNo(String no);
}
