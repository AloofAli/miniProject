import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment {
    String subject;

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
    Date deadLine;

    boolean Active;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
