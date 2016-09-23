package cn.zeffect.views.tabmenu;

import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.LinkedList;
import java.util.List;

import cn.zeffect.views.tabmenu.config.RadioConfig;
import cn.zeffect.views.tabmenu.config.TabConfig;

/**
 * Created by xuan on 2016/9/22.
 *
 * @author zzx
 */

public class TabMenu {
    public TabConfig creadTabMenu() {
        return new TabConfig();
    }

    public RadioConfig creadRadioMenu() {
        return new RadioConfig();
    }
}
