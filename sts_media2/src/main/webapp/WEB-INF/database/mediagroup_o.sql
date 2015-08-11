>>>>> /sts_media/src/main/webapp/WEB-INF/doc/mediagroup_o.sql

1. µî·Ï
INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2010 Drive À½¾Ç');

INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2011 Drive À½¾Ç');

INSERT INTO mediagroup(mediagroupno, title)
VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), '2012 Drive À½¾Ç');

SELECT mediagroupno, title
FROM mediagroup
ORDER BY mediagroupno ASC;

 MEDIAGROUPNO TITLE
 ------------ -------------
            1 2010 Drive À½¾Ç
            2 2011 Drive À½¾Ç
            3 2012 Drive À½¾Ç

            
1) Á¶È¸
SELECT mediagroupno, title
FROM mediagroup
WHERE mediagroupno = 1;



2) ¼öÁ¤
UPDATE mediagroup
SET title = '2010~2011 ¿©Çà À½¾Ç'
WHERE mediagroupno = 1;

3) »èÁ¦
DELETE FROM mediagroup
WHERE mediagroupno = 1;


