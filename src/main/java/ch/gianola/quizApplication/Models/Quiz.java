package ch.gianola.quizApplication.Models;

public class Quiz {
    private Integer points;
    private Integer fails;
    private Integer time;
    private String username;

    public Quiz() {}

    public Quiz(Integer points, Integer fails, Integer time, String username) {
        this.points = points;
        this.fails = fails;
        this.time = time;
        this.username = username;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getFails() {
        return fails;
    }

    public void setFails(Integer fails) {
        this.fails = fails;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "points=" + points +
                ", fails=" + fails +
                ", time=" + time +
                ", username='" + username + '\'' +
                '}';
    }
}
