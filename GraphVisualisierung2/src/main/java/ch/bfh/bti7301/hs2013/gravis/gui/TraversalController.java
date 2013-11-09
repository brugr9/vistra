package ch.bfh.bti7301.hs2013.gravis.gui;

import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.BACKWARD;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.FORWARD;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.GOTO_BEGINNING;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.GOTO_END;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.PAUSE;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.PLAY;
import static ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource.STOP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

/**
 * A traversal controller panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public final class TraversalController extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a titled border.
	 */
	private TitledBorder playerPanelBorder;
	/**
	 * A field for a player panel.
	 */
	private JPanel playerPanel1;
	/**
	 * A field for a player panel.
	 */
	private JPanel playerPanel2;
	/**
	 * A field for a player panel.
	 */
	private JPanel playerPanel3;
	/**
	 * A field for a step label.
	 */
	private JLabel stepLabel;
	/**
	 * A field for a delay label.
	 */
	private JLabel delayLabel;
	/**
	 * A field for a step spinner number model.
	 */
	private SpinnerNumberModel stepSpinnerNumberModel;
	/**
	 * A field for an delay spinner number model.
	 */
	private SpinnerNumberModel delaySpinnerNumberModel;
	/**
	 * A field for an step spinner.
	 */
	private JSpinner stepSpinner;
	/**
	 * A field for an delay spinner.
	 */
	private JSpinner delaySpinner;
	/**
	 * A field for a progress label.
	 */
	private JLabel progressLabel;
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
	private JButton pauseButton;
	/**
	 * A field for a stop button.
	 */
	private JButton stopButton;
	/**
	 * A field for a home button.
	 */
	private JButton homeButton;
	/**
	 * A field for a backward button.
	 */
	private JButton backwardButton;
	/**
	 * A field for a forward button.
	 */
	private JButton forwardButton;
	/**
	 * A field for an end button.
	 */
	private JButton endButton;

	/**
	 * Main constructor.
	 * 
	 * @param control
	 *            the controller as in MVC
	 */
	public TraversalController(Control control) {

		// spinner
		this.stepLabel = new JLabel("stepLabel");
		this.stepSpinnerNumberModel = new SpinnerNumberModel(1, 1, 10, 1);
		this.stepSpinner = new JSpinner(this.stepSpinnerNumberModel);
		((JSpinner.NumberEditor) this.stepSpinner.getEditor()).getTextField()
				.addFocusListener(control.stepSettingsListener);

		this.delayLabel = new JLabel("delayLabel");
		this.delaySpinnerNumberModel = new SpinnerNumberModel(1, 1, 10, 1);
		this.delaySpinner = new JSpinner(this.delaySpinnerNumberModel);
		((JSpinner.NumberEditor) this.delaySpinner.getEditor()).getTextField()
				.addFocusListener(control.delaySettingsListener);

		this.progressLabel = new JLabel("progressLabel");

		this.progressBar = new JProgressBar();
		this.progressBar.setBackground(Color.DARK_GRAY);
		this.progressBar.setForeground(Color.GREEN);
		this.progressBar.setVisible(true);

		this.playButton = new JButton("playButton");
		this.playButton.setActionCommand(PLAY.toString());
		this.playButton.addActionListener(control.playerListener);

		this.pauseButton = new JButton("pauseButton");
		this.pauseButton.setActionCommand(PAUSE.toString());
		this.pauseButton.addActionListener(control.playerListener);

		this.stopButton = new JButton("stopButton");
		this.stopButton.setActionCommand(STOP.toString());
		this.stopButton.addActionListener(control.playerListener);

		this.homeButton = new JButton("homeButton");
		this.homeButton.setActionCommand(GOTO_BEGINNING.toString());
		this.homeButton.addActionListener(control.playerListener);

		this.backwardButton = new JButton("backwardButton");
		this.backwardButton.setActionCommand(BACKWARD.toString());
		this.backwardButton.addActionListener(control.playerListener);

		this.forwardButton = new JButton("forwardButton");
		this.forwardButton.setActionCommand(FORWARD.toString());
		this.forwardButton.addActionListener(control.playerListener);

		this.endButton = new JButton("endButton");
		this.endButton.setActionCommand(GOTO_END.toString());
		this.endButton.addActionListener(control.playerListener);

		// Panel
		// 1
		this.playerPanel1 = new JPanel();
		this.playerPanel1.setLayout(new GridLayout(1, 6));
		this.playerPanel1.add(this.stepLabel);
		this.playerPanel1.add(this.stepSpinner);
		this.playerPanel1.add(this.delayLabel);
		this.playerPanel1.add(this.delaySpinner);
		this.playerPanel1.add(this.progressLabel);
		this.playerPanel1.add(this.progressBar);
		// 2
		this.playerPanel2 = new JPanel();
		this.playerPanel2.setLayout(new GridLayout(1, 3));
		this.playerPanel2.add(this.playButton);
		this.playerPanel2.add(this.pauseButton);
		this.playerPanel2.add(this.stopButton);
		// 3
		this.playerPanel3 = new JPanel();
		this.playerPanel3.setLayout(new GridLayout(1, 4));
		this.playerPanel2.add(this.homeButton);
		this.playerPanel2.add(this.backwardButton);
		this.playerPanel2.add(this.forwardButton);
		this.playerPanel2.add(this.endButton);
		// 1 - 2 - 3
		this.playerPanelBorder = BorderFactory
				.createTitledBorder("playerPanel");
		this.setBorder(playerPanelBorder);
		this.setLayout(new BorderLayout(1, 1));
		this.add(this.playerPanel1, BorderLayout.NORTH);
		this.add(this.playerPanel2, BorderLayout.CENTER);
		this.add(this.playerPanel3, BorderLayout.SOUTH);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		Model m = (Model) o;

		try {

			this.playerPanelBorder.setTitle(m.getPlayerPanelLabel());

			// spinner
			this.stepLabel.setText(m.getStepLabel());
			this.delayLabel.setText(m.getDelayLabel());
			this.stepSpinner.setValue(m.getStepValue());
			this.delaySpinner.setValue(m.getDelayValue());
			this.stepSpinner.setEnabled(m.isStepEnabled());
			this.delaySpinner.setEnabled(m.isDelayEnabled());

			// progressbar
			this.progressLabel.setText(m.getProgressLabel());
			this.progressBar.setMaximum(m.getProgressValueMaximum());
			this.progressBar.setValue(m.getProgressValue());

			// button
			this.playButton.setText(m.getPlayButtonLabel());
			this.playButton.setEnabled(m.isPlayButtonEnabled());

			this.pauseButton.setText(m.getPauseButtonLabel());
			this.pauseButton.setActionCommand(m.getPauseButtonActionCommand());
			this.pauseButton.setEnabled(m.isPauseButtonEnabled());

			this.stopButton.setText(m.getStopButtonLabel());
			this.stopButton.setEnabled(m.isStopButtonEnabled());

			this.homeButton.setText(m.getHomeButtonLabel());
			this.homeButton.setEnabled(m.isHomeButtonEnabled());

			this.backwardButton.setText(m.getBackwardButtonLabel());
			this.backwardButton.setMnemonic(m.getBackwardButtonMnemonic());
			this.backwardButton.setEnabled(m.isBackwardButtonEnabled());

			this.forwardButton.setText(m.getForwardButtonLabel());
			this.forwardButton.setEnabled(m.isForwardButtonEnabled());

			this.endButton.setText(m.getEndButtonLabel());
			this.endButton.setEnabled(m.isEndButtonEnabled());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					m.getProgramName(), 1, null);
			e.printStackTrace();
		}

	}

}
