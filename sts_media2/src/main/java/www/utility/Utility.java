package www.utility;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class Utility {
  /**
   * ���� ����� �޾� KB, MB, GB�� ��ȯ�մϴ�.
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
   * ������ �Է¹޾� ���� ��θ� �����մϴ�. 
   * ��) getRealPath(request, "/media/storage")
   * 
   * @param request
   * @param dir ���� ��θ� ���� ������
   * @return ���� ��� ����
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
   * ���� ����
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
