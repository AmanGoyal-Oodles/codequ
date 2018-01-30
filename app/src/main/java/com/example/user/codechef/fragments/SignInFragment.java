package com.example.user.codechef.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.user.codechef.R;
import com.example.user.codechef.activities.HomeActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 1/25/2018.
 */

public class SignInFragment extends Fragment {


    @BindView(R.id.signin_forgot_pass_tv)
    TextView mForgotPassTv;
    @BindView(R.id.signin_btn)
    Button mSignInBtn;
    @BindView(R.id.signin_signup_tv)
    TextView mSignUpTv;
    private ViewPager mViewPager;
    private Context mContext;
    private static final String TAG=SignInFragment.class.getName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mContext=getContext();
        mViewPager=(ViewPager)getActivity().findViewById(R.id.auth_viewpager);
    }

    @OnClick({R.id.signin_forgot_pass_tv})
    public void onClickForgotPass() {
        //todo open forgot pass fragment
        Fragment forgotPasswordFragment=new ForgotPasswordFragment();
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_login,forgotPasswordFragment,TAG);
        fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.signin_btn})
    public void onClickSignIn() {
        Intent intent=new Intent(mContext, HomeActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.signin_signup_tv})
    public void onClickSignUp() {
        mViewPager.setCurrentItem(1);
    }

}