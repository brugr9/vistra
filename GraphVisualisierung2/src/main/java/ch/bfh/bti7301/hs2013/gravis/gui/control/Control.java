package ch.bfh.bti7301.hs2013.gravis.gui.control;

import java.util.ResourceBundle;

import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.gui.Model;
import ch.bfh.bti7301.hs2013.gravis.gui.control.animation.AnimationStateHandler;
import ch.bfh.bti7301.hs2013.gravis.gui.control.parameter.ParameterStateHandler;
import ch.bfh.bti7301.hs2013.gravis.gui.control.stepbystep.StepByStepStateHandler;

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
	private final Model model;

	/**
	 * Main constructor.
	 * 
	 * @param core
	 *            a core
	 * @param model
	 *            a gravis gui model
	 * @throws Exception
	 */
	public Control(ICore core, Model model) throws Exception {
		super();
		try {
			this.model = model;
			// action listener
			this.model.setI18nListener(new ActionListenerI18n(model));
			this.model.setHelpListener(new ActionListenerHelp(model));
			this.model.setAboutListener(new ActionListenerAbout(model));
			this.model.setQuitListener(new ActionListenerQuit(model));
			// state handler
			this.model.setParameterStateHandler(new ParameterStateHandler(core,
					model));
			this.model.setStepByStepStateHandler(new StepByStepStateHandler(
					model));
			this.model
					.setAnimationStateHandler(new AnimationStateHandler(model));
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
							System.lineSeparator()) + System.lineSeparator()
					+ "----" + System.lineSeparator());
			this.model.setStringBuilder(sb);
			/* update the view */
			this.model.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
