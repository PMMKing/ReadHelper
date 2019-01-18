package com.yuan.helper.bean.douyin;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shucheng.qu on 2018/12/11
 */
public class DouyinListBean implements Serializable {


    public int status_code;
    public int min_cursor;
    public int max_cursor;
    public int has_more;
    public int home_model;
    public int refresh_clear;
    public Extra extra;
    public LogPb log_pb;
    public List<AwemeList> aweme_list;

    public static class Extra {
        public long now;
        public Object fatal_item_ids;
    }

    public static class LogPb {
        public String impr_id;
    }

    public static class AwemeList {
        public String aweme_id;
        public String desc;
        public int create_time;
        public Author author;
        public Music music;
        public Object cha_list;
        public Video video;
        public String share_url;
        public int user_digged;
        public Statistics statistics;
        public Status status;
        public int rate;
        public int is_top;
        public LabelTop label_top;
        public ShareInfoX share_info;
        public String distance;
        public boolean is_vr;
        public boolean is_ads;
        public PoiInfo poi_info;
        public int duration;
        public int aweme_type;
        public boolean is_fantasy;
        public boolean cmt_swt;
        public Object image_infos;
        public RiskInfos risk_infos;
        public boolean is_relieve;
        public String sort_label;
        public Object position;
        public Object uniqid_position;
        public Object comment_list;
        public long author_user_id;
        public int bodydance_score;
        public int is_hash_tag;
        public boolean is_pgcshow;
        public String region;
        public int vr_type;
        public int collect_stat;
        public Object label_top_text;
        public Object promotions;
        public String group_id;
        public boolean prevent_download;
        public Object nickname_position;
        public Object challenge_position;
        public int item_comment_settings;
        public boolean with_promotional_music;
        public XiguaTask xigua_task;
        public Object long_video;
        public Descendants descendants;
        public RawAdData raw_ad_data;
        public String stickers;
        public StickerDetail sticker_detail;
        public List<?> text_extra;
        public List<?> video_labels;
        public List<?> geofencing;
        public List<?> video_text;

        public static class Author {
            public String uid;
            public String short_id;
            public String nickname;
            public int gender;
            public String signature;
            public AvatarLarger avatar_larger;
            public AvatarThumb avatar_thumb;
            public AvatarMedium avatar_medium;
            public String birthday;
            public boolean is_verified;
            public int follow_status;
            public int aweme_count;
            public int following_count;
            public int follower_count;
            public int favoriting_count;
            public int total_favorited;
            public boolean is_block;
            public boolean hide_search;
            public int constellation;
            public String location;
            public boolean hide_location;
            public String weibo_verify;
            public String custom_verify;
            public String unique_id;
            public String bind_phone;
            public int special_lock;
            public int need_recommend;
            public boolean is_binded_weibo;
            public String weibo_name;
            public String weibo_schema;
            public String weibo_url;
            public boolean story_open;
            public int story_count;
            public boolean has_facebook_token;
            public boolean has_twitter_token;
            public int fb_expire_time;
            public int tw_expire_time;
            public boolean has_youtube_token;
            public int youtube_expire_time;
            public long room_id;
            public int live_verify;
            public int authority_status;
            public String verify_info;
            public int shield_follow_notice;
            public int shield_digg_notice;
            public int shield_comment_notice;
            public String school_name;
            public String school_poi_id;
            public int school_type;
            public ShareInfo share_info;
            public boolean with_commerce_entry;
            public int verification_type;
            public String enterprise_verify_reason;
            public boolean is_ad_fake;
            public Object followers_detail;
            public String region;
            public String account_region;
            public int sync_to_toutiao;
            public int commerce_user_level;
            public int live_agreement;
            public Object platform_sync_info;
            public boolean with_shop_entry;
            public boolean is_discipline_member;
            public int secret;
            public boolean has_orders;
            public boolean prevent_download;
            public boolean show_image_bubble;
            public int unique_id_modify_time;
            public VideoIcon video_icon;
            public String ins_id;
            public String google_account;
            public String youtube_channel_id;
            public String youtube_channel_title;
            public int apple_account;
            public boolean with_dou_entry;
            public boolean with_fusion_shop_entry;
            public boolean is_phone_binded;
            public boolean accept_private_policy;
            public String twitter_id;
            public String twitter_name;
            public boolean user_canceled;
            public boolean has_email;
            public boolean is_gov_media_vip;
            public int live_agreement_time;
            public int status;
            public int create_time;
            public String avatar_uri;
            public int follower_status;
            public int neiguang_shield;
            public int comment_setting;
            public int duet_setting;
            public int reflow_page_gid;
            public int reflow_page_uid;
            public int user_rate;
            public Object policy_version;
            public int download_setting;
            public int download_prompt_ts;
            public int react_setting;
            public boolean live_commerce;
            public String language;
            public boolean has_insights;
            public String share_qrcode_uri;
            public Object item_list;
            public Object new_story_cover;
            public List<?> geofencing;
            public List<CoverUrl> cover_url;

