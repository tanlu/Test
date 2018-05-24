package com.daydayup.yuekao_moth4.fragments.syfragmnet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.daydayup.yuekao_moth4.R;
import com.daydayup.yuekao_moth4.adapters.MyListAdapter;
import com.daydayup.yuekao_moth4.bean.AndroidBean;
import com.daydayup.yuekao_moth4.http.HttpConfig;
import com.daydayup.yuekao_moth4.http.utils.HttpUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化页面
 * <p>
 * 请求网络数据
 */
public class AndroidFragment extends Fragment {
    private static final String TAG = "AndroidFragment---";
    private View view;
    private PullToRefreshListView listView;
    private int page = 1;
    private List<AndroidBean.ResultsBean> list = new ArrayList<>();
    private MyListAdapter myListAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.android_layout, null);
        initViews();
        return view;
    }

    private void initViews() {
        listView = view.findViewById(R.id.pull_to_refresh_listview);
        //开启下拉和上啦刷新
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        //设置监听
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //刷新
                page = 1;
                getDataFromNet();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //加载更多
                page++;
                getDataFromNet();
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myListAdapter = new MyListAdapter(getContext(), list);

        listView.setAdapter(myListAdapter);


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //请求网络数据数据
            getDataFromNet();
        }
    }

    private void getDataFromNet() {
        HttpUtils httpUtils = HttpUtils.getInstance();
        httpUtils.get(HttpConfig.ANDROID_URL + page);
        httpUtils.setHttpUtilsListener(new HttpUtils.HttpUtilListener() {
            @Override
            public void getSuccess(String json) {
                Log.d(TAG, "---数据---: " + json);
                Gson gson = new Gson();
                AndroidBean androidBean = gson.fromJson(json, AndroidBean.class);

                if (page == 1) {
                    list.clear();
                }

                list.addAll(androidBean.getResults());

                myListAdapter.notifyDataSetChanged();

                listView.onRefreshComplete();

            }

            @Override
            public void getError(String error) {
                Log.d(TAG, "getError: " + error);
            }
        });
    }
    //

    public static AndroidFragment create(String title) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        AndroidFragment f = new AndroidFragment();
        f.setArguments(bundle);
        return f;
    }
}
