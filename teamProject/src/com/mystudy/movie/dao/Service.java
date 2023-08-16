package com.mystudy.movie.dao;

import java.util.List;

import com.mystudy.movie.vo.CommentsVO;
import com.mystudy.movie.vo.MovieVO;
import com.mystudy.movie.vo.MyCommentsVO;
import com.mystudy.movie.vo.TicketVO;
import com.mystudy.movie.vo.TimeTableDateVO;
import com.mystudy.movie.vo.TimeTableVO;
import com.mystudy.movie.vo.UsersVO;
import com.mystudy.movie.vo.WatchVO;

import java.time.LocalDate;
import java.util.*;

public class Service {
   static DAO dao = null;
   static List<TimeTableVO> timeTableList = null;
   static List<MovieVO> movieList = null;

   static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {
      dao = new DAO();
      movieList = dao.selectAllMovie();
      firstPage();

   }

   public static void firstPage() {
      System.out.println("--------------------");
      System.out.println(" 1. 로그인\n 2. 회원 가입\n 3. 종료");
      System.out.println("--------------------");
      while (true) {
         System.out.print(">> ");
         int input = sc.nextInt();
         if (input == 1)
            loginUser();
         else if (input == 2)
            joinUser();
         else if (input == 3)
            System.exit(0);
         else
            System.out.println("잘못된 입력입니다. 다시 입력하세요");
      }
   }

   public static void afterLogin(UsersVO user) {
      System.out.println("\n--------------------");
      System.out.println(" 1. 마이페이지");
      System.out.println(" 2. 전체 영화");
      System.out.println(" 3. 로그아웃");
      System.out.println("--------------------");
      while (true) {
         System.out.print(">> ");
         int input = sc.nextInt();
         if (input == 1)
            myPage(user);
         else if (input == 2) {
            selectMovie(user);
         } else if (input == 3)
            firstPage();
         else
            System.out.println("잘못된 입력입니다. 다시 입력하세요");
      }
   }

   public static void watchList(UsersVO user) {
      List<WatchVO> watchList = dao.selectAllWatchByUser(user);
      
      System.out.println();
      for (WatchVO vo : watchList)
         vo.printFormat();
      System.out.println(" 1. 초기 화면  2. 종료 ");
      System.out.print(">> ");
      while (true) {
         int input = sc.nextInt();
         if (input == 1)
            afterLogin(user);
         else if (input == 2)
            System.exit(0);
         else
            System.out.println("잘못된 입력입니다. 다시 입력하세요");
      }

   }

