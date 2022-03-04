package com.test.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.test.library_db.SearchHistoryEntity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class RvAdapterSearchHis extends DelegateAdapter.Adapter<BaseViewHolder> {

    private List<SearchHistoryEntity> dataList;

    public RvAdapterSearchHis() {
        this.dataList = new ArrayList<>();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_search_his, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        TextView tvTitle = holder.getView(R.id.tvTitle);
        ImageView ivCha = holder.getView(R.id.ivCha);
        holder.itemView.setOnClickListener(view -> {
            if (onSearchHisCallBack!=null){
                onSearchHisCallBack.onItemClick(dataList.get(position).getName());
            }
        });
        ivCha.setOnClickListener(view -> {
            if (onSearchHisCallBack!=null){
                onSearchHisCallBack.onItemDelete(dataList.get(position).getId());
            }
            dataList.remove(position);
            notifyItemRemoved(position);
        });
        tvTitle.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void refresh(List<SearchHistoryEntity> list){
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }
    public void clear(){
        dataList.clear();
        notifyDataSetChanged();
    }


    private OnSearchHisCallBack onSearchHisCallBack;

    public void setOnSearchHisCallBack(OnSearchHisCallBack onSearchHisCallBack) {
        this.onSearchHisCallBack = onSearchHisCallBack;
    }

    public interface OnSearchHisCallBack {
        void onItemClick(String searchContent);

        void onItemDelete(long id);
    }
}

