package de.ur.mi.android.taschenrechner.ui.display;

import android.widget.TextView;

import de.ur.mi.android.taschenrechner.helper.CalculatorHelper;

/*
    Die Display-Klasse kümmert sich um die Darstellung und Aktualisierung des Anzeigebereichs im
    User Interface. Hier soll bei der Eingabe der aktuelle Term angezeigt werden, bei Berechnung
    das Ergebnis dargestellt werden und der Bereich beim Klicken auf den "C" Knopf geleert werden.
 */
public class Display {

    // Initial steht kein Text im Display.
    private static final String DEFAULT_TERM = "";

    // Diese Views sollen entsprechend der Eingaben mit Inhalt befüllt werden.
    private final TextView termView;
    private final TextView resultView;

    // In diesem String ist der aktuell anzuzeigende/zu berechnende Term gespeichert.
    private String currentTerm;

    /**
     * Konstruktor der Display Klasse. Wird aufgerufen um Displays zu intialisieren. Dabei müssen die
     * TextViews übergeben werden in denen das Ergebnis und der Term angezeigt werden sollen. Initial
     * wird der leere Term verwendet und angezeigt.
     *
     * @param termView TextView in dem der aktuelle Term angezeigt werden soll.
     * @param resultView TextView in dem das Ergebnis dargestellt werden soll.
     */
    public Display(TextView termView, TextView resultView) {
        this.termView = termView;
        this.resultView = resultView;
        currentTerm = DEFAULT_TERM;
        update(false);
    }

    /**
     * Diese Methode hängt einen String an den aktuellen Term an und aktualisiert das UI.
     *
     * @param term String der an den aktuellen Term angehängt werden soll.
     */
    public void appendTerm(String term) {
        currentTerm = currentTerm.concat(term);
        update(false);
    }

    /**
     * Diese Methode ersetzt das letzte Zeichen des aktuellen Terms durch einen neuen Operator.
     *
     * @param operator Operator durch den das letzte Zeichen ersetzt werden soll.
     */
    public void replaceLastOperator(String operator) {
        currentTerm = currentTerm.substring(0, currentTerm.length() - 1).concat(operator);
        update(false);
    }

    /**
     * Diese Methode setzt den aktuellen Term zurück.
     */
    public void clear() {
        currentTerm = DEFAULT_TERM;
        update(false);
    }

    /**
     * Beim Aufruf dieser Methode wird der aktuelle Term ausgewertet, das Ergebnis im entsprechenden
     * TextView angezeigt und der aktuelle Term zurückgesetzt.
     */
    public void solve() {
        update(true);
    }

    /**
     * Diese Methode dient der Aktualisierung des UIs. Dabei wird der angezeigte aktuelle Term durch
     * den Wert des currentTerm Strings ersetzt. Falls das letzte Zeichen des aktuellen Terms keine
     * Zahl ist, so wird der Inhalt des Result UI-Elements auf den berechneten Term gesetzt.
     * Wird zudem true übergeben, so wird der Inhalt der Anzeige des Terms auf den Inhalt des Result-Views
     * gesetzt und letzterer gelöscht.
     *
     * @param clearTerm boolean Variable, die angibt, ob der Inhalt des Ergebnisses in die Term-Anzeige übertragen werden soll.
     */
    private void update(boolean clearTerm) {
        termView.setText(currentTerm);
        if (currentTerm.equals(DEFAULT_TERM)) {
            resultView.setText(DEFAULT_TERM);
            return;
        }
        if (!Character.isDigit(currentTerm.charAt(currentTerm.length() - 1))) {
            return;
        }
        resultView.setText(CalculatorHelper.calculate(currentTerm));
        if (clearTerm) {
            currentTerm = resultView.getText().toString();
            termView.setText(currentTerm);
            resultView.setText(DEFAULT_TERM);
        }
    }

}
