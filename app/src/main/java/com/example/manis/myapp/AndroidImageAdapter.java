package com.example.manis.myapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by manis on 24-Jun-17.
 */
public class AndroidImageAdapter extends PagerAdapter {
    Context mContext;

    AndroidImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    private String[] sliderImagesId = new String[]{
           "http://images.all-free-download.com/images/graphiclarge/mississippi_landscape_scenic_214567.jpg",
            "https://s-media-cache-ak0.pinimg.com/originals/57/80/0e/57800e6fd63b49c51c106bc26bbc3933.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/9e/9a/84/9e9a847b036b582a20fb4ae76c444fb3--green-scenery-black-garden.jpg"

    };

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == ((ImageView) obj);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
       // mImageView.setImageResource(sliderImagesId[i]);


        Picasso.with(mContext).load(sliderImagesId[i]).into(mImageView);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }
}