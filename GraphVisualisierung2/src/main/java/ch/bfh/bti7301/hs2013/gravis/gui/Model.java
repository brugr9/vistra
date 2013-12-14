package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.ResourceBundle;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.traversal.Traversal;
import ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource;
import ch.bfh.bti7301.hs2013.gravis.gui.control.animation.IAnimationStateHandler;
import ch.bfh.bti7301.hs2013.gravis.gui.control.parameter.IParameterStateHandler;
import ch.bfh.bti7301.hs2013.gravis.gui.control.stepbystep.IStepByStepStateHandler;

/**
 * A model as in MVC containing some fields and its getter and setter methods.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class Model extends Observable implements IModel {

	// Graph
	private IGravisGraph graph;
	private boolean graphSaved;
	private Traversal traversal;

	// action listener
	private ActionListener i18nListener;
	private ActionListener helpListener;
	private ActionListener aboutListener;
	private ActionListener quitListener;
	// state handler
	private IParameterStateHandler parameterStateHandler;
	private IAnimationStateHandler animationStateHandler;
	private IStepByStepStateHandler stepByStepStateHandler;

	// i18n
	private ResourceBundle resourceBundle;
	private boolean i18nEnabled;
	private boolean deDEEnabled;
	private boolean frFREnabled;
	private boolean enUSEnabled;

	// File
	private boolean fileEnabled;
	private boolean newMenuEnabled;
	private boolean undirectedGraphEnabled;
	private boolean directedGraphEnabled;
	private boolean openEnabled;
	private boolean saveEnabled;
	private boolean saveAsEnabled;
	private boolean algorithmMenuEnabled;
	private boolean importAlgorithmEnabled;
	private boolean deleteAlgorithmEnabled;
	private boolean importGraphEnabled;
	private boolean deleteGraphEnabled;
	private boolean quitEnabled;

	// Info
	private boolean infoEnabled;
	private boolean helpEnabled;
	private boolean aboutEnabled;

	// Algorithm
	private String[] algorithms;
	private boolean algorithmsEnabled;
	private int selectedAlgorithmIndex;
	private String algorithmDescription;

	// Player
	private int delay;
	private int steplength;
	private boolean delayEnabled;
	private boolean steplengthEnabled;
	private int progress;
	private int progressMaximum;

	private String pauseLabel;
	private EventSource pauseEvent;

	private boolean playEnabled;
	private boolean pauseEnabled;
	private boolean stopEnabled;

	private boolean toBeginningEnabled;
	private boolean backwardEnabled;
	private boolean forwardEnabled;
	private boolean toEndEnabled;

	// Protocol
	private StringBuilder stringBuilder;

	/**
	 * Main constructor.
	 * 
	 * @param graph
	 *            a graph
	 */
	public Model(IGravisGraph graph) {
		super();

		// graph
		this.graph = graph;
		this.graphSaved = false;
		this.traversal = null;

		// simple listener
		this.i18nListener = null;
		this.helpListener = null;
		this.aboutListener = null;
		this.quitListener = null;
		// state handler as listener
		this.parameterStateHandler = null;
		this.stepByStepStateHandler = null;
		this.animationStateHandler = null;

		// i18n
		this.resourceBundle = null;
		this.i18nEnabled = false;
		this.deDEEnabled = false;
		this.frFREnabled = false;
		this.enUSEnabled = false;

		// File
		this.fileEnabled = false;
		this.newMenuEnabled = false;
		this.undirectedGraphEnabled = false;
		this.directedGraphEnabled = false;
		this.openEnabled = false;
		this.saveEnabled = false;
		this.saveAsEnabled = false;
		this.algorithmMenuEnabled = false;
		this.importAlgorithmEnabled = false;
		this.deleteAlgorithmEnabled = false;
		this.quitEnabled = false;

		// Info
		this.infoEnabled = false;
		this.helpEnabled = false;
		this.aboutEnabled = false;

		// Parameter
		this.algorithms = null;
		this.algorithmsEnabled = false;
		this.selectedAlgorithmIndex = -1;
		this.algorithmDescription = " ";

		// Player
		this.delay = 1;
		this.steplength = 1;
		this.delayEnabled = false;
		this.steplengthEnabled = false;
		this.progress = 0;
		this.progressMaximum = 0;

		this.pauseLabel = "";
		this.pauseEvent = null;

		this.animationStateHandler = null;
		this.playEnabled = false;
		this.pauseEnabled = false;
		this.stopEnabled = false;

		this.stepByStepStateHandler = null;
		this.toBeginningEnabled = false;
		this.backwardEnabled = false;
		this.forwardEnabled = false;
		this.toEndEnabled = false;

		// Protocol
		this.stringBuilder = new StringBuilder();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setMenuEnabled(boolean)
	 */
	@Override
	public void setMenuEnabled(boolean menuEnabled) {
		// Menu
		this.setFileEnabled(menuEnabled);
		this.setI18nEnabled(menuEnabled);
		this.setInfoEnabled(menuEnabled);
		// MenuItem
		// (...)
		this.setNewMenuEnabled(menuEnabled);
		this.setUndirectedGraphEnabled(menuEnabled);
		this.setDirectedGraphEnabled(menuEnabled);
		this.setOpenEnabled(menuEnabled);
		this.setSaveEnabled(menuEnabled);
		this.setSaveAsEnabled(menuEnabled);
		this.setAlgorithmMenuEnabled(menuEnabled);
		this.setImportAlgorithmEnabled(menuEnabled);
		this.setDeleteAlgorithmEnabled(menuEnabled);
		this.setQuitEnabled(menuEnabled);
		// (...)
		this.setDeDEEnabled(menuEnabled);
		this.setFrFREnabled(menuEnabled);
		this.setEnUSEnabled(menuEnabled);
		// (...)
		this.setHelpEnabled(menuEnabled);
		this.setAboutEnabled(menuEnabled);

		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setPlayerEnabled(boolean)
	 */
	@Override
	public void setPlayerEnabled(boolean menuEnabled) {
		this.setSteplengthEnabled(menuEnabled);
		this.setDelayEnabled(menuEnabled);
		this.setAnimationEnabled(menuEnabled);
		this.setStepByStepEnabled(menuEnabled);

		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setAnimationEnabled(boolean)
	 */
	@Override
	public void setAnimationEnabled(boolean menuEnabled) {
		this.setPlayEnabled(menuEnabled);
		this.setPauseEnabled(menuEnabled);
		this.setStopEnabled(menuEnabled);

		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setStepByStepEnabled(boolean)
	 */
	@Override
	public void setStepByStepEnabled(boolean menuEnabled) {
		this.setToBeginningEnabled(menuEnabled);
		this.setBackwardEnabled(menuEnabled);
		this.setForwardEnabled(menuEnabled);
		this.setToEndEnabled(menuEnabled);

		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getGraph()
	 */
	@Override
	public IGravisGraph getGraph() {
		return graph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isGraphSaved()
	 */
	@Override
	public boolean isGraphSaved() {
		return graphSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getTraversal()
	 */
	@Override
	public Traversal getTraversal() {
		return traversal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getI18nListener()
	 */
	@Override
	public ActionListener getI18nListener() {
		return i18nListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getHelpListener()
	 */
	@Override
	public ActionListener getHelpListener() {
		return helpListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getAboutListener()
	 */
	@Override
	public ActionListener getAboutListener() {
		return aboutListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getQuitListener()
	 */
	@Override
	public ActionListener getQuitListener() {
		return quitListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getParameterStateHandler()
	 */
	@Override
	public IParameterStateHandler getParameterStateHandler() {
		return parameterStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getAnimationStateHandler()
	 */
	@Override
	public IAnimationStateHandler getAnimationStateHandler() {
		return animationStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getStepByStepStateHandler()
	 */
	@Override
	public IStepByStepStateHandler getStepByStepStateHandler() {
		return stepByStepStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getResourceBundle()
	 */
	@Override
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isI18nEnabled()
	 */
	@Override
	public boolean isI18nEnabled() {
		return i18nEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isDeDEEnabled()
	 */
	@Override
	public boolean isDeDEEnabled() {
		return deDEEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isFrFREnabled()
	 */
	@Override
	public boolean isFrFREnabled() {
		return frFREnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isEnUSEnabled()
	 */
	@Override
	public boolean isEnUSEnabled() {
		return enUSEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isFileEnabled()
	 */
	@Override
	public boolean isFileEnabled() {
		return fileEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isNewMenuEnabled()
	 */
	@Override
	public boolean isNewMenuEnabled() {
		return newMenuEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isUndirectedGraphEnabled()
	 */
	@Override
	public boolean isUndirectedGraphEnabled() {
		return undirectedGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isDirectedGraphEnabled()
	 */
	@Override
	public boolean isDirectedGraphEnabled() {
		return directedGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isOpenEnabled()
	 */
	@Override
	public boolean isOpenEnabled() {
		return openEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isSaveEnabled()
	 */
	@Override
	public boolean isSaveEnabled() {
		return saveEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isSaveAsEnabled()
	 */
	@Override
	public boolean isSaveAsEnabled() {
		return saveAsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isAlgorithmMenuEnabled()
	 */
	@Override
	public boolean isAlgorithmMenuEnabled() {
		return algorithmMenuEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isImportAlgorithmEnabled()
	 */
	@Override
	public boolean isImportAlgorithmEnabled() {
		return importAlgorithmEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isDeleteAlgorithmEnabled()
	 */
	@Override
	public boolean isDeleteAlgorithmEnabled() {
		return deleteAlgorithmEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isImportGraphEnabled()
	 */
	@Override
	public boolean isImportGraphEnabled() {
		return importGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isDeleteGraphEnabled()
	 */
	@Override
	public boolean isDeleteGraphEnabled() {
		return deleteGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isQuitEnabled()
	 */
	@Override
	public boolean isQuitEnabled() {
		return quitEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isInfoEnabled()
	 */
	@Override
	public boolean isInfoEnabled() {
		return infoEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isHelpEnabled()
	 */
	@Override
	public boolean isHelpEnabled() {
		return helpEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isAboutEnabled()
	 */
	@Override
	public boolean isAboutEnabled() {
		return aboutEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getAlgorithms()
	 */
	@Override
	public String[] getAlgorithms() {
		return algorithms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isAlgorithmsEnabled()
	 */
	@Override
	public boolean isAlgorithmsEnabled() {
		return algorithmsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getSelectedAlgorithmIndex()
	 */
	@Override
	public int getSelectedAlgorithmIndex() {
		return selectedAlgorithmIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getAlgorithmDescription()
	 */
	@Override
	public String getAlgorithmDescription() {
		return algorithmDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getDelay()
	 */
	@Override
	public int getDelay() {
		return delay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getSteplength()
	 */
	@Override
	public int getSteplength() {
		return steplength;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isDelayEnabled()
	 */
	@Override
	public boolean isDelayEnabled() {
		return delayEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isSteplengthEnabled()
	 */
	@Override
	public boolean isSteplengthEnabled() {
		return steplengthEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getProgress()
	 */
	@Override
	public int getProgress() {
		return progress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getProgressMaximum()
	 */
	@Override
	public int getProgressMaximum() {
		return progressMaximum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getPauseLabel()
	 */
	@Override
	public String getPauseLabel() {
		return pauseLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getPauseEvent()
	 */
	@Override
	public EventSource getPauseEvent() {
		return pauseEvent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isPlayEnabled()
	 */
	@Override
	public boolean isPlayEnabled() {
		return playEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isPauseEnabled()
	 */
	@Override
	public boolean isPauseEnabled() {
		return pauseEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isStopEnabled()
	 */
	@Override
	public boolean isStopEnabled() {
		return stopEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isToBeginningEnabled()
	 */
	@Override
	public boolean isToBeginningEnabled() {
		return toBeginningEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isBackwardEnabled()
	 */
	@Override
	public boolean isBackwardEnabled() {
		return backwardEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isForwardEnabled()
	 */
	@Override
	public boolean isForwardEnabled() {
		return forwardEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#isToEndEnabled()
	 */
	@Override
	public boolean isToEndEnabled() {
		return toEndEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#getStringBuilder()
	 */
	@Override
	public StringBuilder getStringBuilder() {
		return stringBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setGraph(ch.bfh.bti7301.hs2013
	 * .gravis.core.graph.IGravisGraph)
	 */
	@Override
	public void setGraph(IGravisGraph graph) {
		this.graph = graph;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setGraphSaved(boolean)
	 */
	@Override
	public void setGraphSaved(boolean graphSaved) {
		this.graphSaved = graphSaved;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setTraversal(ch.bfh.bti7301.hs2013
	 * .gravis.core.traversal.Traversal)
	 */
	@Override
	public void setTraversal(Traversal traversal) {
		this.traversal = traversal;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setI18nListener(java.awt.event
	 * .ActionListener)
	 */
	@Override
	public void setI18nListener(ActionListener i18nListener) {
		this.i18nListener = i18nListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setHelpListener(java.awt.event
	 * .ActionListener)
	 */
	@Override
	public void setHelpListener(ActionListener helpListener) {
		this.helpListener = helpListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setAboutListener(java.awt.event
	 * .ActionListener)
	 */
	@Override
	public void setAboutListener(ActionListener aboutListener) {
		this.aboutListener = aboutListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setQuitListener(java.awt.event
	 * .ActionListener)
	 */
	@Override
	public void setQuitListener(ActionListener quitListener) {
		this.quitListener = quitListener;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setParameterStateHandler(ch.bfh
	 * .bti7301.hs2013.gravis.gui.control.parameter.IParameterStateHandler)
	 */
	@Override
	public void setParameterStateHandler(
			IParameterStateHandler parameterStateHandler) {
		this.parameterStateHandler = parameterStateHandler;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setAnimationStateHandler(ch.bfh
	 * .bti7301.hs2013.gravis.gui.control.animation.IAnimationStateHandler)
	 */
	@Override
	public void setAnimationStateHandler(
			IAnimationStateHandler animationStateHandler) {
		this.animationStateHandler = animationStateHandler;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setStepByStepStateHandler(ch.bfh
	 * .bti7301.hs2013.gravis.gui.control.stepbystep.IStepByStepStateHandler)
	 */
	@Override
	public void setStepByStepStateHandler(
			IStepByStepStateHandler stepByStepStateHandler) {
		this.stepByStepStateHandler = stepByStepStateHandler;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setResourceBundle(java.util.
	 * ResourceBundle)
	 */
	@Override
	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setI18nEnabled(boolean)
	 */
	@Override
	public void setI18nEnabled(boolean i18nEnabled) {
		this.i18nEnabled = i18nEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setDeDEEnabled(boolean)
	 */
	@Override
	public void setDeDEEnabled(boolean deDEEnabled) {
		this.deDEEnabled = deDEEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setFrFREnabled(boolean)
	 */
	@Override
	public void setFrFREnabled(boolean frFREnabled) {
		this.frFREnabled = frFREnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setEnUSEnabled(boolean)
	 */
	@Override
	public void setEnUSEnabled(boolean enUSEnabled) {
		this.enUSEnabled = enUSEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setFileEnabled(boolean)
	 */
	@Override
	public void setFileEnabled(boolean fileEnabled) {
		this.fileEnabled = fileEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setNewMenuEnabled(boolean)
	 */
	@Override
	public void setNewMenuEnabled(boolean newMenuEnabled) {
		this.newMenuEnabled = newMenuEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setUndirectedGraphEnabled(boolean)
	 */
	@Override
	public void setUndirectedGraphEnabled(boolean undirectedGraphEnabled) {
		this.undirectedGraphEnabled = undirectedGraphEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setDirectedGraphEnabled(boolean)
	 */
	@Override
	public void setDirectedGraphEnabled(boolean directedGraphEnabled) {
		this.directedGraphEnabled = directedGraphEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setOpenEnabled(boolean)
	 */
	@Override
	public void setOpenEnabled(boolean openEnabled) {
		this.openEnabled = openEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setSaveEnabled(boolean)
	 */
	@Override
	public void setSaveEnabled(boolean saveEnabled) {
		this.saveEnabled = saveEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setSaveAsEnabled(boolean)
	 */
	@Override
	public void setSaveAsEnabled(boolean saveAsEnabled) {
		this.saveAsEnabled = saveAsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setAlgorithmMenuEnabled(boolean)
	 */
	@Override
	public void setAlgorithmMenuEnabled(boolean algorithmMenuEnabled) {
		this.algorithmMenuEnabled = algorithmMenuEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setImportAlgorithmEnabled(boolean)
	 */
	@Override
	public void setImportAlgorithmEnabled(boolean importAlgorithmEnabled) {
		this.importAlgorithmEnabled = importAlgorithmEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setDeleteAlgorithmEnabled(boolean)
	 */
	@Override
	public void setDeleteAlgorithmEnabled(boolean deleteAlgorithmEnabled) {
		this.deleteAlgorithmEnabled = deleteAlgorithmEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setImportGraphEnabled(boolean)
	 */
	@Override
	public void setImportGraphEnabled(boolean importGraphEnabled) {
		this.importGraphEnabled = importGraphEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setDeleteGraphEnabled(boolean)
	 */
	@Override
	public void setDeleteGraphEnabled(boolean deleteGraphEnabled) {
		this.deleteGraphEnabled = deleteGraphEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setQuitEnabled(boolean)
	 */
	@Override
	public void setQuitEnabled(boolean quitEnabled) {
		this.quitEnabled = quitEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setInfoEnabled(boolean)
	 */
	@Override
	public void setInfoEnabled(boolean infoEnabled) {
		this.infoEnabled = infoEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setHelpEnabled(boolean)
	 */
	@Override
	public void setHelpEnabled(boolean helpEnabled) {
		this.helpEnabled = helpEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setAboutEnabled(boolean)
	 */
	@Override
	public void setAboutEnabled(boolean aboutEnabled) {
		this.aboutEnabled = aboutEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setAlgorithms(java.lang.String[])
	 */
	@Override
	public void setAlgorithms(String[] algorithms) {
		this.algorithms = algorithms;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setAlgorithmsEnabled(boolean)
	 */
	@Override
	public void setAlgorithmsEnabled(boolean algorithmsEnabled) {
		this.algorithmsEnabled = algorithmsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setSelectedAlgorithmIndex(int)
	 */
	@Override
	public void setSelectedAlgorithmIndex(int selectedAlgorithmIndex) {
		this.selectedAlgorithmIndex = selectedAlgorithmIndex;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setAlgorithmDescription(java.lang
	 * .String)
	 */
	@Override
	public void setAlgorithmDescription(String algorithmDescription) {
		this.algorithmDescription = algorithmDescription;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setDelay(int)
	 */
	@Override
	public void setDelay(int delay) {
		this.delay = delay;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setSteplength(int)
	 */
	@Override
	public void setSteplength(int steplength) {
		this.steplength = steplength;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setDelayEnabled(boolean)
	 */
	@Override
	public void setDelayEnabled(boolean delayEnabled) {
		this.delayEnabled = delayEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setSteplengthEnabled(boolean)
	 */
	@Override
	public void setSteplengthEnabled(boolean steplengthEnabled) {
		this.steplengthEnabled = steplengthEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setProgress(int)
	 */
	@Override
	public void setProgress(int progress) {
		this.progress = progress;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setProgressMaximum(int)
	 */
	@Override
	public void setProgressMaximum(int progressMaximum) {
		this.progressMaximum = progressMaximum;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setPauseLabel(java.lang.String)
	 */
	@Override
	public void setPauseLabel(String pauseLabel) {
		this.pauseLabel = pauseLabel;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setPauseEvent(ch.bfh.bti7301.hs2013
	 * .gravis.gui.control.IControl.EventSource)
	 */
	@Override
	public void setPauseEvent(EventSource pauseEvent) {
		this.pauseEvent = pauseEvent;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setPlayEnabled(boolean)
	 */
	@Override
	public void setPlayEnabled(boolean playEnabled) {
		this.playEnabled = playEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setPauseEnabled(boolean)
	 */
	@Override
	public void setPauseEnabled(boolean pauseEnabled) {
		this.pauseEnabled = pauseEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setStopEnabled(boolean)
	 */
	@Override
	public void setStopEnabled(boolean stopEnabled) {
		this.stopEnabled = stopEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IMode#setToBeginningEnabled(boolean)
	 */
	@Override
	public void setToBeginningEnabled(boolean toBeginningEnabled) {
		this.toBeginningEnabled = toBeginningEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setBackwardEnabled(boolean)
	 */
	@Override
	public void setBackwardEnabled(boolean backwardEnabled) {
		this.backwardEnabled = backwardEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setForwardEnabled(boolean)
	 */
	@Override
	public void setForwardEnabled(boolean forwardEnabled) {
		this.forwardEnabled = forwardEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setToEndEnabled(boolean)
	 */
	@Override
	public void setToEndEnabled(boolean toEndEnabled) {
		this.toEndEnabled = toEndEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IMode#setStringBuilder(java.lang.
	 * StringBuilder)
	 */
	@Override
	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
		this.setChanged();
	}

}
