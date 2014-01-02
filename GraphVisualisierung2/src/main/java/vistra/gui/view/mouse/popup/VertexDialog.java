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
import vistra.gui.control.verifier.ItemIdVerifier;
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
	 *            a vertex
	 * @param top
	 *            a top frame
	 * @param viewer
	 *            a visualization viewer
	 * @param model
	 *            a gui model
	 */
	public VertexDialog(IVertexLayout vertex, JFrame top,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super(top, true);
		this.setResizable(false);

		ResourceBundle b = model.getResourceBundle();
		this.setTitle(b.getString("vertex.label"));

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

		this.setText(vertex, viewer);
		this.setListeners(vertex, viewer, ok, cancel);

		this.setLayout(new BorderLayout());
		this.add(this.content, BorderLayout.CENTER);
		this.add(buttonPane, BorderLayout.SOUTH);

		this.pack();
	}

	/**
	 * @param vertex
	 * @param viewer
	 * @param okButton
	 * @param cancelButton
	 */
	private void setListeners(final IVertexLayout vertex,
			final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			JButton okButton, JButton cancelButton) {

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VertexDialog.this.updateText(vertex, viewer);
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
	 * @param viewer
	 */
	private void updateText(final IVertexLayout vertex,
			final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		vertex.setId(this.name.getText().trim());
		viewer.repaint();
		this.dispose();

	}

	/**
	 * @param vertex
	 * @param viewer
	 */
	private void setText(IVertexLayout vertex,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		this.name.setText(vertex.getId());
		this.name.setInputVerifier(new ItemIdVerifier(this.name.getText()
				.trim(), vertex, viewer));
	}

}
