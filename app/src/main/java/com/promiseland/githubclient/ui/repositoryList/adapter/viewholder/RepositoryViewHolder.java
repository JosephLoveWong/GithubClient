package com.promiseland.githubclient.ui.repositoryList.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.promiseland.githubclient.data.model.Repository;

/**
 * Created by Administrator on 2018/1/11.
 */

public abstract class RepositoryViewHolder extends RecyclerView.ViewHolder {
    public RepositoryViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Repository repository);
}
