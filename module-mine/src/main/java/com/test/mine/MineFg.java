package com.test.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.library_base.base.BaseMvvmFg;
import com.test.library_base.constant.RouterFragmentPath;
import com.test.library_base.pojo.UserInfo;
import com.test.library_base.utils.MMkvHelper;
import com.test.mine.databinding.FgMineBinding;

import androidx.annotation.Nullable;

@Route(path = RouterFragmentPath.Mine.PAGER_MINE)
public class MineFg extends BaseMvvmFg<FgMineBinding, MineViewModel> {

    @Override
    protected void initViews() {
        super.initViews();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) binding.llHead.getLayoutParams();
        binding.waveView.setOnWaveAnimationListener(y -> {
            layoutParams.setMargins(0, (int) y, 0, 0);
            binding.llHead.setLayoutParams(layoutParams);
        });
        viewModel.register(requireActivity());
        viewModel.userInfoLiveData.observe(this, userInfo -> {
            binding.tvLevel.setVisibility(View.VISIBLE);
            binding.tvId.setText(String.format("ID: %s", userInfo.getUserId()));
            binding.tvLevel.setText(String.format("lv.%d", userInfo.getLevel()));
            binding.tvMyScore.setText(String.format(getString(R.string.mine_current_score) + ": %s", userInfo.getCoinCount()));
            if (userInfo != null) {
                userInfo.setUsername(userInfo.getUsername());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        UserInfo userInfo = MMkvHelper.getInstance().getUserInfo();
        if (userInfo != null) {
            binding.tvName.setText(userInfo.getUsername());
            viewModel.getScore();
        } else {
            binding.tvId.setText("");
            binding.tvMyScore.setText("");
            binding.tvName.setText(R.string.unlogin);
            binding.tvLevel.setVisibility(View.GONE);
        }
    }

    @Override
    protected int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fg_mine;
    }

    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }
}
