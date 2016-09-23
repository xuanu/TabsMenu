package cn.zeffect.views.tabmenu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * tablayout的适配器
 * Created by xuan on 2016/9/23.
 *
 * @author zzx
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<String> mTitles = new LinkedList<>();
    private List<Fragment> mPagers = new LinkedList<>();

    public TabAdapter(FragmentManager fm, List<String> pTitle, List<Fragment> pPager) {
        super(fm);
        mTitles = pTitle;
        mPagers = pPager;
    }

    @Override
    public Fragment getItem(int position) {
        return mPagers.get(position) ;
    }

    @Override
    public int getCount() {
        return mPagers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
