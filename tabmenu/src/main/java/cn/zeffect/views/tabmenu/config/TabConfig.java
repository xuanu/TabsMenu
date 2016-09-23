package cn.zeffect.views.tabmenu.config;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.Gravity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import cn.zeffect.views.tabmenu.menu.TabMenuFragment;
import cn.zeffect.views.tabmenu.utils.MenuConstant;

/**
 * TabLayout的属性
 * Created by xuan on 2016/9/23.
 *
 * @author zzx
 */

public class TabConfig implements Serializable {
    private List<String> mTexts = new LinkedList<>();

    public List<String> getTexts() {
        return mTexts;
    }

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

    public TabConfig setTitleLayout(@LayoutRes int pLayoutId, @IdRes int groupId) {
        this.mLayoutRes = pLayoutId;
        this.mGroupId = groupId;
        return this;
    }

    /**
     * 设置显示位置
     *
     * @param mDefaultGravity
     */
    public TabConfig setDefaultGravity(int mDefaultGravity) {
        this.mDefaultGravity = mDefaultGravity;
        return this;
    }

    /**
     * 设置内容视图
     *
     * @param pFgs
     * @return
     */
    public TabConfig setContentFragment(List<Fragment> pFgs) {
        if (pFgs != null) {
            this.mFragments = pFgs;
        }
        return this;
    }

    /**
     * 设置标题栏文字数据
     *
     * @param pTexts
     * @return
     */
    public TabConfig setTitleTexts(List<String> pTexts) {
        if (pTexts != null) {
            this.mTexts = pTexts;
        }
        return this;
    }

    public Fragment Build() {
        Fragment tabFragment = new TabMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MenuConstant.KEY_KEY, this);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }
}
