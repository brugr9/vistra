package vistra.app;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import vistra.app.control.state.IAnimation;
import vistra.app.control.state.IParameterStateHandler;
import vistra.app.control.state.IStepByStep;
import vistra.framework.ITraversal;
import vistra.framework.graph.ILayoutGraph;
import vistra.framework.graph.item.ILayoutVertex;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

public interface IModel {

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setMenuEnabled(boolean menuEnabled);

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setMenuFileEnabled(boolean menuEnabled);

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setMenuModeEnabled(boolean menuEnabled);

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setMenuEditEnabled(boolean menuEnabled);

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setMenuI18nEnabled(boolean menuEnabled);

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setMenuHelpEnabled(boolean menuEnabled);

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setTraversalEnabled(boolean menuEnabled);

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setSbsEnabled(boolean menuEnabled);

	/**
	 * Grouped setter method. Sets the menuEnabled
	 * 
	 * @param menuEnabled
	 *            the menuEnabled
	 */
	public abstract void setAnimationEnabled(boolean menuEnabled);

	/**
	 * Returns the top.
	 * 
	 * @return the top
	 */
	public abstract Container getTop();

	/**
	 * Sets the top.
	 * 
	 * @param top
	 *            the top to set
	 */
	public abstract void setTop(Container top);

	/**
	 * Returns the resourceBundle.
	 * 
	 * @return the resourceBundle
	 */
	public abstract ResourceBundle getResourceBundle();

	/**
	 * Sets the resourceBundle.
	 * 
	 * @param resourceBundle
	 *            the resourceBundle to set
	 */
	public abstract void setResourceBundle(ResourceBundle resourceBundle);

	/**
	 * Returns the shortcutsMessage.
	 * 
	 * @return the shortcutsMessage
	 */
	public abstract String getShortcutsMessage();

	/**
	 * Sets the shortcutsMessage.
	 * 
	 * @param shortcutsMessage
	 *            the shortcutsMessage to set
	 */
	public abstract void setShortcutsMessage(String shortcutsMessage);

	/**
	 * Returns the aboutMessage.
	 * 
	 * @return the aboutMessage
	 */
	public abstract String getAboutMessage();

	/**
	 * Sets the aboutMessage.
	 * 
	 * @param aboutMessage
	 *            the aboutMessage to set
	 */
	public abstract void setAboutMessage(String aboutMessage);

	/**
	 * Returns the i18nListener.
	 * 
	 * @return the i18nListener
	 */
	public abstract ActionListener getI18nListener();

	/**
	 * Sets the i18nListener.
	 * 
	 * @param i18nListener
	 *            the i18nListener to set
	 */
	public abstract void setI18nListener(ActionListener i18nListener);

	/**
	 * Returns the shortcutsListener.
	 * 
	 * @return the shortcutsListener
	 */
	public abstract ActionListener getShortcutsListener();

	/**
	 * Sets the shortcutsListener.
	 * 
	 * @param shortcutsListener
	 *            the shortcutsListener to set
	 */
	public abstract void setShortcutsListener(ActionListener shortcutsListener);

	/**
	 * Returns the aboutListener.
	 * 
	 * @return the aboutListener
	 */
	public abstract ActionListener getAboutListener();

	/**
	 * Sets the aboutListener.
	 * 
	 * @param aboutListener
	 *            the aboutListener to set
	 */
	public abstract void setAboutListener(ActionListener aboutListener);

	/**
	 * Returns the fileEnabled.
	 * 
	 * @return the fileEnabled
	 */
	public abstract boolean isFileEnabled();

	/**
	 * Sets the fileEnabled.
	 * 
	 * @param fileEnabled
	 *            the fileEnabled to set
	 */
	public abstract void setFileEnabled(boolean fileEnabled);

	/**
	 * Returns the newEnabled.
	 * 
	 * @return the newEnabled
	 */
	public abstract boolean isNewEnabled();

	/**
	 * Sets the newEnabled.
	 * 
	 * @param newEnabled
	 *            the newEnabled to set
	 */
	public abstract void setNewEnabled(boolean newEnabled);

	/**
	 * Returns the undirectedEnabled.
	 * 
	 * @return the undirectedEnabled
	 */
	public abstract boolean isUndirectedEnabled();

