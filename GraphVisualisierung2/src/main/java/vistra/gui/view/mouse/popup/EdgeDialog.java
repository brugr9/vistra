package vistra.gui.view.mouse.popup;

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

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.control.verifier.EdgeWeightVerifier;
import vistra.gui.control.verifier.ItemIdVerifier;
import vistra.util.Convert;
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
	 * A field for a label: name.
	 */
	private JLabel nameLbl;
	/**
	 * A field for a text field: name.
	 */
	private JTextField name;
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
	 * @param edge
	 *            an edge
	 * @param top
	 *            a top frame
	 * @param viewer
	 *            a visualization viewer
	 * @param model
	 *            a gui model
	 */
	public EdgeDialog(IEdgeLayout edge, JFrame top,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super(top, true);
		this.setResizable(false);

		ResourceBundle b = model.getResourceBundle();
		this.setTitle(b.getString("edge.label"));

		/* content */
		// name
		this.nameLbl = new JLabel(b.getString("name.label"));
		this.name = new JTextField("name");
		this.name.setColumns(10);
		// weigth
		this.weightLbl = new JLabel(b.getString("weight.label"));
		this.weight = new JTextField("weight");
		this.weight.setColumns(10);
		// panel
		this.content = new JPanel();
		this.content.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.content.setLayout(new GridLayout(2, 2, 0, 0));
		this.content.add(this.nameLbl);
		this.content.add(this.name);
		this.content.add(this.weightLbl);
		this.content.add(this.weight);

		/* button */
		JButton ok = new JButton("OK");
		ok.setActionCommand(EventSource.EDIT_GRAPH.toString());
		ok.addActionListener(model.getParameterStateHandler());
		JButton cancel = new JButton("Cancel");
		cancel.setActionCommand("Cancel");

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPane.add(ok);
		buttonPane.add(cancel);
		this.getRootPane().setDefaultButton(ok);

		this.setText(edge, viewer);
		this.setListeners(edge, viewer, ok, cancel);

		this.setLayout(new BorderLayout());
		this.add(this.content, BorderLayout.CENTER);
		this.add(buttonPane, BorderLayout.SOUTH);

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
	protected void updateText(IEdgeLayout edge,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		edge.setId(this.name.getText().trim());
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
		this.name.setText(edge.getId());
		this.weight.setText(String.valueOf(edge.getWeight()));
		this.name.setInputVerifier(new ItemIdVerifier(this.name.getText()
				.trim(), edge, viewer));
		this.weight.setInputVerifier(new EdgeWeightVerifier(this.weight
				.getText().trim()));
	}

}