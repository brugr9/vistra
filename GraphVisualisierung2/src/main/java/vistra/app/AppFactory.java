package vistra.app;

import java.io.File;
import java.util.Properties;

import vistra.app.control.Control;
import vistra.app.control.IControl;
import vistra.app.view.DefaultView;
import vistra.app.view.FullView;
import vistra.app.view.IView;
import vistra.app.view.IView.ViewType;
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
			IModel model = new Model();
			IControl control = new Control(parameterManager, model);
			IView view;
			if (type == ViewType.FULL)
				view = new FullView(model, control);
			else if (type == ViewType.DEFAULT)
				view = new DefaultView(model, control);
			else
				view = new DefaultView(model, control);
			model.getI18nListener().actionPerformed(null);
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
