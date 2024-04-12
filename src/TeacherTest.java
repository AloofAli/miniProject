import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
public class TeacherTest {
    /**
     * Rigorously tests the `RemoveCourse` function of the `Teacher` class.
     * This method verifies that a course is correctly added and removed from the teacher's list of courses.
     */
    @Test
    public void testRemoveCourse() {
        // Create a new course
        Course course = new Course("Ap", 3);

        // Create a teacher
        Teacher teacher = new Teacher();

        // Add the course to the teacher's list
        teacher.AddCourse(course);

        // Verify that the course was added successfully
        Assertions.assertEquals(teacher.courses.getLast(), course);

        // Remove the course from the teacher's list
        teacher.RemoveCourse(course);

        // Verify that the course was removed successfully
        Assertions.assertEquals(teacher.courses, new ArrayList<>());
    }

    /**
     * Rigorously tests the `RemoveStudent` function of the `Teacher` class.
     * This method verifies that a student is correctly added and removed from a specific course.
     */
    @Test
    public void testRemoveStudent() {
        // Create a new course
        Course course = new Course("Ap", 3);

        // Create a teacher
        Teacher teacher = new Teacher();

        // Create a student
        Student student = new Student();

        // Add the course to the teacher's list
        teacher.AddCourse(course);

        // Start a new term for the student
        student.newTerm();

        // Add the student to the course
        teacher.AddStudent(course, student);

        // Verify that the student was added successfully
        Assertions.assertEquals(student.terms.getLast().studentCourses.getLast(), course.studentCourseVersion.getLast());

        // Remove the student from the course
        teacher.RemoveStudent(course, student);

        // Verify that the student was removed successfully
        Assertions.assertEquals(student.terms.getLast().studentCourses, new ArrayList<>());
    }

    /**
     * Rigorously tests the `AddAssignment` and `AssignmentActivator` functions of the `Teacher` class.
     * This method verifies that an assignment is correctly added to a course and activated.
     */
    @Test
    public void testAddAssignment() {
        // Create a new course
        Course course = new Course("Ap", 3);

        // Create a teacher
        Teacher teacher = new Teacher();

        // Create a student
        Student student = new Student();

        // Add the course to the teacher's list
        teacher.AddCourse(course);

        // Create an assignment
        Assignment assignment = new Assignment("Junit Exercise");

        // Add the assignment to the course and activate it
        teacher.AddAssignment(course, assignment);
        teacher.AssignmentActivator(course, assignment);

        // Verify that the assignment is active and added to both lists
        Assertions.assertEquals(course.ActiveAssignments.getLast(), assignment);
        Assertions.assertEquals(course.AllAssignments.getLast(), assignment);
    }

    /**
     * Rigorously tests the `RemoveAssignment` function of the `Teacher` class.
     * This method verifies that an assignment is correctly added, activated, and removed from a specific course.
     */
    @Test
    public void testRemoveAssignment() {
        // Create a new course
        Course course = new Course("Ap", 3);

        // Create a teacher
        Teacher teacher = new Teacher();
        //Teacher Add course to his courses
        teacher.AddCourse(course);
        // Create assignments
        Assignment assignment = new Assignment("Junit Exercise");
        Assignment assignment2 = new Assignment("oop");
        Assignment assignment3 = new Assignment("Exception");

        // Add assignments to the course and activate them
        teacher.AddAssignment(course, assignment);
        teacher.AddAssignment(course, assignment2);
        teacher.AddAssignment(course, assignment3);
        teacher.AssignmentActivator(course, assignment);
        teacher.AssignmentActivator(course, assignment2);
        teacher.AssignmentActivator(course, assignment3);

        // Verify that assignments are active and added to both lists
        ArrayList<Assignment> result = new ArrayList<>();
        result.add(assignment);
        result.add(assignment2);
        result.add(assignment3);
        Assertions.assertEquals(course.ActiveAssignments, result);
        Assertions.assertEquals(course.AllAssignments, result);

        // Remove an assignment from the course
        teacher.RemoveAssignment(course, assignment);

        // Verify that the assignment is removed from active assignments
        result.remove(assignment);
        Assertions.assertEquals(course.ActiveAssignments, result);
    }
    /**
     * Rigorously tests the `DeadLineTimeEdit` function of the `Teacher` class.
     * This method verifies that an assignment's deadline is correctly edited in a specific course.
     */
    @Test
    public void testDeadLineTimeEdit() {
        // Create a new course
        Course course = new Course("Ap", 3);

        // Create a teacher
        Teacher teacher = new Teacher();
        //Teacher Add course to his courses
        teacher.AddCourse(course);
        // Create an assignment
        Assignment assignment = new Assignment("Junit Exercise");

        // Add the assignment to the course and activate it
        teacher.AddAssignment(course, assignment);
        teacher.AssignmentActivator(course, assignment);

        // Edit the assignment's deadline
        teacher.DeadLineTimeEdit(course, assignment, new Date(2024, 4, 12));

        // Verify that the assignment's deadline is updated correctly
        Assertions.assertEquals(assignment.getDeadLine(), new Date(2024, 4, 12));
    }

}
