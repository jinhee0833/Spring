>>>>> /WEB-INF/doc/reply_o.sql
 
1) 댓글 테이블
CREATE TABLE reply(
  replyno      NUMBER(10)    NOT NULL PRIMARY KEY, -- 댓글 번호
  content      VARCHAR2(300) NOT NULL,             -- 댓글 내용 
  passwd       VARCHAR2(15)  NOT NULL,             -- 패스워드  
  rdate        Date          NOT NULL,             -- 등록일
  mediano      NUMBER(7)     NULL                  -- 미디어 번호
);
 
 
2) media 테이블의 데이터 확인
SELECT mediano, title, poster, filename, filesize, mview, mediagroupno FROM media;
 
 MEDIANO TITLE      POSTER        FILENAME      FILESIZE MVIEW MEDIAGROUPNO
 ------- ---------- ------------- ------------- -------- ----- ------------
       8 mp3        (0)bbabba.jpg (0)bbabba.mp3  7395678 Y         0
      10 비딱하게       Crooked.jpg   Crooked.mp3   10055724 Y     1
      12 mp3        IDoIDo.jpg    IDoIDo.mp3     8716442 Y         3
       4 LaSong - 비 poster.jpg    lasong.mp3       15000 Y        1
       5 LaSong - 비 poster.jpg    lasong.mp3       15000 Y        1
       6 LaSong - 비 poster.jpg    lasong.mp3       15000 Y        1
       7 mp3        bbabba.jpg    bbabba.mp3     7395678 Y         0
       9 mp3        (1)bbabba.jpg (1)bbabba.mp3  7395678 Y         1
      11 mp3        gguri.jpg     gguri.mp3      7171584 Y         2
 
      
      
3) media 테이블에 데이터 추가
INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'좋은 음악 입니다.', '1234', sysdate, 10);
 
INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'좋은 음악 입니다.', '1234', sysdate, 10);
 
INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'좋은 음악 입니다.', '1234', sysdate, 10);
 
 
 
4) 목록 출력
SELECT replyno, content, passwd, rdate, mediano
FROM reply
WHERE mediano = 10
ORDER BY replyno DESC;
 
 REPLYNO CONTENT    PASSWD RDATE                 MEDIANO
 ------- ---------- ------ --------------------- -------
       3 좋은 음악 입니다. 1234   2014-04-22 17:08:47.0      10
       2 좋은 음악 입니다. 1234   2014-04-22 17:08:46.0      10
       1 좋은 음악 입니다. 1234   2014-04-22 17:08:45.0      10
 
       