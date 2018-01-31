package com.example.user.codechef.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.user.codechef.R;
import com.example.user.codechef.fragments.AccountFragment;
import com.example.user.codechef.fragments.DeliveryFragment;
import com.example.user.codechef.fragments.ForgotPasswordFragment;
import com.example.user.codechef.fragments.ItemsFragment;
import com.example.user.codechef.fragments.OrdersFragment;
import com.example.user.codechef.fragments.VerificationCodeFragment;
import com.example.user.codechef.utils.util.helperclasses.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.home_navigation)
    BottomNavigationView mNavigationView;
    private static final String TAG=HomeActivity.class.getName();
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        getWindow().setStatusBarColor(getResources().getColor(R.color.Lime));
        mActionBar=getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Lime)));
        Fragment fragment=new OrdersFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.home_frame,fragment,TAG);
        fragmentTransaction.commit();
        BottomNavigationViewHelper.removeShiftMode(mNavigationView);
        mNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected( MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.orders:
                                selectedFragment = new OrdersFragment();
                                break;
                            case R.id.delivery:
                                selectedFragment = new DeliveryFragment();
                                break;
                            case R.id.items:
                                selectedFragment = new ItemsFragment();
                                break;
                            case R.id.account:
                                selectedFragment = new AccountFragment();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.home_frame, selectedFragment,TAG);
                        transaction.commit();
                        return true;
                    }
                });
    }


}
