package com.lauwba.namabinatang;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class Play extends AppCompatActivity {
    ViewPager viewPager;
    MediaPlayer mp;
    private Integer [] suara = {R.raw.suara_gajah,R.raw.suara_simpanse,R.raw.suara_singa};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp= MediaPlayer.create(Play.this,suara[position]);
                mp.start();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
