/**
 * 
 */
package vistra.gui.control.animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.Observable;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import vistra.gui.IModel;
import vistra.gui.Model;
import vistra.gui.control.stepbystep.StepByStepStateHandler;

import static vistra.gui.control.IControl.EventSource.ANIMATION;
import static vistra.gui.control.IControl.EventSource.PAUSE;
import static vistra.gui.control.IControl.EventSource.PLAY;
import static vistra.gui.control.IControl.EventSource.RESUME;
import static vistra.gui.control.IControl.EventSource.SET_DELAY;
import static vistra.gui.control.IControl.EventSource.STOP;

/**
 * An animation state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public final class AnimationStateHandler extends Observable implements
		IAnimationStateHandler {

	/**
	 * A field for a model.
	 */
	private Model model;
	/**
	 * A field for an animation state.
	 */
	private AbstractAnimationState state;
	/**
	 * A field for an animation timer.
	 */
	private Timer animationTimer;
	/**
	 * A field for an animation listener.
	 */
	private AnimationListener animationListener;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a gravis gui model
	 */
	public AnimationStateHandler(IModel model) {
		super();
		this.model = (Model) model;
		this.animationListener = new AnimationListener();
		int animationDelay = this.model.getDelay() * A_SECOND;
		this.animationTimer = new Timer(animationDelay, this.animationListener);
		// state
		this.setState(new AnimationOff(this));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void focusGained(FocusEvent e) {
		// nothing to do on gaining focus
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void focusLost(FocusEvent e) {
		try {
			/* get the value */
			JFormattedTextField textField = (JFormattedTextField) e.getSource();
			int value = Integer.valueOf(textField.getText());
			/* set the value */
			this.model.setDelay(value);
			this.animationTimer.setDelay(value * A_SECOND);
			/* update the view */
			this.model.notifyObservers(SET_DELAY);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String c = e.getActionCommand();
			if (c.equals(PLAY.toString()))
				this.handlePlay();
			else if (c.equals(PAUSE.toString()))
				this.handlePause();
			else if (c.equals(RESUME.toString()))
				this.handlePlay();
			else if (c.equals(STOP.toString()))
				this.handleStop();
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
	public void handleIdle() {
		this.state.exit();
		this.state.handleIdle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handlePlay() {
		this.state.exit();
		this.state.handlePlay();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handlePause() {
		this.state.exit();
		this.state.handlePause();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleStop() {
		this.state.exit();
		this.state.handleStop();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleOff() {
		this.state.exit();
		this.state.handleOff();
	}

	/**
	 * Sets a state.
	 * 
	 * @param state
	 *            the state to set
	 */
	void setState(AbstractAnimationState state) {
		this.state = state;
		this.state.entry();
	}

	/**
	 * Doing: Starts the animation by starting the related timer. If the
	 * progress is already at maximum, a 'go to beginning' will be performed
	 * first.
	 */
	void startAnimation() {
		/* reset the traversal eventually */
		if (this.model.getProgress() == this.model.getProgressMaximum())
			((StepByStepStateHandler) this.model.getStepByStepStateHandler())
					.goToBeginning();
		/* simply start the timer */
		this.animationTimer.start();
		this.setChanged();
	}

	/**
	 * Doing: Pauses the animation by stopping the related timer.
	 */
	void pauseAnimation() {
		/* simply stop the timer */
		this.animationTimer.stop();
		this.setChanged();
	}

	/**
	 * Doing: Stops the animation by stopping the related timer.
	 */
	void stopAnimation() {
		/* simply stop the timer */
		this.animationTimer.stop();
		this.setChanged();
	}

	/**
	 * State view setter: Sets the view elements for state: playing. In
	 * addition, this method sets the state machines parameter and step-by-step
	 * in state off.
	 */
	void setViewPlaying() {
		/* other state handlers */
		try {
			this.model.getParameterStateHandler().handleOff();
			this.model.getStepByStepStateHandler().handleOff();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* animation state machine */
		this.model.setDelayEnabled(false);
		this.model.setAnimationEnabled(true);
		this.model.setPlayEnabled(false);
		// pause
		String label = this.model.getResourceBundle().getString("pause.label");
		this.model.setPauseLabel(label);
		this.model.setPauseEvent(PAUSE);

		this.model.notifyObservers(ANIMATION);
	}

	/**
	 * State view setter: Sets the animation view elements for state: paused.
	 */
	void setViewPaused() {
		/* other state handlers */
		// ... are already in state 'off' since coming from state 'playing'
		/* animation state machine */
		// ... is already setViewPlaying() since coming from state 'playing'
		// pause
		String label = this.model.getResourceBundle().getString("resume.label");
		this.model.setPauseLabel(label);
		this.model.setPauseEvent(RESUME);

		this.model.notifyObservers(ANIMATION);
	}

	/**
	 * State view setter: Sets the view elements for state: stopped. In
	 * addition, this method sets the state machines parameter and step-by-step
	 * in state idle.
	 */
	void setViewStopped() {
		/* animation state machine */
		this.model.setDelayEnabled(true);
		this.model.setAnimationEnabled(false);
		this.model.setPlayEnabled(true);
		// pause
		String label = this.model.getResourceBundle().getString("pause.label");
		this.model.setPauseLabel(label);
		this.model.setPauseEvent(PAUSE);
		/* other state handlers */
		try {
			this.model.getParameterStateHandler().handleIdle();
			this.model.getStepByStepStateHandler().handleIdle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.model.notifyObservers(ANIMATION);
	}

	/**
	 * State view setter: Sets the animation view elements for state: off. In
	 * addition, his method sets the state machine step-by-step in state off.
	 */
	void setViewOff() {
		this.model.getStepByStepStateHandler().handleOff();
		this.model.setDelayEnabled(false);
		this.model.setAnimationEnabled(false);
		this.model.notifyObservers(ANIMATION);
	}

	/**
	 * An animation listener.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private final class AnimationListener implements ActionListener {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			IModel model = AnimationStateHandler.this.model;

			if (model.getProgress() < model.getProgressMaximum())
				((StepByStepStateHandler) model.getStepByStepStateHandler())
						.goForward();
			else
				model.getAnimationStateHandler().handleStop();
		}

	}

}
