package com.yuan.helper.bean.huoshan

/**
 * @author shucheng.qu
 * @date   2019/1/30
 */
data class User(
    val data: List<Data>,
    val extra: Extra,
    val status_code: Int
)

data class Data(
    val content: Content,
    val type: Int
)

data class Content(
    val description: String,
    val items: List<Item>,
    val user: UserX
)

data class Item(
    val allow_comment: Boolean,
    val allow_dislike: Boolean,
    val allow_share: Boolean,
    val at_users: List<AtUser>,
    val author: Author,
    val comment_delay: Int,
    val create_time: Int,
    val description: String,
    val disable_watermark: Boolean,
    val follow_display: Boolean,
    val follow_status_tag: String,
    val id: Long,
    val id_str: String,
    val location: String,
    val media_type: Int,
    val prefetch_comment: Boolean,
    val prefetch_profile: Boolean,
    val share_description: String,
    val share_enable: Boolean,
    val share_strong_guide: Int,
    val share_title: String,
    val share_url: String,
    val song: Any,
    val stats: Stats,
    val status: Int,
    val tips: String,
    val tips_url: String,
    val title: String,
    val user_bury: Int,
    val user_digg: Int,
    val video: Video,
    val weibo_share_title: String
)

data class AtUser(
    val end: Int,
    val start: Int,
    val user_id: Long
)

data class Video(
    val allow_cache: Boolean,
    val cover: Cover,
    val cover_animated: Any,
    val cover_medium: CoverMedium,
    val cover_thumb: CoverThumb,
    val download_url: List<String>,
    val duration: Double,
    val height: Int,
    val preload_size: Int,
    val uri: String,
    val url_list: List<String>,
    val video_id: String,
    val watermark: Boolean,
    val width: Int
)

data class Cover(
    val avg_color: String,
    val uri: String,
    val url_list: List<String>
)

data class CoverMedium(
    val avg_color: String,
    val uri: String,
    val url_list: List<String>
)

data class CoverThumb(
    val avg_color: String,
    val uri: String,
    val url_list: List<String>
)

data class Author(
    val allow_be_located: Boolean,
    val allow_find_by_contacts: Boolean,
    val allow_others_download_video: Boolean,
    val allow_others_download_when_sharing_video: Boolean,
    val allow_share_show_profile: Boolean,
    val allow_show_in_gossip: Boolean,
    val allow_strange_comment: Boolean,
    val allow_unfollower_comment: Boolean,
    val anchor_level: AnchorLevel,
    val avatar_jpg: AvatarJpg,
    val avatar_large: AvatarLarge,
    val avatar_medium: AvatarMedium,
    val avatar_thumb: AvatarThumb,
    val bg_img_url: String,
    val birthday: Int,
    val birthday_description: String,
    val birthday_valid: Boolean,
    val block_status: Int,
    val city: String,
    val comment_restrict: Int,
    val constellation: String,
    val disable_ichat: Int,
    val enable_ichat_img: Int,
    val exp: Int,
    val fan_ticket_count: Int,
    val fold_stranger_chat: Boolean,
    val follow_status: Int,
    val gender: Int,
    val has_hashtag_item: Boolean,
    val hotsoon_verified: Boolean,
    val hotsoon_verified_reason: String,
    val ichat_restrict_type: Int,
    val id: Long,
    val id_str: String,
    val income_share_percent: Int,
    val is_follower: Boolean,
    val is_following: Boolean,
    val level: Int,
    val need_profile_guide: Boolean,
    val nickname: String,
    val pay_grade: PayGrade,
    val pay_scores: Int,
    val push_comment_status: Boolean,
    val push_digg: Boolean,
    val push_follow: Boolean,
    val push_ichat: Boolean,
    val push_status: Boolean,
    val push_video_post: Boolean,
    val push_video_recommend: Boolean,
    val short_id: Int,
    val signature: String,
    val type_a1: Int,
    val verified: Boolean,
    val verified_mobile: Boolean,
    val verified_reason: String
)

data class AvatarMedium(
    val uri: String,
    val url_list: List<String>
)

data class AnchorLevel(
    val experience: Int,
    val highest_experience_this_level: Int,
    val level: Int,
    val lowest_experience_this_level: Int,
    val profile_dialog_bg: ProfileDialogBg,
    val profile_dialog_bg_back: ProfileDialogBgBack,
    val small_icon: SmallIcon,
    val stage_level: StageLevel,
    val task_decrease_experience: Int,
    val task_end_time: Int,
    val task_start_experience: Int,
    val task_start_time: Int,
    val task_target_experience: Int
)

data class SmallIcon(
    val uri: String,
    val url_list: List<String>
)

data class StageLevel(
    val uri: String,
    val url_list: List<String>
)

data class ProfileDialogBg(
    val uri: String,
    val url_list: List<String>
)

