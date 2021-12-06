package com.example.gheee;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<HorizontalProductScrollModal> horizontalProductScrollModalList;

    public GridProductLayoutAdapter(List<HorizontalProductScrollModal> horizontalProductScrollModalList) {
        this.horizontalProductScrollModalList = horizontalProductScrollModalList;
    }

    @Override
    public int getCount() {
        return horizontalProductScrollModalList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if (convertView == null) {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productdetailsIntent=new Intent(parent.getContext(),ProductDetailsActivity.class);
                    parent.getContext().startActivity(productdetailsIntent);
                }
            });

            ImageView productImage=view.findViewById(R.id.h_s_product_image);
            TextView productTitle=view.findViewById(R.id.h_s_product_title);
            TextView productDescription=view.findViewById(R.id.h_s_prodect_discribtion);
            TextView productPrice=view.findViewById(R.id.h_s_product_price);

            productImage.setImageResource(horizontalProductScrollModalList.get(position).getProducedImage());
            productTitle.setText(horizontalProductScrollModalList.get(position).getProducedTitle());
            productDescription.setText(horizontalProductScrollModalList.get(position).getProducesDescription());
            productPrice.setText(horizontalProductScrollModalList.get(position).getProducedPrice());

        }else {
            view=convertView;

        }
    return view;
    }
}
