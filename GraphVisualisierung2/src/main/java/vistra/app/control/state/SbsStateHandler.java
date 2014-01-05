package vistra.app.control.state;

import static vistra.app.control.IControl.A_SECOND;
import static vistra.app.control.IControl.ControlEvent.BACKWARD;
import static vistra.app.control.IControl.ControlEvent.FORWARD;
import static vistra.app.control.IControl.ControlEvent.STEPLENGTH;
import static vistra.app.control.IControl.ControlEvent.TO_BEGINNING;
import static vistra.app.control.IControl.ControlEvent.TO_END;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.Observable;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import vistra.app.GuiModel;
import vistra.app.IGuiModel;
import vistra.app.control.IControl.ControlEvent;
import vistra.framework.traversal.ITraversal;
import vistra.framework.traversal.step.IStep;

/**
 * A step-by-step state handler. A step-by-step state machine handles the
 * step-by-step iteration over a traversal-object.
 * <p>
 * As a part of the graphic user interface control, this state handler is a
 * focus listener (step length setting) and an action listener (buttons), too.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ParameterStateHandler
 * @see AnimationStateHandler
 */
public final class SbsStateHandler extends Observable implements
		ISbsStateHandler {

	/**
	 * A field for a step-by-step state.
	 */
	private AbstractSbsState state;

	/**
	 * A field for a model.
	 */
	private GuiModel model;

	/**
	 * A field for a timer.
	 */
	private Timer timer;

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
	public SbsStateHandler(IGuiModel model) {
		super();
		this.model = (GuiModel) model;
		this.blinkListener = new BlinkListener(NUMBER_OF_BLINKS);
		int timeDivider = 2; // divides the delay into two parts: blink and show
		int numberOfSteps = 2; // number of steps per blink: backward, forward
		int blinkDelay = this.model.getDelay()
				/ (timeDivider * numberOfSteps * NUMBER_OF_BLINKS) * A_SECOND;
		this.timer = new Timer(blinkDelay, this.blinkListener);
		try {
			this.setState(new SbsStateOff(this));
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
			this.model.notifyObservers(STEPLENGTH);
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
			if (c.equals(TO_BEGINNING.toString()))
				this.handleToBeginning();
			else if (c.equals(BACKWARD.toString()))
				this.handleBackward();
			else if (c.equals(FORWARD.toString()))
				this.handleForward();
			else if (c.equals(TO_END.toString()))
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
	 * State view setter: Sets the step-by-step view elements for state:
	 * beginning.
	 */
	void setViewBeginning() {
		this.model.setSbsEnabled(true);
		this.model.setBackwardEnabled(false);
		this.model.setToBeginningEnabled(false);
		this.model.notifyObservers(ControlEvent.STEP_BY_STEP);
	}

	/**
	 * State view setter: Sets the step-by-step view elements for state: inter.
	 */
	void setViewInter() {
		this.model.setSbsEnabled(true);
		this.model.notifyObservers(ControlEvent.STEP_BY_STEP);
	}

	/**
	 * State view setter: Sets the step-by-step view elements for state: end.
	 */
	void setViewEnd() {
		this.model.setSbsEnabled(true);
		this.model.setForwardEnabled(false);
		this.model.setToEndEnabled(false);
		this.model.notifyObservers(ControlEvent.STEP_BY_STEP);
	}

	/**
	 * State view setter: Sets the step-by-step view elements for state: off.
	 */
	void setViewOff() {
		this.model.setSbsEnabled(false);
		this.model.notifyObservers(ControlEvent.STEP_BY_STEP);
	}

	/**
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
	 * Doing: Step-by-Step backward until reaching the beginning.
	 * 
	 * @throws Exception
	 */
	void toBeginning() throws Exception {

		ITraversal traversal = this.model.getTraversal();

		try {
			boolean ok = traversal.hasPrevious();

			/* here we go ... */
			while (ok) {
				/* modify the graph */
				traversal.previous();
				ok = traversal.hasPrevious();
			}

			/* update */
			this.model.setProgress(0);
			this.model.setProtocol(new StringBuilder().append(" "));
			this.model.notifyObservers();

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

			int steplength = this.model.getSteplength();
			int min = 0;
			int progress = this.model.getProgress();

			/* here we go ... */
			for (int i = 0; i < steplength; i++) {
				if (min < progress) {
					/* modify the graph */
					traversal.previous();
					progress--;

					/* update */
					this.model.setProgress(progress);
					this.model.notifyObservers();
				} else {
					break;
				}
			}

			this.model.setProtocol(new StringBuilder().append(" "));
			this.model.notifyObservers();

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

			int steplength = this.model.getSteplength();
			int progress = this.model.getProgress();
			int max = this.model.getTraversal().size();
			IStep step = null;
			String description = "";
			StringBuilder stringBuilder = this.model.getProtocol();

			/* here we go ... */
			for (int i = 0; i < steplength; i++) {
				if (progress < max) {
					/* modify the graph */
					// TODO
					// this.blink();
					step = traversal.next();
					description = step.getDescription();
					step.execute();
					stringBuilder.append(description + System.lineSeparator());
					progress++;

					/* update */
					this.model.setProgress(progress);
					this.model.setProtocol(stringBuilder);
					this.model.notifyObservers();
				} else {
					stringBuilder.append(traversal.getDescription()
							+ System.lineSeparator());
					this.model.setProtocol(stringBuilder);
					this.model.notifyObservers();
					break;
				}
			}

		} catch (Exception ex) {
			throw ex;
		}

		return traversal.hasNext();

	}

	/**
	 * A helper method: Helping a step to blink by starting the related timer.
	 * 
	 * @throws InterruptedException
	 */
	private void blink() throws InterruptedException {
		// TODO
		// if (this.model.isBlinkEnabled()) {
		this.timer.start();
		this.setChanged();
		try {
			this.wait();
		} catch (InterruptedException ex) {
			throw ex;
		}
		// }
	}

	/**
	 * Doing: Step-by-Step forward until reaching the end.
	 * 
	 * @throws Exception
	 */
	void toEnd() throws Exception {

		ITraversal traversal = this.model.getTraversal();

		try {

			IStep step = null;
			String description = "";
			StringBuilder stringBuilder = this.model.getProtocol();
			boolean ok = traversal.hasNext();

			/* here we go ... */
			while (ok) {
				/* modify the graph */
				step = traversal.next();
				description = step.getDescription();
				step.execute();
				stringBuilder.append(description + System.lineSeparator());
				ok = traversal.hasNext();
			}

			/* update */
			int max = this.model.getTraversal().size();
			this.model.setProgress(max);
			stringBuilder.append(traversal.getDescription()
					+ System.lineSeparator());
			this.model.setProtocol(stringBuilder);
			this.model.notifyObservers();

		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * A blink listener letting a step blink.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class BlinkListener implements ActionListener {

		/**
		 * A field for a number of blinks.
		 */
		private final int numberOfBlinks;

		/**
		 * Main constructor.
		 * 
		 * @param blinks
		 *            the number of blinks
		 */
		BlinkListener(int numberOfBlinks) {
			this.numberOfBlinks = numberOfBlinks;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			GuiModel model = SbsStateHandler.this.model;
			Timer timer = SbsStateHandler.this.timer;

			try {
				boolean off = true;
				int counter = 0;
				if (counter < numberOfBlinks) {
					if (off)
						model.getTraversal().next().execute();
					else
						model.getTraversal().previous().undo();
					model.notifyObservers();
					off = !off;
					counter++;
				} else {
					timer.stop();
					timer.notify();
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), model
						.getResourceBundle().getString("app.label"), 1, null);
				ex.printStackTrace();
			}

		}

	}

}