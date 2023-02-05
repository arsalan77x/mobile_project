package com.example.rebook;


import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageAdapter extends FragmentPagerAdapter {

    public pageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public static boolean isChecked = false;
    public static int counter = 0;

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

            return new ReaderFragment();
        } else if (!isChecked)  {
            isChecked = true;
            return new NextReaderFragment();
        } else {
            isChecked = false;
            return new ReaderFragment();
        }
    }

    @Override
    public int getCount() {
        return ReaderActivity.pageCounter;
    }
}