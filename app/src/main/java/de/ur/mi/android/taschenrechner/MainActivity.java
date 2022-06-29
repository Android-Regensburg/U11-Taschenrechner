package de.ur.mi.android.taschenrechner;

import android.app.Activity;
import android.os.Bundle;
import de.ur.mi.android.taschenrechner.ui.button.Button;
import de.ur.mi.android.taschenrechner.ui.display.Display;
import de.ur.mi.android.taschenrechner.ui.numpad.Numpad;

public class MainActivity extends Activity implements Numpad.NumpadListener {

    // Im Display werden die Ergebnisse und Eingaben angezeigt.
    private Display display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
        // Das Numpad dient der Darstellung und Verwendung der Knöpfe für Ziffern und Operatoren.
        // Wir registrieren diese Klasse als Listener, der sich um reaktionen auf das Klicken der Knöpfe kümmert.
        Numpad numpad = new Numpad(getApplicationContext(), findViewById(R.id.view_input_numpad), this);
        display = new Display(findViewById(R.id.text_output_term), findViewById(R.id.text_output_result));
    }

    @Override
    public void onNumberButtonPressed(Button button) {
        // Wird eine Zahl geklickt so wird deren Wert dem Term hinzugefügt
        display.appendTerm(button.label);
    }

    @Override
    public void onOperatorButtonPressed(Button button) {
        // Wird ein Operand geklickt so wird dieser dem Term hinzugefügt.
        display.appendTerm(button.label);
    }

    @Override
    public void onOperatorButtonOverwritten(Button button) {
        // Wird ein Operand geklickt, obwohl schon einer geklickt war, so wird der letzte Operand überschrieben.
        display.replaceLastOperator(button.label);
    }

    @Override
    public void onClearButtonPressed() {
        // Wir der "C" Knopf gedrückt, so wird der Term gelöscht.
        display.clear();
    }

    @Override
    public void onResultButtonPressed() {
        // Wird der "=" Button geklickt so wird das Ergebnis berechnet.
        display.solve();
    }
}