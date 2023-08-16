package com.mystudy.movie.vo;

public class TicketVO {
	private int ticketId;
	private String userId;
	private int timeId;
	private String startTime;
	private String title;
	private int theaterId;
	private int count;
	private int price;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public TicketVO( String userId, int timeId, String startTime, String title, int theaterId,int count, int price) {
		this.userId = userId;
		this.timeId = timeId;
		this.startTime = startTime;
		this.title = title;
		this.theaterId = theaterId;
		this.count= count;
		this.price = price;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTimeId() {
		return timeId;
	}
	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
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
	
}
