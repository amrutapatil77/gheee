package com.example.gheee;

import java.util.List;

public class HomePageModal {
    public static final int BANNER_SLIDER=0;
    public static final int STRIP_AD_BANNER=1;
    public static final int HORIZONTAL_PRODUCT_VIEW=2;
    public static final int GRID_PRODUCT_VIEW=3;

    private int type;

    ///////Banner slider
    private List<SliderModel> sliderModels;
    public HomePageModal(int type, List<SliderModel> sliderModels) {
        this.type = type;
        this.sliderModels = sliderModels;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<SliderModel> getSliderModels() {
        return sliderModels;
    }
    public void setSliderModels(List<SliderModel> sliderModels) {
        this.sliderModels = sliderModels;
    }
    /////banner


    ///////////////strip Ad
    private int resourses;
    private String backgroundColor;

    public HomePageModal(int type, int resourses, String backgroundColor) {
        this.type = type;
        this.resourses = resourses;
        this.backgroundColor = backgroundColor;
    }

    public int getResourses() {
        return resourses;
    }

    public void setResourses(int resourses) {
        this.resourses = resourses;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
/////////////////strip Ad

    /////////Horizontal product  &&& GRIDEL

    private String title;
    private  List<HorizontalProductScrollModal> horizontalProductScrollModalList;

    public HomePageModal(int type, String title, List<HorizontalProductScrollModal> horizontalProductScrollModalList) {
        this.type = type;
        this.title = title;
        this.horizontalProductScrollModalList = horizontalProductScrollModalList;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<HorizontalProductScrollModal> getHorizontalProductScrollModalList() {
        return horizontalProductScrollModalList;
    }
    public void setHorizontalProductScrollModalList(List<HorizontalProductScrollModal> horizontalProductScrollModalList) {
        this.horizontalProductScrollModalList = horizontalProductScrollModalList;
    }
    /////////Horizontal product  &&& GRIDEL

}


