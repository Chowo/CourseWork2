package pro.sky.course_work2_question.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "requested more questions than there are")
public class RequestedTooManyQuestions extends RuntimeException {

    public RequestedTooManyQuestions() {
        super("requested more questions than there are");
    }

}
