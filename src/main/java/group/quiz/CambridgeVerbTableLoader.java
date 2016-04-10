package group.quiz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Loader downloads verbs from table on cambridge web page
 */
public class CambridgeVerbTableLoader implements VerbTableLoader {
    private static final String PAGE_URL = "http://dictionary.cambridge.org/grammar/british-grammar/table-of-irregular-verbs";
    private static final String TARGET_TAG_ON_PAGE = ".tbody> .tr> .td> .p";

    public VerbTable load() throws Exception {
        Document doc = Jsoup.connect(PAGE_URL).get();
        Elements resultLinks = doc.select(TARGET_TAG_ON_PAGE);
        StringBuilder stringBuilder = new StringBuilder();
        for (Element times : resultLinks) {
            stringBuilder.append(times.text()).append(" "); //TODO get parse values
        }
        VerbTable verbTable = new VerbTable();
        addVerbsToTable(verbTable, stringBuilder.toString());
        return verbTable;
    }

    private void addVerbsToTable(VerbTable verbTable, String verbs) {
        String[] arrayOfInputVerbs = verbs.split(" ");
        /*Узнаём количество полных троек глаголов*/
        int countOfInputVerbs = (arrayOfInputVerbs.length / 3) * 3;

        for (int i = 0; i < countOfInputVerbs; i += 3) {
            String baseFormInputVerb = arrayOfInputVerbs[i];
            String pastSimpleFormInputVerb = arrayOfInputVerbs[i + 1];
            String edFormInputVerb = arrayOfInputVerbs[i + 2];
            verbTable.add(baseFormInputVerb, pastSimpleFormInputVerb, edFormInputVerb);
        }
    }
}
