package pro.sky.course_work2_question.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.sky.course_work2_question.model.Question;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionIsAlreadyAddedException extends RuntimeException {
    public QuestionIsAlreadyAddedException(Question question) {
        super("Question - [%s] with answer - [%s] already added".formatted(question.getQuestion(), question.getAnswer()));
    }
}
