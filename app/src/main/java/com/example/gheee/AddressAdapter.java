package com.example.gheee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.gheee.DeliveryActivity.SELECT_ADDRES;
import static com.example.gheee.MyAccountFragment.MANAGE_ADDRESS;
import static com.example.gheee.MyAddressActivity.refreshItem;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    private List<AddressModal> addressModalList;
    private int MODE;
    private  int preSelectedPostion=-1;

    public AddressAdapter(List<AddressModal> addressModalList, int MODE) {
        this.addressModalList = addressModalList;
        this.MODE = MODE;
    }

    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder viewHolder, int position) {

        String name = addressModalList.get(position).getFullname();
        String address = addressModalList.get(position).getAddress();
        String pincode = addressModalList.get(position).getPincode();
        Boolean selected = addressModalList.get(position).getSelected();
        viewHolder.setData(name, address, pincode, selected,position);

    }

    @Override
    public int getItemCount() {
        return addressModalList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView fullname;
        private TextView address;
        private TextView pincode;
        private ImageView icon;
        private LinearLayout optionContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fullname = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            pincode = itemView.findViewById(R.id.pincode);
            icon = itemView.findViewById(R.id.icon_view);
            optionContainer=itemView.findViewById(R.id.option_container);
        }

        private void setData(String username, String userAddress, String userPincode, final Boolean selected, final int position) {
            fullname.setText(username);
            address.setText(userAddress);
            pincode.setText(userPincode);

            if (MODE == SELECT_ADDRES) {
                icon.setImageResource(R.mipmap.tick);
                if (selected) {
                    icon.setVisibility(View.VISIBLE);
                    preSelectedPostion=position;
                } else {
                    icon.setVisibility(View.GONE);
                }

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (preSelectedPostion!=position) {
                            addressModalList.get(position).setSelected(true);
                            addressModalList.get(preSelectedPostion).setSelected(false);
                            refreshItem(preSelectedPostion, position);
                            preSelectedPostion = position;
                        }
                    }
                });
            } else if (MODE == MANAGE_ADDRESS) {

                optionContainer.setVisibility(View.GONE);
                icon.setImageResource(R.mipmap.vertical_dot);
                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        optionContainer.setVisibility(View.VISIBLE);
                        refreshItem(preSelectedPostion,preSelectedPostion);
                        preSelectedPostion=position;
                    }
                });
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshItem(preSelectedPostion,preSelectedPostion);
                        preSelectedPostion=-1;
                    }
                });
            }
        }
    }
}
