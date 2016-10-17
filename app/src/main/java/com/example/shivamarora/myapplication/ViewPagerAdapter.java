package com.example.shivamarora.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

            if (position == 0) {
                return new FragmentSource();
            }
            else if (position == 1) {
                return new FragmentInput();
            }
            else if (position == 2) {
                return new FragmentOutput();
            }

        else
                return  null ;
        }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "SOURCE CODE";
        else if(position == 1)
            return "INPUT " ;
        else if(position == 2)
            return "OUTPUT ";

        else return null ;
    }
}
