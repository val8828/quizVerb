package group.quiz;

/**
 * Interface for different form of storage  for example base, inside program, in file etc.
 */
interface QuizDAO {

    /**
     * returns random verb from table
     * @param questionVerbForm  request verb form
     * @return verb
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     */
    String getRandomVerb(VerbForm questionVerbForm) throws IllegalArgumentException, IllegalStateException;

    /**
     * returns another form of verb  by entered verb and request and response verb form
     * @param verbRequest entered verb
     * @param requestVerbForm request Verb Form
     * @param responseVerbForm response Verb Form
     * @return another verb form
     */
    String getVerbByOtherForm(String verbRequest,
                              VerbForm requestVerbForm,
                              VerbForm responseVerbForm);
}
