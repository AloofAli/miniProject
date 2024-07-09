import exceptions.AssignmentNotFoundException;
import exceptions.CourseNotFoundException;
import exceptions.StudentNotFoundException;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Teacher implements Serializable {

    private String name;
    private String PASSWORD;
    private ArrayList<Course> courses = new ArrayList<>();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
    private Date BirthDate;
    private String FatherName;
    private String NationalId;
    private String phoneNumber;
    private BeheshtiUniversityField field;
    private int numberOfCourses;

    public Teacher(String name, String nationalId) throws IOException {
        this.name = name;
        NationalId = nationalId;
    }

    public Teacher() {
    }

    /**
     * Adds a course to the teacher's list of courses.
     * Associates the teacher's name with the course.
     *
     * @param course The course to be added.
     */
    public synchronized void AddCourse(Course course) {
        if (course == null) {
            throw new CourseNotFoundException();
        }
        courses.add(course);
        course.setTeacherName(name);
        course.setBeheshtiUniversityField(field);
    }

    /**
     * Removes a course from the teacher's list of courses.
     *
     * @param course The course to be removed.
     */
    public synchronized void RemoveCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        } else {
            throw new CourseNotFoundException();
        }
    }

    /**
     * Adds a student to a specific course.
     *
     * @param course  The course to which the student will be added.
     * @param student The student to be added.
     */
    public synchronized void AddStudent(Course course, Student student) {
        if (!courses.contains(course)) {
            throw new CourseNotFoundException();
        }
        getCourses().get(getCourses().indexOf(course)).AddStudent(student);
    }

    /**
     * Removes a student from a specific course.
     *
     * @param course  The course from which the student will be removed.
     * @param student The student to be removed.
     */
    public synchronized void RemoveStudent(Course course, Student student) {
        for (int i = 0; i < getCourses().size(); i++) {
            if (getCourses().get(i).getName().equals(course.getName())) {
                for (int j = 0; j < getCourses().get(i).getStudents().size(); j++) {
                    if (getCourses().get(i).getStudents().get(j).getStudentId().equals(student.getStudentId())) {
                        getCourses().get(i).getStudents().remove(j);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Adds an assignment to a specific course.
     *
     * @param course     The course to which the assignment will be added.
     * @param assignment The assignment to be added.
     */
    public synchronized void AddAssignment(Course course, Assignment assignment) {
        if (!courses.contains(course)) {
            throw new CourseNotFoundException();
        }
        courses.get(courses.indexOf(course)).getAllAssignments().add(assignment);
    }

    /**
     * Removes an assignment from a specific course.
     *
     * @param course     The course from which the assignment will be removed.
     * @param assignment The assignment to be removed.
     */
    public synchronized void RemoveAssignment(Course course, Assignment assignment) {
        if (!courses.contains(course)) {
            throw new CourseNotFoundException();
        }
        if (!getCourses().get(getCourses().indexOf(course)).getAllAssignments().contains(assignment)) {
            throw new AssignmentNotFoundException();
        }
        if (assignment.isActive()) {
            getCourses().get(getCourses().indexOf(course)).getAllAssignments().remove(assignment);
        }
    }

    /**
     * Scores an assignment for a specific student in a course.
     *
     * @param course  The course in which the assignment was submitted.
     * @param student The student who submitted the assignment.
     * @param score   The score to assign to the assignment.
     */
    public synchronized void Score(Course course, Student student, double score) {
        if (!courses.contains(course)) {
            throw new CourseNotFoundException();
        }
        if (!getCourses().get(getCourses().indexOf(course)).getStudents().contains(student)) {
            throw new StudentNotFoundException();
        }
        int lastTermIndex = getCourses().get(getCourses().indexOf(course)).getStudents().get(getCourses().get(getCourses().indexOf(course)).getStudents().indexOf(student)).getTerms().size() - 1;
        for (int i = 0; i < getCourses().get(getCourses().indexOf(course)).getStudents().get(getCourses().get(getCourses().indexOf(course)).getStudents().indexOf(student)).getTerms().get(lastTermIndex).getStudentCourses().size(); i++) {
            if (Objects.equals(getCourses().get(getCourses().indexOf(course)).getStudents().get(getCourses().get(getCourses().indexOf(course)).getStudents().indexOf(student)).getTerms().get(lastTermIndex).getStudentCourses().get(i).getName(), course.getName())) {
                getCourses().get(getCourses().indexOf(course)).getStudents().get(getCourses().get(getCourses().indexOf(course)).getStudents().indexOf(student)).getTerms().get(lastTermIndex).getStudentCourses().get(i).setScore(score);
            }
        }
    }

    /**
     * Edits the deadline for a specific assignment in a course.
     *
     * @param course     The course containing the assignment.
     * @param assignment The assignment whose deadline will be edited.
     * @param newDate    The new deadline date.
     */
    public synchronized void DeadLineTimeEdit(Course course, Assignment assignment, Date newDate) {
        if (!courses.contains(course)) {
            throw new CourseNotFoundException();
        }
        if (!course.getAllAssignments().contains(assignment)) {
            throw new AssignmentNotFoundException();
        }
        courses.get(courses.indexOf(course)).getAllAssignments().get(courses.get(courses.indexOf(course)).getAllAssignments().indexOf(assignment)).setDeadLine(newDate);
        courses.get(courses.indexOf(course)).getActiveAssignments().get(courses.get(courses.indexOf(course)).getActiveAssignments().indexOf(assignment)).setDeadLine(newDate);
    }

    /**
     * Activates an assignment in a course.
     *
     * @param course     The course containing the assignment.
     * @param assignment The assignment to be activated.
     */
    public synchronized void AssignmentActivator(Course course, Assignment assignment) {
        if (!courses.contains(course)) {
            throw new CourseNotFoundException();
        }
//        if (!course.getAllAssignments().contains(assignment)) {
//            throw new AssignmentNotFoundException();
//        }
        courses.get(courses.indexOf(course)).getAllAssignments().get(courses.get(courses.indexOf(course)).getAllAssignments().indexOf(assignment)).setActive(true);
        courses.get(courses.indexOf(course)).getActiveAssignments().add(assignment);
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getNationalId() {
        return NationalId;
    }

    public void setNationalId(String nationalId) {
        NationalId = nationalId;
    }

    public BeheshtiUniversityField getField() {
        return field;
    }

    public void setField(BeheshtiUniversityField field) {
        this.field = field;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name) && Objects.equals(NationalId, teacher.NationalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, NationalId);
    }
}
