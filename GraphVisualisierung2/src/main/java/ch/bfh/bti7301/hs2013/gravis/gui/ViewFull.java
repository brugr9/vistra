package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A view as in MVC.
 * <p>
 * This view instantiates
 * <ul>
 * <li>a {@link MenuBar}
 * <li>a {@link ParameterPanel}
 * <li>a {@link VisualizationPanel}
 * <li>a {@link TraversalPanel}
 * <li>a {@link ProtocolPanel}
 * </ul>
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ViewFull extends JFrame implements IView {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a panel.
	 */
	private final JPanel panel1;
	/**
	 * A field for a second panel.
	 */
	private final JPanel panel2;
	/**
	 * A field for the menu bar.
	 */
	private final MenuBar menuBar;
	/**
	 * A field for the settings panel.
	 */
	private final ParameterPanel parameterPanel;
	/**
	 * A field for a visualization panel.
	 */
	private final VisualizationPanel visualizationPanel;
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
	 * @param width
	 *            the width of the frame
	 * @param height
	 *            the height of the frame
	 * @throws Exception
	 */
	public ViewFull(Model model, Control control, int width,
			int height) throws Exception {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Components
		this.menuBar = GuiFactory.createMenuBar(model, control);
		this.parameterPanel = GuiFactory.createParameterController(model,
				control);
		this.visualizationPanel = GuiFactory.createVisualizer(model);
		this.traversalPanel = GuiFactory.createTraversalController(model, control);
		this.protocolPanel = GuiFactory.createProtocolPanel(model, width, 30);

		// Layout
		this.setJMenuBar(this.menuBar);
		this.panel1 = new JPanel();
		this.panel1.setLayout(new BorderLayout());
		this.panel1.add(this.parameterPanel, BorderLayout.NORTH);
		this.panel1.add(this.visualizationPanel, BorderLayout.SOUTH);
		this.panel2 = new JPanel();
		this.panel2.setLayout(new BorderLayout());
		this.panel2.add(this.traversalPanel, BorderLayout.NORTH);
		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(this.protocolPanel, BorderLayout.SOUTH);

		// Size
		this.setLocation(60, 50);
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(true);

		// let's go ...
		control.init();
		super.setTitle(model.getResourceBundle().getString("app.label"));
		this.setVisible(true);
	}
}
