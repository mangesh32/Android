package com.task1;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    int tabs;

    public ViewPagerAdapter (android.support.v4.app.FragmentManager fm,int tabCount){

        super(fm);
        this.tabs=tabCount;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new tab1();
            case 1: return new tab2();
            case 2:return new tab3();
            default: return  null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "TAB1";
            case 1: return "TAB2";
            case 2: return "TAB3";
            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return this.tabs;
    }
}