	/**
	 * Sets the undirectedEnabled.
	 * 
	 * @param undirectedEnabled
	 *            the undirectedEnabled to set
	 */
	public abstract void setUndirectedEnabled(boolean undirectedEnabled);

	/**
	 * Returns the directedEnabled.
	 * 
	 * @return the directedEnabled
	 */
	public abstract boolean isDirectedEnabled();

	/**
	 * Sets the directedEnabled.
	 * 
	 * @param directedEnabled
	 *            the directedEnabled to set
	 */
	public abstract void setDirectedEnabled(boolean directedEnabled);

	/**
	 * Returns the openEnabled.
	 * 
	 * @return the openEnabled
	 */
	public abstract boolean isOpenEnabled();

	/**
	 * Sets the openEnabled.
	 * 
	 * @param openEnabled
	 *            the openEnabled to set
	 */
	public abstract void setOpenEnabled(boolean openEnabled);

	/**
	 * Returns the saveEnabled.
	 * 
	 * @return the saveEnabled
	 */
	public abstract boolean isSaveEnabled();

	/**
	 * Sets the saveEnabled.
	 * 
	 * @param saveEnabled
	 *            the saveEnabled to set
	 */
	public abstract void setSaveEnabled(boolean saveEnabled);

	/**
	 * Returns the saveAsEnabled.
	 * 
	 * @return the saveAsEnabled
	 */
	public abstract boolean isSaveAsEnabled();

	/**
	 * Sets the saveAsEnabled.
	 * 
	 * @param saveAsEnabled
	 *            the saveAsEnabled to set
	 */
	public abstract void setSaveAsEnabled(boolean saveAsEnabled);

	/**
	 * Returns the quitEnabled.
	 * 
	 * @return the quitEnabled
	 */
	public abstract boolean isQuitEnabled();

	/**
	 * Sets the quitEnabled.
	 * 
	 * @param quitEnabled
	 *            the quitEnabled to set
	 */
	public abstract void setQuitEnabled(boolean quitEnabled);

	/**
	 * Returns the switchModeEnabled.
	 * 
	 * @return the switchModeEnabled
	 */
	public abstract boolean isSwitchModeEnabled();

	/**
	 * Sets the switchModeEnabled.
	 * 
	 * @param switchModeEnabled
	 *            the switchModeEnabled to set
	 */
	public abstract void setSwitchModeEnabled(boolean switchModeEnabled);

	/**
	 * Returns the selectEditingModeEnabled.
	 * 
	 * @return the selectEditingModeEnabled
	 */
	public abstract boolean isSelectEditingModeEnabled();

	/**
	 * Sets the selectEditingModeEnabled.
	 * 
	 * @param selectEditingModeEnabled
	 *            the selectEditingModeEnabled to set
	 */
	public abstract void setSelectEditingModeEnabled(
			boolean selectEditingModeEnabled);

	/**
	 * Returns the selectPickingModeEnabled.
	 * 
	 * @return the selectPickingModeEnabled
	 */
	public abstract boolean isSelectPickingModeEnabled();

	/**
	 * Sets the selectPickingModeEnabled.
	 * 
	 * @param selectPickingModeEnabled
	 *            the selectPickingModeEnabled to set
	 */
	public abstract void setSelectPickingModeEnabled(
			boolean selectPickingModeEnabled);

	/**
	 * Returns the editVertexEnabled.
	 * 
	 * @return the editVertexEnabled
	 */
	public abstract boolean isEditVertexEnabled();

	/**
	 * Sets the editVertexEnabled.
	 * 
	 * @param editVertexEnabled
	 *            the editVertexEnabled to set
	 */
	public abstract void setEditVertexEnabled(boolean editVertexEnabled);

	/**
	 * Returns the editEdgeEnabled.
	 * 
	 * @return the editEdgeEnabled
	 */
	public abstract boolean isEditEdgeEnabled();

	/**
	 * Sets the editEdgeEnabled.
	 * 
	 * @param editEdgeEnabled
	 *            the editEdgeEnabled to set
	 */
	public abstract void setEditEdgeEnabled(boolean editEdgeEnabled);

	/**
	 * Returns the i18nEnabled.
	 * 
	 * @return the i18nEnabled
	 */
	public abstract boolean isI18nEnabled();

	/**
	 * Sets the i18nEnabled.
	 * 
	 * @param i18nEnabled
	 *            the i18nEnabled to set
	 */
	public abstract void setI18nEnabled(boolean i18nEnabled);

