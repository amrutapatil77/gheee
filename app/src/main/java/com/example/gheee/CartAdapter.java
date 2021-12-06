package com.example.gheee;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.ResourceBundle;

public class CartAdapter extends RecyclerView.Adapter {
    private List<CartItemModal> cartItemModalList;

    public CartAdapter(List<CartItemModal> cartItemModalList) {
        this.cartItemModalList = cartItemModalList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModalList.get(position).getType()){
            case 0:
                return CartItemModal.CART_ITEM;
            case 1:
                return CartItemModal.TOTAL_AMOUNT;
            default:
                return -1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       switch (viewType){
           case CartItemModal.CART_ITEM:
               View CartItemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
               return new CartItemViewHolder(CartItemview);
           case CartItemModal.TOTAL_AMOUNT:
               View CartTotalview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
               return new CartItemViewHolder(CartTotalview);

           default:
               return null;
       }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (cartItemModalList.get(position).getType()){
            case CartItemModal.CART_ITEM:
                int resource=cartItemModalList.get(position).getProductImage();
                String title=cartItemModalList.get(position).getProductTitle();
                int freeCoupens=cartItemModalList.get(position).getFreeCoupen();
                String productPrice=cartItemModalList.get(position).getProductPrice();
                String cuttedPrice=cartItemModalList.get(position).getCuttedPrice();
                int offersApplied=cartItemModalList.get(position).getOffersApplied();

                ((CartItemViewHolder)viewHolder).setItemDetails(resource,title,freeCoupens,productPrice,cuttedPrice,offersApplied);
                break;
            case CartItemModal.TOTAL_AMOUNT:
                String totalItems=cartItemModalList.get(position).getTotalItem();
                String totalItemPrice=cartItemModalList.get(position).getTotalItemPrice();
                String deliveryPrice=cartItemModalList.get(position).getDelivaryPrice();
                String totalAmount=cartItemModalList.get(position).getTotalAmount();
                String savedAmount=cartItemModalList.get(position).getSavedAmount();

                ((CartTotalAmountViewholder)viewHolder).setTotalAmount(totalItems,totalItemPrice,deliveryPrice,totalAmount,savedAmount);
                break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return cartItemModalList.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private ImageView freeCoupenIcon;
        private TextView productTitle;
        private TextView freeCoupens;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplird;
        private TextView coupenApplied;
        private TextView productQuentity;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            freeCoupenIcon=itemView.findViewById(R.id.free_coupen_icon);
            freeCoupens=itemView.findViewById(R.id.tv_free_coupen);
            productPrice=itemView.findViewById(R.id.product_prize);
            cuttedPrice=itemView.findViewById(R.id.cutted_price);
            offersApplird=itemView.findViewById(R.id.offer_applied);
            coupenApplied=itemView.findViewById(R.id.coupens_applied);
            productQuentity=itemView.findViewById(R.id.product_quentity);
        }
        private  void  setItemDetails(int resource,String title,int freeCoupenNo,String productPriceText,String cuttedPriceText,int offersAppliedNo){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCoupenNo>0){
                freeCoupenIcon.setVisibility(View.VISIBLE);
                freeCoupens.setVisibility(View.VISIBLE);
                if (freeCoupenNo==1){
                freeCoupens.setText("free " + freeCoupenNo+ " Coupen");
            }else {
                freeCoupens.setText("free " + freeCoupenNo + " Coupens");

            }
            }else {
            freeCoupenIcon.setVisibility(View.INVISIBLE);
            freeCoupens.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
            cuttedPrice.setText(cuttedPriceText);
            if (offersAppliedNo>0){
                offersApplird.setVisibility(View.VISIBLE);
                offersApplird.setText(offersAppliedNo+" Offers applied");
            }else {
                offersApplird.setVisibility(View.INVISIBLE);
            }
            if (offersAppliedNo>0){
                offersApplird.setVisibility(View.VISIBLE);
                offersApplird.setText(offersAppliedNo+"Offers applied");
            }else {
                offersApplird.setVisibility(View.INVISIBLE);
            }

            productQuentity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog quentityDialog=new Dialog(itemView.getContext());
                    quentityDialog.setContentView(R.layout.quentity_dialog);
                    quentityDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                    quentityDialog.setCancelable(false);
                    final EditText quentityNo=quentityDialog.findViewById(R.id.quantity_no);
                    Button cancelBtb=quentityDialog.findViewById(R.id.cancel_btn);
                    Button okBtb=quentityDialog.findViewById(R.id.ok_btn);

                    cancelBtb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            quentityDialog.dismiss();

                        }
                    });

                    okBtb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            productQuentity.setText("Qty:  "+quentityNo.getText());
                            quentityDialog.dismiss();

                        }
                    });

                    quentityDialog.show();

                }
            });
        }
    }
    class CartTotalAmountViewholder extends RecyclerView.ViewHolder{

        private TextView totalItems;
        private TextView totalItemPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView savedAmount;
        public CartTotalAmountViewholder(@NonNull View itemView) {
            super(itemView);

            totalItems=itemView.findViewById(R.id.total_items);
            totalItemPrice=itemView.findViewById(R.id.total_items_price);
            deliveryPrice=itemView.findViewById(R.id.deliwary_price);
            totalAmount=itemView.findViewById(R.id.total_price);
            savedAmount=itemView.findViewById(R.id.saved_amound);
        }
        private void setTotalAmount(String totalItemText,String totalItemPriceText,String deliveryPriceText,String totalAmountText,String savedAmountText){
            totalItems.setText(totalItemText);
            totalItemPrice.setText(totalItemPriceText);
            deliveryPrice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
            savedAmount.setText(savedAmountText);
        }

        
    }
}
