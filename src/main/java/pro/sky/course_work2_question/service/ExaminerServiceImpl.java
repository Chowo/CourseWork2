package pro.sky.course_work2_question.service;

import org.springframework.stereotype.Service;
import pro.sky.course_work2_question.exceptions.RequestedTooManyQuestions;
import pro.sky.course_work2_question.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> randomSetOfQuestions = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new RequestedTooManyQuestions();
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Unacceptable amount of questions, it must be higher than 0");
        } else if (amount == questionService.getAll().size()) {
            System.out.println(questionService.getAll());
            return questionService.getAll();
        }

        while (randomSetOfQuestions.size() < amount) {
            randomSetOfQuestions.add(questionService.getRandomQuestion());
        }
        return randomSetOfQuestions;
    }
}
