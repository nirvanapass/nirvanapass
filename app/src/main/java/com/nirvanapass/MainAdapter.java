package com.nirvanapass;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nirvanapass.mainactivity.PasswordFragment;

public class MainAdapter extends FragmentPagerAdapter {

    private static final int NUM_TABS = 5;

    public MainAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PasswordFragment.newInstance();
            default:
                return null;
        }
    }
}