   public static void myPage(UsersVO user) {
      System.out.println("\n---------------");
      
      System.out.println("아이디: " + user.getId() + "\n이름: " + user.getName() + "\n나이: " + user.getAge() + "\n가입일 "
            + user.getJoindate().substring(0, 10));
      System.out.println("\n---------------");
      System.out.println(" 1. 회원정보 \n 2. 예매 내역 \n 3. 내가 작성한 한줄평 보기 \n 4. 뒤로 가기");
      System.out.println("---------------\n");
      System.out.print(">> ");
      int input = sc.nextInt();
      while (true) {
         if (input == 1) {
            System.out.println("\n-----------------");
            System.out.println(" 1. 비밀번호변경 \n 2. 회원 탈퇴");
            System.out.println("-----------------\n");
            while (true) {
               System.out.print(">> ");
               int input2 = sc.nextInt();
               if (input2 == 1) {
                  updateUser(user);
               } else if (input2 == 2) {
                  deleteUser(user.getId());
               } else
                  System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
         } else if (input == 2)
            watchList(user);
         else if (input == 3) {
            seeMyComments(user);
         }else if( input ==4) {
            afterLogin(user);
         }else
            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
      }
   }

   public static void loginUser() {

      String id = "";

      while (true) {
         System.out.print("아이디 : ");
         id = sc.next();
         UsersVO user = dao.selectOneUsers(id);
         if (user == null) {
            System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
            continue;
         }
         while (true) {
            System.out.print("비밀번호 : ");
            String password = sc.next();
            if (user.getPassword().equals(password)) {
               System.out.println("\n " + user.getId() + " 로그인 성공!\n");
               break;
            } else {
               System.out.println("비밀번호를 다시 입력해주세요");
               continue;
            }
         }
         if (user.getId().equals("admin"))
            adminPage(user);
         else
            afterLogin(user);
         break;
      }
      return;
   }

   public static void updateUser(UsersVO user) {
      System.out.println("변경할 비밀번호를 입력해주세요");
      System.out.print(">> ");
      String newPassword = sc.next();
      dao.userUpdate(newPassword, user.getId());
      System.out.println("\n변경 완료!\n");
      afterLogin(user);
   }

   public static void selectTime(UsersVO user, MovieVO movie) {
      List<String> dates = dao.selectDateTime();
      System.out.println("---------------");
      for (int i = 0; i < dates.size(); i++) {
         System.out.println(" " + (i + 1) + "번 " + dates.get(i) + "\t");
      }
      System.out.println("---------------");
      System.out.println("예매할 날짜를 선택하세요 ");
      System.out.print(">> ");
      int inputDate = sc.nextInt();

      List<TimeTableDateVO> timeTableDateList = dao.selectTimeTableDate(dates.get(inputDate - 1));
      System.out.println(" ");
      boolean isEmpty = true;
      int cnt = 0;
      for (TimeTableDateVO vo : timeTableDateList) {

         if (vo.getTitle().equals(movie.getTitle())) {
            if (cnt++ == 0) {
               System.out.println("------------------------------------------------");
               System.out.println("번호\t영화제목\t\t시간\t\t  남은좌석\t상영관");

            }
            vo.printAll();
            isEmpty = false;
         }
      }
      if (isEmpty) {
         System.out.println("선택한 날짜에 영화가 없습니다. 다시선택하세요");
         selectTime(user, movie);
      } else {
         System.out.println("------------------------------------------------");
         System.out.println("원하는 시간을 선택하세요");
         System.out.print(">> ");
         int inputTimeid = sc.nextInt();

         TimeTableVO time = dao.selectOneTimetable(inputTimeid);

         System.out.println("인원수를 입력하세요");
         System.out.print(">> ");
         int count = sc.nextInt();
         if (count > time.getRemainingSeats()) {
            System.out.println("남아있는 좌석이 부족합니다.");
            System.out.println("1. 다시 예매하기  2. 종료");
            System.out.print(">>");
            int option2 = sc.nextInt();
            if (option2 == 1)
               selectMovie(user);
            else if (option2 == 2)
               System.exit(0);
         }
         TicketVO ticket = new TicketVO(user.getId(), time.getTimeId(), time.getStartTime(), movie.getTitle(),
               time.getTheaterId(), count, movie.getPrice());
         dao.updateTimetable(time, count);
         dao.insertTicket(ticket);

         System.out.println("\n예매 완료!\n");

         while (true) {
            System.out.println("1. 초기 화면" + "\t" + "2. 종료 ");
            System.out.print(">> ");
            int answer = sc.nextInt();

            if (answer == 1)
               afterLogin(user);
            else if (answer == 2)
               System.exit(0);
            else
               System.out.println("잘못된 입력입니다.");
         }
      }

   }

   public static void deleteUser(String userId) {
      UsersVO user = dao.selectOneUsers(userId);

      System.out.println("회원을 탈퇴하시겠습니까?" + "\t" + "1. 네 " + " 2.아니오");
      int answer = sc.nextInt();

      while (true) {
         if (answer == 1) {
            System.out.println("비밀번호를 입력해주세요.");
            String pw = sc.next();
            if (user.getPassword().equals(pw)) {
               dao.deleteUsers(userId);
               System.out.println("회원탈퇴를 성공했습니다.");
               firstPage();
               break;
            } else {
               System.out.println("비밀번호가 틀렸습니다");
               continue;
            }
         } else if (answer == 2) {
            System.out.println("회원탈퇴를 중단합니다.");
            afterLogin(user);
            break;
         }

      }

   }

   public static void joinUser() {
      System.out.println("\n사용할 아이디를 입력하세요");
      System.out.print(">> ");
      String inputId = sc.next();
      while (true) {
         UsersVO vo = dao.selectOneUsers(inputId);
         if (vo != null) { // 아이디가 사용중일경우
            System.out.println("중복된 아이디가 존재합니다. 다시 입력하세요");
            System.out.print(">> ");
            inputId = sc.next();
         } else
            break;
      }

      System.out.println("사용할 비밀번호를 입력하세요");
      System.out.print(">> ");
      String inputPw = sc.next();

      System.out.println("이름을 입력하세요");
      System.out.print(">> ");
      String inputName = sc.next();
      System.out.println("나이를 입력하세요");
      System.out.print(">> ");
      int inputAge = sc.nextInt();

      LocalDate now = LocalDate.now();
      String inputTime = now.toString();

      UsersVO user = new UsersVO(inputId, inputPw, inputName, inputAge, inputTime);

      dao.insertUsers(user);
      System.out.println("\n회원 가입 완료!\n");
      afterLogin(user);
      return;
   }

   public static void selectMovie(UsersVO user) {
      System.out.println("\n");
      for (MovieVO vo : movieList) {
         System.out.println(vo.printForm());
      }
      System.out.println();
      System.out.println("영화를 선택하세요");
      System.out.print(">>");
      int movieId = sc.nextInt();
      MovieVO movie = dao.selectOneMovie(movieId);
      if (user.getAge() < movie.getAgeRating()) {
         System.out.println();
         System.out.println(movie.getAgeRating() + "세 미만은 관람이 불가합니다.");
         System.out.println("1. 다시 선택하기 \t 2. 종료");
         int option3 = sc.nextInt();
         if (option3 == 1)
            selectMovie(user);
         else if (option3 == 2)
            System.exit(0);

      }
      System.out.println("\n---------------");
      System.out.printf(" %s를 선택하셨습니다.\n", movie.getTitle());
      System.out.println(" 1. 예매하기\n 2. 한줄평 보기");
      System.out.println("---------------");
      System.out.print(">>");
      int option = sc.nextInt();
      if (option == 1)
         selectTime(user, movie);
      else if (option == 2)
         selectCommentsByMovie(movie, user);

   }

   // 한줄평 전체 보기
   public static void selectCommentsByMovie(MovieVO movie, UsersVO user) {
      System.out.println("\n------------------------------------");
      List<CommentsVO> CommentsList = dao.selectComments(movie.getMovieId());
      for (CommentsVO vo : CommentsList) {
         System.out.print(movie.getTitle() + "\n");
         vo.printFormat();
      }
      System.out.println("------------------------------------");
      System.out.println(" 1. 한줄평 작성 2. 내가 작성한 한줄평 보기 3. 뒤로 가기 4. 초기화면 5. 종료 ");

      while (true) {
         System.out.print(">> ");
         int input = sc.nextInt();
         if (input == 1)
            insertComment(user, movie);
         else if (input == 2)
            selectMyCommentsByMovie(user, movie);
         else if (input == 3)
            selectMovie(user);
         else if (input == 4)
            afterLogin(user);
         else if (input == 5)
            System.exit(0);
         else
            System.out.println("잘못된 입력입니다. 다시 입력하세요");
      }
   }

   public static void insertComment(UsersVO user, MovieVO movie) {

      System.out.println("\n한줄평 작성할 영화: " + movie.getTitle());
      System.out.println("별점을 입력하세요(최대 10점)");
      System.out.print(">> ");
      int star = sc.nextInt();
      System.out.println("한줄평을 입력하세요");
      System.out.print(">> ");
      sc = new Scanner(System.in);
      String review = sc.nextLine();
      CommentsVO vo = new CommentsVO(1, movie.getMovieId(), user.getId(), star, review);
      dao.insertComment(vo);

      System.out.println("\n작성 완료!\n");
      System.out.println(" 1. 한줄평 보기 2. 초기화면  3. 종료 ");
      System.out.print(">> ");
      int input = sc.nextInt();
      if (input == 1)
         selectCommentsByMovie(movie, user);
      else if (input == 2)
         afterLogin(user);
      else if (input == 3)
         System.exit(0);
   }

   public static void adminPage(UsersVO user) {
      System.out.println("---------------");
      System.out.println(" *관리자 페이지");
      System.out.println("---------------");
      System.out.println(" 1. 일별 매출 조회 \n 2. 전체 매출 조회 \n 3. 로그아웃 \n 4. 종료");
      System.out.println("---------------");
      while (true) {
         System.out.print(">> ");
         int input = sc.nextInt();
         if (input == 1) {

            List<String> dates = dao.selectDateTime();
            for (int i = 0; i < dates.size(); i++) {
               System.out.println(i + 1 + "번 :" + dates.get(i));
            }
            System.out.println("조회할 날짜를 선택하세요");
            System.out.print(">> ");
            int selectDate = sc.nextInt();
            int sales1 = dao.selectSalesByDate(dates.get(selectDate - 1));
            System.out.println("\n" + dates.get(selectDate - 1) + " 매출: " + sales1 + "원\n");
            adminPage(user);

         }

         else if (input == 2) {
            int sales2 = dao.selectSalesAll();
            System.out.println("\n전체 매출: " + sales2 + "원\n");
            adminPage(user);
         } else if (input == 3) {
            firstPage();
         } else if (input == 4)
            System.exit(0);

         else
            System.out.println("잘못된 입력입니다. 다시 입력하세요");
      }
   }

   public static void selectMyCommentsByMovie(UsersVO user, MovieVO movie) {
         String userId = user.getId();
            int  movieId = movie.getMovieId();
            
            System.out.println("\n");
            List<CommentsVO> list = dao.selectMyCommentsByMovie(userId, movieId);
            boolean isEmpty = true;
            for (CommentsVO vo : list) {
               if (movie.getMovieId() == vo.getMovieId()) {
                  isEmpty= false;
                  vo.printFormat();
               }
            
            }
            if (isEmpty) {
               System.out.println("내가 작성한 한줄평이 존재하지 않습니다.");    
               selectCommentsByMovie(movie,user);
            } else {
               System.out.println("------------------------------");
               System.out.println(" 1. 내가 작성한 한줄평 삭제  2. 뒤로 가기");
               System.out.println("------------------------------");
               System.out.print(">> ");
               int review = sc.nextInt();
               
               if (review == 1) deleteComment(user,movie);
               else if (review == 2) selectCommentsByMovie(movie,user);
            }

   }

   public static void deleteComment(UsersVO user, MovieVO movie) {
      System.out.println("삭제할 한줄평의 번호를 입력하세요");
      System.out.print(">> ");
      int deletenum = sc.nextInt();
      dao.deleteComment(deletenum);
      System.out.println("\n한줄평이 삭제되었습니다!\n");

      selectCommentsByMovie(movie, user);
   }
   
   public static void deleteComment(UsersVO user) {
      System.out.println("삭제할 한줄평의 번호를 입력하세요");
      System.out.print(">> ");
      int deletenum = sc.nextInt();
      dao.deleteComment(deletenum);
      System.out.println("\n한줄평이 삭제되었습니다!\n");

      seeMyComments(user);
   }

   public static void seeMyComments(UsersVO user) {
      List<MyCommentsVO> list = dao.selectMyComment(user.getId());
      for (MyCommentsVO vo : list) {
         vo.printFormat();
      }

      System.out.println("------------------------------");
      System.out.println(" 1. 내가 작성한 한줄평 삭제  2. 뒤로 가기");
      System.out.println("------------------------------");
      System.out.print(">> ");
      int review = sc.nextInt();if (review == 1)
         deleteComment(user);
      else if (review == 2)
         myPage(user);

   }

}