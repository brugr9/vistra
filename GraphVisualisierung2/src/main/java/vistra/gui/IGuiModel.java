package vistra.gui;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.traversal.ITraversal;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.control.state.IAnimationStateHandler;
import vistra.gui.control.state.IParameterStateHandler;
import vistra.gui.control.state.ISbsStateHandler;

public interface IGuiModel {

	/**
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	void setMenuEnabled(boolean menuEnabled);

	/**
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	void setPlayerEnabled(boolean menuEnabled);

	/**
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	void setAnimationEnabled(boolean menuEnabled);

	/**
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	void setStepByStepEnabled(boolean menuEnabled);

	/**
	 * @return the resourceBundle
	 */
	ResourceBundle getResourceBundle();

	/**
	 * @return the help
	 */
	String getHelp();

	/**
	 * @return the about
	 */
	String getAbout();

	/**
	 * @return the i18nListener
	 */
	ActionListener getI18nListener();

	/**
	 * @return the helpListener
	 */
	ActionListener getHelpListener();

	/**
	 * @return the aboutListener
	 */
	ActionListener getAboutListener();

	/**
	 * @return the quitListener
	 */
	ActionListener getQuitListener();

	/**
	 * @return the fileEnabled
	 */
	boolean isFileEnabled();

	/**
	 * @return the newMenuEnabled
	 */
	boolean isNewMenuEnabled();

	/**
	 * @return the undirectedGraphEnabled
	 */
	boolean isUndirectedGraphEnabled();

	/**
	 * @return the directedGraphEnabled
	 */
	boolean isDirectedGraphEnabled();

	/**
	 * @return the openGraphEnabled
	 */
	boolean isOpenGraphEnabled();

	/**
	 * @return the saveGraphEnabled
	 */
	boolean isSaveGraphEnabled();

	/**
	 * @return the saveGraphAsEnabled
	 */
	boolean isSaveGraphAsEnabled();

	/**
	 * @return the quitEnabled
	 */
	boolean isQuitEnabled();

	/**
	 * @return the i18nEnabled
	 */
	boolean isI18nEnabled();

	/**
	 * @return the deDEEnabled
	 */
	boolean isDeDEEnabled();

	/**
	 * @return the frFREnabled
	 */
	boolean isFrFREnabled();

	/**
	 * @return the enUSEnabled
	 */
	boolean isEnUSEnabled();

	/**
	 * @return the infoEnabled
	 */
	boolean isInfoEnabled();

	/**
	 * @return the helpEnabled
	 */
	boolean isHelpEnabled();

	/**
	 * @return the aboutEnabled
	 */
	boolean isAboutEnabled();

	/**
	 * @return the parameterStateHandler
	 */
	IParameterStateHandler getParameterStateHandler();

	/**
	 * @return the graph
	 */
	IExtendedGraph getGraph();

	/**
	 * @return the graphFile
	 */
	boolean isGraphFile();

	/**
	 * @return the graphSaved
	 */
	boolean isGraphSaved();

	/**
	 * @return the editGraphEnabled
	 */
	boolean isEditGraphEnabled();

	/**
	 * @return the start
	 */
	IVertexLayout getStart();

	/**
	 * @return the end
	 */
	IVertexLayout getEnd();

	/**
	 * @return the algorithms
	 */
	String[] getAlgorithms();

	/**
	 * @return the algorithmsEnabled
	 */
	boolean isAlgorithmsEnabled();

	/**
	 * @return the selectedAlgorithmIndex
	 */
	int getSelectedAlgorithmIndex();

	/**
	 * @return the algorithmDescription
	 */
	String getAlgorithmDescription();

	/**
	 * @return the traversal
	 */
	ITraversal getTraversal();

	/**
	 * @return the progress
	 */
	int getProgress();

	/**
	 * @return the stepByStepStateHandler
	 */
	ISbsStateHandler getStepByStepStateHandler();

	/**
	 * @return the steplength
	 */
	int getSteplength();

	/**
	 * @return the steplengthEnabled
	 */
	boolean isSteplengthEnabled();

	/**
	 * @return the toBeginningEnabled
	 */
	boolean isToBeginningEnabled();

