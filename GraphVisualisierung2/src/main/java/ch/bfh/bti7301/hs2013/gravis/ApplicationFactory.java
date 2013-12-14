package ch.bfh.bti7301.hs2013.gravis;

import java.io.File;
import java.util.Properties;

import ch.bfh.bti7301.hs2013.gravis.core.Core;
import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory.ViewType;
import ch.bfh.bti7301.hs2013.gravis.gui.view.IView;

/**
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class ApplicationFactory {

	/**
	 * A main (no-)constructor.
	 */
	private ApplicationFactory() {
	}

	/**
	 * Creates an application with core and a default gui (MVC) of frame size as
	 * given by values.
	 * 
	 * @return the view
	 * @throws Exception
	 */
	protected static IView createApplication() throws Exception {
		try {
			Properties properties = createProperties();
			ICore core = new Core(properties);
			IView view = GuiFactory.createGui(core);
			return view;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates an application with core and a gui (MVC) of given type and of
	 * frame size as given by values.
	 * 
	 * @param viewType
	 * @return the view
	 * @throws Exception
	 */
	protected static IView createApplication(ViewType viewType)
			throws Exception {
		try {
			Properties properties = createProperties();
			ICore core = new Core(properties);
			IView view = GuiFactory.createGui(core, viewType);
			return view;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates properties for this application.
	 * 
	 * @throws Exception
	 */
	private static Properties createProperties() throws Exception {

		String propertiesName = ApplicationFactory.class.getPackage().getName()
				.replace(".", File.separator)
				+ File.separator + "Application.properties";

		try {

			Properties properties = null;
			properties = new Properties();
			properties.load(ApplicationFactory.class.getClassLoader()
					.getResourceAsStream(propertiesName));
			return properties;

		} catch (SecurityException e) {
			throw new Exception(ApplicationFactory.class.getName(), e);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					ApplicationFactory.class.getName()
							+ ": \nCannot load properties file "
							+ propertiesName + "\n", e);
		}

	}

}
