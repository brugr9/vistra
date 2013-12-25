package vistra.gui.control.animation;

import static vistra.gui.control.IControl.A_SECOND;
import static vistra.gui.control.IControl.EventSource.ANIMATION;
import static vistra.gui.control.IControl.EventSource.DELAY;
import static vistra.gui.control.IControl.EventSource.PAUSE;
import static vistra.gui.control.IControl.EventSource.PLAY;
import static vistra.gui.control.IControl.EventSource.RESUME;
import static vistra.gui.control.IControl.EventSource.STOP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.Observable;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import vistra.gui.GuiModel;
import vistra.gui.IGuiModel;
import vistra.gui.control.stepbystep.SbsStateHandler;

/**
 * An animation state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public final class AnimationStateHandler extends Observable implements
		IAnimationStateHandler {

	/**
	 * A field for a state.
	 */
	private AbstractAnimationState state;
	/**
	 * A field for a model.
	 */
	private GuiModel model;
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
	 *            a model
	 */
	public AnimationStateHandler(GuiModel model) {
		super();
		this.model = model;

		this.animationListener = new AnimationListener();
		int animationDelay = this.model.getDelay() * A_SECOND;
		this.animationTimer = new Timer(animationDelay, this.animationListener);
		// state
		this.state = new AnimationStateOff(this);
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
			this.model.notifyObservers(DELAY);
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
	public void handleIdle() throws Exception {
		try {
			this.state.exit();
			this.state.handleIdle();
		} catch (Exception e) {
			throw e;
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
	public void handlePlay() throws Exception {
		try {
			this.state.exit();
			this.state.handlePlay();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handlePause() throws Exception {
		try {
			this.state.exit();
			this.state.handlePause();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleStop() throws Exception {
		try {
			this.state.exit();
			this.state.handleStop();
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
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets a state.
	 * 
	 * @param state
	 *            the state to set
	 */
	void setState(AbstractAnimationState state) throws Exception {
		try {
			this.state = state;
			this.state.entry();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * State view setter: Sets the animation view elements for state: off. In
	 * addition, his method sets the state machine step-by-step in state off.
	 * 
	 * @throws Exception
	 */
	void setViewOff() throws Exception {
		try {
			this.model.getStepByStepStateHandler().handleOff();
			this.model.setDelayEnabled(false);
			this.model.setAnimationEnabled(false);
			// pause label
			String label = this.model.getResourceBundle().getString(
					"pause.label");
			this.model.setPauseLabel(label);
			this.model.setPauseEvent(PAUSE);
			this.model.notifyObservers(ANIMATION);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * State view setter: idle.
	 * 
	 * @throws Exception
	 */
	void setViewIdle() throws Exception {
		try {
			/* animation state machine */
			this.model.setDelayEnabled(true);
			this.model.setAnimationEnabled(false);
			this.model.setPlayEnabled(true);
			// pause
			String label = this.model.getResourceBundle().getString(
					"pause.label");
			this.model.setPauseLabel(label);
			this.model.setPauseEvent(PAUSE);
			this.model.notifyObservers(ANIMATION);
			/* other state handlers */
			this.model.getStepByStepStateHandler().handleIdle();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * State view setter: Sets the view elements for state: stopped. In
	 * addition, this method sets the state machines parameter and step-by-step
	 * in state idle.
	 * 
	 * @throws Exception
	 */
	void setViewStopped() throws Exception {
		try {
			/* animation state machine */
			this.model.setDelayEnabled(true);
			this.model.setAnimationEnabled(false);
			this.model.setPlayEnabled(true);
			// pause
			String label = this.model.getResourceBundle().getString(
					"pause.label");
			this.model.setPauseLabel(label);
			this.model.setPauseEvent(PAUSE);
			this.model.notifyObservers(ANIMATION);
			/* other state handlers */
			this.model.getParameterStateHandler().handleIdle();
			this.model.getStepByStepStateHandler().handleIdle();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * State view setter: Sets the view elements for state: playing. In
	 * addition, this method sets the state machines parameter and step-by-step
	 * in state off.
	 * 
	 * @throws Exception
	 */
	void setViewPlaying() throws Exception {
		/* other state handlers */
		try {
			this.model.getParameterStateHandler().handleOff();
			this.model.getStepByStepStateHandler().handleOff();
			/* animation state machine */
			this.model.setDelayEnabled(false);
			this.model.setAnimationEnabled(true);
			this.model.setPlayEnabled(false);
			// pause
			String label = this.model.getResourceBundle().getString(
					"pause.label");
			this.model.setPauseLabel(label);
			this.model.setPauseEvent(PAUSE);

			this.model.notifyObservers(ANIMATION);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * State view setter: Sets the animation view elements for state: paused.
	 * 
	 * @throws Exception
	 */
	void setViewPaused() throws Exception {
		try {
			/* other state handlers */
			// ... are already in state 'off' since coming from state 'playing'
			/* animation state machine */
			// ... is already setViewPlaying() since coming from state 'playing'
			// pause
			String label = this.model.getResourceBundle().getString(
					"resume.label");
			this.model.setPauseLabel(label);
			this.model.setPauseEvent(RESUME);

			this.model.notifyObservers(ANIMATION);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Doing: Starts the animation by starting the related timer. If the
	 * progress is already at maximum, a 'go to beginning' will be performed
	 * first.
	 * 
	 * @throws Exception
	 */
	void startAnimation() throws Exception {
		try {
			/* reset the traversal eventually */
			if (this.model.getProgress() == this.model.getProgressMaximum())
				((SbsStateHandler) this.model
						.getStepByStepStateHandler()).goToBeginning();
			/* simply start the timer */
			this.animationTimer.start();
			this.setChanged();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Doing: Pauses the animation by stopping the related timer.
	 * 
	 * @throws Exception
	 */
	void pauseAnimation() throws Exception {
		try {
			/* simply stop the timer */
			this.animationTimer.stop();
			this.setChanged();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Doing: Stops the animation by stopping the related timer.
	 * 
	 * @throws Exception
	 */
	void stopAnimation() throws Exception {
		try {
			/* simply stop the timer */
			this.animationTimer.stop();
			this.setChanged();
		} catch (Exception ex) {
			throw ex;
		}
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
			try {
				IGuiModel model = AnimationStateHandler.this.model;
				if (model.getProgress() < model.getProgressMaximum())
					((SbsStateHandler) model.getStepByStepStateHandler())
							.goForward();
				else
					model.getAnimationStateHandler().handleStop();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
