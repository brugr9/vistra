### vistra -- Visualisierung von Algorithmen und Datenstrukturen
Applikation zum editieren und traversieren von Graphen.

Semesterarbeit Modul Projekt 1<br>
Berner Fachhochschule für Technik und Informatik BFH-TI, Biel/Bienne 2013/14
<hr>

##### Downloads
- [Executable](GraphVisualisierung2/release-demo/vistra.jar?raw=true) (vistra.jar)
- [Demo-Graph](GraphVisualisierung2/release-demo/simple-undirected-weigthed_with_start.vistra?raw=true) (simple-undirected-weigthed_with_start.vistra)
- <a target="_blank" href="https://www.hashdoc.com/documents/262840/visualisierung-von-algorithmen-und-datenstrukturen">Bericht Vistra</a> (auf Hashdoc)

#### Lösung
- Framework: 
 - Implemetiert OOAD Design Pattern:
 - Graph: [Factory](GraphVisualisierung2/src/main/java/vistra/framework/graph/GraphFactory.java), [Manager](GraphVisualisierung2/src/main/java/vistra/framework/graph/GraphManager.java), [Adapter](GraphVisualisierung2/src/main/java/vistra/framework/graph/ITraversableGraph.java), [State / Command combined](GraphVisualisierung2/src/main/java/vistra/framework/graph/item/state/)
 - Algorithm: [Manager and Strategy](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/IAlgorithmManager.java)
 - Traversal: [Macro Command](GraphVisualisierung2/src/main/java/vistra/framework/traversal/step/)
 
- Applikation:
 - Implementiert als [Zustandsmaschine](GraphVisualisierung2/src/main/java/vistra/app/control/state/)
 - Algorithmen: BFS, [DFS](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/impl/DFS.java), [Dijkstra](GraphVisualisierung2/src/main/java/vistra/framework/algorithm/impl/Dijkstra.java), Kruskal
<hr>

#### Stichworte
- Algorithmen: BFS, DFS, Dijkstra, Kruskal
- Datenstrukturen: un-/gerichteter, un-/gewichteter einfacher Graph
- Objektorientierte Programmierung (OOP), JavaSE-7
- Eclipse-Projekt mit Apache Maven
- GUI mit Swing
- Dateiformat *.vistra in GraphML

##### Bibliotheken
- <a target="_blank" href="http://net3.datastructures.net/">net.datastructures</a>
- <a target="_blank" href="http://jung.sourceforge.net/">JUNG - Java Universal Network/Graph Framework</a>
- <a target="_blank" href="http://commons.apache.org/proper/commons-io/">Apache Commons IO</a>
- <a target="_blank" href="http://graphml.graphdrawing.org/">The GraphML File Format</a>
