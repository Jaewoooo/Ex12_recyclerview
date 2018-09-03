package kr.co.dothome.jkl421.ex12_recyclerview;

public class MemberModel {
	private String id;
	private String userId;
	private String userName;
	private String userPic;
	private String wDate;
	public static final String PIC_BASEURL = "http://motive.co.kr/images/";

	public MemberModel(String id, String userId, String userName, String userPic, String wDate) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.userPic = userPic;
		this.wDate = wDate;
	}

	public String getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPic() {
		return userPic;
	}

	public String getwDate() {
		return wDate;
	}
}