	/**
	 * Returns the deCHEnabled.
	 * 
	 * @return the deCHEnabled
	 */
	public abstract boolean isDeCHEnabled();

	/**
	 * Sets the deCHEnabled.
	 * 
	 * @param deCHEnabled
	 *            the deCHEnabled to set
	 */
	public abstract void setDeCHEnabled(boolean deCHEnabled);

	/**
	 * Returns the deDEEnabled.
	 * 
	 * @return the deDEEnabled
	 */
	public abstract boolean isDeDEEnabled();

	/**
	 * Sets the deDEEnabled.
	 * 
	 * @param deDEEnabled
	 *            the deDEEnabled to set
	 */
	public abstract void setDeDEEnabled(boolean deDEEnabled);

	/**
	 * Returns the frFREnabled.
	 * 
	 * @return the frFREnabled
	 */
	public abstract boolean isFrFREnabled();

	/**
	 * Sets the frFREnabled.
	 * 
	 * @param frFREnabled
	 *            the frFREnabled to set
	 */
	public abstract void setFrFREnabled(boolean frFREnabled);

	/**
	 * Returns the enGBEnabled.
	 * 
	 * @return the enGBEnabled
	 */
	public abstract boolean isEnGBEnabled();

	/**
	 * Sets the enGBEnabled.
	 * 
	 * @param enGBEnabled
	 *            the enGBEnabled to set
	 */
	public abstract void setEnGBEnabled(boolean enGBEnabled);

	/**
	 * Returns the enUSEnabled.
	 * 
	 * @return the enUSEnabled
	 */
	public abstract boolean isEnUSEnabled();

	/**
	 * Sets the enUSEnabled.
	 * 
	 * @param enUSEnabled
	 *            the enUSEnabled to set
	 */
	public abstract void setEnUSEnabled(boolean enUSEnabled);

	/**
	 * Returns the helpEnabled.
	 * 
	 * @return the helpEnabled
	 */
	public abstract boolean isHelpEnabled();

	/**
	 * Sets the helpEnabled.
	 * 
	 * @param helpEnabled
	 *            the helpEnabled to set
	 */
	public abstract void setHelpEnabled(boolean helpEnabled);

	/**
	 * Returns the shortcutsEnabled.
	 * 
	 * @return the shortcutsEnabled
	 */
	public abstract boolean isShortcutsEnabled();

	/**
	 * Sets the shortcutsEnabled.
	 * 
	 * @param shortcutsEnabled
	 *            the shortcutsEnabled to set
	 */
	public abstract void setShortcutsEnabled(boolean shortcutsEnabled);

	/**
	 * Returns the aboutEnabled.
	 * 
	 * @return the aboutEnabled
	 */
	public abstract boolean isAboutEnabled();

	/**
	 * Sets the aboutEnabled.
	 * 
	 * @param aboutEnabled
	 *            the aboutEnabled to set
	 */
	public abstract void setAboutEnabled(boolean aboutEnabled);

	/**
	 * Returns the parameterHandler.
	 * 
	 * @return the parameterHandler
	 */
	public abstract IParameterStateHandler getParameterStateHandler();

	/**
	 * Sets the parameterHandler.
	 * 
	 * @param parameterHandler
	 *            the parameterHandler to set
	 */
	public abstract void setParameterStateHandler(
			IParameterStateHandler parameterHandler);

	/**
	 * Returns the graph.
	 * 
	 * @return the graph
	 */
	public abstract ILayoutGraph getGraph();

	/**
	 * Sets the graph.
	 * 
	 * @param graph
	 *            the graph to set
	 */
	public abstract void setGraph(ILayoutGraph graph);

	/**
	 * Returns the start.
	 * 
	 * @return the start
	 */
	public abstract ILayoutVertex getStart();

	/**
	 * Sets the start.
	 * 
	 * @param start
	 *            the start to set
	 */
	public abstract void setStart(ILayoutVertex start);

	/**
	 * Returns the end.
	 * 
	 * @return the end
	 */
	public abstract ILayoutVertex getEnd();

	/**
	 * Sets the end.
	 * 
	 * @param end
	 *            the end to set
	 */
	public abstract void setEnd(ILayoutVertex end);

	/**
	 * Returns the focus.
	 * 
	 * @return the focus
	 */
	public abstract ILayoutVertex getFocus();

