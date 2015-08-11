package sts.blog.media;

import org.springframework.web.multipart.MultipartFile;

public class MediaDTO {
  /** �̵�� ��ȣ */
  private int mediano;    // 0
  private String title;   // null
  private String rdate;
  private String poster;
  private String filename;  
  private long filesize;
  private String filesizeUnit;
  private String mview;  
  private int mediagroupno;
  
  private MultipartFile posterMF;
  private MultipartFile filenameMF;
  
  public int getMediano() {
    return mediano;
  }
  public void setMediano(int mediano) {
    this.mediano = mediano;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public String getPoster() {
    return poster;
  }
  public void setPoster(String poster) {
    this.poster = poster;
  }
  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }

  public long getFilesize() {
    return filesize;
  }
  public void setFilesize(long filesize) {
    this.filesize = filesize;
  }
  
  public String getFilesizeUnit() {
    return filesizeUnit;
  }
  public void setFilesizeUnit(String filesizeUnit) {
    this.filesizeUnit = filesizeUnit;
  }
  public String getMview() {
    return mview;
  }
  public void setMview(String mview) {
    this.mview = mview;
  }
  public int getMediagroupno() {
    return mediagroupno;
  }
  public void setMediagroupno(int mediagroupno) {
    this.mediagroupno = mediagroupno;
  }
  
  public MultipartFile getPosterMF() {
    return posterMF;
  }
  public void setPosterMF(MultipartFile posterMF) {
    this.posterMF = posterMF;
  }
  public MultipartFile getFilenameMF() {
    return filenameMF;
  }
  public void setFilenameMF(MultipartFile filenameMF) {
    this.filenameMF = filenameMF;
  }
  
  
}
