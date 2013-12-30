package vistra.gui.control;

import static vistra.gui.control.IControl.EventSource.I18N;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import vistra.gui.GuiModel;
import vistra.gui.IGuiModel;

/**
 * An i18n listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ActionListenerI18n extends AbstractActionListener {

	/**
	 * A field for an i18n base name.
	 */
	private final String i18nBaseName;

	/**
	 * A field for a list of shortcuts.
	 */
	private final String shortCuts = "<html>"
			+ "<h3>All Modes:</h3>"
			+ "<ul>"
			+ "<li><b>Mousewheel</b>: Scale the view"
			+ "<li><b>Right-click</b> an empty area: Switch mode"
			+ "</ul>"
			+ "<h3>Edit Mode:</h3>"
			+ "<ul>"
			+ "<li><b>Left-click</b> an empty area: Create a vertex"
			+ "<li><b>Left-click + drag</b> from a first vertex to another vertex: Create an edge"
			+ "<li><b>Left-Double-click</b> on a vertex or edge: Edit the label"
			+ "<li><b>Right-click</b> on a vertex: Edit-vertex popup"
			+ "<li><b>Right-click</b> on an edge: Edit-edge popup"
			+ "</ul>"
			+ "<h3>Picking Mode:</h3>"
			+ "<ul>"
			+ "<li><b>Left-click + drag</b> elsewhere: Select vertices in a region"
			+ "<li><b>Left-click</b> on a vertex: Select the vertex"
			+ "<li><b>Left-click + drag</b> on a vertex: Move all selected vertices"
			+ "<li><b>Left-click</b> elsewhere: Unselect all vertices"
			+ "<li><b>CTRL + Left-click</b> on a vertex: Select the vertex as center and shift view"
			+ "<li><b>Shift + Left-click</b> on a vertex: Add/remove vertex selection"
			+ "<li><b>Shift + Left-click + drag</b>: Add selection of vertices in a new region"
			+ "</ul>" + "</html>";

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	ActionListenerI18n(IGuiModel model) {
		super(model);
		this.i18nBaseName = (this.getClass().getPackage().getName() + ".MessagesBundle")
				.replace(".", File.separator);
		this.actionPerformed(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			/* create locale */
			String language, country;
			if (e == null) {
				language = System.getProperty("user.language");
				country = System.getProperty("user.country");
			} else {
				// first and second character out of e.g. <EN_US>
				language = e.getActionCommand().substring(0, 2).toLowerCase();
				// fourth and fifth character out of e.g. <EN_US>
				country = e.getActionCommand().substring(3, 5);
			}
			Locale locale = new Locale(language, country);

			/* component */
			JComponent.setDefaultLocale(locale);
			/* resource bundle */
			ResourceBundle b = ResourceBundle.getBundle(this.i18nBaseName,
					locale);
			this.model.setResourceBundle(b);
			/* help message */
			// TODO i18n
			// StringBuilder help = new StringBuilder();
			// help.append(b.getString("help.message"));
			// this.model.setHelp(help.toString());
			this.model.setHelp(this.shortCuts);
			/* about message */
			StringBuilder about = new StringBuilder();
			about.append(b.getString("app.label"));
			about.append(System.lineSeparator());
			about.append(System.lineSeparator());
			about.append(b.getString("about.message").replaceAll("\n",
					System.lineSeparator()));
			about.append(System.lineSeparator());
			this.model.setAbout(about.toString());
			/* protocol */
			this.model.setProtocol(about);
			/* update the view */
			((GuiModel) this.model).notifyObservers(I18N);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}
}