	/**
	 * Sets the focus.
	 * 
	 * @param focus
	 *            the focus to set
	 */
	public abstract void setFocus(ILayoutVertex focus);

	/**
	 * Returns the graphFile.
	 * 
	 * @return the graphFile
	 */
	public abstract boolean isGraphFile();

	/**
	 * Sets the graphFile.
	 * 
	 * @param graphFile
	 *            the graphFile to set
	 */
	public abstract void setGraphFile(boolean graphFile);

	/**
	 * Returns the graphSaved.
	 * 
	 * @return the graphSaved
	 */
	public abstract boolean isGraphSaved();

	/**
	 * Sets the graphSaved.
	 * 
	 * @param graphSaved
	 *            the graphSaved to set
	 */
	public abstract void setGraphSaved(boolean graphSaved);

	/**
	 * Returns the mode.
	 * 
	 * @return the mode
	 */
	public abstract Mode getMode();

	/**
	 * Sets the mode.
	 * 
	 * @param mode
	 *            the mode to set
	 */
	public abstract void setMode(Mode mode);

	/**
	 * Returns the algorithms.
	 * 
	 * @return the algorithms
	 */
	public abstract String[] getAlgorithms();

	/**
	 * Sets the algorithms.
	 * 
	 * @param algorithms
	 *            the algorithms to set
	 */
	public abstract void setAlgorithms(String[] algorithms);

	/**
	 * Returns the algorithmsEnabled.
	 * 
	 * @return the algorithmsEnabled
	 */
	public abstract boolean isAlgorithmsEnabled();

	/**
	 * Sets the algorithmsEnabled.
	 * 
	 * @param algorithmsEnabled
	 *            the algorithmsEnabled to set
	 */
	public abstract void setAlgorithmsEnabled(boolean algorithmsEnabled);

	/**
	 * Returns the selectedAlgorithmIndex.
	 * 
	 * @return the selectedAlgorithmIndex
	 */
	public abstract int getSelectedAlgorithmIndex();

	/**
	 * Sets the selectedAlgorithmIndex.
	 * 
	 * @param selectedAlgorithmIndex
	 *            the selectedAlgorithmIndex to set
	 */
	public abstract void setSelectedAlgorithmIndex(int selectedAlgorithmIndex);

	/**
	 * Returns the algorithmDescription.
	 * 
	 * @return the algorithmDescription
	 */
	public abstract String getAlgorithmDescription();

	/**
	 * Sets the algorithmDescription.
	 * 
	 * @param algorithmDescription
	 *            the algorithmDescription to set
	 */
	public abstract void setAlgorithmDescription(String algorithmDescription);

	/**
	 * Returns the traversal.
	 * 
	 * @return the traversal
	 */
	public abstract ITraversal getTraversal();

	/**
	 * Sets the traversal.
	 * 
	 * @param traversal
	 *            the traversal to set
	 */
	public abstract void setTraversal(ITraversal traversal);

	/**
	 * Returns the progress.
	 * 
	 * @return the progress
	 */
	public abstract int getProgress();

	/**
	 * Sets the progress.
	 * 
	 * @param progress
	 *            the progress to set
	 */
	public abstract void setProgress(int progress);

	/**
	 * Returns the stepByStep.
	 * 
	 * @return the stepByStep
	 */
	public abstract IStepByStep getStepByStep();

	/**
	 * Sets the stepByStep.
	 * 
	 * @param stepByStep
	 *            the stepByStep to set
	 */
	public abstract void setStepByStep(IStepByStep stepByStep);

	/**
	 * Returns the steplength.
	 * 
	 * @return the steplength
	 */
	public abstract int getSteplength();

	/**
	 * Sets the steplength.
	 * 
	 * @param steplength
	 *            the steplength to set
	 */
	public abstract void setSteplength(int steplength);

	/**
	 * Returns the steplengthEnabled.
	 * 
	 * @return the steplengthEnabled
	 */
	public abstract boolean isSteplengthEnabled();

	/**
	 * Sets the steplengthEnabled.
	 * 
	 * @param steplengthEnabled
	 *            the steplengthEnabled to set
	 */
	public abstract void setSteplengthEnabled(boolean steplengthEnabled);

	/**
	 * Returns the toBeginningEnabled.
	 * 
	 * @return the toBeginningEnabled
	 */
	public abstract boolean isToBeginningEnabled();

