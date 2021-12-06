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


public class ProductSpecificationFragment extends Fragment {
    public ProductSpecificationFragment() {
        // Required empty public constructor
    }
    private RecyclerView productSpecificationRecylerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view= inflater.inflate(R.layout.fragment_product_specification, container, false);
        productSpecificationRecylerView=view.findViewById(R.id.product_specification_recycleviewer);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        productSpecificationRecylerView.setLayoutManager(linearLayoutManager);
        List<ProductSpecificationModal> productSpecificationModalList=new ArrayList<>();
        productSpecificationModalList.add(new ProductSpecificationModal(0,"General"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(0,"Display"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(0,"General"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(0,"Display"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));
        productSpecificationModalList.add(new ProductSpecificationModal(1,"RAM","4GB"));

        ProductSpecifictionAdapter productSpecifictionAdapter=new ProductSpecifictionAdapter(productSpecificationModalList);
       productSpecificationRecylerView.setAdapter(productSpecifictionAdapter);
        productSpecifictionAdapter.notifyDataSetChanged();
        return view;
    }
}