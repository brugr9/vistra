package vistra.gui.view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import vistra.gui.IModel;
import vistra.gui.control.IControl.EventSource;
import vistra.util.VistraColor;


/**
 * An algorithm panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class AlgorithmPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a titled border.
	 */
	private TitledBorder titledBorder;
	/**
	 * A field for an algorithm combo box.
	 */
	private JComboBox<String> algorithmCombo;
	/**
	 * A field for an algorithm combo model.
	 */
	private ComboBoxModel<String> algorithmComboModel;
	/**
	 * A field for an algorithm description text area.
	 */
	private JTextArea algorithmDescriptionTextArea;
	/**
	 * A field for an algorithm description scroll pane.
	 */
	private JScrollPane algorithmDescriptionScrollPane;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model as in MVC
	 */
	public AlgorithmPanel(IModel model, int width, int height) {
		super();
		this.setSize(new Dimension(width, height));

		// combo
		this.algorithmComboModel = new DefaultComboBoxModel<String>(
				model.getAlgorithms());
		this.algorithmCombo = new JComboBox<String>(this.algorithmComboModel);
		this.algorithmCombo.addItemListener(model.getParameterStateHandler());

		// algorithmDescriptionTextArea
		this.algorithmDescriptionTextArea = new JTextArea();
		this.algorithmDescriptionTextArea.setEditable(false);
		this.algorithmDescriptionTextArea.setMinimumSize(new Dimension(width,
				height / 3));
		this.algorithmDescriptionTextArea.setColumns(10);
		this.algorithmDescriptionTextArea.setRows(10);
		this.algorithmDescriptionTextArea.setLineWrap(true);
		this.algorithmDescriptionTextArea.setWrapStyleWord(true);
		this.algorithmDescriptionTextArea.setBackground(VistraColor.LIGHT_GRAY);
		this.algorithmDescriptionTextArea.setForeground(VistraColor.DARK_BLUE);
		// algorithmDescriptionScrollPane
		this.algorithmDescriptionScrollPane = new JScrollPane(
				this.algorithmDescriptionTextArea);
		this.algorithmDescriptionScrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.algorithmDescriptionScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// this
		this.titledBorder = BorderFactory.createTitledBorder("algorithmPanel");
		this.setBorder(titledBorder);
		this.setBackground((Color) VistraColor.ANTIQUE);
		this.setLayout(new BorderLayout());
		this.add(this.algorithmCombo, BorderLayout.NORTH);
		this.add(this.algorithmDescriptionTextArea, BorderLayout.SOUTH);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof IModel) {

			IModel m = (IModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == EventSource.I18N) {
					this.titledBorder.setTitle(b.getString("algorithm.label"));
				} else if (arg == EventSource.GRAPH) {
					this.algorithmCombo.setEnabled(m.isAlgorithmsEnabled());
				} else if (arg == EventSource.ALGORITHM) {
					this.algorithmComboModel = new DefaultComboBoxModel<String>(
							m.getAlgorithms());
					this.algorithmCombo.setSelectedIndex(m
							.getSelectedAlgorithmIndex());
					this.algorithmCombo.setEnabled(m.isAlgorithmsEnabled());
					this.algorithmDescriptionTextArea.setText(m
							.getAlgorithmDescription());
					this.algorithmDescriptionTextArea.setCaretPosition(1);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}
	}
}