	/**
	 * Sets the toBeginningEnabled.
	 * 
	 * @param toBeginningEnabled
	 *            the toBeginningEnabled to set
	 */
	public abstract void setToBeginningEnabled(boolean toBeginningEnabled);

	/**
	 * Returns the backwardEnabled.
	 * 
	 * @return the backwardEnabled
	 */
	public abstract boolean isBackwardEnabled();

	/**
	 * Sets the backwardEnabled.
	 * 
	 * @param backwardEnabled
	 *            the backwardEnabled to set
	 */
	public abstract void setBackwardEnabled(boolean backwardEnabled);

	/**
	 * Returns the forwardEnabled.
	 * 
	 * @return the forwardEnabled
	 */
	public abstract boolean isForwardEnabled();

	/**
	 * Sets the forwardEnabled.
	 * 
	 * @param forwardEnabled
	 *            the forwardEnabled to set
	 */
	public abstract void setForwardEnabled(boolean forwardEnabled);

	/**
	 * Returns the toEndEnabled.
	 * 
	 * @return the toEndEnabled
	 */
	public abstract boolean isToEndEnabled();

	/**
	 * Sets the toEndEnabled.
	 * 
	 * @param toEndEnabled
	 *            the toEndEnabled to set
	 */
	public abstract void setToEndEnabled(boolean toEndEnabled);

	/**
	 * Returns the animation.
	 * 
	 * @return the animation
	 */
	public abstract IAnimation getAnimation();

	/**
	 * Sets the animation.
	 * 
	 * @param animation
	 *            the animation to set
	 */
	public abstract void setAnimation(IAnimation animation);

	/**
	 * Returns the delay.
	 * 
	 * @return the delay
	 */
	public abstract int getDelay();

	/**
	 * Sets the delay.
	 * 
	 * @param delay
	 *            the delay to set
	 */
	public abstract void setDelay(int delay);

	/**
	 * Returns the delayEnabled.
	 * 
	 * @return the delayEnabled
	 */
	public abstract boolean isDelayEnabled();

	/**
	 * Sets the delayEnabled.
	 * 
	 * @param delayEnabled
	 *            the delayEnabled to set
	 */
	public abstract void setDelayEnabled(boolean delayEnabled);

	/**
	 * Returns the playEnabled.
	 * 
	 * @return the playEnabled
	 */
	public abstract boolean isPlayEnabled();

	/**
	 * Sets the playEnabled.
	 * 
	 * @param playEnabled
	 *            the playEnabled to set
	 */
	public abstract void setPlayEnabled(boolean playEnabled);

	/**
	 * Returns the pauseLabel.
	 * 
	 * @return the pauseLabel
	 */
	public abstract String getPauseLabel();

	/**
	 * Sets the pauseLabel.
	 * 
	 * @param pauseLabel
	 *            the pauseLabel to set
	 */
	public abstract void setPauseLabel(String pauseLabel);

	/**
	 * Returns the pauseActionCommand.
	 * 
	 * @return the pauseActionCommand
	 */
	public abstract String getPauseActionCommand();

	/**
	 * Sets the pauseActionCommand.
	 * 
	 * @param pauseActionCommand
	 *            the pauseActionCommand to set
	 */
	public abstract void setPauseActionCommand(String pauseActionCommand);

	/**
	 * Returns the pauseEnabled.
	 * 
	 * @return the pauseEnabled
	 */
	public abstract boolean isPauseEnabled();

	/**
	 * Sets the pauseEnabled.
	 * 
	 * @param pauseEnabled
	 *            the pauseEnabled to set
	 */
	public abstract void setPauseEnabled(boolean pauseEnabled);

	/**
	 * Returns the stopEnabled.
	 * 
	 * @return the stopEnabled
	 */
	public abstract boolean isStopEnabled();

	/**
	 * Sets the stopEnabled.
	 * 
	 * @param stopEnabled
	 *            the stopEnabled to set
	 */
	public abstract void setStopEnabled(boolean stopEnabled);

	/**
	 * Returns the protocol.
	 * 
	 * @return the protocol
	 */
	public abstract StringBuilder getProtocol();

	/**
	 * Sets the protocol.
	 * 
	 * @param protocol
	 *            the protocol to set
	 */
	public abstract void setProtocol(StringBuilder protocol);

}