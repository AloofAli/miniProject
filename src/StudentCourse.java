import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a student's performance in a specific course.
 * Each student course has a name, credit value, and score.
 * Associates the student with the course.
 */
public class StudentCourse implements Serializable {
    private String name;
    private double score;
    private int credit; // The credit value of the course

    /**
     * Constructs a student course with the given name and credit value.
     *
     * @param name   The name of the course.
     * @param credit The credit value of the course.
     */
    public StudentCourse(String name, int credit) {
        this.name = name;
        this.credit = credit;
        this.score = 0;
    }

    public StudentCourse() {
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", credit=" + credit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourse that = (StudentCourse) o;
        return credit == that.credit && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credit);
    }
}
