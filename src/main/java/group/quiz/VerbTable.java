package group.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerbTable {
    private final ArrayList<Row> rows = new ArrayList<Row>();
    /*adding index to values*/
    private final Map<String, Row> firstFormIndex = new HashMap<String, Row>();
    private final Map<String, Row> secondFormIndex = new HashMap<String, Row>();
    private final Map<String, Row> thirdFormIndex = new HashMap<String, Row>();

    public int getCountOfVerbs() {
        return rows.size();
    }

    public Row getRow(int index) {
        return this.rows.get(index);
    }

    public void add(String baseFormInputVerb, String pastSimpleFormInputVerb, String edFormInputVerb) {
        Row row = new Row(baseFormInputVerb, pastSimpleFormInputVerb, edFormInputVerb);
        this.rows.add(row);
        this.firstFormIndex.put(baseFormInputVerb, row);
        this.secondFormIndex.put(pastSimpleFormInputVerb, row);
        this.thirdFormIndex.put(edFormInputVerb, row);
    }

    public Row getByFirstForm(String value) {
        return this.firstFormIndex.get(value);
    }

    public Row getBySecondForm(String value) {
        return this.secondFormIndex.get(value);
    }

    public Row getByThirdForm(String value) {
        return this.thirdFormIndex.get(value);
    }

    public static class Row {
        private final String firstForm;
        private final String secondForm;
        private final String thirdForm;

        public Row(String firstForm, String secondForm, String thirdForm) {
            this.firstForm = firstForm;
            this.secondForm = secondForm;
            this.thirdForm = thirdForm;
        }

        public String getFirstForm() {
            return firstForm;
        }

        public String getSecondForm() {
            return secondForm;
        }

        public String getThirdForm() {
            return thirdForm;
        }
    }
}
