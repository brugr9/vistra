package vistra.app;

import java.awt.event.ActionListener;

import vistra.app.control.ActionListenerAbout;
import vistra.app.control.ActionListenerI18n;
import vistra.app.control.ActionListenerShortcuts;
import vistra.app.control.state.Animation;
import vistra.app.control.state.ParameterStateHandler;
import vistra.app.control.state.StepByStep;
import vistra.framework.IParameterManager;

/**
 * An application factory, creates MVC based graphic user interfaces.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class ModelFactory {

	/**
	 * A main (no-)constructor.
	 */
	private ModelFactory() {
	}

	/**
	 * Creates a model.
	 * 
	 * @param parameterManager
	 *            a parameter manager
	 * @return the model
	 * @throws Exception
	 */
	static IModel create(IParameterManager parameterManager) throws Exception {
		try {
			IModel model = new Model();
			// Action listener
			ActionListener i18n = new ActionListenerI18n(model);
			ActionListener shortcuts = new ActionListenerShortcuts(model);
			ActionListener about = new ActionListenerAbout(model);
			model.setI18nListener(i18n);
			model.setShortcutsListener(shortcuts);
			model.setAboutListener(about);
			// State handler
			Animation animation = new Animation(model);
			StepByStep stepByStep = new StepByStep(model);
			ParameterStateHandler parameterStateHandler = new ParameterStateHandler(
					parameterManager, model);
			model.setAnimationStateHandler(animation);
			model.setSbsStateHandler(stepByStep);
			model.setParameterStateHandler(parameterStateHandler);

			return model;
		} catch (Exception e) {
			throw e;
		}
	}

}
