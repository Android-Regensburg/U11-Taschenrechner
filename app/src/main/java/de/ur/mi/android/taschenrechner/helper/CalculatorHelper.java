package de.ur.mi.android.taschenrechner.helper;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/*
    Diese Klasse stellt eine statische Methode bereit mit der als String übergebene Terme berechnet
    und das Ergebnis als String zurückgegeben werden kann.
 */
public class CalculatorHelper {

    // Fehlermeldung, wenn bei der Umwandlung etwas schief geht.
    private static final String ERROR_MESSAGE = "Error";
    // Fehlermeldung groß geschrieben.
    private static final String ERROR_UPPER_CASE = "ERROR";

    /**
     * Mit dieser Methode kann ein Ausdruck, in Form eines Strings, berechnet werden.
     * @param expression Term/Ausdruck der berechnet werden soll
     * @return Ergebnis der Rechnung als String-Wert, falls ein Fehler auftritt wird 'Error'
     * zurückgegeben
     */
    public static String calculate(String expression) {
        String cleanedExpression = cleanExpression(expression);
        if (checkError(cleanedExpression)) return ERROR_MESSAGE;
        return evaluateExpression(cleanedExpression);
    }

    /**
     * Diese Methode kümmert sich um die Berechnung des Ergebnisses und gibt dieses als String zurück.
     * Bei der Umwandlung des Ergebnisses in einen String kann eine RuntimeException auftreten. In
     * diesem Fall wird ein vordefinierter Error-String zurückgegeben.
     *
     * @param expression Term/Ausdruck der berechnet werden soll
     * @return Ergebnis der Berechnung oder Error-String
     */
    private static String evaluateExpression(String expression) {
        Expression exp = new ExpressionBuilder(expression).build();
        try {
            return String.valueOf(exp.evaluate());
        } catch (RuntimeException e) {
            return ERROR_MESSAGE;
        }
    }

    /**
     * Diese Methode überprüft, ob im zu berechnenden String irgendwo ein Errorstring enthalten ist.
     * Dann kann keine Berechnung durchgeführt werden.
     *
     * @param expression Term dessen Inhalt überprüft werden muss
     * @return true - es ist ein Error enthalten / false - es ist kein Fehler enthalten.
     */
    private static boolean checkError(String expression) {
        return expression.contains(ERROR_MESSAGE) || expression.contains(ERROR_UPPER_CASE);
    }

    /**
     * Diese Methode ersetzt Zeichen, die eine eindeutige Bedeutung haben aber nicht von der
     * Bibliothek unterstützt werden durch solche, mit denen gerechnet werden kann.
     *
     * @param expression Term/Ausdruck der bereinigt werden soll.
     * @return Bereinigter Term/Ausdruck, der von der Bibliothek verarbeitet werden kann.
     */
    private static String cleanExpression(String expression) {
        String result = expression.toUpperCase();
        result = replaceXByStar(result);
        result = replaceDivideBySlash(result);
        return result;

    }

    /**
     * Diese Methode ersetzt im Ausdruck enthaltene x durch *, da nur letztere von der Bibliothek
     * verarbeitet werden können.
     *
     * @param expression Ausdruck, dessen enthaltene x ersetzt werden sollen.
     * @return Termin in dem alle x durch * ersetzt wurden.
     */
    private static String replaceXByStar(String expression) {
        if(expression.contains("X")) return expression.replaceAll("X", "*");
        return expression;
    }

    /**
     * Diese Methode ersetzt im übergebenen Term/Ausdruck alle ÷ durch /, da nur letztere von der
     * Bibliothek verstandne und verarbeitet werden können.
     *
     * @param expression Term/Ausdruck, in dem die ÷ durch / ersetzt werden sollen.
     * @return Term/Ausdruck, in dem alle ÷ durch / ersetzt wurden.
     */
    private static String replaceDivideBySlash(String expression) {
        if(expression.contains("÷")) return expression.replaceAll("÷", "/");
        return expression;
    }

}