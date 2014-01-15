package vistra.app;

import java.io.File;
import java.util.Properties;

import vistra.app.view.IView;
import vistra.app.view.ViewFactory;
import vistra.app.view.ViewFactory.ViewType;
import vistra.framework.IParameterManager;
import vistra.framework.ParameterManager;

/**
 * An application factory, creates MVC based graphic user interfaces.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class AppFactory {

	/**
	 * A main (no-)constructor.
	 */
	private AppFactory() {
	}

	/**
	 * Creates an application with a graphic user interface (MVC) of given type.
	 * 
	 * @param type
	 *            the view type
	 * @return the view
	 * @throws Exception
	 */
	static IView createApp(ViewType type) throws Exception {
		try {
			Properties properties = createProperties();
			IParameterManager parameterManager = new ParameterManager(
					properties);
			IModel model = ModelFactory.create(parameterManager);
			return ViewFactory.create(model, type);
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

		String propertiesName = AppFactory.class.getPackage().getName()
				.replace(".", File.separator)
				+ File.separator + "Application.properties";

		try {

			Properties properties = null;
			properties = new Properties();
			properties.load(AppFactory.class.getClassLoader()
					.getResourceAsStream(propertiesName));
			return properties;

		} catch (SecurityException e) {
			throw new Exception(AppFactory.class.getName(), e);
		} catch (Exception e) {
			throw new IllegalArgumentException(AppFactory.class.getName()
					+ ": \nCannot load properties file " + propertiesName
					+ "\n", e);
		}

	}

}
