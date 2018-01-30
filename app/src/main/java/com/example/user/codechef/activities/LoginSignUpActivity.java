package com.example.user.codechef.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.codechef.R;
import com.example.user.codechef.adapters.ViewPagerAdapter;
import com.example.user.codechef.fragments.LoginSignUpTabFragment;
import com.example.user.codechef.fragments.RegisterFragment;
import com.example.user.codechef.fragments.SignInFragment;
import com.example.user.codechef.utils.IntentKeyConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginSignUpActivity extends AppCompatActivity {


    private int tabPosition;
    private static final String TAG=LoginSignUpActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
        ButterKnife.bind(this);
        tabPosition=getIntent().getIntExtra(IntentKeyConstants.TAB_POSITION,0);
        openLoginSIgnUpTabFragment();    
    }

    private void openLoginSIgnUpTabFragment() {
        Bundle bundle = new Bundle();
        bundle.putInt(IntentKeyConstants.TAB_POSITION,tabPosition);
        Fragment fragment = new LoginSignUpTabFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_login, fragment, TAG);
        fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()==1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}