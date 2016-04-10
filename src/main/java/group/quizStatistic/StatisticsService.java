package group.quizStatistic;

/**
 * Statistics Service
 */
public interface StatisticsService {
    Statistics getStatistics();

    void addStatistic(boolean answer);
}
