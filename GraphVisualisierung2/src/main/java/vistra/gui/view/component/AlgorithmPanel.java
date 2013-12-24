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

import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
import vistra.util.ColorPalette;

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
	private TitledBorder border;
	/**
	 * A field for a combo box.
	 */
	private JComboBox<String> combo;
	/**
	 * A field for a combo box model.
	 */
	private ComboBoxModel<String> comboModel;
	/**
	 * A field for a text area.
	 */
	private JTextArea textArea;
	/**
	 * A field for a scroll pane.
	 */
	private JScrollPane scrollPane;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model as in MVC
	 * @param size
	 *            the panel size
	 */
	public AlgorithmPanel(IGuiModel model, Dimension size) {
		super();
		this.setSize(size);
		this.border = BorderFactory.createTitledBorder("algorithmPanel");
		this.setBorder(border);
		this.setBackground((Color) ColorPalette.antique);

		/* combo */
		this.comboModel = new DefaultComboBoxModel<String>(
				model.getAlgorithms());
		this.combo = new JComboBox<String>(this.comboModel);
		this.combo.addItemListener(model.getParameterStateHandler());

		/* text area */
		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.textArea.setMinimumSize(size);
		this.textArea.setColumns(10);
		this.textArea.setRows(10);
		this.textArea.setLineWrap(true);
		this.textArea.setWrapStyleWord(true);
		this.textArea.setBackground(ColorPalette.gray);
		this.textArea.setForeground(ColorPalette.darkblue);
		// scroll pane
		this.scrollPane = new JScrollPane(this.textArea);
		this.scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		/* this */
		this.setLayout(new BorderLayout());
		this.add(this.combo, BorderLayout.NORTH);
		this.add(this.scrollPane, BorderLayout.SOUTH);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof IGuiModel) {

			IGuiModel m = (IGuiModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == EventSource.I18N) {
					this.border.setTitle(b.getString("algorithm.label"));
				} else if (arg == EventSource.GRAPH) {
					this.combo.setEnabled(m.isAlgorithmsEnabled());
				} else if (arg == EventSource.ALGORITHM) {
					this.comboModel = new DefaultComboBoxModel<String>(
							m.getAlgorithms());
					this.combo.setSelectedIndex(m.getSelectedAlgorithmIndex());
					this.combo.setEnabled(m.isAlgorithmsEnabled());
					this.textArea.setText(m.getAlgorithmDescription());
					this.textArea.setCaretPosition(1);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}
	}
}
