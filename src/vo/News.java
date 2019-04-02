package vo;

public class News {
	int NewsID;
	String NewsTitle;
	String NewsContent;
	String NewsTime;
	String AdminName;
	public int getNewsID() {
		return NewsID;
	}
	public void setNewsID(int newsID) {
		NewsID = newsID;
	}
	public String getNewsTitle() {
		return NewsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}
	public String getNewsContent() {
		return NewsContent;
	}
	public void setNewsContent(String newsContent) {
		NewsContent = newsContent;
	}
	public String getNewsTime() {
		return NewsTime;
	}
	public void setNewsTime(String newsTime) {
		NewsTime = newsTime;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
}
