package com.blb.aigo.entity;

public class AddressShow implements Comparable<AddressShow> {
    private String id;
    private String receivingAddress;
    private String receivingPerson;
    private long mobilePhone;
    private String userId;
    private int isDefault;

    public AddressShow(String id, String receivingAddress, String receivingPerson, long mobilePhone, String userId, int isDefault) {
        this.id = id;
        this.receivingAddress = receivingAddress;
        this.receivingPerson = receivingPerson;
        this.mobilePhone = mobilePhone;
        this.userId = userId;
        this.isDefault = isDefault;
    }

    public AddressShow() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public String getReceivingPerson() {
        return receivingPerson;
    }

    public void setReceivingPerson(String receivingPerson) {
        this.receivingPerson = receivingPerson;
    }

    public long getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public int compareTo(AddressShow o) {
        return o.isDefault - this.isDefault;
    }
}
