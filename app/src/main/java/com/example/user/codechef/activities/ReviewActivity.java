package com.example.user.codechef.activities;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.user.codechef.R;
import com.example.user.codechef.adapters.ReviewAdapter;
import com.example.user.codechef.utils.pojoclasses.ReviewDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReviewActivity extends AppCompatActivity {


    @BindView(R.id.review_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.review_back_iv)
    ImageView mbackIv;
    private Context mContext;
    private ReviewAdapter mReviewAdapter;
    private ArrayList<ReviewDetail> mReviewDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.Lime));
        }
        init();
    }

    private void init() {
        initVariables();
        setReviewDetailList();
        setRecyclerViewAdapter();
    }

    private void setReviewDetailList() {
        String reviewText="Awesome food taste as well as quick delivery  services. Really appreaciate the packing and quality of food delivered by Global fusion China gate restro. Go for it!!";
        mReviewDetailList.add(new ReviewDetail("Joseph Kelly","Street 45",4.2,reviewText,"5 April, 17" ));
        mReviewDetailList.add(new ReviewDetail("Menon Jeryy","Zyan Road",2.0,reviewText,"17 Feb, 17" ));
        mReviewDetailList.add(new ReviewDetail("Rutvik Desai","George Street",4.2,reviewText,"5 April, 17" ));
    }

    private void setRecyclerViewAdapter() {
        mReviewAdapter=new ReviewAdapter(mContext);
        mReviewAdapter.setReviewDetailList(mReviewDetailList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mReviewAdapter);
    }

    private void initVariables() {
        mContext=getApplicationContext();
        mReviewDetailList=new ArrayList<>();
    }

    @OnClick({R.id.review_back_iv})
    public void onClickBackIv() {
        onBackPressed();
    }

}
