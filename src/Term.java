import java.util.ArrayList;

public class Term {


    int totalThisTermCredit =0;
    private double avg=0;
    private int termNumber;
     ArrayList<StudentCourse> studentCourses =new ArrayList<StudentCourse>();
    public int getTermNumber() {
        return termNumber;
    }

    public double getAvg() {
        return avg;
    }
    public Term(int termNumber) {
        this.termNumber = termNumber;
    }
    public double avgCalculate(){
        double sum=0;
        for (int i = 0; i <studentCourses.size() ; i++) {
            sum+= studentCourses.get(i).getScore()*studentCourses.get(i).getCredit();
        }
        for (int i = 0; i <studentCourses.size() ; i++) {
            totalThisTermCredit +=studentCourses.get(i).getCredit();
        }

        return sum/ totalThisTermCredit;
    }
    public int getTotalThisTermCredit() {
        for (int i = 0; i <studentCourses.size() ; i++) {
            totalThisTermCredit +=studentCourses.get(i).getCredit();
        }
        return totalThisTermCredit;
    }
    public void setScore(StudentCourse studentCourse,double score) {
        studentCourse.score=score;
    }



}

