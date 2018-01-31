package com.example.user.codechef.fragments;

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
import com.example.user.codechef.adapters.DeliveryListAdapter;
import com.example.user.codechef.utils.pojoclasses.DeliveryDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/28/2018.
 */

public class DeliveryFragment extends Fragment {


    @BindView(R.id.delivery_recycler_view)
    RecyclerView mRecyclerView;
    private DeliveryListAdapter mDeliveryListAdapter;
    private Context mContext;
    private ArrayList<DeliveryDetail> mDeliveryDetailList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_delivery,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        getActivity().setTitle("Delivery");
        init();
    }

    private void init() {
        initVariables();
        setVariablesToDefaultValues();
        initRecyclerView();
    }

    private void setVariablesToDefaultValues() {
        mDeliveryDetailList.add(new DeliveryDetail("Perry Johnson","Cash","042","07:02 pm, 01 Jan, 18",1));
        mDeliveryDetailList.add(new DeliveryDetail("David Anderson","Credit Card","042","07:02 pm, 01 Jan, 18",1));
        mDeliveryDetailList.add(new DeliveryDetail("Jerry Smith","Cash","042","07:02 pm, 01 Jan, 18",2));
        mDeliveryDetailList.add(new DeliveryDetail("Ritvi George","Debit Card","042","07:02 pm, 01 Jan, 18",2));
    }

    private void initRecyclerView() {
        mDeliveryListAdapter=new DeliveryListAdapter(mContext);
        mDeliveryListAdapter.setDeliveryList(mDeliveryDetailList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mDeliveryListAdapter);
    }

    private void initVariables() {
        mContext=getContext();
        mDeliveryDetailList=new ArrayList<>();
    }
}
