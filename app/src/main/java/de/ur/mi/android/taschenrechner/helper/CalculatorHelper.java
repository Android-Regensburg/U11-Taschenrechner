package de.ur.mi.android.taschenrechner.helper;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorHelper {

    private static final String ERROR_MESSAGE = "Error";
    private static final String ERROR_UPPER_CASE = "ERROR";

    /**
     * Mit dieser Methode kann ein Ausdruck, in Form eines Strings, berechnet werden.
     * @param expression Term/Ausdruck der berechnet werden soll
     * @return Ergebnis der Rechnung als String-Wert, falls ein Fehler auftritt wird 'Error'
     * zurückgegeben
     */
    public static String calculate(String expression) {
        String cleanedExpression = cleanExpression(expression);
        if (containsError(cleanedExpression)) return ERROR_MESSAGE;
        return evaluateStringExpression(cleanedExpression);
    }

    private static boolean containsError(String expression) {
        return expression.contains(ERROR_MESSAGE) || expression.contains(ERROR_UPPER_CASE);
    }

    private static String evaluateStringExpression(String expression) {
        Expression exp = new ExpressionBuilder(expression).build();
        try {
            return String.valueOf(exp.evaluate());
        } catch (RuntimeException e) {
            return ERROR_MESSAGE;
        }
    }

    private static String cleanExpression(String expression) {
        String result = expression.toUpperCase();
        result = replaceXByStar(result);
        result = replaceDivideBySlash(result);
        return result;
    }

    private static String replaceXByStar(String expression) {
        if (expression.contains("X")) {
            return expression.replaceAll("X", "*");
        }
        return expression;
    }

    private static String replaceDivideBySlash(String expression) {
        if(expression.contains("÷")) {
            return expression.replaceAll("÷", "/");
        }
        return expression;
    }

}
