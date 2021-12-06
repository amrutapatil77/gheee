package com.example.gheee;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductSpecifictionAdapter extends RecyclerView.Adapter<ProductSpecifictionAdapter.ViewHolder>
{
    private List<ProductSpecificationModal>productSpecificationModalList;

    public ProductSpecifictionAdapter(List<ProductSpecificationModal> productSpecificationModalList) {
        this.productSpecificationModalList = productSpecificationModalList;
    }

    @Override
    public int getItemViewType(int position) {
       switch (productSpecificationModalList.get(position).getType()){
           case 0:
               return ProductSpecificationModal.SPECIFICATION_TITLE;
           case 1:
               return ProductSpecificationModal.SPECIFICATION_BODY;
           default:
               return -1;
       }
    }

    @NonNull
    @Override
    public ProductSpecifictionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType){ case ProductSpecificationModal.SPECIFICATION_TITLE:
            TextView title=new TextView(viewGroup.getContext());
            title.setTypeface(null, Typeface.BOLD);
            title.setTextColor(Color.parseColor("#000000"));
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(setDp(16,viewGroup.getContext()),setDp(16,viewGroup.getContext()),setDp(16,viewGroup.getContext()),setDp(8,viewGroup.getContext()));

            title.setLayoutParams(layoutParams);
            return new ViewHolder(title);

            case ProductSpecificationModal.SPECIFICATION_BODY:
            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_specification_item_layout,viewGroup,false);
            return new ViewHolder(view);
            default:
        return null;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecifictionAdapter.ViewHolder viewHolder, int position) {

        switch (productSpecificationModalList.get(position).getType()){
            case ProductSpecificationModal.SPECIFICATION_TITLE:
                viewHolder.setTitle(productSpecificationModalList.get(position).getTitle());
                break;

            case ProductSpecificationModal.SPECIFICATION_BODY:
                String featureTitle=productSpecificationModalList.get(position).getFeatureName();
                String featureDetail=productSpecificationModalList.get(position).getFeaturvalue();
                viewHolder.setFeatures(featureTitle,featureDetail);
                break;
            default:
                return;
        }



    }

    @Override
    public int getItemCount() {
        return productSpecificationModalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featureName;
        private TextView featureValue;
        private TextView title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        private void  setTitle(String titleText){
            title= (TextView) itemView;
            title.setText(titleText);
        }
        private void setFeatures(String featureTitle,String featuredetail){
            featureName=itemView.findViewById(R.id.feature_name);
            featureValue=itemView.findViewById(R.id.feature_value);
            featureName.setText(featureTitle);
            featureValue.setText(featuredetail);
        }

    }

    private int setDp(int dp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }
}
