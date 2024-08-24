package pro.sky.course_work2_question.service;

import pro.sky.course_work2_question.model.Question;

import java.util.*;

import static pro.sky.course_work2_question.util.Util.RANDOM;

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        Question addedQuestion = new Question(question, answer);
        questions.add(addedQuestion);
        return addedQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new NoSuchElementException("Указанный вопрос отсутствует");
    }

    @Override
    public Collection<Question> getAll() {
        if (questions.isEmpty()) {
            throw new NullPointerException();
        }
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> listOfQuestions = new ArrayList<>(questions);
        return listOfQuestions.get(RANDOM.nextInt(listOfQuestions.size()));
    }
}
