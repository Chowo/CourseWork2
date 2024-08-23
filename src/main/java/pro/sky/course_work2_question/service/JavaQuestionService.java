package pro.sky.course_work2_question.service;

import pro.sky.course_work2_question.model.Question;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private Random random;


    public JavaQuestionService() {
        questions = new HashSet<>();
        random = new Random(System.currentTimeMillis());
    }

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
    public Question remove(String question, String answer) {
        Question removableQuestion = new Question(question, answer);
        if (questions.contains(removableQuestion)) {
            questions.remove(removableQuestion);
            return removableQuestion;
        }
        throw new NoSuchElementException("Указанный вопрос отсутствует");
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
    public Set<Question> getAll() {
        if (questions.isEmpty()) {
            throw new NullPointerException();
        }
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> listOfQuestions = new ArrayList<>(questions);
        Collections.shuffle(listOfQuestions);
        return listOfQuestions.get(random.nextInt(listOfQuestions.size()));
    }
//    @Override
//    public Question getRandomQuestion() {
//        int randomIndex = ThreadLocalRandom.current().nextInt(questions.size()-1);
//        return questions.stream().skip(randomIndex).findFirst().orElseThrow();
//    }
}
