package com.example.user.codechef.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.codechef.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/30/2018.
 */

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.AccountListHolder> {


    private Context mContext;
    private ArrayList<String> accountListName;

    public AccountListAdapter(Context context) {
        mContext=context;
       // accountListName.addAll(mContext.getResources().getStringArray(R.id.account_list));
    }

    @Override
    public AccountListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_layout,parent,false);
        return new AccountListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AccountListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AccountListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.account_item_image_view)
        ImageView imageView;
        @BindView(R.id.account_item_tv)
        TextView textView;

        public AccountListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
