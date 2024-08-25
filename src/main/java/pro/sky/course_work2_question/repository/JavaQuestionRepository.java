package pro.sky.course_work2_question.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.course_work2_question.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        questions.add(new Question("JavaQuestion1", "JavaAnswer1"));
        questions.add(new Question("JavaQuestion2", "JavaAnswer2"));
        questions.add(new Question("JavaQuestion3", "JavaAnswer3"));
        questions.add(new Question("JavaQuestion4", "JavaAnswer4"));
        questions.add(new Question("JavaQuestion5", "JavaAnswer5"));
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
