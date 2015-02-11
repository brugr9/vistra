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
import vistra.framework.util.palette.ConstantPalette;

/**
 * An animation handler: handles the animated iteration over a traversal-object.
 * <p>
 * As a part of the graphic user interface control, this state handler is an is
 * a focus listener (delay setting) and an action listener (buttons), too.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ParameterStateHandler
 * @see SbsStateHandler
 */
public final class AnimationStateHandler extends Observable implements IAnimation {

	/**
	 * A field for a state.
	 */
	private AbstractAnimationState state;
	/**
	 * A field for a model.
	 */
	private Model model;
	/**
	 * A field for an animation timer.
	 */
	protected Timer animationTimer;
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
	public AnimationStateHandler(IModel model) {
		super();
		this.model = (Model) model;
		// timer
		this.animationListener = new AnimationListener();
		int animationDelay = this.model.getDelay() * ConstantPalette.aSecond;
		this.animationTimer = new Timer(animationDelay, this.animationListener);
		// state
		try {
			this.state = new AnimationOff(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			this.animationTimer.setDelay(value * ConstantPalette.aSecond);
			/* update the view */
			this.model.notifyObservers();
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
			if (c.equals(AnimationEvent.play))
				this.handlePlaying();
			else if (c.equals(AnimationEvent.pause))
				this.handlePaused();
			else if (c.equals(AnimationEvent.resume))
				this.handlePlaying();
			else if (c.equals(AnimationEvent.stop))
				this.handleStopped();
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
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handlePlaying() throws Exception {
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
	public void handlePaused() throws Exception {
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
	public void handleStopped() throws Exception {
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
	 * Property: Sets the animation view elements for state: stopped.
	 * 
	 * @throws Exception
	 */
	void setStopped() throws Exception {
		try {
			((SbsStateHandler) this.model.getStepByStep()).handleIdle();
			((ParameterStateHandler) this.model.getParameterStateHandler())
					.setEnableMenu(true);
			((ParameterStateHandler) this.model.getParameterStateHandler())
					.setEnableAlgorithms(true);
			//
			this.model.setAnimationEnabled(true);
			this.model.setPauseEnabled(false);
			this.model.setStopEnabled(false);
			// pause label
			String label = this.model.getResourceBundle().getString(
					"pause.label");
			this.model.setPauseLabel(label);
			this.model.setPauseActionCommand(AnimationEvent.pause);
			//
			this.model.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Property: Sets the animation view elements for state: playing.
	 * 
	 * @throws Exception
	 */
	void setPlaying() throws Exception {
		try {
			this.model.getStepByStep().handleOff();
			((ParameterStateHandler) this.model.getParameterStateHandler())
					.setEnableMenu(false);
			((ParameterStateHandler) this.model.getParameterStateHandler())
					.setEnableAlgorithms(false);
			//
			this.model.setAnimationEnabled(true);
			this.model.setDelayEnabled(false);
			this.model.setPlayEnabled(false);
			// pause label
			String label = this.model.getResourceBundle().getString(
					"pause.label");
			this.model.setPauseLabel(label);
			this.model.setPauseActionCommand(AnimationEvent.pause);
			//
			this.model.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Property: Sets the animation view elements for state: paused.
	 * 
	 * @throws Exception
	 */
	void setPaused() throws Exception {
		try {
			this.model.setAnimationEnabled(true);
			this.model.setDelayEnabled(false);
			this.model.setPlayEnabled(false);
			// pause label
			String label = this.model.getResourceBundle().getString(
					"resume.label");
			this.model.setPauseLabel(label);
			this.model.setPauseActionCommand(AnimationEvent.resume);
			//
			this.model.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Property: Sets the animation view elements for state: off.
	 * 
	 * @throws Exception
	 */
	void setOff() throws Exception {
		try {
			this.model.getStepByStep().handleOff();
			//
			this.model.setAnimationEnabled(false);
			this.model.notifyObservers();
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
			/* go to the first step eventually */
			if (this.model.getProgress() == this.model.getTraversal().size())
				((SbsStateHandler) this.model.getStepByStep()).toBeginning();
			/* start the timer */
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
			this.animationTimer.stop();
			this.setChanged();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Doing: Resumes the animation by starting the related timer.
	 * 
	 * @throws Exception
	 */
	void resumeAnimation() throws Exception {
		try {
			this.animationTimer.start();
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
				IModel m = AnimationStateHandler.this.model;
				if (m.getTraversal().hasNext())
					m.getStepByStep().handleForward();
				else
					m.getAnimation().handleStopped();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Animation events.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum AnimationEvent {

		//
		DELAY("delay"),
		//
		PLAY("play"),
		//
		PAUSE("pause"),
		//
		RESUME("resume"),
		//
		STOP("stop"),

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
		AnimationEvent(String value) {
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

		public static final String delay = DELAY.getValue();
		public static final String play = PLAY.getValue();
		public static final String pause = PAUSE.getValue();
		public static final String resume = RESUME.getValue();
		public static final String stop = STOP.getValue();

	}

}
