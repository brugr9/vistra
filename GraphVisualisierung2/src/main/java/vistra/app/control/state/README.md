## Zustandsmaschine MVC-App
Die App ist als Zustandsmaschine implementiert (state pattern). Dabei werden drei Komponenten unterschieden:

- Parameter: Editieren des Graphen und Wahl des Algorithmus
- Step-by-step (Sbs): Traversierung des Graphen Schritt-für-Schritt 
- Animation: Traversierung des Graphen animiert

### Zustände der Komponenten
Die drei Komponenten können sich in folgenden Zuständen befinden:

##### Parameter: 

 - graph edited (Graph wurde editert)
 - graph saved (Graph wurde gespeichert)
 - algorithm selected (Algorithmus wurde ausgewählt)
 - off (Interaktion ausgeschaltet)

##### Step-by-step (kurz 'Sbs'):

 - at beginning (Stand der Traversierung: am Anfang)
 - inter (Stand der Traversierung: zwischen Anfang und Ende)
 - at end (Stand der Traversierung: am Ende)

##### Animation: 

 - playing (am laufen)
 - paused (angehalten)
 - stopped (gestoppt)
 - off (Interaktion ausgeschaltet)
