import java.util.*;

public class Course {
    BeheshtiUniversityField beheshtiUniversityField;
    String name;
    int credit;
    StudentCourse studentCourseVersion;

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
        studentCourseVersion = new StudentCourse(name, credit);
    }

    String teacherName;

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Assignment> AllAssignments = new ArrayList<>();
    ArrayList<Assignment> ActiveAssignments = new ArrayList<>();

    public void AddStudent(Student student) {
        students.add(student);
        student.terms.getLast().studentCourses.add(studentCourseVersion);
    }

    public void RemoveStudent(Student student) {
        students.remove(student);
        student.terms.getLast().studentCourses.remove(studentCourseVersion);
    }

    public Student GetTopStudent() {
            sort(students);
            return students.getFirst();
    }
    private void sort(ArrayList<Student>students){
        students.sort((o1,o2)
                ->o1.terms.getLast().studentCourses.get(o1.terms.getLast().studentCourses.indexOf(studentCourseVersion)).getScore().compareTo(
                o2.terms.getLast().studentCourses.get(o2.terms.getLast().studentCourses.indexOf(studentCourseVersion)).getScore()));
    }
}
