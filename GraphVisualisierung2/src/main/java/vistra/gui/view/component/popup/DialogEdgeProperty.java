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
import vistra.gui.util.EdgeWeightVerifier;
import vistra.gui.util.GraphItemIdVerifier;
import vistra.util.transformer.ValueTransformer;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An edge property dialog.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DialogEdgeProperty extends JDialog {

	private static final long serialVersionUID = -6646549637907283799L;

	/**
	 * A field for a content panel.
	 */
	private final JPanel contentPanel;

	/**
	 * A field for an edge name text field.
	 */
	private JTextField txtEdgeName;

	/**
	 * A field for an edge weight text field.
	 */
	private JTextField txtEdgeWeight;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 * @param owner
	 * @param edge
	 */
	public DialogEdgeProperty(IEdge edge, JFrame owner,
			VisualizationViewer<IVertex, IEdge> viewer) {
		super(owner, true);
		this.contentPanel = new JPanel();

		// TODO remove string literals
		this.setTitle("Kante " + edge.getId() + " bearbeiten...");

		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblEdgeName = new JLabel("Kanten-Name:              ");
		this.contentPanel.add(lblEdgeName);

		this.txtEdgeName = new JTextField();
		this.contentPanel.add(this.txtEdgeName);
		this.txtEdgeName.setColumns(10);

		JLabel lblEdgeWeight = new JLabel("Gewicht:");
		this.contentPanel.add(lblEdgeWeight);

		this.txtEdgeWeight = new JTextField();
		this.contentPanel.add(this.txtEdgeWeight);
		this.txtEdgeWeight.setColumns(10);

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

		this.setTextFieldValues(edge, viewer);
		this.setListeners(edge, viewer, okButton, cancelButton);

		this.pack();
	}

	/**
	 * @param edge
	 * @param vViewer
	 * @param okButton
	 * @param cancelButton
	 */
	private void setListeners(final IEdge edge,
			final VisualizationViewer<IVertex, IEdge> vViewer,
			final JButton okButton, final JButton cancelButton) {

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogEdgeProperty.this.updateTextFieldValues(edge, vViewer);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogEdgeProperty.this.dispose();
			}
		});
	}

	/**
	 * @param edge
	 * @param vViewer
	 */
	protected void updateTextFieldValues(IEdge edge,
			VisualizationViewer<IVertex, IEdge> vViewer) {

		edge.setId(this.txtEdgeName.getText().trim());
		edge.setWeight(ValueTransformer.round2Decimals(ValueTransformer
				.transformDouble(this.txtEdgeWeight.getText())));
		vViewer.repaint();
		this.dispose();
	}

	/**
	 * @param edge
	 * @param vViewer
	 */
	private void setTextFieldValues(IEdge edge,
			VisualizationViewer<IVertex, IEdge> vViewer) {

		this.txtEdgeName.setText(edge.getId());
		this.txtEdgeWeight.setText(String.valueOf(edge.getWeight()));

		this.txtEdgeName.setInputVerifier(new GraphItemIdVerifier(
				this.txtEdgeName.getText().trim(), edge, vViewer));
		this.txtEdgeWeight.setInputVerifier(new EdgeWeightVerifier(
				this.txtEdgeWeight.getText().trim()));
	}

}
