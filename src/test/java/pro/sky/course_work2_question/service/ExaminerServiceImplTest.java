package pro.sky.course_work2_question.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work2_question.exceptions.RequestedTooManyQuestions;
import pro.sky.course_work2_question.model.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.course_work2_question.constants.ServiceTestConstants.JAVA_QUESTIONS;
import static pro.sky.course_work2_question.constants.ServiceTestConstants.MATH_QUESTIONS;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;

    private ExaminerServiceImpl out;

    @BeforeEach
    public void initOut() {
        out = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }


    @Test
    void should_throw_RequestedTooManyQuestionsException() {
        assertThrows(RequestedTooManyQuestions.class, () -> out.getQuestions(9));
    }

    @Test
    void should_throw_IllegalArgumentException_when_amount_is_0_or_less() {
        assertThrows(IllegalArgumentException.class, () -> out.getQuestions(0));
    }

    @Test
    void verify_that_we_get_all_questions_when_requested() {
        when(javaQuestionService.getAll()).thenReturn(JAVA_QUESTIONS);
        when(mathQuestionService.getAll()).thenReturn(MATH_QUESTIONS);
        assertEquals(8, out.getQuestions(8).size());
    }

    @Test
    void verify_that_we_get_at_least_one_question() {
        when(javaQuestionService.getAll()).thenReturn(JAVA_QUESTIONS);
        when(mathQuestionService.getAll()).thenReturn(MATH_QUESTIONS);

        Collection<Question> actual = out.getQuestions(1);

        assertEquals(out.getQuestions(1).size(), 1);
    }
}
