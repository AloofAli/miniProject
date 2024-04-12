import java.util.*;
/**
 * Represents a course in an academic program.
 * Each course has a name, credit value, associated students, and assignments.
 */
public class Course {
    BeheshtiUniversityField beheshtiUniversityField;
    String name;
    int credit;

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;

    }

    String teacherName;

    ArrayList<StudentCourse> studentCourseVersion = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Assignment> AllAssignments = new ArrayList<>();
    ArrayList<Assignment> ActiveAssignments = new ArrayList<>();

    /**
     * Adds a student to this course.
     * Associates the student with the course and updates the student's term information.
     *
     * @param student The student to be added.
     */
    public void AddStudent(Student student) {
        students.add(student);
        studentCourseVersion.add(new StudentCourse(name, credit));
        student.terms.getLast().studentCourses.add(studentCourseVersion.getLast());
    }
    /**
     * Removes a student from this course.
     * Disassociates the student from the course and updates the student's term information.
     *
     * @param student The student to be removed.
     */
    public void RemoveStudent(Student student) {
        student.terms.getLast().studentCourses.remove(studentCourseVersion.get(students.indexOf(student)));
        students.remove(student);
    }
    /**
     * Retrieves the top-performing student in this course.
     * The top student is determined based on their scores in the course.
     *
     * @return The student with the highest score.
     */
    public Student GetTopStudent() {
        Student[] s = new Student[students.size()];
        for (int i = 0; i < students.size(); i++) {
            s[i] = students.get(i);
        }
        sort(s);

        return s[students.size() - 1];
    }

    private void sort(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].terms.getLast().studentCourses.get(students[j].terms.getLast().studentCourses.indexOf(studentCourseVersion.get(this.students.indexOf(students[j])))).score > students[j+1].terms.getLast().studentCourses.get(students[j+1].terms.getLast().studentCourses.indexOf(studentCourseVersion.get(this.students.indexOf(students[j+1])))).score) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

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
}
