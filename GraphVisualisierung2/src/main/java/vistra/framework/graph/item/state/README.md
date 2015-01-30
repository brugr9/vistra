# Visualisierte Traversierung von Graphen
### Implementation von Algorithmen und Datenstrukturen
 
#### Elemente des Graphen als Zustandsmaschine: State und Command Pattern
Beim Traversieren des Graphen werden die einzelnen Elemente (Item: Vertex, Edge) z.B. aktualisiert oder besucht. Dabei verändert sich deren Zustand (Farben, Strichstärke, Wert). Die Elemente sind deshalb als Zustandsmaschine implementiert:

Zustand (ItemState):
- Mit dem Besuchen eines Elementes verändert sich dessen Zustand.
- Jedes Element ist ein ItemStateHandler und hat einen Stack zum speichern der Zustände.

Zustandsänderung (ItemStateCommand):
- Die Zustandsänderung ist ein Objekt.
- Eine Zustandsänderung implementiert das Command Pattern.
- Die Zustandsänderung wird durch die execute-Methode herbeigeführt.
- Die Zustandsänderung wird durch die undo-Methode rückgängig gemacht.


Aufgrund der möglichen Zustände wurden die dazugehörenden Zustandsänderungen entworfen. Folgende Tabelle 'From state to step' zeigt die möglichen Zustände, die Zustände als Objekte (ItemState) und die Zustandsänderungen als Objekte (ItemStateCommand):
![From state to step](https://raw.githubusercontent.com/brugr9/vistra/master/GraphVisualisierung2/doc/vistra/04_beamer/2_solution/2_framework-parameter/01_graph/04_list_-_from_state_to_step.png "From state to step")

