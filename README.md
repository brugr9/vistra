### vistra - Visualisierung von Graphenalgorithmen
Applikation zum editieren und traversieren von Graphen.

![vistra GUI](GraphVisualisierung2/release-demo/vistra-dijkstra.png "vistra GUI")
<hr>

[Executable](GraphVisualisierung2/release-demo/vistra.jar?raw=true), [Demo-Graph](GraphVisualisierung2/release-demo/simple-undirected-weigthed_with_start.vistra?raw=true), <a target="_blank" href="https://www.hashdoc.com/documents/476943/desktop-applikation-zur-visualisierung-von-graphenalgorithmen">Report</a>, <a target="_blank" href="https://youtu.be/PHCs4vWJ0Cw">Screencast</a>.

### Lösung
#### Framework, implemetiert OOAD Design Pattern:
 - Graph: [Factory](GraphVisualisierung2/src/main/java/vistra/framework/graph/GraphFactory.java), [Manager](GraphVisualisierung2/src/main/java/vistra/framework/graph/GraphManager.java), [Adapter](GraphVisualisierung2/src/main/java/vistra/framework/graph/ITraversableGraph.java), [State / Command combined](GraphVisualisierung2/src/main/java/vistra/framework/graph/item/state/)
 - Algorithm: [Manager and Strategy](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/IAlgorithmManager.java)
 - Traversal: [Macro Command](GraphVisualisierung2/src/main/java/vistra/framework/traversal/step/)
 
#### Applikation:
 - Implementiert als [Zustandsmaschine](GraphVisualisierung2/src/main/java/vistra/app/control/state/)
 - Algorithmen: BFS, [DFS](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/impl/DFS.java), [Dijkstra](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/impl/Dijkstra.java), Kruskal
<hr>

- Stichworte: BFS, DFS, Dijkstra, Kruskal, Objektorientierte Programmierung OOP, Objektorientierte Analyse und Design OOAD.

- Technologie: Eclipse-Projekt mit Apache Maven, GUI mit Swing, <a target="_blank" href="http://net3.datastructures.net/">net.datastructures</a>, <a target="_blank" href="http://jung.sourceforge.net/">JUNG - Java Universal Network/Graph Framework</a>, <a target="_blank" href="http://commons.apache.org/proper/commons-io/">Apache Commons IO</a>, <a target="_blank" href="http://graphml.graphdrawing.org/">The GraphML File Format</a>.

<hr>
Modul Projekt 1, Semesterarbeit HS 2013/14

Berner Fachhochschule, Abteilung Technik und Informatik BFH-TI, Biel/Bienne
