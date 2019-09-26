package com.lauwba.namabinatang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private String [] judul={"Gajah","Monyet","Singa"};
    private String [] ket={"ini Gajah","ini Monyet","ini Singa"};
    private Integer [] images = {R.drawable.gajah,R.drawable.monyet,R.drawable.singa};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_view_pager, null);
        ImageView imageView = view.findViewById(R.id.imgBinatang);
        imageView.setImageResource(images[position]);
        TextView tv_judul=view.findViewById(R.id.tv_judul);
        TextView tv_ket=view.findViewById(R.id.tv_keterangan);
        tv_judul.setText(judul[position]);
        tv_ket.setText(ket[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
