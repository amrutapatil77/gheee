package com.example.gheee;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ProductDetailsAdpter extends  FragmentStateAdapter {
    private int totalTabs;
private int tanCount;
    public ProductDetailsAdpter( FragmentManager supportFragmentManager,  Lifecycle lifecycle, int totalTabs) {
        super(supportFragmentManager, lifecycle);
        this.totalTabs = totalTabs;
    }




    @Override
    public Fragment createFragment(int i) {
        switch (i){
            case 0:
                ProductDescriptionFragment productDescriptionFragment1=new ProductDescriptionFragment();
                return productDescriptionFragment1;
            case 1:

                ProductSpecificationFragment productSpecificationFragment=new ProductSpecificationFragment();
                return productSpecificationFragment;
            case 2:
                ProductDescriptionFragment productDescriptionFragment2=new ProductDescriptionFragment();
                return productDescriptionFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return totalTabs;
    }
}

