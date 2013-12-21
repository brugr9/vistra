package vistra.gui.view.component;

import static vistra.gui.control.IControl.EventSource.BACKWARD;
import static vistra.gui.control.IControl.EventSource.FORWARD;
import static vistra.gui.control.IControl.EventSource.I18N;
import static vistra.gui.control.IControl.EventSource.PAUSE;
import static vistra.gui.control.IControl.EventSource.PLAY;
import static vistra.gui.control.IControl.EventSource.STOP;
import static vistra.gui.control.IControl.EventSource.TO_BEGINNING;
import static vistra.gui.control.IControl.EventSource.TO_END;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import vistra.gui.IModel;
import vistra.gui.control.IControl.EventSource;
import vistra.util.GraphColor;

/**
 * A traversal panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class TraversalPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a titled border.
	 */
	private TitledBorder titledBorder;
	/**
	 * A field for a steps panel.
	 */
	private JPanel stepsPanel;
	/**
	 * A field for a step-by-step panel.
	 */
	private JPanel stepByStepPanel;
	/**
	 * A field for a animation panel.
	 */
	private JPanel animationPanel;
	/**
	 * A field for a delay panel.
	 */
	private JPanel delayPanel;
	/**
	 * A field for a steplength label.
	 */
	private JLabel steplengthLabel;
	/**
	 * A field for a delay label.
	 */
	private JLabel delayLabel;
	/**
	 * A field for a steplength spinner number model.
	 */
	private SpinnerNumberModel steplengthSpinnerNumberModel;
	/**
	 * A field for an delay spinner number model.
	 */
	private SpinnerNumberModel delaySpinnerNumberModel;
	/**
	 * A field for an steplength spinner.
	 */
	private JSpinner steplengthSpinner;
	/**
	 * A field for an delay spinner.
	 */
	private JSpinner delaySpinner;
	/**
	 * A field for a progress bar.
	 */
	private JProgressBar progressBar;
	/**
	 * A field for a play button.
	 */
	private JButton playButton;
	/**
	 * A field for a pause button.
	 */
	private JToggleButton pauseButton;
	/**
	 * A field for a stop button.
	 */
	private JButton stopButton;
	/**
	 * A field for a toBeginning button.
	 */
	private JButton toBeginningButton;
	/**
	 * A field for a backward button.
	 */
	private JButton backwardButton;
	/**
	 * A field for a forward button.
	 */
	private JButton forwardButton;
	/**
	 * A field for an toEnd button.
	 */
	private JButton toEndButton;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model as in MVC
	 * @param width
	 *            the panel width
	 * @param height
	 *            the panel height
	 */
	public TraversalPanel(IModel model, int width, int height) {
		super();
		this.setSize(new Dimension(width, height));
		this.titledBorder = BorderFactory.createTitledBorder("traversalPanel");
		this.setBorder(titledBorder);

		// step length
		this.steplengthLabel = new JLabel("steplength");
		this.steplengthSpinnerNumberModel = new SpinnerNumberModel(1, 1, 10, 1);
		this.steplengthSpinner = new JSpinner(this.steplengthSpinnerNumberModel);
		((JSpinner.NumberEditor) this.steplengthSpinner.getEditor())
				.getTextField().addFocusListener(
						model.getStepByStepStateHandler());
		// delay
		this.delayLabel = new JLabel("delay");
		this.delaySpinnerNumberModel = new SpinnerNumberModel(1, 1, 10, 1);
		this.delaySpinner = new JSpinner(this.delaySpinnerNumberModel);
		((JSpinner.NumberEditor) this.delaySpinner.getEditor()).getTextField()
				.addFocusListener(model.getAnimationStateHandler());

		// button
		this.toBeginningButton = new JButton(new ImageIcon(this.getClass()
				.getResource("toBeginning.png")));
		this.backwardButton = new JButton(new ImageIcon(this.getClass()
				.getResource("backward.png")));
		this.forwardButton = new JButton(new ImageIcon(this.getClass()
				.getResource("forward.png")));
		this.toEndButton = new JButton(new ImageIcon(this.getClass()
				.getResource("toEnd.png")));
		this.playButton = new JButton(new ImageIcon(this.getClass()
				.getResource("play.png")));
		this.pauseButton = new JToggleButton(new ImageIcon(this.getClass()
				.getResource("pause.png")));
		this.stopButton = new JButton(new ImageIcon(this.getClass()
				.getResource("stop.png")));
		// action command
		this.toBeginningButton.setActionCommand(TO_BEGINNING.toString());
		this.backwardButton.setActionCommand(BACKWARD.toString());
		this.forwardButton.setActionCommand(FORWARD.toString());
		this.toEndButton.setActionCommand(TO_END.toString());
		this.playButton.setActionCommand(PLAY.toString());
		this.pauseButton.setActionCommand(PAUSE.toString());
		this.stopButton.setActionCommand(STOP.toString());
		// action listener
		this.toBeginningButton.addActionListener(model
				.getStepByStepStateHandler());
		this.backwardButton
				.addActionListener(model.getStepByStepStateHandler());
		this.forwardButton.addActionListener(model.getStepByStepStateHandler());
		this.toEndButton.addActionListener(model.getStepByStepStateHandler());
		this.playButton.addActionListener(model.getAnimationStateHandler());
		this.pauseButton.addActionListener(model.getAnimationStateHandler());
		this.stopButton.addActionListener(model.getAnimationStateHandler());

		// progress
		this.progressBar = new JProgressBar();
		this.progressBar.setBackground(GraphColor.DARK_GRAY);
		this.progressBar.setForeground(GraphColor.LIGHT_GREEN);
		this.progressBar.setVisible(true);

		// Panel
		//
		this.stepsPanel = new JPanel();
		this.delayPanel = new JPanel();
		this.stepByStepPanel = new JPanel();
		this.animationPanel = new JPanel();
		//
		this.stepsPanel.setLayout(new GridLayout(1, 2));
		this.delayPanel.setLayout(new GridLayout(1, 2));
		this.stepByStepPanel.setLayout(new GridLayout(1, 4));
		this.animationPanel.setLayout(new GridLayout(1, 3));
		//
		this.stepsPanel.setBackground((Color) GraphColor.ANTIQUE);
		this.delayPanel.setBackground((Color) GraphColor.ANTIQUE);
		this.stepByStepPanel.setBackground((Color) GraphColor.ANTIQUE);
		this.animationPanel.setBackground((Color) GraphColor.ANTIQUE);
		//
		this.stepsPanel.add(this.steplengthLabel);
		this.stepsPanel.add(this.steplengthSpinner);
		//
		this.delayPanel.add(this.delayLabel);
		this.delayPanel.add(this.delaySpinner);
		//
		this.stepByStepPanel.add(this.toBeginningButton);
		this.stepByStepPanel.add(this.backwardButton);
		this.stepByStepPanel.add(this.forwardButton);
		this.stepByStepPanel.add(this.toEndButton);
		//
		this.animationPanel.add(this.playButton);
		this.animationPanel.add(this.pauseButton);
		this.animationPanel.add(this.stopButton);
		// this
		this.setLayout(new GridLayout(5, 1));
		this.setBackground((Color) GraphColor.ANTIQUE);
		this.add(this.stepsPanel);
		this.add(this.delayPanel);
		this.add(this.progressBar);
		this.add(this.stepByStepPanel);
		this.add(this.animationPanel);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof IModel) {

			IModel m = (IModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == I18N) {
					this.titledBorder.setTitle(b.getString("player.label"));
					//
					this.steplengthLabel.setText(b.getString("setStep.label"));
					this.delayLabel.setText(b.getString("setDelay.label"));
					//
					this.toBeginningButton.setToolTipText(b
							.getString("home.label"));
					this.backwardButton.setToolTipText(b
							.getString("backward.label"));
					this.forwardButton.setToolTipText(b
							.getString("forward.label"));
					this.toEndButton.setToolTipText(b.getString("end.label"));
					//
					this.playButton.setToolTipText(b.getString("play.label"));
					this.pauseButton.setToolTipText(b.getString("pause.label"));
					this.stopButton.setToolTipText(b.getString("stop.label"));

				} else if (arg == EventSource.SET_DELAY) {
					this.delaySpinner.setValue(m.getDelay());
				} else if (arg == EventSource.SET_STEPLENGTH) {
					this.steplengthSpinner.setValue(m.getSteplength());
				} else if (arg == EventSource.STEP_BY_STEP) {
					this.steplengthSpinner.setEnabled(m.isSteplengthEnabled());
					this.toBeginningButton.setEnabled(m.isToBeginningEnabled());
					this.backwardButton.setEnabled(m.isBackwardEnabled());
					this.forwardButton.setEnabled(m.isForwardEnabled());
					this.toEndButton.setEnabled(m.isToEndEnabled());
				} else if (arg == EventSource.ANIMATION) {
					this.delaySpinner.setEnabled(m.isDelayEnabled());
					this.playButton.setEnabled(m.isPlayEnabled());
					this.pauseButton.setEnabled(m.isPauseEnabled());
					this.stopButton.setEnabled(m.isStopEnabled());
					this.pauseButton.setToolTipText(m.getPauseLabel());
					this.pauseButton.setActionCommand(m.getPauseEvent()
							.toString());
					if (m.getPauseEvent() == EventSource.PAUSE)
						this.pauseButton.setSelected(false);
				}
				this.progressBar.setValue(m.getProgress());
				this.progressBar.setMaximum(m.getProgressMaximum());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}
	}
}
