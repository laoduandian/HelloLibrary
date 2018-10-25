package com.example.library.ad;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.example.library.LotusADActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;



public class GoogleAd implements LotusAd,RewardedVideoAdListener {
	private InterstitialAd interstitialAd;
	private RewardedVideoAd mRewardedVideoAd;
	private LotusADActivity activity;
	public GoogleAd(LotusADActivity activity){
		this.activity = activity;
		MobileAds.initialize(activity, this.activity.game.info.app_ad_id);
	}
	@Override
	public void initInterstitialAd() {
		interstitialAd = new InterstitialAd(activity);
		interstitialAd.setAdUnitId(this.activity.game.info.interstitial_ad_id);
		interstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
			}
			@Override
			public void onAdFailedToLoad(int errorCode) {
			}
		});
	}

	@Override
	public void loadInsertscreen() {
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice(this.activity.game.info.interstitial_ad_id).build();
		interstitialAd.loadAd(adRequest);
	}

	@Override
	public void showInsertscreen() {
		if (interstitialAd.isLoaded()) {
			interstitialAd.show();
		}else{
			loadRewardedVideo();
		}
	}

	@Override
	public void initRewardedVideo() {
		mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(activity);
		mRewardedVideoAd.setRewardedVideoAdListener(this);
		loadRewardedVideo();
	}

	@Override
	public void loadRewardedVideo() {
		mRewardedVideoAd.loadAd(this.activity.game.info.rewardedVideo_ad_id,
				new AdRequest.Builder().build());
	}


	@Override
	public void initBannerAd(RelativeLayout bannerRelativeLayout) {
		AdView adView = new AdView(activity);// a152f7167e68810//钢琴a152f8d3eeb4232
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(this.activity.game.info.banner_ad_id);
		LayoutParams adParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		bannerRelativeLayout.addView(adView, adParams);
		adView.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
	}
	@Override
	public void dispose() {
	}

	@Override
	public void onRewardedVideoAdLoaded() {
	}

	@Override
	public void onRewardedVideoAdOpened() {
	}

	@Override
	public void onRewardedVideoStarted() {
	}

	@Override
	public void onRewardedVideoAdClosed() {
		loadRewardedVideo();

	}

	@Override
	public void onRewarded(RewardItem rewardItem) {
	}

	@Override
	public void onRewardedVideoAdLeftApplication() {
	}

	@Override
	public void onRewardedVideoAdFailedToLoad(int i) {
		loadRewardedVideo();
	}

	public void onRewardedVideoCompleted() {
	}
	private int movie_index = 0;
	public void showMovie(int id) {
		movie_index = id;
		if (mRewardedVideoAd.isLoaded()) {
			mRewardedVideoAd.show();
		}
	}
}
