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

public class CatagryAdapter extends RecyclerView.Adapter<CatagryAdapter.ViewHolder> {
    private List<CatagryModel> catagryModelList;

    public CatagryAdapter(List<CatagryModel> catagryModelList) {
        this.catagryModelList = catagryModelList;
    }

    @NonNull
    @Override
    public CatagryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categry_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagryAdapter.ViewHolder viewHolder, int position) {
        String icon=catagryModelList.get(position).getCatagryIconLink();
        String name=catagryModelList.get(position).getCatagryName();
        viewHolder.setcatagry(name,position);

    }

    @Override
    public int getItemCount() {
        return catagryModelList.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView categoryIcon;
        private  TextView catagryname;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            categoryIcon=itemView.findViewById(R.id.category_icon);
            catagryname=itemView.findViewById(R.id.catagry_name);
        }
        private void setCategoryIcon(){

        }
        private  void setcatagry(final String name,final int position){
            catagryname .setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position != 0) {
                        Intent categoryIntent = new Intent(itemView.getContext(), CatagryActivity.class);
                        categoryIntent.putExtra("CategoryName", name);
                        itemView.getContext().startActivity(categoryIntent);
                    }
                }
            });
        }
    }
}
