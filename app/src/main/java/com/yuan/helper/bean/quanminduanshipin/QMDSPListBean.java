package com.yuan.helper.bean.quanminduanshipin;

import java.util.List;

/**
 * Created by shucheng.qu on 2018/12/16
 */
public class QMDSPListBean {

    public Data data;
    public int code;
    public String message;

    public static class Data {
        public int totalCount;
        public int pageNum;
        public String cdnName;
        public int shakeOpen;
        public int totalPage;
        public int page;
        public boolean hasNextPage;
        public java.util.List<List> list;

        public static class List {
            public String praiseCount;
            public String icon;
            public int id;
            public User user;
            public String giftCount;
            public String introduction;
            public String fileName;
            public String title;
            public String reviewerCount;
            public String shareCount;
            public int isFollow;
            public boolean isLike;

            public static class User {
                public String number;
                public String icon;
                public String imAccid;
                public String nickName;
                public int userId;
                public String level;
            }
        }
    }
}
