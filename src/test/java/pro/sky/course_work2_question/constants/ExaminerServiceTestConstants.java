package pro.sky.course_work2_question.constants;

import pro.sky.course_work2_question.model.Question;

import java.util.Set;

public class ExaminerServiceTestConstants {
    public static final Question JAVA_QUESTION1 = new Question("Java Question1", "Java Answer1");
    public static final Question JAVA_QUESTION2 = new Question("Java Question2", "Java Answer2");
    public static final Question JAVA_QUESTION3 = new Question("Java Question3", "Java Answer3");
    public static final Question JAVA_QUESTION4 = new Question("Java Question4", "Java Answer4");

    public static final Question MATH_QUESTION1 = new Question("Math Question1", "Math Answer1");
    public static final Question MATH_QUESTION2 = new Question("Math Question2", "Math Answer2");
    public static final Question MATH_QUESTION3 = new Question("Math Question3", "Math Answer3");
    public static final Question MATH_QUESTION4 = new Question("Math Question4", "Math Answer4");

    public static final Set<Question> JAVA_QUESTIONS = Set.of(JAVA_QUESTION1, JAVA_QUESTION2, JAVA_QUESTION3, JAVA_QUESTION4);
    public static final Set<Question> MATH_QUESTIONS = Set.of(MATH_QUESTION1, MATH_QUESTION2, MATH_QUESTION3, MATH_QUESTION4);


}
