package pro.sky.course_work2_question.service;

import pro.sky.course_work2_question.model.Question;

import java.util.Set;

public interface QuestionService {

    public Question add(String question, String answer);

    public Question add(Question question);

    Question remove(String question, String answer);

    public Question remove(Question question);

    public Set<Question> getAll();

    public Question getRandomQuestion();

}
