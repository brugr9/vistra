package vistra.app.control.state;

import static vistra.app.control.IControl.A_SECOND;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.Observable;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.app.control.IControl.ActionCommandAnimation;

/**
 * An animation state handler. An animation state machine handles the animated
 * iteration over a traversal-object.
 * <p>
 * As a part of the graphic user interface control, this state handler is an is
 * a focus listener (delay setting) and an action listener (buttons), too.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ParameterStateHandler
 * @see SbsStateHandler
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
	private Model model;
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
	public AnimationStateHandler(IModel model) {
		super();
		this.model = (Model) model;
		try {
			this.state = new AnimationStateOff(this);
			this.setState(new AnimationStateOff(this));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.animationListener = new AnimationListener();
		int animationDelay = this.model.getDelay() * A_SECOND;
		this.animationTimer = new Timer(animationDelay, this.animationListener);
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
			if (c.equals(ActionCommandAnimation.play))
				this.handlePlaying();
			else if (c.equals(ActionCommandAnimation.pause))
				this.handlePaused();
			else if (c.equals(ActionCommandAnimation.resume))
				this.handlePlaying();
			else if (c.equals(ActionCommandAnimation.stop))
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
	 * State view setter: Sets the animation view elements for state: stopped.
	 * 
	 * @throws Exception
	 */
	void setViewStopped() throws Exception {
		try {
			this.model.setAnimationEnabled(true);
			this.model.setPauseEnabled(false);
			this.model.setStopEnabled(false);
			// pause label
			String label = this.model.getResourceBundle().getString(
					"pause.label");
			this.model.setPauseLabel(label);
			this.model.setPauseActionCommand(ActionCommandAnimation.pause);
			//
			this.model.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * State view setter: Sets the animation view elements for state: playing.
	 * 
	 * @throws Exception
	 */
	void setViewPlaying() throws Exception {
		try {
			this.model.setAnimationEnabled(true);
			this.model.setDelayEnabled(false);
			this.model.setPlayEnabled(false);
			// pause label
			String label = this.model.getResourceBundle().getString(
					"pause.label");
			this.model.setPauseLabel(label);
			this.model.setPauseActionCommand(ActionCommandAnimation.pause);
			//
			this.model.notifyObservers();
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
			this.model.setAnimationEnabled(true);
			this.model.setDelayEnabled(false);
			this.model.setPlayEnabled(false);
			// pause label
			String label = this.model.getResourceBundle().getString(
					"resume.label");
			this.model.setPauseLabel(label);
			this.model.setPauseActionCommand(ActionCommandAnimation.resume);
			//
			this.model.notifyObservers();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * State view setter: Sets the animation view elements for state: off.
	 * 
	 * @throws Exception
	 */
	void setViewOff() throws Exception {
		try {
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
				((SbsStateHandler) this.model.getSbsStateHandler())
						.toBeginning();
			((SbsStateHandler) this.model.getSbsStateHandler()).handleOff();
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
			((SbsStateHandler) this.model.getSbsStateHandler()).handleIdle();
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
				Model m = AnimationStateHandler.this.model;
				if (m.getProgress() < m.getTraversal().size())
					((SbsStateHandler) m.getSbsStateHandler()).forward();
				else
					m.getAnimationStateHandler().handleStopped();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
