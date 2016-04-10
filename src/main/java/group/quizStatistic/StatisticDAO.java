package group.quizStatistic;

/**
 * DAO object using for control statistic base
 */
interface StatisticDAO {
    /**
     * Adding information to base
     *
     * @param answer answer
     */
    void addStatistic(boolean answer);

    /**
     * Returns statistic
     *
     * @return statistic
     */
    Statistics getStatistic();
}
