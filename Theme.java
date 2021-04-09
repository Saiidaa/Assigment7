
import java.io.Serializable;
import java.util.Date;

public class Theme implements Serializable {
    int Themeid;
    String userid;
    String Themename;
    String comment;
    Date date;
    public Theme()
    {

    }
    public Theme(int Themeid, String userid, String Themename, String comment,
                 Date date) {
        super();
        this.Themeid = Themeid;
        this.userid = userid;
        this.Themename = Themename;
        this.comment = comment;
        this.date = date;
    }
    public int getThemeid() {
        return Themeid;
    }
    public static void setThemeid(int Themeid) {
        this.Themeid = Themeid;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getThemename() {
        return Themename;
    }
    public void setThemename(String Themename) {
        this.Themename = Themename;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}