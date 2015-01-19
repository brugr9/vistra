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
- Algorithmen: BFS, [DFS](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/impl/DFS.java), [Dijkstra](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/impl/Dijkstra.java), Kruskal
- Datenstrukturen: un-/gerichteter, un-/gewichteter Graph
- [Framework](GraphVisualisierung2/src/main/java/vistra/framework/) implemetiert OOAD Design Pattern: Factory, State, Strategy, Command, Adapter
- [MVC-App](GraphVisualisierung2/src/main/java/vistra/app/) mit Java-Observer-Pattern, implementiert als [state-machine](GraphVisualisierung2/src/main/java/vistra/app/control/state/)
- Programmiersprache Java
- Eclipse-Projekt mit Apache Maven
- GUI mit Swing
- Dateiformat *.graphml

##### Bibliotheken
- <a target="_blank" href="http://net3.datastructures.net/">net.datastructures</a>
- <a target="_blank" href="http://jung.sourceforge.net/">JUNG - Java Universal Network/Graph Framework</a>
- <a target="_blank" href="http://commons.apache.org/proper/commons-io/">Apache Commons IO</a>
- <a target="_blank" href="http://graphml.graphdrawing.org/">The GraphML File Format</a>

##### Downloads und Bericht
- [Release-Demo](GraphVisualisierung2/release-demo/vistra.jar?raw=true) (vistra.jar) und [Beispiel-Graph](GraphVisualisierung2/release-demo/simple-undirected-weigthed_with_start.vistra?raw=true)
- [JavaDoc](GraphVisualisierung2/doc/vistra/vistra-javadoc.zip?raw=true) (vistra-javadoc.zip)
- <a target="_blank" href="https://speakerdeck.com/brugr9/visualisierte-traversierung-von-graphen-bericht">Bericht</a> (auf speakerdeck)


##### TODOs
- Textausgabe für Dijkstra und Kruskal: Angabe der Lösung ist bis dato lediglich die Reihenfolge der zur Lösung hinzugefügten Ecken
- Editieren von Ecken und Kanten: Fang-Bereich vergrössern
