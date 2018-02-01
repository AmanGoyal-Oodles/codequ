package com.example.user.codechef.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.user.codechef.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemInfoActivity extends AppCompatActivity {


    @BindView(R.id.item_info_back_iv)
    ImageView mBackIv;
    @BindView(R.id.item_info_edit_iv)
    ImageView mEditIv;
    @BindView(R.id.item_info_spinner_tv)
    Spinner mTypeSpinner;
    private ArrayAdapter<String> mItemTypeAdapter;
    private String[] itemcat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        ButterKnife.bind(this);
        itemcat=getResources().getStringArray(R.array.item_type);
        setSpinnerAdapter();
        mTypeSpinner.setEnabled(false);
    }

    private void setSpinnerAdapter() {
        mItemTypeAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item) {
            @Override
            public boolean isEnabled(int position) {
                return position!=0 && super.isEnabled(position);
            }
        };
        mItemTypeAdapter.clear();
        mItemTypeAdapter.addAll(itemcat);
        mTypeSpinner.setAdapter(mItemTypeAdapter);
        mTypeSpinner.setSelection(2);
    }

    @OnClick({R.id.item_info_back_iv})
    public void onClickBackIv() {
        onBackPressed();
    }

}
