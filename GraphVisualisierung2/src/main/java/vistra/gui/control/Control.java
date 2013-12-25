package vistra.gui.control;

import vistra.core.ICore;
import vistra.gui.GuiModel;
import vistra.gui.control.state.animation.AnimationStateHandler;
import vistra.gui.control.state.parameter.ParameterStateHandler;
import vistra.gui.control.state.stepbystep.SbsStateHandler;

/**
 * A control as in MVC.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class Control implements IControl {

	/**
	 * A field for a model as in MVC.
	 */
	private final GuiModel model;

	/**
	 * Main constructor.
	 * 
	 * @param core
	 *            the core
	 * @param model
	 *            the model
	 * @throws Exception
	 */
	public Control(ICore core, GuiModel model) throws Exception {
		super();
		try {
			this.model = model;
			// Algorithms
			this.model.setAlgorithms(core.getAlgorithms(this.model.getGraph()
					.getEdgeType()));
			// Action listener
			this.model.setI18nListener(new ActionListenerI18n(model));
			this.model.setHelpListener(new ActionListenerHelp(model));
			this.model.setAboutListener(new ActionListenerAbout(model));
			this.model.setQuitListener(new ActionListenerQuit(model));
			// State handler
			this.model.setStepByStepStateHandler(new SbsStateHandler(
					model));
			this.model
					.setAnimationStateHandler(new AnimationStateHandler(model));
			this.model.setParameterStateHandler(new ParameterStateHandler(core,
					model));
			// Graph event listener
			this.model.getGraph().addGraphEventListener(
					this.model.getParameterStateHandler());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init() throws Exception {
		try {
			/* i18n */
			this.model.getI18nListener().actionPerformed(null);
			/* set state (cascading animation and step-by-step states) */
			this.model.getParameterStateHandler().handleIdle();
			/* update the view */
			this.model.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
