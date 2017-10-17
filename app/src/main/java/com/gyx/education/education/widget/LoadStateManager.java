package com.gyx.education.education.widget;

import com.gyx.education.education.base.BaseStateManager;

/**
 * Created by Administrator on 2016/11/3.
 */

public class LoadStateManager extends BaseStateManager<LoadStateManager.LoadState> {
    public static enum LoadState{
        Init,
        Success,
        Failure,
        NoData
        ;
    }
}
