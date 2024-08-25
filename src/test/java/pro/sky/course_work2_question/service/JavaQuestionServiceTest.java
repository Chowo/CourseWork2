package pro.sky.course_work2_question.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work2_question.exceptions.QuestionIsAlreadyAddedException;
import pro.sky.course_work2_question.model.Question;
import pro.sky.course_work2_question.repository.JavaQuestionRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.course_work2_question.constants.ServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository repository;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    void verify_that_adding_existing_question_throws_exception() {
        when(repository.getAll()).thenReturn(JAVA_QUESTIONS);

        assertThrows(QuestionIsAlreadyAddedException.class, () -> out.add(JAVA_QUESTION1));
    }

    @Test
    void verify_that_question_was_added() {
        Question comparableQuestion = new Question("Question5", "Answer5");
        when(repository.add(comparableQuestion)).thenReturn(comparableQuestion);
        assertEquals(out.add("Question5", "Answer5"), comparableQuestion);
    }

    @Test
    void verify_that_question_was_removed() {
        Question removedQuestion = new Question("Question1", "Answer1");
        Set<Question> comparableSet = Set.of(JAVA_QUESTION2, JAVA_QUESTION3, JAVA_QUESTION4);
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
        when(repository.getAll()).thenReturn(JAVA_QUESTIONS);
        assertNotNull(out.getRandomQuestion());
    }


}
