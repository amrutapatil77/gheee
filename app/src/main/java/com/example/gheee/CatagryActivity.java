package com.example.gheee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CatagryActivity extends AppCompatActivity {

    private RecyclerView catagryrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title=getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        catagryrecyclerview=findViewById(R.id.catagry_recyclerview);


        //////baner slider


        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.mipmap.cart_white, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.more, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_emai, "#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.red_emai, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profil, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.heart, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.home, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.search, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_emai, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_white, "#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.more, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_emai, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_emai, "#077AE4"));
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

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        catagryrecyclerview.setLayoutManager(testingLayoutManager);


        List<HomePageModal> homePageModalList = new ArrayList<>();
        homePageModalList.add(new HomePageModal(0, sliderModelList));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#ff0000"));
        homePageModalList.add(new HomePageModal(2, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(3, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#000000"));
        homePageModalList.add(new HomePageModal(3, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(2, "Deals of the Day", horizontalProductScrollModalList));
        homePageModalList.add(new HomePageModal(1, R.mipmap.ban, "#ffff00"));


        HomePageAdapter adapter = new HomePageAdapter(homePageModalList);
        catagryrecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.search_icon, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Inflate the menu; this adds items to the action bar if it is present.
            int id=item.getItemId();

            if (id==R.id.main_search_icon){
                return true;
            }else if (id==android.R.id.home){
                finish();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

}