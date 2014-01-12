package vistra.app;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import vistra.app.control.state.IAnimation;
import vistra.app.control.state.IParameterHandler;
import vistra.app.control.state.IStepByStep;
import vistra.framework.ITraversal;
import vistra.framework.graph.IExtendedGraph;
import vistra.framework.graph.item.IVertexLayout;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

public interface IModel {

	public abstract void setMenuEnabled(boolean menuEnabled);

	public abstract void setMenuFileEnabled(boolean menuEnabled);

	public abstract void setMenuModeEnabled(boolean menuEnabled);

	public abstract void setMenuEditEnabled(boolean menuEnabled);

	public abstract void setMenuI18nEnabled(boolean menuEnabled);

	public abstract void setMenuHelpEnabled(boolean menuEnabled);

	public abstract void setTraversalEnabled(boolean menuEnabled);

	public abstract void setSbsEnabled(boolean menuEnabled);

	public abstract void setAnimationEnabled(boolean menuEnabled);

	/**
	 * @return the resourceBundle
	 */
	public abstract ResourceBundle getResourceBundle();

	/**
	 * @param resourceBundle
	 *            the resourceBundle to set
	 */
	public abstract void setResourceBundle(ResourceBundle resourceBundle);

	/**
	 * @return the shortcutsMessage
	 */
	public abstract String getShortcutsMessage();

	/**
	 * @param shortcutsMessage
	 *            the shortcutsMessage to set
	 */
	public abstract void setShortcutsMessage(String shortcutsMessage);

	/**
	 * @return the aboutMessage
	 */
	public abstract String getAboutMessage();

	/**
	 * @param aboutMessage
	 *            the aboutMessage to set
	 */
	public abstract void setAboutMessage(String aboutMessage);

	/**
	 * @return the i18nListener
	 */
	public abstract ActionListener getI18nListener();

	/**
	 * @param i18nListener
	 *            the i18nListener to set
	 */
	public abstract void setI18nListener(ActionListener i18nListener);

	/**
	 * @return the shortcutsListener
	 */
	public abstract ActionListener getShortcutsListener();

	/**
	 * @param shortcutsListener
	 *            the shortcutsListener to set
	 */
	public abstract void setShortcutsListener(ActionListener shortcutsListener);

	/**
	 * @return the aboutListener
	 */
	public abstract ActionListener getAboutListener();

	/**
	 * @param aboutListener
	 *            the aboutListener to set
	 */
	public abstract void setAboutListener(ActionListener aboutListener);

	/**
	 * @return the fileEnabled
	 */
	public abstract boolean isFileEnabled();

	/**
	 * @param fileEnabled
	 *            the fileEnabled to set
	 */
	public abstract void setFileEnabled(boolean fileEnabled);

	/**
	 * @return the newEnabled
	 */
	public abstract boolean isNewEnabled();

	/**
	 * @param newEnabled
	 *            the newEnabled to set
	 */
	public abstract void setNewEnabled(boolean newEnabled);

	/**
	 * @return the undirectedEnabled
	 */
	public abstract boolean isUndirectedEnabled();

	/**
	 * @param undirectedEnabled
	 *            the undirectedEnabled to set
	 */
	public abstract void setUndirectedEnabled(boolean undirectedEnabled);

	/**
	 * @return the directedEnabled
	 */
	public abstract boolean isDirectedEnabled();

	/**
	 * @param directedEnabled
	 *            the directedEnabled to set
	 */
	public abstract void setDirectedEnabled(boolean directedEnabled);

	/**
	 * @return the openEnabled
	 */
	public abstract boolean isOpenEnabled();

	/**
	 * @param openEnabled
	 *            the openEnabled to set
	 */
	public abstract void setOpenEnabled(boolean openEnabled);

	/**
	 * @return the saveEnabled
	 */
	public abstract boolean isSaveEnabled();

	/**
	 * @param saveEnabled
	 *            the saveEnabled to set
	 */
	public abstract void setSaveEnabled(boolean saveEnabled);

