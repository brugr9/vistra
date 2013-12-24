package vistra.gui.view.component;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
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
 * A protocol panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ProtocolPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a titled border.
	 */
	private TitledBorder border;
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
	 * @param size
	 *            the size
	 */
	public ProtocolPanel(Dimension size) {
		super();
		this.setMinimumSize(size);
		this.border = BorderFactory.createTitledBorder("protocolPanel");
		this.setBorder(border);

		/* text area */
		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.textArea.setMinimumSize(size);
		this.textArea.setColumns(20);
		this.textArea.setRows(20);
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
		this.setLayout(new GridLayout(1, 1));
		this.add(this.scrollPane);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof IGuiModel) {

			IGuiModel m = (IGuiModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == EventSource.I18N) {
					this.border.setTitle(b.getString("protocol.label"));
				}
				this.textArea.setText(m.getStringBuilder().toString());
				this.textArea.setCaretPosition(this.textArea.getDocument()
						.getLength());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}
		}
	}
}
