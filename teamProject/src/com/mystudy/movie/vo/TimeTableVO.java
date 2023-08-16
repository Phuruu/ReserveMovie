package com.mystudy.movie.vo;
import java.util.*; 

public class TimeTableVO {
	private int timeId;
	private int theaterId;
	private int movieId;
	private String startTime;
	private int remainingSeats;
	
	public TimeTableVO() {
	}
	public TimeTableVO(int timeId, int theaterId, int movieId, String startTime, int remainingSeats) {
		this.timeId = timeId;
		this.theaterId = theaterId;
		this.movieId = movieId;
		this.startTime = startTime;
		this.remainingSeats = remainingSeats;
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
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getRemainingSeats() {
		return remainingSeats;
	}
	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	
}