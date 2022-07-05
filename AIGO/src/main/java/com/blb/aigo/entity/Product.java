package com.blb.aigo.entity;
public class Product {
     private String id;
     private String productName;
     private String productImage;
     private double price;
     private String productType;
     private String productDesc;
     private String creatTime;
     private String productBrand;

    public Product(String id, String productName, String productImage, double price, String productType, String productDesc, String creatTime, String productBrand) {
        this.id = id;
        this.productName = productName;
        this.productImage = productImage;
        this.price = price;
        this.productType = productType;
        this.productDesc = productDesc;
        this.creatTime = creatTime;
        this.productBrand = productBrand;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
}