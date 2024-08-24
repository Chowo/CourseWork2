package pro.sky.course_work2_question.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.course_work2_question.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        questions.add(new Question("MathQuestion1", "MathAnswer1"));
        questions.add(new Question("MathQuestion2", "MathAnswer2"));
        questions.add(new Question("MathQuestion3", "MathAnswer3"));
        questions.add(new Question("MathQuestion4", "MathAnswer4"));
        questions.add(new Question("MathQuestion5", "MathAnswer5"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
