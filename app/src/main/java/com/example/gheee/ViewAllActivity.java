package com.example.gheee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ViewAllActivity<layout_code> extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code", -1);

        if (layout_code == 0){

            recyclerView.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        List<WhishListModal> whishListModalList = new ArrayList<>();
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 1, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 0, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 2, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 4, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 1, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 1, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 0, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 2, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 4, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));
        whishListModalList.add(new WhishListModal(R.drawable.mob, "Pixel 2", 1, "3", 145, "Rs.49999/-", "Rs.59999/-", "Cash on delivery"));

        WhishListAdapter adapter = new WhishListAdapter(whishListModalList, false);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    } else if(layout_code==1)

    {
        gridView.setVisibility(View.VISIBLE);
        List<HorizontalProductScrollModal> horizontalProductScrollModalList = new ArrayList<>();
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone5, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone1, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.pho, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone1, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone3, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone4, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone5, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone1, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.pho, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone1, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone3, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone4, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));
        horizontalProductScrollModalList.add(new HorizontalProductScrollModal(R.mipmap.phone, "Redmi 5A", "SD 625 Processer", "RS.5999/-"));


        GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModalList);
        gridView.setAdapter(gridProductLayoutAdapter);
    }

}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}