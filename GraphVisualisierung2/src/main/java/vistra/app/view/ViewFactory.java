package vistra.app.view;

import vistra.app.IModel;

/**
 * A view factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ViewFactory {

	/**
	 * A main (no-)constructor.
	 */
	private ViewFactory() {
	}

	/**
	 * Creates a graphic user interface.
	 * 
	 * @param model
	 *            the model
	 * @param type
	 *            the view type
	 * @return the view
	 * @throws Exception
	 */
	public static IView create(IModel model, ViewType type) throws Exception {
		try {
			IView view;
			if (type == ViewType.FULL)
				view = new FullView(model);
			else if (type == ViewType.DEFAULT)
				view = new DefaultView(model);
			else
				view = new DefaultView(model);
			//
			model.getI18nListener().actionPerformed(null);
			return view;
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * View types.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ViewType {
		DEFAULT, FULL;
	}

}
