package cn.zeffect.views.tabmenu.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.zeffect.views.tabmenu.R;
import cn.zeffect.views.tabmenu.adapter.RadioAdapter;
import cn.zeffect.views.tabmenu.config.RadioConfig;
import cn.zeffect.views.tabmenu.utils.MenuConstant;
import cn.zeffect.views.tabmenu.utils.MenuUtils;

/**
 * Created by xuan on 2016/9/23.
 *
 * @author zzx
 */

public class RadioMenuFragment extends Fragment {
    private RadioConfig mConfig;
    private View rootView;
    private LinearLayout mViewStub;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mConfig = (RadioConfig) getArguments().getSerializable(MenuConstant.KEY_KEY);
        checkConfig(mConfig);
    }

    private void checkConfig(RadioConfig pConfig) {
        if (pConfig == null) {
            throw new NullPointerException("config id null");
        }
        if (pConfig.getLayoutRes() == 0) {
            throw new NullPointerException("layout id null");
        }
        if (pConfig.getGroupId() == 0) {
            throw new NullPointerException("groupid id null");
        }
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

    private void initView() {
        mViewStub = (LinearLayout) rootView.findViewById(R.id.tabmenu_vs);
        mViewStub.addView(LayoutInflater.from(getContext()).inflate(mConfig.getLayoutRes(), null));
        mViewPager = (ViewPager) rootView.findViewById(R.id.tabmenu_pager);
        View tempView = rootView.findViewById(mConfig.getGroupId());
        if (!(tempView instanceof RadioGroup)) {
            throw new ClassCastException("not RadioGroup");
        }
        mRadioGroup = (RadioGroup) tempView;
        if (mRadioGroup.getChildCount() != mConfig.getFragments().size()) {
            throw new RuntimeException("goup child count != fragments.size()");
        }
        RadioAdapter adapter = new RadioAdapter(getFragmentManager(), mConfig.getFragments());
        mViewPager.setAdapter(adapter);
        setOnClickListener(mRadioGroup);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                View tempView = mRadioGroup.getChildAt(position);
                if (tempView instanceof RadioButton) {
                    ((RadioButton) tempView).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 设置监听事件，并且默认选择第一个
     *
     * @param pGroup
     */
    private void setOnClickListener(RadioGroup pGroup) {
        int count = pGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            final int postion = i;
            View tempView = pGroup.getChildAt(postion);
            if (tempView instanceof RadioButton) {
                ((RadioButton) tempView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            mViewPager.setCurrentItem(postion);
                        }
                    }
                });
            }
        }
        View firstView = pGroup.getChildAt(0);
        if (firstView instanceof RadioButton) {
            ((RadioButton) firstView).setChecked(true);
        }
    }

}
