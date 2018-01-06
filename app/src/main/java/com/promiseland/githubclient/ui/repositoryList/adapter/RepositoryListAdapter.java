package com.promiseland.githubclient.ui.repositoryList.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.promiseland.githubclient.data.model.Repository;

import java.util.List;

/**
 * Created by joseph on 2018/1/6.
 */

public class RepositoryListAdapter extends RecyclerView.Adapter<RepositoryListAdapter.ViewHolder> {
    private List<Repository> mDatas;

    public RepositoryListAdapter(List<Repository> datas) {
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
