package cn.zeffect.views.tabmenu.config;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.Gravity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import cn.zeffect.views.tabmenu.menu.RadioMenuFragment;
import cn.zeffect.views.tabmenu.utils.MenuConstant;

/**
 * Created by xuan on 2016/9/23.
 *
 * @author zzx
 */

public class RadioConfig implements Serializable {
    @IdRes
    private int mGroupId;
    @LayoutRes
    private int mLayoutRes;
    private List<Fragment> mFragments = new LinkedList<>();
    private int mDefaultGravity = Gravity.BOTTOM;

    public int getGroupId() {
        return mGroupId;
    }

    public int getDefaultGravity() {
        return mDefaultGravity;
    }

    public int getLayoutRes() {
        return mLayoutRes;
    }

    public List<Fragment> getFragments() {
        return mFragments;
    }

    public RadioConfig setTitleLayout(@LayoutRes int pLayoutId, @IdRes int groupId) {
        this.mLayoutRes = pLayoutId;
        this.mGroupId = groupId;
        return this;
    }

    /**
     * 设置显示位置
     *
     * @param mDefaultGravity
     */
    public RadioConfig setDefaultGravity(int mDefaultGravity) {
        this.mDefaultGravity = mDefaultGravity;
        return this;
    }

    /**
     * 设置内容视图
     *
     * @param pFgs
     * @return
     */
    public RadioConfig setContentFragment(List<Fragment> pFgs) {
        if (pFgs != null) {
            this.mFragments = pFgs;
        }
        return this;
    }

    public Fragment Build() {
        Fragment radioFragment = new RadioMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MenuConstant.KEY_KEY, this);
        radioFragment.setArguments(bundle);
        return radioFragment;
    }
}
