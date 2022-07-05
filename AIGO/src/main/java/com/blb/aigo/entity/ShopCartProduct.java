package com.blb.aigo.entity;

public class ShopCartProduct {
    private String id;
    private String shopCartId;
    private String productId;
    private int productNum;

    public ShopCartProduct(String id, String shopCartId, String productId, int productNum) {
        this.id = id;
        this.shopCartId = shopCartId;
        this.productId = productId;
        this.productNum = productNum;
    }

    public ShopCartProduct() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
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
