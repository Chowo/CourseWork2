package pro.sky.course_work2_question.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.MethodNotAllowedException;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MathMethodMethodNotAllowedException extends NullPointerException {
    public MathMethodMethodNotAllowedException() {
        super("Method not allowed");
    }
}
