package com.test.library_widget.viewpager;

import android.graphics.Path;
import android.graphics.Region;
import android.view.View;

public abstract class ClipPathProvider {
    protected Path path = new Path();
    Region.Op op = Region.Op.INTERSECT;

    abstract Path getPath(Float percent, View view);
}
