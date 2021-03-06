package com.test.home;


import android.text.TextUtils;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.test.library_base.constant.C;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.utils.GlideUtil;
import com.test.library_base.widget.shinebtn.ShineButton;

import org.jetbrains.annotations.NotNull;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * 文章列表
 */
public class RvAdapterArticleList extends BaseMultiItemQuickAdapter<ArticleBean, BaseViewHolder> {

    private boolean hasTop = false;

    public void setHasTop(boolean hasTop) {
        this.hasTop = hasTop;
    }

    public RvAdapterArticleList() {
        super(null);
        addItemType(C.ARTICLE_ITEM_TEXT, R.layout.rv_item_article_text);
        addItemType(C.ARTICLE_ITEM_TEXT_PIC, R.layout.rv_item_article_text_pic);
        addChildClickViewIds(R.id.ivCollect);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ArticleBean articleBean) {
        String superChapterName = articleBean.getSuperChapterName();
        String chapterName = articleBean.getChapterName();
        switch (baseViewHolder.getItemViewType()) {
            case C.ARTICLE_ITEM_TEXT:
                baseViewHolder
                        .setText(R.id.tvChapter,
                                TextUtils.isEmpty(superChapterName) ? chapterName : String.format("%s·%s", superChapterName, chapterName))
                        .setText(R.id.tvTime, articleBean.getNiceDate())
                        .setGone(R.id.tvRefresh, !articleBean.isFresh());
                break;
            case C.ARTICLE_ITEM_TEXT_PIC:
                AppCompatImageView imageView = baseViewHolder.getView(R.id.image);
                GlideUtil.getInstance().loadRoundImage(imageView, articleBean.getEnvelopePic(), 8);
                baseViewHolder.setText(R.id.tvContent, articleBean.getDesc());
                break;
        }
        baseViewHolder.setText(R.id.tvTitle, articleBean.getTitle())
                .setText(R.id.tvAuthor, TextUtils.isEmpty(articleBean.getAuthor()) ? articleBean.getShareUser() : articleBean.getAuthor())
                .setGone(R.id.top, !(hasTop && baseViewHolder.getAdapterPosition() == 0));
        ShineButton shineButton = baseViewHolder.getView(R.id.ivCollect);
        shineButton.setChecked(articleBean.isCollect());

    }

    /**
     * 取消收藏，做单个删除
     */
    public void cancelCollect(int position) {
        getData().remove(position);
        notifyItemRemoved(position);
    }
}
