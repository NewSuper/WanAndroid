package com.test.library_widget.viewpager;

public interface LiquidSwipeLayout {
    public ClipPathProvider clipPathProvider();

    public Float currentRevealPercent();

    public void revealForPercentage(Float percent);
}

