package cn.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class GoodsOut implements Serializable {
    private Integer id;
    private String no;
    private String library;

    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date datetime;

    private String operator;
    private String send;
    private Integer delete ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "GoodsOut{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", library='" + library + '\'' +
                ", datetime=" + datetime +
                ", operator='" + operator + '\'' +
                ", send='" + send + '\'' +
                ", delete=" + delete +
                '}';
    }
}
