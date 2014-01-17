package vistra.app.control;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import vistra.app.IModel;

/**
 * An i18n action listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ActionListenerI18n extends AbstractActionListener {

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
	public ActionListenerI18n(IModel model) {
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
			/* about message */
			StringBuilder about = new StringBuilder();
			about.append(b.getString("app.label"));
			about.append(System.lineSeparator());
			about.append(System.lineSeparator());
			about.append(b.getString("about.message").replaceAll("\n",
					System.lineSeparator()));
			about.append(System.lineSeparator());
			this.model.setAboutMessage(about.toString());
			/* update the view */
			this.model.notifyObservers(I18nEvent.I18N);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

	/**
	 * I18n events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum I18nEvent {
		I18N;
	}

	/**
	 * A palette for i18n.
	 * 
	 * Use the lower-case constants for getting directly a BCP47 language tag.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum I18nPalette {

		/**
		 * I18n 'deCH'.
		 * <ul>
		 * <li>language: de
		 * <li>country: CH
		 */
		DE_CH("de", "CH"),
		/**
		 * I18n 'deDE'.
		 * <ul>
		 * <li>language: de
		 * <li>country: DE
		 */
		DE_DE("de", "DE"),
		/**
		 * I18n 'frFR'.
		 * <ul>
		 * <li>language: fr
		 * <li>country: FR
		 */
		FR_FR("fr", "FR"),
		/**
		 * I18n 'enGB'.
		 * <ul>
		 * <li>language: en
		 * <li>country: GB
		 */
		EN_GB("en", "GB"),
		/**
		 * I18n 'enUS'.
		 * <ul>
		 * <li>language: en
		 * <li>country: US
		 */
		EN_US("en", "US"),

		;

		/**
		 * A field for a language.
		 */
		private String language;
		/**
		 * A field for a country.
		 */
		private String country;

		/**
		 * Main constructor.
		 * 
		 * @param language
		 *            the language
		 * @param country
		 *            the country
		 */
		I18nPalette(String language, String country) {
			this.language = language;
			this.country = country;
		}

		/**
		 * Returns the string.
		 * 
		 * @return the string
		 */
		@Override
		public String toString() {
			return this.language + this.country;
		}

		/**
		 * Returns the language.
		 * 
		 * @return the language
		 */
		public String getLanguage() {
			return this.language;
		}

		/**
		 * Returns the country.
		 * 
		 * @return the country
		 */
		public String getCountry() {
			return this.country;
		}

		/**
		 * Returns the locale.
		 * 
		 * @return the locale
		 */
		public Locale getLocale() {
			return new Locale(this.language, this.country);
		}

		/**
		 * A BCP47 language tag representing the locale 'Standardsprache
		 * Schweizer Hochdeutsch'.
		 * <ul>
		 * <li>language: de
		 * <li>country: CH
		 * 
		 * @see Locale
		 */
		public final static String deCH = DE_CH.getLocale().toLanguageTag();
		/**
		 * A BCP47 language tag representing the locale 'Standartsprache
		 * Deutsches Hochdeutsch'.
		 * <ul>
		 * <li>language: de
		 * <li>country: DE
		 * 
		 * @see Locale
		 */
		public final static String deDE = DE_DE.getLocale().toLanguageTag();
		/**
		 * A BCP47 language tag representing the locale 'frFR'.
		 * <ul>
		 * <li>language: fr
		 * <li>country: FR
		 * 
		 * @see Locale
		 */
		public final static String frFR = FR_FR.getLocale().toLanguageTag();
		/**
		 * A BCP47 language tag representing the locale 'Standard Language
		 * British English'.
		 * <ul>
		 * <li>language: en
		 * <li>country: GB
		 * 
		 * @see Locale
		 */
		public final static String enGB = EN_GB.getLocale().toLanguageTag();
		/**
		 * A BCP47 language tag representing the locale 'Standard Language
		 * American English'.
		 * <ul>
		 * <li>language: en
		 * <li>country: US
		 * 
		 * @see Locale
		 */
		public final static String enUS = EN_US.getLocale().toLanguageTag();

	}

}
