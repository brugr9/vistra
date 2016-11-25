### Elemente des Graphen als Zustandsmaschine
Beim Traversieren des Graphen werden die einzelnen Elemente (Item: Vertex, Edge) z.B. aktualisiert oder besucht. Dabei verändert sich deren Zustand (Farben, Strichstärke, Wert). Die Elemente sind deshalb mit einem State Pattern, die Zustandsänderungen mit einem Command Pattern implementiert:

Element (Item: Vertex, Edge):
- Ein Element ist ein Objekt.
- Jedes Element ist ein [ItemStateHandler](IItemStateHandler.java) und hat einen Stack zum speichern seiner Zustände.

Zustand (ItemState):
- Ein Zustand ist ein Objekt.
- Ein Zustand implementiert das State Pattern.
- Der Zustand wird durch die doEntry-Methode herbeigeführt.

Zustandsänderung (ItemStateCommand):
- Eine Zustandsänderung ist ein Objekt.
- Eine Zustandsänderung implementiert das Command Pattern.
- Die Zustandsänderung wird durch die execute-Methode ausgeführt.
- Die Zustandsänderung wird durch die undo-Methode rückgängig gemacht.

Aufgrund der möglichen Zustände (ItemState) wurden die dazugehörenden Zustandsänderungen (ItemStateCommand) entworfen.
Ein 'Step' ist ein Schritt in der Traversierung.
- Ein Schritt ist ein Objekt.
- Die Schritte implementieren ebenfalls das Command Pattern.
- Ein Schritt kann eine oder mehrere Zustandsänderungen beinhalten (macro command).
- Die Schritte sind Teil des Frameworks und gehören zum Paket der Traversierung.
