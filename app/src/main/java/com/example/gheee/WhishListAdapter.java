package com.example.gheee;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WhishListAdapter extends RecyclerView.Adapter<WhishListAdapter.ViewHolder> {

    private List<WhishListModal> whishListModalList;
    private Boolean whishlist;

    public WhishListAdapter(List<WhishListModal> whishListModalList,Boolean whishlist) {
        this.whishListModalList = whishListModalList;

        this.whishlist=whishlist;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.whishlist_item_layout,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        int resource=whishListModalList.get(position).getProductImage();
        String title=whishListModalList.get(position).getProductTitle();
        int freeCoupens=whishListModalList.get(position).getFreeCoupens();
        String rating =whishListModalList.get(position).getRating();
        int totalRatings=whishListModalList.get(position).getTotalRating();
        String productprice=whishListModalList.get(position).getProductPrice();
        String cuttedPrice=whishListModalList.get(position).getCuttedPrice();
        String paymentMethod =whishListModalList.get(position).getPymentMethod();
        viewHolder.setData(resource,title,freeCoupens,rating,totalRatings,productprice,cuttedPrice,paymentMethod);
    }

    @Override
    public int getItemCount() {
        return whishListModalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCoupens;
        private ImageView coupenIcon;
        private TextView rating;
        private TextView totalRating;
        private View priceCut;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private ImageButton deletebtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);

            freeCoupens=itemView.findViewById(R.id.free_coupen);
             coupenIcon=itemView.findViewById(R.id.coupen_icon);
            rating=itemView.findViewById(R.id.tv_product_rating_miniview);
             totalRating=itemView.findViewById(R.id.total_rating);
             priceCut=itemView.findViewById(R.id.price_cut);
             productPrice=itemView.findViewById(R.id.product_price);
             cuttedPrice=itemView.findViewById(R.id.cutted_price);
             paymentMethod=itemView.findViewById(R.id.payment_method);
             deletebtn=itemView.findViewById(R.id.delete_btn);

        }
        private void setData(int resource, String title, int freeCoupensNo,String avergeRate, int totalRatingsNo, String price, String cuttedPriceValue, String payMethod) {
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCoupensNo != 0) {
                coupenIcon.setVisibility(View.VISIBLE);
                if (freeCoupensNo == 1) {
                    freeCoupens.setText("free" + freeCoupensNo + "coupen");

                } else {
                    freeCoupens.setText("free" + freeCoupensNo + "coupens");
                }
            }else {
                coupenIcon.setVisibility(View.INVISIBLE);
                freeCoupens.setVisibility(View.INVISIBLE);
            }

            rating.setText(avergeRate);
            totalRating.setText(totalRatingsNo+"(ratings)");
            productPrice.setText(price);
            cuttedPrice.setText(cuttedPriceValue);
            paymentMethod.setText(payMethod);
            if (whishlist){
                deletebtn.setVisibility(View.VISIBLE);

            }else {
                deletebtn.setVisibility(View.GONE);
            }

            deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"delete",Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetails=new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetails);
                }
            });
        }
    }
}
