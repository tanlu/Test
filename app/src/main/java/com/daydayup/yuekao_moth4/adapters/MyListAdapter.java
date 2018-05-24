package com.daydayup.yuekao_moth4.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daydayup.yuekao_moth4.R;
import com.daydayup.yuekao_moth4.app.MyApp;
import com.daydayup.yuekao_moth4.bean.AndroidBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<AndroidBean.ResultsBean> list;

    public MyListAdapter(Context context, List<AndroidBean.ResultsBean> list) {
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
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item_android,null);
            ImageView imageView=convertView.findViewById(R.id.item_android_pic);
            TextView textView= convertView.findViewById(R.id.item_android_tv);
            myViewHolder=new MyViewHolder(imageView,textView);

            convertView.setTag(myViewHolder);

        }else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }

        //
        myViewHolder.getTextView().setText(list.get(position).getDesc());

        List<String> images = list.get(position).getImages();
        if (images!=null&&images.size()>0){
            String pic_url = images.get(0);
            ImageLoader.getInstance().displayImage(pic_url,myViewHolder.getImageView(), MyApp.getOptions());
        }

        return convertView;
    }
    class MyViewHolder{
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(ImageView imageView, TextView textView) {
            this.imageView = imageView;
            this.textView = textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }
}
