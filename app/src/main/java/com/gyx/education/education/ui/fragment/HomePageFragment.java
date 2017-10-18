package com.gyx.education.education.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gyx.education.education.R;
import com.gyx.education.education.adapter.MyPagerAdapter;
import com.gyx.education.education.base.BaseFragment;
import com.gyx.education.education.model.LoopImage;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 内容：
 * Created by 关云秀 on 2017\10\17 0017.
 */

public class HomePageFragment extends BaseFragment {
    @BindView(R.id.rollpager)
    RollPagerView pagerView;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void initViews() {
        //设置适配器
        pagerView.setAdapter(new MyPagerAdapter(getUrl(),mContext));

        pagerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mContext,"点击了：：："+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void updateViews() {

    }
    public List<LoopImage> getUrl(){
        List<LoopImage> loopImages = new ArrayList<>();
            LoopImage loopImage = new LoopImage();
            loopImage.setPath("http://www.saiwensida.com:8080/zhly/upload/loop/e2c084ff-1a47-4c00-b42c-8f993264464d.jpg");
            loopImages.add(loopImage);
        LoopImage loopImage2 = new LoopImage();
        loopImage2.setPath("http://www.saiwensida.com:8080/zhly/upload/loop/1b60af6b-3a84-4359-92d5-6cfd5cde6a74.jpg");
        loopImages.add(loopImage2);
        LoopImage loopImage3 = new LoopImage();
        loopImage3.setPath("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        loopImages.add(loopImage3);
        return loopImages;
    }
}
