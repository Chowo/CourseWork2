package pro.sky.course_work2_question.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.course_work2_question.model.Question;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private QuestionService out = new JavaQuestionService();

    @BeforeEach
    void make_a_set_of_questions() {
        out.add("Question1", "Answer1");
        out.add("Question2", "Answer2");
        out.add("Question3", "Answer3");
        out.add("Question4", "Answer4");

    }

    @Test
    void should_return_NullPointerException() {
        out = new JavaQuestionService();
        assertThrows(NullPointerException.class, out::getAll);
    }

    @Test
    void verify_that_question_was_added() {
        Question comparableQuestion = new Question("Question5", "Answer5");
        assertEquals(out.add("Question5", "Answer5"), comparableQuestion);
    }

    @Test
    void verify_that_question_was_removed() {
        Question removedQuestion = new Question("Question1", "Answer1");
        out.remove(removedQuestion);
        assertFalse(out.getAll().contains(removedQuestion));
    }

    @Test
    void verify_that_random_question_throws_exception_when_set_is_empty() {
        out = new JavaQuestionService();
        assertThrows(IllegalArgumentException.class, out::getRandomQuestion);
    }

    @Test
    void verify_that_random_is_not_null() {
        assertNotNull(out.getRandomQuestion());
    }


}
