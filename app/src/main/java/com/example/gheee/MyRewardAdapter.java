package com.example.gheee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRewardAdapter extends RecyclerView.Adapter<MyRewardAdapter.Viewholder> {

  private List<RewardModal>rewardModalList;

    public MyRewardAdapter(List<RewardModal> rewardModalList) {
        this.rewardModalList = rewardModalList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rewards_item_layout,viewGroup,false);
       return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {

        String title=rewardModalList.get(position).getTitle();
        String date=rewardModalList.get(position).getExpiryData();
        String body=rewardModalList.get(position).getCoupenbody();
        viewholder.setData(title,date,body);
    }

    @Override
    public int getItemCount() {
        return rewardModalList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private TextView coupenTitle;
        private TextView coupenExpiryData;
        private TextView coupenBody;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            coupenTitle=itemView.findViewById(R.id.coupen_title);
            coupenExpiryData=itemView.findViewById(R.id.coupen_valitity);
            coupenBody=itemView.findViewById(R.id.coupen_body);
        }
        private void setData(String title, String date, String body){
            coupenTitle.setText(title);
            coupenExpiryData.setText(date);
            coupenBody.setText(body);
        }
    }
}
