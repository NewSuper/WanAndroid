package com.test.offcial;

import android.widget.ImageView;
import android.widget.TextView;

import com.test.library_base.base.BaseRecycleAdapter;
import com.test.library_base.base.OnItemClickListener;
import com.test.library_base.pojo.PublicAuthorListRes;
import com.test.library_widget.hivelayoutmanager.HiveDrawable;
import com.test.library_widget.hivelayoutmanager.HiveLayoutManager;

import java.util.List;

import androidx.core.content.ContextCompat;

public class AuthorAdapter extends BaseRecycleAdapter<PublicAuthorListRes> {

    public AuthorAdapter(List<PublicAuthorListRes> datas) {
        super(datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rv_item_author;
    }

    @Override
    protected void bindData(BaseViewHolder holder, PublicAuthorListRes bean, int position) {
        TextView textView = holder.getView(R.id.text);
        ImageView image = holder.getView(R.id.image);
        textView.setText(bean.getName());
        HiveDrawable hiveDrawable = new HiveDrawable(HiveLayoutManager.VERTICAL, ContextCompat.getColor(getContext(),R.color.main_text));
        image.setImageDrawable(hiveDrawable);
        image.setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
