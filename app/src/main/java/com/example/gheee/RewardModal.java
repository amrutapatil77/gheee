package com.example.gheee;

public class RewardModal {
    private String title;
    private String expiryData;
    private String coupenbody;

    public RewardModal(String title, String expiryData, String coupenbody) {
        this.title = title;
        this.expiryData = expiryData;
        this.coupenbody = coupenbody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpiryData() {
        return expiryData;
    }

    public void setExpiryData(String expiryData) {
        this.expiryData = expiryData;
    }

    public String getCoupenbody() {
        return coupenbody;
    }

    public void setCoupenbody(String coupenbody) {
        this.coupenbody = coupenbody;
    }
}
