package com.example.botik.view.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.example.botik.R;
import com.example.botik.databinding.ItemssliderBinding;
import com.example.botik.model.Slider;

import java.util.List;

public class Adapterviewpager extends PagerAdapter {
    List<Slider> slider;
    public Adapterviewpager(List<Slider> slider){
        this.slider=slider;
    }
    @Override
    public int getCount() {
        return slider.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ItemssliderBinding binding= DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), R.layout.itemsslider,container,false);
        binding.setImageurl(slider.get(position).getImage());
        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public float getPageWidth(int position) {
        return 0.95f;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
