import java.util.ArrayList;

public class Term {
    private int credit=0;
    private double avg=0;
    private int termNumber;
     ArrayList<StudentCourse> studentCourses =new ArrayList<>();
    public int getTermNumber() {
        return termNumber;
    }

    public double getAvg() {
        return avg;
    }
    public int getCredit() {
        return credit;
    }
    public Term(int termNumber) {
        this.termNumber = termNumber;
    }
    public double avgCalculate(){
        double sum=0;
        for (int i = 0; i <studentCourses.size() ; i++) {
            sum+= studentCourses.get(i).getScore()*studentCourses.get(i).getCredit();
        }
        return sum/credit;
    }



}

