package com.example.gheee;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MyAccountFragment extends Fragment {

   public MyAccountFragment(){

    }

    private Button viewAllAdreesbtn;

    public static final int MANAGE_ADDRESS=1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_account, container, false);

        viewAllAdreesbtn=view.findViewById(R.id.view_all_address_button);
        viewAllAdreesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressesIntent=new Intent(getContext(),MyAddressActivity.class);
                myAddressesIntent.putExtra("MODE",MANAGE_ADDRESS);
                startActivity(myAddressesIntent);
            }
        });


        return view;
    }
}