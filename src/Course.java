import java.util.ArrayList;
import java.util.Collections;

public class Course {
BeheshtiUniversityField beheshtiUniversityField;
String name;
int credit;
    StudentCourse studentCourseVersion;
    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
      studentCourseVersion=new StudentCourse(name, credit);
    }
String teacherName;


ArrayList<Student>students=new ArrayList<>();
ArrayList<Assignment> AllAssignment=new ArrayList<>();
ArrayList<Assignment> ActiveAssignment=new ArrayList<>();


    public void AddStudent(Student student){
    students.add(student);
    student.terms.getLast().studentCourses.add(studentCourseVersion);
}
public void RemoveStudent(Student student){
    students.remove(student);
    StudentCourse removeHelper=new StudentCourse(name, credit);
    student.terms.getLast().studentCourses.remove(removeHelper);
}
public double GetTopStudent() {
    ArrayList<StudentCourse> sorted = new ArrayList<>();
    for (int i = 0; i < students.size(); i++) {
        for (int j = 0; j < students.get(i).terms.getLast().studentCourses.size(); j++) {
            if (students.get(i).terms.getLast().studentCourses.get(j).getName() == name) {
                sorted.add(students.get(i).terms.getLast().studentCourses.get(j));
            }
        }
    }
    Collections.sort(sorted, (o1, o2) -> o1.getScore().compareTo(o2.getScore()));
    return sorted.getFirst().getScore();
}

}
