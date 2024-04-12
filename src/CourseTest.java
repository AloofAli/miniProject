import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class CourseTest {
    @Test
    public void testGetTopStudent(){
        Student student1 =new Student();
        Student student2 =new Student();
        student2.setName("Ali");
        Student student3 =new Student();
        Student student4 =new Student();
        Student student5 =new Student();
        Student student6 =new Student();
        Teacher teacher =new Teacher();
        Course course =new Course("AP",3);
        teacher.AddCourse(course);
        student1.newTerm();
        student2.newTerm();
        student3.newTerm();
        student4.newTerm();
        student5.newTerm();
        student6.newTerm();
        teacher.AddStudent(course,student1);
        teacher.AddStudent(course,student2);
        teacher.AddStudent(course,student3);
        teacher.AddStudent(course,student4);
        teacher.AddStudent(course,student5);
        teacher.AddStudent(course,student6);
        teacher.Score(course,student1,19);
        teacher.Score(course,student2,20);
        teacher.Score(course,student3,10);
        teacher.Score(course,student4,14);
        teacher.Score(course,student5,18.5);
        teacher.Score(course,student6,9);
        Assertions.assertEquals(20,course.GetTopStudent());


    }
}
