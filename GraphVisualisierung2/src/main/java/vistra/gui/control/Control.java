package vistra.gui.control;

import vistra.core.ICore;
import vistra.gui.IGuiModel;
import vistra.gui.control.state.AnimationStateHandler;
import vistra.gui.control.state.ParameterStateHandler;
import vistra.gui.control.state.SbsStateHandler;

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
	public Control(ICore core, IGuiModel model) throws Exception {
		super();
		try {
			/* Action listener */
			model.setI18nListener(new ActionListenerI18n(model));
			model.setModeListener(new ActionListenerMode(model));
			model.setShortcutsListener(new ActionListenerShortcuts(model));
			model.setAboutListener(new ActionListenerAbout(model));
			model.setQuitListener(new ActionListenerQuit(model));
			/* State handler */
			model.setStepByStepStateHandler(new SbsStateHandler(model));
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
