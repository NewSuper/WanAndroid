package com.test.web;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.test.library_base.base.EventHandlers;
import com.test.library_base.constant.RouterActivityPath;
import com.test.library_network.LogUtil;
import com.test.web.databinding.AcWebBinding;

@Route(path = RouterActivityPath.Web.PAGER_WEB)
public class WebAc extends BaseMvvmAc<AcWebBinding, WebViewModel> {

    private String webUrl;

    @Override
    public void initViews() {
        super.initViews();
        binding.setEventHandlers(new WebEvent());
        setRightImg(R.mipmap.ic_more_menu);
        webUrl = getIntent().getStringExtra("webUrl");
        LogUtil.show("webUrl=" + webUrl);

        AgentWeb.with(this)
                .setAgentWebParent(binding.parent, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setWebLayout(new WebLayout(this))
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl() //拦截找不到相关页面的Scheme
                .createAgentWeb()
                .ready()
                .go(getUrl());
    }

    private String getUrl() {
        return webUrl;
    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
            Log.i("Info", "BaseWebActivity onPageStarted");
        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setAcTitle(title);
        }
    };

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.ac_web;
    }

    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }

    public class WebEvent extends EventHandlers {
        public void onRightClick(){
            WebDialogFg.newInstance(webUrl).show(getSupportFragmentManager(), "webDialog");
        }
    }
}
