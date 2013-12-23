package vistra.gui.control;

import static vistra.gui.control.IControl.EventSource.I18N;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import vistra.gui.IGuiModel;
import vistra.gui.GuiModel;

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

			/* set the locale to different components */
			JComponent.setDefaultLocale(locale);
			ResourceBundle b = ResourceBundle.getBundle(this.i18nBaseName,
					locale);
			this.model.setResourceBundle(b);

			/* update the view */
			((GuiModel) this.model).notifyObservers(I18N);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}
}
