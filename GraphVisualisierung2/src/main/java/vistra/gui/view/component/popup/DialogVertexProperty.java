package vistra.gui.view.component.popup;

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

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.gui.util.GraphItemIdVerifier;
import vistra.gui.util.VertexSizeVerifier;
import vistra.util.transformer.ValueTransformer;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A vertex property dialog.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DialogVertexProperty extends JDialog {

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
	 * A field for a width value text field.
	 */
	private JTextField txtWidth;

	/**
	 * A field for a height value text field.
	 */
	private JTextField txtHeight;

	/**
	 * Create the dialog.
	 * 
	 * @param vertex
	 * @param owner
	 * @param vViewer
	 */
	public DialogVertexProperty(final IVertex vertex, final JFrame owner,
			final VisualizationViewer<IVertex, IEdge> vViewer) {
		super(owner, true);
		this.setResizable(false);
		// TODO remove string literals
		this.setTitle("Knoten " + vertex.getId() + " bearbeiten...");

		this.contentPanel = new JPanel();
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPanel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblVertexName = new JLabel("Knoten-Name:              ");
		this.contentPanel.add(lblVertexName);
		this.txtVertexName = new JTextField();
		this.contentPanel.add(txtVertexName);

		JLabel lblWidth = new JLabel("Breite:");
		this.contentPanel.add(lblWidth);
		this.txtWidth = new JTextField();
		this.contentPanel.add(txtWidth);

		JLabel lblHeight = new JLabel("Höhe:");
		this.contentPanel.add(lblHeight);
		this.txtHeight = new JTextField();
		this.contentPanel.add(txtHeight);

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
	private void setListeners(final IVertex vertex,
			final VisualizationViewer<IVertex, IEdge> vViewer,
			JButton okButton, JButton cancelButton) {

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogVertexProperty.this
						.updateTextFieldValues(vertex, vViewer);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogVertexProperty.this.dispose();
			}
		});
	}

	/**
	 * @param vertex
	 * @param vViewer
	 */
	private void updateTextFieldValues(final IVertex vertex,
			final VisualizationViewer<IVertex, IEdge> vViewer) {

		vertex.setId(this.txtVertexName.getText().trim());
		vertex.setWidth(ValueTransformer.transformDouble(this.txtWidth
				.getText()));
		vertex.setHeight(ValueTransformer.transformDouble(this.txtHeight
				.getText()));
		vViewer.repaint();
		this.dispose();
	}

	/**
	 * @param vertex
	 * @param vViewer
	 */
	private void setTextFieldValues(IVertex vertex,
			VisualizationViewer<IVertex, IEdge> vViewer) {

		this.txtVertexName.setText(vertex.getId());
		this.txtWidth.setText(String.valueOf(new Double(vertex.getWidth())
				.intValue()));
		this.txtHeight.setText(String.valueOf(new Double(vertex.getHeight())
				.intValue()));

		this.txtVertexName.setInputVerifier(new GraphItemIdVerifier(
				this.txtVertexName.getText().trim(), vertex, vViewer));
		this.txtWidth.setInputVerifier(new VertexSizeVerifier(this.txtWidth
				.getText().trim()));
		this.txtHeight.setInputVerifier(new VertexSizeVerifier(this.txtHeight
				.getText().trim()));
	}

}
