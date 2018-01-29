package com.example.user.codechef.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.codechef.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 1/25/2018.
 */

public class RegisterFragment extends Fragment {


    @BindView(R.id.register_btn)
    Button mRegisterBtn;
    private static final String TAG=RegisterFragment.class.getName();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_signup_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    @OnClick({R.id.register_btn})
    public void onClickRegister() {
        Fragment verificationCodeFragment=new VerificationCodeFragment();
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_login,verificationCodeFragment,TAG);
        fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }


}
