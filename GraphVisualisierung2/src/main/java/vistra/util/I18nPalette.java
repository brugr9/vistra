package vistra.util;

import java.util.Locale;

/**
 * A palette for i18n.
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
	 */
	/**
	 * 
	 * @param language
	 * @param country
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
	 * A BCP47 language tag representing the locale 'Standardsprache Schweizer
	 * Hochdeutsch'.
	 * <ul>
	 * <li>language: de
	 * <li>country: CH
	 * 
	 * @see Locale
	 */
	public final static String deCH = DE_CH.getLocale().toLanguageTag();
	/**
	 * A BCP47 language tag representing the locale 'Standartsprache Deutsches
	 * Hochdeutsch'.
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
	 * A BCP47 language tag representing the locale 'Standard Language British
	 * English'.
	 * <ul>
	 * <li>language: en
	 * <li>country: GB
	 * 
	 * @see Locale
	 */
	public final static String enGB = EN_GB.getLocale().toLanguageTag();
	/**
	 * A BCP47 language tag representing the locale 'Standard Language American
	 * English'.
	 * <ul>
	 * <li>language: en
	 * <li>country: US
	 * 
	 * @see Locale
	 */
	public final static String enUS = EN_US.getLocale().toLanguageTag();

}
