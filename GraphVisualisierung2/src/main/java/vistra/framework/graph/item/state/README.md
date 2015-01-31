### Elemente des Graphen als Zustandsmaschine
Beim Traversieren des Graphen werden die einzelnen Elemente (Item: Vertex, Edge) z.B. aktualisiert oder besucht. Dabei verändert sich deren Zustand (Farben, Strichstärke, Wert). Die Elemente sind deshalb mit einem State Pattern, die Zustandsänderungen mit einem Command Pattern implementiert:

Element (Item: Vertex, Edge):
- Ein Element ist ein Objekt.
- Jedes Element ist ein ItemStateHandler und hat einen Stack zum speichern seiner Zustände.

Zustand (ItemState):
- Ein Zustand ist ein Objekt.
- Ein Zustand implementiert das State Pattern.
- Der Zustand wird durch die doEntry-Methode herbeigeführt.

Zustandsänderung (ItemStateCommand):
- Eine Zustandsänderung ist ein Objekt.
- Eine Zustandsänderung implementiert das Command Pattern.
- Die Zustandsänderung wird durch die execute-Methode herbeigeführt.
- Die Zustandsänderung wird durch die undo-Methode rückgängig gemacht.

Aufgrund der möglichen Zustände (ItemState) wurden die dazugehörenden Zustandsänderungen (ItemStateCommand) entworfen, wie folgende Tabelle 'From state to step' zeigt:
![From state to step](https://raw.githubusercontent.com/brugr9/vistra/master/GraphVisualisierung2/doc/vistra/04_beamer/2_solution/2_framework-parameter/01_graph/04_list_-_from_state_to_step.png "From state to step")

In der Tabelle gibt es noch die Spalte 'Step': Ein 'Step' ist ein Schritt in der Traversierung.
- Ein Schritt ist ein Objekt.
- Die Schritte implementieren ebenfalls das Command Pattern.
- Ein Schritt kann eine oder mehrere Zustandsänderungen beinhalten (macro command).
- Die Schritte sind Teil des Frameworks und gehören zum Paket der Traversierung: [framework/traversal/step](https://github.com/brugr9/vistra/tree/master/GraphVisualisierung2/src/main/java/vistra/framework/traversal/step)
