package vistra.gui.view.component.viewer.popup;

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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.view.component.viewer.popup.verifier.ItemIdVerifier;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A vertex property dialog.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexDialog extends JDialog implements Observer {

	private static final long serialVersionUID = -6919635847499019908L;

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
	 * Main constructor.
	 * 
	 * @param vertex
	 * @param owner
	 * @param viewer
	 * @param model
	 */
	public VertexDialog(IVertexLayout vertex, JFrame owner,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super(owner, true);
		this.setResizable(false);

		ResourceBundle b = model.getResourceBundle();

		/* content */
		// name
		this.nameLbl = new JLabel(b.getString("name.label"));
		this.name = new JTextField("name");
		this.name.setColumns(10);
		// panel
		this.content = new JPanel();
		this.content.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.content.setLayout(new GridLayout(1, 2, 0, 0));
		this.content.add(this.nameLbl);
		this.content.add(this.name);

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

		this.setTextFieldValues(vertex, viewer);
		this.setListeners(vertex, viewer, okButton, cancelButton);

		this.setTitle(b.getString("edit.vertex.label"));
		this.setLayout(new BorderLayout());
		this.add(this.content, BorderLayout.CENTER);
		this.add(buttonPane, BorderLayout.SOUTH);

		this.pack();
	}

	/**
	 * @param vertex
	 * @param vViewer
	 * @param okButton
	 * @param cancelButton
	 */
	private void setListeners(final IVertexLayout vertex,
			final VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer,
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
	private void updateTextFieldValues(final IVertexLayout vertex,
			final VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer) {

		vertex.setId(this.name.getText().trim());
		vViewer.repaint();
		this.dispose();

	}

	/**
	 * @param vertex
	 * @param vViewer
	 */
	private void setTextFieldValues(IVertexLayout vertex,
			VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer) {

		this.name.setText(vertex.getId());
		this.name.setInputVerifier(new ItemIdVerifier(this.name.getText()
				.trim(), vertex, vViewer));

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
