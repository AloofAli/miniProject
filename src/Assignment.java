import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Represents an academic assignment.
 * An assignment has a subject, a deadline, and an active status.
 */
public class Assignment {
    String subject;// The subject of the assignment

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");// Date format for deadlines
    Date deadLine; // The deadline for completing the assignment

    boolean Active=false;// Indicates whether the assignment is currently active
    /**
     * Constructs an assignment with the given subject.
     *
     * @param subject The subject of the assignment.
     */
    public Assignment(String subject) {
        this.subject = subject;
    }


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
