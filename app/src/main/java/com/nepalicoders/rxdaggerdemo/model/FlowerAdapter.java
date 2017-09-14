package com.nepalicoders.rxdaggerdemo.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nepalicoders.rxdaggerdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sulav on 8/28/17.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {

    private final LayoutInflater mInflater;
    private List<FlowerResponse> mFlowerList;

    public FlowerAdapter(LayoutInflater inflater) {
        mInflater = inflater;
        mFlowerList = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mInflater.inflate(R.layout.item_flower, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }

    public void addFlowers(List<FlowerResponse> flowerResponses) {
        mFlowerList.addAll(flowerResponses);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView) {
            super(itemView);
        }

    }

}
