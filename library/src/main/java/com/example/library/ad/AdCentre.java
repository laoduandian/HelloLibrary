package com.example.library.ad;


import android.view.View;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RelativeLayout;

import com.example.library.LotusADActivity;


public class AdCentre {
	private LotusADActivity activity;
	private RelativeLayout bannerRelativeLayout;
	private GoogleAd myAd;
	public AdCentre(LotusADActivity activity) {
		this.activity = activity;
		init();
	}
	private void init(){
		bannerRelativeLayout = new RelativeLayout(activity);
		RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		activity.relativeLayout.addView(bannerRelativeLayout,adParams);
		myAd = new GoogleAd(activity);
		initInterstitialAd();
		myAd.initRewardedVideo();
        initBannerAd();
        loadInsertscreen();
	}
	/** 插屏 **/
	private void initInterstitialAd() {
		myAd.initInterstitialAd();
	}
	public void showInsertscreen() {
		myAd.showInsertscreen();
	}
	public void loadInsertscreen(){
		myAd.loadInsertscreen();
    }
    public void initBannerAd() {
    	myAd.initBannerAd(bannerRelativeLayout);
    }
	public void addBanners(){
		bannerRelativeLayout.setVisibility(View.VISIBLE);
	}
	public void removeRanners(){
		bannerRelativeLayout.setVisibility(View.GONE);
	}
	public void dispose() {
		myAd.dispose();
	}
	public void showMovie(int id) {
		myAd.showMovie(id);
	}
}
