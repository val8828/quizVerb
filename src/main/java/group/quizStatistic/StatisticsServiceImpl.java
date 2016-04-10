package group.quizStatistic;

/**
 * service statistic
 */
public class StatisticsServiceImpl implements StatisticsService {
    private StatisticDAO statisticDAO;


    public Statistics getStatistics() {
        return statisticDAO.getStatistic();
    }

    public void addStatistic(boolean answer) {
        statisticDAO.addStatistic(answer);
    }

    public void setStatisticDAO(StatisticDAO statisticDAO) {
        this.statisticDAO = statisticDAO;
    }
}