	/**
	 * @return the saveAsEnabled
	 */
	public abstract boolean isSaveAsEnabled();

	/**
	 * @param saveAsEnabled
	 *            the saveAsEnabled to set
	 */
	public abstract void setSaveAsEnabled(boolean saveAsEnabled);

	/**
	 * @return the quitEnabled
	 */
	public abstract boolean isQuitEnabled();

	/**
	 * @param quitEnabled
	 *            the quitEnabled to set
	 */
	public abstract void setQuitEnabled(boolean quitEnabled);

	/**
	 * @return the switchModeEnabled
	 */
	public abstract boolean isSwitchModeEnabled();

	/**
	 * @param switchModeEnabled
	 *            the switchModeEnabled to set
	 */
	public abstract void setSwitchModeEnabled(boolean switchModeEnabled);

	/**
	 * @return the selectEditingModeEnabled
	 */
	public abstract boolean isSelectEditingModeEnabled();

	/**
	 * @param selectEditingModeEnabled
	 *            the selectEditingModeEnabled to set
	 */
	public abstract void setSelectEditingModeEnabled(
			boolean selectEditingModeEnabled);

	/**
	 * @return the selectPickingModeEnabled
	 */
	public abstract boolean isSelectPickingModeEnabled();

	/**
	 * @param selectPickingModeEnabled
	 *            the selectPickingModeEnabled to set
	 */
	public abstract void setSelectPickingModeEnabled(
			boolean selectPickingModeEnabled);

	/**
	 * @return the editVertexEnabled
	 */
	public abstract boolean isEditVertexEnabled();

	/**
	 * @param editVertexEnabled
	 *            the editVertexEnabled to set
	 */
	public abstract void setEditVertexEnabled(boolean editVertexEnabled);

	/**
	 * @return the editEdgeEnabled
	 */
	public abstract boolean isEditEdgeEnabled();

	/**
	 * @param editEdgeEnabled
	 *            the editEdgeEnabled to set
	 */
	public abstract void setEditEdgeEnabled(boolean editEdgeEnabled);

	/**
	 * @return the i18nEnabled
	 */
	public abstract boolean isI18nEnabled();

	/**
	 * @param i18nEnabled
	 *            the i18nEnabled to set
	 */
	public abstract void setI18nEnabled(boolean i18nEnabled);

	/**
	 * @return the deCHEnabled
	 */
	public abstract boolean isDeCHEnabled();

	/**
	 * @param deCHEnabled
	 *            the deCHEnabled to set
	 */
	public abstract void setDeCHEnabled(boolean deCHEnabled);

	/**
	 * @return the deDEEnabled
	 */
	public abstract boolean isDeDEEnabled();

	/**
	 * @param deDEEnabled
	 *            the deDEEnabled to set
	 */
	public abstract void setDeDEEnabled(boolean deDEEnabled);

	/**
	 * @return the frFREnabled
	 */
	public abstract boolean isFrFREnabled();

	/**
	 * @param frFREnabled
	 *            the frFREnabled to set
	 */
	public abstract void setFrFREnabled(boolean frFREnabled);

	/**
	 * @return the enGBEnabled
	 */
	public abstract boolean isEnGBEnabled();

	/**
	 * @param enGBEnabled
	 *            the enGBEnabled to set
	 */
	public abstract void setEnGBEnabled(boolean enGBEnabled);

	/**
	 * @return the enUSEnabled
	 */
	public abstract boolean isEnUSEnabled();

	/**
	 * @param enUSEnabled
	 *            the enUSEnabled to set
	 */
	public abstract void setEnUSEnabled(boolean enUSEnabled);

	/**
	 * @return the helpEnabled
	 */
	public abstract boolean isHelpEnabled();

	/**
	 * @param helpEnabled
	 *            the helpEnabled to set
	 */
	public abstract void setHelpEnabled(boolean helpEnabled);

	/**
	 * @return the shortcutsEnabled
	 */
	public abstract boolean isShortcutsEnabled();

