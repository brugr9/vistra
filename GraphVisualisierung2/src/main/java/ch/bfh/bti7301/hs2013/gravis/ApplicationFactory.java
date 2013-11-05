package ch.bfh.bti7301.hs2013.gravis;

import ch.bfh.bti7301.hs2013.gravis.core.CoreFactory;
import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory.ViewType;
import ch.bfh.bti7301.hs2013.gravis.gui.IGuiView;

/**
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ApplicationFactory {
	/**
	 * A main (no-)constructor.
	 */
	private ApplicationFactory() {
	}

	/**
	 * Creates a default Application with core and GUI.
	 * 
	 * @return a default Application with core and GUI
	 */
	protected static IGuiView createApplication(int width, int height)
			throws Exception {
		try {
			ICore core = CoreFactory.createCore();
			IGuiView guiView = GuiFactory.createGui(core, width, height);
			return guiView;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates an Application with core and a GUI of given type.
	 * 
	 * @return an Application with core and a GUI of given type
	 */
	protected static IGuiView createApplication(int width, int height,
			ViewType viewType) throws Exception {
		try {
			ICore core = CoreFactory.createCore();
			IGuiView guiView = GuiFactory.createGui(core, width, height,
					viewType);
			return guiView;
		} catch (Exception e) {
			throw e;
		}
	}
}
