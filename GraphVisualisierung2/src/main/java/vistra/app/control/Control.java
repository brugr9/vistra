package vistra.app.control;

import vistra.app.IModel;
import vistra.app.control.state.AnimationStateHandler;
import vistra.app.control.state.ParameterStateHandler;
import vistra.app.control.state.SbsStateHandler;
import vistra.framework.ICore;

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
	 * @param core
	 *            the core
	 * @param model
	 *            the model
	 * @throws Exception
	 */
	public Control(ICore core, IModel model) throws Exception {
		super();
		try {
			/* Action listener */
			model.setI18nListener(new ActionListenerI18n(model));
			model.setShortcutsListener(new ActionListenerShortcuts(model));
			model.setAboutListener(new ActionListenerAbout(model));
			/* State handler */
			model.setSbsStateHandler(new SbsStateHandler(model));
			model.setAnimationStateHandler(new AnimationStateHandler(model));
			model.setParameterStateHandler(new ParameterStateHandler(core,
					model));
			/* Parameter */
			model.setGraphSaved(true);
			model.getParameterStateHandler().handleNewGraphUndirected();
		} catch (Exception e) {
			throw e;
		}
	}

}
