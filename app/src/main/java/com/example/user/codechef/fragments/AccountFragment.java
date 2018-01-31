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
import com.example.user.codechef.adapters.AccountListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/28/2018.
 */

public class AccountFragment extends Fragment {


    @BindView(R.id.account_list_rv)
    RecyclerView mRecyclerView;
    private AccountListAdapter mAccountListAdapter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_account,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        getActivity().setTitle("Account");
        init();
    }

    private void init() {
        initVariables();
        initRecyclerView();
    }

    private void initVariables() {
        mContext=getContext();
    }

    private void initRecyclerView() {
        mAccountListAdapter=new AccountListAdapter(mContext);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAccountListAdapter);
    }
}
