package ch.gianola.quizApplication.Controller;

import ch.gianola.quizApplication.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.gianola.quizApplication.Models.Quiz;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/all/quiz")
    public List<Quiz> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    @PostMapping("/post/quiz")
    public void setQuiz(@RequestParam("fails") Integer fails, @RequestParam("username") String username, @RequestParam("time") Integer time, @RequestParam("points") Integer points) {
        Quiz quiz = new Quiz(points, fails, time, username);
        quizService.setQuiz(quiz);
    }
}
