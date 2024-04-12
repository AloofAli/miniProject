import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentTests {

    /**
     * This method tests the calculation of the total passed credit for a student.
     * It sets up a scenario with a student, teacher, and several courses.
     * The student enrolls in courses, and the method verifies that the total passed credit is correctly calculated.
     *
     * <p>Scenario:
     * - A student is created.
     * - A teacher is created.
     * - Four courses are created: "AP", "BP", "DB", and "Ds".
     * - The student enrolls in "Ds".
     * - The teacher adds the student to "AP", "BP", and "DB".
     * - The expected total passed credit is 11 (sum of credits for all courses).</p>
     */
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
    /**
     * This JUnit test method verifies the behavior of the {@link Student#addCourse(Course)} method.
     * It sets up a scenario with a student, teacher, and several courses.
     * The student enrolls in multiple courses, and the test checks if the total number of enrolled courses matches the expected count.
     *
     * <p>Scenario:
     * - A student is created.
     * - Four courses are created: "AP", "BP", "DB", and "Ds".
     * - The student enrolls in all four courses using the {@link Student#addCourse(Course)} method.
     * - The expected total number of enrolled courses is 4.</p>
     *
     */
    @Test
    public void testAddCourse(){
        Student student=new Student();
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
    /**
     * This method thoroughly tests the `termCourseDetail` function in the `Student` class.
     * It ensures that the list of student course versions returned by the function
     * precisely matches the expected result.
     *
     * <p>Scenario:
     * - A student is created.
     * - A teacher is created.
     * - Four courses are created: "AP", "BP", "DB", and "Ds".
     * - The student enrolls in all four courses using the {@link Student#addCourse(Course)} method.
     * - Additionally, the student is added to the "DLC" course.
     * - The teacher assigns the student to the "EC" course.
     * - The expected result is a list containing all six student-course associations.</p>
     */
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
    /**
     * Rigorously test the `termCourseDetail` function of the `Student` class.
     * This method sets up two distinct scenarios to verify the correctness of term course details:
     * <p>
     * Scenario 1:
     * - A new student is created.
     * - Three courses ("AP", "BP", and "DB") are added to the student's first term.
     * - Expected result after adding courses: [course1, course2, course3]
     * <p>
     * Scenario 2:
     * - A new term is started for the student.
     * - A different course ("Ds") is added to the student's second term.
     * - The student is enrolled in "Digital Logic Circuits" (course5).
     * - The teacher offers "Electronic Circuits" (course6) and associates the student with it.
     * - Expected result after adding courses: [course4, course5, course6]
     * <p>
     * The test ensures that the term course details match the expected results for both scenarios.
     */
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


