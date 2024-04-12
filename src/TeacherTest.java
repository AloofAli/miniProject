import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
public class TeacherTest {
    @Test
    public void testRemoveCourse(){
        Course course =new Course("Ap",3);
        Teacher teacher = new Teacher();
        teacher.AddCourse(course);
        Assertions.assertEquals(teacher.courses.getLast(),course);
        teacher.RemoveCourse(course);
        Assertions.assertEquals(teacher.courses,new ArrayList<>());
    }
    @Test
    public void testRemoveStudent(){
        Course course =new Course("Ap",3);
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.AddCourse(course);
        student.newTerm();
        teacher.AddStudent(course,student);
        Assertions.assertEquals(student.terms.getLast().studentCourses.getLast(),course.studentCourseVersion.getLast());
        teacher.RemoveStudent(course,student);
        Assertions.assertEquals(student.terms.getLast().studentCourses,new ArrayList<>());
        }
    @Test
    public void testAddAssignment(){
        Course course =new Course("Ap",3);
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.AddCourse(course);
        Assignment assignment =new Assignment("Junit Exercise");
        teacher.AddAssignment(course,assignment);
        teacher.AssignmentActivator(course,assignment);
        Assertions.assertEquals(course.ActiveAssignments.getLast(),assignment);
        Assertions.assertEquals(course.AllAssignments.getLast(),assignment);
    }
    @Test
    public void testRemoveAssignment(){
        Course course =new Course("Ap",3);
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.AddCourse(course);
        Assignment assignment =new Assignment("Junit Exercise");
        Assignment assignment2 =new Assignment("oop");
        Assignment assignment3 =new Assignment("Exception");
        teacher.AddAssignment(course,assignment);
        teacher.AddAssignment(course,assignment2);
        teacher.AddAssignment(course,assignment3);
        ArrayList<Assignment>result=new ArrayList<>();
        result.add(assignment);
        result.add(assignment2);
        result.add(assignment3);
        teacher.AssignmentActivator(course,assignment);
        teacher.AssignmentActivator(course,assignment2);
        teacher.AssignmentActivator(course,assignment3);
        Assertions.assertEquals(course.ActiveAssignments,result);
        Assertions.assertEquals(course.AllAssignments,result);
        teacher.RemoveAssignment(course,assignment);
        Assertions.assertEquals(course.AllAssignments,result);
        result.remove(assignment);
        Assertions.assertEquals(course.ActiveAssignments,result);
    }
    @Test
    public void testDeadLineTimeEdit(){
        Course course =new Course("Ap",3);
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.AddCourse(course);
        Assignment assignment =new Assignment("Junit Exercise");

        teacher.AddAssignment(course,assignment);
        teacher.AssignmentActivator(course,assignment);

        teacher.DeadLineTimeEdit(course,assignment,new Date(2024,4,12));
        Assertions.assertEquals(assignment.deadLine,new Date(2024,4,12));

    }
}
