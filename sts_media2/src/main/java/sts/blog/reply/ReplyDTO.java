package sts.blog.reply;
 
public class ReplyDTO{
  private int replyno;
  private String content;
  private String passwd;
  private String rdate;
  private int mediano;
  
  public int getReplyno() {
    return replyno;
  }
  public void setReplyno(int replyno) {
    this.replyno = replyno;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getPasswd() {
    return passwd;
  }
  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }
    public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public int getMediano() {
    return mediano;
  }
  public void setMediano(int mediano) {
    this.mediano = mediano;
  }
  
  
}