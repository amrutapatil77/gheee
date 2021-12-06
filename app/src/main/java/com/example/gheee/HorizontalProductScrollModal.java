package com.example.gheee;

public class HorizontalProductScrollModal {
    private int producedImage;
    private String producedTitle;
    private String producesDescription;
    private String producedPrice;

    public HorizontalProductScrollModal(int producedImage, String producedTitle, String producesDescription, String producedPrice) {
        this.producedImage = producedImage;
        this.producedTitle = producedTitle;
        this.producesDescription = producesDescription;
        this.producedPrice = producedPrice;
    }

    public int getProducedImage() {
        return producedImage;
    }

    public void setProducedImage(int producedImage) {
        this.producedImage = producedImage;
    }

    public String getProducedTitle() {
        return producedTitle;
    }

    public void setProducedTitle(String producedTitle) {
        this.producedTitle = producedTitle;
    }

    public String getProducesDescription() {
        return producesDescription;
    }

    public void setProducesDescription(String producesDescription) {
        this.producesDescription = producesDescription;
    }

    public String getProducedPrice() {
        return producedPrice;
    }

    public void setProducedPrice(String producedPrice) {
        this.producedPrice = producedPrice;
    }
}
