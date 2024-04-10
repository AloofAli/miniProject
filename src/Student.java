import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Student {
    private String name;
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
    private String FatherName;
    private Date BirthDate;
    private String NationalId;
    private String StudentId;
    private BeheshtiUniversityField field;
    private int currentTerm;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Term> terms = new ArrayList<>();

    private boolean isDormitory;
    private double totalAverage;
    private double currentAverage;
    private int totalPassedCredit;

    public void addCourse(Course course) {
        courses.add(course);
        terms.get(currentTerm-1).courses.add(course);

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public double getTotalAverage() {
        return totalAverage;
    }

    public void setTotalAverage(double totalAverage) {
        this.totalAverage = totalAverage;
    }

    public double getCurrentAverage() {
        return currentAverage;
    }

    public void setCurrentAverage(double currentAverage) {
        this.currentAverage = currentAverage;
    }

    public int getTerm() {
        return currentTerm;
    }

    public void setTerm(int term) {
        this.currentTerm = term;
    }

    public boolean isDormitory() {
        return isDormitory;
    }

    public void setDormitory(boolean dormitory) {
        isDormitory = dormitory;
    }

    public int getCredit() {
        return totalPassedCredit;
    }

    public void setCredit(int credit) {
        this.totalPassedCredit = credit;
    }

    public ArrayList<Course> termCoursesDetail(int term) {
        return terms.get(term - 1).courses;
    }

    public ArrayList<Course> termCourseDetail() {
        return terms.get(currentTerm - 1).courses;

    }

    public int termCreditDetail(int term) {
        return terms.get(term - 1).getCredit();
    }

    public int termCreditDetail() {
        return terms.get(currentTerm - 1).getCredit();

    }
    public double termAvgDetail(int term) {
        return terms.get(term - 1).avgCalculate();
    }

    public double termAvgDetail() {
        return terms.get(currentTerm - 1).avgCalculate();

    }
    public void newTerm(){
        currentTerm++;
        terms.add(new Term(currentTerm));
    }
    public void totalAvg(){
        //TODO
    }
    public void coursePrinter(){
        System.out.println(courses);
    }
    public void TotalPassedCreditPrinter(){
        System.out.println(totalPassedCredit);
    }
    public void totalAvgPrinter(){
        totalAvg();
        System.out.println(totalAverage);
    }

}