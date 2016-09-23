package cn.zeffect.views.tabmenu.utils;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.zeffect.views.tabmenu.R;

/**
 * 菜单相关工具类
 * Created by xuan on 2016/9/23.
 *
 * @author zzx
 */

public class MenuUtils {
    public static View innerView(LayoutInflater inflater, ViewGroup container, int mDefaultGravity) {
        View rootView;
        switch (mDefaultGravity) {
            case Gravity.BOTTOM:
                rootView = inflater.inflate(R.layout.tabmenu_bottom, container, false);
                break;
            case Gravity.TOP:
                rootView = inflater.inflate(R.layout.tabmenu_top, container, false);
                break;
            case Gravity.LEFT:
                rootView = inflater.inflate(R.layout.tabmenu_left, container, false);
                break;
            case Gravity.RIGHT:
                rootView = inflater.inflate(R.layout.tabmenu_right, container, false);
                break;
            default:
                rootView = inflater.inflate(R.layout.tabmenu_bottom, container, false);
                break;
        }
        return rootView;
    }
}
