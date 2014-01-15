package vistra.app.control;

import vistra.app.IModel;
import vistra.app.control.state.Animation;
import vistra.app.control.state.ParameterStateHandler;
import vistra.app.control.state.StepByStep;
import vistra.framework.IParameterManager;

/**
 * A control as in MVC.
 * 
 * @author rbruggmann
 * 
 */
public class Control implements IControl {

	/**
	 * A field for a model as in MVC.
	 */
	private final IModel model;
	/**
	 * A field for an 'i18n' listener.
	 */
	private final ActionListenerI18n i18n;
	/**
	 * A field for a 'shortcuts' listener.
	 */
	private final ActionListenerShortcuts shortcuts;
	/**
	 * A field for an 'about' listener.
	 */
	private final ActionListenerAbout about;
	/**
	 * A field for an animation.
	 */
	private final Animation animation;
	/**
	 * A field for a step-by-step.
	 */
	private final StepByStep stepByStep;
	/**
	 * A field for a parameter state handler.
	 */
	private final ParameterStateHandler parameterStateHandler;

	/**
	 * Main constructor.
	 */
	public Control(IParameterManager parameterManager, IModel model) {
		this.model = model;
		// Action listener
		this.i18n = new ActionListenerI18n(model);
		this.shortcuts = new ActionListenerShortcuts(model);
		this.about = new ActionListenerAbout(model);
		// State handler
		this.animation = new Animation(model);
		this.stepByStep = new StepByStep(model);
		this.parameterStateHandler = new ParameterStateHandler(
				parameterManager, model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init() {
		// Action listener
		this.model.setI18nListener(this.i18n);
		this.model.setShortcutsListener(this.shortcuts);
		this.model.setAboutListener(this.about);
		// State handler
		this.model.setAnimationStateHandler(this.animation);
		this.model.setSbsStateHandler(this.stepByStep);
		this.model.setParameterStateHandler(this.parameterStateHandler);
	}
}
