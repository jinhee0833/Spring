
DROP TABLE reply;
DROP TABLE media;
DROP TABLE mediagroup;
 
CREATE TABLE mediagroup(
  mediagroupno NUMBER(7)     NOT NULL PRIMARY KEY, 
  title        VARCHAR2(50) NOT NULL 
);
 

CREATE TABLE media(
  mediano      NUMBER(7)     NOT NULL PRIMARY KEY, 
  title        VARCHAR2(70) NOT NULL,             
  rdate        DATE          NOT NULL,             
  poster                     VARCHAR2(50) DEFAULT 'poster.jpg' NOT NULL, 
  filename                   VARCHAR2(70) NOT NULL,  
  filesize                   NUMBER(10)   DEFAULT 0 NOT NULL,  
  mview                      CHAR(1)      DEFAULT 'Y' NOT NULL, 
  mediagroupno               NUMBER(7)    NULL       
);
 
 
CREATE TABLE reply(
  replyno      NUMBER(10)    NOT NULL PRIMARY KEY, -- ��� ��ȣ
  content      VARCHAR2(70) NOT NULL,             -- ��� ���� 
  passwd       VARCHAR2(15)  NOT NULL,             -- �н�����  
  rdate        Date          NOT NULL,             -- �����
  mediano      NUMBER(7)     NULL                  -- �̵�� ��ȣ
);
 
 
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - ��', sysdate, 'poster.jpg', 'lasong.mp3', 15000, 'Y', 1);
 
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - ��', sysdate, 'lason.jpg', 'lasong.mp3', 15000, 'Y', 1);
 
INSERT INTO media(mediano, 
           title, rdate, poster, filename, filesize, mview, mediagroupno)
VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),
           'LaSong - ��', sysdate, 'lason.jpg', 'lasong.mp3', 15000, 'Y', 1);
 

SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno
FROM media
WHERE mediagroupno = 1
ORDER BY mediano DESC;


INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2014 Drive ����');

INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2015 Music ����');

INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2016 Dance ����');

SELECT mediagroupno, title
FROM mediagroup
ORDER BY mediagroupno ASC;


SELECT mediano, title, poster, filename, filesize, mview, mediagroupno FROM media;

INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'���� ���� �Դϴ�.', '1234', sysdate, 10);
 
INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'���� ���� �Դϴ�.', '1234', sysdate, 10);
 
INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'���� ���� �Դϴ�.', '1234', sysdate, 10);
 
 
SELECT replyno, content, passwd, rdate, mediano
FROM reply
WHERE mediano = 10
ORDER BY replyno DESC;

SELECT mediagroupno, title
FROM mediagroup
WHERE mediagroupno = 1;


UPDATE mediagroup
SET title = '2010~2011 ���� ����'
WHERE mediagroupno = 1;

DELETE FROM mediagroup
WHERE mediagroupno = 1;

       
SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno
FROM media
WHERE mediano=1;

commit;


       

