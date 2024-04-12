import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a student in the Beheshti University system.
 * It contains information such as name, gender, birth date, national ID, student ID, field of study, phone number,
 * whether the student is living in the dormitory or not, and a list of terms that the student has attended.
 * The class also contains methods for calculating the average grade of the student, adding a new term, and printing
 * information about the student's courses and grades.
 */
public class Student {

    private String name;
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");

    private Gender gender;
    private String FatherName;
    private Date BirthDate;
    private String NationalId;
    private String StudentId;
    private BeheshtiUniversityField field;
    private String phoneNumber;
    private int currentTerm=0;

    ArrayList<Term> terms = new ArrayList<>();

    private boolean isDormitory;
    private double totalAverage=0;
    private double currentAverage=0;

    int totalPassedCredit=0;

    /**
     * Calculates the total number of credits that the student has passed.
     * @return the total number of credits that the student has passed
     */
    public int getTotalPassedCredit() {
        // have test
        for (int i = 0; i < terms.size(); i++) {
            totalPassedCredit+=terms.get(i).getTotalThisTermCredit();
        }
        return totalPassedCredit;
    }

    /**
     * Adds a new course to the student's list of courses.
     * @param course the course to be added
     */
    public void addCourse(Course course) {
        course.AddStudent(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }
    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
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

    /**
     * Returns the list of courses that the student has taken in a specific term.
     * @param term the term of the courses
     * @return the list of courses that the student has taken in the specified term
     */
    public ArrayList<StudentCourse> termCourseDetail(int term) {
        return terms.get(term - 1).studentCourses;
    }

    /**
     * Returns the list of courses that the student has taken in the current term.
     * @return the list of courses that the student has taken in the current term
     */
    public ArrayList<StudentCourse> termCourseDetail() {
        return terms.get(currentTerm - 1).studentCourses;

    }

    /**
     * Returns the total number of credits that the student has taken in a specific term.
     * @param term the term of the credits
     * @return the total number of credits that the student has taken in the specified term
     */
    public int termCreditDetail(int term) {
        if(terms.size()<term)
            throw new DontHaveThisTermException();

        return terms.get(term - 1).getTotalThisTermCredit();
    }

    /**
     * Returns the total number of credits that the student has taken in the current term.
     * @return the total number of credits that the student has taken in the current term
     */
    public int termCreditDetail() {
        return terms.get(currentTerm - 1).getTotalThisTermCredit();

    }

    /**
     * Returns the average grade of the student in a specific term.
     * @param term the term of the average grade
     * @return the average grade of the student in the specified term
     */
    public double termAvgDetail(int term) {
        if(terms.size()<term)
            throw new DontHaveThisTermException();
        return terms.get(term - 1).avgCalculate();
    }

    /**
     * Returns the average grade of the student in the current term.
     * @return the average grade of the student in the current term
     */
    public double termAvgDetail() {
        return terms.get(currentTerm - 1).avgCalculate();

    }

    /**
     * Adds a new term to the student's list of terms.
     */
    public void newTerm(){
        currentTerm++;
        terms.add(new Term(currentTerm));
    }

    /**
     * Calculates the total average grade of the student.
     * @return the total average grade of the student
     */
    public double totalAvg(){
        double sum=0;
        for (int i = 0; i <terms.size() ; i++) {
            for (int j = 0; j <terms.get(i).studentCourses.size() ; j++) {

           sum+= terms.get(i).studentCourses.get(j).getScore()*terms.get(i).studentCourses.get(j).getCredit();
            }
        }
        totalAverage=sum/getTotalPassedCredit();
        return totalAverage;
    }

    /**
     * Prints all the courses that the student has taken.
     */
    public void AllCoursePrinter(){
        for (int i = 0; i < terms.size(); i++) {
            System.out.println(terms.get(i).studentCourses);
        }
    }

    /**
     * Prints the total number of credits that the student has passed.
     */
    public void TotalPassedCreditPrinter(){

        System.out.println(getTotalPassedCredit());
    }

    /**
     * Prints the total average grade of the student.
     */
    public void totalAvgPrinter(){
        System.out.println(totalAvg());
    }

    /**
     * Prints the average grade of the student in the current term.
     */
    public void CurrentTermAvgPrinter(){
        System.out.println(termAvgDetail());
    }


    public Gender getGender() {
        return gender;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Checks if two students are equal.
     * @param student the student to be compared
     * @return true if the two students have the same national ID, false otherwise
     */
    public boolean equals(Student student) {
        return student.getNationalId() == this.NationalId;
    }


}
