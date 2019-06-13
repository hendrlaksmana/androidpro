package com.example.sumbermakmur;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence[] Titles; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence[] mTitles, int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0)
        {
            home_fragment tab1 = new home_fragment();
            return tab1;
        }
        else if(position == 1)
        {
            katalog tab2 = new katalog();
            return tab2;
        }
         else if(position == 2)
        {
            Artikel tab3 = new Artikel();
            return tab3;
        }
          else if(position == 3)
        {
            cara_pembayaran tab4 = new cara_pembayaran();
            return tab4;
        }
           else if(position == 4)
        {
            TentangToko tab5 = new TentangToko();
            return tab5;
        }
           else
        {
            Akun tab6 = new Akun();
            return tab6;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}