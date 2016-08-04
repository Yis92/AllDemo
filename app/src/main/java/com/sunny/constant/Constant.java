package com.sunny.constant;

/**
 * 常量类
 */
public class Constant {

    //判断有没有使用过app
    public static final String XINWEN_FIRST_USE = "first_use";

    //启动图
    public static final String XINWEN_START_URL = "start_url";

    //shared
    public static final String XINWEN_PRE_NAME = "news";

    //EventBus
    public static final String XINWEN_REFRASH_INDEX="refresh_index";//刷新首页

    //新闻是否阅读过
    public static final String XINWEN_IS_READ="is_read";

    //搜索历史记录
    public static final String XINWEN_SEARCH_HISTORY="search_history";
    public static final String SEARCH_NAME="search_name";//搜索关键字

    //历史阅读
    public static final String XINWEN_HISTORY_READ="history_read";

    //我的个人兴趣
    public static final String XINWEN_MY_INTEREST="my_interest";
    //当在我的兴趣词中删除兴趣词时，通知是否需要更新添加兴趣词中的我的兴趣
    public static final String XINWEN_IS_UPDATE_INTEREST="is_update_interest";


    //我的频道
    public static final String MY_CHANNEL="my_channel";
    public static final String MY_CHANNEL_NAME="my_channel_name";//频道名称
    public static final String CHANNEL_ID="cid";//频道id

    //请求码、返回码
    public static final int REQUEST_CODE = 1001;
    public static final int RESULT_CODE = 1002;

    //贴心生活URL
    public static final String FIND_LIFE_URL = "find_life_url";
    public static final String FIND_LIFE_TITLE = "find_life_title";


    //新闻标题
    public static final String NEWS_TITLE="news_title";
    public static final String NID="nid";//新闻ID
    public static final String NEWS_URL="news_url";//新闻URL

    public static final String UID ="uid";//用户uid
    public static final String USERNAME ="username";//用户名
    public static final String PASSWORD ="password";//密码
    public static final String SEX ="sex";//用户性别
    public static final String MOBILE ="mobile";//用户手机号
    public static final String LEVEL ="level";//用户等级
    public static final String AVATAR ="avatar";//头像地址
    public static final String INVITECODDE ="inviteCode";//用户邀请码
    public static final String SCORE ="score";//用户积分
    public static final String TOKEN ="token";//用户token标识
    public static final String MOBILECODESTATUS ="mobileCodeStatus";//用户注册状态
    public static final String TOTALREAD ="totalRead";//总阅读数
    public static final String IP ="ip";//用户ip
    public static final String REGISTERTIME ="registerTime";//用户注册时间
    public static final String TODAYREAD ="todayRead";//总阅读数


    //控制新手引导
    public static final String GUIDE_INDEX="guide_index";
    public static final String GUIDE_INDEX_NEWS_SHOW="guide_index_news_show";
    public static final String GUIDE_USER="guide_user";
}
