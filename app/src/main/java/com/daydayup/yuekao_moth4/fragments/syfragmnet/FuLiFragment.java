package com.daydayup.yuekao_moth4.fragments.syfragmnet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.daydayup.yuekao_moth4.R;
import com.daydayup.yuekao_moth4.adapters.MyGridAdapter;
import com.daydayup.yuekao_moth4.adapters.MyListAdapter;
import com.daydayup.yuekao_moth4.bean.AndroidBean;
import com.daydayup.yuekao_moth4.bean.FuLiBean;
import com.daydayup.yuekao_moth4.http.HttpConfig;
import com.daydayup.yuekao_moth4.http.utils.HttpUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class FuLiFragment extends Fragment {
    private static final String TAG = "FuLiFragment---";
    private View view;
    private PullToRefreshGridView gridView;
    private int page = 1;
    private List<FuLiBean.ResultsBean> list = new ArrayList<>();
    private MyGridAdapter myListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fuli_layout, null);
        initViews();
        return view;
    }

    private void initViews() {
        gridView = view.findViewById(R.id.pull_to_refresh_gridview);
        //开启下拉和上啦刷新
        gridView.setMode(PullToRefreshBase.Mode.BOTH);
        //设置监听
        gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                //刷新
                page = 1;
                getDataFromNet();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                //加载更多
                page++;
                getDataFromNet();
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myListAdapter = new MyGridAdapter(getContext(), list);

        gridView.setAdapter(myListAdapter);


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            //请求网络数据数据
            getDataFromNet();
        }
    }

    private void getDataFromNet() {
        HttpUtils httpUtils = HttpUtils.getInstance();
        httpUtils.get(HttpConfig.FULI_URL + page);
        httpUtils.setHttpUtilsListener(new HttpUtils.HttpUtilListener() {
            @Override
            public void getSuccess(String json) {
                Log.d(TAG, "---数据---: " + json);
                Gson gson = new Gson();
                FuLiBean fuLiBean = gson.fromJson(json, FuLiBean.class);

                if (page == 1) {
                    list.clear();
                }

                list.addAll(fuLiBean.getResults());

                myListAdapter.notifyDataSetChanged();

                gridView.onRefreshComplete();

            }

            @Override
            public void getError(String error) {
                Log.d(TAG, "getError: " + error);
            }
        });
    }

    public static FuLiFragment create(String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        FuLiFragment f = new FuLiFragment();
        f.setArguments(bundle);
        return f;
    }
}
