# Visualisierte Traversierung von Graphen
### Implementation von Algorithmen und Datenstrukturen

#### Semesterarbeit

Modul Projekt 1<br>
Berner Fachhochschule für Technik und Informatik BFH-TI, Biel/Bienne 2013
<hr>
![vistra GUI](GraphVisualisierung2/doc/vistra/04_beamer/2_solution/4_app/04_DFS_running.png "vistra GUI")
<hr>
##### Beschreibung
Java-Applikation zum editieren und traversieren von Graphen.
<hr>
##### Stichworte
- Algorithmen (BFS, BLS, [DFS](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/impl/DFS.java), DLS, [Dijkstra](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/impl/Dijkstra.java))
- Datenstrukturen (Array, Queue, Stack, Tree, Graph)
- OOAD Design Pattern (Factory, State, Strategy, Command, Adapter)
- Programmiersprache Java
- Eclipse-Projekt mit Apache Maven
- GUI mit Swing, [MVC](GraphVisualisierung2/src/main/java/vistra/app/) mit Java-Observer-Pattern, implementiert als [state-machine](GraphVisualisierung2/src/main/java/vistra/app/control/state/)
- Dateiformat *.graphml

##### Bibliotheken
- <a target="_blank" href="http://net3.datastructures.net/">net.datastructures</a>
- <a target="_blank" href="http://jung.sourceforge.net/">JUNG - Java Universal Network/Graph Framework</a>
- <a target="_blank" href="http://commons.apache.org/proper/commons-io/">Apache Commons IO</a>
- <a target="_blank" href="http://graphml.graphdrawing.org/">The GraphML File Format</a>
