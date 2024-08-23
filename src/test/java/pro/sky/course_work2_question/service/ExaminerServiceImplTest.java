package pro.sky.course_work2_question.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work2_question.exceptions.RequestedTooManyQuestions;
import pro.sky.course_work2_question.model.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.course_work2_question.constants.ExaminerServiceTestConstants.*;


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
    void verify_that_we_get_requested_amount_of_questions_when_not_equals_size_of_set() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
        assertEquals(out.getQuestions(2).size(), 2);

    }



}
