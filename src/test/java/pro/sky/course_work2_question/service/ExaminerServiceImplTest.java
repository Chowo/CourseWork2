package pro.sky.course_work2_question.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work2_question.exceptions.RequestedTooManyQuestions;
import pro.sky.course_work2_question.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.course_work2_question.constants.ExaminerServiceTestConstants.QUESTIONS;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void should_throw_RequestedTooManyQuestionsException() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
        assertThrows(RequestedTooManyQuestions.class, () -> out.getQuestions(6));
    }

    @Test
    void should_throw_IllegalArgumentException() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
        assertThrows(IllegalArgumentException.class, () -> out.getQuestions(0));
    }

    @Test
    void verify_that_we_get_all_questions_when_requested() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
        assertEquals(out.getQuestions(4).size(), 4);
    }

    @Test
    void verify_that_we_get_requested_amount_of_questions_when_amount_is_not_equals_size_of_set() {
        List<Question> listOfQuestions = new ArrayList<>(QUESTIONS);
        Question expected = listOfQuestions.get(new Random().nextInt(listOfQuestions.size()));
        when(questionService.getAll()).thenReturn(QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(expected);

        Collection<Question> actual = out.getQuestions(1);

        assertEquals(out.getQuestions(1).size(), 1);
        assertThat(actual).contains(expected);

    }


}
