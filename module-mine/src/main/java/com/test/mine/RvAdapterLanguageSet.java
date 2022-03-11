package com.test.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.library_base.base.BaseRecycleAdapter;
import com.test.library_base.base.OnItemClickListener;

import java.util.List;

public class RvAdapterLanguageSet extends BaseRecycleAdapter<LanguageBean> {

    public RvAdapterLanguageSet(List<LanguageBean> datas) {
        super(datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rv_item_language_set;
    }

    @Override
    protected void bindData(BaseViewHolder holder, LanguageBean languageBean, int position) {
        TextView textView = holder.getView(R.id.text);
        ImageView imageView = holder.getView(R.id.image);
        textView.setText(languageBean.getDesc());
        imageView.setVisibility(languageBean.isPress()? View.VISIBLE:View.INVISIBLE);
        holder.itemView.setOnClickListener(view -> {
            if (listener!=null){
                listener.onItemClick(position);
            }
        });
    }

    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
