package com.example.gheee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImageViewPager;
    private TabLayout viewpagerIndicator;

    private ViewPager productDetailsViewpager;
    private TabLayout productDetailsTablayout;

    //////////rating layout
    private LinearLayout rateNowContainer;
    /////////

    private Button buyNowBtn;
    private static boolean ALLREDY_ADDED_TO_WISHLIST=false;
    private FloatingActionButton addToWishlistbtn;
    private boolean showCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImageViewPager=findViewById(R.id.product_images_viewpager);
        viewpagerIndicator=findViewById(R.id.viewpager_indicator);
        addToWishlistbtn=findViewById(R.id.add_to_whish_list_button);

        productDetailsViewpager=findViewById(R.id.product_details_viewpager);
        productDetailsTablayout=findViewById(R.id.product_details_tabLayout);

        buyNowBtn=findViewById(R.id.buy_now_btn);
        List<Integer> productImages=new ArrayList<>();
        productImages.add(R.drawable.mobile2);
        productImages.add(R.drawable.mob);
        productImages.add(R.drawable.mobile3);
        productImages.add(R.drawable.mobile2);

        ProductImageadapter productImageadapter=new ProductImageadapter(productImages);
        productImageViewPager.setAdapter(productImageadapter);

        viewpagerIndicator.setupWithViewPager(productImageViewPager,true);

        addToWishlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (ALLREDY_ADDED_TO_WISHLIST){
                  ALLREDY_ADDED_TO_WISHLIST=false;
                  addToWishlistbtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9f9f9f")));
              }else {
                  ALLREDY_ADDED_TO_WISHLIST=true;
                  addToWishlistbtn.setSupportImageTintList(getResources().getColorStateList(R.color.color_red));
              }
            }
        });

       //productDetailsViewpager.setAdapter(new ProductDetailsAdpter(getSupportFragmentManager(),productDetailsTablayout.getTabCount()));
      //  productDetailsViewpager.setAdapter(ProductDetailsAdpter);

        //ProductDetailsAdpter productDetailsAdpter=new ProductDetailsAdpter(getSupportFragmentManager(),productDetailsTablayout.getTabCount());
       // productDetailsViewpager.setAdapter(ProductDetailsAdpter);

        productDetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));
        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /////////////rating
        rateNowContainer=findViewById(R.id.rate_now_container);
        for (int x=0;x<rateNowContainer.getChildCount();x++){
            final int starPosition=x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }
            });
        }
        ///////
        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent=new Intent(ProductDetailsActivity.this,DeliveryActivity.class);
                startActivity(deliveryIntent);

            }
        });

    }

    private void setRating(int starPosition) {
        for (int x=0;x<rateNowContainer.getChildCount();x++){
            ImageView starbtn=(ImageView)rateNowContainer.getChildAt(x);
            starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if (x<=starPosition){
                starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_card_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Inflate the menu; this adds items to the action bar if it is present.
        int id=item.getItemId();

        if (id==android.R.id.home) {
            finish();
            return true;
        }
       else if (id==R.id.main_search_icon){
            return true;
        }
        else if (id==R.id.main_cart_icon){
            Intent cartIntent=new Intent(ProductDetailsActivity.this,StartActivity.class);
            showCart=true;
            startActivity(cartIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}