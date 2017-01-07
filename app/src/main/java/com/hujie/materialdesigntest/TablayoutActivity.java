package com.hujie.materialdesigntest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class TablayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        TabLayout tabLayout= (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager= (ViewPager) findViewById(R.id.view_pager);
        ArrayList<Fragment> fragments=new ArrayList<>();
        for (int i=0;i<6;i++){
            fragments.add(new RecyclerFragment());
        }

        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        private ArrayList<Fragment> data;

        public MyPagerAdapter(FragmentManager fm,ArrayList<Fragment> data) {
            super(fm);
            this.data=data;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return data.get(position);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "第"+position+"页";
        }
    }
}