            public static class AvatarLarger {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class AvatarThumb {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class AvatarMedium {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class ShareInfo {
                public String share_url;
                public String share_weibo_desc;
                public String share_desc;
                public String share_title;
                public ShareQrcodeUrl share_qrcode_url;
                public String share_title_myself;
                public String share_title_other;

                public static class ShareQrcodeUrl {
                    public String uri;
                    public int width;
                    public int height;
                    public List<String> url_list;
                }
            }

            public static class VideoIcon {
                public String uri;
                public int width;
                public int height;
                public List<?> url_list;
            }

            public static class CoverUrl {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }
        }

        public static class Music {
            public long id;
            public String id_str;
            public String title;
            public String author;
            public String album;
            public CoverHd cover_hd;
            public CoverLarge cover_large;
            public CoverMedium cover_medium;
            public CoverThumb cover_thumb;
            public PlayUrl play_url;
            public String schema_url;
            public int source_platform;
            public int start_time;
            public int end_time;
            public int duration;
            public String extra;
            public int user_count;
            public Object position;
            public int collect_stat;
            public int status;
            public String offline_desc;
            public EffectsData effects_data;
            public String owner_id;
            public String owner_nickname;
            public AudioTrack audio_track;
            public boolean is_original;
            public String mid;
            public boolean redirect;
            public boolean is_restricted;
            public boolean author_deleted;
            public boolean is_del_video;
            public boolean is_video_self_see;
            public String owner_handle;
            public Object author_position;
            public boolean prevent_download;

            public static class CoverHd {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class CoverLarge {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class CoverMedium {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class CoverThumb {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class PlayUrl {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class EffectsData {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class AudioTrack {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }
        }

        public static class Video {
            public PlayAddr play_addr;
            public Cover cover;
            public int height;
            public int width;
            public DynamicCover dynamic_cover;
            public OriginCover origin_cover;
            public String ratio;
            public DownloadAddr download_addr;
            public boolean has_watermark;
            public PlayAddrLowbr play_addr_lowbr;
            public int duration;
            public int is_h265;
            public List<BitRate> bit_rate;

            public static class PlayAddr {
                public String uri;
                public int width;
                public int height;
                public String url_key;
                public List<String> url_list;
            }

            public static class Cover {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class DynamicCover {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class OriginCover {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class DownloadAddr {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class PlayAddrLowbr {
                public String uri;
                public int width;
                public int height;
                public String url_key;
                public List<String> url_list;
            }

            public static class BitRate {
                public String gear_name;
                public int quality_type;
                public int bit_rate;
                public int is_h265;
            }
        }

        public static class Statistics {
            public String aweme_id;
            public int comment_count;
            public int digg_count;
            public int play_count;
            public int share_count;
            public int forward_count;
        }

        public static class Status {
            public String aweme_id;
            public boolean is_delete;
            public boolean allow_share;
            public boolean allow_comment;
            public boolean is_private;
            public boolean with_goods;
            public int private_status;
            public boolean with_fusion_goods;
            public boolean in_reviewing;
            public int reviewed;
            public boolean self_see;
            public boolean is_prohibited;
            public int download_status;
        }

