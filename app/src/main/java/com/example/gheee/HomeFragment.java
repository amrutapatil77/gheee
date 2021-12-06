package com.example.gheee;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView CatgoryRecyclerview;
    private CatagryAdapter catagryAdapter;
    private RecyclerView testing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        CatgoryRecyclerview = view.findViewById(R.id.catagry_recyclear_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        CatgoryRecyclerview.setLayoutManager(layoutManager);

        final List<CatagryModel> catagryModelList = new ArrayList<CatagryModel>();
        catagryModelList.add(new CatagryModel("Link", "Home"));
        catagryModelList.add(new CatagryModel("Link", "Electronics"));
        catagryModelList.add(new CatagryModel("Link", "Appliances"));
        catagryModelList.add(new CatagryModel("Link", "Furniture"));
        catagryModelList.add(new CatagryModel("Link", "Toys"));
        catagryModelList.add(new CatagryModel("Link", "Sports"));
        catagryModelList.add(new CatagryModel("Link", "Wall Arts"));
        catagryModelList.add(new CatagryModel("Link", "Books"));
        catagryModelList.add(new CatagryModel("Link", "Shoes"));

        catagryAdapter = new CatagryAdapter(catagryModelList);
        CatgoryRecyclerview.setAdapter(catagryAdapter);
        catagryAdapter.notifyDataSetChanged();
        //////baner slider


        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.green_emai, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_emai, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profil, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.heart, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.home, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.search, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_white, "#077AE4"));


        /////////////////


        /////////Horizontal product

        List<HorizontalProductScrollModal> horizontalProductScrollModalList = new ArrayList<>();
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone5, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone1, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.pho, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone1, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone3, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone4, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));

        //////////////////////


        ///////////////////////////
        testing = view.findViewById(R.id.home_page_recyclerView);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);


        List<HomePageModal> homePageModalList = new ArrayList<>();
        homePageModalList.add(new HomePageModal(0, sliderModelList));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#ff0000"));
        homePageModalList.add(new HomePageModal(2, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(3, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#000000"));
        homePageModalList.add(new HomePageModal(3, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(2, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#ffff00"));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#ff0000"));
        homePageModalList.add(new HomePageModal(2, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(3, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#000000"));
        homePageModalList.add(new HomePageModal(3, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(2, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#ffff00"));



        HomePageAdapter adapter = new HomePageAdapter(homePageModalList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ///////////////////////
        return view;
    }

}