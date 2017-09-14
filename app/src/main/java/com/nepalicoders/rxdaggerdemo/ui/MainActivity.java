package com.nepalicoders.rxdaggerdemo.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.nepalicoders.rxdaggerdemo.R;
import com.nepalicoders.rxdaggerdemo.application.FlowerApplication;
import com.nepalicoders.rxdaggerdemo.base.FlowerPresenter;
import com.nepalicoders.rxdaggerdemo.model.FlowerAdapter;
import com.nepalicoders.rxdaggerdemo.model.FlowerResponse;
import com.nepalicoders.rxdaggerdemo.service.FlowerService;
import com.nepalicoders.rxdaggerdemo.service.FlowerViewInterface;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity implements FlowerViewInterface {

    @Inject
    FlowerService mService;

    private FlowerPresenter mPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private FlowerAdapter mAdapter;

    private ProgressDialog mDialog;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUnbinder = ButterKnife.bind(this);

        resolveDependency();

        mPresenter = new FlowerPresenter(MainActivity.this);
        mPresenter.onCreate();

        configView();
    }

    private void resolveDependency() {
        ((FlowerApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    private void configView() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FlowerAdapter(getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchFlowers();
        mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setIndeterminate(true);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setTitle("Downloading List");
        mDialog.setMessage("Please wait...");
        mDialog.show();
    }

    @Override
    protected void onStop() {
        mUnbinder.unbind();
        super.onStop();
    }

    @Override
    public void onFlowers(List<FlowerResponse> flowerResponses) {
        mAdapter.addFlowers(flowerResponses);
    }

    @Override
    public void onError(String message) {
        mDialog.dismiss();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCompleted() {
        mDialog.dismiss();
    }

    @Override
    public Observable<List<FlowerResponse>> getFlowers() {
        return mService.getFlowers();
    }
}
