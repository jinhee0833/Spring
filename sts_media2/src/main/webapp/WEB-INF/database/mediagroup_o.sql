>>>>> /sts_media/src/main/webapp/WEB-INF/doc/mediagroup_o.sql

1. ���
INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2010 Drive ����');

INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2011 Drive ����');

INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2012 Drive ����');

SELECT mediagroupno, title
FROM mediagroup
ORDER BY mediagroupno ASC;

 MEDIAGROUPNO TITLE
 ------------ -------------
            1 2010 Drive ����
            2 2011 Drive ����
            3 2012 Drive ����

            
1) ��ȸ
SELECT mediagroupno, title
FROM mediagroup
WHERE mediagroupno = 1;



2) ����
UPDATE mediagroup
SET title = '2010~2011 ���� ����'
WHERE mediagroupno = 1;

3) ����
DELETE FROM mediagroup
WHERE mediagroupno = 1;


