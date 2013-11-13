package ch.bfh.bti7301.hs2013.gravis.gui;

import java.util.Observable;
import java.util.ResourceBundle;
import javax.swing.KeyStroke;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource;

/**
 * A model as in MVC containing some fields and its getter and setter methods.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class Model extends Observable implements IModel {

	// gravis
	private IGravisGraph graph;
	// private IGravisListIterator<ICommand> traversal;

	// i18n
	private String i18nBaseName;
	private ResourceBundle resourceBundle;

	// Menu
	private boolean fileEnabled;
	private boolean i18nEnabled;
	private boolean deDEEnabled;
	private boolean frFREnabled;
	private boolean enUSEnabled;
	private boolean infoEnabled;
	private boolean helpEnabled;
	private boolean aboutEnabled;
	private boolean quitEnabled;

	// IO
	private boolean importAlgorithmEnabled;
	private boolean deleteAlgorithmEnabled;
	private boolean importGraphEnabled;
	private boolean deleteGraphEnabled;

	// Parameter
	private String[] graphs;
	private String[] algorithms;
	private boolean graphsEnabled;
	private boolean algorithmsEnabled;
	private int selectedGraph;
	private int selectedAlgorithm;

	// Player
	private int delay;
	private int steplength;
	private boolean delayEnabled;
	private boolean steplengthEnabled;
	private int progress;
	private int progressMaximum;

	private String pauseLabel;
	private KeyStroke pauseAccelerator;
	private EventSource pauseEvent;

	private boolean playEnabled;
	private boolean pauseEnabled;
	private boolean stopEnabled;

	private boolean toBeginningEnabled;
	private boolean backwardEnabled;
	private boolean forwardEnabled;
	private boolean toEndEnabled;

	// Protocol
	private String protocol;

	/**
	 * Main constructor.
	 * 
	 * @param i18nBaseName
	 *            an i18n base name
	 */
	public Model(String i18nBaseName) {
		super();

		this.graph = null;

		// i18n
		this.i18nBaseName = i18nBaseName;
		this.resourceBundle = null;

		// Menu
		this.fileEnabled = false;
		this.i18nEnabled = false;
		this.deDEEnabled = false;
		this.frFREnabled = false;
		this.enUSEnabled = false;
		this.infoEnabled = false;
		this.helpEnabled = false;
		this.aboutEnabled = false;
		this.quitEnabled = false;

		// IO
		this.importAlgorithmEnabled = false;
		this.deleteAlgorithmEnabled = false;
		this.importGraphEnabled = false;
		this.deleteGraphEnabled = false;

		// Parameter
		this.graphs = null;
		this.algorithms = null;
		this.graphsEnabled = false;
		this.algorithmsEnabled = false;
		this.selectedGraph = 0;
		this.selectedAlgorithm = 0;

		// Player
		this.delay = 1;
		this.steplength = 1;
		this.delayEnabled = false;
		this.steplengthEnabled = false;
		this.progress = 0;
		this.progressMaximum = 0;

		this.pauseLabel = "";
		this.pauseAccelerator = null;
		this.pauseEvent = null;

		this.playEnabled = false;
		this.pauseEnabled = false;
		this.stopEnabled = false;

		this.toBeginningEnabled = false;
		this.backwardEnabled = false;
		this.forwardEnabled = false;
		this.toEndEnabled = false;

		// Protocol
		this.protocol = "";

	}

	/**
	 * Disables or enables menu elements.
	 * 
	 * @param enabled
	 */
	@Override
	public void setMenuEnabled(boolean enabled) {
		// Menu
		this.setFileEnabled(enabled);
		this.setI18nEnabled(enabled);
		this.setInfoEnabled(enabled);
		// MenuItem
		// (...)
		this.setImportAlgorithmEnabled(enabled);
		this.setDeleteAlgorithmEnabled(enabled);
		this.setImportGraphEnabled(enabled);
		this.setDeleteGraphEnabled(enabled);
		this.setQuitEnabled(enabled);
		// (...)
		this.setDeDEEnabled(enabled);
		this.setFrFREnabled(enabled);
		this.setEnUSEnabled(enabled);
		// (...)
		this.setHelpEnabled(enabled);
		this.setAboutEnabled(enabled);

		this.setChanged();
	}

	/**
	 * Disables or enables parameter elements.
	 * 
	 * @param enabled
	 */
	@Override
	public void setParameterEnabled(boolean enabled) {
		this.setGraphsEnabled(enabled);
		this.setAlgorithmsEnabled(enabled);

		this.setChanged();
	}

	/**
	 * Disables or enables player elements.
	 * 
	 * @param enabled
	 */
	@Override
	public void setPlayerEnabled(boolean enabled) {
		this.setSteplengthEnabled(enabled);
		this.setDelayEnabled(enabled);
		this.setPlayEnabled(enabled);
		this.setPauseEnabled(enabled);
		this.setStopEnabled(enabled);
		this.setStepByStepEnabled(enabled);

		this.setChanged();
	}

	/**
	 * Disables or enables the players step-by-step elements.
	 * 
	 * @param enabled
	 */
	@Override
	public void setStepByStepEnabled(boolean enabled) {
		this.setToBeginningEnabled(enabled);
		this.setBackwardEnabled(enabled);
		this.setForwardEnabled(enabled);
		this.setToEndEnabled(enabled);

		this.setChanged();
	}

	/**
	 * @return the graph
	 */
	protected IGravisGraph getGraph() {
		return graph;
	}

	/**
	 * @return the i18nBaseName
	 */
	protected String getI18nBaseName() {
		return i18nBaseName;
	}

	/**
	 * @return the resourceBundle
	 */
	protected ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/**
	 * @return the fileEnabled
	 */
	protected boolean isFileEnabled() {
		return fileEnabled;
	}

	/**
	 * @return the i18nEnabled
	 */
	protected boolean isI18nEnabled() {
		return i18nEnabled;
	}

	/**
	 * @return the deDEEnabled
	 */
	protected boolean isDeDEEnabled() {
		return deDEEnabled;
	}

	/**
	 * @return the frFREnabled
	 */
	protected boolean isFrFREnabled() {
		return frFREnabled;
	}

	/**
	 * @return the enUSEnabled
	 */
	protected boolean isEnUSEnabled() {
		return enUSEnabled;
	}

	/**
	 * @return the infoEnabled
	 */
	protected boolean isInfoEnabled() {
		return infoEnabled;
	}

	/**
	 * @return the helpEnabled
	 */
	protected boolean isHelpEnabled() {
		return helpEnabled;
	}

	/**
	 * @return the aboutEnabled
	 */
	protected boolean isAboutEnabled() {
		return aboutEnabled;
	}

	/**
	 * @return the quitEnabled
	 */
	protected boolean isQuitEnabled() {
		return quitEnabled;
	}

	/**
	 * @return the importAlgorithmEnabled
	 */
	protected boolean isImportAlgorithmEnabled() {
		return importAlgorithmEnabled;
	}

	/**
	 * @return the deleteAlgorithmEnabled
	 */
	protected boolean isDeleteAlgorithmEnabled() {
		return deleteAlgorithmEnabled;
	}

	/**
	 * @return the importGraphEnabled
	 */
	protected boolean isImportGraphEnabled() {
		return importGraphEnabled;
	}

	/**
	 * @return the deleteGraphEnabled
	 */
	protected boolean isDeleteGraphEnabled() {
		return deleteGraphEnabled;
	}

	/**
	 * @return the graphs
	 */
	protected String[] getGraphs() {
		return graphs;
	}

	/**
	 * @return the algorithms
	 */
	protected String[] getAlgorithms() {
		return algorithms;
	}

	/**
	 * @return the graphsEnabled
	 */
	protected boolean isGraphsEnabled() {
		return graphsEnabled;
	}

	/**
	 * @return the algorithmsEnabled
	 */
	protected boolean isAlgorithmsEnabled() {
		return algorithmsEnabled;
	}

	/**
	 * @return the selectedGraph
	 */
	protected int getSelectedGraph() {
		return selectedGraph;
	}

	/**
	 * @return the selectedAlgorithm
	 */
	protected int getSelectedAlgorithm() {
		return selectedAlgorithm;
	}

	/**
	 * @return the delay
	 */
	protected int getDelay() {
		return delay;
	}

	/**
	 * @return the steplength
	 */
	protected int getSteplength() {
		return steplength;
	}

	/**
	 * @return the delayEnabled
	 */
	protected boolean isDelayEnabled() {
		return delayEnabled;
	}

	/**
	 * @return the steplengthEnabled
	 */
	protected boolean isSteplengthEnabled() {
		return steplengthEnabled;
	}

	/**
	 * @return the progress
	 */
	protected int getProgress() {
		return progress;
	}

	/**
	 * @return the progressMaximum
	 */
	protected int getProgressMaximum() {
		return progressMaximum;
	}

	/**
	 * @return the pauseLabel
	 */
	protected String getPauseLabel() {
		return pauseLabel;
	}

	/**
	 * @return the pauseAccelerator
	 */
	protected KeyStroke getPauseAccelerator() {
		return pauseAccelerator;
	}

	/**
	 * @return the pauseEvent
	 */
	protected EventSource getPauseEvent() {
		return pauseEvent;
	}

	/**
	 * @return the playEnabled
	 */
	protected boolean isPlayEnabled() {
		return playEnabled;
	}

	/**
	 * @return the pauseEnabled
	 */
	protected boolean isPauseEnabled() {
		return pauseEnabled;
	}

	/**
	 * @return the stopEnabled
	 */
	protected boolean isStopEnabled() {
		return stopEnabled;
	}

	/**
	 * @return the toBeginningEnabled
	 */
	protected boolean isToBeginningEnabled() {
		return toBeginningEnabled;
	}

	/**
	 * @return the backwardEnabled
	 */
	protected boolean isBackwardEnabled() {
		return backwardEnabled;
	}

	/**
	 * @return the forwardEnabled
	 */
	protected boolean isForwardEnabled() {
		return forwardEnabled;
	}

	/**
	 * @return the toEndEnabled
	 */
	protected boolean isToEndEnabled() {
		return toEndEnabled;
	}

	/**
	 * @return the protocol
	 */
	protected String getProtocol() {
		return protocol;
	}

	/**
	 * @param graph
	 *            the graph to set
	 */
	protected void setGraph(IGravisGraph graph) {
		this.graph = graph;
		this.setChanged();
	}

	/**
	 * @param i18nBaseName
	 *            the i18nBaseName to set
	 */
	protected void setI18nBaseName(String i18nBaseName) {
		this.i18nBaseName = i18nBaseName;
		this.setChanged();
	}

	/**
	 * @param resourceBundle
	 *            the resourceBundle to set
	 */
	protected void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.setChanged();
	}

	/**
	 * @param fileEnabled
	 *            the fileEnabled to set
	 */
	protected void setFileEnabled(boolean fileEnabled) {
		this.fileEnabled = fileEnabled;
		this.setChanged();
	}

	/**
	 * @param i18nEnabled
	 *            the i18nEnabled to set
	 */
	protected void setI18nEnabled(boolean i18nEnabled) {
		this.i18nEnabled = i18nEnabled;
		this.setChanged();
	}

	/**
	 * @param deDEEnabled
	 *            the deDEEnabled to set
	 */
	protected void setDeDEEnabled(boolean deDEEnabled) {
		this.deDEEnabled = deDEEnabled;
		this.setChanged();
	}

	/**
	 * @param frFREnabled
	 *            the frFREnabled to set
	 */
	protected void setFrFREnabled(boolean frFREnabled) {
		this.frFREnabled = frFREnabled;
		this.setChanged();
	}

	/**
	 * @param enUSEnabled
	 *            the enUSEnabled to set
	 */
	protected void setEnUSEnabled(boolean enUSEnabled) {
		this.enUSEnabled = enUSEnabled;
		this.setChanged();
	}

	/**
	 * @param infoEnabled
	 *            the infoEnabled to set
	 */
	protected void setInfoEnabled(boolean infoEnabled) {
		this.infoEnabled = infoEnabled;
		this.setChanged();
	}

	/**
	 * @param helpEnabled
	 *            the helpEnabled to set
	 */
	protected void setHelpEnabled(boolean helpEnabled) {
		this.helpEnabled = helpEnabled;
		this.setChanged();
	}

	/**
	 * @param aboutEnabled
	 *            the aboutEnabled to set
	 */
	protected void setAboutEnabled(boolean aboutEnabled) {
		this.aboutEnabled = aboutEnabled;
		this.setChanged();
	}

	/**
	 * @param quitEnabled
	 *            the quitEnabled to set
	 */
	protected void setQuitEnabled(boolean quitEnabled) {
		this.quitEnabled = quitEnabled;
		this.setChanged();
	}

	/**
	 * @param importAlgorithmEnabled
	 *            the importAlgorithmEnabled to set
	 */
	protected void setImportAlgorithmEnabled(boolean importAlgorithmEnabled) {
		this.importAlgorithmEnabled = importAlgorithmEnabled;
		this.setChanged();
	}

	/**
	 * @param deleteAlgorithmEnabled
	 *            the deleteAlgorithmEnabled to set
	 */
	protected void setDeleteAlgorithmEnabled(boolean deleteAlgorithmEnabled) {
		this.deleteAlgorithmEnabled = deleteAlgorithmEnabled;
		this.setChanged();
	}

	/**
	 * @param importGraphEnabled
	 *            the importGraphEnabled to set
	 */
	protected void setImportGraphEnabled(boolean importGraphEnabled) {
		this.importGraphEnabled = importGraphEnabled;
		this.setChanged();
	}

	/**
	 * @param deleteGraphEnabled
	 *            the deleteGraphEnabled to set
	 */
	protected void setDeleteGraphEnabled(boolean deleteGraphEnabled) {
		this.deleteGraphEnabled = deleteGraphEnabled;
		this.setChanged();
	}

	/**
	 * @param graphs
	 *            the graphs to set
	 */
	protected void setGraphs(String[] graphs) {
		this.graphs = graphs;
		this.setChanged();
	}

	/**
	 * @param algorithms
	 *            the algorithms to set
	 */
	protected void setAlgorithms(String[] algorithms) {
		this.algorithms = algorithms;
		this.setChanged();
	}

	/**
	 * @param graphsEnabled
	 *            the graphsEnabled to set
	 */
	protected void setGraphsEnabled(boolean graphsEnabled) {
		this.graphsEnabled = graphsEnabled;
		this.setChanged();
	}

	/**
	 * @param algorithmsEnabled
	 *            the algorithmsEnabled to set
	 */
	protected void setAlgorithmsEnabled(boolean algorithmsEnabled) {
		this.algorithmsEnabled = algorithmsEnabled;
		this.setChanged();
	}

	/**
	 * @param selectedGraph
	 *            the selectedGraph to set
	 */
	protected void setSelectedGraph(int selectedGraph) {
		this.selectedGraph = selectedGraph;
		this.setChanged();
	}

	/**
	 * @param selectedAlgorithm
	 *            the selectedAlgorithm to set
	 */
	protected void setSelectedAlgorithm(int selectedAlgorithm) {
		this.selectedAlgorithm = selectedAlgorithm;
		this.setChanged();
	}

	/**
	 * @param delay
	 *            the delay to set
	 */
	protected void setDelay(int delay) {
		this.delay = delay;
		this.setChanged();
	}

	/**
	 * @param steplength
	 *            the steplength to set
	 */
	protected void setSteplength(int steplength) {
		this.steplength = steplength;
		this.setChanged();
	}

	/**
	 * @param delayEnabled
	 *            the delayEnabled to set
	 */
	protected void setDelayEnabled(boolean delayEnabled) {
		this.delayEnabled = delayEnabled;
		this.setChanged();
	}

	/**
	 * @param steplengthEnabled
	 *            the steplengthEnabled to set
	 */
	protected void setSteplengthEnabled(boolean steplengthEnabled) {
		this.steplengthEnabled = steplengthEnabled;
		this.setChanged();
	}

	/**
	 * @param progress
	 *            the progress to set
	 */
	protected void setProgress(int progress) {
		this.progress = progress;
		this.setChanged();
	}

	/**
	 * @param progressMaximum
	 *            the progressMaximum to set
	 */
	protected void setProgressMaximum(int progressMaximum) {
		this.progressMaximum = progressMaximum;
		this.setChanged();
	}

	/**
	 * @param pauseLabel
	 *            the pauseLabel to set
	 */
	protected void setPauseLabel(String pauseLabel) {
		this.pauseLabel = pauseLabel;
		this.setChanged();
	}

	/**
	 * @param pauseAccelerator
	 *            the pauseAccelerator to set
	 */
	protected void setPauseAccelerator(KeyStroke pauseAccelerator) {
		this.pauseAccelerator = pauseAccelerator;
		this.setChanged();
	}

	/**
	 * @param pauseEvent
	 *            the pauseEvent to set
	 */
	protected void setPauseEvent(EventSource pauseEvent) {
		this.pauseEvent = pauseEvent;
		this.setChanged();
	}

	/**
	 * @param playEnabled
	 *            the playEnabled to set
	 */
	protected void setPlayEnabled(boolean playEnabled) {
		this.playEnabled = playEnabled;
		this.setChanged();
	}

	/**
	 * @param pauseEnabled
	 *            the pauseEnabled to set
	 */
	protected void setPauseEnabled(boolean pauseEnabled) {
		this.pauseEnabled = pauseEnabled;
		this.setChanged();
	}

	/**
	 * @param stopEnabled
	 *            the stopEnabled to set
	 */
	protected void setStopEnabled(boolean stopEnabled) {
		this.stopEnabled = stopEnabled;
		this.setChanged();
	}

	/**
	 * @param toBeginningEnabled
	 *            the toBeginningEnabled to set
	 */
	protected void setToBeginningEnabled(boolean toBeginningEnabled) {
		this.toBeginningEnabled = toBeginningEnabled;
		this.setChanged();
	}

	/**
	 * @param backwardEnabled
	 *            the backwardEnabled to set
	 */
	protected void setBackwardEnabled(boolean backwardEnabled) {
		this.backwardEnabled = backwardEnabled;
		this.setChanged();
	}

	/**
	 * @param forwardEnabled
	 *            the forwardEnabled to set
	 */
	protected void setForwardEnabled(boolean forwardEnabled) {
		this.forwardEnabled = forwardEnabled;
		this.setChanged();
	}

	/**
	 * @param toEndEnabled
	 *            the toEndEnabled to set
	 */
	protected void setToEndEnabled(boolean toEndEnabled) {
		this.toEndEnabled = toEndEnabled;
		this.setChanged();
	}

	/**
	 * @param protocol
	 *            the protocol to set
	 */
	protected void setProtocol(String protocol) {
		this.protocol = protocol;
		this.setChanged();
	}

}
