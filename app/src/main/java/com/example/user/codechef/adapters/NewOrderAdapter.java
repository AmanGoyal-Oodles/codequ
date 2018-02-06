package com.example.user.codechef.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.user.codechef.R;
import com.example.user.codechef.activities.OrderInfoActivity;
import com.example.user.codechef.utils.pojoclasses.NewOrderDetail;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 2/1/2018.
 */

public class NewOrderAdapter extends RecyclerView.Adapter<NewOrderAdapter.NewOrderHolder> {


    private Context mContext;
    private ArrayList<NewOrderDetail> mNewOrderDetails;

    public NewOrderAdapter(Context context) {
        mContext=context;
        mNewOrderDetails=new ArrayList<>();
    }

    @Override
    public NewOrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_order_item_layout, parent,false);
        return new NewOrderHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewOrderHolder holder, int position) {
        holder.personNameTv.setText(mNewOrderDetails.get(position).getmPersonName());
        holder.priceTv.setText(mNewOrderDetails.get(position).getmPrice());
        holder.paymentMethodTv.setText(mNewOrderDetails.get(position).getmPaymentMethod());
        holder.orderNumberTv.setText(mNewOrderDetails.get(position).getmOrderNumber());
        holder.orderDateTv.setText(mNewOrderDetails.get(position).getmOrderDate());
        holder.orderStatusFlag=mNewOrderDetails.get(position).getmOrderStatusFlag();
        switch(holder.orderStatusFlag) {
            case 0:
                holder.orderStatusTv.setText("View Order");
                holder.orderStatusTv.setTextColor(mContext.getResources().getColor(R.color.OrangeRed));
                holder.arrowRightIv.setColorFilter(mContext.getResources().getColor(R.color.OrangeRed));
                break;
            case 1:
                holder.orderStatusTv.setText("Accepted");
                holder.orderStatusTv.setTextColor(mContext.getResources().getColor(R.color.Lime));
                holder.arrowRightIv.setColorFilter(mContext.getResources().getColor(R.color.Lime));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mNewOrderDetails.size();
    }

    public void setmNewOrderDetails(ArrayList<NewOrderDetail> newOrderDetails) {
        mNewOrderDetails.clear();
        mNewOrderDetails.addAll(newOrderDetails);
    }

    public class NewOrderHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.new_order_person_name_tv)
        TextView personNameTv;
        @BindView(R.id.new_order_price_tv)
        TextView priceTv;
        @BindView(R.id.new_order_payment_method_tv)
        TextView paymentMethodTv;
        @BindView(R.id.new_order_order_number_tv)
        TextView orderNumberTv;
        @BindView(R.id.new_order_dispatch_date_tv)
        TextView orderDateTv;
        @BindView(R.id.new_order_status_tv)
        TextView orderStatusTv;
        @BindView(R.id.new_order_arrow_right_iv)
        ImageView arrowRightIv;
        @BindView(R.id.new_order_item_layout)
        LinearLayout mItemLayout;
        int orderStatusFlag=0;

        public NewOrderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick({R.id.new_order_item_layout})
        public void onClickItemLayout() {
            Intent intent=new Intent(mContext, OrderInfoActivity.class);
            mContext.startActivity(intent);
        }
    }
}
