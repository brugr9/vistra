package vistra.app;

import java.io.File;
import java.util.Properties;

import vistra.app.control.ActionListenerAbout;
import vistra.app.control.ActionListenerI18n;
import vistra.app.control.ActionListenerShortcuts;
import vistra.app.control.state.Animation;
import vistra.app.control.state.ParameterStateHandler;
import vistra.app.control.state.StepByStep;
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
	 * Creates an application with a graphic user interface (MVC).
	 * 
	 * @return the view
	 * @throws Exception
	 */
	static IView createApp() throws Exception {
		try {
			Properties properties = createProperties();
			IParameterManager parameterManager = new ParameterManager(
					properties);
			IView view = createGui(parameterManager);
			return view;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates an application with a graphic user interface (MVC) of given type.
	 * 
	 * @param viewType
	 * @return the view
	 * @throws Exception
	 */
	static IView createApp(ViewType viewType) throws Exception {
		try {
			Properties properties = createProperties();
			IParameterManager parameterManager = new ParameterManager(
					properties);
			IView view = createGui(parameterManager, viewType);
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

	/**
	 * Creates a graphic user interface.
	 * 
	 * @param parameterManager
	 *            a parameter manager
	 * @return a view as in MVC
	 * @throws Exception
	 */
	private static IView createGui(IParameterManager parameterManager)
			throws Exception {
		try {
			return createGui(parameterManager, ViewType.DEFAULT);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Creates a MVC based graphic user interface.
	 * 
	 * @param parameterManager
	 *            a parameter manager
	 * @param type
	 *            the view type
	 * @return a view as in MVC
	 * @throws Exception
	 */
	private static IView createGui(IParameterManager parameterManager,
			ViewType type) throws Exception {
		try {
			IModel model = new Model();
			// Action listener
			model.setI18nListener(new ActionListenerI18n(model));
			model.setShortcutsListener(new ActionListenerShortcuts(model));
			model.setAboutListener(new ActionListenerAbout(model));
			// State handler
			model.setAnimationStateHandler(new Animation(model));
			model.setSbsStateHandler(new StepByStep(model));
			model.setParameterStateHandler(new ParameterStateHandler(
					parameterManager, model));

			IView view = ViewFactory.create(model, type);
			return view;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
