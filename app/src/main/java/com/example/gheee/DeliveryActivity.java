package com.example.gheee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.gheee.R.id.action_bar_logo;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryRecyclerview;
    private Button changeoeAddnewAddreesBtn;
    public static final int SELECT_ADDRES = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        deliveryRecyclerview=findViewById(R.id.delivery_recycler_view);
        changeoeAddnewAddreesBtn=findViewById(R.id.change_add_address_btn);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerview.setLayoutManager(layoutManager);
        List<CartItemModal> cartItemModalList=new ArrayList<>();
        cartItemModalList.add(new CartItemModal(0,R.drawable.mob,"Pixel 2",2,"Rs.499999/-","Rs.599999/-",1,0,0));
        cartItemModalList.add(new CartItemModal(0,R.drawable.mob,"Pixel 2",0,"Rs.499999/-","Rs.599999/-",1,1,0));
        cartItemModalList.add(new CartItemModal(0,R.drawable.mob,"Pixel 2",2,"Rs.499999/-","Rs.599999/-",1,2,0));
        cartItemModalList.add(new CartItemModal(1,"Price (3items)","Rs.169999/-","Free","Rs.169999/-","Rs.5999/-"));

        CartAdapter cartAdapter=new CartAdapter(cartItemModalList);
        deliveryRecyclerview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        changeoeAddnewAddreesBtn.setVisibility(View.VISIBLE);
        changeoeAddnewAddreesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressesIntent=new Intent(DeliveryActivity.this,MyAddressActivity.class);
                myAddressesIntent.putExtra("MODE",SELECT_ADDRES);
                startActivity(myAddressesIntent);
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Inflate the menu; this adds items to the action bar if it is present.
        int id = item.getItemId();

        if(id==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}