package com.test.offcial;


import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.test.library_base.R2;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.utils.RouterUtil;
import com.test.library_base.widget.shinebtn.ShineButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PublicArticleAdapter extends DelegateAdapter.Adapter<PublicArticleAdapter.ViewHolder> {

    private List<ArticleBean> articleListResList;

    private boolean hasTop = false;

    public void setHasTop(boolean hasTop) {
        this.hasTop = hasTop;
    }

    public PublicArticleAdapter(List<ArticleBean> articleListResList) {
        this.articleListResList = articleListResList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_public_article, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticleBean datasBean = articleListResList.get(position);
        holder.tvContent.setText(datasBean.getTitle());
        holder.tvAuthor.setText(TextUtils.isEmpty(datasBean.getAuthor()) ? datasBean.getShareUser() : datasBean.getAuthor());
        holder.tvChapter.setText(String.format("%s·%s", datasBean.getSuperChapterName(), datasBean.getChapterName()));
        holder.tvTime.setText(datasBean.getNiceDate());
        holder.tvRefresh.setVisibility(datasBean.isFresh() ? View.VISIBLE : View.GONE);
        holder.shineButton.setChecked(datasBean.isCollect());

        if (position == 0 && hasTop) {
            holder.top.setVisibility(View.VISIBLE);
        } else {
            holder.top.setVisibility(View.GONE);
        }

        holder.vItem.setOnClickListener(view -> {
            RouterUtil.launchWeb(articleListResList.get(position).getLink());
        });

        holder.shineButton.setOnClickListener(view -> {
            if (onArticleCollect != null) {
                onArticleCollect.onCollect(datasBean);
            }
            datasBean.setCollect(!datasBean.isCollect());
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return articleListResList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.tvChapter)
        TextView tvChapter;
        @BindView(R2.id.tvTime)
        TextView tvTime;
        @BindView(R2.id.tvContent)
        TextView tvContent;
        @BindView(R2.id.tvAuthor)
        TextView tvAuthor;
        @BindView(R2.id.tvRefresh)
        TextView tvRefresh;
        @BindView(R2.id.top)
        View top;
        @BindView(R2.id.ivCollect)
        ShineButton shineButton;

        @BindView(R2.id.vItem)
        View vItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    private OnArticleCollect onArticleCollect;

    public void setOnArticleCollect(OnArticleCollect onArticleCollect) {
        this.onArticleCollect = onArticleCollect;
    }

    public interface OnArticleCollect {
        void onCollect(ArticleBean articleBean);
    }
}
