package pro.sky.course_work2_question.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_work2_question.model.Question;
import pro.sky.course_work2_question.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("Math") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam("Question") String question, @RequestParam("Answer") String answer) {
        return questionService.add(question, answer);
    }
    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam("Question") String question, @RequestParam("Answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

}
