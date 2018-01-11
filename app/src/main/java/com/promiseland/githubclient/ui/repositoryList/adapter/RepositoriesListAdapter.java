package com.promiseland.githubclient.ui.repositoryList.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.promiseland.githubclient.data.model.Repository;
import com.promiseland.githubclient.ui.repositoryList.RepositoriesListContract;
import com.promiseland.githubclient.ui.repositoryList.adapter.viewholder.RepositoriesListViewHolderFactory;
import com.promiseland.githubclient.ui.repositoryList.adapter.viewholder.RepositoryViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by joseph on 2018/1/6.
 */

public class RepositoriesListAdapter extends RecyclerView.Adapter{
    private RepositoriesListContract.View mActivity;
    private Map<Integer, RepositoriesListViewHolderFactory> mViewHolderFactories;

    private List<Repository> mRepositories = new ArrayList<>();

    public RepositoriesListAdapter(RepositoriesListContract.View activity, Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        mActivity = activity;
        mViewHolderFactories = viewHolderFactories;
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = mViewHolderFactories.get(viewType).createViewHolder(parent);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRepositoryItemClicked(viewHolder.getAdapterPosition());
            }
        });
        return (RepositoryViewHolder) viewHolder;
    }

    private void onRepositoryItemClicked(int adapterPosition) {
        mActivity.onRepositoryClick(mRepositories.get(adapterPosition));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RepositoryViewHolder)holder).bind(mRepositories.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        Repository repository = mRepositories.get(position);
        if (repository.stargazers_count > 500) {
            if (repository.forks_count > 100) {
                return Repository.TYPE_FEATURED;
            }
            return Repository.TYPE_BIG;
        }
        return Repository.TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }

    public void updateRepositoriesList(List<Repository> repositories) {
        mRepositories.clear();
        mRepositories.addAll(repositories);
        notifyDataSetChanged();
    }
}
