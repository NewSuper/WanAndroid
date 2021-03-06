package com.test.square;

import android.view.MotionEvent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.test.library_base.R2;
import com.test.library_base.base.BaseFg;
import com.test.library_base.constant.RouterFragmentPath;
import com.test.library_widget.viewpager.LiquidSwipeViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.Arrays;

import androidx.fragment.app.Fragment;
import butterknife.BindView;

@Route(path = RouterFragmentPath.Square.PAGER_SQUARE)
public class SquareFg extends BaseFg implements TabPagerListener {

    @BindView(R2.id.magicIndicator)
    MagicIndicator magicIndicator;
    @BindView(R2.id.viewPager)
    LiquidSwipeViewPager viewPager;


    @Override
    protected int getLayoutId() {
        return R.layout.fg_square;
    }

    @Override
    protected boolean immersionBar() {
        return true;
    }

    @Override
    protected void initViews() {
        super.initViews();
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        String[] stringArray = getResources().getStringArray(R.array.square_title);
        TabNavigatorAdapter tabNavigatorAdapter = new TabNavigatorAdapter(Arrays.asList(stringArray));
        tabNavigatorAdapter.setOnTabClickListener((view, index) -> viewPager.setCurrentItem(index));
        commonNavigator.setAdapter(tabNavigatorAdapter);
        magicIndicator.setNavigator(commonNavigator);
        VpAdapterSquare vpAdapterSquare = new VpAdapterSquare(getChildFragmentManager(), 2);
        vpAdapterSquare.setListener(this);
        viewPager.setOffscreenPageLimit(stringArray.length);
        viewPager.setAdapter(vpAdapterSquare);
        ViewPagerHelper.bind(magicIndicator, viewPager);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    @Override
    public Fragment getFragment(int position) {
        if (position == 0) {
            return (Fragment) ARouter.getInstance().build(RouterFragmentPath.Square.PAGER_SYSTEM).navigation();
        } else if (position == 1) {
            return (Fragment) ARouter.getInstance().build(RouterFragmentPath.Square.PAGER_NAVIGATION).navigation();
        }
        return null;
    }
}