	/**
	 * @return the backwardEnabled
	 */
	boolean isBackwardEnabled();

	/**
	 * @return the forwardEnabled
	 */
	boolean isForwardEnabled();

	/**
	 * @return the toEndEnabled
	 */
	boolean isToEndEnabled();

	/**
	 * @return the animationStateHandler
	 */
	IAnimationStateHandler getAnimationStateHandler();

	/**
	 * @return the delay
	 */
	int getDelay();

	/**
	 * @return the delayEnabled
	 */
	boolean isDelayEnabled();

	/**
	 * @return the playEnabled
	 */
	boolean isPlayEnabled();

	/**
	 * @return the pauseLabel
	 */
	String getPauseLabel();

	/**
	 * @return the pauseEvent
	 */
	EventSource getPauseEvent();

	/**
	 * @return the pauseEnabled
	 */
	boolean isPauseEnabled();

	/**
	 * @return the stopEnabled
	 */
	boolean isStopEnabled();

	/**
	 * @return the protocol
	 */
	StringBuilder getProtocol();

	/**
	 * @param resourceBundle
	 *            the resourceBundle to set
	 */
	void setResourceBundle(ResourceBundle resourceBundle);

	/**
	 * @param help
	 *            the help to set
	 */
	void setHelp(String help);

	/**
	 * @param about
	 *            the about to set
	 */
	void setAbout(String about);

	/**
	 * @param i18nListener
	 *            the i18nListener to set
	 */
	void setI18nListener(ActionListener i18nListener);

	/**
	 * @param helpListener
	 *            the helpListener to set
	 */
	void setHelpListener(ActionListener helpListener);

	/**
	 * @param aboutListener
	 *            the aboutListener to set
	 */
	void setAboutListener(ActionListener aboutListener);

	/**
	 * @param quitListener
	 *            the quitListener to set
	 */
	void setQuitListener(ActionListener quitListener);

	/**
	 * @param fileEnabled
	 *            the fileEnabled to set
	 */
	void setFileEnabled(boolean fileEnabled);

	/**
	 * @param newMenuEnabled
	 *            the newMenuEnabled to set
	 */
	void setNewMenuEnabled(boolean newMenuEnabled);

	/**
	 * @param undirectedGraphEnabled
	 *            the undirectedGraphEnabled to set
	 */
	void setUndirectedGraphEnabled(boolean undirectedGraphEnabled);

	/**
	 * @param directedGraphEnabled
	 *            the directedGraphEnabled to set
	 */
	void setDirectedGraphEnabled(boolean directedGraphEnabled);

	/**
	 * @param openGraphEnabled
	 *            the openGraphEnabled to set
	 */
	void setOpenGraphEnabled(boolean openGraphEnabled);

	/**
	 * @param saveGraphEnabled
	 *            the saveGraphEnabled to set
	 */
	void setSaveGraphEnabled(boolean saveGraphEnabled);

	/**
	 * @param saveGraphAsEnabled
	 *            the saveGraphAsEnabled to set
	 */
	void setSaveGraphAsEnabled(boolean saveGraphAsEnabled);

	/**
	 * @param quitEnabled
	 *            the quitEnabled to set
	 */
	void setQuitEnabled(boolean quitEnabled);

	/**
	 * @param i18nEnabled
	 *            the i18nEnabled to set
	 */
	void setI18nEnabled(boolean i18nEnabled);

	/**
	 * @param deDEEnabled
	 *            the deDEEnabled to set
	 */
	void setDeDEEnabled(boolean deDEEnabled);

	/**
	 * @param frFREnabled
	 *            the frFREnabled to set
	 */
	void setFrFREnabled(boolean frFREnabled);

	/**
	 * @param enUSEnabled
	 *            the enUSEnabled to set
	 */
	void setEnUSEnabled(boolean enUSEnabled);

	/**
	 * @param infoEnabled
	 *            the infoEnabled to set
	 */
	void setInfoEnabled(boolean infoEnabled);

	/**
	 * @param helpEnabled
	 *            the helpEnabled to set
	 */
	void setHelpEnabled(boolean helpEnabled);