	/**
	 * @param shortcutsEnabled
	 *            the shortcutsEnabled to set
	 */
	public abstract void setShortcutsEnabled(boolean shortcutsEnabled);

	/**
	 * @return the aboutEnabled
	 */
	public abstract boolean isAboutEnabled();

	/**
	 * @param aboutEnabled
	 *            the aboutEnabled to set
	 */
	public abstract void setAboutEnabled(boolean aboutEnabled);

	/**
	 * @return the parameterStateHandler
	 */
	public abstract IParameterHandler getParameterStateHandler();

	/**
	 * @param parameterStateHandler
	 *            the parameterStateHandler to set
	 */
	public abstract void setParameterStateHandler(
			IParameterHandler parameterStateHandler);

	/**
	 * @return the graph
	 */
	public abstract IExtendedGraph getGraph();

	/**
	 * @param graph
	 *            the graph to set
	 */
	public abstract void setGraph(IExtendedGraph graph);

	/**
	 * @return the start
	 */
	public abstract IVertexLayout getStart();

	/**
	 * @param start
	 *            the start to set
	 */
	public abstract void setStart(IVertexLayout start);

	/**
	 * @return the end
	 */
	public abstract IVertexLayout getEnd();

	/**
	 * @param end
	 *            the end to set
	 */
	public abstract void setEnd(IVertexLayout end);

	/**
	 * @return the focus
	 */
	public abstract IVertexLayout getFocus();

	/**
	 * @param focus
	 *            the focus to set
	 */
	public abstract void setFocus(IVertexLayout focus);

	/**
	 * @return the graphFile
	 */
	public abstract boolean isGraphFile();

	/**
	 * @param graphFile
	 *            the graphFile to set
	 */
	public abstract void setGraphFile(boolean graphFile);

	/**
	 * @return the graphSaved
	 */
	public abstract boolean isGraphSaved();

	/**
	 * @param graphSaved
	 *            the graphSaved to set
	 */
	public abstract void setGraphSaved(boolean graphSaved);

	/**
	 * @return the mode
	 */
	public abstract Mode getMode();

	/**
	 * @param mode
	 *            the mode to set
	 */
	public abstract void setMode(Mode mode);

	/**
	 * @return the algorithms
	 */
	public abstract String[] getAlgorithms();

	/**
	 * @param algorithms
	 *            the algorithms to set
	 */
	public abstract void setAlgorithms(String[] algorithms);

	/**
	 * @return the algorithmsEnabled
	 */
	public abstract boolean isAlgorithmsEnabled();

	/**
	 * @param algorithmsEnabled
	 *            the algorithmsEnabled to set
	 */
	public abstract void setAlgorithmsEnabled(boolean algorithmsEnabled);

	/**
	 * @return the selectedAlgorithmIndex
	 */
	public abstract int getSelectedAlgorithmIndex();

	/**
	 * @param selectedAlgorithmIndex
	 *            the selectedAlgorithmIndex to set
	 */
	public abstract void setSelectedAlgorithmIndex(int selectedAlgorithmIndex);

	/**
	 * @return the algorithmDescription
	 */
	public abstract String getAlgorithmDescription();

	/**
	 * @param algorithmDescription
	 *            the algorithmDescription to set
	 */
	public abstract void setAlgorithmDescription(String algorithmDescription);

	/**
	 * @return the traversal
	 */
	public abstract ITraversal getTraversal();

	/**
	 * @param traversal
	 *            the traversal to set
	 */
	public abstract void setTraversal(ITraversal traversal);

	/**
	 * @return the progress
	 */
	public abstract int getProgress();

	/**
	 * @param progress
	 *            the progress to set
	 */
	public abstract void setProgress(int progress);

	/**
	 * @return the sbsStateHandler
	 */
	public abstract IStepByStep getSbsStateHandler();

	/**
	 * @param sbsStateHandler
	 *            the sbsStateHandler to set
	 */
	public abstract void setSbsStateHandler(IStepByStep sbsStateHandler);

