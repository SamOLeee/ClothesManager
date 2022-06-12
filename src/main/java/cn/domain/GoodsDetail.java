package cn.domain;

public class GoodsDetail {
//    private Integer id;
    private Integer did;
    private Integer gioid;
    private String name;
    private String no;
    private String color;
    private String size;
    private Integer amount;
    private Integer type;
    private Integer delete;

    private Integer iid;

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "did=" + did +
                ", gioid=" + gioid +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                ", delete=" + delete +
                ", iid=" + iid +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getGioid() {
        return gioid;
    }

    public void setGioid(Integer gioid) {
        this.gioid = gioid;
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

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }
}
