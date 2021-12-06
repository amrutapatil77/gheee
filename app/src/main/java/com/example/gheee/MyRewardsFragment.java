package com.example.gheee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MyRewardsFragment extends Fragment {



    public MyRewardsFragment() {
        // Required empty public constructor
    }

    private RecyclerView rewardsRecyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_rewards, container, false);

        rewardsRecyclerview=view.findViewById(R.id.my_rewards_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardsRecyclerview.setLayoutManager(layoutManager);

        List<RewardModal> rewardModalList=new ArrayList<>();
        rewardModalList.add(new RewardModal("Cashback","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));
        rewardModalList.add(new RewardModal("discount","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));
        rewardModalList.add(new RewardModal("But 1 get 1 free","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));
        rewardModalList.add(new RewardModal("Cashback","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));
        rewardModalList.add(new RewardModal("discount","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));
        rewardModalList.add(new RewardModal("But 1 get 1 free","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));
        rewardModalList.add(new RewardModal("Cashback","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));
        rewardModalList.add(new RewardModal("discount","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));
        rewardModalList.add(new RewardModal("But 1 get 1 free","till 2nd.june 2016,","GET 20% CASHBACK on any product above Rs.200/- and below Rs.3000/-."));

      MyRewardAdapter myRewardAdapter=new MyRewardAdapter(rewardModalList);
      rewardsRecyclerview.setAdapter(myRewardAdapter);
      myRewardAdapter.notifyDataSetChanged();
        return view;
    }
}