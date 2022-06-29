package de.ur.mi.android.taschenrechner.ui.numpad;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import de.ur.mi.android.taschenrechner.ui.button.Button;
import de.ur.mi.android.taschenrechner.ui.button.ButtonType;

/*
    Diese Klasse verwaltet das im UI dargestellte Eingabefeld bestehend aus Ziffern und Operanden.
    Die Klasse fängt Interaktionen mit den Knöpfen ab und leitet diese an entsprechende Stellen
    weiter.
 */
public class Numpad implements NumpadAdapter.ButtonListener {

    // Hier wird der zuletzt gedrückte Knopf gespeichert, um zu entscheiden was ein Knopfdruck bedeutet.
    private Button lastButtonPressed;
    // Dieser Listener wird über Interaktionen mit den Knöpfen informiert.
    private final NumpadListener listener;

    /**
     * Konstruktor des Numpads. Hier wird der Listener gesetzt und die Initialisierung des User-
     * Interfaces gestartet.
     *
     * @param context Context in dem die Knöpfe zu sehen sind.
     * @param view RecyclerView, in dem der Ziffernblock angezeigt werden soll.
     * @param listener dieser Listener soll über Interaktionen mit dem Ziffernblock informiert werden.
     */
    public Numpad(Context context, RecyclerView view, NumpadListener listener) {
        this.listener = listener;
        init(context, view);
    }

    /*
        In dieser Methode wird das UI initialisiert, indem ein NumpadAdapter erstellt und auf den
        RecyclerView registriert wird.
     */
    private void init(Context context, RecyclerView view) {
        NumpadAdapter adapter = new NumpadAdapter(context, this);
        view.setAdapter(adapter);
    }

    // Diese Methode wird aufgerufen wenn einer der Knöpfe gedrückt wird.
    @Override
    public void onButtonPressed(Button button) {
        switch (button.type) {
            case NUMBER:
                // Wurde eine Zahl gedrückt, dann wird der Listener darüber informiert.
                listener.onNumberButtonPressed(button);
                break;
            case OPERATOR:
                // Wenn ein Operator gedrückt wurde ...
                if (lastButtonPressed == null || lastButtonPressed.type != ButtonType.OPERATOR) {
                    // ... und der letzte Knopf kein Operator war, wird der Operator verwendet.
                    listener.onOperatorButtonPressed(button);
                } else {
                    // ... und der letzte Knopf ein Operator war, wird der letzte Operator überschrieben.
                    listener.onOperatorButtonOverwritten(button);
                }
                break;
            case COMMAND:
                if (button == Button.BUTTON_DELETE) {
                    // Beim Drücken von "C" wird das Eingabefeld geleert.
                    listener.onClearButtonPressed();
                    break;
                }
                if (button == Button.BUTTON_RESULT) {
                    // Beim Drücken auf "=" wird der Term berechnet.
                    listener.onResultButtonPressed();
                    break;
                }
            default:
                break;
        }
        // Der letzte Knopf wird gespeichert.
        lastButtonPressed = button;
    }

    public interface NumpadListener {
        void onNumberButtonPressed(Button button);

        void onOperatorButtonPressed(Button button);

        void onOperatorButtonOverwritten(Button button);

        void onClearButtonPressed();

        void onResultButtonPressed();
    }
}
