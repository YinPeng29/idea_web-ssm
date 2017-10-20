package com.ssm.demo.model;

/**
 * Created by yinpeng on 2017/10/20.
 */
public class IMemberOrders {
    private Long oid;

    //订单号
    private String ordercode;

    //昵称
    private String nickname;

    //商品名
    private String shopname;

    //购买数量
    private Integer buycount;

    //当次花费
    private Double paycount;

    //购买时间
    private String buytime;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Integer getBuycount() {
        return buycount;
    }

    public void setBuycount(Integer buycount) {
        this.buycount = buycount;
    }

    public Double getPaycount() {
        return paycount;
    }

    public void setPaycount(Double paycount) {
        this.paycount = paycount;
    }

    public String getBuytime() {
        return buytime;
    }

    public void setBuytime(String buytime) {
        this.buytime = buytime;
    }
}
