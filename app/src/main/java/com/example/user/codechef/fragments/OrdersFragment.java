package com.example.user.codechef.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.codechef.R;
import com.example.user.codechef.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/28/2018.
 */

public class OrdersFragment extends Fragment {


    @BindView(R.id.order_tabs)
    TabLayout mOrderTabs;
    @BindView(R.id.order_viewpager)
    ViewPager mOrderViewPager;
    private Context mContext;
    private Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_orders,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        getActivity().setTitle("Orders");
        init();
        setUpViewPager(mOrderViewPager);
        mOrderTabs.setupWithViewPager(mOrderViewPager);
    }

    private void init() {
        initVariables();
    }

    private void initVariables() {
        mContext=getContext();
        mActivity=getActivity();
    }

    public void setUpViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new NewOrderFragment(),"New Orders");
        adapter.addFragment(new PastOrderFragment(),"Past Orders");
        mOrderViewPager.setAdapter(adapter);
        mOrderViewPager.setCurrentItem(0);
    }
}
