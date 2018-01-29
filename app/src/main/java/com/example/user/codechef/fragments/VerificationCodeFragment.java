package com.example.user.codechef.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.example.user.codechef.R;
import com.example.user.codechef.activities.HomeActivity;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by user on 1/28/2018.
 */

public class VerificationCodeFragment extends Fragment {

    @BindView(R.id.verification_code_back_iv)
    ImageView mBackIv;
    @BindView(R.id.verification_code_btn)
    Button mVerifyBtn;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_verification_code_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        mContext=getContext();
    }

    @OnClick({R.id.verification_code_back_iv})
    public void onClickBack() {
        getActivity().onBackPressed();
    }

    @OnClick({R.id.verification_code_btn})
    public void onClickVerificationBtn() {
        Intent intent=new Intent(mContext, HomeActivity.class);
        startActivity(intent);
    }


}
