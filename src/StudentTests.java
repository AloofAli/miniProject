import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentTests {

    @Test
    public void testGetTotalPassedCredit(){
        Student student=new Student();
        Teacher teacher=new Teacher();
        Course course=new Course("AP",3);
        Course course2=new Course("BP",3);
        Course course3=new Course("DB",3);
        Course sCourse = new Course("Ds",2);
        student.newTerm();
        teacher.AddCourse(course);
        teacher.AddStudent(course,student);
        student.addCourse(sCourse);
        course2.AddStudent(student);
        course3.AddStudent(student);
        Assertions.assertEquals(11, student.getTotalPassedCredit());
    }
    @Test
    public void testAddCourse(){
        Student student=new Student();
        Teacher teacher=new Teacher();
        Course course=new Course("AP",3);
        Course course2=new Course("BP",3);
        Course course3=new Course("DB",3);
        Course course4 = new Course("Ds",2);
        student.newTerm();
        student.addCourse(course);
        student.addCourse(course2);
        student.addCourse(course3);
        student.addCourse(course4);
        Assertions.assertEquals(4,student.terms.getLast().studentCourses.size());
    }
    @Test
    public void testTermCoursesDetail() {
        Student student=new Student();
        Teacher teacher=new Teacher();
        Course course=new Course("AP",3);
        Course course2=new Course("BP",3);
        Course course3=new Course("DB",3);
        Course course4 = new Course("Ds",2);
        Course course5 = new Course("DLC",2);
        Course course6 = new Course("EC",3);
        student.newTerm();
        student.addCourse(course);
        student.addCourse(course2);
        student.addCourse(course3);
        student.addCourse(course4);
        course5.AddStudent(student);
        teacher.AddCourse(course6);
        teacher.AddStudent(course6,student);
        ArrayList<StudentCourse> result=new ArrayList<StudentCourse>();
        result.add(course.studentCourseVersion);
        result.add(course2.studentCourseVersion);
        result.add(course3.studentCourseVersion);
        result.add(course4.studentCourseVersion);
        result.add(course5.studentCourseVersion);
        result.add(course6.studentCourseVersion);
        Assertions.assertEquals(result,student.termCourseDetail());
    }

    @Test
    public void testTermCoursesDetail2() {
        Student student=new Student();
        Teacher teacher=new Teacher();
        Course course=new Course("AP",3);
        Course course2=new Course("BP",3);
        Course course3=new Course("DB",3);
        Course course4 = new Course("Ds",2);
        Course course5 = new Course("DLC",2);
        Course course6 = new Course("EC",3);
        student.newTerm();
        student.addCourse(course);
        student.addCourse(course2);
        student.addCourse(course3);
        student.newTerm();
        student.addCourse(course4);
        course5.AddStudent(student);
        teacher.AddCourse(course6);
        teacher.AddStudent(course6,student);
        ArrayList<StudentCourse> result=new ArrayList<StudentCourse>();

        result.add(course4.studentCourseVersion);
        result.add(course5.studentCourseVersion);
        result.add(course6.studentCourseVersion);
        Assertions.assertEquals(result,student.termCourseDetail(2));
    }

    @Test
    public void testTermCreditDetail() {
        Student student=new Student();
        Teacher teacher=new Teacher();
        Course course=new Course("AP",3);
        Course course2=new Course("BP",3);
        Course course3=new Course("DB",3);
        Course course4 = new Course("Ds",2);
        Course course5 = new Course("DLC",2);
        Course course6 = new Course("EC",3);
        student.newTerm();
        student.addCourse(course);
        student.addCourse(course2);
        student.addCourse(course3);
        student.addCourse(course4);
        course5.AddStudent(student);
        teacher.AddCourse(course6);
        teacher.AddStudent(course6,student);
        Assertions.assertEquals(16,student.termCreditDetail());
    }
    @Test
    public void testTermCreditDetail2() {
        Student student=new Student();
        Teacher teacher=new Teacher();
        Course course=new Course("AP",3);
        Course course2=new Course("BP",3);
        Course course3=new Course("DB",3);
        Course course4 = new Course("Ds",2);
        Course course5 = new Course("DLC",2);
        Course course6 = new Course("EC",3);
        student.newTerm();
        student.addCourse(course);
        student.addCourse(course2);
        student.newTerm();
        student.addCourse(course3);
        student.addCourse(course4);
        course5.AddStudent(student);
        teacher.AddCourse(course6);
        teacher.AddStudent(course6,student);
        Assertions.assertEquals(10,student.termCreditDetail(2));
    }
    @Test
    public void testTermAvgDetail() {
        Student student=new Student();
        Teacher teacher=new Teacher();
        Teacher teacher2=new Teacher();
        Teacher teacher3=new Teacher();
        Teacher teacher4=new Teacher();
        Teacher teacher5=new Teacher();
        Course course=new Course("AP",1);
        Course course2=new Course("BP",0);
        Course course3=new Course("DB",1);
        Course course4 = new Course("Ds",1);
        Course course5 = new Course("DLC",1);
        Course course6 = new Course("EC",1);
        student.newTerm();
        teacher5.AddCourse(course6);
        teacher5.AddCourse(course5);
        teacher4.AddCourse(course4);
        teacher3.AddCourse(course3);
        teacher2.AddCourse(course2);
        teacher.AddCourse(course);
        teacher.AddStudent(course,student);
        teacher2.AddStudent(course2,student);
        teacher3.AddStudent(course3,student);
        teacher4.AddStudent(course4,student);
        teacher5.AddStudent(course5,student);
        teacher5.AddStudent(course6,student);
        teacher.Score(course,student,10);
        teacher2.Score(course2,student,11);
        teacher3.Score(course3,student,12);
        teacher4.Score(course4,student,13);
        teacher5.Score(course5,student,14);
        teacher5.Score(course6,student,15);
        Assertions.assertEquals(12.8,student.termAvgDetail());
    }

    @Test
    public void testTermAvgDetail2() {
        Student student=new Student();
        Teacher teacher=new Teacher();
        Teacher teacher2=new Teacher();
        Teacher teacher3=new Teacher();
        Teacher teacher4=new Teacher();
        Teacher teacher5=new Teacher();
        Course course=new Course("AP",1);
        Course course2=new Course("BP",0);
        Course course3=new Course("DB",1);
        Course course4 = new Course("Ds",1);
        Course course5 = new Course("DLC",1);
        Course course6 = new Course("EC",1);
        student.newTerm();
        teacher5.AddCourse(course6);
        teacher5.AddCourse(course5);
        teacher4.AddCourse(course4);
        teacher3.AddCourse(course3);
        teacher2.AddCourse(course2);
        teacher.AddCourse(course);
        teacher.AddStudent(course,student);
        teacher2.AddStudent(course2,student);
        teacher3.AddStudent(course3,student);
        teacher4.AddStudent(course4,student);
        teacher5.AddStudent(course5,student);
        teacher.Score(course,student,10);
        teacher2.Score(course2,student,11);
        teacher3.Score(course3,student,12);
        teacher4.Score(course4,student,13);
        teacher5.Score(course5,student,14);
        student.newTerm();
        teacher5.AddStudent(course6,student);
        teacher5.Score(course6,student,15);
        Assertions.assertEquals(15,student.termAvgDetail(2));
    }

    @Test
    public void testTotalAvg(){
        Student student=new Student();
        Teacher teacher=new Teacher();
        Teacher teacher2=new Teacher();
        Teacher teacher3=new Teacher();
        Teacher teacher4=new Teacher();
        Teacher teacher5=new Teacher();
        Course course=new Course("AP",1);
        Course course2=new Course("BP",0);
        Course course3=new Course("DB",1);
        Course course4 = new Course("Ds",1);
        Course course5 = new Course("DLC",1);
        Course course6 = new Course("EC",1);
        student.newTerm();
        teacher5.AddCourse(course6);
        teacher5.AddCourse(course5);
        teacher4.AddCourse(course4);
        teacher3.AddCourse(course3);
        teacher2.AddCourse(course2);
        teacher.AddCourse(course);
        teacher.AddStudent(course,student);
        teacher2.AddStudent(course2,student);
        teacher3.AddStudent(course3,student);
        teacher4.AddStudent(course4,student);
        teacher5.AddStudent(course5,student);
        teacher.Score(course,student,10);
        teacher2.Score(course2,student,11);
        teacher3.Score(course3,student,12);
        teacher4.Score(course4,student,13);
        teacher5.Score(course5,student,14);
        student.newTerm();
        teacher5.AddStudent(course6,student);
        teacher5.Score(course6,student,15);
        Assertions.assertEquals(15,student.termAvgDetail(2));
    }


}


