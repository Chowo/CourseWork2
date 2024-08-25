package pro.sky.course_work2_question.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.course_work2_question.exceptions.RequestedTooManyQuestions;
import pro.sky.course_work2_question.model.Question;

import java.util.*;

import static pro.sky.course_work2_question.util.Util.RANDOM;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> services = new ArrayList<>();


    public ExaminerServiceImpl(@Qualifier("Java") QuestionService javaQuestionService,
                               @Qualifier("Math") QuestionService mathQuestionService) {
        services.add(javaQuestionService);
        services.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questionList = new ArrayList<>();
        for (QuestionService service : services) {
            questionList.addAll(service.getAll());
        }
        Set<Question> randomSetOfQuestions = new HashSet<>();
        if (amount > questionList.size()) {
            throw new RequestedTooManyQuestions();
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Unacceptable amount of questions, it must be higher than 0");
        } else if (amount == questionList.size()) {
            randomSetOfQuestions.addAll(questionList);
            return randomSetOfQuestions;
        } else if (amount == 1) {
            randomSetOfQuestions.add(questionList.get(RANDOM.nextInt(questionList.size())));
            return randomSetOfQuestions;
        }

        while (randomSetOfQuestions.size() < amount) {
            randomSetOfQuestions.add(services.get(RANDOM.nextInt(services.size())).getRandomQuestion());
        }

        return randomSetOfQuestions;

    }
}
