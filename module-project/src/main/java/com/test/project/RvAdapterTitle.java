package com.test.project;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.test.library_base.pojo.ProjectListRes;

import org.jetbrains.annotations.NotNull;

public class RvAdapterTitle extends BaseQuickAdapter<ProjectListRes, BaseViewHolder> {


    public RvAdapterTitle() {
        super(R.layout.rv_item_title);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ProjectListRes projectListRes) {
        baseViewHolder.setText(R.id.text, projectListRes.getName());
    }
}
