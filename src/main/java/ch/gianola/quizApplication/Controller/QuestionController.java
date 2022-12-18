package ch.gianola.quizApplication.Controller;

import ch.gianola.quizApplication.Models.Question;
import ch.gianola.quizApplication.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/all/questions")
    public List<Question> getAllQuestions() {
        return questionService.getALlQuestions();
    }

    @GetMapping("/get/question/name")
    public Question getQuestionByName(@RequestParam("questionName") String questionName) {
        return questionService.getQuestionByName(questionName);
    }
}
