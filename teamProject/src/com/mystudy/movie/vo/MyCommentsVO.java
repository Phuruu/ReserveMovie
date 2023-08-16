package com.mystudy.movie.vo;

public class MyCommentsVO {
	private int commentId;
	private String title;
	private int starRating;
	private String review;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public MyCommentsVO(int commentId, String title, int starRating, String review) {
		this.commentId = commentId;
		this.title = title;
		this.starRating = starRating;
		this.review = review;
	}
	public MyCommentsVO() {
	}
	
	public void printFormat() {
	      StringBuilder sb = new StringBuilder();
	      for(int i=1;i<=starRating;i++) {
	         if(i%2 == 0)
	            sb.append("★");
	      }if(starRating %2 !=0)
	         sb.append("☆");
	   
	      System.out.printf( "%d.   %6s\n",commentId,title ,sb);
	      System.out.printf("  :%s",review);
	      System.out.println("\n");
	   }
	
	
}
