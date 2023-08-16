DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE MOVIE CASCADE CONSTRAINTS;
DROP TABLE THEATER CASCADE CONSTRAINTS;
DROP TABLE TIMETABLE CASCADE CONSTRAINTS;
DROP TABLE TICKET_LIST CASCADE CONSTRAINTS;

CREATE TABLE USERS(
    ID VARCHAR2(20) PRIMARY KEY,
    PASSWORD VARCHAR2(20),
    NAME VARCHAR2(20),
    AGE NUMBER(10),
    JOINDATE DATE
);

CREATE TABLE MOVIE(
    MOVIE_ID NUMBER(5) PRIMARY KEY,
    TITLE VARCHAR2(30),
    GENRE VARCHAR2(20),
    STAR_RATING NUMBER(3,1),
    AGE_RATING NUMBER(10)
);

--상영관 정보
CREATE TABLE THEATER(
    THEATER_ID NUMBER(5) PRIMARY KEY,
    TIME_FK NUMBER(5),
    SEATS NUMBER(5)
);

-- 상영 테이블
CREATE TABLE TIMETABLE(
    TIME_ID NUMBER(5) PRIMARY KEY,
    START_TIME VARCHAR2(10),
    END_TIME VARCHAR2(10),
    REMAINING_SEATS NUMBER(5),
    MOVIE_FK NUMBER(5),
    THEATER_FK NUMBER(5),
    CONSTRAINT TIMETABLE_MOVIE_FK FOREIGN KEY (MOVIE_FK)
    REFERENCES MOVIE(MOVIE_ID) ON DELETE CASCADE,
    CONSTRAINT TIMETABLE_THEATER_FK FOREIGN KEY (THEATER_FK)
    REFERENCES THEATER(THEATER_ID) ON DELETE CASCADE
);
    
-- 고객들이 산 영화내역
CREATE TABLE TICKET_LIST(
    TICKET_ID NUMBER(5) PRIMARY KEY,
    USER_FK VARCHAR2(20),
    TIME_FK NUMBER(5),
    CONSTRAINT TICKET_USER_FK FOREIGN KEY (USER_FK)
    REFERENCES USERS(ID) ON DELETE CASCADE,
    CONSTRAINT TICKET_TIME_FK FOREIGN KEY (TIME_FK)
    REFERENCES TIMETABLE(TIME_ID) ON DELETE CASCADE
);

