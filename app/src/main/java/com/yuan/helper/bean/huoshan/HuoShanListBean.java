package com.yuan.helper.bean.huoshan;

import java.util.List;

/**
 * Created by shucheng.qu on 2018/12/21
 */
public class HuoShanListBean {

    public int status_code;
    public Extra extra;
    public List<DataX> data;

    public static class Extra {
        public LogPb log_pb;
        public long now;
        public boolean has_more;
        public int is_backup;
        public int cost;
        public long max_time;
        public long min_time;
        public int total;
        public Banner banner;
        public List<?> fatal_ids;

        public static class LogPb {
            public String impr_id;
        }

        public static class Banner {
            public int total;
            public List<?> banners;
        }
    }

    public static class DataX {
        public int type;
        public String rid;
        public Data data;

        public static class Data {
            public int display_style;
            public String weibo_share_title;
            public String share_title;
            public int cell_width;
            public int share_strong_guide;
            public String follow_status_tag;
            public int create_time;
            public Video video;
            public long id;
            public int user_bury;
            public Stats stats;
            public boolean share_enable;
            public String title;
            public String share_url;
            public boolean follow_display;
            public String feed_tips;
            public String location;
            public int media_type;
            public String tips;
            public String id_str;
            public int status;
            public int cell_height;
            public String description;
            public Song song;
            public boolean prefetch_comment;
            public String tips_url;
            public boolean allow_share;
            public int user_digg;
            public int feed_tips_type;
            public int comment_delay;
            public Author author;
            public boolean disable_watermark;
            public boolean allow_dislike;
            public String share_description;
            public boolean allow_comment;
            public boolean prefetch_profile;
            public List<AtUsers> at_users;

            public static class Video {
                public String video_id;
                public boolean watermark;
                public boolean allow_cache;
                public Cover cover;
                public String uri;
                public int height;
                public int width;
                public String h265_uri;
                public double duration;
                public int preload_size;
                public Object cover_animated;
                public CoverMedium cover_medium;
                public CoverThumb cover_thumb;
                public List<String> h265_url;
                public List<String> url_list;
                public List<String> download_url;

                public static class Cover {
                    public String avg_color;
                    public String uri;
                    public List<String> url_list;
                }

                public static class CoverMedium {
                    public String avg_color;
                    public String uri;
                    public List<String> url_list;
                }

                public static class CoverThumb {
                    public String avg_color;
                    public String uri;
                    public List<String> url_list;
                }
            }

            public static class Stats {
                public int play_count;
                public int share_count;
                public int comment_count;
                public int digg_count;
            }

            public static class Song {
                public String album;
                public int status;
                public String author;
                public PlayUrl play_url;
                public boolean show_in_video;
                public String title;
                public String share_url;
                public int source_platform;
                public CoverLarge cover_large;
                public String share_description;
                public String share_title;
                public long original_user_id;
                public int duration;
                public String original_titel_tpl;
                public long id;
                public CoverThumbX cover_thumb;

                public static class PlayUrl {
                    public String uri;
                    public List<String> url_list;
                }

                public static class CoverLarge {
                    public String uri;
                    public List<String> url_list;
                }

                public static class CoverThumbX {
                    public String uri;
                    public List<String> url_list;
                }
            }

            public static class Author {
                public String live_room_id_str;
                public boolean allow_find_by_contacts;
                public AvatarLarge avatar_large;
                public int pay_scores;
                public int income_share_percent;
                public int luckymoney_num;
                public boolean is_following;
                public boolean allow_others_download_video;
                public boolean is_follower;
                public String hotsoon_verified_reason;
                public int ichat_restrict_type;
                public boolean allow_unfollower_comment;
                public String constellation;
                public long id;
                public boolean verified_mobile;
                public boolean push_ichat;
                public String city;
                public boolean verified;
                public int short_id;
                public Border border;
                public int comment_restrict;
                public boolean has_hashtag_item;
                public int enable_ichat_img;
                public String verified_reason;
                public boolean push_digg;
                public PayGrade pay_grade;
                public boolean allow_others_download_when_sharing_video;
                public String id_str;
                public AvatarMedium avatar_medium;
                public boolean fold_stranger_chat;
                public AvatarThumb avatar_thumb;
                public boolean need_profile_guide;
                public boolean hotsoon_verified;
                public String bg_img_url;
                public String birthday_description;
                public boolean push_follow;
                public int birthday;
                public long live_room_id;
                public boolean allow_share_show_profile;
                public boolean push_video_post;
                public boolean push_video_recommend;
                public String nickname;
                public boolean birthday_valid;
                public int disable_ichat;
                public int block_status;
                public int fan_ticket_count;
                public boolean push_status;
                public AvatarJpg avatar_jpg;
                public boolean allow_be_located;
                public int level;
                public boolean push_comment_status;
                public int gender;
                public String room_title;
                public boolean allow_show_in_gossip;
                public boolean allow_strange_comment;
                public int exp;
                public String signature;
                public int type_a1;
                public int follow_status;

                public static class AvatarLarge {
                    public String uri;
                    public List<String> url_list;
                }

                public static class Border {
                    public int level;
                    public Icon icon;

                    public static class Icon {
                        public String uri;
                        public List<String> url_list;
                    }
                }

                public static class PayGrade {
                    public int this_grade_min_diamond;
                    public IconX icon;
                    public int this_grade_max_diamond;
                    public ProfileDialogBg profile_dialog_bg;
                    public int next_diamond;
                    public LiveIcon live_icon;
                    public NewLiveIcon new_live_icon;
                    public int now_diamond;
                    public int pay_diamond_bak;
                    public ImIcon im_icon;
                    public int upgrade_need_consume;
                    public ProfileDialogBgBack profile_dialog_bg_back;
                    public NewImIconWithLevel new_im_icon_with_level;
                    public int total_diamond_count;
                    public String grade_banner;
                    public String grade_describe;
                    public DiamondIcon diamond_icon;
                    public String next_name;
                    public NextIcon next_icon;
                    public String name;
                    public int level;
                    public int screen_chat_type;
                    public ImIconWithLevel im_icon_with_level;
                    public List<GradeIconList> grade_icon_list;

                    public static class IconX {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class ProfileDialogBg {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class LiveIcon {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class NewLiveIcon {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class ImIcon {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class ProfileDialogBgBack {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class NewImIconWithLevel {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class DiamondIcon {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class NextIcon {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class ImIconWithLevel {
                        public String uri;
                        public List<String> url_list;
                    }

                    public static class GradeIconList {
                        public String level_str;
                        public int icon_diamond;
                        public int level;
                        public IconXX icon;

                        public static class IconXX {
                            public String uri;
                            public List<String> url_list;
                        }
                    }
                }

                public static class AvatarMedium {
                    public String uri;
                    public List<String> url_list;
                }

                public static class AvatarThumb {
                    public String uri;
                    public List<String> url_list;
                }

                public static class AvatarJpg {
                    public String uri;
                    public List<String> url_list;
                }
            }

            public static class AtUsers {
                public int start;
                public int end;
                public long user_id;
            }
        }
    }
}
