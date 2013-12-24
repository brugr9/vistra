package vistra.gui.view.component;

import static vistra.gui.control.IControl.EventSource.BACKWARD;
import static vistra.gui.control.IControl.EventSource.FORWARD;
import static vistra.gui.control.IControl.EventSource.I18N;
import static vistra.gui.control.IControl.EventSource.PAUSE;
import static vistra.gui.control.IControl.EventSource.PLAY;
import static vistra.gui.control.IControl.EventSource.STOP;
import static vistra.gui.control.IControl.EventSource.TO_BEGINNING;
import static vistra.gui.control.IControl.EventSource.TO_END;

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

import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
import vistra.util.ColorPalette;

/**
 * A traversal panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class TraversalPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	/**
	 * A field for a minimum steplength.
	 */
	private static final int STEPLENGTH_MIN = 1;
	/**
	 * A field for a maximum steplength.
	 */
	private static final int STEPLENGTH_MAX = 10;
	/**
	 * A field for a minimum delay.
	 */
	private static final int DELAY_MIN = 1;
	/**
	 * A field for a maximum delay.
	 */
	private static final int DELAY_MAX = 10;
	/**
	 * A field for a titled border.
	 */
	private TitledBorder border;
	/**
	 * A field for a steplength panel.
	 */
	private JPanel steplengthPanel;
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
	private SpinnerNumberModel steplengthModel;
	/**
	 * A field for an delay spinner number model.
	 */
	private SpinnerNumberModel delayModel;
	/**
	 * A field for an steplength spinner.
	 */
	private JSpinner steplength;
	/**
	 * A field for an delay spinner.
	 */
	private JSpinner delay;
	/**
	 * A field for a progress bar.
	 */
	private JProgressBar progress;
	/**
	 * A field for a play button.
	 */
	private JButton play;
	/**
	 * A field for a pause button.
	 */
	private JToggleButton pause;
	/**
	 * A field for a stop button.
	 */
	private JButton stop;
	/**
	 * A field for a toBeginning button.
	 */
	private JButton toBeginning;
	/**
	 * A field for a backward button.
	 */
	private JButton backward;
	/**
	 * A field for a forward button.
	 */
	private JButton forward;
	/**
	 * A field for an toEnd button.
	 */
	private JButton toEnd;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model as in MVC
	 * @param size
	 *            the panel size
	 */
	public TraversalPanel(IGuiModel model, Dimension size) {
		super();
		this.setSize(size);
		this.border = BorderFactory.createTitledBorder("traversalPanel");
		this.setBorder(border);
		this.setBackground(ColorPalette.antique);

		/* spinner */
		// step length
		this.steplengthLabel = new JLabel("steplength");
		this.steplengthModel = new SpinnerNumberModel(1, STEPLENGTH_MIN,
				STEPLENGTH_MAX, 1);
		this.steplength = new JSpinner(this.steplengthModel);
		((JSpinner.NumberEditor) this.steplength.getEditor()).getTextField()
				.addFocusListener(model.getStepByStepStateHandler());
		// delay
		this.delayLabel = new JLabel("delay");
		this.delayModel = new SpinnerNumberModel(1, DELAY_MIN, DELAY_MAX, 1);
		this.delay = new JSpinner(this.delayModel);
		((JSpinner.NumberEditor) this.delay.getEditor()).getTextField()
				.addFocusListener(model.getAnimationStateHandler());

		/* button */
		Class<? extends TraversalPanel> c = this.getClass();
		this.toBeginning = new JButton(new ImageIcon(
				c.getResource("toBeginning.png")));
		this.backward = new JButton(
				new ImageIcon(c.getResource("backward.png")));
		this.forward = new JButton(new ImageIcon(c.getResource("forward.png")));
		this.toEnd = new JButton(new ImageIcon(c.getResource("toEnd.png")));
		this.play = new JButton(new ImageIcon(c.getResource("play.png")));
		this.pause = new JToggleButton(
				new ImageIcon(c.getResource("pause.png")));
		this.stop = new JButton(new ImageIcon(c.getResource("stop.png")));
		// action command
		this.toBeginning.setActionCommand(TO_BEGINNING.toString());
		this.backward.setActionCommand(BACKWARD.toString());
		this.forward.setActionCommand(FORWARD.toString());
		this.toEnd.setActionCommand(TO_END.toString());
		this.play.setActionCommand(PLAY.toString());
		this.pause.setActionCommand(PAUSE.toString());
		this.stop.setActionCommand(STOP.toString());
		// action listener
		this.toBeginning.addActionListener(model.getStepByStepStateHandler());
		this.backward.addActionListener(model.getStepByStepStateHandler());
		this.forward.addActionListener(model.getStepByStepStateHandler());
		this.toEnd.addActionListener(model.getStepByStepStateHandler());
		this.play.addActionListener(model.getAnimationStateHandler());
		this.pause.addActionListener(model.getAnimationStateHandler());
		this.stop.addActionListener(model.getAnimationStateHandler());

		// progress
		this.progress = new JProgressBar();
		this.progress.setBackground(ColorPalette.darkgrey);
		this.progress.setForeground(ColorPalette.green);
		this.progress.setVisible(true);

		/* panel */
		this.steplengthPanel = new JPanel();
		this.delayPanel = new JPanel();
		this.stepByStepPanel = new JPanel();
		this.animationPanel = new JPanel();
		// layout
		this.steplengthPanel.setLayout(new GridLayout(1, 2));
		this.delayPanel.setLayout(new GridLayout(1, 2));
		this.stepByStepPanel.setLayout(new GridLayout(1, 4));
		this.animationPanel.setLayout(new GridLayout(1, 3));
		// background
		this.steplengthPanel.setBackground(ColorPalette.antique);
		this.delayPanel.setBackground(ColorPalette.antique);
		this.stepByStepPanel.setBackground(ColorPalette.antique);
		this.animationPanel.setBackground(ColorPalette.antique);
		// add
		this.steplengthPanel.add(this.steplengthLabel);
		this.steplengthPanel.add(this.steplength);
		this.delayPanel.add(this.delayLabel);
		this.delayPanel.add(this.delay);
		this.stepByStepPanel.add(this.toBeginning);
		this.stepByStepPanel.add(this.backward);
		this.stepByStepPanel.add(this.forward);
		this.stepByStepPanel.add(this.toEnd);
		this.animationPanel.add(this.play);
		this.animationPanel.add(this.pause);
		this.animationPanel.add(this.stop);

		/* this */
		this.setLayout(new GridLayout(5, 1));
		this.add(this.steplengthPanel);
		this.add(this.delayPanel);
		this.add(this.progress);
		this.add(this.stepByStepPanel);
		this.add(this.animationPanel);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof IGuiModel) {

			IGuiModel m = (IGuiModel) o;
			ResourceBundle b = m.getResourceBundle();

			try {

				if (arg == I18N) {
					this.border.setTitle(b.getString("player.label"));
					//
					this.steplengthLabel.setText(b.getString("setStep.label"));
					this.delayLabel.setText(b.getString("setDelay.label"));
					//
					this.toBeginning.setToolTipText(b.getString("home.label"));
					this.backward.setToolTipText(b.getString("backward.label"));
					this.forward.setToolTipText(b.getString("forward.label"));
					this.toEnd.setToolTipText(b.getString("end.label"));
					//
					this.play.setToolTipText(b.getString("play.label"));
					this.pause.setToolTipText(b.getString("pause.label"));
					this.stop.setToolTipText(b.getString("stop.label"));

				} else if (arg == EventSource.DELAY) {
					this.delay.setValue(m.getDelay());
				} else if (arg == EventSource.STEPLENGTH) {
					this.steplength.setValue(m.getSteplength());
				} else if (arg == EventSource.STEP_BY_STEP) {
					this.steplength.setEnabled(m.isSteplengthEnabled());
					this.toBeginning.setEnabled(m.isToBeginningEnabled());
					this.backward.setEnabled(m.isBackwardEnabled());
					this.forward.setEnabled(m.isForwardEnabled());
					this.toEnd.setEnabled(m.isToEndEnabled());
				} else if (arg == EventSource.ANIMATION) {
					this.delay.setEnabled(m.isDelayEnabled());
					this.play.setEnabled(m.isPlayEnabled());
					this.pause.setEnabled(m.isPauseEnabled());
					this.stop.setEnabled(m.isStopEnabled());
					this.pause.setToolTipText(m.getPauseLabel());
					this.pause.setActionCommand(m.getPauseEvent().toString());
					if (m.getPauseEvent() == EventSource.PAUSE)
						this.pause.setSelected(false);
				}
				this.progress.setValue(m.getProgress());
				this.progress.setMaximum(m.getProgressMaximum());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}
	}
}
