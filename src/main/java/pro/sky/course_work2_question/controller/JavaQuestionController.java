package pro.sky.course_work2_question.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_work2_question.model.Question;
import pro.sky.course_work2_question.service.QuestionService;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam("Question") String question, @RequestParam("Answer") String answer) {
        return service.add(question, answer);
    }
    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam("Question") String question, @RequestParam("Answer") String answer) {
        return service.remove(question, answer);
    }
    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

}
