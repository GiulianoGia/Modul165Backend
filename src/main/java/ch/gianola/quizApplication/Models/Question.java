package ch.gianola.quizApplication.Models;

import java.util.List;

public class Question {
    public String question;
    public String result;
    public List<String> selection;

    public Question() {}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String> getSelection() {
        return selection;
    }

    public void setSelection(List<String> selection) {
        this.selection = selection;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", result='" + result + '\'' +
                ", selection=" + selection +
                '}';
    }
}
