package vistra.app.control;

import vistra.app.IModel;
import vistra.app.Model;
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
		this.model.setI18nListener(this.i18n);
		this.model.setShortcutsListener(this.shortcuts);
		this.model.setAboutListener(this.about);
		// State handler
		this.animation = new Animation(model);
		this.stepByStep = new StepByStep(model);
		this.parameterStateHandler = new ParameterStateHandler(
				parameterManager, model);
		this.model.setAnimation(this.animation);
		this.model.setStepByStep(this.stepByStep);
		this.model.setParameterStateHandler(this.parameterStateHandler);
		try {
			// graph mustn't be null for creating the view
			this.parameterStateHandler.handleNewGraphUndirected();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception
	 */
	@Override
	public void init() throws Exception {
		try {
			this.animation.handleOff();
			this.i18n.actionPerformed(null);
			this.model.setProtocol(this.model.getProtocol().append(
					this.model.getAboutMessage()));
			((Model) this.model).notifyObservers();
		} catch (Exception e) {
			throw e;
		}

	}
}
