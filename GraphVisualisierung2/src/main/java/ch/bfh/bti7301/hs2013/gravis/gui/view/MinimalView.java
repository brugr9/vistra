package ch.bfh.bti7301.hs2013.gravis.gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.gui.Model;
import ch.bfh.bti7301.hs2013.gravis.gui.control.Control;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.MenuBar;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.ParameterPanel;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.PlayerPanel;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.VisualizationPanel;
import ch.bfh.bti7301.hs2013.gravis.util.GravisColor;
import edu.uci.ics.jung.algorithms.layout.Layout;

/**
 * A view as in MVC.
 * <p>
 * This view instantiates
 * <ul>
 * <li>a {@link MenuBar}
 * <li>a {@link VisualizationPanel}
 * <li>a controller panel with a {@link ParameterPanel} and a
 * {@link PlayerPanel}
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
	private final VisualizationPanel visualizationPanel;
	/**
	 * A field for a right panel.
	 */
	private final JPanel controlPanel;
	/**
	 * A field for an edit mode combo box.
	 */
	private JComboBox<?> editModeComboBox;
	/**
	 * A field for the settings panel.
	 */
	private final ParameterPanel parameterPanel;
	/**
	 * A field for a traversal panel.
	 */
	private final PlayerPanel playerPanel;

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
			Control control) throws Exception {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(20, 20);
		this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);

		/* Components */
		this.menuBar = new MenuBar(model);
		this.visualizationPanel = new VisualizationPanel(this, model, layout,
				new Dimension(VISUALISATION_WIDTH, VISUALISATION_HEIGHT));
		this.editModeComboBox = this.visualizationPanel.getModeComboBox();
		int width = FRAME_WIDTH - VISUALISATION_WIDTH;
		// TODO height
		this.parameterPanel = new ParameterPanel(model, width, 200);
		this.playerPanel = new PlayerPanel(model, width, 400);

		// components observe the model
		model.addObserver(this.menuBar);
		model.addObserver(this.visualizationPanel);
		model.addObserver(this.parameterPanel);
		model.addObserver(this.playerPanel);

		/* control panel */
		this.controlPanel = new JPanel();
		this.controlPanel.setLayout(new BorderLayout());
		this.controlPanel.setBackground((Color) GravisColor.ANTIQUE);
		this.controlPanel.add(this.editModeComboBox, BorderLayout.NORTH);
		this.controlPanel.add(this.parameterPanel, BorderLayout.CENTER);
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
