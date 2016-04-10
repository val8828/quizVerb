package group.quiz;

/**
 * The interface is designed for the case of changing the logic of game
 */
public interface QuizService {

    String getVerb(VerbForm verbForm);

    boolean checkVerb(String quizVerb, VerbForm quizVerbForm, String answerVerb, VerbForm answerVerbForm);
}
