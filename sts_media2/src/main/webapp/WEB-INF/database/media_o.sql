1. SQL
>>>>> /sts_media/src/main/webapp/WEB-INF/doc/media_o.sql
 
1) ���̺� ����
DROP TABLE reply;
DROP TABLE media;
DROP TABLE mediagroup;
 
 
2) mp3, mp4 �׷��� ���̺�
CREATE TABLE mediagroup(
  mediagroupno NUMBER(7)     NOT NULL PRIMARY KEY, -- �׷� ��ȣ
  title        VARCHAR2(100) NOT NULL -- �׷� ����
);
 
 
3) ������ ���̺�
CREATE TABLE media(
  mediano      NUMBER(7)     NOT NULL PRIMARY KEY, -- �̵�� ��ȣ
  title        VARCHAR2(300) NOT NULL,             -- ����
  rdate        DATE          NOT NULL,             -- �����
  poster                     VARCHAR2(50) DEFAULT 'poster.jpg' NOT NULL, -- ������
  filename                   VARCHAR2(100) NOT NULL,  -- ���ϸ�
  filesize                   NUMBER(10)   DEFAULT 0 NOT NULL,   -- ���� ������
  mview                      CHAR(1)      DEFAULT 'Y' NOT NULL, -- ��� ���
  mediagroupno               NUMBER(7)    NULL       -- �׷� ��ȣ
);
 
 
4) ��� ���̺�
CREATE TABLE reply(
  replyno      NUMBER(10)    NOT NULL PRIMARY KEY, -- ��� ��ȣ
  content      VARCHAR2(300) NOT NULL,             -- ��� ���� 
  passwd       VARCHAR2(15)  NOT NULL,             -- �н�����  
  rdate        Date          NOT NULL,             -- �����
  mediano      NUMBER(7)     NULL                  -- �̵�� ��ȣ
);
 

1. ���
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - ��', sysdate, 'poster.jpg', 'lasong.mp3', 15000, 'Y', 1);
 
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - ��', sysdate, 'poster.jpg', 'lasong.mp3', 15000, 'Y', 1);
 
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - ��', sysdate, 'poster.jpg', 'lasong.mp3', 15000, 'Y', 1);
 
 
2. ���
SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno
FROM media
WHERE mediagroupno = 1
ORDER BY mediano DESC;
 
 MEDIANO TITLE      RDATE                 POSTER     FILENAME   FILESIZE MVIEW MEDIAGROUPNO
 ------- ---------- --------------------- ---------- ---------- -------- ----- ------------
       3 LaSong - �� 2014-04-17 18:34:10.0 poster.jpg lasong.mp3    15000 Y                1
       2 LaSong - �� 2014-04-17 18:34:08.0 poster.jpg lasong.mp3    15000 Y                1
       1 LaSong - �� 2014-04-17 18:33:43.0 poster.jpg lasong.mp3    15000 Y                1

       
 
       
SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno
FROM media
WHERE mediano=1;
 
 MEDIANO TITLE      RDATE                 POSTER     FILENAME   FILESIZE MVIEW MEDIAGROUPNO
 ------- ---------- --------------------- ---------- ---------- -------- ----- ------------
       1 LaSong - �� 2014-04-17 18:33:43.0 poster.jpg lasong.mp3    15000 Y                1
    
       

UPDATE media
SET title=?, poster=?, filename=?, filesize=?
WHERE mediano=? 
      

DELETE FROM media
WHERE mediano=? 


       

