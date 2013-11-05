package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

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
	 */
	public ProtocolPanel() {

		// protocolTextArea
		this.protocolTextArea = new JTextArea();
		this.protocolTextArea.setEditable(false);
		this.protocolTextArea.setColumns(30);
		this.protocolTextArea.setRows(10);
		this.protocolTextArea.setLineWrap(true);
		this.protocolTextArea.setWrapStyleWord(true);
		this.protocolTextArea.setBackground(Color.WHITE);
		this.protocolTextArea.setForeground(Color.BLUE);
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
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {
		GuiModel m = (GuiModel) o;
		try {
			this.protocolPanelBorder.setTitle(m.getProtocolPanelLabel());
			this.protocolTextArea.setText(m.getProtocolPanelText());
			this.protocolTextArea.setCaretPosition(this.protocolTextArea
					.getDocument().getLength());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					m.getProgramName(), 1, null);
			e.printStackTrace();
		}
	}
}
