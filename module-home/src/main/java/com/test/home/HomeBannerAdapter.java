package com.test.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.test.library_base.pojo.BannerRes;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.MZScaleInTransformer;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeBannerAdapter extends DelegateAdapter.Adapter<HomeBannerAdapter.ViewHolder> {

    private List<BannerRes> bannerResList;

    public HomeBannerAdapter(List<BannerRes> bannerResList) {
        this.bannerResList = bannerResList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new SingleLayoutHelper();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_home_banner, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.banner.setIndicator(new CircleIndicator(holder.banner.getContext()));
        holder.banner.setPageTransformer(new MZScaleInTransformer());
        holder.banner.setAdapter(new BannerImageAdapter<BannerRes>(bannerResList) {
            @Override
            public void onBindView(BannerImageHolder holder, BannerRes data, int position, int size) {
                Glide.with(holder.itemView)
                        .load(data.getImagePath())
//                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

   public class ViewHolder extends RecyclerView.ViewHolder {
       Banner banner;
       public ViewHolder(@NonNull @NotNull View itemView) {
           super(itemView);
           banner = itemView.findViewById(R.id.banner);
           banner.setOnBannerListener((data, position) -> {
               BannerRes bannerRes = (BannerRes) data;
           });
       }
////        @BindView(R2.id.banner)
////        Banner banner;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);

//        }
  }
}
