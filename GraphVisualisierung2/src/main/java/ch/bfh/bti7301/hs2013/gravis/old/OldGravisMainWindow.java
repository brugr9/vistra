package ch.bfh.bti7301.hs2013.gravis.old;

import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.BACKWARD_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.BEGINNING_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.DELETE_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.DELETE_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.END_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.EXIT_APPLICATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.EXPORT_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.FORWARD_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.IMPORT_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.IMPORT_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.PAUSE_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.PLAY_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.SAVE_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.SELECT_ALGORITHM;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.SELECT_GRAPH;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.START_PROCESSING;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.STEP_INCREMENT;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.STOP_ANIMATION;
import static ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener.EventSource.TIME_INTERVALL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @deprecated
 */
public class OldGravisMainWindow extends JFrame {

	private static final long serialVersionUID = 7221550910200463672L;

	/**
	 * Create the application.
	 * 
	 * @param title
	 * @param graphPanel
	 * @param mainWindowListener
	 */
	public OldGravisMainWindow(String title, JPanel graphPanel,
			OldIGravisMainListener mainWindowListener) {
		super(title);

		// TODO add dynamic layout
		getContentPane().setLayout(null);

		JButton btnImportNewGraph = new JButton("Neuen Graphen importieren...");
		btnImportNewGraph.setActionCommand(IMPORT_GRAPH.toString());
		btnImportNewGraph.addActionListener(mainWindowListener);
		btnImportNewGraph.setBounds(10, 11, 218, 23);
		getContentPane().add(btnImportNewGraph);

		JButton btnNewAlgo = new JButton("Neuen Algorithmus einbinden...");
		btnNewAlgo.setActionCommand(IMPORT_ALGORITHM.toString());
		btnNewAlgo.addActionListener(mainWindowListener);
		btnNewAlgo.setBounds(238, 11, 215, 23);
		getContentPane().add(btnNewAlgo);

		JComboBox comboBox = new JComboBox(new String[] { "Graph wählen" });
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Graph wählen", "Sample Graph 1", "Sample Tree 1" }));
		comboBox.setActionCommand(SELECT_GRAPH.toString());
		comboBox.addItemListener(mainWindowListener);
		comboBox.setBounds(463, 12, 170, 20);
		getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox(
				new String[] { "Algorithmus wählen" });
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {
				"Algorithmus wählen", "Depth-first search recursive",
				"Depth-last search recursive" }));
		comboBox_1.setActionCommand(SELECT_ALGORITHM.toString());
		comboBox_1.addItemListener(mainWindowListener);
		comboBox_1.setBounds(643, 12, 215, 20);
		getContentPane().add(comboBox_1);

		JButton btnNewButton_1 = new JButton("Berechnung starten");
		btnNewButton_1.setActionCommand(START_PROCESSING.toString());
		btnNewButton_1.addActionListener(mainWindowListener);
		btnNewButton_1.setBounds(10, 77, 218, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Graph löschen...");
		btnNewButton_2.setBounds(463, 45, 170, 23);
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.setActionCommand(DELETE_GRAPH.toString());
		btnNewButton_2.addActionListener(mainWindowListener);

		JButton btnNewButton_3 = new JButton("Algorithmus löschen...");
		btnNewButton_3.setBounds(643, 43, 215, 23);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.setActionCommand(DELETE_ALGORITHM.toString());
		btnNewButton_3.addActionListener(mainWindowListener);

		JButton btnNewButton_4 = new JButton("Beenden");
		btnNewButton_4.setBounds(706, 77, 152, 23);
		getContentPane().add(btnNewButton_4);
		btnNewButton_4.setActionCommand(EXIT_APPLICATION.toString());
		btnNewButton_4.addActionListener(mainWindowListener);

		JLabel lblNewLabel = new JLabel("Inkrement:");
		lblNewLabel.setBounds(654, 440, 88, 14);
		getContentPane().add(lblNewLabel);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(76, 440, 267, 14);
		getContentPane().add(progressBar);

		JLabel lblZeitintervall = new JLabel("Zeitintervall: ");
		lblZeitintervall.setBounds(463, 440, 82, 14);
		getContentPane().add(lblZeitintervall);

		JButton btnNewButton_5 = new JButton("Play");
		btnNewButton_5.setBounds(10, 476, 89, 23);
		getContentPane().add(btnNewButton_5);
		btnNewButton_5.setActionCommand(PLAY_ANIMATION.toString());
		btnNewButton_5.addActionListener(mainWindowListener);

		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(109, 476, 89, 23);
		getContentPane().add(btnPause);
		btnPause.setActionCommand(PAUSE_ANIMATION.toString());
		btnPause.addActionListener(mainWindowListener);

		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(208, 476, 89, 23);
		getContentPane().add(btnStop);
		btnStop.setActionCommand(STOP_ANIMATION.toString());
		btnStop.addActionListener(mainWindowListener);

		JButton btnAnfang = new JButton("Anfang");
		btnAnfang.setBounds(466, 476, 89, 23);
		getContentPane().add(btnAnfang);
		btnAnfang.setActionCommand(BEGINNING_ANIMATION.toString());
		btnAnfang.addActionListener(mainWindowListener);

		JButton btnZurck = new JButton("Zurück");
		btnZurck.setBounds(565, 476, 89, 23);
		getContentPane().add(btnZurck);
		btnZurck.setActionCommand(BACKWARD_ANIMATION.toString());
		btnZurck.addActionListener(mainWindowListener);

		JButton btnVor = new JButton("Vor");
		btnVor.setBounds(670, 476, 89, 23);
		getContentPane().add(btnVor);
		btnVor.setActionCommand(FORWARD_ANIMATION.toString());
		btnVor.addActionListener(mainWindowListener);

		JButton btnEnde = new JButton("Ende");
		btnEnde.setBounds(769, 476, 89, 23);
		getContentPane().add(btnEnde);
		btnEnde.setActionCommand(END_ANIMATION.toString());
		btnEnde.addActionListener(mainWindowListener);

		JLabel lblNewLabel_1 = new JLabel("Fortschritt: ");
		lblNewLabel_1.setBounds(12, 440, 75, 14);
		getContentPane().add(lblNewLabel_1);
		this.initialize();

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "2", "4",
				"8" }));
		comboBox_2.setBounds(555, 437, 89, 20);
		getContentPane().add(comboBox_2);
		comboBox_2.setActionCommand(TIME_INTERVALL.toString());
		comboBox_2.addItemListener(mainWindowListener);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "1", "5",
				"10" }));
		comboBox_3.setBounds(723, 437, 135, 20);
		getContentPane().add(comboBox_3);
		comboBox_3.setActionCommand(STEP_INCREMENT.toString());
		comboBox_3.addItemListener(mainWindowListener);

		JLabel lblSchrittVon = new JLabel("Schritt 1 von 100");
		lblSchrittVon.setBounds(353, 440, 100, 14);
		getContentPane().add(lblSchrittVon);

		JButton btnNewButton_6 = new JButton("Graph speichern...");
		btnNewButton_6.setBounds(10, 43, 218, 23);
		getContentPane().add(btnNewButton_6);
		btnNewButton_6.setActionCommand(SAVE_GRAPH.toString());
		btnNewButton_6.addActionListener(mainWindowListener);

		JButton btnNewButton_7 = new JButton("Graph exportieren...");
		btnNewButton_7.setBounds(238, 43, 215, 23);
		getContentPane().add(btnNewButton_7);
		btnNewButton_7.setActionCommand(EXPORT_GRAPH.toString());
		btnNewButton_7.addActionListener(mainWindowListener);

		// TODO add dynamic layout
		this.getContentPane().add(graphPanel);
		graphPanel.setBounds(20, 120, 800, 300);

		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 896, 570);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
