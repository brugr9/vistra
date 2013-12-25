package vistra.gui.view.component.viewer.popup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vistra.core.graph.item.edge.ILayoutEdge;
import vistra.core.graph.item.vertex.ILayoutVertex;
import vistra.gui.view.component.viewer.popup.verifier.GraphItemIdVerifier;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A vertex property dialog.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexDialog extends JDialog {

	private static final long serialVersionUID = -6919635847499019908L;

	/**
	 * A field for a content panel.
	 */
	private final JPanel contentPanel;

	/**
	 * A field for a vertext name text field.
	 */
	private JTextField txtVertexName;

	/**
	 * Create the dialog.
	 * 
	 * @param vertex
	 * @param owner
	 * @param vViewer
	 */
	public VertexDialog(final ILayoutVertex vertex, final JFrame owner,
			final VisualizationViewer<ILayoutVertex, ILayoutEdge> vViewer) {
		super(owner, true);
		this.setResizable(false);
		// TODO remove string literals
		this.setTitle("Knoten " + vertex.getId() + " bearbeiten...");

		this.contentPanel = new JPanel();
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPanel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblVertexName = new JLabel("Name:              ");
		this.contentPanel.add(lblVertexName);
		this.txtVertexName = new JTextField();
		this.contentPanel.add(txtVertexName);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		this.setTextFieldValues(vertex, vViewer);
		this.setListeners(vertex, vViewer, okButton, cancelButton);

		this.pack();
	}

	/**
	 * @param vertex
	 * @param vViewer
	 * @param okButton
	 * @param cancelButton
	 */
	private void setListeners(final ILayoutVertex vertex,
			final VisualizationViewer<ILayoutVertex, ILayoutEdge> vViewer,
			JButton okButton, JButton cancelButton) {

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VertexDialog.this.updateTextFieldValues(vertex, vViewer);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VertexDialog.this.dispose();
			}
		});
	}

	/**
	 * @param vertex
	 * @param vViewer
	 */
	private void updateTextFieldValues(final ILayoutVertex vertex,
			final VisualizationViewer<ILayoutVertex, ILayoutEdge> vViewer) {

		vertex.setId(this.txtVertexName.getText().trim());
		vViewer.repaint();
		this.dispose();

	}

	/**
	 * @param vertex
	 * @param vViewer
	 */
	private void setTextFieldValues(ILayoutVertex vertex,
			VisualizationViewer<ILayoutVertex, ILayoutEdge> vViewer) {

		this.txtVertexName.setText(vertex.getId());
		this.txtVertexName.setInputVerifier(new GraphItemIdVerifier(
				this.txtVertexName.getText().trim(), vertex, vViewer));

	}

}
