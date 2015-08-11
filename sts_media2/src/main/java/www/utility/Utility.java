package www.utility;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class Utility {
  /**
   * 파일 사이즈를 받아 KB, MB, GB로 변환합니다.
   * @param filesize
   * @return
   */
  public static synchronized String getUnit(long filesize){
    String str = "";
    
    if (filesize >= 1024 * 1024 * 1024){ // GB
      filesize = filesize / (1024 * 1024 * 1024);
      str = filesize + " GB";

    }else if (filesize >= 1024 * 1024){ // MB
      filesize = filesize / (1024 * 1024);
      str = filesize + " MB";

    }else if (filesize >= 1024){ // MB
      filesize = filesize / (1024);
      str = filesize + " KB";

    }
    
    return str;
  }//end
  
  /**
   * 폴더를 입력받아 절대 경로를 산출합니다. 
   * 예) getRealPath(request, "/media/storage")
   * 
   * @param request
   * @param dir 절대 경로를 구할 폴더명
   * @return 절대 경로 리턴
   * @throws IOException
   */
  public static synchronized String getRealPath(HttpServletRequest request, String dir) {
    String path = "";
    
    try{
      path = request.getRealPath(dir) + "/";  
      // System.out.println("Upload path: " + path);
    }catch(Exception e){
      System.out.println(e.toString());
    }
 
    return path;
  }//end

  /**
   * 파일 삭제
   * @param fname
   * @return
   */
  public static synchronized boolean deleteFile(String fname) {
    File file = new File(fname);
    boolean ret = false;
    
    if (file.exists()){
      ret = file.delete();
    }
    
    return ret;
  }//end
  
}//class end
