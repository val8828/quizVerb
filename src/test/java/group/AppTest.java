package group;

import group.quizStatistic.StatisticDAOImpl;
import group.quizStatistic.Statistics;
import group.quizStatistic.StatisticsServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * couple of Unit test for demonstration.
 */
public class AppTest  {
    StatisticsServiceImpl statisticsService;
    @Before
    public void initStatistic(){
        StatisticDAOImpl statisticDAO = new StatisticDAOImpl();
        statisticsService = new StatisticsServiceImpl();
        statisticsService.setStatisticDAO(statisticDAO);
    }

    @Test
    public void statisticYesTest(){
        statisticsService.addStatistic(true);
        Statistics statistic=statisticsService.getStatistics();
        assert statistic.getYesCount()==1;
    }

    @Test
    public void statisticNoTest(){
        statisticsService.addStatistic(false);
        Statistics statistic=statisticsService.getStatistics();
        assert statistic.getNoCount()==1;
    }
}
