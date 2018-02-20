package com.johnnyhanly.muteplanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Johnny Hanly on 2/14/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int tabs;
    public PagerAdapter(FragmentManager fragmentManager, int tabs){
        super(fragmentManager);
        this.tabs= tabs;

    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                ScheduleFragment tab1= new ScheduleFragment();
                return tab1;
            case 1:
                LocationFragment tab2= new LocationFragment();
                return tab2;
            default:
                return null;
        }
    }



    @Override
    public int getCount(){
        return tabs;
    }
}
