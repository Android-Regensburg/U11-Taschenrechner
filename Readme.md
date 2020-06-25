---
title: U12-Taschenrechner
author: Zuletzt bearbeitet von Tim Eichinger
documentclass: scrartcl
classoption:
  - a4paper
header-includes: |
    \usepackage{german} 
    \usepackage[a4paper,left=2.5cm, right=2.5cm,top=2.5cm, bottom=3cm]{geometry}
    \usepackage{fancyhdr}
    \pagestyle{fancy}
    \fancyhf{}
    \rhead{Mobile Apps für Android}
    \lhead{Übungsaufgaben}
    \cfoot{\includegraphics[height=2cm]{docs/footer.png}}
---

# U12-Taschenrechner

![](./docs/cover.png)

## Aufgabe

Das Ziel dieser Aufgabe ist die Implementierung einer simplen Taschenrechner-App. Dabei ist nur die CalculatorHelper-Klasse vorgegeben, mit der man einen mathematischen Term (`String`) berechnen kann. UI, Eingabe und Ausgabe kann dabei komplett frei gestaltet werden

## Hinweise

* Ihr könnt euch an den Screenshots unten orientieren, müsst euch aber nicht daran halten. Das Design ist von euch frei wählbar. Schaut euch in diesem Zusammenhang auch noch einmal das [`GridLayout`](https://developer.android.com/reference/android/widget/GridLayout) an, das man hier verwenden kann (aber nicht muss).
* Versucht zu vermeiden, jeden Button über einen einzelnen _Listener_ anzusteuern (Ein und der selbe _Listener_ kann z.B. auch auf mehreren _Buttons_ registriert werden).
* Für die eigentliche Berechnung wird die [exp4j-Library](https://www.objecthunter.net/exp4j/index.html) verwendet, die bereits implementiert ist und in der `CalculatorHelper`-Klasse verwendet wird
* Die `CalculatorHelper`-Klasse besitzt eine statische öffentliche Methode `calculate(String expression)`. Diese berechnet das Ergebnis eines mathematischen Terms und gibt es als String zurück. Dabei können als Operatoren folgende Zeichen verwendet werden: **Addition** (`+`), **Subtraktion** (`-`), **Multiplikation** (`*` oder `x`), **Division** (`/` oder `÷`)

## Tipps zum Vorgehen

- Entwerfen Sie ein User Interface das über die notwendigen Elemente für die Interaktion mit dem Taschenrechner verfügt. Dabei sind vor allem die _Buttons_ für die Zahlen und Operatoren und ein Bereich zur Anzeige des Terms bzw. Ausgabe des Ergebnis wichtig.
- Erlauben Sie den NutzerInnen durch Interaktion mit den _Buttons_ einen Term einzugeben.
- Berechnen Sie bei der Interaktion mit dem `=`-Button das Ergebnis und zeigen Sie dies im UI an. Nutzen Sie dafür die vorgegebene `CalculatorHelper`-Klasse.

## Screenshots

| | | |
|-|-|-|
|![Screenshot der Taschenrechner-App](./docs/screenshot-1.png "Beim Start"){ height=8cm } |![Screenshot der Taschenrechner-App](./docs/screenshot-2.png "Bei der Eingabe"){ height=8cm } |![Screenshot der Taschenrechner-App](./docs/screenshot-3.png "Beim Anzeigen des Ergebnisses"){ height=8cm } |
