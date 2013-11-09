package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A view as in MVC.
 * <p>
 * This view instantiates
 * <ul>
 * <li>a {@link MenuBar}
 * <li>a {@link ParameterController}
 * <li>a {@link Visualizer}
 * <li>a {@link TraversalController}
 * </ul>
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ViewMinimal extends JFrame implements IView {

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
	private final ParameterController parameterController;
	/**
	 * A field for a visualization panel.
	 */
	private final Visualizer visualizer;
	/**
	 * A field for a player panel.
	 */
	private final TraversalController traversalController;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a model as in MVC
	 * @param control
	 *            a control as in MVC
	 * @param width
	 *            the width of the view
	 * @param height
	 *            the height of the view
	 */
	public ViewMinimal(Model model, Control control, int width,
			int height) {
		super(model.getProgramName());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Components
		this.menuBar = GuiFactory.createMenuBar(model, control);
		this.parameterController = GuiFactory
				.createParameterController(model, control);
		this.visualizer = GuiFactory.createVisualizer(model);
		this.traversalController = GuiFactory.createTraversalController(model, control);

		// Layout
		this.setJMenuBar(this.menuBar);
		this.panel1 = new JPanel();
		this.panel1.setLayout(new BorderLayout());
		this.panel1.add(this.parameterController, BorderLayout.NORTH);
		this.panel1.add(this.visualizer, BorderLayout.SOUTH);
		this.panel2 = new JPanel();
		this.panel2.setLayout(new BorderLayout());
		this.panel2.add(this.traversalController, BorderLayout.NORTH);
		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);

		// Size
		this.setLocation(60, 50);
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(true);
		// let's go ...
		try {
			control.init();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"setViewInit():\n" + e.getMessage(),
					model.getProgramName(), 1, null);
			e.printStackTrace();
		}
		this.setVisible(true);
	}
}
