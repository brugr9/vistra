package vistra.gui;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import vistra.core.graph.IObservableGravisGraph;
import vistra.core.traversal.Traversal;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.control.animation.IAnimationStateHandler;
import vistra.gui.control.parameter.IParameterStateHandler;
import vistra.gui.control.stepbystep.IStepByStepStateHandler;

/**
 * A model interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IModel {

	/**
	 * Sets the menuEnabled.
	 */
	public abstract void setMenuEnabled(boolean menuEnabled);

	/**
	 * Sets the playerEnabled.
	 */
	public abstract void setPlayerEnabled(boolean playerEnabled);

	/**
	 * Sets the animationEnabled.
	 */
	public abstract void setAnimationEnabled(boolean animationEnabled);

	/**
	 * Sets the stepByStepEnabled.
	 */
	public abstract void setStepByStepEnabled(boolean stepByStepEnabled);

	/**
	 * @return the i18nListener
	 */
	public abstract ActionListener getI18nListener();

	/**
	 * @return the helpListener
	 */
	public abstract ActionListener getHelpListener();

	/**
	 * @return the aboutListener
	 */
	public abstract ActionListener getAboutListener();

	/**
	 * @return the quitListener
	 */
	public abstract ActionListener getQuitListener();

	/**
	 * @return the resourceBundle
	 */
	public abstract ResourceBundle getResourceBundle();

	/**
	 * @return the i18nEnabled
	 */
	public abstract boolean isI18nEnabled();

	/**
	 * @return the deDEEnabled
	 */
	public abstract boolean isDeDEEnabled();

	/**
	 * @return the frFREnabled
	 */
	public abstract boolean isFrFREnabled();

	/**
	 * @return the enUSEnabled
	 */
	public abstract boolean isEnUSEnabled();

	/**
	 * @return the fileEnabled
	 */
	public abstract boolean isFileEnabled();

	/**
	 * @return the newMenuEnabled
	 */
	public abstract boolean isNewMenuEnabled();

	/**
	 * @return the undirectedGraphEnabled
	 */
	public abstract boolean isUndirectedGraphEnabled();

	/**
	 * @return the directedGraphEnabled
	 */
	public abstract boolean isDirectedGraphEnabled();

	/**
	 * @return the openGraphEnabled
	 */
	public abstract boolean isOpenGraphEnabled();

	/**
	 * @return the saveGraphEnabled
	 */
	public abstract boolean isSaveGraphEnabled();

	/**
	 * @return the saveGraphAsEnabled
	 */
	public abstract boolean isSaveGraphAsEnabled();

	/**
	 * @return the algorithmMenuEnabled
	 */
	public abstract boolean isAlgorithmMenuEnabled();

	/**
	 * @return the importAlgorithmEnabled
	 */
	public abstract boolean isImportAlgorithmEnabled();

	/**
	 * @return the deleteAlgorithmEnabled
	 */
	public abstract boolean isDeleteAlgorithmEnabled();

	/**
	 * @return the quitEnabled
	 */
	public abstract boolean isQuitEnabled();

	/**
	 * @return the infoEnabled
	 */
	public abstract boolean isInfoEnabled();

	/**
	 * @return the helpEnabled
	 */
	public abstract boolean isHelpEnabled();

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
	public abstract IObservableGravisGraph getGraph();

	/**
	 * @return the editGraphEnabled
	 */
	public abstract boolean isEditGraphEnabled();

	/**
	 * @return the graphSaved
	 */
	public abstract boolean isGraphSaved();

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
	public abstract Traversal getTraversal();

	/**
	 * @return the progress
	 */
	public abstract int getProgress();

	/**
	 * @return the progressMaximum
	 */
	public abstract int getProgressMaximum();

	/**
	 * @return the stepByStepStateHandler
	 */
	public abstract IStepByStepStateHandler getStepByStepStateHandler();

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
	 * @return the stringBuilder
	 */
	public abstract StringBuilder getStringBuilder();

	/**
	 * @param i18nListener
	 *            the i18nListener to set
	 */
	public abstract void setI18nListener(ActionListener i18nListener);

	/**
	 * @param helpListener
	 *            the helpListener to set
	 */
	public abstract void setHelpListener(ActionListener helpListener);

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
	 * @param resourceBundle
	 *            the resourceBundle to set
	 */
	public abstract void setResourceBundle(ResourceBundle resourceBundle);

	/**
	 * @param i18nEnabled
	 *            the i18nEnabled to set
	 */
	public abstract void setI18nEnabled(boolean i18nEnabled);

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
	 * @param enUSEnabled
	 *            the enUSEnabled to set
	 */
	public abstract void setEnUSEnabled(boolean enUSEnabled);

	/**
	 * @param fileEnabled
	 *            the fileEnabled to set
	 */
	public abstract void setFileEnabled(boolean fileEnabled);

	/**
	 * @param newMenuEnabled
	 *            the newMenuEnabled to set
	 */
	public abstract void setNewMenuEnabled(boolean newMenuEnabled);

	/**
	 * @param undirectedGraphEnabled
	 *            the undirectedGraphEnabled to set
	 */
	public abstract void setUndirectedGraphEnabled(
			boolean undirectedGraphEnabled);

	/**
	 * @param directedGraphEnabled
	 *            the directedGraphEnabled to set
	 */
	public abstract void setDirectedGraphEnabled(boolean directedGraphEnabled);

	/**
	 * @param openGraphEnabled
	 *            the openGraphEnabled to set
	 */
	public abstract void setOpenGraphEnabled(boolean openGraphEnabled);

	/**
	 * @param saveGraphEnabled
	 *            the saveGraphEnabled to set
	 */
	public abstract void setSaveGraphEnabled(boolean saveGraphEnabled);

	/**
	 * @param saveGraphAsEnabled
	 *            the saveGraphAsEnabled to set
	 */
	public abstract void setSaveGraphAsEnabled(boolean saveGraphAsEnabled);

	/**
	 * @param algorithmMenuEnabled
	 *            the algorithmMenuEnabled to set
	 */
	public abstract void setAlgorithmMenuEnabled(boolean algorithmMenuEnabled);

	/**
	 * @param importAlgorithmEnabled
	 *            the importAlgorithmEnabled to set
	 */
	public abstract void setImportAlgorithmEnabled(
			boolean importAlgorithmEnabled);

	/**
	 * @param deleteAlgorithmEnabled
	 *            the deleteAlgorithmEnabled to set
	 */
	public abstract void setDeleteAlgorithmEnabled(
			boolean deleteAlgorithmEnabled);

	/**
	 * @param quitEnabled
	 *            the quitEnabled to set
	 */
	public abstract void setQuitEnabled(boolean quitEnabled);

	/**
	 * @param infoEnabled
	 *            the infoEnabled to set
	 */
	public abstract void setInfoEnabled(boolean infoEnabled);

	/**
	 * @param helpEnabled
	 *            the helpEnabled to set
	 */
	public abstract void setHelpEnabled(boolean helpEnabled);

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
	public abstract void setGraph(IObservableGravisGraph graph);

	/**
	 * @param editGraphEnabled
	 *            the editGraphEnabled to set
	 */
	public abstract void setEditGraphEnabled(boolean editGraphEnabled);

	/**
	 * @param graphSaved
	 *            the graphSaved to set
	 */
	public abstract void setGraphSaved(boolean graphSaved);

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
	public abstract void setTraversal(Traversal traversal);

	/**
	 * @param progress
	 *            the progress to set
	 */
	public abstract void setProgress(int progress);

	/**
	 * @param progressMaximum
	 *            the progressMaximum to set
	 */
	public abstract void setProgressMaximum(int progressMaximum);

	/**
	 * @param stepByStepStateHandler
	 *            the stepByStepStateHandler to set
	 */
	public abstract void setStepByStepStateHandler(
			IStepByStepStateHandler stepByStepStateHandler);

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
	 * @param stringBuilder
	 *            the stringBuilder to set
	 */
	public abstract void setStringBuilder(StringBuilder stringBuilder);

}