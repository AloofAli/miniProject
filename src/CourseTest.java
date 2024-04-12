import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class CourseTest {
    /**
     * Rigorously tests the `GetTopStudent` function of the `Course` class.
     * This method verifies that the top-performing student is correctly identified based on scores.
     */
    @Test
    public void testGetTopStudent() {
        // Create students
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();
        Student student6 = new Student();

        // Set student names
        student1.setName("Ali");
        student2.setName("Ali2");
        student3.setName("Ali3");
        student4.setName("Ali4");
        student5.setName("Ali5");
        student6.setName("Ali6");

        // Create a teacher
        Teacher teacher = new Teacher();

        // Create a course
        Course course = new Course("AP", 3);

        // Add the course to the teacher's list
        teacher.AddCourse(course);

        // Start a new term for each student
        student1.newTerm();
        student2.newTerm();
        student3.newTerm();
        student4.newTerm();
        student5.newTerm();
        student6.newTerm();

        // Add students to the course
        teacher.AddStudent(course, student1);
        teacher.AddStudent(course, student2);
        teacher.AddStudent(course, student3);
        teacher.AddStudent(course, student4);
        teacher.AddStudent(course, student5);
        teacher.AddStudent(course, student6);

        // Score the students
        teacher.Score(course, student1, 19);
        teacher.Score(course, student2, 20);
        teacher.Score(course, student3, 10);
        teacher.Score(course, student4, 14);
        teacher.Score(course, student5, 18.5);
        teacher.Score(course, student6, 9);

        // Verify that the top-performing student is correctly identified
        Assertions.assertEquals(student2, course.GetTopStudent());
    }

}
