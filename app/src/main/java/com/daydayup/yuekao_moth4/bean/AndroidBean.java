package com.daydayup.yuekao_moth4.bean;

import java.util.List;

public class AndroidBean {

    /**
     * error : false
     * results : [{"_id":"5b02ada4421aa97aa11c234c","createdAt":"2018-05-21T19:29:40.273Z","desc":"Computer Vision on Android with Kotlin and Tensorflow Lite","images":["http://img.gank.io/e45d1fad-1497-47e0-866c-8883efdf7856","http://img.gank.io/39a4f7c8-113f-4369-9078-4de87d0bbff8","http://img.gank.io/1643e374-0dbc-4c0e-9cc0-0526515770cf","http://img.gank.io/22d932f5-ac7c-45e5-98f3-56fa586819b8"],"publishedAt":"2018-05-24T11:03:54.588Z","source":"chrome","type":"Android","url":"https://github.com/eddywm/KTFLITE","used":true,"who":"lijinshanmx"},{"_id":"5b04c482421aa97f03088329","createdAt":"2018-05-24T10:55:45.184Z","desc":"时间选择器、省市区三级联动","publishedAt":"2018-05-24T11:03:54.588Z","source":"web","type":"Android","url":"https://github.com/Bigkoo/Android-PickerView","used":true,"who":"nan403"},{"_id":"5b061bdd421aa97efda86521","createdAt":"2018-05-24T09:56:45.611Z","desc":"XRouter 一个轻量级的Android路由框架，基于ARouter上进行改良，优化Fragment的使用，可结合XPage使用","publishedAt":"2018-05-24T11:03:54.588Z","source":"chrome","type":"Android","url":"https://blog.csdn.net/xuexiangjys/article/details/80414078","used":true,"who":"xuexiangjys"},{"_id":"5b062896421aa97f0624f41e","createdAt":"2018-05-24T10:55:00.660Z","desc":"Flutter实现的圆形菜单","images":["http://img.gank.io/69b3716d-819f-4cd6-8097-77a402921357","http://img.gank.io/2e242f5f-23e7-4c11-b52c-ef204c1d4c27"],"publishedAt":"2018-05-24T11:03:54.588Z","source":"chrome","type":"Android","url":"https://github.com/MarcinusX/flutter_ui_challenge_filter_menu","used":true,"who":"lijinshanmx"},{"_id":"5b0628b9421aa97f0624f420","createdAt":"2018-05-24T10:54:38.498Z","desc":"Android Step Bar控件","images":["http://img.gank.io/61b959a2-c8e6-4ed0-a785-16747abace0e"],"publishedAt":"2018-05-24T11:03:54.588Z","source":"chrome","type":"Android","url":"https://github.com/imaNNeoFighT/StepBarView","used":true,"who":"lijinshanmx"},{"_id":"5b0628cf421aa97efda86525","createdAt":"2018-05-24T10:54:16.571Z","desc":"优雅的图表控件","images":["http://img.gank.io/130c7980-fbcb-4ee8-a1cc-93826ac425f1","http://img.gank.io/d0fabe81-016e-4736-9bd9-d32730f22699"],"publishedAt":"2018-05-24T11:03:54.588Z","source":"chrome","type":"Android","url":"https://github.com/thekeenant/fcharts","used":true,"who":"lijinshanmx"},{"_id":"5b0628ee421aa97f00f67c45","createdAt":"2018-05-24T10:52:30.447Z","desc":"Just a bar","images":["http://img.gank.io/d88342be-33e6-4888-b17d-ceafc05afc18"],"publishedAt":"2018-05-24T11:03:54.588Z","source":"chrome","type":"Android","url":"https://github.com/Hamadakram/JustBar","used":true,"who":"lijinshanmx"},{"_id":"5b03eda0421aa967a5d6b808","createdAt":"2018-05-22T18:14:56.322Z","desc":"自定义LayoutManager，炫酷列表","images":["http://img.gank.io/183cc749-d628-40fc-85cb-8112a207a6da","http://img.gank.io/50fd513c-c967-4774-b520-ba86d2a18d4f","http://img.gank.io/ef42363f-d094-45dd-8e42-b4d3cb5aa28d","http://img.gank.io/4c541aaa-2e16-40bb-a35f-d9c9a812593e"],"publishedAt":"2018-05-23T00:22:29.342Z","source":"web","type":"Android","url":"https://github.com/DingMouRen/LayoutManagerGroup","used":true,"who":"DingMouRen"},{"_id":"5b040587421aa967a5d6b80a","createdAt":"2018-05-22T19:56:55.686Z","desc":"Android中必要的一环---单元测试","publishedAt":"2018-05-23T00:22:29.342Z","source":"web","type":"Android","url":"https://github.com/simplezhli/AndroidUT","used":true,"who":"唯鹿"},{"_id":"5b042932421aa967abfaf1ae","createdAt":"2018-05-22T22:29:06.666Z","desc":"安卓热修复框架","publishedAt":"2018-05-23T00:22:29.342Z","source":"web","type":"Android","url":"https://github.com/ximsfei/Stark","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5b02ada4421aa97aa11c234c
         * createdAt : 2018-05-21T19:29:40.273Z
         * desc : Computer Vision on Android with Kotlin and Tensorflow Lite
         * images : ["http://img.gank.io/e45d1fad-1497-47e0-866c-8883efdf7856","http://img.gank.io/39a4f7c8-113f-4369-9078-4de87d0bbff8","http://img.gank.io/1643e374-0dbc-4c0e-9cc0-0526515770cf","http://img.gank.io/22d932f5-ac7c-45e5-98f3-56fa586819b8"]
         * publishedAt : 2018-05-24T11:03:54.588Z
         * source : chrome
         * type : Android
         * url : https://github.com/eddywm/KTFLITE
         * used : true
         * who : lijinshanmx
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
