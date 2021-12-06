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


public class MyOrdersFragment extends Fragment {


    public MyOrdersFragment() {
        // Required empty public constructor
    }

 private RecyclerView myOrdersRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_orders, container, false);
        myOrdersRecyclerView=view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrdersRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModal> myOrderItemModalList=new ArrayList<>();
        myOrderItemModalList.add(new MyOrderItemModal(R.drawable.mobile3,2,"Pixel 2xl (Black)","Delivered on Mon,15th JAN 2013"));
        myOrderItemModalList.add(new MyOrderItemModal(R.drawable.mobile2,1,"Pixel 2xl (Black)","Delivered on Mon,15th JAN 2013"));
        myOrderItemModalList.add(new MyOrderItemModal(R.drawable.mobile3,0,"Pixel 2xl (Black)","Cancelled"));
        myOrderItemModalList.add(new MyOrderItemModal(R.drawable.mob,4,"Pixel 2xl (Black)","Delivered on Mon,15th JAN 2013"));

        MyOrderAdapter myOrderAdapter=new MyOrderAdapter(myOrderItemModalList);
        myOrdersRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();
        return view;
    }
}