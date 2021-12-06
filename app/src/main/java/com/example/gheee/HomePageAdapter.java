package com.example.gheee;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.gridlayout.widget.GridLayout;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {
    private List<HomePageModal> homePageModalList;
    private  RecyclerView.RecycledViewPool recycledViewPool;

    public HomePageAdapter(List<HomePageModal> homePageModalList) {
        this.homePageModalList = homePageModalList;
        recycledViewPool=new RecyclerView.RecycledViewPool();
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModalList.get(position).getType()) {
            case 0:
                return HomePageModal.BANNER_SLIDER;
            case 1:
                return HomePageModal.STRIP_AD_BANNER;
            case 2:
                return HomePageModal.HORIZONTAL_PRODUCT_VIEW;
            case 3:
                return HomePageModal.GRID_PRODUCT_VIEW;
            default:
                return -1;


        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case HomePageModal.BANNER_SLIDER:
                View bannerSliderView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sliding_add_layout, viewGroup, false);
                return new BannerSliderViewHolader(bannerSliderView);
            case HomePageModal.STRIP_AD_BANNER:
                View stripAdView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.strip_add_layout, viewGroup, false);
                return new StripAdBannerViewholder(stripAdView);
            case HomePageModal.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_layout, viewGroup, false);
                return new HorizontalProductViewholder(horizontalProductView);
            case HomePageModal.GRID_PRODUCT_VIEW:
                View gridProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_product_layout, viewGroup, false);
                return new GridProductViewholder(gridProductView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (homePageModalList.get(position).getType()){
            case HomePageModal.BANNER_SLIDER:
                List<SliderModel> sliderModelList= homePageModalList.get(position).getSliderModels();
                ((BannerSliderViewHolader)viewHolder).setBannersliderViewPager(sliderModelList);
                break;

            case HomePageModal.STRIP_AD_BANNER:
                int resource=homePageModalList.get(position).getResourses();
                String color=homePageModalList.get(position).getBackgroundColor();
                ((StripAdBannerViewholder)viewHolder).setStripAd(resource,color);
                break;
            case HomePageModal.HORIZONTAL_PRODUCT_VIEW:
                String horizontalLayoutTitle=homePageModalList.get(position).getTitle();
                List<HorizontalProductScrollModal> horizontalProductScrollModalList=homePageModalList.get(position).getHorizontalProductScrollModalList();
                ((HorizontalProductViewholder)viewHolder).setHorizontalProductLayout(horizontalProductScrollModalList,horizontalLayoutTitle);
                break;
            case HomePageModal.GRID_PRODUCT_VIEW:
                String gridLayoutTitle =homePageModalList.get(position).getTitle();
                List<HorizontalProductScrollModal> gridProductScrollModalList=homePageModalList.get(position).getHorizontalProductScrollModalList();
                ((GridProductViewholder)viewHolder).setGridProductLayout(gridProductScrollModalList,gridLayoutTitle);
                break;

            default:
                return;

        }
    }

    @Override
    public int getItemCount() {
        return homePageModalList.size();
    }

    public class BannerSliderViewHolader extends RecyclerView.ViewHolder {

        private ViewPager bannersliderViewPage;
        private int currentPage ;
        private Timer timer;
        final private long DELAY_TIME=3000;
        final private long PEROID_TIME=3000;
        private List<SliderModel> arrangedList;

        public BannerSliderViewHolader(@NonNull View itemView) {

            super(itemView);
            bannersliderViewPage=itemView.findViewById(R.id.banar_slider_view_pager);

        }
        private void setBannersliderViewPager(final List<SliderModel>sliderModelList){

            currentPage=2;
            if (timer!= null){
                timer.cancel();
            }

            arrangedList=new ArrayList<>();
            for (int x=0;x<sliderModelList.size();x++){
                arrangedList.add(x,sliderModelList.get(x));
            }
            arrangedList.add(0,sliderModelList.get(sliderModelList.size()-2));
            arrangedList.add(1,sliderModelList.get(sliderModelList.size()-1));
            arrangedList.add(sliderModelList.get(0));
            arrangedList.add(sliderModelList.get(1));

            SliderAdapter sliderAdapter = new SliderAdapter(arrangedList);
            bannersliderViewPage.setAdapter(sliderAdapter);
            bannersliderViewPage.setClipToPadding(false);
            bannersliderViewPage.setPageMargin(20);

            bannersliderViewPage.setCurrentItem(currentPage);
            ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int i) {

                    currentPage= i;
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                    if (i==ViewPager.SCROLL_STATE_IDLE){
                        pageLopper(arrangedList);
                    }
                }
            };
            bannersliderViewPage.addOnPageChangeListener(onPageChangeListener);

            starBannerSlideShow(arrangedList);
            bannersliderViewPage.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pageLopper(arrangedList);
                    stopBannerSlideShow();
                    if (event.getAction()==MotionEvent.ACTION_UP){
                        starBannerSlideShow(arrangedList);
                    }
                    return false;
                }
            });

        }
        private void pageLopper(List<SliderModel>sliderModelList) {

            if (currentPage == sliderModelList.size() - 2) {
                currentPage = 2;
                bannersliderViewPage.setCurrentItem(currentPage, false);
            }
            if (currentPage == 1) {
                currentPage = sliderModelList.size() - 3;
                bannersliderViewPage.setCurrentItem(currentPage, false);
            }
        }
        private void starBannerSlideShow(final List<SliderModel>sliderModelList){
            final Handler handler=new Handler();
            final Runnable Update=new Runnable() {
                @Override
                public void run() {
                    if (currentPage>=sliderModelList.size()){
                        currentPage=1;
                    }
                    bannersliderViewPage.setCurrentItem(currentPage++,true);
                }
            };

            timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(Update);
                }
            },DELAY_TIME,PEROID_TIME);
        }
        private void stopBannerSlideShow(){
            timer.cancel();
        }
    }

    public class StripAdBannerViewholder extends RecyclerView.ViewHolder{
        private ImageView stripAddImage;
        private ConstraintLayout stripAddContainer;


        public StripAdBannerViewholder(@NonNull View itemView) {
            super(itemView);

            stripAddImage=itemView.findViewById(R.id.strip_add_image);
            stripAddContainer=itemView.findViewById(R.id.strip_add_container);
        }

        private void setStripAd(int resource ,String color){
            stripAddImage.setImageResource(resource);
            stripAddImage.setBackgroundColor(Color.parseColor(color));

        }
    }



    public class HorizontalProductViewholder extends RecyclerView.ViewHolder{
        private TextView horizontalLayoutTitle;
        private Button horizontalLayoutviewAllbtn;
        private RecyclerView horizontalRecyclerView;

        public HorizontalProductViewholder(@NonNull View itemView) {
            super(itemView);
            horizontalLayoutTitle=itemView.findViewById(R.id.horizontal_scroll_layout_title);
            horizontalLayoutviewAllbtn=itemView.findViewById(R.id.horizontal_scroll_view_all_btn) ;
            horizontalRecyclerView=itemView.findViewById(R.id.horizontal_scroll_layout_recyclerview);
            horizontalRecyclerView.setRecycledViewPool(recycledViewPool);
        }
        private void  setHorizontalProductLayout(List<HorizontalProductScrollModal> horizontalProductScrollModalList,String title){
            horizontalLayoutTitle.setText(title);
            if (horizontalProductScrollModalList.size()>8){
                horizontalLayoutviewAllbtn.setVisibility(View.VISIBLE);

                horizontalLayoutviewAllbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent viewAllIntent=new Intent(itemView.getContext(),ViewAllActivity.class);
                        viewAllIntent.putExtra("layout_Code",0);
                        itemView.getContext().startActivity(viewAllIntent);
                    }
                });

            }else {
                horizontalLayoutviewAllbtn.setVisibility(View.INVISIBLE);
            }
            HorizontalProductScrollAdapter horizontalProductScrollAdapter=new HorizontalProductScrollAdapter(horizontalProductScrollModalList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalRecyclerView.setLayoutManager(linearLayoutManager);

            horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
            horizontalProductScrollAdapter.notifyDataSetChanged();
        }
    }
    public class GridProductViewholder extends RecyclerView.ViewHolder {

        private TextView gridLayoutTitle;
        private Button gridLayoutViewAllBtn;
       private GridLayout gridProductLayout;

        public GridProductViewholder(@NonNull View itemView) {
            super(itemView);
            gridLayoutTitle = itemView.findViewById(R.id.grid_product_layout_title);
            gridLayoutViewAllBtn = itemView.findViewById(R.id.grid_product_layout_view_all_btn);
            gridProductLayout=itemView.findViewById(R.id.grid_layoutt);

        }

        private void setGridProductLayout(List<HorizontalProductScrollModal> horizontalProductScrollModalList,String title) {
            gridLayoutTitle.setText(title);

            for (int x=0; x<4 ;x++){
                ImageView productImage=gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_image);
                TextView productTitle=gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_title);
                TextView productDescription=gridProductLayout.getChildAt(x).findViewById(R.id.h_s_prodect_discribtion);
                TextView productPrice=gridProductLayout.getChildAt(x).findViewById(R.id.h_s_product_price);


                productImage.setImageResource(horizontalProductScrollModalList.get(x).getProducedImage());
                productTitle.setText(horizontalProductScrollModalList.get(x).getProducedTitle());
                productDescription.setText(horizontalProductScrollModalList.get(x).getProducesDescription());
                productPrice.setText(horizontalProductScrollModalList.get(x).getProducedPrice());


               gridProductLayout.getChildAt(x).setBackgroundColor(Color.parseColor("#ffffff"));
                gridProductLayout.getChildAt(x).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent productDetailsIntent=new Intent(itemView.getContext(),ProductDetailsActivity.class);
                        itemView.getContext().startActivity(productDetailsIntent);

                    }
                });

            }


            gridLayoutViewAllBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viewAllIntent=new Intent(itemView.getContext(),ViewAllActivity.class);
                    viewAllIntent.putExtra("layout_Code",1);
                    itemView.getContext().startActivity(viewAllIntent);
                }
            });
        }
    }
}

