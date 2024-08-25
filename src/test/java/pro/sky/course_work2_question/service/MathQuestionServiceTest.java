package pro.sky.course_work2_question.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work2_question.exceptions.MathMethodMethodNotAllowedException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.course_work2_question.constants.ServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    private final QuestionService out = new MathQuestionService();


    @Test
    void verify_that_adding_throws_exception1() {
        assertThrows(MathMethodMethodNotAllowedException.class, () -> out.add(MATH_QUESTION1));
    }
    @Test
    void verify_that_adding_throws_exception2() {
        String question = "Question";
        String answer = "Answer";
        assertThrows(MathMethodMethodNotAllowedException.class, () -> out.add(question, answer));
    }

    @Test
    void verify_that_removing_question_will_throw_exception() {
        assertThrows(MathMethodMethodNotAllowedException.class, () -> out.remove(MATH_QUESTION1));

    }

    @Test
    void verify_that_getAll_throws_exception() {
        assertThrows(MathMethodMethodNotAllowedException.class, () -> out.getAll());
    }

    @Test
    void verify_that_random_is_made() {
        assertNotNull(out.getRandomQuestion());
    }
}

