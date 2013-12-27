package vistra.gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.GuiModel;
import vistra.gui.control.IControl;
import vistra.gui.view.component.AlgorithmPanel;
import vistra.gui.view.component.GraphPanel;
import vistra.gui.view.component.MenuBar;
import vistra.gui.view.component.ProtocolPanel;
import vistra.gui.view.component.TraversalPanel;
import vistra.util.ColorPalette;
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
public class DefaultView extends JFrame implements IView {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for the menu bar.
	 */
	protected final MenuBar menuBar;
	/**
	 * A field for a graph panel.
	 */
	private final GraphPanel graphPanel;
	/**
	 * A field for another panel.
	 */
	private final JPanel anotherPanel;
	/**
	 * A field for an algorithm panel.
	 */
	private final AlgorithmPanel algorithmPanel;
	/**
	 * A field for a traversal panel.
	 */
	private final TraversalPanel traversalPanel;
	/**
	 * A field for a protocol panel.
	 */
	private final ProtocolPanel protocolPanel;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a model as in MVC
	 * @param control
	 *            a control as in MVC
	 * @throws Exception
	 */
	public DefaultView(Layout<IVertexLayout, IEdgeLayout> layout, GuiModel model,
			IControl control) throws Exception {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(model.getResourceBundle().getString("app.label"));
		this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);
		this.setLocation(20, 20);

		/* Components */
		this.menuBar = new MenuBar(model);
		this.graphPanel = new GraphPanel(this, model, layout, new Dimension(
				VISUALISATION_WIDTH, VISUALISATION_HEIGHT));
		int width = FRAME_WIDTH - VISUALISATION_WIDTH;
		// TODO height
		this.algorithmPanel = new AlgorithmPanel(model, new Dimension(width,
				200));
		this.traversalPanel = new TraversalPanel(model, new Dimension(width,
				400));
		this.protocolPanel = new ProtocolPanel(new Dimension(width, 400));
		// components observe the model
		model.addObserver(this.menuBar);
		model.addObserver(this.graphPanel);
		model.addObserver(this.algorithmPanel);
		model.addObserver(this.traversalPanel);
		model.addObserver(this.protocolPanel);

		/* another panel */
		this.anotherPanel = new JPanel();
		this.anotherPanel.setLayout(new BorderLayout());
		this.anotherPanel.setBackground((Color) ColorPalette.antique);
		this.anotherPanel.add(this.algorithmPanel, BorderLayout.NORTH);
		this.anotherPanel.add(this.traversalPanel, BorderLayout.CENTER);
		this.anotherPanel.add(this.protocolPanel, BorderLayout.SOUTH);

		/* this */
		this.setJMenuBar(this.menuBar);
		this.setLayout(new BorderLayout());
		this.add(this.graphPanel, BorderLayout.WEST);
		this.add(this.anotherPanel, BorderLayout.EAST);
		this.setVisible(true);
	}

}
