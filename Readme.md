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

* Ihr könnt euch an den Screenshots unten orientieren, müsst euch aber nicht daran halten. Das Design ist von euch frei wählbar.
* Für die eigentliche Berechnung wird die [exp4j-Library](https://www.objecthunter.net/exp4j/index.html) verwendet, die bereits implementiert ist und in der CalculatorHelper-Klasse verwendet wird
* Die `CalculatorHelper`-Klasse besitzt eine statische öffentliche Methode `calculate(String expression)`. Diese berechnet das Ergebnis eines mathematischen Terms und gibt es als String zurück. Dabei können als Operatoren folgende Zeichen verwendet werden: **Addition** (`+`), **Subtraktion** (`-`), **Multiplikation** (`*` oder `x`), **Division** (`/` oder `÷`)

## Screenshots

| | | |
|-|-|-|
|![Screenshot der Taschenrechner-App](./docs/screenshot-1.png "Beim Start"){ height=8cm } |![Screenshot der Taschenrechner-App](./docs/screenshot-2.png "Bei der Eingabe"){ height=8cm } |![Screenshot der Taschenrechner-App](./docs/screenshot-3.png "Beim Anzeigen des Ergebnisses"){ height=8cm } |