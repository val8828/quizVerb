package group;

/**
 * Main class
 */

import group.quiz.CambridgeVerbTableLoader;
import group.quiz.InMemoryQuizDAO;
import group.quiz.QuizServiceImpl;
import group.quizStatistic.StatisticDAOImpl;
import group.quizStatistic.StatisticsServiceImpl;
import group.ui.QuizServlet;
import group.ui.StatisticServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class App {

    public static void main(String[] args) throws Exception {

        CambridgeVerbTableLoader cambridgeVerbTableLoader = new CambridgeVerbTableLoader();
        InMemoryQuizDAO inMemoryQuizDAO = new InMemoryQuizDAO(cambridgeVerbTableLoader);
        inMemoryQuizDAO.init();
        QuizServiceImpl quizServiceImpl = new QuizServiceImpl();
        quizServiceImpl.setQuizDAO(inMemoryQuizDAO);

        StatisticDAOImpl statisticDAO = new StatisticDAOImpl();
        StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();
        statisticsService.setStatisticDAO(statisticDAO);

        quizServiceImpl.setStatisticsService(statisticsService);

        int port = Integer.parseInt(args[0]);
        Server server = new Server(port);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        QuizServlet quizServlet = new QuizServlet();
        quizServlet.setQuizService(quizServiceImpl);
        handler.addServletWithMapping(new ServletHolder(quizServlet), "/quiz/*");

        StatisticServlet statisticServlet = new StatisticServlet();
        statisticServlet.setStatisticsService(statisticsService);
        handler.addServletWithMapping(new ServletHolder(statisticServlet), "/stats");

        server.start();
        server.join();
    }


}