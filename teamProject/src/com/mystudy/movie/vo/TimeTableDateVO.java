package com.mystudy.movie.vo;

public class TimeTableDateVO {
	private int timeId;
	private int theaterId;
	private String title;
	private String time;
	private int remainingSeats;
	public TimeTableDateVO(int timeId, int theaterId, String title, String time, int remainingSeats) {
		this.timeId = timeId;
		this.theaterId = theaterId;
		this.title = title;
		this.time = time;
		this.remainingSeats = remainingSeats;
	}
	public TimeTableDateVO() {
	}
	public int getTimeId() {
		return timeId;
	}
	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRemainingSeats() {
		return remainingSeats;
	}
	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	
	public void printAll() {
		
		System.out.println(timeId+"\t"+  title +"\t"+time.substring(0,16)+"\t"+remainingSeats +"\t"+theaterId+ "상영관");
	}
}
