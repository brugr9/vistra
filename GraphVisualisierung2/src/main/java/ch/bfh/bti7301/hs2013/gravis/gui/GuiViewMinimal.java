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
 * <li>a {@link ParameterPanel}
 * <li>a {@link VisualizationPanel}
 * <li>a {@link PlayerPanel}
 * </ul>
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GuiViewMinimal extends JFrame implements IGuiView {

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
	 * A field for a player panel.
	 */
	private final PlayerPanel playerPanel;

	/**
	 * Main constructor.
	 * 
	 * @param guiModel
	 *            a model as in MVC
	 * @param guiControl
	 *            a control as in MVC
	 * @param width
	 *            the width of the view
	 * @param height
	 *            the height of the view
	 */
	public GuiViewMinimal(GuiModel guiModel, GuiControl guiControl, int width,
			int height) {
		super(guiModel.getProgramName());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Components
		this.menuBar = GuiFactory.createMenuBar(guiModel, guiControl);
		this.parameterPanel = GuiFactory
				.createRenderPanel(guiModel, guiControl);
		this.visualizationPanel = GuiFactory.createVisualizationPanel(guiModel);
		this.playerPanel = GuiFactory.createPlayerPanel(guiModel, guiControl);

		// Layout
		this.setJMenuBar(this.menuBar);
		this.panel1 = new JPanel();
		this.panel1.setLayout(new BorderLayout());
		this.panel1.add(this.parameterPanel, BorderLayout.NORTH);
		this.panel1.add(this.visualizationPanel, BorderLayout.SOUTH);
		this.panel2 = new JPanel();
		this.panel2.setLayout(new BorderLayout());
		this.panel2.add(this.playerPanel, BorderLayout.NORTH);
		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);

		// Size
		this.setLocation(60, 50);
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(true);
		// let's go ...
		try {
			guiControl.init();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"setViewInit():\n" + e.getMessage(),
					guiModel.getProgramName(), 1, null);
			e.printStackTrace();
		}
		this.setVisible(true);
	}
}
