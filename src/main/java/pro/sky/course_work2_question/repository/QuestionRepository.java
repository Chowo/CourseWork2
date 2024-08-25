package pro.sky.course_work2_question.repository;

import pro.sky.course_work2_question.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    public Question add(Question question);

    public Question remove(Question question);

    public Collection<Question> getAll();
}
