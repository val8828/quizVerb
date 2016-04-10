package group.quiz;

import group.quizStatistic.StatisticsService;

public class QuizServiceImpl implements QuizService {
    private QuizDAO quizDAO;
    private StatisticsService statisticsService;

    public String getVerb(VerbForm verbForm) {
        return quizDAO.getRandomVerb(verbForm);
    }

    public boolean checkVerb(String quizVerb, VerbForm quizVerbForm, String answerVerb, VerbForm answerVerbForm) {
        boolean answer = compareAnswer(quizVerb, quizVerbForm, answerVerb, answerVerbForm);
        statisticsService.addStatistic(answer);
        return answer;
    }

    private boolean compareAnswer(String requestVerb,
                                  VerbForm requestVerbForm,
                                  String responseVerb,
                                  VerbForm responseVerbForm) {
        String expectedResponseVerb = quizDAO.getVerbByOtherForm(requestVerb, requestVerbForm, responseVerbForm);
        return responseVerb.equals(expectedResponseVerb);
    }

    public void setQuizDAO(QuizDAO quizDAO) {
        this.quizDAO = quizDAO;
    }

    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }
}