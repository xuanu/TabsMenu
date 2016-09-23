package cn.zeffect.views.tabmenu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuan on 2016/9/23.
 *
 * @author zzx
 */

public class RadioAdapter extends FragmentPagerAdapter {
    private List<Fragment> mPagers = new LinkedList<>();

    public RadioAdapter(FragmentManager fm, List<Fragment> pPager) {
        super(fm);
        mPagers = pPager;
    }

    @Override
    public Fragment getItem(int position) {
        return mPagers.get(position);
    }

    @Override
    public int getCount() {
        return mPagers.size();
    }
}
