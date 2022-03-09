package com.test.square;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.flexbox.FlexboxLayout;
import com.test.library_base.base.BaseMvvmFg;
import com.test.library_base.constant.RouterFragmentPath;
import com.test.library_base.pojo.ArticleBean;
import com.test.library_base.pojo.TreeListRes;
import com.test.library_base.utils.ResourceUtil;
import com.test.library_base.utils.RouterUtil;
import com.test.square.databinding.FgBaseSquareBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.AppCompatTextView;

@Route(path = RouterFragmentPath.Square.PAGER_NAVIGATION)
public class NavigationFg extends BaseMvvmFg<FgBaseSquareBinding, SquareViewModel> {

    private LayoutInflater layoutInflater = null;

    List<Integer> colorList = new ArrayList<>();

    @Override
    protected void initViews() {
        super.initViews();
        initColors();
        binding.indicatorScrollView.bindIndicatorView(binding.indicatorView);
        showLoading(binding.indicatorScrollView);
        viewModel.navisLiveData.observe(this, treeListRes -> {
            if (treeListRes != null) {
                setData(treeListRes, false);
            }
            showSuccess();
        });
        viewModel.listNavis();
    }

    private void initColors() {
        for (int i = 0; i < 19; i++) {
            int resId = ResourceUtil.getResId("in" + (i + 1), R.color.class);
            colorList.add(resId);
        }
    }

    protected void setData(List<TreeListRes> data, boolean system) {
        binding.indicatorView.removeAllViews();
        binding.llParent.removeAllViews();
        for (int i = 0; i < data.size(); i++) {
            TreeListRes res = data.get(i);
            String name = res.getName();
            String firstName = TextUtils.isEmpty(name) ? "" : name.substring(0, 1);
            View view = findItem();
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            tvTitle.setText(name);
            FlexboxLayout flexboxLayout = view.findViewById(R.id.flexLayout);
            if (system) {
                List<TreeListRes.ChildrenBean> children = res.getChildren();
                for (TreeListRes.ChildrenBean child : children) {
                    AppCompatTextView textView = findLabel(flexboxLayout);
                    textView.setText(child.getName());
                    textView.setOnClickListener(v -> {
                        RouterUtil.launchArticleList(child.getId(), child.getName());
                    });
                    flexboxLayout.addView(textView);
                }
            } else {
                List<ArticleBean> articles = res.getArticles();
                for (ArticleBean article : articles) {
                    AppCompatTextView textView = findLabel(flexboxLayout);
                    textView.setText(article.getTitle());
                    textView.setOnClickListener(v -> {
                        RouterUtil.launchWeb(article.getLink());
                    });
                    flexboxLayout.addView(textView);
                }

            }
            binding.llParent.addView(view);
            int i1 = i % colorList.size();
            binding.indicatorView.addIndicatorItem(new IndicatorItem.Builder(view).setItemText(firstName).setItemColorResource(colorList.get(i1)).setItemIconResource(R.mipmap.ic_uncollect).build());
        }
    }

    private View findItem() {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(getContext());
        return (View) layoutInflater.inflate(R.layout.rv_item_flex, null, false);
    }

    private AppCompatTextView findLabel(FlexboxLayout flexboxLayout) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(flexboxLayout.getContext());
        return (AppCompatTextView) layoutInflater.inflate(R.layout.flextlayout_item_label, flexboxLayout, false);
    }

    @Override
    protected int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fg_base_square;
    }

    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }
}
