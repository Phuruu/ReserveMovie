package com.mystudy.movie.vo;

public class CommentsVO {
   int commentId;
   int movieId;
   String id;
   int starRating;
   String review;
   
   
   public CommentsVO() {
   }

   public CommentsVO(int commentId, int movieId, String id, int starRating, String review) {
	   this.commentId = commentId;
	   this.movieId = movieId;
      this.id = id;
      this.starRating = starRating;
      this.review = review;
   }

   public int getCommentId() {
      return commentId;
   }

   public void setCommentId(int commentId) {
      this.commentId = commentId;
   }

   public int getMovieId() {
      return movieId;
   }

   public void setMovieId(int movieId) {
      this.movieId = movieId;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
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

   @Override
   public String toString() {
      return "CommentsVO [commentId=" + commentId + ", movieId=" + movieId + ", id=" + id + ", starRating="
            + starRating + ", review=" + review + "]";
   }
   public void printFormat() {
	      StringBuilder sb = new StringBuilder();
	      for(int i=1;i<=starRating;i++) {
	         if(i%2 == 0)
	            sb.append("★");
	      }if(starRating %2 !=0)
	         sb.append("☆");
	   
	      System.out.printf( "%d. 작성자: %s  %6s\n",commentId, id,sb);
	      System.out.printf("  :%s",review);
	      System.out.println("\n");
	   }

   
   

}