package pro.sky.course_work2_question.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestedTooManyQuestions extends RuntimeException {

    public RequestedTooManyQuestions() {
        super("requested more questions than there are");
    }

}
