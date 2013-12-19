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

import vistra.gui.IModel;
import vistra.gui.control.IControl.EventSource;
import vistra.util.VistraColor;


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
	private TitledBorder protocolPanelBorder;
	/**
	 * A field for a messages screen.
	 */
	private JTextArea protocolTextArea;
	/**
	 * A field for a scroll pane.
	 */
	private JScrollPane protocolScrollPane;

	/**
	 * Main constructor.
	 * 
	 * @param width
	 *            the panel width
	 * @param height
	 *            the panel height
	 */
	public ProtocolPanel(int width, int height) {
		super();
		// size
		this.setMinimumSize(new Dimension(width, height));

		// protocolTextArea
		this.protocolTextArea = new JTextArea();
		this.protocolTextArea.setEditable(false);
		this.protocolTextArea.setMinimumSize(new Dimension(width, height));
		this.protocolTextArea.setColumns(50);
		this.protocolTextArea.setRows(8);
		this.protocolTextArea.setLineWrap(true);
		this.protocolTextArea.setWrapStyleWord(true);
		this.protocolTextArea.setBackground(VistraColor.LIGHT_GRAY);
		this.protocolTextArea.setForeground(VistraColor.DARK_BLUE);
		// protocolScrollPane
		this.protocolScrollPane = new JScrollPane(this.protocolTextArea);
		this.protocolScrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.protocolScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// Layout
		this.protocolPanelBorder = BorderFactory
				.createTitledBorder("protocolPanel");
		this.setBorder(protocolPanelBorder);
		this.setLayout(new GridLayout(1, 1));
		this.add(this.protocolScrollPane);
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

				if (arg == EventSource.I18N) {
					this.protocolPanelBorder.setTitle(b
							.getString("protocol.label"));
				}
				this.protocolTextArea.setText(m.getStringBuilder().toString());
				this.protocolTextArea.setCaretPosition(this.protocolTextArea
						.getDocument().getLength());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}
		}
	}
}
