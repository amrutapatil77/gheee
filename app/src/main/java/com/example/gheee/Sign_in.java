package com.example.gheee;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.gheee.RegisterActivity.onResetPasswordFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sign_in extends Fragment {


    public Sign_in() {
        // Required empty public constructor

    }
        private TextView dontHaveAnAccount;
        private FrameLayout parentFrameLayout;

        private EditText emil;
        private EditText password;
        private ProgressBar progressBar;


        private TextView forgotpassword;

        private Button signInbtn;
        private FirebaseAuth firebaseAuth;
        private String emailPattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        dontHaveAnAccount=view.findViewById(R.id.tvReg) ;

        parentFrameLayout=getActivity().findViewById(R.id.register_framlayout);

        forgotpassword=view.findViewById(R.id.signin_forgrt_password);

        emil=view.findViewById(R.id.signin_email);
        password=view.findViewById(R.id.signin_password);

        progressBar=view.findViewById(R.id.signin_progressbar);

        signInbtn=view.findViewById(R.id.signin_btn);

        firebaseAuth=FirebaseAuth.getInstance();

        return  view;
    }






    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dontHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Sign_up());
            }
        });



        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetPasswordFragment=true;

                setFragment(new reset_password_Fragment());
            }
        });

        emil.addTextChangedListener(new TextWatcher() {
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
        password.addTextChangedListener(new TextWatcher() {
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

        signInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkEmilAndPassword();
            }
        });

    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_frome_right,R.anim.slideout_frome_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs() {
        if(!TextUtils.isEmpty(emil.getText())){
            if(!TextUtils.isEmpty(password.getText())){
               signInbtn.setEnabled(true);
               signInbtn.setTextColor(Color.rgb(255,255,255));
            }else {

                signInbtn.setEnabled(false);
                signInbtn.setTextColor(Color.argb(50,255,255,255));
            }
        }else {
            signInbtn.setEnabled(false);
            signInbtn.setTextColor(Color.argb(50,255,255,255));

        }

    }

    private void checkEmilAndPassword()
    {
        if (emil.getText().toString().matches(emailPattern)){
            if (password.length()>=8){

                progressBar.setVisibility(View.VISIBLE);
                signInbtn.setEnabled(false);
                signInbtn.setTextColor(Color.argb(50,255,255,255));


                firebaseAuth.signInWithEmailAndPassword(emil.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent mainInent= new Intent(getActivity(),StartActivity.class);
                                    startActivity(mainInent);
                                    getActivity().finish();


                                }else {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    signInbtn.setEnabled(true);
                                    signInbtn.setTextColor(Color.rgb(255,255,255));

                                    String error=task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }else {
                Toast.makeText(getActivity(),"Incoorect emil or password!",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(),"Incoorect emil or password!",Toast.LENGTH_SHORT).show();
        }

    }

}









