package pro.sky.course_work2_question.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.course_work2_question.exceptions.MathMethodMethodNotAllowedException;
import pro.sky.course_work2_question.model.Question;

import java.util.Collection;

import static pro.sky.course_work2_question.util.Util.RANDOM;

@Service
@Qualifier("Math")
public class MathQuestionService implements QuestionService {

    private final String[] signs = {"+", "-", "/", "*"};


    @Override
    public Question add(String question, String answer) {
        throw new MathMethodMethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MathMethodMethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MathMethodMethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MathMethodMethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        StringBuilder question = new StringBuilder();
        int firstNumber = RANDOM.nextInt(0, 1000);
        int secondNumber = RANDOM.nextInt(1, 1000);
        int signNumberEquivalent = RANDOM.nextInt(4);
        question.append(firstNumber)
                .append(" ")
                .append(signs[signNumberEquivalent])
                .append(" ")
                .append(secondNumber);
        Integer answer = 0;
        //0 : +     1 : -     2 : /     3 : *
        switch (signNumberEquivalent) {
            case 0:
                answer = firstNumber + secondNumber;
                break;
            case 1:
                answer = firstNumber - secondNumber;
                break;
            case 2:
                answer = firstNumber / secondNumber;
                break;
            case 3:
                answer = firstNumber * secondNumber;
                break;
        }
        return new Question(question.toString(), answer.toString());
    }
}
