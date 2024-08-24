package pro.sky.course_work2_question.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.course_work2_question.exceptions.RequestedTooManyQuestions;
import pro.sky.course_work2_question.model.Question;

import java.util.*;

import static pro.sky.course_work2_question.util.Util.RANDOM;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("Java") QuestionService javaQuestionService,
                               @Qualifier("Math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> javaQuestionList = new ArrayList<>(javaQuestionService.getAll());
        List<Question> mathQuestionList = new ArrayList<>(mathQuestionService.getAll());
        Set<Question> randomSetOfQuestions = new HashSet<>();
        if (amount > javaQuestionList.size() + mathQuestionList.size()) {
            throw new RequestedTooManyQuestions();
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Unacceptable amount of questions, it must be higher than 0");
        } else if (amount == javaQuestionList.size() + mathQuestionList.size()) {
            System.out.println(javaQuestionList);
            randomSetOfQuestions.addAll(javaQuestionList);
            System.out.println(randomSetOfQuestions);
            System.out.println(mathQuestionList);
            randomSetOfQuestions.addAll(mathQuestionList);
            System.out.println(randomSetOfQuestions);
            return randomSetOfQuestions;
        } else if (amount == 1) {
            int chooseOneQuestion = RANDOM.nextInt(1, 11);
            if (chooseOneQuestion % 2 == 0) {
                randomSetOfQuestions.add(javaQuestionService.getRandomQuestion());
            } else randomSetOfQuestions.add(mathQuestionService.getRandomQuestion());
        }
        int javaQuestions = RANDOM.nextInt(0, amount);
        while (randomSetOfQuestions.size() < javaQuestions) {
            randomSetOfQuestions.add(javaQuestionService.getRandomQuestion());
        }
        while (randomSetOfQuestions.size() < amount) {
            randomSetOfQuestions.add(mathQuestionService.getRandomQuestion());
        }
        return randomSetOfQuestions;

    }
}
