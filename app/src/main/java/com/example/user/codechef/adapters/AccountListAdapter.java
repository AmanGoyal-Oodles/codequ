package com.example.user.codechef.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.codechef.R;
import com.example.user.codechef.activities.BankDetailActivity;
import com.example.user.codechef.activities.EarningsActivity;
import com.example.user.codechef.activities.ProfileActivity;
import com.example.user.codechef.activities.ReviewActivity;
import com.example.user.codechef.activities.SupportActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 1/30/2018.
 */

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.AccountListHolder> {


    private Context mContext;
    private String[] accountListName;
    private TypedArray icons;

    public AccountListAdapter(Context context) {
        mContext=context;
        accountListName=mContext.getResources().getStringArray(R.array.account_list);
        icons=mContext.getResources().obtainTypedArray(R.array.account_list_icons);
    }

    @Override
    public AccountListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_layout,parent,false);
        return new AccountListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AccountListHolder holder, int position) {
        holder.imageView.setImageDrawable(icons.getDrawable(position));
        holder.textView.setText(accountListName[position]);
    }

    @Override
    public int getItemCount() {
        return accountListName.length;
    }

    public class AccountListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.account_item_image_view)
        ImageView imageView;
        @BindView(R.id.account_item_tv)
        TextView textView;
        @BindView(R.id.account_item_layout)
        LinearLayout accountItemLayout;

        public AccountListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            imageView.setColorFilter(mContext.getResources().getColor(R.color.Lime));
        }

        @OnClick({R.id.account_item_layout})
        public void onClickItem() {
            int position=getAdapterPosition();
            switch(position) {
                case 0:
                    Intent profileIntent=new Intent(mContext, ProfileActivity.class);
                    mContext.startActivity(profileIntent);
                    break;
                case 1:
                    Intent reviewIntent=new Intent(mContext, ReviewActivity.class);
                    mContext.startActivity(reviewIntent);
                    break;
                case 2:
                    break;
                case 3:
                    Intent bankDetailIntent=new Intent(mContext, BankDetailActivity.class);
                    mContext.startActivity(bankDetailIntent);
                    break;
                case 4:
                    Intent earningsActivity=new Intent(mContext, EarningsActivity.class);
                    mContext.startActivity(earningsActivity);
                    break;
                case 5:
                    Intent supportActivity=new Intent(mContext, SupportActivity.class);
                    mContext.startActivity(supportActivity);
                    break;
                case 6:
                    break;
            }
        }

    }

}
