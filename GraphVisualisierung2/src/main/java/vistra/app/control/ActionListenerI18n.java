package vistra.app.control;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import vistra.app.IModel;
import vistra.app.control.IControl.ActionCommandGeneral;

/**
 * An i18n action listener.
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
	 * A field for a list of shortcuts. TODO i18n
	 */
	private final String shortcuts = "<html>"
			+ "<h4>All Modes:</h4>"
			+ "<small>LC = left-click; RC = right-click</small>"
			+ "<ul>"
			+ "<li>Mousewheel: Scale the view"
			+ "<li>RC an empty area: Switch-mode pop-up menu"
			+ "</ul>"
			+ "<h4>Editing Mode:</h4>"
			+ "<ul>"
			+ "<li>LC an empty area: Create a vertex"
			+ "<li>LC + drag from a first to another vertex: Create an edge"
			+ "<li>RC on a vertex: Edit-vertex pop-up menu"
			+ "<li>RC on an edge: Edit-edge pop-up menu"
			+ "</ul>"
			+ "<h4>Picking Mode:</h4>"
			+ "<ul>"
			+ "<li>LC on a vertex: Select the vertex"
			+ "<li>LC + drag elsewhere: Select vertices in a region"
			+ "<li>LC + drag on a vertex: Move all selected vertices"
			+ "<li>LC elsewhere: Unselect all vertices"
			+ "<li>CTRL + LC on a vertex: Select the vertex as center and shift view"
			+ "<li>Shift + LC on a vertex: Add/remove vertex selection"
			+ "<li>Shift + LC + drag: Add selection of vertices in a new region"
			+ "</ul>" + "</html>";

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	ActionListenerI18n(IModel model) {
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
			Locale locale = null;
			if (e == null) {
				String language = System.getProperty("user.language");
				String country = System.getProperty("user.country");
				locale = new Locale(language, country);
			} else
				locale = Locale.forLanguageTag(e.getActionCommand());

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
			this.model.setShortcutsMessage(this.shortcuts);
			/* about message */
			StringBuilder about = new StringBuilder();
			about.append(b.getString("app.label"));
			about.append(System.lineSeparator());
			about.append(System.lineSeparator());
			about.append(b.getString("about.message").replaceAll("\n",
					System.lineSeparator()));
			about.append(System.lineSeparator());
			this.model.setAboutMessage(about.toString());
			/* protocol */
			this.model.setProtocol(about);
			/* update the view */
			// TODO
			this.model.notifyObservers(ActionCommandGeneral.i18n);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}
}
