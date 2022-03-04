package com.test.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import androidx.annotation.NonNull;

public class RvAdapterSearchClear extends DelegateAdapter.Adapter<BaseViewHolder> {

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new SingleLayoutHelper();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_search_clear, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        TextView tvClear= holder.itemView.findViewById(R.id.tvClear);
        tvClear.setOnClickListener(view -> {
            if (onSearchClearCallBack != null) {
                onSearchClearCallBack.onClear();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private OnSearchClearCallBack onSearchClearCallBack;

    public void setOnSearchClearCallBack(OnSearchClearCallBack onSearchClearCallBack) {
        this.onSearchClearCallBack = onSearchClearCallBack;
    }

    public interface OnSearchClearCallBack {
        void onClear();
    }
}
