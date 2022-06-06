package cn.domain;

public class GoodsDetail {
    private Integer id;
    private Integer gid;
    private String name;
    private String no;
    private String color;
    private String size;
    private Integer amount;
    private Integer type;
    private Integer delete;

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "id=" + id +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                ", delete=" + delete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }
}
