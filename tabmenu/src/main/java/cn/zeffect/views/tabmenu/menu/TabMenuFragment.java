package cn.zeffect.views.tabmenu.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import cn.zeffect.views.tabmenu.R;
import cn.zeffect.views.tabmenu.adapter.TabAdapter;
import cn.zeffect.views.tabmenu.config.TabConfig;
import cn.zeffect.views.tabmenu.utils.MenuConstant;
import cn.zeffect.views.tabmenu.utils.MenuUtils;

/**
 * Created by xuan on 2016/9/23.
 *
 * @author zzx
 */

public class TabMenuFragment extends Fragment {
    private TabConfig mConfig;
    private View rootView;
    private LinearLayout mViewStub;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mConfig = (TabConfig) getArguments().getSerializable(MenuConstant.KEY_KEY);
        checkConfig(mConfig);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = MenuUtils.innerView(inflater, container, mConfig.getDefaultGravity());
        }
        initView();
        return rootView;
    }

    /**
     * 检验设置，必须项不能为空
     *
     * @param pConfig
     */
    private void checkConfig(TabConfig pConfig) {
        if (pConfig == null) {
            throw new NullPointerException("config id null");
        }
        if (pConfig.getLayoutRes() == 0) {
            throw new NullPointerException("layout id null");
        }
        if (pConfig.getGroupId() == 0) {
            throw new NullPointerException("groupid id null");
        }
        if (pConfig.getFragments().size() != pConfig.getTexts().size()) {
            throw new NullPointerException("title.size()!= content.size()");
        }
    }

    private void initView() {
        mViewStub = (LinearLayout) rootView.findViewById(R.id.tabmenu_vs);
        mViewStub.addView(LayoutInflater.from(getContext()).inflate(mConfig.getLayoutRes(), null));
        mViewPager = (ViewPager) rootView.findViewById(R.id.tabmenu_pager);
        TabAdapter adapter = new TabAdapter(getFragmentManager(), mConfig.getTexts(), mConfig.getFragments());
        mViewPager.setAdapter(adapter);
        View tempView = rootView.findViewById(mConfig.getGroupId());
        if (!(tempView instanceof TabLayout)) {
            throw new ClassCastException("not tablayou");
        }
        mTabLayout = (TabLayout) tempView;
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
