package pro.sky.course_work2_question.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work2_question.exceptions.QuestionIsAlreadyAddedException;
import pro.sky.course_work2_question.model.Question;
import pro.sky.course_work2_question.repository.MathQuestionRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.course_work2_question.constants.ExaminerServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository repository;

    @InjectMocks
    private MathQuestionService out;

    @Test
    void verify_that_adding_existing_question_throws_exception() {
        when(repository.getAll()).thenReturn(MATH_QUESTIONS);

        assertThrows(QuestionIsAlreadyAddedException.class, () -> out.add(MATH_QUESTION1));
    }

    @Test
    void verify_that_math_question_was_added() {
        Question comparableQuestion = new Question("Question5", "Answer5");
        when(repository.add(comparableQuestion)).thenReturn(comparableQuestion);
        assertEquals(out.add("Question5", "Answer5"), comparableQuestion);
    }

    @Test
    void verify_that_question_was_removed() {
        Question removedQuestion = new Question("Question1", "Answer1");
        Set<Question> comparableSet = Set.of(MATH_QUESTION2, MATH_QUESTION3, MATH_QUESTION4);
        when(repository.remove(removedQuestion)).thenReturn(removedQuestion);
        when(repository.getAll()).thenReturn(comparableSet);
        assertEquals(out.remove(new Question("Question1", "Answer1")), removedQuestion);
        assertFalse(out.getAll().contains(removedQuestion));
    }

    @Test
    void verify_that_getAll_throws_exception_when_it_is_empty() {
        when(repository.getAll()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> out.getAll());
    }

    @Test
    void verify_that_random_question_throws_exception_when_set_is_empty() {
        when(repository.getAll()).thenReturn(null);
        assertThrows(NullPointerException.class, out::getRandomQuestion);
    }

    @Test
    void verify_that_random_is_not_null() {
        when(repository.getAll()).thenReturn(MATH_QUESTIONS);
        assertNotNull(out.getRandomQuestion());
    }
}

