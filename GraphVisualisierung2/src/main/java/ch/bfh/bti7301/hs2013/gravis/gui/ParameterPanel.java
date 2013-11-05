package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * An settings panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ParameterPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a settings panel.
	 */
	private JPanel settingsPanel;
	/**
	 * A field for a titled border.
	 */
	private TitledBorder settingsPanelBorder;
	/**
	 * A field for a graph label.
	 */
	private JLabel graphLabel;
	/**
	 * A field for a algorithm label.
	 */
	private JLabel algorithmLabel;
	/**
	 * A field for a graph combo box.
	 */
	private JComboBox<String> graphCombo;
	/**
	 * A field for a graph combo model.
	 */
	private ComboBoxModel<String> graphComboModel;
	/**
	 * A field for an algorithm combo box.
	 */
	private JComboBox<String> algorithmCombo;
	/**
	 * A field for an algorithm combo model.
	 */
	private ComboBoxModel<String> algorithmComboModel;

	/**
	 * Main constructor.
	 * 
	 * @param guiControl
	 *            the controller as in MVC
	 */
	public ParameterPanel(GuiControl guiControl) {

		this.graphLabel = new JLabel("graphLabel");
		this.algorithmLabel = new JLabel("algorithmLabel");

		// Combobox
		this.graphComboModel = new DefaultComboBoxModel<String>(new String[] {});
		this.graphCombo = new JComboBox<String>(this.graphComboModel);
		this.graphCombo.addItemListener(guiControl.graphSettingsListener);
		// this.graphCombo.setBounds(463, 12, 170, 20);

		this.algorithmComboModel = new DefaultComboBoxModel<String>(
				new String[] {});
		this.algorithmCombo = new JComboBox<String>(this.algorithmComboModel);
		this.algorithmCombo
				.addItemListener(guiControl.algorithmSettingsListener);
		// this.algorithmCombo.setBounds(463, 12, 170, 20);

		// Panel
		this.settingsPanel = new JPanel();
		this.settingsPanel.setLayout(new BorderLayout());
		this.settingsPanelBorder = BorderFactory
				.createTitledBorder("settingsPanel");
		this.settingsPanel.setBorder(settingsPanelBorder);
		this.settingsPanel.setLayout(new GridLayout(1, 5));
		this.settingsPanel.add(this.graphLabel);
		this.settingsPanel.add(this.graphCombo);
		this.settingsPanel.add(this.algorithmLabel);
		this.settingsPanel.add(this.algorithmCombo);

		// this
		this.setLayout(new BorderLayout());
		this.add(this.settingsPanel);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {
		GuiModel m = (GuiModel) o;

		try {

			this.settingsPanelBorder.setTitle(m.getRenderPanelLabel());
			// label
			this.graphLabel.setText(m.getGraphLabel());
			this.algorithmLabel.setText(m.getAlgorithmLabel());
			// combo
			this.graphComboModel = new DefaultComboBoxModel<String>(
					m.getGraphComboModel());
			this.algorithmComboModel = new DefaultComboBoxModel<String>(
					m.getAlgorithmComboModel());

			this.graphCombo.setSelectedIndex(m.getGraphSelected());
			this.algorithmCombo.setSelectedIndex(m.getAlgorithmSelected());

			this.graphCombo.setEnabled(m.isGraphEnabled());
			this.algorithmCombo.setEnabled(m.isAlgorithmEnabled());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					m.getProgramName(), 1, null);
			e.printStackTrace();
		}

	}
}
