--------------------------------------------------------
--  파일이 생성됨 - 월요일-2월-27-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table COMMENTS
--------------------------------------------------------

  CREATE TABLE "COMMENTS" 
   (	"COMMENT_ID" NUMBER(5,0), 
	"MOVIE_ID" NUMBER(5,0), 
	"ID" VARCHAR2(20 BYTE), 
	"STAR_RATING" NUMBER(3,0), 
	"REVIEW" VARCHAR2(300 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table MOVIE
--------------------------------------------------------

  CREATE TABLE "MOVIE" 
   (	"MOVIE_ID" NUMBER(5,0), 
	"TITLE" VARCHAR2(30 BYTE), 
	"GENRE" VARCHAR2(20 BYTE), 
	"STAR_RATING" NUMBER(3,1), 
	"AGE_RATING" NUMBER(10,0), 
	"OPENDATE" DATE, 
	"CLOSEDATE" DATE, 
	"PRICE" NUMBER(10,0), 
	"RUNNINGTIME" NUMBER(5,0)
   ) ;
--------------------------------------------------------
--  DDL for Table THEATER
--------------------------------------------------------

  CREATE TABLE "THEATER" 
   (	"THEATER_ID" NUMBER(5,0), 
	"SEATS" NUMBER(5,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TICKET
--------------------------------------------------------

  CREATE TABLE "TICKET" 
   (	"TICKET_ID" NUMBER(5,0), 
	"USER_ID" VARCHAR2(20 BYTE), 
	"TIME_ID" NUMBER(5,0), 
	"COUNTS" NUMBER(5,0)
   ) ;
--------------------------------------------------------
--  DDL for Table TIMETABLE
--------------------------------------------------------

  CREATE TABLE "TIMETABLE" 
   (	"TIME_ID" NUMBER(5,0), 
	"THEATER_ID" NUMBER(5,0), 
	"MOVIE_ID" NUMBER(5,0), 
	"START_TIME" DATE, 
	"REMAINING_SEATS" NUMBER(5,0)
   ) ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" 
   (	"ID" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"AGE" NUMBER(10,0), 
	"JOINDATE" DATE
   ) ;
REM INSERTING into COMMENTS
SET DEFINE OFF;
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (1,1,'myid1',7,'극장에서 볼 만한 이유가 있는 영화');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (2,2,'myid1',10,'제임스 카메룬 감독님.. 영화 만들어주셔서 너무 감사해요.. 타이타닉의 이야기를 세상에 알리고 싶었다는 감독님의 사명감과 애정이 정말 너무나 묻어나는 영화.. 영상미 연출 연기 완벽하지...');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (3,3,'myid1',5,'영화 재미없어요');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (4,4,'myid1',8,'스토리도 탄탄!!보는재미가 처음부터 끝까지 있어요');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (5,5,'myid1',10,'고통은 누군가에게는 영원히 상처로 남지만, 박시헌 선수처럼 끝까지 싸워 이겨낸 사람에게는 영광의 훈장이 된다.');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (6,1,'myid2',9,'스토리는 조금 예상가는 면이 없잖아 있었지만 영상 보는 내내 이건 미쳤다라는 말만 나옴');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (7,2,'myid2',10,'말해 뭐하나 아이맥스 영화값 제대로 뽑고 왔다');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (8,3,'myid2',8,' 드라마를 보지 않은 나에겐 그저 혼란하기만 했던...');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (9,4,'myid3',7,' 양자세계에서의 2시간은 너무 길었어요..');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (10,5,'myid3',9,'볼만했습니다 진선규배우 더 자주 봤으면 좋겠네요');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (11,1,'myid4',10,'이정도 영상에 진심이면 안볼수가 없다.');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (12,2,'myid4',10,'시간이 지날수록 멋진 영화가 있다. [타이타닉]이 바로 그런 영화다.');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (13,3,'myid4',7,'드라마와 이어지는 내용일줄 알았는데 다른 오리지널 스토리였어요');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (14,4,'myid4',4,'캐릭터만 바뀌었지 언젠가부터 비슷비슷한 배경에 갇혀있는 마블 시리즈. 앤트맨 특유의 개성을 하나도 못살렸다.');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (15,5,'myid4',10,'실화여서 더욱 감동적이었습니다.');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (16,1,'myid5',10,' 정말 재미있었고 끝나자마자 또 보고 싶어지군요^^ 네테이얌 최고!');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (17,2,'myid5',10,'드디어 이 영화를 극장에서 보게 되다니 감동 심하다');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (18,3,'myid5',5,'  극의 2/3 지점까지는 이해가 잘 됐는데 그 지점을 딱 넘어서는 순간부터 진짜 뭐라는 건지 모르겠음 ');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (19,4,'myid5',8,' 마블팬이여서 반가움에 8점 줍니다. 진입장벽이 확실히 높아졌어요. 디즈니플러스 로키와도 이어지네요.');
Insert into COMMENTS (COMMENT_ID,MOVIE_ID,ID,STAR_RATING,REVIEW) values (20,5,'myid5',8,' 가족끼리 보기 좋은 영화');
REM INSERTING into MOVIE
SET DEFINE OFF;
Insert into MOVIE (MOVIE_ID,TITLE,GENRE,STAR_RATING,AGE_RATING,OPENDATE,CLOSEDATE,PRICE,RUNNINGTIME) values (1,'아바타','SF/액션',8.8,12,to_date('23/02/10','RR/MM/DD'),to_date('23/03/02','RR/MM/DD'),12000,192);
Insert into MOVIE (MOVIE_ID,TITLE,GENRE,STAR_RATING,AGE_RATING,OPENDATE,CLOSEDATE,PRICE,RUNNINGTIME) values (2,'타이타닉','로맨스',9.7,15,to_date('23/02/16','RR/MM/DD'),to_date('23/03/03','RR/MM/DD'),9000,195);
Insert into MOVIE (MOVIE_ID,TITLE,GENRE,STAR_RATING,AGE_RATING,OPENDATE,CLOSEDATE,PRICE,RUNNINGTIME) values (3,'상견니','드라마',7.7,15,to_date('23/02/20','RR/MM/DD'),to_date('23/03/05','RR/MM/DD'),8000,107);
Insert into MOVIE (MOVIE_ID,TITLE,GENRE,STAR_RATING,AGE_RATING,OPENDATE,CLOSEDATE,PRICE,RUNNINGTIME) values (4,'앤트맨','모험/액션',8.4,12,to_date('23/02/24','RR/MM/DD'),to_date('23/02/28','RR/MM/DD'),10000,120);
Insert into MOVIE (MOVIE_ID,TITLE,GENRE,STAR_RATING,AGE_RATING,OPENDATE,CLOSEDATE,PRICE,RUNNINGTIME) values (5,'카운트','드라마',9.6,12,to_date('23/03/01','RR/MM/DD'),to_date('23/03/05','RR/MM/DD'),11000,109);
REM INSERTING into THEATER
SET DEFINE OFF;
Insert into THEATER (THEATER_ID,SEATS) values (1,12);
Insert into THEATER (THEATER_ID,SEATS) values (2,15);
Insert into THEATER (THEATER_ID,SEATS) values (3,20);
REM INSERTING into TICKET
SET DEFINE OFF;
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (6,'myid5',19,4);
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (7,'myid2',24,2);
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (1,'myid4',39,5);
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (2,'myid2',1,2);
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (3,'myid5',37,3);
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (4,'myid2',12,2);
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (5,'myid1',18,2);
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (8,'myid2',29,3);
Insert into TICKET (TICKET_ID,USER_ID,TIME_ID,COUNTS) values (9,'test2',40,1);
REM INSERTING into TIMETABLE
SET DEFINE OFF;
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (1,1,1,to_date('23/02/27','RR/MM/DD'),10);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (2,1,1,to_date('23/02/27','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (3,1,1,to_date('23/02/27','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (4,2,2,to_date('23/02/27','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (5,2,2,to_date('23/02/27','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (6,2,2,to_date('23/02/27','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (7,3,3,to_date('23/02/27','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (8,3,3,to_date('23/02/27','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (9,3,4,to_date('23/02/27','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (10,3,4,to_date('23/02/27','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (11,1,1,to_date('23/02/28','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (12,1,1,to_date('23/02/28','RR/MM/DD'),10);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (13,1,1,to_date('23/02/28','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (14,2,2,to_date('23/02/28','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (15,2,2,to_date('23/02/28','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (16,2,2,to_date('23/02/28','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (17,3,3,to_date('23/02/28','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (18,3,3,to_date('23/02/28','RR/MM/DD'),18);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (19,3,4,to_date('23/02/28','RR/MM/DD'),16);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (20,3,4,to_date('23/02/28','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (21,1,1,to_date('23/03/01','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (22,1,1,to_date('23/03/01','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (23,1,1,to_date('23/03/01','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (24,2,2,to_date('23/03/01','RR/MM/DD'),13);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (25,2,2,to_date('23/03/01','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (26,2,2,to_date('23/03/01','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (27,3,3,to_date('23/03/01','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (28,3,3,to_date('23/03/01','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (29,3,5,to_date('23/03/01','RR/MM/DD'),17);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (30,3,5,to_date('23/03/01','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (31,1,1,to_date('23/03/02','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (32,1,1,to_date('23/03/02','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (33,1,1,to_date('23/03/02','RR/MM/DD'),12);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (34,2,2,to_date('23/03/02','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (35,2,2,to_date('23/03/02','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (36,2,2,to_date('23/03/02','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (37,3,3,to_date('23/03/02','RR/MM/DD'),17);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (38,3,3,to_date('23/03/02','RR/MM/DD'),20);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (39,3,5,to_date('23/03/02','RR/MM/DD'),15);
Insert into TIMETABLE (TIME_ID,THEATER_ID,MOVIE_ID,START_TIME,REMAINING_SEATS) values (40,3,5,to_date('23/03/02','RR/MM/DD'),19);
REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (ID,PASSWORD,NAME,AGE,JOINDATE) values ('myid1','pw1','박미현',20,to_date('23/02/21','RR/MM/DD'));
Insert into USERS (ID,PASSWORD,NAME,AGE,JOINDATE) values ('myid2','pw2','김민선',17,to_date('23/02/02','RR/MM/DD'));
Insert into USERS (ID,PASSWORD,NAME,AGE,JOINDATE) values ('myid3','pw3','이성균',13,to_date('23/01/21','RR/MM/DD'));
Insert into USERS (ID,PASSWORD,NAME,AGE,JOINDATE) values ('myid4','pw4','차무식',16,to_date('23/01/23','RR/MM/DD'));
Insert into USERS (ID,PASSWORD,NAME,AGE,JOINDATE) values ('myid5','pw5','이승훈',16,to_date('23/02/21','RR/MM/DD'));
Insert into USERS (ID,PASSWORD,NAME,AGE,JOINDATE) values ('admin','adminpw','관리자',99,to_date('23/02/22','RR/MM/DD'));
Insert into USERS (ID,PASSWORD,NAME,AGE,JOINDATE) values ('test2','test2','test',13,to_date('23/02/27','RR/MM/DD'));
--------------------------------------------------------
--  Constraints for Table TICKET
--------------------------------------------------------

  ALTER TABLE "TICKET" ADD PRIMARY KEY ("TICKET_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table COMMENTS
--------------------------------------------------------

  ALTER TABLE "COMMENTS" ADD PRIMARY KEY ("COMMENT_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table TIMETABLE
--------------------------------------------------------

  ALTER TABLE "TIMETABLE" ADD PRIMARY KEY ("TIME_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table MOVIE
--------------------------------------------------------

  ALTER TABLE "MOVIE" ADD PRIMARY KEY ("MOVIE_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table THEATER
--------------------------------------------------------

  ALTER TABLE "THEATER" ADD PRIMARY KEY ("THEATER_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" ADD PRIMARY KEY ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table COMMENTS
--------------------------------------------------------

  ALTER TABLE "COMMENTS" ADD CONSTRAINT "MOVIE_COMMENTS_FK" FOREIGN KEY ("MOVIE_ID")
	  REFERENCES "MOVIE" ("MOVIE_ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "COMMENTS" ADD CONSTRAINT "USERS_COMMENTS_FK" FOREIGN KEY ("ID")
	  REFERENCES "USERS" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TICKET
--------------------------------------------------------

  ALTER TABLE "TICKET" ADD CONSTRAINT "TICKET_TIME_FK" FOREIGN KEY ("TIME_ID")
	  REFERENCES "TIMETABLE" ("TIME_ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "TICKET" ADD CONSTRAINT "TICKET_USER_FK" FOREIGN KEY ("USER_ID")
	  REFERENCES "USERS" ("ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TIMETABLE
--------------------------------------------------------

  ALTER TABLE "TIMETABLE" ADD CONSTRAINT "TIMETABLE_MOVIE_FK" FOREIGN KEY ("MOVIE_ID")
	  REFERENCES "MOVIE" ("MOVIE_ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "TIMETABLE" ADD CONSTRAINT "TIMETABLE_THEATER_FK" FOREIGN KEY ("THEATER_ID")
	  REFERENCES "THEATER" ("THEATER_ID") ON DELETE CASCADE ENABLE;
