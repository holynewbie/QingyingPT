package cn.edu.hit.pt.http;import java.io.UnsupportedEncodingException;import java.net.URLEncoder;import java.text.DecimalFormat;import java.util.ArrayList;import android.util.Base64;import cn.edu.hit.pt.Params;import com.litesuits.http.data.NameValuePair;public class URLContainer {	public static final String PREFIX = "http://";	public static final String BASEURL = PREFIX + "219.217.227.94/";	public static final String BASEURL_ALTERNATE = PREFIX + "pt.hit.edu.cn/";	public static final String DOMAIN = BASEURL + "android/" + Params.version + "/";	public static String getLoginUrl(String userName, String password) {		String pattern = "0000";		DecimalFormat df = new DecimalFormat(pattern);		String client = df.format(Params.version);		String url = DOMAIN + "login.php?username=" + userName + "&password=" + Base64.encodeToString(password.getBytes(), Base64.NO_WRAP|Base64.URL_SAFE) + "&client=android" + client;		return url;	}		public static String getUserInforUrl(long userid, boolean if_client) {		String url = "";		if(userid == 0){			String client = "";			if(if_client == true){				String pattern = "0000";				DecimalFormat df = new DecimalFormat(pattern);				client = df.format(Params.version);			}			url = DOMAIN + "user.php?client=android" + client;		}else			url = DOMAIN + "user.php?userid=" + userid;		return url;	}		public static String getSaveProfileUrl() {		String url = DOMAIN + "user.php?action=update";		return url;	}		public static String getShoutboxUrl(long id) {		String url = DOMAIN + "shoutbox.php?id="+id;		return url;	}		public static String getPostShoutboxUrl(String text) {		String url;		try {			url = DOMAIN + "shoutbox.php?post=1&text="+URLEncoder.encode(text, "UTF-8");			return url;		} catch (UnsupportedEncodingException e) {			e.printStackTrace();		}		return null;	}	public static String getProfileUrl(long userid) {		String url = DOMAIN + "last_update_profile.php?id=" + userid;		return url;	}	public static String getAvatarUrl(long userid) {		String url = DOMAIN + "user_avatar.php?userid=" + userid;		return url;	}	public static String getTorrent(ArrayList<NameValuePair> params) {		String s = "";		for (int i = 0; i < params.size(); i++) {			NameValuePair nPair = params.get(i);			s += nPair.getName();			s += "=" + nPair.getValue() + "&";		}		String url = DOMAIN + "torrents.php?" + s;		return url;	}	public static String getTaskCount() {		String url = DOMAIN + "torrents.php?action=get_task_count";		return url;	}	public static String getTorrentSearchList(String key, String last_torrent) {		String url = null;		try {			url = DOMAIN + "torrents.php?id="+last_torrent+"&search=" + URLEncoder.encode(key, "UTF-8");		} catch (UnsupportedEncodingException e) {			e.printStackTrace();		}		return url;	}	public static String getTorrentImg(long id, String size) {		String url;		url = DOMAIN + "torrent_pic_cache.php?id="+id+"&size="+size;		return url;	}	public static String getForumList() {		String url = DOMAIN + "forums.php";		return url;	}	public static String getNews() {		String url = DOMAIN + "forums.php?action=news";		return url;	}		public static String getTopicList(String forumid, long lastpost) {		String url = DOMAIN + "forums.php?forumid="+forumid+"&lastpost="+lastpost;		return url;	}		public static String getTorrentComments(String torrentid, int commentid) {		String url = null;		url = DOMAIN + "torrents.php?action=torrent_comment&id="+torrentid+"&commentid="+commentid;		return url;	}		public static String postComment(long torrentid, String body) {		String url = null;		try {			url = DOMAIN + "torrents.php?action=add_comment&id="+torrentid+"&body="+URLEncoder.encode(body, "UTF-8");		} catch (UnsupportedEncodingException e) {			e.printStackTrace();		}		return url;	}		public static String getTopicSearchList(String keyword, long lastpost) {		String url = DOMAIN + "forums.php?forumid=search&keyword="+keyword+"&lastpost="+lastpost;		return url;	}	public static String likePost(long postid) {		return DOMAIN + "forums.php?action=like&postid="+postid;	}		public static String getPostList(long topicid, long last_postid, String order, String author, long page) {		return DOMAIN + "forums.php?topicid="+topicid+"&last_postid="+last_postid+"&order="+order+"&author="+author+"&page="+page;	}	public static String getPostURL() {		String url = DOMAIN + "post.php";		return url;	}	public static String getMailURL(int page) {		String url = DOMAIN + "mail.php?page="+page;		return url;	}	public static String getPeerMailURL(long id, int page) {		String url = DOMAIN + "mail.php?id="+id+"&page="+page;		return url;	}	public static String getDelMailURL(long sender) {		String url = DOMAIN + "mail.php?action=del&sender="+sender;		return url;	}	public static String getContactsURL() {		String url = DOMAIN + "contacts.php";		return url;	}	public static String getAddContactURL(long userid) {		String url = DOMAIN + "contacts.php?action=add&id=" + userid;		return url;	}	public static String getSearchUsersURL(String name, long userid) {		String url = null;		try {			url = DOMAIN + "contacts.php?action=search&name=" + URLEncoder.encode(name, "UTF-8") + "&id=" + userid;		} catch (UnsupportedEncodingException e) {			e.printStackTrace();		}		return url;	}	public static String getAddMailURL(long receiver, String body) {		String url;		try {			url = DOMAIN + "mail.php?action=post&receiver="+receiver+"&body="+URLEncoder.encode(body, "UTF-8");			return url;		} catch (UnsupportedEncodingException e) {			// TODO Auto-generated catch block			e.printStackTrace();		}		return null;	}	public static String getPollURL() {		String url = DOMAIN + "poll.php";		return url;	}	public static String getCheckin(String action) {		String url = DOMAIN + "checkin.php?action=" + action;		return url;	}	public static String getIMDbImage(String dburl) {		String url = BASEURL + "imdb/images/" + dburl + ".jpg";		return url;	}		public static String getUploadURL() {		String url = DOMAIN + "upload.php";		return url;	}	public static String getLists() {		String url = DOMAIN + "list.php";		return url;	}	public static String getApps() {		String url = DOMAIN + "apps.php?sdk=" + Params.version;		return url;	}		public static String getHotSearchURL() {		String url = DOMAIN + "search.php?action=hotsearch";		return url;	}}	