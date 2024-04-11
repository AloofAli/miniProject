import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Teacher {

    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
    private Date BirthDate;


    private Gender gender;
    private String FatherName;
    private String NationalId;
    private String StudentId;


    private String phoneNumber;
    private BeheshtiUniversityField field;
    private int numberOfCourses;

    public void AddStudent(Course course,Student student) {
        courses.get(courses.indexOf(course)).AddStudent(student);
        student.addCourse(new StudentCourse(course.name,course.credit));
    }

    public void RemoveStudent(Course course,Student student) {
        courses.get(courses.indexOf(course)).RemoveStudent(student);
        StudentCourse removeHelper=new StudentCourse(name, course.credit);
        student.terms.getLast().studentCourses.remove(removeHelper);
    }

    public void AddAssignment(Course course,Assignment assignment) {
        courses.get(courses.indexOf(course)).ActiveAssignment.add(assignment);
        courses.get(courses.indexOf(course)).AllAssignment.add(assignment);
    }

    public void RemoveAssignment(Course course , Assignment assignment) {
        courses.get(courses.indexOf(course))
                                                            .ActiveAssignment
                                                                     .remove(assignment);

        courses.get(courses.indexOf(course))
                                                            .AllAssignment.get(courses.get(courses.indexOf(course))
                                                                     .AllAssignment.indexOf(assignment))
                                                                              .setActive(false);
    }

    public void Score(Course course, Student student, double score) {
        for (int i = 0; i <courses.get(courses.indexOf(course)).students.get(courses.get(courses.indexOf(course)).students.indexOf(student)).terms.getLast().studentCourses.size() ; i++) {

        if(courses.get(courses.indexOf(course)).students.get(courses.get(courses.indexOf(course)).students.indexOf(student)).terms.getLast().studentCourses.get(i).getName()==course.name){
            courses.get(courses.indexOf(course)).students.get(courses.get(courses.indexOf(course)).students.indexOf(student)).terms.getLast().studentCourses.get(i).setScore(score);
        }
        }
    }

    public void DeadLineTimeEdit(Course course, Assignment assignment, Date newDate) {
        courses.get(courses.indexOf(course)).AllAssignment.get( courses.get(courses.indexOf(course)).AllAssignment.indexOf(assignment)).setDeadLine(newDate);
        courses.get(courses.indexOf(course)).ActiveAssignment.get( courses.get(courses.indexOf(course)).ActiveAssignment.indexOf(assignment)).setDeadLine(newDate);
    }

    public void AssignmentActivator(Course course, Assignment assignment, boolean isActive) {
        courses.get(courses.indexOf(course)).AllAssignment.get( courses.get(courses.indexOf(course)).AllAssignment.indexOf(assignment)).setActive(isActive);
        if (isActive)
        courses.get(courses.indexOf(course)).ActiveAssignment.get( courses.get(courses.indexOf(course)).ActiveAssignment.indexOf(assignment)).setActive(true);
        else {
            courses.get(courses.indexOf(course)).ActiveAssignment.remove(assignment);
        }
    }


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

}
