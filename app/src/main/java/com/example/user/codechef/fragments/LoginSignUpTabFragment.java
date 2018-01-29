package com.example.user.codechef.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.codechef.R;
import com.example.user.codechef.adapters.ViewPagerAdapter;
import com.example.user.codechef.utils.IntentKeyConstants;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/28/2018.
 */

public class LoginSignUpTabFragment extends Fragment {


    @BindView(R.id.auth_tabs)
    TabLayout mAuthTabs;
    @BindView(R.id.auth_viewpager)
    ViewPager mAuhViewPager;
    private int tabPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login_signup_tab_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        init();
        setUpViewPager(mAuhViewPager);
        mAuthTabs.setupWithViewPager(mAuhViewPager);
    }

    private void init() {
        tabPosition=getActivity().getIntent().getIntExtra(IntentKeyConstants.TAB_POSITION,0);
    }

    public void setUpViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new SignInFragment(),"Sign in");
        adapter.addFragment(new RegisterFragment(),"Register");
        mAuhViewPager.setAdapter(adapter);
        mAuhViewPager.setCurrentItem(tabPosition);
    }

}