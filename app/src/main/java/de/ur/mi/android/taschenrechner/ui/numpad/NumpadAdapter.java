package de.ur.mi.android.taschenrechner.ui.numpad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.ur.mi.android.taschenrechner.R;
import de.ur.mi.android.taschenrechner.ui.button.Button;

/*
    Der NumpadAdapter kümmert sich um die Darstellung der einzelnen Knöpfe im UI.
    Dabei sollen unterschiedliche Knopftypen unterschiedliche Farben haben und jeder Knopf passend
    beschriftet sein.
    Darüber hinaus wird ein im Konstruktor übergebener Listener über Klicks auf die Knöpfe informiert.
 */
public class NumpadAdapter extends RecyclerView.Adapter<NumpadButtonViewHolder> implements NumpadButtonViewHolder.OnCLickListener {

    public final Context context;
    public final ButtonListener listener;
    public final Button[] buttons = {Button.BUTTON_SEVEN, Button.BUTTON_EIGHT, Button.BUTTON_NINE, Button.BUTTON_DIVISION, Button.BUTTON_FOUR, Button.BUTTON_FIVE, Button.BUTTON_SIX, Button.BUTTON_MULTIPLICATION, Button.BUTTON_ONE, Button.BUTTON_TWO, Button.BUTTON_THREE, Button.BUTTON_MINUS, Button.BUTTON_ZERO, Button.BUTTON_SEPARATOR, Button.BUTTON_RESULT, Button.BUTTON_PLUS, Button.BUTTON_DELETE};

    public NumpadAdapter(Context context, ButtonListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NumpadButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Die Viewholer werden basierend auf dem Layout für Ziffernblockknöpfe erzeugt.
        View buttonView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_numpad_button, parent, false);
        return new NumpadButtonViewHolder(buttonView, context, this);
    }

    @Override
    public void onBindViewHolder(@NonNull NumpadButtonViewHolder holder, int position) {
        holder.bindButton(buttons[position]);
    }

    @Override
    public int getItemCount() {
        // Für jeden möglichen Button soll ein View angezeigt werden.
        return buttons.length;
    }

    @Override
    public void onButtonClicked(int adapterPosition) {
        // Der Listener wird über Klicks auf Knöpfe informiert.
        listener.onButtonPressed(buttons[adapterPosition]);
    }

    public interface ButtonListener {
        void onButtonPressed(Button button);
    }
}
