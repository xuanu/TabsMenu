package cn.zeffect.views.tabsmenu;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.RadioButton;

import java.util.LinkedList;
import java.util.List;

import cn.zeffect.views.tabmenu.TabMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBottom();
        setLeft();
        setTop();
        setRight();
    }

    private void setLeft() {
        List<Fragment> content = new LinkedList<>();
        content.add(new TestFragment());
        content.add(new TestFragment());
        content.add(new TestFragment());
        content.add(new TestFragment());
        content.add(new TestFragment());
        Fragment radioFragment = new TabMenu().creadRadioMenu().setTitleLayout(R.layout.layout_title_radio, R.id.ltr_gb).setContentFragment(content).setDefaultGravity(Gravity.LEFT).Build();
        getSupportFragmentManager().beginTransaction().add(R.id.top_right, radioFragment).show(radioFragment).commit();
    }


    private void setBottom() {
        List<String> title = new LinkedList<>();
        List<Fragment> content = new LinkedList<>();
        title.add("标题");
        content.add(new TestFragment());
        title.add("标题");
        content.add(new TestFragment());
        title.add("标题");
        content.add(new TestFragment());
        title.add("标题");
        content.add(new TestFragment());
        title.add("标题");
        content.add(new TestFragment());
        Fragment tabFragment = new TabMenu().creadTabMenu().setTitleLayout(R.layout.layout_title, R.id.lt_tab).setTitleTexts(title).setContentFragment(content).Build();
        getSupportFragmentManager().beginTransaction().add(R.id.top_left, tabFragment).show(tabFragment).commit();
    }

    public void setRight() {
        List<Fragment> content = new LinkedList<>();
        content.add(new TestFragment());
        content.add(new TestFragment());
        content.add(new TestFragment());
        content.add(new TestFragment());
        content.add(new TestFragment());
        Fragment radioFragment = new TabMenu().creadRadioMenu().setTitleLayout(R.layout.layout_title_radio, R.id.ltr_gb).setContentFragment(content).setDefaultGravity(Gravity.RIGHT).Build();
        getSupportFragmentManager().beginTransaction().add(R.id.bottom_right, radioFragment).show(radioFragment).commit();
    }

    private void setTop() {
        List<String> title = new LinkedList<>();
        List<Fragment> content = new LinkedList<>();
        title.add("标题");
        content.add(new TestFragment());
        title.add("标题");
        content.add(new TestFragment());
        title.add("标题");
        content.add(new TestFragment());
        title.add("标题");
        content.add(new TestFragment());
        title.add("标题");
        content.add(new TestFragment());
        Fragment tabFragment = new TabMenu().creadTabMenu().setTitleLayout(R.layout.layout_title, R.id.lt_tab).setTitleTexts(title).setDefaultGravity(Gravity.TOP).setContentFragment(content).Build();
        getSupportFragmentManager().beginTransaction().add(R.id.bottom_left, tabFragment).show(tabFragment).commit();
    }
}
