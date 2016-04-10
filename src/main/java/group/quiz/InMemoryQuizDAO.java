package group.quiz;

import java.util.Objects;
import java.util.Random;

/**
 * local storage of verbs
 */
public class InMemoryQuizDAO implements QuizDAO {
    private final VerbTableLoader verbTableLoader;
    private VerbTable verbTable;

    public InMemoryQuizDAO(VerbTableLoader verbTableLoader) {
        this.verbTableLoader = verbTableLoader;
    }

    public void init() {
        try {
            this.verbTable = this.verbTableLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * returns random verb from table
     * @param questionVerbForm  request verb form
     * @return verb
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     */
    public String getRandomVerb(VerbForm questionVerbForm) throws IllegalArgumentException, IllegalStateException {
        Objects.requireNonNull(questionVerbForm);
        final Random random = new Random();//Будем доставать глагол со случайным номером
        int randomNumberOfVerb = random.nextInt(verbTable.getCountOfVerbs());//Номер случайного глагола
        VerbTable.Row row = this.verbTable.getRow(randomNumberOfVerb);
        switch (questionVerbForm) {
            case FIRST:
                return row.getFirstForm();
            case SECOND:
                return row.getSecondForm();
            case THIRD:
                return row.getThirdForm();
            default:
                throw new IllegalStateException();
        }
    }

    /**
     * returns another form of verb  by entered verb and request and response verb form
     * @param verbRequest entered verb
     * @param requestVerbForm request Verb Form
     * @param responseVerbForm response Verb Form
     * @return another verb form
     */
    public String getVerbByOtherForm(String verbRequest, VerbForm requestVerbForm, VerbForm responseVerbForm) {
        Objects.requireNonNull(verbRequest);
        Objects.requireNonNull(requestVerbForm);
        Objects.requireNonNull(responseVerbForm);
        VerbTable.Row row;
        switch (requestVerbForm) {
            case FIRST:
                row = verbTable.getByFirstForm(verbRequest);
                break;
            case SECOND:
                row = verbTable.getBySecondForm(verbRequest);
                break;
            case THIRD:
                row = verbTable.getByThirdForm(verbRequest);
                break;
            default:
                throw new IllegalStateException();
        }
        if (row == null) {
            return null;
        }
        switch (responseVerbForm) {
            case FIRST:
                return row.getFirstForm();
            case SECOND:
                return row.getSecondForm();
            case THIRD:
                return row.getThirdForm();
            default:
                throw new IllegalStateException();
        }

    }
}
