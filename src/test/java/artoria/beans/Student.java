package artoria.beans;

public class Student extends Person {

    private static final Integer DEFAULT_SCORE = 0;

    private Integer score;
    private String email;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
