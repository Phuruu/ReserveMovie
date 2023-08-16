package com.mystudy.movie.vo;
/*----
예매내역에서 출력해야 할것
1. 영화이름
2. 상영관정보
3. 인원
4. 영화시작시간
5. 러닝타임
6. 영화가격
*/
public class WatchVO {
	private String title;
	private int theaterId;
	private int count;
	private String startTime;
	private int runningTime;
	private int price;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public WatchVO() {
	}
	
	public WatchVO(String title, int theaterId, int count, String startTime, int runningTime, int price) {
		this.title = title;
		this.theaterId = theaterId;
		this.count = count;
		this.startTime = startTime;
		this.runningTime = runningTime;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	@Override
	public String toString() {
		return "WatchVO [title=" + title + ", theaterId=" + theaterId + ", count=" + count + ", startTime=" + startTime
				+ ", runningTime=" + runningTime + ", price=" + price + "]";
	}
	
	public void printFormat() {
		String y = startTime.substring(0,4);
		String m = startTime.substring(5,7);
		String d = startTime.substring(8,10);
		String h = startTime.substring(11,13);
		String mi = startTime.substring(14,16);
		System.out.printf("영화제목: %s [%d상영관]  인원:%d, 결제금액: %d원\n", title,theaterId,count,count*price);
		System.out.printf("관람날짜 및 시간: [%s년%s월%s일 %s시%s분]   상영시간:[%d분]\n",y,m,d,h,mi,runningTime);
		System.out.println("-------------------------------------------------");
	}
	
	
}

