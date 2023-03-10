package com.userinterface.ssuroom.model;

public class ReviewItem {
    String tradeType;
    long rentCost;
    long depositCost;
    long area;
    long floor;
    String address;
    double star;
    String isTrading;
    String id;
    boolean isHeart;
    public byte[] mainImg;

    public ReviewItem(String tradeType, long rentCost, long depositCost, long area, long floor, String address, double star, String isTrading,String id,boolean isHeart) {
        this.tradeType = tradeType;
        this.rentCost = rentCost;
        this.depositCost = depositCost;
        this.area = area;
        this.floor = floor;
        this.address = address;
        this.star = star;
        this.isTrading = isTrading;
        this.id = id;
        this.isHeart=isHeart;
        mainImg=null;
    }

    public void setMainImg(byte[] mainImg) {
        this.mainImg = mainImg;
    }

    public byte[] getMainImg() {
        return mainImg;
    }

    public boolean isHeart() {
        return isHeart;
    }

    public void setHeart(boolean heart) {
        isHeart = heart;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public long getRentCost() {
        return rentCost;
    }

    public void setRentCost(long rentCost) {
        this.rentCost = rentCost;
    }

    public long getDepositCost() {
        return depositCost;
    }

    public void setDepositCost(long depositCost) {
        this.depositCost = depositCost;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getFloor() {
        return floor;
    }

    public void setFloor(long floor) {
        this.floor = floor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public String getIsTrading() {
        return isTrading;
    }

    public void setIsTrading(String isTrading) {
        this.isTrading = isTrading;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
