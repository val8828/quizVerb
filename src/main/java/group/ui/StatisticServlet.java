package group.ui;

import group.quizStatistic.Statistics;
import group.quizStatistic.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for Statistic control
 */
@SuppressWarnings("serial")
public class StatisticServlet extends HttpServlet {
    private StatisticsService statisticsService;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

        Statistics statistics = statisticsService.getStatistics();
        String stat = String.format("Yes: %d, No: %d", statistics.getYesCount(), statistics.getNoCount());
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(stat);
    }

    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }
}
