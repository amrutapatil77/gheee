package com.example.gheee;

public class WhishListModal {
    private int productImage;
    private String productTitle;
    private int freeCoupens;
    private String rating;
    private int totalRating;
    private String productPrice;
    private String cuttedPrice;
    private String pymentMethod;

    public WhishListModal(int productImage, String productTitle, int freeCoupens, String rating, int totalRating, String productPrice, String cuttedPrice, String pymentMethod) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCoupens = freeCoupens;
        this.rating = rating;
        this.totalRating = totalRating;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.pymentMethod = pymentMethod;
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

    public int getFreeCoupens() {
        return freeCoupens;
    }

    public void setFreeCoupens(int freeCoupens) {
        this.freeCoupens = freeCoupens;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
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

    public String getPymentMethod() {
        return pymentMethod;
    }

    public void setPymentMethod(String pymentMethod) {
        this.pymentMethod = pymentMethod;
    }
}