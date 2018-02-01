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
import com.example.user.codechef.adapters.PastOrderAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2/1/2018.
 */

public class PastOrderFragment extends Fragment {


    @BindView(R.id.past_order_recycler_view)
    RecyclerView mPastOrderRv;
    private Context mContext;
    private Activity mActivity;
    private PastOrderAdapter mPastOrderAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_past_order,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        init();
    }

    private void init() {
        initVariables();
        setRecyclerView();
    }

    private void setRecyclerView() {
        mPastOrderAdapter=new PastOrderAdapter(mContext);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(mContext);
        mPastOrderRv.setLayoutManager(layoutManager);
        mPastOrderRv.setItemAnimator(new DefaultItemAnimator());
        mPastOrderRv.setAdapter(mPastOrderAdapter);

    }

    private void initVariables() {
        mContext=getContext();
        mActivity=getActivity();
    }

}
