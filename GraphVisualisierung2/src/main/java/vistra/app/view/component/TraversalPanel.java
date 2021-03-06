package vistra.app.view.component;

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

import vistra.app.IModel;
import vistra.app.control.ActionListenerI18n.I18nEvent;
import vistra.app.control.state.AnimationStateHandler.AnimationEvent;
import vistra.app.control.state.SbsStateHandler.SbsEvent;
import vistra.framework.util.palette.ColorPalette;

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
	 * A field for a delay panel.
	 */
	private JPanel delayPanel;
	/**
	 * A field for a step-by-step panel.
	 */
	private JPanel sbsPanel;
	/**
	 * A field for a animation panel.
	 */
	private JPanel animationPanel;
	/**
	 * A field for a progress panel.
	 */
	private JPanel progressPanel;
	/**
	 * A field for an empty panel.
	 */
	private JPanel empty1;
	/**
	 * A field for an empty panel.
	 */
	private JPanel empty2;
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
	public TraversalPanel(IModel model, Dimension size) {
		super();
		this.setSize(size);
		this.border = BorderFactory.createTitledBorder("traversalPanel");
		this.setBorder(border);
		this.setBackground(ColorPalette.apricot);

		/* spinner */
		// step length
		this.steplengthLabel = new JLabel("steplength");
		this.steplengthModel = new SpinnerNumberModel(1, STEPLENGTH_MIN,
				STEPLENGTH_MAX, 1);
		this.steplength = new JSpinner(this.steplengthModel);
		((JSpinner.NumberEditor) this.steplength.getEditor()).getTextField()
				.addFocusListener(model.getStepByStep());
		// delay
		this.delayLabel = new JLabel("delay");
		this.delayModel = new SpinnerNumberModel(1, DELAY_MIN, DELAY_MAX, 1);
		this.delay = new JSpinner(this.delayModel);
		((JSpinner.NumberEditor) this.delay.getEditor()).getTextField()
				.addFocusListener(model.getAnimation());

		/* progress bar */
		this.progress = new JProgressBar();
		this.progress.getWidth();
		this.progress.setBackground(ColorPalette.darkgrey);
		this.progress.setForeground(ColorPalette.apple);
		this.progress.setValue(0);
		this.progress.setMaximum(0);
		this.progress.setVisible(true);

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
		this.toBeginning.setActionCommand(SbsEvent.toBeginning);
		this.backward.setActionCommand(SbsEvent.backward);
		this.forward.setActionCommand(SbsEvent.forward);
		this.toEnd.setActionCommand(SbsEvent.toEnd);
		this.play.setActionCommand(AnimationEvent.play);
		this.pause.setActionCommand(AnimationEvent.pause);
		this.stop.setActionCommand(AnimationEvent.stop);
		// action listener
		this.toBeginning.addActionListener(model.getStepByStep());
		this.backward.addActionListener(model.getStepByStep());
		this.forward.addActionListener(model.getStepByStep());
		this.toEnd.addActionListener(model.getStepByStep());
		this.play.addActionListener(model.getAnimation());
		this.pause.addActionListener(model.getAnimation());
		this.stop.addActionListener(model.getAnimation());

		/* panel */
		this.steplengthPanel = new JPanel();
		this.delayPanel = new JPanel();
		this.progressPanel = new JPanel();
		this.empty1 = new JPanel();
		this.empty2 = new JPanel();
		this.sbsPanel = new JPanel();
		this.animationPanel = new JPanel();
		// layout
		this.steplengthPanel.setLayout(new GridLayout(1, 2));
		this.delayPanel.setLayout(new GridLayout(1, 2));
		this.progressPanel.setLayout(new GridLayout(3, 1));
		this.sbsPanel.setLayout(new GridLayout(1, 4));
		this.animationPanel.setLayout(new GridLayout(1, 3));
		// background
		this.steplengthPanel.setBackground(ColorPalette.apricot);
		this.delayPanel.setBackground(ColorPalette.apricot);
		this.progressPanel.setBackground(ColorPalette.apricot);
		this.empty1.setBackground(ColorPalette.apricot);
		this.empty2.setBackground(ColorPalette.apricot);
		this.sbsPanel.setBackground(ColorPalette.apricot);
		this.animationPanel.setBackground(ColorPalette.apricot);
		// add
		this.steplengthPanel.add(this.steplengthLabel);
		this.steplengthPanel.add(this.steplength);
		this.delayPanel.add(this.delayLabel);
		this.delayPanel.add(this.delay);
		this.progressPanel.add(empty1);
		this.progressPanel.add(this.progress);
		this.progressPanel.add(empty2);
		this.sbsPanel.add(this.toBeginning);
		this.sbsPanel.add(this.backward);
		this.sbsPanel.add(this.forward);
		this.sbsPanel.add(this.toEnd);
		this.animationPanel.add(this.play);
		this.animationPanel.add(this.pause);
		this.animationPanel.add(this.stop);

		/* this */
		this.setLayout(new GridLayout(5, 1));
		this.add(this.steplengthPanel);
		this.add(this.delayPanel);
		this.add(this.progressPanel);
		this.add(this.sbsPanel);
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
				if (arg == I18nEvent.I18N) {
					this.border.setTitle(b.getString("traversal.label"));
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
				} else {
					//
					this.progress.setMaximum(m.getTraversal().size());
					this.progress.setValue(m.getProgress());
					//
					this.steplength.setValue(m.getSteplength());
					this.steplength.setEnabled(m.isSteplengthEnabled());
					//
					this.toBeginning.setEnabled(m.isToBeginningEnabled());
					this.backward.setEnabled(m.isBackwardEnabled());
					this.forward.setEnabled(m.isForwardEnabled());
					this.toEnd.setEnabled(m.isToEndEnabled());
					//
					this.delay.setValue(m.getDelay());
					this.delay.setEnabled(m.isDelayEnabled());
					//
					this.play.setEnabled(m.isPlayEnabled());
					this.pause.setEnabled(m.isPauseEnabled());
					this.pause.setActionCommand(m.getPauseActionCommand());
					if (m.getPauseActionCommand() == AnimationEvent.pause)
						this.pause.setSelected(false);
					this.pause.setToolTipText(m.getPauseLabel());
					this.stop.setEnabled(m.isStopEnabled());
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}
	}
}
