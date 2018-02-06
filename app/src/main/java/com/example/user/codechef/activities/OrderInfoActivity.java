package com.example.user.codechef.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.codechef.R;
import com.example.user.codechef.adapters.OrderItemAdapter;
import com.example.user.codechef.utils.pojoclasses.OrderItemDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderInfoActivity extends AppCompatActivity {


    @BindView(R.id.order_info_items_recyclerview)
    RecyclerView mItemRv;
    @BindView(R.id.order_info_person_name_tv)
    TextView mPersonNameTv;
    @BindView(R.id.order_info_payment_method_tv)
    TextView mPaymentMethodTv;
    @BindView(R.id.order_info_price_tv)
    TextView mPriceTv;
    @BindView(R.id.order_info_order_number_tv)
    TextView mOrderNumberTv;
    @BindView(R.id.order_info_ordered_date_tv)
    TextView mOrderDateTv;
    @BindView(R.id.order_info_cancel_order_tv)
    TextView mCancelOrderTv;
    @BindView(R.id.order_info_accept_order_tv)
    TextView mAcceptOrderTv;
    @BindView(R.id.order_info_name_tv)
    TextView mNameTv;
    @BindView(R.id.order_info_payment_method2_tv)
    TextView mPaymentMethod2Tv;
    @BindView(R.id.order_info_address_tv)
    TextView mAddressTv;
    @BindView(R.id.order_info_home_iv)
    ImageView mHomeIv;
    @BindView(R.id.order_info_back_iv)
    ImageView mBackIv;
    @BindView(R.id.order_info_open_map_layout)
    RelativeLayout mOrderDetailLayout;
    private Context mContext;
    private OrderItemAdapter mOrderItemAdapter;
    private ArrayList<OrderItemDetail> mOrderItemDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.Lime));
        }
        init();
    }

    private void init() {
        initVariables();
    }

    private void initVariables() {
        mContext=getApplicationContext();
        mOrderItemDetailList=new ArrayList<>();
        setOrderItemDetailList();
        initRecyclerView();
    }

    private void setOrderItemDetailList() {
        mOrderItemDetailList.add(new OrderItemDetail("Ginger Chicken Curry","20","1"));
        mOrderItemDetailList.add(new OrderItemDetail("Paneer Khurchan","10","2"));
        mOrderItemDetailList.add(new OrderItemDetail("Ginger Chicken Curry","20","1"));
        //mOrderItemDetailList.add(new OrderItemDetail("Paneer Khurchan","10","2"));
        mOrderItemDetailList.add(new OrderItemDetail("Ginger Chicken Curry","20","2"));
    }

    private void initRecyclerView() {
        mOrderItemAdapter=new OrderItemAdapter(mContext);
        mOrderItemAdapter.setmOrderItemDetailList(mOrderItemDetailList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(mContext);
        mItemRv.setLayoutManager(layoutManager);
        mItemRv.setItemAnimator(new DefaultItemAnimator());
        mItemRv.setAdapter(mOrderItemAdapter);
    }

    @OnClick({R.id.order_info_back_iv})
    public void onClickBackIv() {
        onBackPressed();
    }

    @OnClick({R.id.order_info_open_map_layout})
    public void onClickOrderDetailMap() {
        Intent intent=new Intent(this, DeliveryInfoActivity.class);
        startActivity(intent);
    }

}
