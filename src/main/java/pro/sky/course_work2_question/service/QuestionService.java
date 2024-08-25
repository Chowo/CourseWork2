package pro.sky.course_work2_question.service;

import pro.sky.course_work2_question.model.Question;

import java.util.Collection;

public interface QuestionService {

    public Question add(String question, String answer);

    public Question add(Question question);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion();

}
