package com.example.gheee;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.Viewholder> {
private List<MyOrderItemModal>myOrderItemModalList;

    public MyOrderAdapter(List<MyOrderItemModal> myOrderItemModalList) {
        this.myOrderItemModalList = myOrderItemModalList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_order_item,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        int resource=myOrderItemModalList.get(position).getProductImage();
        int rating=myOrderItemModalList.get(position).getRating();
        String title=myOrderItemModalList.get(position).getProductTitle();
        String deliverdData=myOrderItemModalList.get(position).getDeliveryStatus();
        viewholder.setData(resource,title,deliverdData,rating);
    }



    @Override
    public int getItemCount() {
        return myOrderItemModalList.size();
    }
    class Viewholder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private ImageView orderIndicator;
        private TextView productTitle;
        private TextView deliveryStatus;
        private LinearLayout rateNowContainer;
        public Viewholder(@NonNull final View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
           orderIndicator =itemView.findViewById(R.id.order_indicater);
            deliveryStatus=itemView.findViewById(R.id.order_deliver_date_);
            rateNowContainer=itemView.findViewById(R.id.rate_now_container);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent orderDetailsIntent=new Intent(itemView.getContext(),OrderDetailsActivity.class);
                    itemView.getContext().startActivity(orderDetailsIntent);
                }
            });

        }
        private void setData(int resource,String title,String deliveredDate,int rating) {
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (deliveredDate.equals("Cancelled")) {

                orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.red)));
            }else {
                orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.successGreen)));
            }

                deliveryStatus.setText(deliveredDate);
            ////////rating
            setRating(rating);
            for (int x=0;x<rateNowContainer.getChildCount();x++){
                final int starPosition=x;
                rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setRating(starPosition);
                    }
                });
            }

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
    }
}
