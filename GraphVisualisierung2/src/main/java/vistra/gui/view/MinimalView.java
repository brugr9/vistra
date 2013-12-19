package vistra.gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import vistra.gui.Model;
import vistra.gui.control.IControl;
import vistra.gui.view.component.AlgorithmPanel;
import vistra.gui.view.component.GraphPanel;
import vistra.gui.view.component.MenuBar;
import vistra.gui.view.component.TraversalPanel;
import vistra.util.VistraColor;
import edu.uci.ics.jung.algorithms.layout.Layout;

/**
 * A view as in MVC.
 * <p>
 * This view instantiates
 * <ul>
 * <li>a {@link MenuBar}
 * <li>a {@link GraphPanel}
 * <li>a controller panel with a {@link AlgorithmPanel} and a
 * {@link TraversalPanel}
 * </ul>
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class MinimalView extends JFrame implements IView {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for the menu bar.
	 */
	protected final MenuBar menuBar;
	/**
	 * A field for a visualization panel.
	 */
	private final GraphPanel visualizationPanel;
	/**
	 * A field for a right panel.
	 */
	private final JPanel controlPanel;
	/**
	 * A field for the settings panel.
	 */
	private final AlgorithmPanel parameterPanel;
	/**
	 * A field for a traversal panel.
	 */
	private final TraversalPanel playerPanel;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a model as in MVC
	 * @param control
	 *            a control as in MVC
	 * @throws Exception
	 */
	public MinimalView(Layout<IVertex, IEdge> layout, Model model,
			IControl control) throws Exception {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(20, 20);
		this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);

		/* Components */
		this.menuBar = new MenuBar(model);
		this.visualizationPanel = new GraphPanel(this, model, layout,
				new Dimension(VISUALISATION_WIDTH, VISUALISATION_HEIGHT));
		int width = FRAME_WIDTH - VISUALISATION_WIDTH;
		// TODO height
		this.parameterPanel = new AlgorithmPanel(model, width, 200);
		this.playerPanel = new TraversalPanel(model, width, 400);

		// components observe the model
		model.addObserver(this.menuBar);
		model.addObserver(this.visualizationPanel);
		model.addObserver(this.parameterPanel);
		model.addObserver(this.playerPanel);

		/* control panel */
		this.controlPanel = new JPanel();
		this.controlPanel.setLayout(new BorderLayout());
		this.controlPanel.setBackground((Color) VistraColor.ANTIQUE);
		this.controlPanel.add(this.parameterPanel, BorderLayout.NORTH);
		this.controlPanel.add(this.playerPanel, BorderLayout.SOUTH);

		/* this */
		this.setJMenuBar(this.menuBar);
		this.setLayout(new BorderLayout());
		this.add(this.visualizationPanel, BorderLayout.WEST);
		this.add(this.controlPanel, BorderLayout.EAST);
		control.init();
		this.setTitle(model.getResourceBundle().getString("app.label"));
		this.setVisible(true);
	}

}
