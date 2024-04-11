import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private int currentTerm=1;

     ArrayList<Term> terms = new ArrayList<>();

    private boolean isDormitory;
    private double totalAverage=0;
    private double currentAverage=0;

    int totalPassedCredit=0;
    public int getTotalPassedCredit() {
        for (int i = 0; i < terms.size(); i++) {
            totalPassedCredit+=terms.get(i).getTotalThisTermCredit();
        }
        return totalPassedCredit;
    }



    public void addCourse(StudentCourse course) {
        terms.get(currentTerm-1).studentCourses.add(course);

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



    public ArrayList<StudentCourse> termCoursesDetail(int term) {
        return terms.get(term - 1).studentCourses;
    }

    public ArrayList<StudentCourse> termCourseDetail() {
        return terms.get(currentTerm - 1).studentCourses;

    }

    public int termCreditDetail(int term) {
        if(terms.size()<term)
            throw new DontHaveThisTermException();

        return terms.get(term - 1).getTotalThisTermCredit();
    }

    public int termCreditDetail() {
        return terms.get(currentTerm - 1).getTotalThisTermCredit();

    }
    public double termAvgDetail(int term) {
        if(terms.size()<term)
            throw new DontHaveThisTermException();
        return terms.get(term - 1).avgCalculate();
    }

    public double termAvgDetail() {
        return terms.get(currentTerm - 1).avgCalculate();

    }
    public void newTerm(){
        currentTerm++;
        terms.add(new Term(currentTerm));
    }
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
    public void AllCoursePrinter(){
        for (int i = 0; i < terms.size(); i++) {
            System.out.println(terms.get(i).studentCourses);
        }
    }
    public void TotalPassedCreditPrinter(){

        System.out.println(getTotalPassedCredit());
    }
    public void totalAvgPrinter(){
        System.out.println(totalAvg());
    }
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

    public boolean equals(Student student) {
        return student.getNationalId() == this.NationalId;
    }

}
