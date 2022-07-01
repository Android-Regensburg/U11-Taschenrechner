
# U11 | Ein Taschenrechner

## Aufgabe

Das Ziel dieser Aufgabe ist die Implementierung einer simplen Taschenrechner-App. Dabei ist nur die CalculatorHelper-Klasse vorgegeben, mit der man einen mathematischen Term (übergeben in Form eines `String`) berechnen kann. UI, Eingabe und Ausgabe sollen hier in Vorbereitung auf das Projekt komplett frei gestaltet werden.

## Starterpaket

Im Starterpaket finden Sie eine fast leere `MainActivity`. Diese können Sie als Ausgangspunkt Ihrer Implementierung verwenden. Außerdem ist die Klasse `CalculatorHelper` vorgegeben. Hier ist die statische Methode `calculate` vorgegeben. Dieser kann ein Term als String übergeben werden. Die Methode liefert dann einen String mit dem Ergebnis zurück. Bei Übergabe von `"2x3+3"` würde also `"9"` zurückgegeben werden.

## Hinweise

* Ihr könnt euch an den Screenshots unten orientieren, müsst euch aber nicht daran halten. Das Design ist von euch frei wählbar. 
* Zur Darstellung der Knöpfe des Ziffernblocks kann ein [`GridLayoutManager`](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/GridLayoutManager) verwendet werden. Dieser kann im `app:layoutManager` Attribut in einem RecyclerView gesetzt werden und kümmert sich um die Anordnung der Elemente.
* Versucht zu vermeiden, jeden Button über einen einzelnen _Listener_ anzusteuern (Ein und der selbe _Listener_ kann z.B. auch auf mehreren _Buttons_ registriert werden).
* Für die eigentliche Berechnung wird die [exp4j-Library](https://www.objecthunter.net/exp4j/index.html) verwendet, die bereits implementiert ist und in der `CalculatorHelper`-Klasse verwendet wird. Ihr müsst euch nicht näher mit der Berechnung auseinander setzen.
* Die `CalculatorHelper`-Klasse besitzt eine statische öffentliche Methode `calculate(String expression)`. Diese berechnet das Ergebnis eines mathematischen Terms und gibt es als String zurück. Dabei können als Operatoren folgende Zeichen verwendet werden: **Addition** (`+`), **Subtraktion** (`-`), **Multiplikation** (`*` oder `x`), **Division** (`/` oder `÷`)
* Die einzelnen Bereiche des UI können in eigene Klassen oder sogar eigene Fragments ausgelagert werden.
* Die möglichen Buttons könnten als Enums oder Konstanten gespeichert werden.
* Man sollte zwischen verschiedenen Typen von Buttons unterscheiden.
* Ansprechendere Buttons können Sie gestalten indem Sie ein eigenes Layout für die Knöpfe definieren. Dessen Hintergrundfarbe kann man durch setzen des `backgroundTint` Attributs verändern. Die Form der Buttons kann man ändern indem man im `drawable` Ordner eine `shape` *Ressource* anlegt. Diese Ressource muss dann als `background` gesetzt werden. Mehr dazu erfahren sie [hier](https://developer.android.com/guide/topics/resources/drawable-resource#Shape).

## Mögliches Vorgehen

Die folgende Reihenfolge der Bearbeitung ist möglich aber nicht vorgeschrieben.

- Entwerft mit Hilfe eines *Adapters* und eines geeigneten *Views* ein einfaches *User Interface* für die Knöpfe. Dabei sollte für jede mögliche Ziffer, für jeden möglichen Rechenoperanden, für die Berechnung des Ergebnisses und für das Löschen des Terms ein Button angeboten werden.
- Ergänzt euer *User Interface* um einen Bereich (oder Bereiche) in dem (/denen) der aktuelle Term und das aktuelle Ergebnis angezeigt werden können.
- Erlaubt den NutzerInnen durch Interaktion mit den _Buttons_ einen Term einzugeben. Der Term kann dabei ein einfacher _String_ sein, in dem Zahlen und Operatoren in der Reihenfolge erscheinen, in der sie eingegeben wurden. Der aktuelle Term sollte stets sichtbar sein.
- Berechnet, nachdem die NutzerInnen auf den `=`-Button geklickt haben, das Ergebnis und zeigt dieses im UI an. Nutzt dafür die vorgegebene `CalculatorHelper`-Klasse.
- Sorgt dafür, dass beim Drücken des _Löschen_ Buttons der aktuelle Term aus dem User Interface entfernt wird.
- Sucht nach problematischen Eingaben und Situationen und behandelt diese passend.
- Verbessert das Design eures *User Interfaces* und achtet dabei auf eine ansprechende farbliche und inhaltliche Gestaltung.

## Screenshots

|  Start   |   Eingabe    |   Ergebnisse    |
|:-------:|:-------:|:-------:|
| ![Screenshot der Taschenrechner-App](./docs/screenshot-1.png)  | ![Screenshot der Taschenrechner-App](./docs/screenshot-2.png)  | ![Screenshot der Taschenrechner-App](./docs/screenshot-3.png ) |
