package com.example.gheee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.gheee.DeliveryActivity.SELECT_ADDRES;

public class MyAddressActivity extends AppCompatActivity {

    private RecyclerView myAddressRecyclerview;
    private Button changeORaddNewAddressbtn;
    private Button deliverHereBtn;
    private static AddressAdapter addressAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        myAddressRecyclerview=findViewById(R.id.address_recycler_view);
        deliverHereBtn=findViewById(R.id.deliver_here_button);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAddressRecyclerview.setLayoutManager(layoutManager);

        List<AddressModal>addressModalList=new ArrayList<>();
        addressModalList.add(new AddressModal("John Doe","sasrdjk vcgftft vcytfy","535456234",true));
        addressModalList.add(new AddressModal("John fffoe","sasrdjk vcgftft vcytfy","535456234",false));
        addressModalList.add(new AddressModal("John Doeew","sasrdjk vcgftft vcytfy","535456234",false));
        addressModalList.add(new AddressModal("John Dofsdfe","sasrdjk vcgftft vcytfy","535456234",false));
        addressModalList.add(new AddressModal("Johewe Doe","sasrdjk vcgftft vcytfy","535456234",false));
        addressModalList.add(new AddressModal("fef Doe","sasrdjk vcgftft vcytfy","535456234",false));
        addressModalList.add(new AddressModal("Joff Doe","sasrdjk vcgftft vcytfy","535456234",false));
        addressModalList.add(new AddressModal("Johfr Doe","sasrdjk vcgftft vcytfy","535456234",false));

        int mode=getIntent().getIntExtra("MODE",-1);
        if (mode==SELECT_ADDRES){
            deliverHereBtn.setVisibility(View.VISIBLE);
        }
        else {
            deliverHereBtn.setVisibility(View.GONE);
        }
         addressAdapter=new AddressAdapter(addressModalList,mode);
        myAddressRecyclerview.setAdapter(addressAdapter);
        ((SimpleItemAnimator) myAddressRecyclerview.getItemAnimator()).setSupportsChangeAnimations(false);
        addressAdapter.notifyDataSetChanged();



    }

    public static void refreshItem(int deselect,int select){
        addressAdapter.notifyItemChanged(deselect);
        addressAdapter.notifyItemChanged(select);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}