package com.example.gheee;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MtCartFragment extends Fragment {

  public MtCartFragment(){

  }
  private RecyclerView cartItemsRecyclerView;
   private Button continueBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mt_cart, container, false);
        cartItemsRecyclerView=view.findViewById(R.id.cart_items_recyclerview);
        continueBtn=view.findViewById(R.id.caet_continue_btn);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);
        List<CartItemModal>cartItemModalList=new ArrayList<>();
        cartItemModalList.add(new CartItemModal(0,R.drawable.mob,"Pixel 2",2,"Rs.499999/-","Rs.599999/-",1,0,0));
        cartItemModalList.add(new CartItemModal(0,R.drawable.mob,"Pixel 2",0,"Rs.499999/-","Rs.599999/-",1,1,0));
        cartItemModalList.add(new CartItemModal(0,R.drawable.mob,"Pixel 2",2,"Rs.499999/-","Rs.599999/-",1,2,0));
        cartItemModalList.add(new CartItemModal(1,"Price (3items)","Rs.169999/-","Free","Rs.169999/-","Rs.5999/-"));

       CartAdapter cartAdapter=new CartAdapter(cartItemModalList);
       cartItemsRecyclerView.setAdapter(cartAdapter);
       cartAdapter.notifyDataSetChanged();

       continueBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent deliveryIntent=new Intent(getContext(),AddAddreesActivity.class);
               getActivity().startActivity(deliveryIntent);
           }
       });
        return view;
    }

}