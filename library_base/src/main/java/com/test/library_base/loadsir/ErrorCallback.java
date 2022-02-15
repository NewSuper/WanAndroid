package com.test.library_base.loadsir;

import com.test.library_base.R;
import com.kingja.loadsir.callback.Callback;
public class ErrorCallback extends Callback {

    @Override
    protected int onCreateView()
    {
        return R.layout.base_layout_error;
    }
}
