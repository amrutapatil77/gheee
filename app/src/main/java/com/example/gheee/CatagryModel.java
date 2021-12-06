package com.example.gheee;

public class CatagryModel {

    private String  CatagryIconLink;
    private  String catagryName;

    public CatagryModel(String catagryIconLink, String catagryName) {
        CatagryIconLink = catagryIconLink;
        this.catagryName = catagryName;
    }

    public String getCatagryIconLink() {
        return CatagryIconLink;
    }

    public void setCatagryIconLink(String catagryIconLink) {
        CatagryIconLink = catagryIconLink;
    }

    public String getCatagryName() {
        return catagryName;
    }

    public void setCatagryName(String catagryName) {
        this.catagryName = catagryName;
    }
}
