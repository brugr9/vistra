package vistra.app.control.state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.Observable;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.framework.ITraversal;
import vistra.framework.step.IStep;
import vistra.framework.util.palette.ConstantPalette;

/**
 * A step-by-step handler: handles the step-by-step iteration over a
 * traversal-object.
 * <p>
 * As a part of the graphic user interface control, this state handler is a
 * focus listener (step length setting) and an action listener (buttons), too.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ParameterStateHandler
 * @see Animation
 */
public final class StepByStep extends Observable implements IStepByStep {

	/**
	 * A field for a step-by-step state.
	 */
	private AbstractSbsState state;
	/**
	 * A field for a model.
	 */
	private Model model;
	/**
	 * A field for a step.
	 */
	private IStep step;
	/**
	 * A field for an off.
	 */
	private boolean off;
	/**
	 * A field for a counter.
	 */
	private int counter;
	/**
	 * A field for a blink timer.
	 */
	private Timer blinkTimer;
	/**
	 * A field for a blink listener.
	 */
	private BlinkListener blinkListener;
	/**
	 * A field for a number of blinks.
	 */
	private static final int NUMBER_OF_BLINKS = 2;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	public StepByStep(IModel model) {
		super();
		this.model = (Model) model;
		// timer
		this.step = null;
		this.off = true;
		this.counter = 0;
		this.blinkListener = new BlinkListener();
		int blinkDelay = (this.model.getDelay() * ConstantPalette.aSecond)
				/ (4 * NUMBER_OF_BLINKS);
		this.blinkTimer = new Timer(blinkDelay, this.blinkListener);
		// state
		try {
			this.state = new SbsOff(this);
			// TODO remove
			// this.handleOff();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Steplength. Does nothing on gaining focus. {@inheritDoc}
	 */
	@Override
	public void focusGained(FocusEvent e) {
		// nothing to do on gaining focus
	}

	/**
	 * Steplength. {@inheritDoc}
	 */
	@Override
	public void focusLost(FocusEvent e) {
		try {
			/* get the value */
			JFormattedTextField textField = (JFormattedTextField) e.getSource();
			int value = Integer.valueOf(textField.getText());
			/* set the value */
			this.model.setSteplength(value);
			/* update the view */
			this.model.notifyObservers();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

	/**
	 * Step-by-Step actions. {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String c = e.getActionCommand();
			if (c.equals(SbsEvent.toBeginning))
				this.handleToBeginning();
			else if (c.equals(SbsEvent.backward))
				this.handleBackward();
			else if (c.equals(SbsEvent.forward))
				this.handleForward();
			else if (c.equals(SbsEvent.toEnd))
				this.handleToEnd();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleIdle() throws Exception {
		try {
			this.state.exit();
			this.state.handleIdle();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void handleToBeginning() throws Exception {
		try {
			this.state.exit();
			this.state.handleBeginning();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleBackward() throws Exception {
		try {
			this.state.exit();
			this.state.handleBackward();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleForward() throws Exception {
		try {
			this.state.exit();
			this.state.handleForward();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleToEnd() throws Exception {
		try {
			this.state.exit();
			this.state.handleEnd();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleOff() throws Exception {
		try {
			this.state.exit();
			this.state.handleOff();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Sets a state.
	 * 
	 * @param state
	 *            the state to set
	 * @throws Exception
	 */
	void setState(AbstractSbsState state) throws Exception {
		try {
			this.state = state;
			this.state.entry();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Property: Sets the step-by-step view elements for state: beginning.
	 */
	void setBeginning() {
		this.model.setSbsEnabled(true);
		this.model.setBackwardEnabled(false);
		this.model.setToBeginningEnabled(false);
		this.model.notifyObservers();
	}

	/**
	 * Property: Sets the step-by-step view elements for state: inter.
	 */
	void setInter() {
		this.model.setSbsEnabled(true);
		this.model.notifyObservers();
	}

	/**
	 * Property: Sets the step-by-step view elements for state: end.
	 */
	void setEnd() {
		this.model.setSbsEnabled(true);
		this.model.setForwardEnabled(false);
		this.model.setToEndEnabled(false);
		this.model.notifyObservers();
	}

	/**
	 * Property: Sets the step-by-step view elements for state: off.
	 */
	void setOff() {
		this.model.setSbsEnabled(false);
		this.model.notifyObservers();
	}

	/**
	 * Doing: Returns -1 if at beginning, 1 if at end, 0 else (inter).
	 * 
	 * @return -1 if at beginning, 1 if at end, 0 else
	 */
	int idle() {
		int progress = this.model.getProgress();
		int max = this.model.getTraversal().size();
		if (progress == 0)
			return -1;
		else if (progress == max)
			return 1;
		return 0;
	}

	/**
	 * Doing: Step-by-Step backward until executing the first step.
	 * 
	 * @throws Exception
	 */
	void toBeginning() throws Exception {
		try {
			while (this.backward())
				;
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Doing: Step-by-Step backward for a step length.
	 * 
	 * @return <code>true</code> if the traversal has a previous step.
	 * @throws Exception
	 */
	boolean backward() throws Exception {
		ITraversal traversal = this.model.getTraversal();
		try {
			IStep step;
			int progress = this.model.getProgress();
			/* here we go ... */
			for (int i = 0; i < this.model.getSteplength(); i++) {
				if (traversal.hasPrevious()) {
					// protocol
					if (!traversal.hasNext())
						this.delete(traversal.getSolution());
					// step
					step = traversal.previous();
					step.undo();
					this.model.setProgress(--progress);
					// protocol
					this.delete(step.getDescription());
					//
					this.model.notifyObservers();
				} else {
					break;
				}
			}
		} catch (Exception ex) {
			throw ex;
		}
		return traversal.hasPrevious();
	}

	/**
	 * Doing: Step-by-Step forward for a step length.
	 * 
	 * @return <code>true</code> if the traversal has a next step.
	 * @throws Exception
	 */
	boolean forward() throws Exception {
		ITraversal traversal = this.model.getTraversal();
		try {
			IStep step;
			int progress = this.model.getProgress();
			StringBuilder protocol = this.model.getProtocol();
			/* here we go ... */
			for (int i = 0; i < this.model.getSteplength(); i++) {
				if (traversal.hasNext()) {
					// step
					step = traversal.next();
					// TODO
					// if (this.model.isBlinkEnabled())
					// this.blink(step);
					step.execute();
					this.model.setProgress(++progress);
					// protocol
					protocol.append(step.getDescription());
					if (!traversal.hasNext())
						protocol.append(traversal.getSolution());
					this.model.notifyObservers();
				} else {
					break;
				}
			}
		} catch (Exception ex) {
			throw ex;
		}
		return traversal.hasNext();
	}

	/**
	 * Doing: Step-by-Step forward until executing the last step.
	 * 
	 * @throws Exception
	 */
	void toEnd() throws Exception {
		try {
			while (this.forward())
				;
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * A helper method: Deletes a string from protocol.
	 * 
	 * @param str
	 *            the string to delete
	 */
	private void delete(String str) {
		StringBuilder protocol = this.model.getProtocol();
		int start, end;
		start = protocol.lastIndexOf(str);
		end = start + str.length();
		protocol.delete(start, end);
	}

	/**
	 * A helper method: Blinks a step.
	 * 
	 * @param step
	 *            the step to blink
	 */
	private void blink(IStep step) {
		this.step = step;
		this.blinkTimer.start();
		this.setChanged();
	}

	/**
	 * A blink listener letting a step blink.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class BlinkListener implements ActionListener {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (off) {
					step.execute();
				} else {
					step.undo();
					counter++;
				}
				off = !off;
				if (counter == NUMBER_OF_BLINKS) {
					blinkTimer.stop();
					setChanged();
					off = true;
					counter = 0;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(
						null,
						ex.toString(),
						StepByStep.this.model.getResourceBundle().getString(
								"app.label"), 1, null);
				ex.printStackTrace();
			}

		}
	}

	/**
	 * Step-by-step events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum SbsEvent {

		//
		STEPLENGTH("steplenth"),
		//
		TO_BEGINNING("toBeginning"),
		//
		BACKWARD("backward"),
		//
		FORWARD("forward"),
		//
		TO_END("toEnd"),

		;

		/**
		 * A field for a value.
		 */
		private String value;

		/**
		 * Main constructor.
		 * 
		 * @param value
		 *            a value
		 */
		SbsEvent(String value) {
			this.value = value;
		}

		/**
		 * Returns the value.
		 * 
		 * @return the value
		 */
		public String getValue() {
			return this.value;
		}

		public static final String steplength = STEPLENGTH.getValue();
		public static final String toBeginning = TO_BEGINNING.getValue();
		public static final String backward = BACKWARD.getValue();
		public static final String forward = FORWARD.getValue();
		public static final String toEnd = TO_END.getValue();

	}
}