	/**
	 * @param aboutEnabled
	 *            the aboutEnabled to set
	 */
	void setAboutEnabled(boolean aboutEnabled);

	/**
	 * @param parameterStateHandler
	 *            the parameterStateHandler to set
	 */
	void setParameterStateHandler(IParameterStateHandler parameterStateHandler);

	/**
	 * @param graph
	 *            the graph to set
	 */
	void setGraph(IExtendedGraph graph);

	/**
	 * @param graphFile
	 *            the graphFile to set
	 */
	void setGraphFile(boolean graphFile);

	/**
	 * @param graphSaved
	 *            the graphSaved to set
	 */
	void setGraphSaved(boolean graphSaved);

	/**
	 * @param editGraphEnabled
	 *            the editGraphEnabled to set
	 */
	void setEditGraphEnabled(boolean editGraphEnabled);

	/**
	 * @param start
	 *            the start to set
	 */
	void setStart(IVertexLayout start);

	/**
	 * @param end
	 *            the end to set
	 */
	void setEnd(IVertexLayout end);

	/**
	 * @param algorithms
	 *            the algorithms to set
	 */
	void setAlgorithms(String[] algorithms);

	/**
	 * @param algorithmsEnabled
	 *            the algorithmsEnabled to set
	 */
	void setAlgorithmsEnabled(boolean algorithmsEnabled);

	/**
	 * @param selectedAlgorithmIndex
	 *            the selectedAlgorithmIndex to set
	 */
	void setSelectedAlgorithmIndex(int selectedAlgorithmIndex);

	/**
	 * @param algorithmDescription
	 *            the algorithmDescription to set
	 */
	void setAlgorithmDescription(String algorithmDescription);

	/**
	 * @param traversal
	 *            the traversal to set
	 */
	void setTraversal(ITraversal traversal);

	/**
	 * @param progress
	 *            the progress to set
	 */
	void setProgress(int progress);

	/**
	 * @param stepByStepStateHandler
	 *            the stepByStepStateHandler to set
	 */
	void setStepByStepStateHandler(ISbsStateHandler stepByStepStateHandler);

	/**
	 * @param steplength
	 *            the steplength to set
	 */
	void setSteplength(int steplength);

	/**
	 * @param steplengthEnabled
	 *            the steplengthEnabled to set
	 */
	void setSteplengthEnabled(boolean steplengthEnabled);

	/**
	 * @param toBeginningEnabled
	 *            the toBeginningEnabled to set
	 */
	void setToBeginningEnabled(boolean toBeginningEnabled);

	/**
	 * @param backwardEnabled
	 *            the backwardEnabled to set
	 */
	void setBackwardEnabled(boolean backwardEnabled);

	/**
	 * @param forwardEnabled
	 *            the forwardEnabled to set
	 */
	void setForwardEnabled(boolean forwardEnabled);

	/**
	 * @param toEndEnabled
	 *            the toEndEnabled to set
	 */
	void setToEndEnabled(boolean toEndEnabled);

	/**
	 * @param animationStateHandler
	 *            the animationStateHandler to set
	 */
	void setAnimationStateHandler(IAnimationStateHandler animationStateHandler);

	/**
	 * @param delay
	 *            the delay to set
	 */
	void setDelay(int delay);

	/**
	 * @param delayEnabled
	 *            the delayEnabled to set
	 */
	void setDelayEnabled(boolean delayEnabled);

	/**
	 * @param playEnabled
	 *            the playEnabled to set
	 */
	void setPlayEnabled(boolean playEnabled);

	/**
	 * @param pauseLabel
	 *            the pauseLabel to set
	 */
	void setPauseLabel(String pauseLabel);

	/**
	 * @param pauseEvent
	 *            the pauseEvent to set
	 */
	void setPauseEvent(EventSource pauseEvent);

	/**
	 * @param pauseEnabled
	 *            the pauseEnabled to set
	 */
	void setPauseEnabled(boolean pauseEnabled);

	/**
	 * @param stopEnabled
	 *            the stopEnabled to set
	 */
	void setStopEnabled(boolean stopEnabled);

	/**
	 * @param protocol
	 *            the protocol to set
	 */
	void setProtocol(StringBuilder protocol);

}