        public static class LabelTop {
            public String uri;
            public int width;
            public int height;
            public List<String> url_list;
        }

        public static class ShareInfoX {
            public String share_url;
            public String share_weibo_desc;
            public String share_desc;
            public String share_title;
            public int bool_persist;
            public String share_title_myself;
            public String share_title_other;
            public String share_link_desc;
            public String share_signature_url;
            public String share_signature_desc;
            public String share_quote;
        }

        public static class PoiInfo {
            public String poi_id;
            public String poi_name;
            public String type_code;
            public int user_count;
            public int item_count;
            public ShareInfoXX share_info;
            public CoverHdX cover_hd;
            public CoverLargeX cover_large;
            public CoverMediumX cover_medium;
            public CoverThumbX cover_thumb;
            public String distance;
            public AddressInfo address_info;
            public int icon_type;
            public int collect_stat;
            public double poi_longitude;
            public double poi_latitude;
            public int expand_type;
            public IconOnMap icon_on_map;
            public IconOnEntry icon_on_entry;
            public IconOnInfo icon_on_info;
            public String poi_voucher;
            public int show_type;
            public PoiCard poi_card;
            public int poi_subtitle_type;

            public static class ShareInfoXX {
                public String share_url;
                public String share_weibo_desc;
                public String share_desc;
                public String share_title;
                public int bool_persist;
                public String share_title_myself;
                public String share_title_other;
            }

            public static class CoverHdX {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class CoverLargeX {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class CoverMediumX {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class CoverThumbX {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class AddressInfo {
                public String province;
                public String city;
                public String district;
                public String address;
                public String simple_addr;
                public String city_code;
            }

            public static class IconOnMap {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class IconOnEntry {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class IconOnInfo {
                public String uri;
                public int width;
                public int height;
                public List<String> url_list;
            }

            public static class PoiCard {
                public int is_show;
                public String url;
            }
        }

        public static class RiskInfos {
            public boolean vote;
            public boolean warn;
            public boolean risk_sink;
            public int type;
            public String content;
        }

        public static class XiguaTask {
            public boolean is_xigua_task;
        }

        public static class Descendants {
            public String notify_msg;
            public List<String> platforms;
        }

        public static class RawAdData {
            public long ad_id;
            public String button_text;
            public int video_transpose;
            public String appleid;
            public ClickTrackUrlList click_track_url_list;
            public boolean disable_show_ad_link;
            public String download_url;
            public String log_extra;
            public int preload_web;
            public int show_mask_times;
            public TrackUrlList track_url_list;
            public long group_id;
            public String app_name;
            public CommentArea comment_area;
            public int effective_play_time;
            public boolean is_real_author;
            public String learn_more_bg_color;
            public String title;
            public boolean comment_area_switch;
            public boolean is_preview;
            public boolean report_enable;
            public String type;
            public String web_url;
            public int button_style;
            public CardInfos card_infos;
            public Label label;
            public String source;
            public int animation_type;
            public long creative_id;
            public int show_button_seconds;

            public static class ClickTrackUrlList {
                public String uri;
                public List<?> url_list;
            }

            public static class TrackUrlList {
                public String uri;
                public List<?> url_list;
            }

            public static class CommentArea {
                public int comment_time;
                public int show_button_number;
                public String source;
                public String title;
                public AvatarIcon avatar_icon;
                public String button_text;
                public String comment_info;
                public String comment_nickname;

                public static class AvatarIcon {
                    public String uri;
                    public List<String> url_list;
                }
            }

            public static class CardInfos {
                @JSONField(name = "3")
                public _$3 _$3;

                public static class _$3 {
                    public int show_seconds;
                    public CardData card_data;
                    public int card_type;
                    public String card_url;

                    public static class CardData {
                        public String apple_id;
                        public String button_text;
                        public String image_url;
                        public String source;
                        public int style_type;
                        public String title;
                    }
                }
            }

            public static class Label {
                public int type;
                public String color;
                public String color_text;
                public String text;
            }
        }

        public static class StickerDetail {
            public String id;
            public String name;
            public Object children;
            public Object tags;
        }
    }
}
