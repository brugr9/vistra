package vistra.app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.app.control.IControl;
import vistra.app.view.component.AlgorithmPanel;
import vistra.app.view.component.GraphPanel;
import vistra.app.view.component.MenuBar;
import vistra.app.view.component.ProtocolPanel;
import vistra.app.view.component.ToolBar;
import vistra.app.view.component.TraversalPanel;
import vistra.framework.util.palette.ColorPalette;

/**
 * A view as in MVC.
 * <p>
 * This view instantiates
 * <ul>
 * <li>a {@link MenuBar}
 * <li>a {@link ToolBar}
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
	private final MenuBar menuBar;
	/**
	 * A field for a tool bar.
	 */
	private final ToolBar toolBar;
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
	public DefaultView(IModel model, IControl control) throws Exception {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setResizable(false);
		this.setLocation(20, 20);

		/* Components */
		this.menuBar = new MenuBar(model);
		this.toolBar = new ToolBar(model);
		this.graphPanel = new GraphPanel(this, model, new Dimension(
				VISUALISATION_WIDTH, VISUALISATION_HEIGHT));
		int width = FRAME_WIDTH - VISUALISATION_WIDTH;
		// TODO height
		this.algorithmPanel = new AlgorithmPanel(model, new Dimension(width,
				200));
		this.traversalPanel = new TraversalPanel(model, new Dimension(width,
				400));
		this.protocolPanel = new ProtocolPanel(new Dimension(width, 400));
		// components observe the model
		((Model) model).addObserver(this.menuBar);
		((Model) model).addObserver(this.toolBar);
		((Model) model).addObserver(this.graphPanel);
		((Model) model).addObserver(this.algorithmPanel);
		((Model) model).addObserver(this.traversalPanel);
		((Model) model).addObserver(this.protocolPanel);

		/* another panel */
		this.anotherPanel = new JPanel();
		this.anotherPanel.setLayout(new BorderLayout());
		this.anotherPanel.setBackground((Color) ColorPalette.apricot);
		this.anotherPanel.add(this.algorithmPanel, BorderLayout.NORTH);
		this.anotherPanel.add(this.traversalPanel, BorderLayout.CENTER);
		this.anotherPanel.add(this.protocolPanel, BorderLayout.SOUTH);

		/* this */
		this.setJMenuBar(this.menuBar);
		this.setLayout(new BorderLayout());
		this.add(this.toolBar, BorderLayout.NORTH);
		this.add(this.graphPanel, BorderLayout.WEST);
		this.add(this.anotherPanel, BorderLayout.EAST);
		try {
			control.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.setTitle(model.getResourceBundle().getString("app.label"));
		((Model) model).addObserver(this);
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			String title = m.getResourceBundle().getString("app.label");
			title += " - " + m.getGraph().getName();
			if (!m.isGraphSaved())
				title += "*";
			super.setTitle(title);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

}
