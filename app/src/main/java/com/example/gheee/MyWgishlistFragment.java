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


public class MyWgishlistFragment extends Fragment {




    public MyWgishlistFragment() {
        // Required empty public constructor
    }

   private RecyclerView wishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_wgishlist, container, false);
        wishlistRecyclerView=view.findViewById(R.id.my_whishlist_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WhishListModal>whishListModalList=new ArrayList<>();
        whishListModalList.add(new WhishListModal(R.drawable.mob,"Pixel 2",1,"3",145,"Rs.49999/-","Rs.59999/-","Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob,"Pixel 2",0,"3",145,"Rs.49999/-","Rs.59999/-","Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob,"Pixel 2",2,"3",145,"Rs.49999/-","Rs.59999/-","Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob,"Pixel 2",4,"3",145,"Rs.49999/-","Rs.59999/-","Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob,"Pixel 2",1,"3",145,"Rs.49999/-","Rs.59999/-","Cash on delivery"));


        WhishListAdapter whishListAdapter=new WhishListAdapter(whishListModalList,true);
        wishlistRecyclerView.setAdapter(whishListAdapter);
        whishListAdapter.notifyDataSetChanged();

        return view;
    }
}