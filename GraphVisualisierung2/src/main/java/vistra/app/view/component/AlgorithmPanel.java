package vistra.app.view.component;

import java.awt.BorderLayout;
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

import vistra.app.IModel;
import vistra.app.control.IControl.ControlEvent;
import vistra.framework.util.palette.ColorPalette;

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
	private JTextArea text;
	/**
	 * A field for a scroll pane.
	 */
	private JScrollPane scroll;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model as in MVC
	 * @param size
	 *            the panel size
	 */
	public AlgorithmPanel(IModel model, Dimension size) {
		super();
		this.setSize(size);
		this.border = BorderFactory.createTitledBorder("algorithmPanel");
		this.setBorder(border);
		this.setBackground(ColorPalette.antique);

		/* combo */
		this.comboModel = new DefaultComboBoxModel<String>(
				model.getAlgorithms());
		this.combo = new JComboBox<String>(this.comboModel);
		this.combo.addItemListener(model.getParameterStateHandler());

		/* text area */
		this.text = new JTextArea();
		this.text.setEditable(false);
		this.text.setMinimumSize(size);
		this.text.setColumns(10);
		this.text.setRows(10);
		this.text.setLineWrap(true);
		this.text.setWrapStyleWord(true);
		this.text.setBackground(ColorPalette.grey);
		this.text.setForeground(ColorPalette.darkblue);
		// scroll pane
		this.scroll = new JScrollPane(this.text);
		this.scroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.scroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		/* this */
		this.setLayout(new BorderLayout());
		this.add(this.combo, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.SOUTH);

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

				if (arg == ControlEvent.I18N) {
					this.border.setTitle(b.getString("algorithm.label"));
				} else if (arg == ControlEvent.ALGORITHM) {
					this.comboModel = new DefaultComboBoxModel<String>(
							m.getAlgorithms());
					this.combo.setSelectedIndex(m.getSelectedAlgorithmIndex());
					this.text.setText(m.getAlgorithmDescription());
					this.text.setCaretPosition(1);
				}
				this.combo.setEnabled(m.isAlgorithmsEnabled());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}
	}
}
