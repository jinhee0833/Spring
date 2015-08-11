>>>>> /WEB-INF/doc/reply_o.sql
 
1) ��� ���̺�
CREATE TABLE reply(
  replyno      NUMBER(10)    NOT NULL PRIMARY KEY, -- ��� ��ȣ
  content      VARCHAR2(300) NOT NULL,             -- ��� ���� 
  passwd       VARCHAR2(15)  NOT NULL,             -- �н�����  
  rdate        Date          NOT NULL,             -- �����
  mediano      NUMBER(7)     NULL                  -- �̵�� ��ȣ
);
 
 
2) media ���̺��� ������ Ȯ��
SELECT mediano, title, poster, filename, filesize, mview, mediagroupno FROM media;
 
 MEDIANO TITLE      POSTER        FILENAME      FILESIZE MVIEW MEDIAGROUPNO
 ------- ---------- ------------- ------------- -------- ----- ------------
       8 mp3        (0)bbabba.jpg (0)bbabba.mp3  7395678 Y         0
      10 ����ϰ�       Crooked.jpg   Crooked.mp3   10055724 Y     1
      12 mp3        IDoIDo.jpg    IDoIDo.mp3     8716442 Y         3
       4 LaSong - �� poster.jpg    lasong.mp3       15000 Y        1
       5 LaSong - �� poster.jpg    lasong.mp3       15000 Y        1
       6 LaSong - �� poster.jpg    lasong.mp3       15000 Y        1
       7 mp3        bbabba.jpg    bbabba.mp3     7395678 Y         0
       9 mp3        (1)bbabba.jpg (1)bbabba.mp3  7395678 Y         1
      11 mp3        gguri.jpg     gguri.mp3      7171584 Y         2
 
      
      
3) media ���̺� ������ �߰�
INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'���� ���� �Դϴ�.', '1234', sysdate, 10);
 
INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'���� ���� �Դϴ�.', '1234', sysdate, 10);
 
INSERT INTO reply(replyno, content, passwd, rdate, mediano)
VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),
'���� ���� �Դϴ�.', '1234', sysdate, 10);
 
 
 
4) ��� ���
SELECT replyno, content, passwd, rdate, mediano
FROM reply
WHERE mediano = 10
ORDER BY replyno DESC;
 
 REPLYNO CONTENT    PASSWD RDATE                 MEDIANO
 ------- ---------- ------ --------------------- -------
       3 ���� ���� �Դϴ�. 1234   2014-04-22 17:08:47.0      10
       2 ���� ���� �Դϴ�. 1234   2014-04-22 17:08:46.0      10
       1 ���� ���� �Դϴ�. 1234   2014-04-22 17:08:45.0      10
 
       