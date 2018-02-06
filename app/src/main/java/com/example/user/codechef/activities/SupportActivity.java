package com.example.user.codechef.activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.user.codechef.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SupportActivity extends AppCompatActivity {


    @BindView(R.id.support_back_iv)
    ImageView mBackIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.Lime));
        }
    }

    @OnClick(R.id.support_back_iv)
    public void onClickBackIv() {
        onBackPressed();
    }

}
