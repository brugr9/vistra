package ch.bfh.bti7301.hs2013.gravis.old;

import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.BACKWARD_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.BEGINNING_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.DELETE_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.DELETE_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.END_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.EXIT_APPLICATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.EXPORT_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.FORWARD_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.IMPORT_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.IMPORT_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.PAUSE_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.PLAY_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.SAVE_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.SELECT_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.SELECT_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.START_PROCESSING;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.STEP_INCREMENT;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.STOP_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.TIME_INTERVALL;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.NEW_DIR_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.NEW_UNDIR_GRAPH;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.Observable;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeEvent;
import ch.bfh.bti7301.hs2013.gravis.core.TraversalChangeListener;
import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.GravisVisualizationViewer;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.VisualizationPanel;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @deprecated
 */
public class OldMainWindowListener extends Observable implements
		OldIGravisMainListener {

	final private ICore gravisCore;

	final private GravisVisualizationViewer vViewer;

	/**
	 * @param gravisCore
	 * @param vViewer
	 */
	public OldMainWindowListener(ICore gravisCore,
			GravisVisualizationViewer vViewer) {
		this.gravisCore = gravisCore;
		this.vViewer = vViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.importGraphListener(e);
		this.importAlgorithmListener(e);
		this.deleteGraphListener(e);
		this.deleteAlgorithmListener(e);
		this.startProcessingListener(e);
		this.saveGraphListener(e);
		this.exportGraphListener(e);
		this.exitApplicationListener(e);
		this.playListener(e);
		this.pauseListener(e);
		this.stopListener(e);
		this.toBeginningListener(e);
		this.toEndListener(e);
		this.forwardListener(e);
		this.backwardListener(e);
		
		if (e.getActionCommand().equals(NEW_DIR_GRAPH.toString())) {
			System.out.println(NEW_DIR_GRAPH);
			
			IGravisGraph graph = GraphFactory.createIGravisGraph();
			graph.setEdgeType(EdgeType.DIRECTED);
			this.gravisCore.selectGraph(graph);
			this.setChanged();
			this.notifyObservers(graph);
		}
		if (e.getActionCommand().equals(NEW_UNDIR_GRAPH.toString())) {
			System.out.println(NEW_UNDIR_GRAPH);
			
			IGravisGraph graph = GraphFactory.createIGravisGraph();
			graph.setEdgeType(EdgeType.UNDIRECTED);
			this.gravisCore.selectGraph(graph);
			this.setChanged();
			this.notifyObservers(graph);
		}
	}

	/**
	 * @param e
	 */
	private void backwardListener(ActionEvent e) {
		if (e.getActionCommand().equals(BACKWARD_ANIMATION.toString())) {
			try {
				System.out.println(this.gravisCore.goBackward());
				// System.out.println("goBackward");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			this.setChanged();
			this.notifyObservers();
		}
	}

	/**
	 * @param e
	 * @throws Exception
	 */
	private void forwardListener(ActionEvent e) {
		if (e.getActionCommand().equals(FORWARD_ANIMATION.toString())) {
			try {
				System.out.println(this.gravisCore.goForward());

				// System.out.println("goForward");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			this.setChanged();
			this.notifyObservers();
		}
	}

	/**
	 * @param e
	 */
	private void toEndListener(ActionEvent e) {
		if (e.getActionCommand().equals(END_ANIMATION.toString())) {

			try {
				System.out.println(this.gravisCore.goToEnd());
				// System.out.println("goEnd");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			this.setChanged();
			this.notifyObservers();
		}
	}

	/**
	 * @param e
	 */
	private void toBeginningListener(ActionEvent e) {
		if (e.getActionCommand().equals(BEGINNING_ANIMATION.toString())) {

			try {
				System.out.println(this.gravisCore.goToBeginning());
				// System.out.println("goBeginning");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			this.setChanged();
			this.notifyObservers();
		}
	}

	/**
	 * @param e
	 */
	private void stopListener(ActionEvent e) {
		if (e.getActionCommand().equals(STOP_ANIMATION.toString())) {
		}
	}

	/**
	 * @param e
	 */
	private void pauseListener(ActionEvent e) {
		if (e.getActionCommand().equals(PAUSE_ANIMATION.toString())) {
		}
	}

	/**
	 * @param e
	 */
	private void playListener(ActionEvent e) {
		if (e.getActionCommand().equals(PLAY_ANIMATION.toString())) {
		}
	}

	/**
	 * @param e
	 */
	private void exitApplicationListener(ActionEvent e) {
		if (e.getActionCommand().equals(EXIT_APPLICATION.toString())) {
			int value = JOptionPane.showConfirmDialog(null,
					"Programm wirklich beenden?", "Beenden",
					JOptionPane.YES_NO_OPTION);
			if (value == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	/**
	 * @param e
	 */
	private void exportGraphListener(ActionEvent e) {
		if (e.getActionCommand().equals(EXPORT_GRAPH.toString())) {
			try {
				this.gravisCore
						.exportGraph(
								(IGravisGraph) this.vViewer.getGraphLayout()
										.getGraph(),
								new File(
										"src/main/resources/META-INF/templates/ExportGraph.graphml"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("Graph exportiert: "
					+ ((IGravisGraph) this.vViewer.getGraphLayout().getGraph())
							.getId());

			// for (IVertex vertex : this.vViewer
			// .getGraphLayout().getGraph().getVertices()) {
			// System.out.println(vertex.getLocation());
			// }

			// TODO read path from FileChooser
			// IGravisGraph<IVertex, IEdge> graph =
			// this.gravisCore.exportCurrentGraph("path");
		}
	}

	/**
	 * @param e
	 */
	private void saveGraphListener(ActionEvent e) {
		if (e.getActionCommand().equals(SAVE_GRAPH.toString())) {
			try {
				this.gravisCore.saveGraph((IGravisGraph) this.vViewer
						.getGraphLayout().getGraph());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("Graph gespeichert: "
					+ ((IGravisGraph) this.vViewer.getGraphLayout().getGraph())
							.getId());

			// for (IVertex vertex : this.vViewer
			// .getGraphLayout().getGraph().getVertices()) {
			// System.out.println(vertex.getLocation());
			// }

			// TODO read name from dialog
			// IGravisGraph<IVertex, IEdge> graph =
			// this.gravisCore.saveCurrentGraph("graph name");
			// TODO new entry in comboBox list
		}
	}

	/**
	 * @param e
	 */
	private void startProcessingListener(ActionEvent e) {
		if (e.getActionCommand().equals(START_PROCESSING.toString())) {
			// TODO feedback to user
			// JOptionPane.showMessageDialog(null,
			// "Die Traversierung wird für folgende Parameter berechnet...\nGraph: "
			// +
			// "\nAlgorithmus: "
			// );

			// TODO needed parameter: observer for processing and traversing
			// updates

			TraversalChangeListener listener = new TraversalChangeListener() {

				@Override
				public void stateChanged(TraversalChangeEvent e) {
					// if (e instanceof TraversalChangeEvent) {
					// TraversalChangeEvent graphEvent = (TraversalChangeEvent)
					// e;

					System.out.println(e.getMessage());
					// }
				}
			};

			try {
				this.gravisCore.executeTraverser(listener);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// TODO lock the ui controls while processing
			// TODO feedback to user that processing has started, is running,
			// has ended (progress bar)
			// TODO enable GUI

			// TODO feedback message to user
			// JOptionPane.showMessageDialog(null,
			// "Die Berechnung wurde erfolgreich abgeschlossen!");
		}
	}

	/**
	 * @param e
	 */
	private void deleteAlgorithmListener(ActionEvent e) {
		if (e.getActionCommand().equals(DELETE_ALGORITHM.toString())) {
			// TODO read name from comboBox
			// this.gravisCore.unloadAlgorithm("Algoritmus XY");

			// TODO remove the algo from combo-list

			// TODO feedback to user
			JOptionPane.showMessageDialog(null,
					"Der folgende Algorithmus wurde gelöscht: "
							+ "Algoritmus XY");
		}
	}

	/**
	 * @param e
	 */
	private void deleteGraphListener(ActionEvent e) {
		if (e.getActionCommand().equals(DELETE_GRAPH.toString())) {
			// String graphName = this.gravisCore.getCurrentGraphName();
			// IGravisGraph<IVertex, IEdge> graph =
			// this.gravisCore.clearCurrentGraph();

			// TODO remove graph name from comboBox list

			// this.setChanged();
			// this.notifyObservers(graph);

			// TODO feedback to user
			// JOptionPane.showMessageDialog(null,"Der folgende Graph wurde gelöscht: "
			// +
			// graphName);
		}
	}

	/**
	 * @param e
	 */
	private void importAlgorithmListener(ActionEvent e) {
		if (e.getActionCommand().equals(IMPORT_ALGORITHM.toString())) {
			// TODO read from FileChooser
			// this.gravisCore.importAlgorithm("");

			// IAlgorithm algorithm = this.gravisCore.importAlgorithm("");
			// this.gravisCore.setProcessingAlgorithm(algorithm);

			// TODO lock the ui controls while processing
			// TODO add the new algo to the combobox-list
			// TODO feedback to user
			// JOptionPane.showMessageDialog(null,"Der folgende Algorithmus wurde importiert: "
			// +
			// algorithm.getName());
		}
	}

	/**
	 * @param e
	 */
	private void importGraphListener(ActionEvent e) {
		if (e.getActionCommand().equals(IMPORT_GRAPH.toString())) {
			// TODO read from FileChooser
			// IGravisGraph<IVertex, IEdge> graph =
			// this.gravisCore.importGraph("Sample Tree 1");
			// this.gravisCore.setProcessingGraph(graph);

			// TODO update comboBox list

			// this.setChanged();
			// this.notifyObservers(graph);

			// TODO feedback to user
			// JOptionPane.showMessageDialog(null,"Der folgende Graph wurde importiert: "
			// +
			// graph.getGraphName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED
				&& e.getSource() instanceof JComboBox<?>
				&& e.getItem() instanceof String) {
			JComboBox<?> combo = (JComboBox<?>) e.getSource();

			this.selectGraphListener(e, combo);
			this.selectAlgorithmListener(e, combo);
			this.stepIncrementListener(e, combo);
			this.timeIntervallListener(e, combo);
		}

	}

	/**
	 * @param e
	 * @param combo
	 */
	private void timeIntervallListener(ItemEvent e, JComboBox<?> combo) {
		if (combo.getActionCommand().equals(TIME_INTERVALL.toString())) {
			// TODO check valid input
			// this.gravisCore.setTraversingTimeIntervall(2);
		}
	}

	/**
	 * @param e
	 * @param combo
	 */
	private void stepIncrementListener(ItemEvent e, JComboBox<?> combo) {
		if (combo.getActionCommand().equals(STEP_INCREMENT.toString())) {
			// TODO check valid input
			// this.gravisCore.setTraversingStepIncrement(1);
		}
	}

	/**
	 * @param e
	 * @param combo
	 */
	private void selectAlgorithmListener(ItemEvent e, JComboBox<?> combo) {
		if (combo.getActionCommand().equals(SELECT_ALGORITHM.toString())) {
			if (e.getItem() instanceof String) {
				String algorithmName = (String) e.getItem();

				// TODO remove string literal
				if (!algorithmName.equals("Algorithmus wählen")) {
					try {
						this.gravisCore.selectAlgorithm(1);
						this.setChanged();
						this.notifyObservers();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// TODO enable GUI
					// JOptionPane.showMessageDialog(null,algorithm.getName());
				}
			}
		}
	}

	/**
	 * @param e
	 * @param combo
	 */
	private void selectGraphListener(ItemEvent e, JComboBox<?> combo) {
		if (combo.getActionCommand().equals(SELECT_GRAPH.toString())) {
			if (e.getItem() instanceof String) {
				String graphName = (String) e.getItem();

				// TODO remove string literal
				if (!graphName.equals("Graph wählen")) {
					IGravisGraph graph;
					try {
						graph = this.gravisCore.selectGraph(1);
						// this.gravisCore.saveGraph(graph);

						this.setChanged();
						this.notifyObservers(graph);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO updates while processing and traversing

	}

}
