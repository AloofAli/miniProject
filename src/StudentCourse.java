public class StudentCourse {
    String name;
    Double score=0.0;

    int credit;

    public StudentCourse(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }


    public void setScore(double score) {
        this.score=score;
    }
}
