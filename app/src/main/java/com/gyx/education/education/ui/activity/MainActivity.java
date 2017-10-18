package com.gyx.education.education.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.gyx.education.education.R;
import com.gyx.education.education.base.BaseActivity;
import com.gyx.education.education.ui.fragment.CoursesFragment;
import com.gyx.education.education.ui.fragment.HomePageFragment;
import com.gyx.education.education.ui.fragment.PersonalFragment;
import com.gyx.education.education.ui.fragment.QuestionFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\10\17 0017.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.id_content)
    FrameLayout idContent;
    @BindView(R.id.tab01_lv)
    RadioButton tab01Lv;
    @BindView(R.id.tab02_lv)
    RadioButton tab02Lv;
    @BindView(R.id.tab03_lv)
    RadioButton tab03Lv;
    @BindView(R.id.tab04_lv)
    RadioButton tab04Lv;
    @BindView(R.id.tab05_lv)
    RadioButton tab05Lv;
    @BindView(R.id.coordinatorLayout)
    LinearLayout coordinatorLayout;
    HomePageFragment homePageFragment;
    CoursesFragment coursesFragment;
    QuestionFragment questionFragment;
    PersonalFragment personalFragment;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        setSelect(0);
    }

    @Override
    protected void updateViews() {

    }


    public void setSelect(int i) {
        resetImgs();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i) {
            case 0:
                if (homePageFragment == null) {
                    homePageFragment = new HomePageFragment();
                    transaction.add(R.id.id_content, homePageFragment);
                } else {
                    transaction.show(homePageFragment);
                }
                break;
            case 1:
                if (coursesFragment == null) {
                    coursesFragment = new CoursesFragment();
                    transaction.add(R.id.id_content, coursesFragment);
                } else {
                    transaction.show(coursesFragment);
                }
                break;
            case 2:
                if (questionFragment == null) {
                    questionFragment = new QuestionFragment();
                    transaction.add(R.id.id_content, questionFragment);
                } else {
                    transaction.show(questionFragment);
                }
                break;
            case 3:
                break;
            case 4:
                if (personalFragment == null) {
                    personalFragment = new PersonalFragment();
                    transaction.add(R.id.id_content, personalFragment);
                } else {   //
                    transaction.show(personalFragment);
                }
                break;

            default:
                break;
        }

        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction) {
        if (homePageFragment != null) {
            transaction.hide(homePageFragment);
        }
        if (coursesFragment != null) {
            transaction.hide(coursesFragment);
        }
        if (questionFragment != null) {
            transaction.hide(questionFragment);
        }
        if (personalFragment != null) {
            transaction.hide(personalFragment);
        }
    }

    /**
     * 切换图片至暗色
     */
    public void resetImgs() {
        //今天天气不错辅导费热熔
        //id_scenicpot_rdo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_main, 0, 0);
        // id_mine_rdo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_foot, 0, 0);
    }

    @OnClick({R.id.tab01_lv, R.id.tab02_lv, R.id.tab03_lv, R.id.tab04_lv, R.id.tab05_lv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab01_lv:
                setSelect(0);
                break;
            case R.id.tab02_lv:
                setSelect(1);
                break;
            case R.id.tab03_lv:
                setSelect(2);
                break;
            case R.id.tab04_lv:
                setSelect(3);
                break;
            case R.id.tab05_lv:
                setSelect(4);
                break;
        }
    }
}
