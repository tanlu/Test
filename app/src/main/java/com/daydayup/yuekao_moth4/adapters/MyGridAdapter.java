package com.daydayup.yuekao_moth4.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daydayup.yuekao_moth4.R;
import com.daydayup.yuekao_moth4.app.MyApp;
import com.daydayup.yuekao_moth4.bean.AndroidBean;
import com.daydayup.yuekao_moth4.bean.FuLiBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MyGridAdapter extends BaseAdapter {

    private static final String TAG = "MyGridAdapter*****";

    private Context context;
    private List<FuLiBean.ResultsBean> list;

    public MyGridAdapter(Context context, List<FuLiBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_fuli, null);
            ImageView imageView = convertView.findViewById(R.id.fuli_item_pic);

            myViewHolder = new MyViewHolder(imageView);

            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        //

        String url = list.get(position).getUrl();

        if (!TextUtils.isEmpty(url)){
            Log.d(TAG, "getView: "+url);
            ImageLoader.getInstance().displayImage(url, myViewHolder.getImageView(), MyApp.getOptions());

        }


        return convertView;
    }

    class MyViewHolder {
        private ImageView imageView;

        public MyViewHolder(ImageView imageView) {
            this.imageView = imageView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

    }
}
