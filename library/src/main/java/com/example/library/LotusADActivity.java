package com.example.library;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.example.library.ad.AdCentre;

public class LotusADActivity extends Activity{
    public MyGame game;
    public RelativeLayout relativeLayout;
    private AdCentre adCentre;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new MyGame();
        relativeLayout = new RelativeLayout(this);
        setContentView(relativeLayout);
        adCentre = new AdCentre(this);

    }
}
