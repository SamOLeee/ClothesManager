package cn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodsIn implements Serializable {
    private Integer id;
    private String no;
    private String library;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date datetime;

    private String operator;
    private String source;
    private Integer delete;

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
                ", no='" + no + '\'' +
                ", library='" + library + '\'' +
                ", datetime=" + datetime +
                ", operator='" + operator + '\'' +
                ", source='" + source + '\'' +
                ", delete=" + delete +
                '}';
    }
}
