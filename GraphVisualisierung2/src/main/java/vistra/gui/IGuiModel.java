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
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

/**
 * A gui model interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGuiModel {

	/**
	 * A grouped setter method for all menus.
	 * 
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	public abstract void setMenuEnabled(boolean menuEnabled);

	/**
	 * A grouped setter method for the menu file.
	 * 
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	public abstract void setMenuFileEnabled(boolean menuEnabled);

	/**
	 * A grouped setter method for the mode.
	 * 
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	public abstract void setMenuModeEnabled(boolean menuEnabled);

	/**
	 * A grouped setter method for the menu edit.
	 * 
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	public abstract void setMenuEditEnabled(boolean menuEnabled);

	/**
	 * A grouped setter method for the menu i18n.
	 * 
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	public abstract void setMenuI18nEnabled(boolean menuEnabled);

	/**
	 * A grouped setter method for the menu help.
	 * 
	 * @param menuEnabled
	 *            the menuEnabled to set
	 */
	public abstract void setMenuHelpEnabled(boolean menuEnabled);

	/**
	 * A grouped setter method for the traversal control.
	 * 
	 * @param enabled
	 *            the enabled to set
	 */
	public abstract void setTraversalEnabled(boolean enabled);

	/**
	 * A grouped setter method for the step-by-step control.
	 * 
	 * @param enabled
	 *            the enabled to set
	 */
	public abstract void setSbsEnabled(boolean enabled);

	/**
	 * A grouped setter method for the animation control.
	 * 
	 * @param enabled
	 *            the enabled to set
	 */
	public abstract void setAnimationEnabled(boolean enabled);

	/**
	 * @return the resourceBundle
	 */
	public abstract ResourceBundle getResourceBundle();

	/**
	 * @return the shortcutsMessage
	 */
	public abstract String getShortcutsMessage();

	/**
	 * @return the aboutMessage
	 */
	public abstract String getAboutMessage();

	/**
	 * @return the i18nListener
	 */
	public abstract ActionListener getI18nListener();

	/**
	 * @return the modeListener
	 */
	public abstract ActionListener getModeListener();

	/**
	 * @return the shortcutsListener
	 */
	public abstract ActionListener getShortcutsListener();

	/**
	 * @return the aboutListener
	 */
	public abstract ActionListener getAboutListener();

	/**
	 * @return the quitListener
	 */
	public abstract ActionListener getQuitListener();

	/**
	 * @return the fileEnabled
	 */
	public abstract boolean isFileEnabled();

	/**
	 * @return the newEnabled
	 */
	public abstract boolean isNewEnabled();

	/**
	 * @return the undirectedEnabled
	 */
	public abstract boolean isUndirectedEnabled();

	/**
	 * @return the directedEnabled
	 */
	public abstract boolean isDirectedEnabled();

	/**
	 * @return the openEnabled
	 */
	public abstract boolean isOpenEnabled();

	/**
	 * @return the saveEnabled
	 */
	public abstract boolean isSaveEnabled();

	/**
	 * @return the saveAsEnabled
	 */
	public abstract boolean isSaveAsEnabled();

	/**
	 * @return the quitEnabled
	 */
	public abstract boolean isQuitEnabled();

	/**
	 * @return the modeEnabled
	 */
	public abstract boolean isModeEnabled();

	/**
	 * @return the editingEnabled
	 */
	public abstract boolean isEditingEnabled();

	/**
	 * @return the pickingEnabled
	 */
	public abstract boolean isPickingEnabled();

	/**
	 * @return the vertexEnabled
	 */
	public abstract boolean isVertexEnabled();

	/**
	 * @return the edgeEnabled
	 */
	public abstract boolean isEdgeEnabled();

	/**
	 * @return the i18nEnabled
	 */
	public abstract boolean isI18nEnabled();

	/**
	 * @return the deCHEnabled
	 */
	public abstract boolean isDeCHEnabled();

	/**
	 * @return the deDEEnabled
	 */
	public abstract boolean isDeDEEnabled();

	/**
	 * @return the frFREnabled
	 */
	public abstract boolean isFrFREnabled();

	/**
	 * @return the enGBEnabled
	 */
	public abstract boolean isEnGBEnabled();

	/**
	 * @return the enUSEnabled
	 */
	public abstract boolean isEnUSEnabled();

	/**
	 * @return the helpEnabled
	 */
	public abstract boolean isHelpEnabled();

	/**
	 * @return the shortcutsEnabled
	 */
	public abstract boolean isShortcutsEnabled();

	/**
	 * @return the aboutEnabled
	 */
	public abstract boolean isAboutEnabled();

	/**
	 * @return the parameterStateHandler
	 */
	public abstract IParameterStateHandler getParameterStateHandler();

	/**
	 * @return the graph
	 */
	public abstract IExtendedGraph getGraph();

	/**
	 * @return the start
	 */
	public abstract IVertexLayout getStart();

	/**
	 * @return the end
	 */
	public abstract IVertexLayout getEnd();

	/**
	 * @return the graphFile
	 */
	public abstract boolean isGraphFile();

	/**
	 * @return the graphSaved
	 */
	public abstract boolean isGraphSaved();

	/**
	 * @return the mode
	 */
	public abstract Mode getMode();

	/**
	 * @return the algorithms
	 */
	public abstract String[] getAlgorithms();

	/**
	 * @return the algorithmsEnabled
	 */
	public abstract boolean isAlgorithmsEnabled();

	/**
	 * @return the selectedAlgorithmIndex
	 */
	public abstract int getSelectedAlgorithmIndex();

	/**
	 * @return the algorithmDescription
	 */
	public abstract String getAlgorithmDescription();

	/**
	 * @return the traversal
	 */
	public abstract ITraversal getTraversal();

	/**
	 * @return the progress
	 */
	public abstract int getProgress();

	/**
	 * @return the stepByStepStateHandler
	 */
	public abstract ISbsStateHandler getSbsStateHandler();

	/**
	 * @return the steplength
	 */
	public abstract int getSteplength();

	/**
	 * @return the steplengthEnabled
	 */
	public abstract boolean isSteplengthEnabled();

	/**
	 * @return the toBeginningEnabled
	 */
	public abstract boolean isToBeginningEnabled();

	/**
	 * @return the backwardEnabled
	 */
	public abstract boolean isBackwardEnabled();

	/**
	 * @return the forwardEnabled
	 */
	public abstract boolean isForwardEnabled();

	/**
	 * @return the toEndEnabled
	 */
	public abstract boolean isToEndEnabled();

	/**
	 * @return the animationStateHandler
	 */
	public abstract IAnimationStateHandler getAnimationStateHandler();

	/**
	 * @return the delay
	 */
	public abstract int getDelay();

	/**
	 * @return the delayEnabled
	 */
	public abstract boolean isDelayEnabled();

	/**
	 * @return the playEnabled
	 */
	public abstract boolean isPlayEnabled();

	/**
	 * @return the pauseLabel
	 */
	public abstract String getPauseLabel();

	/**
	 * @return the pauseEvent
	 */
	public abstract EventSource getPauseEvent();

	/**
	 * @return the pauseEnabled
	 */
	public abstract boolean isPauseEnabled();

	/**
	 * @return the stopEnabled
	 */
	public abstract boolean isStopEnabled();

	/**
	 * @return the protocol
	 */
	public abstract StringBuilder getProtocol();

	/**
	 * @param resourceBundle
	 *            the resourceBundle to set
	 */
	public abstract void setResourceBundle(ResourceBundle resourceBundle);

	/**
	 * @param shortcutsMessage
	 *            the shortcutsMessage to set
	 */
	public abstract void setShortcutsMessage(String shortcutsMessage);

	/**
	 * @param aboutMessage
	 *            the aboutMessage to set
	 */
	public abstract void setAboutMessage(String aboutMessage);

	/**
	 * @param i18nListener
	 *            the i18nListener to set
	 */
	public abstract void setI18nListener(ActionListener i18nListener);

	/**
	 * @param modeListener
	 *            the modeListener to set
	 */
	public abstract void setModeListener(ActionListener modeListener);

	/**
	 * @param shortcutsListener
	 *            the shortcutsListener to set
	 */
	public abstract void setShortcutsListener(ActionListener shortcutsListener);

	/**
	 * @param aboutListener
	 *            the aboutListener to set
	 */
	public abstract void setAboutListener(ActionListener aboutListener);

	/**
	 * @param quitListener
	 *            the quitListener to set
	 */
	public abstract void setQuitListener(ActionListener quitListener);

	/**
	 * @param fileEnabled
	 *            the fileEnabled to set
	 */
	public abstract void setFileEnabled(boolean fileEnabled);

	/**
	 * @param newEnabled
	 *            the newEnabled to set
	 */
	public abstract void setNewEnabled(boolean newEnabled);

	/**
	 * @param undirectedEnabled
	 *            the undirectedEnabled to set
	 */
	public abstract void setUndirectedEnabled(boolean undirectedEnabled);

	/**
	 * @param directedEnabled
	 *            the directedEnabled to set
	 */
	public abstract void setDirectedEnabled(boolean directedEnabled);

	/**
	 * @param openEnabled
	 *            the openEnabled to set
	 */
	public abstract void setOpenEnabled(boolean openEnabled);

	/**
	 * @param saveEnabled
	 *            the saveEnabled to set
	 */
	public abstract void setSaveEnabled(boolean saveEnabled);

	/**
	 * @param saveAsEnabled
	 *            the saveAsEnabled to set
	 */
	public abstract void setSaveAsEnabled(boolean saveAsEnabled);

	/**
	 * @param quitEnabled
	 *            the quitEnabled to set
	 */
	public abstract void setQuitEnabled(boolean quitEnabled);

	/**
	 * @param modeEnabled
	 *            the modeEnabled to set
	 */
	public abstract void setModeEnabled(boolean modeEnabled);

	/**
	 * @param editingEnabled
	 *            the editingEnabled to set
	 */
	public abstract void setEditingEnabled(boolean editingEnabled);

	/**
	 * @param pickingEnabled
	 *            the pickingEnabled to set
	 */
	public abstract void setPickingEnabled(boolean pickingEnabled);

	/**
	 * @param vertexEnabled
	 *            the vertexEnabled to set
	 */
	public abstract void setVertexEnabled(boolean vertexEnabled);

	/**
	 * @param edgeEnabled
	 *            the edgeEnabled to set
	 */
	public abstract void setEdgeEnabled(boolean edgeEnabled);

	/**
	 * @param i18nEnabled
	 *            the i18nEnabled to set
	 */
	public abstract void setI18nEnabled(boolean i18nEnabled);

	/**
	 * @param deCHEnabled
	 *            the deCHEnabled to set
	 */
	public abstract void setDeCHEnabled(boolean deCHEnabled);

	/**
	 * @param deDEEnabled
	 *            the deDEEnabled to set
	 */
	public abstract void setDeDEEnabled(boolean deDEEnabled);

	/**
	 * @param frFREnabled
	 *            the frFREnabled to set
	 */
	public abstract void setFrFREnabled(boolean frFREnabled);

	/**
	 * @param enGBEnabled
	 *            the enGBEnabled to set
	 */
	public abstract void setEnGBEnabled(boolean enGBEnabled);

	/**
	 * @param enUSEnabled
	 *            the enUSEnabled to set
	 */
	public abstract void setEnUSEnabled(boolean enUSEnabled);

	/**
	 * @param helpEnabled
	 *            the helpEnabled to set
	 */
	public abstract void setHelpEnabled(boolean helpEnabled);

	/**
	 * @param shortcutsEnabled
	 *            the shortcutsEnabled to set
	 */
	public abstract void setShortcutsEnabled(boolean shortcutsEnabled);

	/**
	 * @param aboutEnabled
	 *            the aboutEnabled to set
	 */
	public abstract void setAboutEnabled(boolean aboutEnabled);

	/**
	 * @param parameterStateHandler
	 *            the parameterStateHandler to set
	 */
	public abstract void setParameterStateHandler(
			IParameterStateHandler parameterStateHandler);

	/**
	 * @param graph
	 *            the graph to set
	 */
	public abstract void setGraph(IExtendedGraph graph);

	/**
	 * @param start
	 *            the start to set
	 */
	public abstract void setStart(IVertexLayout start);

	/**
	 * @param end
	 *            the end to set
	 */
	public abstract void setEnd(IVertexLayout end);

	/**
	 * @param graphFile
	 *            the graphFile to set
	 */
	public abstract void setGraphFile(boolean graphFile);

	/**
	 * @param graphSaved
	 *            the graphSaved to set
	 */
	public abstract void setGraphSaved(boolean graphSaved);

	/**
	 * @param mode
	 *            the mode to set
	 */
	public abstract void setMode(Mode mode);

	/**
	 * @param algorithms
	 *            the algorithms to set
	 */
	public abstract void setAlgorithms(String[] algorithms);

	/**
	 * @param algorithmsEnabled
	 *            the algorithmsEnabled to set
	 */
	public abstract void setAlgorithmsEnabled(boolean algorithmsEnabled);

	/**
	 * @param selectedAlgorithmIndex
	 *            the selectedAlgorithmIndex to set
	 */
	public abstract void setSelectedAlgorithmIndex(int selectedAlgorithmIndex);

	/**
	 * @param algorithmDescription
	 *            the algorithmDescription to set
	 */
	public abstract void setAlgorithmDescription(String algorithmDescription);

	/**
	 * @param traversal
	 *            the traversal to set
	 */
	public abstract void setTraversal(ITraversal traversal);

	/**
	 * @param progress
	 *            the progress to set
	 */
	public abstract void setProgress(int progress);

	/**
	 * @param stepByStepStateHandler
	 *            the stepByStepStateHandler to set
	 */
	public abstract void setSbsStateHandler(
			ISbsStateHandler stepByStepStateHandler);

	/**
	 * @param steplength
	 *            the steplength to set
	 */
	public abstract void setSteplength(int steplength);

	/**
	 * @param steplengthEnabled
	 *            the steplengthEnabled to set
	 */
	public abstract void setSteplengthEnabled(boolean steplengthEnabled);

	/**
	 * @param toBeginningEnabled
	 *            the toBeginningEnabled to set
	 */
	public abstract void setToBeginningEnabled(boolean toBeginningEnabled);

	/**
	 * @param backwardEnabled
	 *            the backwardEnabled to set
	 */
	public abstract void setBackwardEnabled(boolean backwardEnabled);

	/**
	 * @param forwardEnabled
	 *            the forwardEnabled to set
	 */
	public abstract void setForwardEnabled(boolean forwardEnabled);

	/**
	 * @param toEndEnabled
	 *            the toEndEnabled to set
	 */
	public abstract void setToEndEnabled(boolean toEndEnabled);

	/**
	 * @param animationStateHandler
	 *            the animationStateHandler to set
	 */
	public abstract void setAnimationStateHandler(
			IAnimationStateHandler animationStateHandler);

	/**
	 * @param delay
	 *            the delay to set
	 */
	public abstract void setDelay(int delay);

	/**
	 * @param delayEnabled
	 *            the delayEnabled to set
	 */
	public abstract void setDelayEnabled(boolean delayEnabled);

	/**
	 * @param playEnabled
	 *            the playEnabled to set
	 */
	public abstract void setPlayEnabled(boolean playEnabled);

	/**
	 * @param pauseLabel
	 *            the pauseLabel to set
	 */
	public abstract void setPauseLabel(String pauseLabel);

	/**
	 * @param pauseEvent
	 *            the pauseEvent to set
	 */
	public abstract void setPauseEvent(EventSource pauseEvent);

	/**
	 * @param pauseEnabled
	 *            the pauseEnabled to set
	 */
	public abstract void setPauseEnabled(boolean pauseEnabled);

	/**
	 * @param stopEnabled
	 *            the stopEnabled to set
	 */
	public abstract void setStopEnabled(boolean stopEnabled);

	/**
	 * @param protocol
	 *            the protocol to set
	 */
	public abstract void setProtocol(StringBuilder protocol);

}