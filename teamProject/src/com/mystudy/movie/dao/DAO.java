package com.mystudy.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.movie.vo.CommentsVO;
import com.mystudy.movie.vo.MovieVO;
import com.mystudy.movie.vo.MyCommentsVO;
import com.mystudy.movie.vo.TicketVO;
import com.mystudy.movie.vo.TimeTableDateVO;
import com.mystudy.movie.vo.TimeTableVO;
import com.mystudy.movie.vo.UsersVO;
import com.mystudy.movie.vo.WatchVO;

/**
 * @author 이성균 박미현 김민선
 *
 */
public class DAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String URL = "jdbc:oracle:thin:@192.168.18.21:1521:xe";

	private static final String USER = "MOVIE";
	private static final String PASSWORD = "moviepw";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] JDBC 드라이버 로딩 실패!!!");
		}
	}

	public int updateTimetable(TimeTableVO vo, int count) {
		int result = 0;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TIMETABLE");
			sql.append("   SET REMAINING_SEATS =  ?"); // 1
			sql.append(" WHERE TIME_ID = ? "); // 2
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, vo.getRemainingSeats() - count);
			pstmt.setInt(2, vo.getTimeId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}

		return result;
	}

	public int insertTicket(TicketVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TICKET ");
			sql.append("       (TICKET_ID,USER_ID,TIME_ID,COUNTS) ");
			sql.append("VALUES ((SELECT NVL(MAX(TICKET_ID),0)+1 FROM TICKET), ?, ?,?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getUserId());
			pstmt.setInt(2, vo.getTimeId());
			pstmt.setInt(3, vo.getCount());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			result = -1;
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}

	public int insertUsers(UsersVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO USERS ");
			sql.append("       (ID,PASSWORD,NAME,AGE,JOINDATE) ");
			sql.append("VALUES (?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getJoindate());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			result = -1;
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}

	public TimeTableVO selectOneTimetable(TimeTableVO time) {
		return selectOneTimetable(time.getTimeId());
	}

	public TimeTableVO selectOneTimetable(int id) {
		TimeTableVO vo = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT TIME_ID, THEATER_ID, MOVIE_ID, START_TIME,REMAINING_SEATS");
			sql.append("  FROM TIMETABLE ");
			sql.append(" WHERE TIME_ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new TimeTableVO(rs.getInt("TIME_ID"), rs.getInt("THEATER_ID"), rs.getInt("MOVIE_ID"),
						rs.getString("START_TIME"), rs.getInt("REMAINING_SEATS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return vo;
	}

	public UsersVO selectOneUsers(UsersVO users) {
		return selectOneUsers(users.getId());
	}

	public UsersVO selectOneUsers(String id) {
		UsersVO vo = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

		
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID,PASSWORD,NAME,AGE,JOINDATE");
			sql.append("  FROM USERS ");
			sql.append(" WHERE ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new UsersVO(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"), rs.getInt("AGE"),
						rs.getString("JOINDATE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return vo;
	}

	public List<WatchVO> selectAllWatchByUser(UsersVO user){
		List<WatchVO> list = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT M.TITLE, T.THEATER_ID, TK.COUNTS, T.START_TIME, M.RUNNINGTIME, M.PRICE");
			sql.append("  FROM TIMETABLE T JOIN TICKET TK ");
			sql.append("  ON TK.TIME_ID = T.TIME_ID ");
			sql.append("  JOIN MOVIE M ");
			sql.append("  ON M.MOVIE_ID = T.MOVIE_ID ");
			sql.append(" WHERE TK.USER_ID = ? ");
			sql.append(" ORDER BY T.START_TIME ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			
			rs = pstmt.executeQuery();
			list = new ArrayList<WatchVO>();
			while (rs.next()) {
				WatchVO vo = new WatchVO(
						rs.getString("TITLE"), 
						rs.getInt("THEATER_ID"),
						rs.getInt("COUNTS"), 
						rs.getString("START_TIME"),
						rs.getInt("RUNNINGTIME"),
						rs.getInt("PRICE"));
				list.add(vo);
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}
	
	public List<TimeTableDateVO> selectTimeTableDate(String date) {
		List<TimeTableDateVO> list = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT T.TIME_ID, T.THEATER_ID, M.TITLE, T.START_TIME, T.REMAINING_SEATS");
			sql.append("  FROM TIMETABLE T JOIN MOVIE M ");
			sql.append("  ON T.MOVIE_ID = M.MOVIE_ID ");
			sql.append(" WHERE T.START_TIME BETWEEN to_date(?) AND to_date(?)+1 ");
			sql.append(" ORDER BY T.START_TIME ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, date); // Date format = 23/2/28
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			list = new ArrayList<TimeTableDateVO>();
			while (rs.next()) {
				TimeTableDateVO vo = new TimeTableDateVO(rs.getInt("TIME_ID"), rs.getInt("THEATER_ID"),
						rs.getString("TITLE"), rs.getString("START_TIME"), rs.getInt("REMAINING_SEATS"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}

	public MovieVO selectOneMovie(int id) {
		MovieVO vo = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append(
					"SELECT MOVIE_ID, TITLE, GENRE, STAR_RATING, AGE_RATING, OPENDATE, CLOSEDATE, PRICE, RUNNINGTIME ");
			sql.append(" FROM MOVIE");
			sql.append(" WHERE MOVIE_ID = ?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new MovieVO(rs.getInt("MOVIE_ID"), rs.getString("TITLE"), rs.getString("GENRE"),
						rs.getDouble("STAR_RATING"), rs.getInt("AGE_RATING"), rs.getString("OPENDATE"),
						rs.getString("CLOSEDATE"), rs.getInt("PRICE"), rs.getInt("RUNNINGTIME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return vo;

	}

	public List<MovieVO> selectAllMovie() {
		List<MovieVO> list = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append(
					"SELECT MOVIE_ID, TITLE, GENRE, STAR_RATING, AGE_RATING, OPENDATE, CLOSEDATE, PRICE, RUNNINGTIME");
			sql.append("  FROM MOVIE ");
			sql.append(" ORDER BY MOVIE_ID ");
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			list = new ArrayList<MovieVO>();
			while (rs.next()) {
				MovieVO vo = new MovieVO(rs.getInt("MOVIE_ID"), rs.getString("TITLE"), rs.getString("GENRE"),
						rs.getDouble("STAR_RATING"), rs.getInt("AGE_RATING"), rs.getString("OPENDATE"),
						rs.getString("CLOSEDATE"), rs.getInt("PRICE"), rs.getInt("RUNNINGTIME"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}

	public List<UsersVO> selectAllUsers() {
		List<UsersVO> list = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, PASSWORD, NAME, AGE, JOINDATE");
			sql.append("  FROM USERS ");
			sql.append(" ORDER BY ID ");
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			list = new ArrayList<UsersVO>();
			while (rs.next()) {
				UsersVO vo = new UsersVO(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getInt("AGE"), rs.getString("JOINDATE"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}

	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// 5. 클로징 처리에 의한 자원 반납
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close(Connection conn, PreparedStatement pstmt) {
		// 5. 클로징 처리에 의한 자원 반납
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUsers(String id) {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "DELETE FROM USERS WHERE ID = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt);
		}

	}

	public void userUpdate(String newPassword, String id) {

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE USERS ");
			sql.append("SET PASSWORD = ? ");
			sql.append("WHERE ID = ?");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, newPassword);
			pstmt.setString(2, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
	}
	public int insertComment(CommentsVO vo) {
	      int result = 0;
	      
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         StringBuilder sql = new StringBuilder();
	         sql.append("INSERT INTO COMMENTS ");
	         sql.append("       (COMMENT_ID, MOVIE_ID, ID, STAR_RATING, REVIEW) ");
	            sql.append(" VALUES ((SELECT NVL(MAX(COMMENT_ID),0)+1 FROM COMMENTS), ?, ?, ?, ?)");
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setInt(1, vo.getMovieId());
	         pstmt.setString(2, vo.getId());
	         pstmt.setInt(3, vo.getStarRating());
	         pstmt.setString(4, vo.getReview());
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt);
	      }
	      return result;

	   }
	
	public List<CommentsVO> selectComments(int movieId) {
	      CommentsVO vo = null;
	      List<CommentsVO> list = null;
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         StringBuilder sql = new StringBuilder();
	         sql.append("SELECT COMMENT_ID, MOVIE_ID, ID, STAR_RATING, REVIEW ");
	         sql.append("   FROM COMMENTS ");
	         sql.append("WHERE MOVIE_ID = ?");
	         sql.append("  ORDER BY COMMENT_ID");
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setInt(1, movieId);
	         rs = pstmt.executeQuery();
	         
	   
	         list = new ArrayList<CommentsVO>();
	         while (rs.next()) {
	            vo = new CommentsVO (
	                  rs.getInt("COMMENT_ID"), 
	                  rs.getInt("MOVIE_ID"), 
	                  rs.getString("ID"),
	                  rs.getInt("STAR_RATING"), 
	                  rs.getString("REVIEW")); 
	               
	               list.add(vo);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt, rs);
	      }
	      return list;
	      
	   }
	public List<String> selectDateTime(){
		List<String> list = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();

			sql.append("SELECT DISTINCT(TO_CHAR(START_TIME,'YY-MM-DD')) as DATES FROM TIMETABLE");
			sql.append(" ORDER BY DATES");
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(rs.getString("DATES"));
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}
	
	public int selectSalesByDate(String date) {
		int ret = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT SUM(TI.COUNTS*M.PRICE) AS SUMP ");
			sql.append(" FROM TICKET TI JOIN TIMETABLE TL ON tl.time_id = ti.time_id ");
			sql.append("     JOIN MOVIE M  ON M.MOVIE_ID = TL.MOVIE_ID ");
			sql.append(" WHERE TL.START_TIME BETWEEN TO_DATE(?) AND TO_DATE(?)+1");
			
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, date);
			pstmt.setString(2, date);

			rs = pstmt.executeQuery();

			// 4. SQL 실행 결과에 대한 처리
			// - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			if (rs.next()) {
				ret = rs.getInt("SUMP");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt, rs);
		}

		return ret;
	}
	
	public int selectSalesAll() {
		int ret = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT SUM(TI.COUNTS*M.PRICE) AS SUMP ");
			sql.append(" FROM TICKET TI JOIN TIMETABLE TL ON tl.time_id = ti.time_id ");
			sql.append("     JOIN MOVIE M  ON M.MOVIE_ID = TL.MOVIE_ID ");
			
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			// 4. SQL 실행 결과에 대한 처리
			// - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			if (rs.next()) {
				ret = rs.getInt("SUMP");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt, rs);
		}

		return ret;
	}
	
	public void deleteComment(int commentId) {
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         StringBuilder sql = new StringBuilder();
	         sql.append("DELETE FROM COMMENTS "); 
	         sql.append(" WHERE COMMENT_ID = ?");
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setInt(1, commentId);
	         
	         pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt);
	      }
	   }

	   public List<CommentsVO> selectMyCommentsByMovie(String userId, int movieId) {
	      List<CommentsVO> list = null;
	      try {
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         StringBuilder sql = new StringBuilder();
	         sql.append("SELECT COMMENT_ID, MOVIE_ID, ID, STAR_RATING, REVIEW ");
	         sql.append(" FROM COMMENTS "); 
	         sql.append(" WHERE ID = ?");
	         sql.append("ORDER BY COMMENT_ID");
	         pstmt = conn.prepareStatement(sql.toString());
	         
	         pstmt.setString(1, userId);
	         
	         rs = pstmt.executeQuery();
	         
	         list = new ArrayList<CommentsVO>();
	         while(rs.next()) {
	            CommentsVO vo = new CommentsVO(
	                  rs.getInt("COMMENT_ID"),
	                  rs.getInt("MOVIE_ID"),
	                  rs.getString("ID"),
	                  rs.getInt("STAR_RATING"),
	                  rs.getString("REVIEW"));
	            list.add(vo);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(conn, pstmt, rs);
	      }
	      return list;
	   }
	   
	   public List<MyCommentsVO> selectMyComment(String userId) {
		      List<MyCommentsVO> list = null;
		      try {
		         conn = DriverManager.getConnection(URL, USER, PASSWORD);
		         
		         StringBuilder sql = new StringBuilder();
		         sql.append("SELECT C.COMMENT_ID, M.TITLE, C.STAR_RATING, C.REVIEW");
		         sql.append(" FROM MOVIE M JOIN COMMENTS C ON M.MOVIE_ID = C.MOVIE_ID "); 
		         sql.append(" WHERE C.ID = ?");
		         sql.append(" ORDER BY C.COMMENT_ID ");
		         pstmt = conn.prepareStatement(sql.toString());
		         
		         pstmt.setString(1, userId);
		         
		         rs = pstmt.executeQuery();
		         
		         list = new ArrayList<MyCommentsVO>();
		         while(rs.next()) {
		            MyCommentsVO vo = new MyCommentsVO(
		                  rs.getInt("COMMENT_ID"),
		                  rs.getString("TITLE"),
		                  rs.getInt("STAR_RATING"),
		                  rs.getString("REVIEW"));
		            list.add(vo);
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(conn, pstmt, rs);
		      }
		      return list;
		   }
	   
}
