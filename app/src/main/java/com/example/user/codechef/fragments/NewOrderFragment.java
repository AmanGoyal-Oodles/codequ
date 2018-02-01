package com.example.user.codechef.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.codechef.R;
import com.example.user.codechef.adapters.NewOrderAdapter;
import com.example.user.codechef.utils.pojoclasses.NewOrderDetail;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2/1/2018.
 */

public class NewOrderFragment extends Fragment {


    @BindView(R.id.new_order_recycler_view)
    RecyclerView mNewOrderRv;
    private Context mContext;
    private Activity mActivity;
    private NewOrderAdapter mNewOrderAdapter;
    private ArrayList<NewOrderDetail> mNewOrderDetailList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_order,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        init();
    }

    private void init() {
        initVariables();
        setNewOrderList();
        initRecyclerView();
    }

    private void setNewOrderList() {
        mNewOrderDetailList.add(new NewOrderDetail("Ahmed Ali","40 BHD","042","11:45 am, 01 Jan,2018","Cash", 0));
        mNewOrderDetailList.add(new NewOrderDetail("Johny Jonson","52 BHD","042","11:45 am, 01 Jan,2018","Credit Card", 1));
        mNewOrderDetailList.add(new NewOrderDetail("Helly Tonny","40 BHD","042","11:45 am, 01 Jan,2018","Cash", 1));
        mNewOrderDetailList.add(new NewOrderDetail("Tina roy","52 BHD","042","11:45 am, 01 Jan,2018","Cash", 1));
        mNewOrderDetailList.add(new NewOrderDetail("Abhijeet Sharma","35 BHD","042","11:45 am, 01 Jan,2018","Credit Card", 0));
        mNewOrderDetailList.add(new NewOrderDetail("Rakesh Kapoor","28 BHD","042","11:45 am, 01 Jan,2018","Cash", 1));
    }

    private void initRecyclerView() {
        mNewOrderAdapter=new NewOrderAdapter(mContext);
        mNewOrderAdapter.setmNewOrderDetails(mNewOrderDetailList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(mContext);
        mNewOrderRv.setLayoutManager(layoutManager);
        mNewOrderRv.setItemAnimator(new DefaultItemAnimator());
        mNewOrderRv.setAdapter(mNewOrderAdapter);
    }

    private void initVariables() {
        mContext=getContext();
        mActivity=getActivity();
        mNewOrderDetailList=new ArrayList<>();
    }

}
