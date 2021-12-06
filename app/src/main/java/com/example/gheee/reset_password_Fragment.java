package com.example.gheee;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class reset_password_Fragment extends Fragment {


    public reset_password_Fragment() {
        // Required empty public constructor
    }

    private EditText regEmail;
    private Button resetpasswordBtn;
    private TextView goBack;
    private FrameLayout parentFrameLayout;

    private ViewGroup emailIconcontainer;
    private ImageView emailIcon;
    private TextView emailIconText;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reset_password_, container, false);

        regEmail=view.findViewById(R.id.forgot_pass_Emil);
        resetpasswordBtn=view.findViewById(R.id.reset_password_btn);
        goBack=view.findViewById(R.id.forgot_pass_goback);
        parentFrameLayout=getActivity().findViewById(R.id.register_framlayout);

        emailIconcontainer=view.findViewById(R.id.fogot_password__email_icon_con);
        emailIcon=view.findViewById(R.id.forgot_pass_email_icon);
        emailIconText=view.findViewById(R.id.forgot_pass_email_icon_text);
        progressBar=view.findViewById(R.id.fogot_pass_progressBar);

        firebaseAuth=FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        regEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        resetpasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition((emailIconcontainer));
                emailIconText.setVisibility(View.GONE);

                TransitionManager.beginDelayedTransition(emailIconcontainer);
                emailIcon.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);




                resetpasswordBtn.setEnabled(false);
                resetpasswordBtn.setTextColor(Color.argb(50,255,255,255));

                firebaseAuth.sendPasswordResetEmail(regEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){

                                    ScaleAnimation scaleAnimation=new ScaleAnimation(1,0,1,0,emailIcon.getWidth()/2,emailIcon.getHeight()/2);
                                     scaleAnimation.setDuration(100);
                                    scaleAnimation.setInterpolator(new AccelerateInterpolator());
                                    scaleAnimation.setRepeatMode(Animation.REVERSE);
                                    scaleAnimation.setRepeatCount(1);


                                    scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {

                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {

                                            emailIconText.setText("Rcovery email sent successfully ! check your inbox");

                                            emailIconText.setTextColor(getResources().getColor(R.color.successGreen));


                                            TransitionManager.beginDelayedTransition(emailIconcontainer);
                                            
                                            emailIconText.setVisibility(View.VISIBLE);
                                            


                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {
                                            emailIcon.setImageResource(R.mipmap.green_emai);
                                        }
                                    });
                                    
                                    emailIcon.startAnimation(scaleAnimation);




                                }else {
                                    String error=task.getException().getMessage();
                                    resetpasswordBtn.setEnabled(true);
                                    resetpasswordBtn.setTextColor(Color.rgb(255,255,255));


                                    emailIconText.setText(error);
                                    emailIconText.setTextColor(getResources().getColor(R.color.color_red));
                                    TransitionManager.beginDelayedTransition(emailIconcontainer);
                                    emailIconText.setVisibility(View.VISIBLE);
                                }
                                progressBar.setVisibility(View.GONE);


                            }

                        });

            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Sign_in());

            }
        });




    }

    private  void checkInputs()
    {

        if (TextUtils.isEmpty(regEmail.getText())){
         resetpasswordBtn.setEnabled(false);
           resetpasswordBtn.setTextColor(Color.argb(50,255,255,255));

        }else
        {
            resetpasswordBtn.setEnabled(true);
            resetpasswordBtn.setTextColor(Color.rgb(255,255,255));


        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();

        fragmentTransaction.setCustomAnimations(R.anim.slide_frome_left,R.anim.slideout_frome_right);

        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }


    public static class HomePageModal {

        private int type;
        //////////banner slider
        private List<SliderModel> sliderModelList;

        public HomePageModal(int type, List<SliderModel> sliderModelList) {
            this.type = type;
            this.sliderModelList = sliderModelList;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<SliderModel> getSliderModelList() {
            return sliderModelList;
        }

        public void setSliderModelList(List<SliderModel> sliderModelList) {
            this.sliderModelList = sliderModelList;
        }   //////////banner slider
    }

    public static class MyOrderItemModal {
        private int productImage;
        private String productTitle;
        private String deliveryStatus;

        public MyOrderItemModal(int productImage, String productTitle, String deliveryStatus) {
            this.productImage = productImage;
            this.productTitle = productTitle;
            this.deliveryStatus = deliveryStatus;
        }

        public int getProductImage() {
            return productImage;
        }

        public void setProductImage(int productImage) {
            this.productImage = productImage;
        }

        public String getProductTitle() {
            return productTitle;
        }

        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }

        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }
    }
}
