package vistra.app.view.component;

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

import vistra.app.IModel;
import vistra.app.control.IControl.ControlEvent;
import vistra.framework.util.ColorPalette;

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
	private JTextArea text;
	/**
	 * A field for a scroll pane.
	 */
	private JScrollPane scroll;

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
		this.setBackground(ColorPalette.antique);

		/* text area */
		this.text = new JTextArea();
		this.text.setEditable(false);
		this.text.setMinimumSize(size);
		this.text.setColumns(20);
		this.text.setRows(20);
		this.text.setLineWrap(true);
		this.text.setWrapStyleWord(true);
		this.text.setBackground(ColorPalette.gray);
		this.text.setForeground(ColorPalette.darkblue);
		// scroll pane
		this.scroll = new JScrollPane(this.text);
		this.scroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.scroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		/* this */
		this.setLayout(new GridLayout(1, 1));
		this.add(this.scroll);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof IModel) {

			IModel m = (IModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == ControlEvent.I18N) {
					this.border.setTitle(b.getString("protocol.label"));
				}
				this.text.setText(m.getProtocol().toString());
				this.text.setCaretPosition(this.text.getDocument().getLength());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}
		}
	}
}
