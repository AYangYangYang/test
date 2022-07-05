package com.blb.aigo.entity;

public class OrderProduct {
    private String id;
    private String orderId;
    private String productId;
    private int productNum;

    public OrderProduct(String id, String orderId, String productId, int productNum) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.productNum = productNum;
    }

    public OrderProduct() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
