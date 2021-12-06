package com.example.gheee;

public class ProductSpecificationModal {

    public static final int SPECIFICATION_TITLE=0;
    public static final int SPECIFICATION_BODY=1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //////////specification title
    private String title;

    public ProductSpecificationModal(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    ///////////////specification title


    ///////specification body
    private String featureName;
    private String Featurvalue;

    public ProductSpecificationModal(int type, String featureName, String featurvalue) {
        this.type = type;
        this.featureName = featureName;
        Featurvalue = featurvalue;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeaturvalue() {
        return Featurvalue;
    }

    public void setFeaturvalue(String featurvalue) {
        Featurvalue = featurvalue;
    }
    //////////////////////body

}
