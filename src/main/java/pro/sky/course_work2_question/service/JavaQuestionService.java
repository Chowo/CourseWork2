package pro.sky.course_work2_question.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.course_work2_question.exceptions.QuestionIsAlreadyAddedException;
import pro.sky.course_work2_question.model.Question;
import pro.sky.course_work2_question.repository.JavaQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static pro.sky.course_work2_question.util.Util.RANDOM;

@Service
@Qualifier("Java")
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository repository;


    public JavaQuestionService(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        Question addedQuestion = new Question(question, answer);
        if (repository.getAll().contains(addedQuestion)) {
            throw new QuestionIsAlreadyAddedException(addedQuestion);
        }
        return repository.add(addedQuestion);
    }

    @Override
    public Question add(Question question) {
        if (repository.getAll().contains(question)) {
            throw new QuestionIsAlreadyAddedException(question);
        }
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        repository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        if (repository.getAll().isEmpty()) {
            throw new NullPointerException("There is no questions");
        }
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> listOfQuestions = new ArrayList<>(repository.getAll());
        if (listOfQuestions.isEmpty()) {
            throw new NullPointerException("There is no questions");
        }
        return listOfQuestions.get(RANDOM.nextInt(listOfQuestions.size()));
    }
}
