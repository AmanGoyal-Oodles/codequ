package com.example.user.codechef.activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.user.codechef.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BankDetailActivity extends AppCompatActivity {


    @BindView(R.id.bank_detail_back_iv)
    ImageView mBackIv;
    @BindView(R.id.bank_detail_update_btn)
    Button mUpdateBtn;
    @BindView(R.id.bank_detail_bank_name_spinner)
    Spinner mBankSpinner;
    private ArrayAdapter<String> mBankNameAdapter;
    private String[] bankNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detail);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.Lime));
        }
        init();
    }

    private void init() {
        initVariables();
        setSpinnerAdapter();
    }

    private void initVariables() {
        bankNames=getResources().getStringArray(R.array.bank_names);
    }

    private void setSpinnerAdapter() {
        mBankNameAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item) {
            @Override
            public boolean isEnabled(int position) {
                return position!=0 && super.isEnabled(position);
            }
        };
        mBankNameAdapter.clear();
        mBankNameAdapter.addAll(bankNames);
        mBankSpinner.setAdapter(mBankNameAdapter);
    }

    @OnClick({R.id.bank_detail_back_iv})
    public void onClickBackIv() {
        onBackPressed();
    }

    @OnClick({R.id.bank_detail_update_btn})
    public void onClickUpdateInfoBtn() {
        onBackPressed();
    }
}