	/**
	 * @return the steplength
	 */
	public abstract int getSteplength();

	/**
	 * @param steplength
	 *            the steplength to set
	 */
	public abstract void setSteplength(int steplength);

	/**
	 * @return the steplengthEnabled
	 */
	public abstract boolean isSteplengthEnabled();

	/**
	 * @param steplengthEnabled
	 *            the steplengthEnabled to set
	 */
	public abstract void setSteplengthEnabled(boolean steplengthEnabled);

	/**
	 * @return the toBeginningEnabled
	 */
	public abstract boolean isToBeginningEnabled();

	/**
	 * @param toBeginningEnabled
	 *            the toBeginningEnabled to set
	 */
	public abstract void setToBeginningEnabled(boolean toBeginningEnabled);

	/**
	 * @return the backwardEnabled
	 */
	public abstract boolean isBackwardEnabled();

	/**
	 * @param backwardEnabled
	 *            the backwardEnabled to set
	 */
	public abstract void setBackwardEnabled(boolean backwardEnabled);

	/**
	 * @return the forwardEnabled
	 */
	public abstract boolean isForwardEnabled();

	/**
	 * @param forwardEnabled
	 *            the forwardEnabled to set
	 */
	public abstract void setForwardEnabled(boolean forwardEnabled);

	/**
	 * @return the toEndEnabled
	 */
	public abstract boolean isToEndEnabled();

	/**
	 * @param toEndEnabled
	 *            the toEndEnabled to set
	 */
	public abstract void setToEndEnabled(boolean toEndEnabled);

	/**
	 * @return the animationStateHandler
	 */
	public abstract IAnimation getAnimationStateHandler();

	/**
	 * @param animationStateHandler
	 *            the animationStateHandler to set
	 */
	public abstract void setAnimationStateHandler(
			IAnimation animationStateHandler);

	/**
	 * @return the delay
	 */
	public abstract int getDelay();

	/**
	 * @param delay
	 *            the delay to set
	 */
	public abstract void setDelay(int delay);

	/**
	 * @return the delayEnabled
	 */
	public abstract boolean isDelayEnabled();

	/**
	 * @param delayEnabled
	 *            the delayEnabled to set
	 */
	public abstract void setDelayEnabled(boolean delayEnabled);

	/**
	 * @return the playEnabled
	 */
	public abstract boolean isPlayEnabled();

	/**
	 * @param playEnabled
	 *            the playEnabled to set
	 */
	public abstract void setPlayEnabled(boolean playEnabled);

	/**
	 * @return the pauseLabel
	 */
	public abstract String getPauseLabel();

	/**
	 * @param pauseLabel
	 *            the pauseLabel to set
	 */
	public abstract void setPauseLabel(String pauseLabel);

	/**
	 * @return the pauseActionCommand
	 */
	public abstract String getPauseActionCommand();

	/**
	 * @param pauseActionCommand
	 *            the pauseActionCommand to set
	 */
	public abstract void setPauseActionCommand(String pauseActionCommand);

	/**
	 * @return the pauseEnabled
	 */
	public abstract boolean isPauseEnabled();

	/**
	 * @param pauseEnabled
	 *            the pauseEnabled to set
	 */
	public abstract void setPauseEnabled(boolean pauseEnabled);

	/**
	 * @return the stopEnabled
	 */
	public abstract boolean isStopEnabled();

	/**
	 * @param stopEnabled
	 *            the stopEnabled to set
	 */
	public abstract void setStopEnabled(boolean stopEnabled);

	/**
	 * @return the protocol
	 */
	public abstract StringBuilder getProtocol();

	/**
	 * @param protocol
	 *            the protocol to set
	 */
	public abstract void setProtocol(StringBuilder protocol);

	/**
	 * @return the top
	 */
	public abstract Container getTop();

	/**
	 * @param top
	 *            the top to set
	 */
	public abstract void setTop(Container top);

}