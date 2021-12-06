package com.example.gheee;

public class CartItemModal {
    public static final int CART_ITEM=0;
    public static final int TOTAL_AMOUNT=1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ///////cart item
    private int productImage;
    private String productTitle;
    private int freeCoupen;
    private String productPrice;
    private  String cuttedPrice;
    private int productQuantity;
    private int offersApplied;
    private int coupensApplied;

    public CartItemModal(int type, int productImage, String productTitle, int freeCoupen, String productPrice, String cuttedPrice, int productQuantity, int offersApplied, int coupensApplied) {
        this.type = type;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCoupen = freeCoupen;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQuantity = productQuantity;
        this.offersApplied = offersApplied;
        this.coupensApplied = coupensApplied;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreeCoupen() {
        return freeCoupen;
    }

    public void setFreeCoupen(int freeCoupen) {
        this.freeCoupen = freeCoupen;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getOffersApplied() {
        return offersApplied;
    }

    public void setOffersApplied(int offersApplied) {
        this.offersApplied = offersApplied;
    }

    public int getCoupensApplied() {
        return coupensApplied;
    }

    public void setCoupensApplied(int coupensApplied) {
        this.coupensApplied = coupensApplied;
    }


    ///////


    ///////////////////cart total
    private String totalItem;
    private String totalItemPrice;
    private String delivaryPrice;
    private String savedAmount;
    private String totalAmount;

    public CartItemModal(int type, String totalItem, String totalItemPrice, String delivaryPrice,String totalAmount, String savedAmount) {
        this.totalAmount = totalAmount;
        this.type = type;
        this.totalItem = totalItem;
        this.totalItemPrice = totalItemPrice;
        this.delivaryPrice = delivaryPrice;
        this.savedAmount = savedAmount;

    }

    public String getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(String totalItem) {
        this.totalItem = totalItem;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public String getDelivaryPrice() {
        return delivaryPrice;
    }

    public void setDelivaryPrice(String delivaryPrice) {
        this.delivaryPrice = delivaryPrice;
    }

    public String getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(String savedAmount) {
        this.savedAmount = savedAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}


