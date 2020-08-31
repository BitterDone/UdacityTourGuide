package com.example.danielbitter.udacitytourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by danielbitter on 12/13/16.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[];
    private Context context;
    private GoogleApiClient mGoogleApiClient;

    public MyPagerAdapter(FragmentManager fm, Context c, GoogleApiClient mgac) {
        super(fm);
        this.context = c;
        this.mGoogleApiClient = mgac;

        tabTitles = new String[6];
        tabTitles[0] = context.getString(R.string.category_one);
        tabTitles[1] = context.getString(R.string.category_two);
        tabTitles[2] = context.getString(R.string.category_three);
        tabTitles[3] = context.getString(R.string.category_four);
        tabTitles[4] = context.getString(R.string.category_five);
        tabTitles[5] = context.getString(R.string.category_six);
    }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 1:
                    FragmentCatTwo two = new FragmentCatTwo();
                    two.setGoogleApiClient(mGoogleApiClient);
                    return two;
                case 2:
                    FragmentCatThree three = new FragmentCatThree();
                    three.setGoogleApiClient(mGoogleApiClient);
                    return three;
                case 3:
                    FragmentCatFour four = new FragmentCatFour();
                    four.setGoogleApiClient(mGoogleApiClient);
                    return four;
                case 4:
                    FragmentCatFive five = new FragmentCatFive();
                    five.setGoogleApiClient(mGoogleApiClient);
                    return five;
                case 5:
                    FragmentCatSix six = new FragmentCatSix();
                    six.setGoogleApiClient(mGoogleApiClient);
                    return six;
                case 0:
                default:
                    FragmentCatOne one = new FragmentCatOne();
                    one.setGoogleApiClient(mGoogleApiClient);
                    return one;
            }
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
