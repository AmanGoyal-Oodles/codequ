package com.example.user.codechef.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.user.codechef.R;
import com.example.user.codechef.utils.pojoclasses.TodayEarningDetail;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2/3/2018.
 */

public class TodayEarningsFragment extends Fragment {

    @BindView(R.id.today_earnings_service_price_val_tv)
    TextView mServiceChargesTv;
    @BindView(R.id.today_earnings_delivery_charges_val_tv)
    TextView mDeliveryChargesTv;
    @BindView(R.id.today_earnings_admin_profit_val_tv)
    TextView mAdminProfitTv;
    @BindView(R.id.today_earnings_deliveryman_profit_val_tv)
    TextView mDeliveryManProfitTv;
    @BindView(R.id.today_earnings_paid_order_amt_val_tv)
    TextView mPaidOrderAmtTv;
    @BindView(R.id.today_earnings_cash_amt_val_tv)
    TextView mCashAmtTv;
    @BindView(R.id.today_earnings_cash_on_hand_val_tv)
    TextView mCashOnHandTv;
    private Context mContext;
    private TodayEarningDetail mTodayEarningDetail;
    private String PRICEUNIT=" BD";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_today_earnings,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        init();
    }

    private void init() {
        initVariables();
        //setTextViewValues();
    }

    private void setTextViewValues() {
        mServiceChargesTv.setText(mTodayEarningDetail.getmServicePrice()+PRICEUNIT);
        mDeliveryChargesTv.setText(mTodayEarningDetail.getmDeliveryCharges()+PRICEUNIT);
        mAdminProfitTv.setText(mTodayEarningDetail.getmAdminProfit()+PRICEUNIT);
        mDeliveryManProfitTv.setText(mTodayEarningDetail.getmDeliverymanProfit()+PRICEUNIT);
        mPaidOrderAmtTv.setText(mTodayEarningDetail.getmPaidOrderAmt()+PRICEUNIT);
        mCashAmtTv.setText(mTodayEarningDetail.getmCashAmt()+PRICEUNIT);
        mCashOnHandTv.setText(mTodayEarningDetail.getmCashOnHand()+PRICEUNIT);
    }

    private void initVariables() {
        mContext=getContext();
        mTodayEarningDetail=new TodayEarningDetail();
    }
}
