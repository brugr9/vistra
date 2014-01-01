package vistra.gui.view.mouse.popup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class EdgeDialog extends JDialog implements Observer {

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
	 * @param owner
	 * @param viewer
	 * @param model
	 */
	public EdgeDialog(IEdgeLayout edge, JFrame owner,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super(owner, true);
		this.setResizable(false);
		this.setTitle("edgeDialog");

		/* content */
		// name
		this.nameLbl = new JLabel("nameLbl");
		this.name = new JTextField("name");
		this.name.setColumns(10);
		// weigth
		this.weightLbl = new JLabel("weightLbl");
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
		JButton okButton = new JButton("OK");
		okButton.setActionCommand(EventSource.EDIT_GRAPH.toString());
		okButton.addActionListener(model.getParameterStateHandler());
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPane.add(okButton);
		buttonPane.add(cancelButton);
		this.getRootPane().setDefaultButton(okButton);

		this.setTextFieldValues(edge, viewer);
		this.setListeners(edge, viewer, okButton, cancelButton);

		this.setLayout(new BorderLayout());
		this.add(this.content, BorderLayout.CENTER);
		this.add(buttonPane, BorderLayout.SOUTH);

		this.pack();
	}

	/**
	 * @param edge
	 * @param vViewer
	 * @param okButton
	 * @param cancelButton
	 */
	private void setListeners(final IEdgeLayout edge,
			final VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer,
			final JButton okButton, final JButton cancelButton) {

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EdgeDialog.this.updateTextFieldValues(edge, vViewer);
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
	 * @param vViewer
	 */
	protected void updateTextFieldValues(IEdgeLayout edge,
			VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer) {

		edge.setId(this.name.getText().trim());
		edge.setWeight(Convert.toInteger(this.weight.getText()));
		vViewer.repaint();
		this.dispose();
	}

	/**
	 * @param edge
	 * @param vViewer
	 */
	private void setTextFieldValues(IEdgeLayout edge,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {

		this.name.setText(edge.getId());
		this.weight.setText(String.valueOf(edge.getWeight()));

		this.name.setInputVerifier(new ItemIdVerifier(this.name.getText()
				.trim(), edge, viewer));
		this.weight.setInputVerifier(new EdgeWeightVerifier(this.weight
				.getText().trim()));
	}

	/**
	 * Updates the dialog.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IGuiModel m = (IGuiModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == EventSource.I18N) {
				this.setTitle(b.getString("edge.label"));
				this.nameLbl.setText(b.getString("name.label"));
				this.weightLbl.setText(b.getString("weight.label"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

}