data class ProfileDialogBgBack(
    val uri: String,
    val url_list: List<String>
)

data class AvatarLarge(
    val uri: String,
    val url_list: List<String>
)

data class AvatarJpg(
    val uri: String,
    val url_list: List<String>
)

data class PayGrade(
    val diamond_icon: DiamondIcon,
    val grade_banner: String,
    val grade_describe: String,
    val grade_icon_list: List<GradeIcon>,
    val icon: Icon,
    val im_icon: ImIcon,
    val im_icon_with_level: ImIconWithLevel,
    val level: Int,
    val live_icon: LiveIcon,
    val name: String,
    val new_im_icon_with_level: NewImIconWithLevel,
    val new_live_icon: NewLiveIcon,
    val next_diamond: Int,
    val next_icon: NextIcon,
    val next_name: String,
    val now_diamond: Int,
    val pay_diamond_bak: Int,
    val profile_dialog_bg: ProfileDialogBg,
    val profile_dialog_bg_back: ProfileDialogBgBack,
    val screen_chat_type: Int,
    val this_grade_max_diamond: Int,
    val this_grade_min_diamond: Int,
    val total_diamond_count: Int,
    val upgrade_need_consume: Int
)

data class ImIconWithLevel(
    val uri: String,
    val url_list: List<String>
)

data class NewLiveIcon(
    val uri: String,
    val url_list: List<String>
)

data class ImIcon(
    val uri: String,
    val url_list: List<String>
)

data class LiveIcon(
    val uri: String,
    val url_list: List<String>
)

data class GradeIcon(
    val icon: Icon,
    val icon_diamond: Int,
    val level: Int,
    val level_str: String
)

data class Icon(
    val uri: String,
    val url_list: List<String>
)

data class NewImIconWithLevel(
    val uri: String,
    val url_list: List<String>
)

data class NextIcon(
    val uri: String,
    val url_list: List<String>
)

data class DiamondIcon(
    val uri: String,
    val url_list: List<String>
)

data class AvatarThumb(
    val uri: String,
    val url_list: List<String>
)

data class Stats(
    val comment_count: Int,
    val digg_count: Int,
    val play_count: Int,
    val share_count: Int
)

data class UserX(
    val allow_be_located: Boolean,
    val allow_find_by_contacts: Boolean,
    val allow_others_download_video: Boolean,
    val allow_others_download_when_sharing_video: Boolean,
    val allow_share_show_profile: Boolean,
    val allow_show_in_gossip: Boolean,
    val allow_strange_comment: Boolean,
    val allow_unfollower_comment: Boolean,
    val anchor_level: AnchorLevel,
    val avatar_jpg: AvatarJpg,
    val avatar_large: AvatarLarge,
    val avatar_medium: AvatarMedium,
    val avatar_thumb: AvatarThumb,
    val bg_img_url: String,
    val birthday: Int,
    val birthday_description: String,
    val birthday_valid: Boolean,
    val block_status: Int,
    val city: String,
    val cluster_follower_count: Int,
    val comment_restrict: Int,
    val constellation: String,
    val disable_ichat: Int,
    val enable_ichat_img: Int,
    val exp: Int,
    val fan_ticket_count: Int,
    val fold_stranger_chat: Boolean,
    val follow_status: Int,
    val gender: Int,
    val has_hashtag_item: Boolean,
    val hotsoon_verified: Boolean,
    val hotsoon_verified_reason: String,
    val ichat_restrict_type: Int,
    val id: Long,
    val id_str: String,
    val income_share_percent: Int,
    val is_follower: Boolean,
    val is_following: Boolean,
    val level: Int,
    val need_profile_guide: Boolean,
    val nickname: String,
    val pay_grade: PayGrade,
    val pay_scores: Int,
    val push_comment_status: Boolean,
    val push_digg: Boolean,
    val push_follow: Boolean,
    val push_ichat: Boolean,
    val push_status: Boolean,
    val push_video_post: Boolean,
    val push_video_recommend: Boolean,
    val short_id: Int,
    val signature: String,
    val stats: StatsX,
    val total_fans_count: Int,
    val type_a1: Int,
    val verified: Boolean,
    val verified_mobile: Boolean,
    val verified_reason: String
)

data class StatsX(
    val daily_fan_ticket_count: Int,
    val daily_income: Int,
    val diamond_consumed_count: Int,
    val diamond_count: Int,
    val favorite_item_count: Int,
    val follower_count: Int,
    val following_count: Int,
    val id: Long,
    val id_str: String,
    val item_count: Int,
    val record_count: Int,
    val total_duration: Int,
    val tuwen_item_count: Int
)

data class Extra(
    val fatal_ids: List<Any>,
    val has_more: Boolean,
    val now: Long,
    val offset: Int
)