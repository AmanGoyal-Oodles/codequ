package com.example.user.codechef.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.user.codechef.R;
import com.example.user.codechef.activities.HomeActivity;

import org.w3c.dom.Text;

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
    @BindView(R.id.signin_password_visible_iv)
    ImageView mPasswordVisibleIv;
    @BindView(R.id.signin_password_et)
    EditText mPasswordEt;
    private ViewPager mViewPager;
    private Context mContext;
    private Activity mActivity;
    private static final String TAG=SignInFragment.class.getName();
    private boolean isPasswordVisible=false;

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
        init();
        mContext=getContext();
        mActivity=getActivity();
        mViewPager=(ViewPager)getActivity().findViewById(R.id.auth_viewpager);
    }

    private void init() {
        initVariables();
    }

    private void initVariables() {
        mContext=getContext();
        mViewPager=(ViewPager)getActivity().findViewById(R.id.auth_viewpager);
        mPasswordVisibleIv.setColorFilter(mContext.getResources().getColor(R.color.Gray_shade2));
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
        Intent intent=new Intent(mActivity, HomeActivity.class);
        mActivity.startActivity(intent);
        mActivity.finish();
    }

    @OnClick({R.id.signin_signup_tv})
    public void onClickSignUp() {
        mViewPager.setCurrentItem(1);
    }

    @OnClick({R.id.signin_password_visible_iv})
    public void onClickVisibilityIv() {
        if(isPasswordVisible) {
            mPasswordVisibleIv.setImageResource(R.drawable.ic_hide);
            mPasswordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
            mPasswordEt.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            isPasswordVisible=false;
        } else {
            mPasswordVisibleIv.setImageResource(R.drawable.ic_show);
            mPasswordEt.setTransformationMethod(null);
            mPasswordEt.setInputType(InputType.TYPE_CLASS_TEXT);
            isPasswordVisible=true;
        }
    }

}