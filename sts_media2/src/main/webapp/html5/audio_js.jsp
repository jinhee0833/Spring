<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [html5/audio_js.jsp]</title>
<style type="text/css">
*{
  font-family: 굴림체;
  font-size: 24px;
}
</style>
<script type="text/javascript">
function loadMusic(poster_img, mp3){
  var poster = document.getElementById('poster'); // id가 'poster'인 태그 검색
  poster.src = poster_img;                        // 새로운 이미지 할당 
 
  var audio1 = document.getElementById('audio1'); // id가 audio1 태그 검색
  audio1.src = mp3;                                 // mp3 음악 파일 할당
  audio1.play();                                  // 자동 실행
 
}
</script>
</head>
<body>
<div style='text-align: center;'>
  <img id='poster' src="./mp3/gguri.jpg" width="300" >
  <br><br>
  <audio controls autoplay id="audio1" src="./mp3/gguri.mp3" />
</div>
<div style='margin:0 auto; width: 20%; background-color: #FFFFFF'>
  <br>
  <OL>
    <LI><a href="javascript:loadMusic('./mp3/crooked.jpg', './mp3/crooked.mp3');">삐딱하게</a>
    <LI><a href="javascript:loadMusic('./mp3/idoido.jpg', './mp3/idoido.mp3');">I Do I Do</a>
    <LI><a href="javascript:loadMusic('./mp3/lasong.jpg', './mp3/lasong.mp3');">La Song</a>
    <LI><a href="javascript:loadMusic('./mp3/opendoor.jpg', './mp3/opendoor.mp3');">문을 여시오</a>
  </OL>  
</div>
 
</body>
</html>

