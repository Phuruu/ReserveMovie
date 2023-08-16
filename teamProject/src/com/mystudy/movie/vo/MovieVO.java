package com.mystudy.movie.vo;

public class MovieVO {
	int movieId;
	String title;
	String genre;
	double starRating;
	int ageRating;
	String openDate;
	String closeDate;
	int price;
	int runningtime;
	
	public MovieVO() {
	}

	public MovieVO(int movieId, String title, String genre, double starRating, int ageRating, String openDate,
			String closeDate, int price, int runningtime) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.starRating = starRating;
		this.ageRating = ageRating;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.price = price;
		this.runningtime = runningtime;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getStarRating() {
		return starRating;
	}

	public void setStarRating(double starRating) {
		this.starRating = starRating;
	}

	public int getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRunningtime() {
		return runningtime;
	}

	public void setRunningtime(int runningtime) {
		this.runningtime = runningtime;
	}

	@Override
	public String toString() {
		return "MovieVO [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", starRating=" + starRating
				+ ", ageRating=" + ageRating + ", openDate=" + openDate + ", closeDate=" + closeDate + ", price="
				+ price + ", runningtime=" + runningtime + "]";
	}
	
	
	public String printForm() {
        return movieId + ". 제목: " + title + "\t장르: " + genre + "\t별점: " + starRating + "\t관람연령: " + ageRating + "세\n" 
              + "\n" + "개봉일: " + openDate.substring(0, 10) 
              + "\t마감일: " + closeDate.substring(0, 10) + "\t가격: " + price + "원 \t" 
              + "상영시간: " + runningtime + "분\n -------------------------------------------------------------------------------------" ;
     }
	

}
