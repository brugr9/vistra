package vistra.app.view.popup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vistra.app.IModel;
import vistra.app.control.state.ParameterStateHandler.ParameterEvent;
import vistra.app.control.verifier.EdgeWeightVerifier;
import vistra.app.control.verifier.ItemIdVerifier;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.util.Convert;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An edge property dialog.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeDialog extends JDialog {

	private static final long serialVersionUID = -6646549637907283799L;

	/**
	 * A field for a content panel.
	 */
	private final JPanel content;
	/**
	 * A field for a label: weight.
	 */
	private JLabel weightLbl;
	/**
	 * A field for a text field: weight.
	 */
	private JTextField weight;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            a top frame
	 * @param viewer
	 *            a visualization viewer
	 * @param model
	 *            a gui model
	 * @param edge
	 *            an edge
	 */
	public EdgeDialog(JFrame top,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IModel model, IEdgeLayout edge) {
		super(top, true);
		this.setResizable(false);

		ResourceBundle b = model.getResourceBundle();
		this.setTitle(b.getString("edge.label"));

		/* content */
		// weigth
		this.weightLbl = new JLabel(b.getString("weight.label"));
		this.weight = new JTextField("weight");
		this.weight.setColumns(10);
		// panel
		this.content = new JPanel();
		this.content.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.content.setLayout(new GridLayout(2, 2, 0, 0));
		this.content.add(this.weightLbl);
		this.content.add(this.weight);
		this.setText(edge, viewer);

		/* button panel */
		// button
		JButton ok = new JButton("OK");
		ok.setActionCommand(ParameterEvent.edit);
		ok.addActionListener(model.getParameterStateHandler());
		JButton cancel = new JButton("Cancel");
		cancel.setActionCommand("Cancel");
		this.setListeners(edge, viewer, ok, cancel);
		// panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		this.getRootPane().setDefaultButton(ok);

		/* this */
		this.setLayout(new BorderLayout());
		this.add(this.content, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.pack();
	}

	/**
	 * @param edge
	 * @param viewer
	 * @param okButton
	 * @param cancelButton
	 */
	private void setListeners(final IEdgeLayout edge,
			final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			final JButton okButton, final JButton cancelButton) {

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EdgeDialog.this.updateText(edge, viewer);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EdgeDialog.this.dispose();
			}
		});
	}

	/**
	 * @param edge
	 * @param viewer
	 */
	private void updateText(final IEdgeLayout edge,
			final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		edge.setWeight(Convert.toInteger(this.weight.getText()));
		viewer.repaint();
		this.dispose();
	}

	/**
	 * @param edge
	 * @param viewer
	 */
	private void setText(IEdgeLayout edge,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		this.weight.setText(String.valueOf(edge.getWeight()));
		this.weight.setInputVerifier(new EdgeWeightVerifier(this.weight
				.getText().trim()));
	}

}
