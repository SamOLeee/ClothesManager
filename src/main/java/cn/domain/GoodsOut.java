package cn.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class GoodsOut implements Serializable {
    private Integer gid;
    private String no;
    private String library;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date datetime;

    private String operator;
    private String send;
    private Integer delete ;


    @Override
    public String toString() {
        return "GoodsOut{" +
                "gid=" + gid +
                ", no='" + no + '\'' +
                ", library='" + library + '\'' +
                ", datetime='" + datetime + '\'' +
                ", operator='" + operator + '\'' +
                ", send='" + send + '\'' +
                ", delete=" + delete +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
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
}
