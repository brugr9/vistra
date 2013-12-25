package vistra.gui;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.ResourceBundle;

import vistra.core.graph.IExtendedGraph;
import vistra.core.traversal.Traversal;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.control.animation.IAnimationStateHandler;
import vistra.gui.control.parameter.IParameterStateHandler;
import vistra.gui.control.stepbystep.ISbsStateHandler;

/**
 * A model as in MVC holding some fields and its getter and setter methods.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GuiModel extends Observable implements IGuiModel {

	/* Menu */
	// Action listener
	private ActionListener i18nListener;
	private ActionListener helpListener;
	private ActionListener aboutListener;
	private ActionListener quitListener;
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
	private boolean openGraphEnabled;
	private boolean saveGraphEnabled;
	private boolean saveGraphAsEnabled;
	private boolean algorithmMenuEnabled;
	private boolean importAlgorithmEnabled;
	private boolean deleteAlgorithmEnabled;
	private boolean quitEnabled;
	// Info
	private boolean infoEnabled;
	private boolean helpEnabled;
	private boolean aboutEnabled;

	/* Parameter */
	private IParameterStateHandler parameterStateHandler;
	// Graph
	private IExtendedGraph graph;
	private boolean editGraphEnabled;
	private boolean graphSaved;
	// Algorithm
	private String[] algorithms;
	private boolean algorithmsEnabled;
	private int selectedAlgorithmIndex;
	private String algorithmDescription;

	/* Traversal */
	private Traversal traversal;
	private int progress;
	private int progressMaximum;
	// Step-by-Step
	private ISbsStateHandler stepByStepStateHandler;
	private int steplength;
	private boolean steplengthEnabled;
	private boolean toBeginningEnabled;
	private boolean backwardEnabled;
	private boolean forwardEnabled;
	private boolean toEndEnabled;
	// Animation
	private IAnimationStateHandler animationStateHandler;
	private int delay;
	private boolean delayEnabled;
	private boolean playEnabled;
	private String pauseLabel;
	private EventSource pauseEvent;
	private boolean pauseEnabled;
	private boolean stopEnabled;

	// Protocol
	private StringBuilder stringBuilder;

	/**
	 * Main constructor.
	 * 
	 * @param graph
	 *            an observable gravis graph
	 */
	public GuiModel(IExtendedGraph graph) {
		super();

		/* Menu */
		// Action listener
		this.i18nListener = null;
		this.helpListener = null;
		this.aboutListener = null;
		this.quitListener = null;
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
		this.openGraphEnabled = false;
		this.saveGraphEnabled = false;
		this.saveGraphAsEnabled = false;
		this.editGraphEnabled = false;
		this.algorithmMenuEnabled = false;
		this.importAlgorithmEnabled = false;
		this.deleteAlgorithmEnabled = false;
		this.quitEnabled = false;
		// Info
		this.infoEnabled = false;
		this.helpEnabled = false;
		this.aboutEnabled = false;

		/* Parameter */
		this.parameterStateHandler = null;
		// Graph
		this.graph = graph;
		this.editGraphEnabled = false;
		this.graphSaved = false;
		// Algorithm
		this.algorithms = null;
		this.algorithmsEnabled = false;
		this.selectedAlgorithmIndex = 0;
		this.algorithmDescription = " ";

		/* Traversal */
		this.traversal = null;
		this.progress = 0;
		this.progressMaximum = 0;
		// Step-by-Step
		this.stepByStepStateHandler = null;
		this.steplength = 1;
		this.steplengthEnabled = false;
		this.toBeginningEnabled = false;
		this.backwardEnabled = false;
		this.forwardEnabled = false;
		this.toEndEnabled = false;
		// Animation
		this.animationStateHandler = null;
		this.delay = 1;
		this.delayEnabled = false;
		this.playEnabled = false;
		this.pauseLabel = "";
		this.pauseEvent = null;
		this.pauseEnabled = false;
		this.stopEnabled = false;

		/* Protocol */
		this.stringBuilder = new StringBuilder();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setMenuEnabled(boolean)
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
		this.setOpenGraphEnabled(menuEnabled);
		this.setSaveGraphEnabled(menuEnabled);
		this.setSaveGraphAsEnabled(menuEnabled);
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
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setPlayerEnabled(boolean)
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
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setAnimationEnabled(boolean)
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
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setStepByStepEnabled(boolean)
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
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getI18nListener()
	 */
	@Override
	public ActionListener getI18nListener() {
		return i18nListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getHelpListener()
	 */
	@Override
	public ActionListener getHelpListener() {
		return helpListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getAboutListener()
	 */
	@Override
	public ActionListener getAboutListener() {
		return aboutListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getQuitListener()
	 */
	@Override
	public ActionListener getQuitListener() {
		return quitListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getResourceBundle()
	 */
	@Override
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isI18nEnabled()
	 */
	@Override
	public boolean isI18nEnabled() {
		return i18nEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isDeDEEnabled()
	 */
	@Override
	public boolean isDeDEEnabled() {
		return deDEEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isFrFREnabled()
	 */
	@Override
	public boolean isFrFREnabled() {
		return frFREnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isEnUSEnabled()
	 */
	@Override
	public boolean isEnUSEnabled() {
		return enUSEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isFileEnabled()
	 */
	@Override
	public boolean isFileEnabled() {
		return fileEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isNewMenuEnabled()
	 */
	@Override
	public boolean isNewMenuEnabled() {
		return newMenuEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isUndirectedGraphEnabled()
	 */
	@Override
	public boolean isUndirectedGraphEnabled() {
		return undirectedGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isDirectedGraphEnabled()
	 */
	@Override
	public boolean isDirectedGraphEnabled() {
		return directedGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isOpenGraphEnabled()
	 */
	@Override
	public boolean isOpenGraphEnabled() {
		return openGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isSaveGraphEnabled()
	 */
	@Override
	public boolean isSaveGraphEnabled() {
		return saveGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isSaveGraphAsEnabled()
	 */
	@Override
	public boolean isSaveGraphAsEnabled() {
		return saveGraphAsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isAlgorithmMenuEnabled()
	 */
	@Override
	public boolean isAlgorithmMenuEnabled() {
		return algorithmMenuEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isImportAlgorithmEnabled()
	 */
	@Override
	public boolean isImportAlgorithmEnabled() {
		return importAlgorithmEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isDeleteAlgorithmEnabled()
	 */
	@Override
	public boolean isDeleteAlgorithmEnabled() {
		return deleteAlgorithmEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isQuitEnabled()
	 */
	@Override
	public boolean isQuitEnabled() {
		return quitEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isInfoEnabled()
	 */
	@Override
	public boolean isInfoEnabled() {
		return infoEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isHelpEnabled()
	 */
	@Override
	public boolean isHelpEnabled() {
		return helpEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isAboutEnabled()
	 */
	@Override
	public boolean isAboutEnabled() {
		return aboutEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getParameterStateHandler()
	 */
	@Override
	public IParameterStateHandler getParameterStateHandler() {
		return parameterStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getGraph()
	 */
	@Override
	public IExtendedGraph getGraph() {
		return graph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isEditGraphEnabled()
	 */
	@Override
	public boolean isEditGraphEnabled() {
		return editGraphEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isGraphSaved()
	 */
	@Override
	public boolean isGraphSaved() {
		return graphSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getAlgorithms()
	 */
	@Override
	public String[] getAlgorithms() {
		return algorithms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isAlgorithmsEnabled()
	 */
	@Override
	public boolean isAlgorithmsEnabled() {
		return algorithmsEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getSelectedAlgorithmIndex()
	 */
	@Override
	public int getSelectedAlgorithmIndex() {
		return selectedAlgorithmIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getAlgorithmDescription()
	 */
	@Override
	public String getAlgorithmDescription() {
		return algorithmDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getTraversal()
	 */
	@Override
	public Traversal getTraversal() {
		return traversal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getProgress()
	 */
	@Override
	public int getProgress() {
		return progress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getProgressMaximum()
	 */
	@Override
	public int getProgressMaximum() {
		return progressMaximum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getStepByStepStateHandler()
	 */
	@Override
	public ISbsStateHandler getStepByStepStateHandler() {
		return stepByStepStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getSteplength()
	 */
	@Override
	public int getSteplength() {
		return steplength;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isSteplengthEnabled()
	 */
	@Override
	public boolean isSteplengthEnabled() {
		return steplengthEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isToBeginningEnabled()
	 */
	@Override
	public boolean isToBeginningEnabled() {
		return toBeginningEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isBackwardEnabled()
	 */
	@Override
	public boolean isBackwardEnabled() {
		return backwardEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isForwardEnabled()
	 */
	@Override
	public boolean isForwardEnabled() {
		return forwardEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isToEndEnabled()
	 */
	@Override
	public boolean isToEndEnabled() {
		return toEndEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getAnimationStateHandler()
	 */
	@Override
	public IAnimationStateHandler getAnimationStateHandler() {
		return animationStateHandler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getDelay()
	 */
	@Override
	public int getDelay() {
		return delay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isDelayEnabled()
	 */
	@Override
	public boolean isDelayEnabled() {
		return delayEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isPlayEnabled()
	 */
	@Override
	public boolean isPlayEnabled() {
		return playEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getPauseLabel()
	 */
	@Override
	public String getPauseLabel() {
		return pauseLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getPauseEvent()
	 */
	@Override
	public EventSource getPauseEvent() {
		return pauseEvent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isPauseEnabled()
	 */
	@Override
	public boolean isPauseEnabled() {
		return pauseEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#isStopEnabled()
	 */
	@Override
	public boolean isStopEnabled() {
		return stopEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#getStringBuilder()
	 */
	@Override
	public StringBuilder getStringBuilder() {
		return stringBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setI18nListener(java.awt.event
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setHelpListener(java.awt.event
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setAboutListener(java.awt.event
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setQuitListener(java.awt.event
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
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setResourceBundle(java.util.
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
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setI18nEnabled(boolean)
	 */
	@Override
	public void setI18nEnabled(boolean i18nEnabled) {
		this.i18nEnabled = i18nEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setDeDEEnabled(boolean)
	 */
	@Override
	public void setDeDEEnabled(boolean deDEEnabled) {
		this.deDEEnabled = deDEEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setFrFREnabled(boolean)
	 */
	@Override
	public void setFrFREnabled(boolean frFREnabled) {
		this.frFREnabled = frFREnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setEnUSEnabled(boolean)
	 */
	@Override
	public void setEnUSEnabled(boolean enUSEnabled) {
		this.enUSEnabled = enUSEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setFileEnabled(boolean)
	 */
	@Override
	public void setFileEnabled(boolean fileEnabled) {
		this.fileEnabled = fileEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setNewMenuEnabled(boolean)
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setUndirectedGraphEnabled(boolean
	 * )
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setDirectedGraphEnabled(boolean)
	 */
	@Override
	public void setDirectedGraphEnabled(boolean directedGraphEnabled) {
		this.directedGraphEnabled = directedGraphEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setOpenGraphEnabled(boolean)
	 */
	@Override
	public void setOpenGraphEnabled(boolean openGraphEnabled) {
		this.openGraphEnabled = openGraphEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setSaveGraphEnabled(boolean)
	 */
	@Override
	public void setSaveGraphEnabled(boolean saveGraphEnabled) {
		this.saveGraphEnabled = saveGraphEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setSaveGraphAsEnabled(boolean)
	 */
	@Override
	public void setSaveGraphAsEnabled(boolean saveGraphAsEnabled) {
		this.saveGraphAsEnabled = saveGraphAsEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setAlgorithmMenuEnabled(boolean)
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setImportAlgorithmEnabled(boolean
	 * )
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setDeleteAlgorithmEnabled(boolean
	 * )
	 */
	@Override
	public void setDeleteAlgorithmEnabled(boolean deleteAlgorithmEnabled) {
		this.deleteAlgorithmEnabled = deleteAlgorithmEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setQuitEnabled(boolean)
	 */
	@Override
	public void setQuitEnabled(boolean quitEnabled) {
		this.quitEnabled = quitEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setInfoEnabled(boolean)
	 */
	@Override
	public void setInfoEnabled(boolean infoEnabled) {
		this.infoEnabled = infoEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setHelpEnabled(boolean)
	 */
	@Override
	public void setHelpEnabled(boolean helpEnabled) {
		this.helpEnabled = helpEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setAboutEnabled(boolean)
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setParameterStateHandler(ch.bfh
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setGraph(ch.bfh.bti7301.hs2013
	 * .gravis.core.graph.IObservableGravisGraph)
	 */
	@Override
	public void setGraph(IExtendedGraph graph) {
		this.graph = graph;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setEditGraphEnabled(boolean)
	 */
	@Override
	public void setEditGraphEnabled(boolean editGraphEnabled) {
		this.editGraphEnabled = editGraphEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setGraphSaved(boolean)
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setAlgorithms(java.lang.String[])
	 */
	@Override
	public void setAlgorithms(String[] algorithms) {
		this.algorithms = algorithms;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setAlgorithmsEnabled(boolean)
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setSelectedAlgorithmIndex(int)
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setAlgorithmDescription(java.
	 * lang.String)
	 */
	@Override
	public void setAlgorithmDescription(String algorithmDescription) {
		this.algorithmDescription = algorithmDescription;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setTraversal(ch.bfh.bti7301.hs2013
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
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setProgress(int)
	 */
	@Override
	public void setProgress(int progress) {
		this.progress = progress;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setProgressMaximum(int)
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setStepByStepStateHandler(ch.
	 * bfh.bti7301.hs2013.gravis.gui.control.stepbystep.IStepByStepStateHandler)
	 */
	@Override
	public void setStepByStepStateHandler(
			ISbsStateHandler stepByStepStateHandler) {
		this.stepByStepStateHandler = stepByStepStateHandler;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setSteplength(int)
	 */
	@Override
	public void setSteplength(int steplength) {
		this.steplength = steplength;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setSteplengthEnabled(boolean)
	 */
	@Override
	public void setSteplengthEnabled(boolean steplengthEnabled) {
		this.steplengthEnabled = steplengthEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setToBeginningEnabled(boolean)
	 */
	@Override
	public void setToBeginningEnabled(boolean toBeginningEnabled) {
		this.toBeginningEnabled = toBeginningEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setBackwardEnabled(boolean)
	 */
	@Override
	public void setBackwardEnabled(boolean backwardEnabled) {
		this.backwardEnabled = backwardEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setForwardEnabled(boolean)
	 */
	@Override
	public void setForwardEnabled(boolean forwardEnabled) {
		this.forwardEnabled = forwardEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setToEndEnabled(boolean)
	 */
	@Override
	public void setToEndEnabled(boolean toEndEnabled) {
		this.toEndEnabled = toEndEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setAnimationStateHandler(ch.bfh
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
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setDelay(int)
	 */
	@Override
	public void setDelay(int delay) {
		this.delay = delay;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setDelayEnabled(boolean)
	 */
	@Override
	public void setDelayEnabled(boolean delayEnabled) {
		this.delayEnabled = delayEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setPlayEnabled(boolean)
	 */
	@Override
	public void setPlayEnabled(boolean playEnabled) {
		this.playEnabled = playEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setPauseLabel(java.lang.String)
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
	 * ch.bfh.bti7301.hs2013.gravis.gui.IModel#setPauseEvent(ch.bfh.bti7301.
	 * hs2013.gravis.gui.control.IControl.EventSource)
	 */
	@Override
	public void setPauseEvent(EventSource pauseEvent) {
		this.pauseEvent = pauseEvent;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setPauseEnabled(boolean)
	 */
	@Override
	public void setPauseEnabled(boolean pauseEnabled) {
		this.pauseEnabled = pauseEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setStopEnabled(boolean)
	 */
	@Override
	public void setStopEnabled(boolean stopEnabled) {
		this.stopEnabled = stopEnabled;
		this.setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.gui.IModel#setStringBuilder(java.lang.
	 * StringBuilder)
	 */
	@Override
	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
		this.setChanged();
	}

}
