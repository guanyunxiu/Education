package com.gyx.education.education.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.gyx.education.education.R;
import com.gyx.education.education.base.BaseActivity;
import com.gyx.education.education.utils.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\10\18 0018.
 */

public class TestActivity extends BaseActivity {
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_test;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews() {

    }

    @OnClick(R.id.btn)
    public void onClick() {
        CommonUtil.showToast(this,"点击 我人");
    }
}
