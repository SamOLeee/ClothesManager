package cn.domain;

import java.io.Serializable;

public class GoodsIn implements Serializable {
    private Integer id;
    private Integer goods_id;
    private String no;
    private String library;
    private String datetime;
    private String operator;
    private String source;
    private Integer delete ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "GoodsIn{" +
                "id=" + id +
                ", goods_id=" + goods_id +
                ", no='" + no + '\'' +
                ", library='" + library + '\'' +
                ", datetime='" + datetime + '\'' +
                ", operator='" + operator + '\'' +
                ", source='" + source + '\'' +
                ", delete=" + delete +
                '}';
    }
}
