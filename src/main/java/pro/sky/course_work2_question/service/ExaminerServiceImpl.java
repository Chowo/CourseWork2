package pro.sky.course_work2_question.service;

import org.springframework.stereotype.Service;
import pro.sky.course_work2_question.exceptions.RequestedTooManyQuestions;
import pro.sky.course_work2_question.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> randomSetOfQuestions = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new RequestedTooManyQuestions();
        }
        if (amount == questionService.getAll().size()) {
            return questionService.getAll();
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Unacceptable amount of questions, it must be higher than 0");
        }
        while (randomSetOfQuestions.size() < amount) {
            randomSetOfQuestions.add(questionService.getRandomQuestion());
        }
        return randomSetOfQuestions;
    }
}
