package ch.bfh.bti7301.hs2013.gravis;

import java.io.InputStream;
import java.util.Properties;

import ch.bfh.bti7301.hs2013.gravis.core.CoreFactory;
import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory.ViewType;
import ch.bfh.bti7301.hs2013.gravis.gui.IView;

/**
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class ApplicationFactory {

	/**
	 * The default name of the property file name relative to the CLASSPATH.
	 */
	public final static String APPLICATION_PROPERTIES = "META-INF/Application.properties";

	/**
	 * A main (no-)constructor.
	 */
	private ApplicationFactory() {
	}

	/**
	 * Creates a default Application with core and GUI.
	 * 
	 * @return a default Application with core and GUI
	 */
	protected static IView createApplication(int width, int height)
			throws Exception {
		try {
			Properties properties = loadProperties();
			ICore core = CoreFactory.createCore(properties);
			IView view = GuiFactory.createGui(core, width, height);
			return view;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates an Application with core and a GUI of given type.
	 * 
	 * @return an Application with core and a GUI of given type
	 */
	protected static IView createApplication(int width, int height,
			ViewType viewType) throws Exception {
		try {
			Properties properties = loadProperties();
			ICore core = CoreFactory.createCore(properties);
			IView view = GuiFactory.createGui(core, width, height, viewType);
			return view;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates properties.
	 * 
	 * @return the properties
	 * @throws Exception
	 */
	private static Properties loadProperties() throws Exception {

		Properties properties = null;
		properties = new Properties();
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		InputStream is = classLoader
				.getResourceAsStream(APPLICATION_PROPERTIES);
		try {
			properties.load(is);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Cannot load properties file for core: "
							+ APPLICATION_PROPERTIES + ". ");
		}
		return properties;

	}
}
