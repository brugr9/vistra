package vistra.gui.control;

import java.util.ResourceBundle;

import vistra.core.ICore;
import vistra.gui.GuiModel;
import vistra.gui.control.animation.AnimationStateHandler;
import vistra.gui.control.parameter.ParameterStateHandler;
import vistra.gui.control.stepbystep.StepByStepStateHandler;

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
			this.model.setStepByStepStateHandler(new StepByStepStateHandler(
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
			/* welcome message */
			ResourceBundle b = this.model.getResourceBundle();
			StringBuilder sb = new StringBuilder();
			sb.append(b.getString("app.label")
					+ System.lineSeparator()
					+ b.getString("about.message").replaceAll("\n",
							System.lineSeparator()) + System.lineSeparator());
			this.model.setStringBuilder(sb);
			/* set state (cascading animation and step-by-step states) */
			this.model.getParameterStateHandler().handleIdle();
			/* update the view */
			this.model.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
