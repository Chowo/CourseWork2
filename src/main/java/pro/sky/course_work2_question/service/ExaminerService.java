package pro.sky.course_work2_question.service;

import pro.sky.course_work2_question.model.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}
