package pro.sky.course_work2_question.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_work2_question.model.Question;
import pro.sky.course_work2_question.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Question> getQuestions(@RequestParam("amountOfQuestions") int amount) {
        return service.getQuestions(amount);
    }
}
