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
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource;

/**
 * A traversal panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public final class TraversalPanel extends JPanel implements Observer {

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
	 * @param control
	 *            the controller as in MVC
	 */
	public TraversalPanel(Control control) {

		// spinner
		this.steplengthLabel = new JLabel("steplengthLabel");
		this.steplengthSpinnerNumberModel = new SpinnerNumberModel(1, 1, 10, 1);
		this.steplengthSpinner = new JSpinner(this.steplengthSpinnerNumberModel);
		((JSpinner.NumberEditor) this.steplengthSpinner.getEditor())
				.getTextField().addFocusListener(control.setSteplengthListener);

		this.delayLabel = new JLabel("delayLabel");
		this.delaySpinnerNumberModel = new SpinnerNumberModel(1, 1, 10, 1);
		this.delaySpinner = new JSpinner(this.delaySpinnerNumberModel);
		((JSpinner.NumberEditor) this.delaySpinner.getEditor()).getTextField()
				.addFocusListener(control.setDelayListener);

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

		this.toBeginningButton = new JButton("toBeginningButton");
		this.toBeginningButton.setActionCommand(GOTO_BEGINNING.toString());
		this.toBeginningButton.addActionListener(control.playerListener);

		this.backwardButton = new JButton("backwardButton");
		this.backwardButton.setActionCommand(BACKWARD.toString());
		this.backwardButton.addActionListener(control.playerListener);

		this.forwardButton = new JButton("forwardButton");
		this.forwardButton.setActionCommand(FORWARD.toString());
		this.forwardButton.addActionListener(control.playerListener);

		this.toEndButton = new JButton("toEndButton");
		this.toEndButton.setActionCommand(GOTO_END.toString());
		this.toEndButton.addActionListener(control.playerListener);

		// Panel
		// 1
		this.playerPanel1 = new JPanel();
		this.playerPanel1.setLayout(new GridLayout(1, 6));
		this.playerPanel1.add(this.steplengthLabel);
		this.playerPanel1.add(this.steplengthSpinner);
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
		this.playerPanel2.add(this.toBeginningButton);
		this.playerPanel2.add(this.backwardButton);
		this.playerPanel2.add(this.forwardButton);
		this.playerPanel2.add(this.toEndButton);
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

		if (o instanceof Model) {

			Model m = (Model) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == EventSource.I18N) {

					this.playerPanelBorder
							.setTitle(b.getString("player.label"));
					this.steplengthLabel.setText(b.getString("setStep.label"));
					this.delayLabel.setText(b.getString("setDelay.label"));
					this.progressLabel.setText(b.getString("progress.label"));
					this.playButton.setText(b.getString("play.label"));
					this.pauseButton.setText(b.getString("pause.label"));
					this.stopButton.setText(b.getString("stop.label"));
					this.toBeginningButton.setText(b.getString("home.label"));
					this.backwardButton.setText(b.getString("backward.label"));
					this.forwardButton.setText(b.getString("forward.label"));
					this.toEndButton.setText(b.getString("end.label"));

				} else if (arg == EventSource.SET_DELAY) {

					this.delaySpinner.setValue(m.getDelay());

				} else if (arg == EventSource.SET_STEPLENGTH) {

					this.steplengthSpinner.setValue(m.getSteplength());

				} else {

					this.progressBar.setMaximum(m.getProgressMaximum());
					this.progressBar.setValue(m.getProgress());
					//
					this.pauseButton.setActionCommand(m.getPauseEvent()
							.toString());
					this.pauseButton.setText(b.getString("pause.label"));
					//
					this.steplengthSpinner.setEnabled(m.isSteplengthEnabled());
					this.delaySpinner.setEnabled(m.isDelayEnabled());
					this.playButton.setEnabled(m.isPlayEnabled());
					this.pauseButton.setEnabled(m.isPauseEnabled());
					this.stopButton.setEnabled(m.isStopEnabled());
					this.toBeginningButton.setEnabled(m.isToBeginningEnabled());
					this.backwardButton.setEnabled(m.isBackwardEnabled());
					this.forwardButton.setEnabled(m.isForwardEnabled());
					this.toEndButton.setEnabled(m.isToEndEnabled());

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}
	}

}
