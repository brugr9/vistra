package ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.gui.util.GraphIdVerifier;

/**
 * A graph property dialog.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GraphPropertyDialog extends JDialog {

	private static final long serialVersionUID = -1767385966504542230L;

	/**
	 * A field for a content panel.
	 */
	private final JPanel contentPanel = new JPanel();

	private JTextField txtGraphName;

	private JTextArea textAreaGraphDescription;

	/**
	 * Create the dialog.
	 * 
	 * @param owner
	 * @param graph
	 */
	public GraphPropertyDialog(IGravisGraph graph, JFrame owner) {
		super(owner, true);

		// TODO remove string literals
		this.setTitle(graph.getId() + " bearbeiten...");

		this.setResizable(false);
		this.setBounds(100, 100, 500, 220);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panelGraphName = new JPanel();
		this.contentPanel.add(panelGraphName, BorderLayout.NORTH);
		panelGraphName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblGraphName = new JLabel("Name des Graphen:");
		panelGraphName.add(lblGraphName);

		this.txtGraphName = new JTextField();
		panelGraphName.add(this.txtGraphName);
		this.txtGraphName.setColumns(10);

		JPanel panelGraphDescription = new JPanel();
		this.contentPanel.add(panelGraphDescription, BorderLayout.CENTER);
		panelGraphDescription.setLayout(new BorderLayout(0, 0));

		JLabel lblGraphDescription = new JLabel("Beschreibung zum Graphen:");
		panelGraphDescription.add(lblGraphDescription, BorderLayout.NORTH);

		this.textAreaGraphDescription = new JTextArea();
		panelGraphDescription.add(this.textAreaGraphDescription,
				BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		this.getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		this.setTextFieldValues(graph);
		this.setListeners(graph, okButton, cancelButton);
		this.centerDialog();
	}

	/**
	 * @param graph
	 * @param okButton
	 * @param cancelButton
	 */
	private void setListeners(final IGravisGraph graph, final JButton okButton,
			final JButton cancelButton) {

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GraphPropertyDialog.this.updateTextFieldValues(graph);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GraphPropertyDialog.this.dispose();
			}
		});
	}

	/**
	 * @param graph
	 */
	protected void updateTextFieldValues(IGravisGraph graph) {
		graph.setId(this.txtGraphName.getText().trim());
		graph.setDescription(this.textAreaGraphDescription.getText().trim());
		this.dispose();
	}

	/**
	 * @param graph
	 */
	private void setTextFieldValues(IGravisGraph graph) {
		this.txtGraphName.setText(graph.getId());
		this.textAreaGraphDescription.setText(graph.getDescription());

		this.txtGraphName.setInputVerifier(new GraphIdVerifier(
				this.txtGraphName.getText().trim()));
	}

	private void centerDialog() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - this.getWidth()) / 2;
		final int y = (screenSize.height - this.getHeight()) / 2;
		this.setLocation(x, y);
	}

}
