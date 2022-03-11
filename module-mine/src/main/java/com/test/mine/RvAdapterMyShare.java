package com.test.mine;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class RvAdapterMyShare extends BaseQuickAdapter<String, BaseViewHolder> {
    public RvAdapterMyShare() {
        super(R.layout.rv_item_my_share);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.text, s);
    }
}
