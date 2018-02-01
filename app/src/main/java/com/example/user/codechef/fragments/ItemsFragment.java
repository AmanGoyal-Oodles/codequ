package com.example.user.codechef.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.codechef.R;
import com.example.user.codechef.activities.AddItemActivity;
import com.example.user.codechef.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 1/28/2018.
 */

public class ItemsFragment extends Fragment {


    @BindView(R.id.item_tabs)
    TabLayout mItemTabs;
    @BindView(R.id.item_viewpager)
    ViewPager mItemViewPager;
    @BindView(R.id.item_add_fab)
    FloatingActionButton mItemAddFab;
    private Context mContext;
    private Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_items,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        getActivity().setTitle("Items");
        init();
        setUpViewPager(mItemViewPager);
        mItemTabs.setupWithViewPager(mItemViewPager);
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
        adapter.addFragment(new ApprovedItemFragment(),"Approved Items");
        adapter.addFragment(new PendingItemFragment(),"Pending Items");
        mItemViewPager.setAdapter(adapter);
        mItemViewPager.setCurrentItem(0);
    }

    @OnClick({R.id.item_add_fab})
    public void onClickFabOpenAddItemActivity() {
        Intent addItemIntent=new Intent(mActivity, AddItemActivity.class);
        startActivity(addItemIntent);
    }
}
