package group.quizStatistic;

/**
 * Local storage of statistic, within the program
 */
public class StatisticDAOImpl implements StatisticDAO {
    private int yesCount;
    private int noCount;

    public void addStatistic(boolean answer) {
        if (answer) {
            yesCount++;
        } else {
            noCount++;
        }
    }

    public Statistics getStatistic() {
        return new Statistics() {
            public int getYesCount() {
                return yesCount;
            }

            public int getNoCount() {
                return noCount;
            }
        };
    }
}

