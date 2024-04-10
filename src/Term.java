import java.util.ArrayList;

public class Term {
    private int credit=0;
    private double avg=0;
    private int termNumber;
     ArrayList<Course> courses=new ArrayList<>();
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
        //TODO
        return 0;
    }


}
