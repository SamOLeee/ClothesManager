package cn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodsIn implements Serializable {
    private Integer gid;
    private String no;
    private String library;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date datetime;

    private String operator;
    private String source;
    private Integer delete;

    @Override
    public String toString() {
        return "GoodsIn{" +
                "gid=" + gid +
                ", no='" + no + '\'' +
                ", library='" + library + '\'' +
                ", datetime=" + datetime +
                ", operator='" + operator + '\'' +
                ", source='" + source + '\'' +
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
//        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String t=sdf.format(datetime);
//        return t;
        return datetime;
    }
//    public String getDatetime() {
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        String time = ft.format(datetime);
//        return time;
//    }

    public void setDatetime(Date datetime) {this.datetime = datetime;}

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
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
}
