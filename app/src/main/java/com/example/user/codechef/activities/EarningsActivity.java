package com.example.user.codechef.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.codechef.R;
import com.example.user.codechef.adapters.ViewPagerAdapter;
import com.example.user.codechef.fragments.TodayEarningsFragment;
import com.example.user.codechef.fragments.WeeklyEarningsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EarningsActivity extends AppCompatActivity {


    @BindView(R.id.earnings_tabs)
    TabLayout mEarningsTabs;
    @BindView(R.id.earnings_viewpager)
    ViewPager mEarningsViewPager;
    private Context mContext;
    private Activity mActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earnings);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.Lime));
        }
        init();
        setUpViewPager(mEarningsViewPager);
        mEarningsTabs.setupWithViewPager(mEarningsViewPager);
    }


    private void init() {
        initVariables();
    }

    private void initVariables() {
        mContext=getApplicationContext();
        mActivity=this;
    }

    public void setUpViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TodayEarningsFragment(),"Today");
        adapter.addFragment(new WeeklyEarningsFragment(),"Weekly");
        mEarningsViewPager.setAdapter(adapter);
        mEarningsViewPager.setCurrentItem(0);
    }

}
