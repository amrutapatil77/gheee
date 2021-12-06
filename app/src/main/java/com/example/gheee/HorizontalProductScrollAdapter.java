package com.example.gheee;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {

    private List<HorizontalProductScrollModal>horizontalProductScrollModalList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModal> horizontalProductScrollModalList) {
        this.horizontalProductScrollModalList = horizontalProductScrollModalList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder viewHolder, int position) {
        int resource=horizontalProductScrollModalList.get(position).getProducedImage();
        String title=horizontalProductScrollModalList.get(position).getProducedTitle();
        String description=horizontalProductScrollModalList.get(position).getProducesDescription();
        String price=horizontalProductScrollModalList.get(position).getProducedPrice();

        viewHolder.setProductImage(resource);
        viewHolder.setProductTitle(title);
        viewHolder.setProductDescription(description);
        viewHolder.setProductPrice(price);

    }

    @Override
    public int getItemCount() {
        if (horizontalProductScrollModalList.size() > 8) {
            return 0;
        } else {
            return horizontalProductScrollModalList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private  TextView productDescription;
        private TextView productPrice;

        public ViewHolder(@NonNull final View itemView){
            super(itemView);
            productImage=itemView.findViewById(R.id.h_s_product_image);
            productTitle=itemView.findViewById(R.id.h_s_product_title);
            productDescription=itemView.findViewById(R.id.h_s_prodect_discribtion);
            productPrice=itemView.findViewById(R.id.h_s_product_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent =new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });

        }

        private void setProductImage(int resource){
            productImage.setImageResource(resource);
        }
        private void setProductTitle(String title){
            productTitle.setText(title);
        }
        private void setProductDescription(String description){
            productDescription.setText(description);
        }
        private void setProductPrice(String price){
            productPrice.setText(price);
        }
    }

}
