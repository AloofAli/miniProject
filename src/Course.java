import java.util.ArrayList;
import java.util.Collections;

public class Course {
BeheshtiUniversityField beheshtiUniversityField;
String name;

Teacher teacher;

ArrayList<Student>students=new ArrayList<>();
ArrayList<Assignment> AllAssignment=new ArrayList<>();
ArrayList<Assignment> ActiveAssignment=new ArrayList<>();

public void AddStudent(Student student){
    students.add(student);
}
public void RemoveStudent(Student student){
    students.remove(student);
}
public String GetTopStudent() {
    ArrayList<StudentCourse> sorted = new ArrayList<>();
    for (int i = 0; i < students.size(); i++) {
        for (int j = 0; j < students.get(i).terms.size(); j++) {
            if (students.get(i).terms.getLast().studentCourses.get(j).getName() == name) {
                sorted.add(students.get(i).terms.getLast().studentCourses.get(j));
            }
        }
    }
    Collections.sort(sorted, (o1, o2) -> o1.getScore().compareTo(o2.getScore()));
    return sorted.getFirst().getName();
}

}
