package pro.sky.course_work2_question.constants;

import pro.sky.course_work2_question.model.Question;
import pro.sky.course_work2_question.service.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceTestConstants {
    public static final Question QUESTION1 = new Question("Question1", "Answer1");
    public static final Question QUESTION2 = new Question("Question2", "Answer2");
    public static final Question QUESTION3 = new Question("Question3", "Answer3");
    public static final Question QUESTION4 = new Question("Question4", "Answer4");

    public static final Set<Question> QUESTIONS = Set.of(QUESTION1, QUESTION2, QUESTION3, QUESTION4);

    public static final JavaQuestionService SERVICE = new JavaQuestionService();
    { SERVICE.add(QUESTION1);
        SERVICE.add(QUESTION2);
        SERVICE.add(QUESTION3);
        SERVICE.add(QUESTION4);
    }
}
