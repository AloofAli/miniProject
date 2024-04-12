import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Teacher {

    private String name;
     ArrayList<Course> courses = new ArrayList<>();

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
    private Date BirthDate;


    private Gender gender;
    private String FatherName;
    private String NationalId;
    private String StudentId;


    private String phoneNumber;
    private BeheshtiUniversityField field;
    private int numberOfCourses;

    public void AddCourse(Course course){
        courses.add(course);
        course.teacherName=name;
    }
    public void RemoveCourse(Course course){
        courses.remove(course);
    }
    public void AddStudent(Course course,Student student) {
        course.AddStudent(student);
    }

    public void RemoveStudent(Course course,Student student) {
        course.RemoveStudent(student);

    }

    public void AddAssignment(Course course,Assignment assignment) {
        course.AllAssignments.add(assignment);
    }

    public void RemoveAssignment(Course course , Assignment assignment) {
        if (assignment.Active){
        course.ActiveAssignments.remove(assignment);}
    }

    public void Score(Course course, Student student, double score) {
        for (int i = 0; i <student.terms.getLast().studentCourses.size() ; i++) {

        if(student.terms.getLast().studentCourses.get(i).name==course.name){
            student.terms.getLast().studentCourses.get(i).setScore(score);
        }
        }
    }

    public void DeadLineTimeEdit(Course course, Assignment assignment, Date newDate) {
        courses.get(courses.indexOf(course)).AllAssignments.get( courses.get(courses.indexOf(course)).AllAssignments.indexOf(assignment)).setDeadLine(newDate);
        courses.get(courses.indexOf(course)).ActiveAssignments.get( courses.get(courses.indexOf(course)).ActiveAssignments.indexOf(assignment)).setDeadLine(newDate);
    }

    public void AssignmentActivator(Course course, Assignment assignment ){
        courses.get(courses.indexOf(course)).AllAssignments.get( courses.get(courses.indexOf(course)).AllAssignments.indexOf(assignment)).setActive(true);
        courses.get(courses.indexOf(course)).ActiveAssignments.add(assignment);}



    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
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
 public Student getTopStudent(Course course ){
        return course.GetTopStudent();
 }
}
