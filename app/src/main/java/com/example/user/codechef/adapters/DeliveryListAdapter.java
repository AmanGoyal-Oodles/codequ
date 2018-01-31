package com.example.user.codechef.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.user.codechef.R;
import com.example.user.codechef.utils.pojoclasses.DeliveryDetail;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 1/30/2018.
 */

public class DeliveryListAdapter extends RecyclerView.Adapter<DeliveryListAdapter.DeliveryListHolder> {


    private Context mContext;
    private ArrayList<DeliveryDetail> mDetailDetailList;

    public DeliveryListAdapter(Context context) {
        mContext=context;
        mDetailDetailList=new ArrayList<>();
    }

    @Override
    public DeliveryListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_item_layout,parent,false);
        return new DeliveryListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DeliveryListHolder holder, int position) {
        holder.personName.setText(mDetailDetailList.get(position).getmPersonName());
        holder.paymentMethodTv.setText(mDetailDetailList.get(position).getmPaymentMethod());
        holder.orderNumberTv.setText(mDetailDetailList.get(position).getmOrderNumber());
        holder.dispatchDateTv.setText(mDetailDetailList.get(position).getmDispatchDate());
        int flag=mDetailDetailList.get(position).getFlag();
        switch(flag) {
            case 0:
                holder.deliveryStatusTv.setText("Ready to dispatch");
                holder.deliveryStatusTv.setTextColor(mContext.getResources().getColor(R.color.Blue));
                break;
            case 1:
                holder.deliveryStatusTv.setText("On the way");
                holder.deliveryStatusTv.setTextColor(mContext.getResources().getColor(R.color.OrangeRed));
                break;
            case 2:
                holder.deliveryStatusTv.setText("Delivered");
                holder.deliveryStatusTv.setTextColor(mContext.getResources().getColor(R.color.Lime));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDetailDetailList.size();
    }

    public void setDeliveryList(ArrayList<DeliveryDetail> deliveryDetail) {
        mDetailDetailList.clear();
        mDetailDetailList.addAll(deliveryDetail);
    }

    public class DeliveryListHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.delivery_person_name_tv)
        TextView personName;
        @BindView(R.id.payment_method_tv)
        TextView paymentMethodTv;
        @BindView(R.id.order_number_tv)
        TextView orderNumberTv;
        @BindView(R.id.dispatch_date_tv)
        TextView dispatchDateTv;
        @BindView(R.id.delivery_status_tv)
        TextView deliveryStatusTv;

        public DeliveryListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
