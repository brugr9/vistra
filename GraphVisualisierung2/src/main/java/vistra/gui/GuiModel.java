package vistra.gui;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.ResourceBundle;

import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.traversal.ITraversal;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.control.state.IAnimationStateHandler;
import vistra.gui.control.state.IParameterStateHandler;
import vistra.gui.control.state.ISbsStateHandler;

/**
 * A model as in MVC holding some fields and its getter and setter methods.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GuiModel extends Observable implements IGuiModel {

	/* i18n */
	private ResourceBundle resourceBundle;
	private String help;
	private String about;

	/* Menu */
	// Action listener
	private ActionListener i18nListener;
	private ActionListener helpListener;
	private ActionListener aboutListener;
	private ActionListener quitListener;
	// File
	private boolean fileEnabled;
	private boolean newMenuEnabled;
	private boolean undirectedGraphEnabled;
	private boolean directedGraphEnabled;
	private boolean openGraphEnabled;
	private boolean saveGraphEnabled;
	private boolean saveGraphAsEnabled;
	private boolean quitEnabled;
	// I18n
	private boolean i18nEnabled;
	private boolean deDEEnabled;
	private boolean frFREnabled;
	private boolean enUSEnabled;
	// Info
	private boolean infoEnabled;
	private boolean helpEnabled;
	private boolean aboutEnabled;

	/* Parameter */
	private IParameterStateHandler parameterStateHandler;
	// Graph
	private IExtendedGraph graph;
	private boolean graphFile;
	private boolean graphSaved;
	private boolean editGraphEnabled;
	private IVertexLayout start;
	private IVertexLayout end;
	// Algorithm
	private String[] algorithms;
	private boolean algorithmsEnabled;
	private int selectedAlgorithmIndex;
	private String algorithmDescription;

	/* Traversal */
	private ITraversal traversal;
	private int progress;
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
	private StringBuilder protocol;

	/**
	 * Main constructor.
	 * 
	 * @param graph
	 *            an observable gravis graph
	 */
	public GuiModel(IExtendedGraph graph) {
		super();

		/* i18n */
		this.resourceBundle = null;
		this.help = "";
		this.about = "";

		/* Menu */
		// Action listener
		this.i18nListener = null;
		this.helpListener = null;
		this.aboutListener = null;
		this.quitListener = null;
		// File
		this.fileEnabled = false;
		this.newMenuEnabled = false;
		this.undirectedGraphEnabled = false;
		this.directedGraphEnabled = false;
		this.openGraphEnabled = false;
		this.saveGraphEnabled = false;
		this.saveGraphAsEnabled = false;
		this.editGraphEnabled = false;
		this.quitEnabled = false;
		// i18n
		this.i18nEnabled = false;
		this.deDEEnabled = false;
		this.frFREnabled = false;
		this.enUSEnabled = false;
		// Info
		this.infoEnabled = false;
		this.helpEnabled = false;
		this.aboutEnabled = false;

		/* Parameter */
		this.parameterStateHandler = null;
		// Graph
		this.graph = graph;
		this.graphFile = false;
		this.graphSaved = false;
		this.editGraphEnabled = false;
		this.start = null;
		this.end = null;

		// Algorithm
		this.algorithms = null;
		this.algorithmsEnabled = false;
		this.selectedAlgorithmIndex = 0;
		this.algorithmDescription = " ";

		/* Traversal */
		this.traversal = null;
		this.progress = 0;
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
		this.protocol = new StringBuilder();

	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setMenuEnabled(boolean)
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

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setPlayerEnabled(boolean)
	 */
	@Override
	public void setPlayerEnabled(boolean menuEnabled) {
		this.setSteplengthEnabled(menuEnabled);
		this.setDelayEnabled(menuEnabled);
		this.setAnimationEnabled(menuEnabled);
		this.setStepByStepEnabled(menuEnabled);

		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setAnimationEnabled(boolean)
	 */
	@Override
	public void setAnimationEnabled(boolean menuEnabled) {
		this.setPlayEnabled(menuEnabled);
		this.setPauseEnabled(menuEnabled);
		this.setStopEnabled(menuEnabled);

		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setStepByStepEnabled(boolean)
	 */
	@Override
	public void setStepByStepEnabled(boolean menuEnabled) {
		this.setToBeginningEnabled(menuEnabled);
		this.setBackwardEnabled(menuEnabled);
		this.setForwardEnabled(menuEnabled);
		this.setToEndEnabled(menuEnabled);

		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getResourceBundle()
	 */
	@Override
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getHelp()
	 */
	@Override
	public String getHelp() {
		return help;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getAbout()
	 */
	@Override
	public String getAbout() {
		return about;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getI18nListener()
	 */
	@Override
	public ActionListener getI18nListener() {
		return i18nListener;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getHelpListener()
	 */
	@Override
	public ActionListener getHelpListener() {
		return helpListener;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getAboutListener()
	 */
	@Override
	public ActionListener getAboutListener() {
		return aboutListener;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getQuitListener()
	 */
	@Override
	public ActionListener getQuitListener() {
		return quitListener;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isFileEnabled()
	 */
	@Override
	public boolean isFileEnabled() {
		return fileEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isNewMenuEnabled()
	 */
	@Override
	public boolean isNewMenuEnabled() {
		return newMenuEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isUndirectedGraphEnabled()
	 */
	@Override
	public boolean isUndirectedGraphEnabled() {
		return undirectedGraphEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isDirectedGraphEnabled()
	 */
	@Override
	public boolean isDirectedGraphEnabled() {
		return directedGraphEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isOpenGraphEnabled()
	 */
	@Override
	public boolean isOpenGraphEnabled() {
		return openGraphEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isSaveGraphEnabled()
	 */
	@Override
	public boolean isSaveGraphEnabled() {
		return saveGraphEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isSaveGraphAsEnabled()
	 */
	@Override
	public boolean isSaveGraphAsEnabled() {
		return saveGraphAsEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isQuitEnabled()
	 */
	@Override
	public boolean isQuitEnabled() {
		return quitEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isI18nEnabled()
	 */
	@Override
	public boolean isI18nEnabled() {
		return i18nEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isDeDEEnabled()
	 */
	@Override
	public boolean isDeDEEnabled() {
		return deDEEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isFrFREnabled()
	 */
	@Override
	public boolean isFrFREnabled() {
		return frFREnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isEnUSEnabled()
	 */
	@Override
	public boolean isEnUSEnabled() {
		return enUSEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isInfoEnabled()
	 */
	@Override
	public boolean isInfoEnabled() {
		return infoEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isHelpEnabled()
	 */
	@Override
	public boolean isHelpEnabled() {
		return helpEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isAboutEnabled()
	 */
	@Override
	public boolean isAboutEnabled() {
		return aboutEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getParameterStateHandler()
	 */
	@Override
	public IParameterStateHandler getParameterStateHandler() {
		return parameterStateHandler;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getGraph()
	 */
	@Override
	public IExtendedGraph getGraph() {
		return graph;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isGraphFile()
	 */
	@Override
	public boolean isGraphFile() {
		return graphFile;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isGraphSaved()
	 */
	@Override
	public boolean isGraphSaved() {
		return graphSaved;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isEditGraphEnabled()
	 */
	@Override
	public boolean isEditGraphEnabled() {
		return editGraphEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getStart()
	 */
	@Override
	public IVertexLayout getStart() {
		return start;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getEnd()
	 */
	@Override
	public IVertexLayout getEnd() {
		return end;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getAlgorithms()
	 */
	@Override
	public String[] getAlgorithms() {
		return algorithms;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isAlgorithmsEnabled()
	 */
	@Override
	public boolean isAlgorithmsEnabled() {
		return algorithmsEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getSelectedAlgorithmIndex()
	 */
	@Override
	public int getSelectedAlgorithmIndex() {
		return selectedAlgorithmIndex;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getAlgorithmDescription()
	 */
	@Override
	public String getAlgorithmDescription() {
		return algorithmDescription;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getTraversal()
	 */
	@Override
	public ITraversal getTraversal() {
		return traversal;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getProgress()
	 */
	@Override
	public int getProgress() {
		return progress;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getStepByStepStateHandler()
	 */
	@Override
	public ISbsStateHandler getStepByStepStateHandler() {
		return stepByStepStateHandler;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getSteplength()
	 */
	@Override
	public int getSteplength() {
		return steplength;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isSteplengthEnabled()
	 */
	@Override
	public boolean isSteplengthEnabled() {
		return steplengthEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isToBeginningEnabled()
	 */
	@Override
	public boolean isToBeginningEnabled() {
		return toBeginningEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isBackwardEnabled()
	 */
	@Override
	public boolean isBackwardEnabled() {
		return backwardEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isForwardEnabled()
	 */
	@Override
	public boolean isForwardEnabled() {
		return forwardEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isToEndEnabled()
	 */
	@Override
	public boolean isToEndEnabled() {
		return toEndEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getAnimationStateHandler()
	 */
	@Override
	public IAnimationStateHandler getAnimationStateHandler() {
		return animationStateHandler;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getDelay()
	 */
	@Override
	public int getDelay() {
		return delay;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isDelayEnabled()
	 */
	@Override
	public boolean isDelayEnabled() {
		return delayEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isPlayEnabled()
	 */
	@Override
	public boolean isPlayEnabled() {
		return playEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getPauseLabel()
	 */
	@Override
	public String getPauseLabel() {
		return pauseLabel;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getPauseEvent()
	 */
	@Override
	public EventSource getPauseEvent() {
		return pauseEvent;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isPauseEnabled()
	 */
	@Override
	public boolean isPauseEnabled() {
		return pauseEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#isStopEnabled()
	 */
	@Override
	public boolean isStopEnabled() {
		return stopEnabled;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#getProtocol()
	 */
	@Override
	public StringBuilder getProtocol() {
		return protocol;
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setResourceBundle(java.util.ResourceBundle)
	 */
	@Override
	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setHelp(java.lang.String)
	 */
	@Override
	public void setHelp(String help) {
		this.help = help;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setAbout(java.lang.String)
	 */
	@Override
	public void setAbout(String about) {
		this.about = about;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setI18nListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setI18nListener(ActionListener i18nListener) {
		this.i18nListener = i18nListener;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setHelpListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setHelpListener(ActionListener helpListener) {
		this.helpListener = helpListener;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setAboutListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setAboutListener(ActionListener aboutListener) {
		this.aboutListener = aboutListener;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setQuitListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setQuitListener(ActionListener quitListener) {
		this.quitListener = quitListener;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setFileEnabled(boolean)
	 */
	@Override
	public void setFileEnabled(boolean fileEnabled) {
		this.fileEnabled = fileEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setNewMenuEnabled(boolean)
	 */
	@Override
	public void setNewMenuEnabled(boolean newMenuEnabled) {
		this.newMenuEnabled = newMenuEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setUndirectedGraphEnabled(boolean)
	 */
	@Override
	public void setUndirectedGraphEnabled(boolean undirectedGraphEnabled) {
		this.undirectedGraphEnabled = undirectedGraphEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setDirectedGraphEnabled(boolean)
	 */
	@Override
	public void setDirectedGraphEnabled(boolean directedGraphEnabled) {
		this.directedGraphEnabled = directedGraphEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setOpenGraphEnabled(boolean)
	 */
	@Override
	public void setOpenGraphEnabled(boolean openGraphEnabled) {
		this.openGraphEnabled = openGraphEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setSaveGraphEnabled(boolean)
	 */
	@Override
	public void setSaveGraphEnabled(boolean saveGraphEnabled) {
		this.saveGraphEnabled = saveGraphEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setSaveGraphAsEnabled(boolean)
	 */
	@Override
	public void setSaveGraphAsEnabled(boolean saveGraphAsEnabled) {
		this.saveGraphAsEnabled = saveGraphAsEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setQuitEnabled(boolean)
	 */
	@Override
	public void setQuitEnabled(boolean quitEnabled) {
		this.quitEnabled = quitEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setI18nEnabled(boolean)
	 */
	@Override
	public void setI18nEnabled(boolean i18nEnabled) {
		this.i18nEnabled = i18nEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setDeDEEnabled(boolean)
	 */
	@Override
	public void setDeDEEnabled(boolean deDEEnabled) {
		this.deDEEnabled = deDEEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setFrFREnabled(boolean)
	 */
	@Override
	public void setFrFREnabled(boolean frFREnabled) {
		this.frFREnabled = frFREnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setEnUSEnabled(boolean)
	 */
	@Override
	public void setEnUSEnabled(boolean enUSEnabled) {
		this.enUSEnabled = enUSEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setInfoEnabled(boolean)
	 */
	@Override
	public void setInfoEnabled(boolean infoEnabled) {
		this.infoEnabled = infoEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setHelpEnabled(boolean)
	 */
	@Override
	public void setHelpEnabled(boolean helpEnabled) {
		this.helpEnabled = helpEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setAboutEnabled(boolean)
	 */
	@Override
	public void setAboutEnabled(boolean aboutEnabled) {
		this.aboutEnabled = aboutEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setParameterStateHandler(vistra.gui.control.state.IParameterStateHandler)
	 */
	@Override
	public void setParameterStateHandler(
			IParameterStateHandler parameterStateHandler) {
		this.parameterStateHandler = parameterStateHandler;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setGraph(vistra.core.graph.IExtendedGraph)
	 */
	@Override
	public void setGraph(IExtendedGraph graph) {
		this.graph = graph;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setGraphFile(boolean)
	 */
	@Override
	public void setGraphFile(boolean graphFile) {
		this.graphFile = graphFile;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setGraphSaved(boolean)
	 */
	@Override
	public void setGraphSaved(boolean graphSaved) {
		this.graphSaved = graphSaved;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setEditGraphEnabled(boolean)
	 */
	@Override
	public void setEditGraphEnabled(boolean editGraphEnabled) {
		this.editGraphEnabled = editGraphEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setStart(vistra.core.graph.item.IVertexLayout)
	 */
	@Override
	public void setStart(IVertexLayout start) {
		this.start = start;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setEnd(vistra.core.graph.item.IVertexLayout)
	 */
	@Override
	public void setEnd(IVertexLayout end) {
		this.end = end;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setAlgorithms(java.lang.String[])
	 */
	@Override
	public void setAlgorithms(String[] algorithms) {
		this.algorithms = algorithms;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setAlgorithmsEnabled(boolean)
	 */
	@Override
	public void setAlgorithmsEnabled(boolean algorithmsEnabled) {
		this.algorithmsEnabled = algorithmsEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setSelectedAlgorithmIndex(int)
	 */
	@Override
	public void setSelectedAlgorithmIndex(int selectedAlgorithmIndex) {
		this.selectedAlgorithmIndex = selectedAlgorithmIndex;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setAlgorithmDescription(java.lang.String)
	 */
	@Override
	public void setAlgorithmDescription(String algorithmDescription) {
		this.algorithmDescription = algorithmDescription;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setTraversal(vistra.core.traversal.ITraversal)
	 */
	@Override
	public void setTraversal(ITraversal traversal) {
		this.traversal = traversal;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setProgress(int)
	 */
	@Override
	public void setProgress(int progress) {
		this.progress = progress;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setStepByStepStateHandler(vistra.gui.control.state.ISbsStateHandler)
	 */
	@Override
	public void setStepByStepStateHandler(
			ISbsStateHandler stepByStepStateHandler) {
		this.stepByStepStateHandler = stepByStepStateHandler;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setSteplength(int)
	 */
	@Override
	public void setSteplength(int steplength) {
		this.steplength = steplength;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setSteplengthEnabled(boolean)
	 */
	@Override
	public void setSteplengthEnabled(boolean steplengthEnabled) {
		this.steplengthEnabled = steplengthEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setToBeginningEnabled(boolean)
	 */
	@Override
	public void setToBeginningEnabled(boolean toBeginningEnabled) {
		this.toBeginningEnabled = toBeginningEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setBackwardEnabled(boolean)
	 */
	@Override
	public void setBackwardEnabled(boolean backwardEnabled) {
		this.backwardEnabled = backwardEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setForwardEnabled(boolean)
	 */
	@Override
	public void setForwardEnabled(boolean forwardEnabled) {
		this.forwardEnabled = forwardEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setToEndEnabled(boolean)
	 */
	@Override
	public void setToEndEnabled(boolean toEndEnabled) {
		this.toEndEnabled = toEndEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setAnimationStateHandler(vistra.gui.control.state.IAnimationStateHandler)
	 */
	@Override
	public void setAnimationStateHandler(
			IAnimationStateHandler animationStateHandler) {
		this.animationStateHandler = animationStateHandler;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setDelay(int)
	 */
	@Override
	public void setDelay(int delay) {
		this.delay = delay;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setDelayEnabled(boolean)
	 */
	@Override
	public void setDelayEnabled(boolean delayEnabled) {
		this.delayEnabled = delayEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setPlayEnabled(boolean)
	 */
	@Override
	public void setPlayEnabled(boolean playEnabled) {
		this.playEnabled = playEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setPauseLabel(java.lang.String)
	 */
	@Override
	public void setPauseLabel(String pauseLabel) {
		this.pauseLabel = pauseLabel;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setPauseEvent(vistra.gui.control.IControl.EventSource)
	 */
	@Override
	public void setPauseEvent(EventSource pauseEvent) {
		this.pauseEvent = pauseEvent;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setPauseEnabled(boolean)
	 */
	@Override
	public void setPauseEnabled(boolean pauseEnabled) {
		this.pauseEnabled = pauseEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setStopEnabled(boolean)
	 */
	@Override
	public void setStopEnabled(boolean stopEnabled) {
		this.stopEnabled = stopEnabled;
		this.setChanged();
	}

	/* (non-Javadoc)
	 * @see vistra.gui.IGuiModel#setProtocol(java.lang.StringBuilder)
	 */
	@Override
	public void setProtocol(StringBuilder protocol) {
		this.protocol = protocol;
		this.setChanged();
	}

}
