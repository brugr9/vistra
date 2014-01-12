package vistra.app.control;

import vistra.app.IModel;
import vistra.app.control.state.Animation;
import vistra.app.control.state.ParameterStateHandler;
import vistra.app.control.state.StepByStep;
import vistra.framework.IParameterManager;

/**
 * A control as in MVC.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class Control implements IControl {

	/**
	 * Main constructor.
	 * 
	 * @param parameterManager
	 *            the parameter manager
	 * @param model
	 *            the model
	 * @throws Exception
	 */
	public Control(IParameterManager parameterManager, IModel model)
			throws Exception {
		super();
		try {
			/* Action listener */
			model.setI18nListener(new ActionListenerI18n(model));
			model.setShortcutsListener(new ActionListenerShortcuts(model));
			model.setAboutListener(new ActionListenerAbout(model));
			/* State handler */
			model.setAnimationStateHandler(new Animation(model));
			model.setSbsStateHandler(new StepByStep(model));
			model.setParameterStateHandler(new ParameterStateHandler(
					parameterManager, model));
		} catch (Exception e) {
			throw e;
		}
	}

}
