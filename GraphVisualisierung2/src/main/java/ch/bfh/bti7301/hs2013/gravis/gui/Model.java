package ch.bfh.bti7301.hs2013.gravis.gui;

import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.KeyStroke;

/**
 * A model as in MVC containing some fields and its getter and setter methods.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class Model extends Observable {

	// ViewType elements
	private String programName;
	private String i18nBaseName;
	private ResourceBundle resourceBundle;

	// MenuBar
	private String fileMenuLabel;
	private String importAlgorithmLabel;
	private String deleteAlgorithmLabel;
	private String importGraphLabel;
	private String deleteGraphLabel;
	private String quitLabel;
	private String i18nMenuLabel;
	private String deDEMenuItemLabel;
	private String frFRMenuItemLabel;
	private String enUSMenuItemLabel;
	private String infoMenuLabel;
	private String helpMenuItemLabel;
	private String aboutMenuItemLabel;

	private char fileMenuMnemonic;
	private char renderMnemonic;
	private char saveGraphMnemonic;
	private char quitMenuItemMnemonic;
	private char i18nMenuMnemonic;
	private char deDEMenuItemMnemonic;
	private char frFRMenuItemMnemonic;
	private char enUSMenuItemMnemonic;
	private char infoMenuMnemonic;
	private char helpMenuItemMnemonic;
	private char aboutMenuItemMnemonic;

	private KeyStroke renderMenuItemAccelerator;
	private KeyStroke quitMenuItemAccelerator;
	private KeyStroke helpMenuItemAccelerator;
	private KeyStroke aboutMenuItemAccelerator;

	private boolean fileMenuEnabled;
	private boolean importAlgorithmMenuItemEnabled;
	private boolean deleteAlgorithmMenuItemEnabled;
	private boolean importGraphMenuItemEnabled;
	private boolean saveGraphEnabled;
	private boolean exportGraphMenuItemEnabled;
	private boolean deleteGraphMenuItemEnabled;
	private boolean renderMenuItemEnabled;
	private boolean quitMenuItemEnabled;
	private boolean i18nMenuEnabled;
	private boolean deDEMenuItemEnabled;
	private boolean frFRMenuItemEnabled;
	private boolean enUSMenuItemEnabled;
	private boolean infoMenuEnabled;
	private boolean helpMenuItemEnabled;
	private boolean aboutMenuItemEnabled;

	// Parameter Panel
	private String renderPanelLabel;
	private String algorithmLabel;
	private String graphLabel;

	private String[] graphComboModel;
	private String[] algorithmComboModel;

	private int algorithmSelected;
	private int graphSelected;

	private boolean algorithmEnabled;
	private boolean graphEnabled;

	// VisualizationPanel
	private String visualizationPanelLabel;

	// Player Panel
	private String playerPanelLabel;

	private String delayLabel;
	private int delayValue;
	private boolean delayEnabled;

	private String stepLabel;
	private int stepValue;
	private boolean stepEnabled;

	private String progressLabel;
	private int progressValue;
	private int progressValueMaximum;

	private String playButtonLabel;
	private boolean playButtonEnabled;
	private KeyStroke playAccelerator;

	private String pauseButtonLabel;
	private boolean pauseButtonEnabled;
	private String pauseButtonActionCommand;
	private KeyStroke pauseAccelerator;

	private String stopButtonLabel;
	private boolean stopButtonEnabled;
	private KeyStroke stopAccelerator;

	private String homeButtonLabel;
	private boolean homeButtonEnabled;
	private KeyStroke homeAccelerator;

	private String backwardButtonLabel;
	private char backwardButtonMnemonic;
	private boolean backwardButtonEnabled;
	private KeyStroke backwardAccelerator;

	private String forwardButtonLabel;
	private boolean forwardButtonEnabled;
	private KeyStroke forwardAccelerator;

	private String endButtonLabel;
	private boolean endButtonEnabled;
	private KeyStroke endAccelerator;

	// Protocol Panel
	private String protocolPanelLabel;
	private String protocolPanelText;

	// IO Pane
	private String importLabel;
	private String deleteLabel;

	// Help Pane
	private String helpMessageLabel;
	private String helpMessageText;

	// About Pane
	private String aboutMessageLabel;
	private String aboutMessageText;

	// Quit
	private String quitMessageText;

	/**
	 * Main constructor.
	 */
	public Model() {
		super();
		this.programName = "";
		this.i18nBaseName = "";
		this.resourceBundle = null;
		this.fileMenuLabel = "";
		this.importAlgorithmLabel = "";
		this.deleteAlgorithmLabel = "";
		this.importGraphLabel = "";
		this.deleteGraphLabel = "";
		this.quitLabel = "";
		this.i18nMenuLabel = "";
		this.deDEMenuItemLabel = "";
		this.frFRMenuItemLabel = "";
		this.enUSMenuItemLabel = "";
		this.infoMenuLabel = "";
		this.helpMenuItemLabel = "";
		this.aboutMenuItemLabel = "";
		this.fileMenuMnemonic = ' ';
		this.saveGraphMnemonic = ' ';
		this.renderMnemonic = ' ';
		this.quitMenuItemMnemonic = ' ';
		this.i18nMenuMnemonic = ' ';
		this.deDEMenuItemMnemonic = ' ';
		this.frFRMenuItemMnemonic = ' ';
		this.enUSMenuItemMnemonic = ' ';
		this.infoMenuMnemonic = ' ';
		this.helpMenuItemMnemonic = ' ';
		this.aboutMenuItemMnemonic = ' ';
		this.renderMenuItemAccelerator = null;
		this.quitMenuItemAccelerator = null;
		this.helpMenuItemAccelerator = null;
		this.aboutMenuItemAccelerator = null;

		this.fileMenuEnabled = false;
		this.importAlgorithmMenuItemEnabled = false;
		this.deleteAlgorithmMenuItemEnabled = false;
		this.importGraphMenuItemEnabled = false;
		this.saveGraphEnabled = false;
		this.exportGraphMenuItemEnabled = false;
		this.deleteGraphMenuItemEnabled = false;
		this.renderMenuItemEnabled = false;
		this.quitMenuItemEnabled = false;
		this.i18nMenuEnabled = false;
		this.deDEMenuItemEnabled = false;
		this.frFRMenuItemEnabled = false;
		this.enUSMenuItemEnabled = false;
		this.infoMenuEnabled = false;
		this.helpMenuItemEnabled = false;
		this.aboutMenuItemEnabled = false;

		this.renderPanelLabel = "";
		this.algorithmLabel = "";
		this.graphLabel = "";
		this.algorithmSelected = 0;
		this.graphSelected = 0;
		this.graphComboModel = new String[] {};
		this.algorithmComboModel = new String[] {};
		this.algorithmEnabled = false;
		this.graphEnabled = false;

		this.visualizationPanelLabel = "";

		this.delayLabel = "";
		this.stepLabel = "";
		this.playerPanelLabel = "";
		this.playButtonLabel = "";
		this.pauseButtonLabel = "";
		this.stopButtonLabel = "";
		this.homeButtonLabel = "";
		this.backwardButtonLabel = "";
		this.forwardButtonLabel = "";
		this.endButtonLabel = "";

		this.delayValue = 1;
		this.stepValue = 1;
		this.progressLabel = "";
		this.progressValue = 0;
		this.progressValueMaximum = 0;
		this.pauseButtonActionCommand = "";

		this.delayEnabled = false;
		this.stepEnabled = false;
		this.playButtonEnabled = false;
		this.pauseButtonEnabled = false;
		this.stopButtonEnabled = false;
		this.homeButtonEnabled = false;
		this.backwardButtonEnabled = false;
		this.forwardButtonEnabled = false;
		this.endButtonEnabled = false;

		this.playAccelerator = null;
		this.pauseAccelerator = null;
		this.stopAccelerator = null;
		this.homeAccelerator = null;
		this.backwardAccelerator = null;
		this.forwardAccelerator = null;
		this.endAccelerator = null;

		this.protocolPanelLabel = "";
		this.protocolPanelText = "";
		this.importLabel = "";
		this.deleteLabel = "";
		this.helpMessageLabel = "";
		this.helpMessageText = "";
		this.aboutMessageLabel = "";
		this.aboutMessageText = "";
		this.quitMessageText = "";
	}

	/**
	 * Disables or enables the menu elements.
	 * 
	 * @param enabled
	 */
	protected void setMenuEnabled(boolean enabled) {
		// Menu
		this.setFileMenuEnabled(enabled);
		this.setI18nMenuEnabled(enabled);
		this.setInfoMenuEnabled(enabled);
		// MenuItem
		// (...)
		this.setImportAlgorithmMenuItemEnabled(enabled);
		this.setDeleteAlgorithmMenuItemEnabled(enabled);
		this.setImportGraphMenuItemEnabled(enabled);
		this.setDeleteGraphMenuItemEnabled(enabled);
		this.setQuitMenuItemEnabled(enabled);
		// (...)
		this.setDeDEMenuItemEnabled(enabled);
		this.setFrFRMenuItemEnabled(enabled);
		this.setEnUSMenuItemEnabled(enabled);
		// (...)
		this.setHelpMenuItemEnabled(enabled);
		this.setAboutMenuItemEnabled(enabled);

		this.setChanged();
	}

	/**
	 * Disables or enables render parameter.
	 * 
	 * @param enabled
	 */
	protected void setParameterEnabled(boolean enabled) {
		this.setGraphEnabled(enabled);
		this.setAlgorithmEnabled(enabled);

		this.setChanged();
	}

	/**
	 * Disables or enables player elements.
	 * 
	 * @param enabled
	 */
	protected void setPlayerEnabled(boolean enabled) {
		this.setStepEnabled(enabled);
		this.setDelayEnabled(enabled);
		this.setPlayButtonEnabled(enabled);
		this.setPauseButtonEnabled(enabled);
		this.setStopButtonEnabled(enabled);
		this.setStepByStepEnabled(enabled);

		this.setChanged();
	}

	/**
	 * Disables or enables the players step-by-step elements.
	 * 
	 * @param enabled
	 */
	protected void setStepByStepEnabled(boolean enabled) {
		this.setHomeButtonEnabled(enabled);
		this.setBackwardButtonEnabled(enabled);
		this.setForwardButtonEnabled(enabled);
		this.setEndButtonEnabled(enabled);

		this.setChanged();
	}

	/**
	 * @return the programName
	 */
	protected String getProgramName() {
		return programName;
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
	 * @return the fileMenuLabel
	 */
	protected String getFileMenuLabel() {
		return fileMenuLabel;
	}

	/**
	 * @return the importAlgorithmLabel
	 */
	protected String getImportAlgorithmLabel() {
		return importAlgorithmLabel;
	}

	/**
	 * @return the deleteAlgorithmLabel
	 */
	protected String getDeleteAlgorithmLabel() {
		return deleteAlgorithmLabel;
	}

	/**
	 * @return the importGraphLabel
	 */
	protected String getImportGraphLabel() {
		return importGraphLabel;
	}

	/**
	 * @return the deleteGraphLabel
	 */
	protected String getDeleteGraphLabel() {
		return deleteGraphLabel;
	}

	/**
	 * @return the quitLabel
	 */
	protected String getQuitLabel() {
		return quitLabel;
	}

	/**
	 * @return the i18nMenuLabel
	 */
	protected String getI18nMenuLabel() {
		return i18nMenuLabel;
	}

	/**
	 * @return the deDEMenuItemLabel
	 */
	protected String getDeDEMenuItemLabel() {
		return deDEMenuItemLabel;
	}

	/**
	 * @return the frFRMenuItemLabel
	 */
	protected String getFrFRMenuItemLabel() {
		return frFRMenuItemLabel;
	}

	/**
	 * @return the enUSMenuItemLabel
	 */
	protected String getEnUSMenuItemLabel() {
		return enUSMenuItemLabel;
	}

	/**
	 * @return the infoMenuLabel
	 */
	protected String getInfoMenuLabel() {
		return infoMenuLabel;
	}

	/**
	 * @return the helpMenuItemLabel
	 */
	protected String getHelpMenuItemLabel() {
		return helpMenuItemLabel;
	}

	/**
	 * @return the aboutMenuItemLabel
	 */
	protected String getAboutMenuItemLabel() {
		return aboutMenuItemLabel;
	}

	/**
	 * @return the fileMenuMnemonic
	 */
	protected char getFileMenuMnemonic() {
		return fileMenuMnemonic;
	}

	/**
	 * @return the renderMnemonic
	 */
	protected char getRenderMnemonic() {
		return renderMnemonic;
	}

	/**
	 * @return the saveGraphMnemonic
	 */
	protected char getSaveGraphMnemonic() {
		return saveGraphMnemonic;
	}

	/**
	 * @return the quitMenuItemMnemonic
	 */
	protected char getQuitMenuItemMnemonic() {
		return quitMenuItemMnemonic;
	}

	/**
	 * @return the i18nMenuMnemonic
	 */
	protected char getI18nMenuMnemonic() {
		return i18nMenuMnemonic;
	}

	/**
	 * @return the deDEMenuItemMnemonic
	 */
	protected char getDeDEMenuItemMnemonic() {
		return deDEMenuItemMnemonic;
	}

	/**
	 * @return the frFRMenuItemMnemonic
	 */
	protected char getFrFRMenuItemMnemonic() {
		return frFRMenuItemMnemonic;
	}

	/**
	 * @return the enUSMenuItemMnemonic
	 */
	protected char getEnUSMenuItemMnemonic() {
		return enUSMenuItemMnemonic;
	}

	/**
	 * @return the infoMenuMnemonic
	 */
	protected char getInfoMenuMnemonic() {
		return infoMenuMnemonic;
	}

	/**
	 * @return the helpMenuItemMnemonic
	 */
	protected char getHelpMenuItemMnemonic() {
		return helpMenuItemMnemonic;
	}

	/**
	 * @return the aboutMenuItemMnemonic
	 */
	protected char getAboutMenuItemMnemonic() {
		return aboutMenuItemMnemonic;
	}

	/**
	 * @return the renderMenuItemAccelerator
	 */
	protected KeyStroke getRenderMenuItemAccelerator() {
		return renderMenuItemAccelerator;
	}

	/**
	 * @return the quitMenuItemAccelerator
	 */
	protected KeyStroke getQuitMenuItemAccelerator() {
		return quitMenuItemAccelerator;
	}

	/**
	 * @return the helpMenuItemAccelerator
	 */
	protected KeyStroke getHelpMenuItemAccelerator() {
		return helpMenuItemAccelerator;
	}

	/**
	 * @return the aboutMenuItemAccelerator
	 */
	protected KeyStroke getAboutMenuItemAccelerator() {
		return aboutMenuItemAccelerator;
	}

	/**
	 * @return the fileMenuEnabled
	 */
	protected boolean isFileMenuEnabled() {
		return fileMenuEnabled;
	}

	/**
	 * @return the importAlgorithmMenuItemEnabled
	 */
	protected boolean isImportAlgorithmMenuItemEnabled() {
		return importAlgorithmMenuItemEnabled;
	}

	/**
	 * @return the deleteAlgorithmMenuItemEnabled
	 */
	protected boolean isDeleteAlgorithmMenuItemEnabled() {
		return deleteAlgorithmMenuItemEnabled;
	}

	/**
	 * @return the importGraphMenuItemEnabled
	 */
	protected boolean isImportGraphMenuItemEnabled() {
		return importGraphMenuItemEnabled;
	}

	/**
	 * @return the saveGraphEnabled
	 */
	protected boolean isSaveGraphEnabled() {
		return saveGraphEnabled;
	}

	/**
	 * @return the exportGraphMenuItemEnabled
	 */
	protected boolean isExportGraphMenuItemEnabled() {
		return exportGraphMenuItemEnabled;
	}

	/**
	 * @return the deleteGraphMenuItemEnabled
	 */
	protected boolean isDeleteGraphMenuItemEnabled() {
		return deleteGraphMenuItemEnabled;
	}

	/**
	 * @return the renderMenuItemEnabled
	 */
	protected boolean isRenderMenuItemEnabled() {
		return renderMenuItemEnabled;
	}

	/**
	 * @return the quitMenuItemEnabled
	 */
	protected boolean isQuitMenuItemEnabled() {
		return quitMenuItemEnabled;
	}

	/**
	 * @return the i18nMenuEnabled
	 */
	protected boolean isI18nMenuEnabled() {
		return i18nMenuEnabled;
	}

	/**
	 * @return the deDEMenuItemEnabled
	 */
	protected boolean isDeDEMenuItemEnabled() {
		return deDEMenuItemEnabled;
	}

	/**
	 * @return the frFRMenuItemEnabled
	 */
	protected boolean isFrFRMenuItemEnabled() {
		return frFRMenuItemEnabled;
	}

	/**
	 * @return the enUSMenuItemEnabled
	 */
	protected boolean isEnUSMenuItemEnabled() {
		return enUSMenuItemEnabled;
	}

	/**
	 * @return the infoMenuEnabled
	 */
	protected boolean isInfoMenuEnabled() {
		return infoMenuEnabled;
	}

	/**
	 * @return the helpMenuItemEnabled
	 */
	protected boolean isHelpMenuItemEnabled() {
		return helpMenuItemEnabled;
	}

	/**
	 * @return the aboutMenuItemEnabled
	 */
	protected boolean isAboutMenuItemEnabled() {
		return aboutMenuItemEnabled;
	}

	/**
	 * @return the renderPanelLabel
	 */
	protected String getRenderPanelLabel() {
		return renderPanelLabel;
	}

	/**
	 * @return the algorithmLabel
	 */
	protected String getAlgorithmLabel() {
		return algorithmLabel;
	}

	/**
	 * @return the graphLabel
	 */
	protected String getGraphLabel() {
		return graphLabel;
	}

	/**
	 * @return the graphComboModel
	 */
	protected String[] getGraphComboModel() {
		return graphComboModel;
	}

	/**
	 * @return the algorithmComboModel
	 */
	protected String[] getAlgorithmComboModel() {
		return algorithmComboModel;
	}

	/**
	 * @return the algorithmSelected
	 */
	protected int getAlgorithmSelected() {
		return algorithmSelected;
	}

	/**
	 * @return the graphSelected
	 */
	protected int getGraphSelected() {
		return graphSelected;
	}

	/**
	 * @return the algorithmEnabled
	 */
	protected boolean isAlgorithmEnabled() {
		return algorithmEnabled;
	}

	/**
	 * @return the graphEnabled
	 */
	protected boolean isGraphEnabled() {
		return graphEnabled;
	}

	/**
	 * @return the visualizationPanelLabel
	 */
	protected String getVisualizationPanelLabel() {
		return visualizationPanelLabel;
	}

	/**
	 * @return the playerPanelLabel
	 */
	protected String getPlayerPanelLabel() {
		return playerPanelLabel;
	}

	/**
	 * @return the delayLabel
	 */
	protected String getDelayLabel() {
		return delayLabel;
	}

	/**
	 * @return the delayValue
	 */
	protected int getDelayValue() {
		return delayValue;
	}

	/**
	 * @return the delayEnabled
	 */
	protected boolean isDelayEnabled() {
		return delayEnabled;
	}

	/**
	 * @return the stepLabel
	 */
	protected String getStepLabel() {
		return stepLabel;
	}

	/**
	 * @return the stepValue
	 */
	protected int getStepValue() {
		return stepValue;
	}

	/**
	 * @return the stepEnabled
	 */
	protected boolean isStepEnabled() {
		return stepEnabled;
	}

	/**
	 * @return the progressLabel
	 */
	protected String getProgressLabel() {
		return progressLabel;
	}

	/**
	 * @return the progressValue
	 */
	protected int getProgressValue() {
		return progressValue;
	}

	/**
	 * @return the progressValueMaximum
	 */
	protected int getProgressValueMaximum() {
		return progressValueMaximum;
	}

	/**
	 * @return the playButtonLabel
	 */
	protected String getPlayButtonLabel() {
		return playButtonLabel;
	}

	/**
	 * @return the playButtonEnabled
	 */
	protected boolean isPlayButtonEnabled() {
		return playButtonEnabled;
	}

	/**
	 * @return the playAccelerator
	 */
	protected KeyStroke getPlayAccelerator() {
		return playAccelerator;
	}

	/**
	 * @return the pauseButtonLabel
	 */
	protected String getPauseButtonLabel() {
		return pauseButtonLabel;
	}

	/**
	 * @return the pauseButtonEnabled
	 */
	protected boolean isPauseButtonEnabled() {
		return pauseButtonEnabled;
	}

	/**
	 * @return the pauseButtonActionCommand
	 */
	protected String getPauseButtonActionCommand() {
		return pauseButtonActionCommand;
	}

	/**
	 * @return the pauseAccelerator
	 */
	protected KeyStroke getPauseAccelerator() {
		return pauseAccelerator;
	}

	/**
	 * @return the stopButtonLabel
	 */
	protected String getStopButtonLabel() {
		return stopButtonLabel;
	}

	/**
	 * @return the stopButtonEnabled
	 */
	protected boolean isStopButtonEnabled() {
		return stopButtonEnabled;
	}

	/**
	 * @return the stopAccelerator
	 */
	protected KeyStroke getStopAccelerator() {
		return stopAccelerator;
	}

	/**
	 * @return the homeButtonLabel
	 */
	protected String getHomeButtonLabel() {
		return homeButtonLabel;
	}

	/**
	 * @return the homeButtonEnabled
	 */
	protected boolean isHomeButtonEnabled() {
		return homeButtonEnabled;
	}

	/**
	 * @return the homeAccelerator
	 */
	protected KeyStroke getHomeAccelerator() {
		return homeAccelerator;
	}

	/**
	 * @return the backwardButtonLabel
	 */
	protected String getBackwardButtonLabel() {
		return backwardButtonLabel;
	}

	/**
	 * @return the backwardButtonMnemonic
	 */
	protected char getBackwardButtonMnemonic() {
		return backwardButtonMnemonic;
	}

	/**
	 * @return the backwardButtonEnabled
	 */
	protected boolean isBackwardButtonEnabled() {
		return backwardButtonEnabled;
	}

	/**
	 * @return the backwardAccelerator
	 */
	protected KeyStroke getBackwardAccelerator() {
		return backwardAccelerator;
	}

	/**
	 * @return the forwardButtonLabel
	 */
	protected String getForwardButtonLabel() {
		return forwardButtonLabel;
	}

	/**
	 * @return the forwardButtonEnabled
	 */
	protected boolean isForwardButtonEnabled() {
		return forwardButtonEnabled;
	}

	/**
	 * @return the forwardAccelerator
	 */
	protected KeyStroke getForwardAccelerator() {
		return forwardAccelerator;
	}

	/**
	 * @return the endButtonLabel
	 */
	protected String getEndButtonLabel() {
		return endButtonLabel;
	}

	/**
	 * @return the endButtonEnabled
	 */
	protected boolean isEndButtonEnabled() {
		return endButtonEnabled;
	}

	/**
	 * @return the endAccelerator
	 */
	protected KeyStroke getEndAccelerator() {
		return endAccelerator;
	}

	/**
	 * @return the protocolPanelLabel
	 */
	protected String getProtocolPanelLabel() {
		return protocolPanelLabel;
	}

	/**
	 * @return the protocolPanelText
	 */
	protected String getProtocolPanelText() {
		return protocolPanelText;
	}

	/**
	 * @return the importLabel
	 */
	protected String getImportLabel() {
		return importLabel;
	}

	/**
	 * @return the deleteLabel
	 */
	protected String getDeleteLabel() {
		return deleteLabel;
	}

	/**
	 * @return the helpMessageLabel
	 */
	protected String getHelpMessageLabel() {
		return helpMessageLabel;
	}

	/**
	 * @return the helpMessageText
	 */
	protected String getHelpMessageText() {
		return helpMessageText;
	}

	/**
	 * @return the aboutMessageLabel
	 */
	protected String getAboutMessageLabel() {
		return aboutMessageLabel;
	}

	/**
	 * @return the aboutMessageText
	 */
	protected String getAboutMessageText() {
		return aboutMessageText;
	}

	/**
	 * @return the quitMessageText
	 */
	protected String getQuitMessageText() {
		return quitMessageText;
	}

	/**
	 * @param programName
	 *            the programName to set
	 */
	protected void setProgramName(String programName) {
		this.programName = programName;
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
	 * @param fileMenuLabel
	 *            the fileMenuLabel to set
	 */
	protected void setFileMenuLabel(String fileMenuLabel) {
		this.fileMenuLabel = fileMenuLabel;
		this.setChanged();
	}

	/**
	 * @param importAlgorithmLabel
	 *            the importAlgorithmLabel to set
	 */
	protected void setImportAlgorithmLabel(String importAlgorithmLabel) {
		this.importAlgorithmLabel = importAlgorithmLabel;
		this.setChanged();
	}

	/**
	 * @param deleteAlgorithmLabel
	 *            the deleteAlgorithmLabel to set
	 */
	protected void setDeleteAlgorithmLabel(String deleteAlgorithmLabel) {
		this.deleteAlgorithmLabel = deleteAlgorithmLabel;
		this.setChanged();
	}

	/**
	 * @param importGraphLabel
	 *            the importGraphLabel to set
	 */
	protected void setImportGraphLabel(String importGraphLabel) {
		this.importGraphLabel = importGraphLabel;
		this.setChanged();
	}

	/**
	 * @param deleteGraphLabel
	 *            the deleteGraphLabel to set
	 */
	protected void setDeleteGraphLabel(String deleteGraphLabel) {
		this.deleteGraphLabel = deleteGraphLabel;
		this.setChanged();
	}

	/**
	 * @param quitLabel
	 *            the quitLabel to set
	 */
	protected void setQuitLabel(String quitLabel) {
		this.quitLabel = quitLabel;
		this.setChanged();
	}

	/**
	 * @param i18nMenuLabel
	 *            the i18nMenuLabel to set
	 */
	protected void setI18nMenuLabel(String i18nMenuLabel) {
		this.i18nMenuLabel = i18nMenuLabel;
		this.setChanged();
	}

	/**
	 * @param deDEMenuItemLabel
	 *            the deDEMenuItemLabel to set
	 */
	protected void setDeDEMenuItemLabel(String deDEMenuItemLabel) {
		this.deDEMenuItemLabel = deDEMenuItemLabel;
		this.setChanged();
	}

	/**
	 * @param frFRMenuItemLabel
	 *            the frFRMenuItemLabel to set
	 */
	protected void setFrFRMenuItemLabel(String frFRMenuItemLabel) {
		this.frFRMenuItemLabel = frFRMenuItemLabel;
		this.setChanged();
	}

	/**
	 * @param enUSMenuItemLabel
	 *            the enUSMenuItemLabel to set
	 */
	protected void setEnUSMenuItemLabel(String enUSMenuItemLabel) {
		this.enUSMenuItemLabel = enUSMenuItemLabel;
		this.setChanged();
	}

	/**
	 * @param infoMenuLabel
	 *            the infoMenuLabel to set
	 */
	protected void setInfoMenuLabel(String infoMenuLabel) {
		this.infoMenuLabel = infoMenuLabel;
		this.setChanged();
	}

	/**
	 * @param helpMenuItemLabel
	 *            the helpMenuItemLabel to set
	 */
	protected void setHelpMenuItemLabel(String helpMenuItemLabel) {
		this.helpMenuItemLabel = helpMenuItemLabel;
		this.setChanged();
	}

	/**
	 * @param aboutMenuItemLabel
	 *            the aboutMenuItemLabel to set
	 */
	protected void setAboutMenuItemLabel(String aboutMenuItemLabel) {
		this.aboutMenuItemLabel = aboutMenuItemLabel;
		this.setChanged();
	}

	/**
	 * @param fileMenuMnemonic
	 *            the fileMenuMnemonic to set
	 */
	protected void setFileMenuMnemonic(char fileMenuMnemonic) {
		this.fileMenuMnemonic = fileMenuMnemonic;
		this.setChanged();
	}

	/**
	 * @param renderMnemonic
	 *            the renderMnemonic to set
	 */
	protected void setRenderMnemonic(char renderMnemonic) {
		this.renderMnemonic = renderMnemonic;
		this.setChanged();
	}

	/**
	 * @param saveGraphMnemonic
	 *            the saveGraphMnemonic to set
	 */
	protected void setSaveGraphMnemonic(char saveGraphMnemonic) {
		this.saveGraphMnemonic = saveGraphMnemonic;
		this.setChanged();
	}

	/**
	 * @param quitMenuItemMnemonic
	 *            the quitMenuItemMnemonic to set
	 */
	protected void setQuitMenuItemMnemonic(char quitMenuItemMnemonic) {
		this.quitMenuItemMnemonic = quitMenuItemMnemonic;
		this.setChanged();
	}

	/**
	 * @param i18nMenuMnemonic
	 *            the i18nMenuMnemonic to set
	 */
	protected void setI18nMenuMnemonic(char i18nMenuMnemonic) {
		this.i18nMenuMnemonic = i18nMenuMnemonic;
		this.setChanged();
	}

	/**
	 * @param deDEMenuItemMnemonic
	 *            the deDEMenuItemMnemonic to set
	 */
	protected void setDeDEMenuItemMnemonic(char deDEMenuItemMnemonic) {
		this.deDEMenuItemMnemonic = deDEMenuItemMnemonic;
		this.setChanged();
	}

	/**
	 * @param frFRMenuItemMnemonic
	 *            the frFRMenuItemMnemonic to set
	 */
	protected void setFrFRMenuItemMnemonic(char frFRMenuItemMnemonic) {
		this.frFRMenuItemMnemonic = frFRMenuItemMnemonic;
		this.setChanged();
	}

	/**
	 * @param enUSMenuItemMnemonic
	 *            the enUSMenuItemMnemonic to set
	 */
	protected void setEnUSMenuItemMnemonic(char enUSMenuItemMnemonic) {
		this.enUSMenuItemMnemonic = enUSMenuItemMnemonic;
		this.setChanged();
	}

	/**
	 * @param infoMenuMnemonic
	 *            the infoMenuMnemonic to set
	 */
	protected void setInfoMenuMnemonic(char infoMenuMnemonic) {
		this.infoMenuMnemonic = infoMenuMnemonic;
		this.setChanged();
	}

	/**
	 * @param helpMenuItemMnemonic
	 *            the helpMenuItemMnemonic to set
	 */
	protected void setHelpMenuItemMnemonic(char helpMenuItemMnemonic) {
		this.helpMenuItemMnemonic = helpMenuItemMnemonic;
		this.setChanged();
	}

	/**
	 * @param aboutMenuItemMnemonic
	 *            the aboutMenuItemMnemonic to set
	 */
	protected void setAboutMenuItemMnemonic(char aboutMenuItemMnemonic) {
		this.aboutMenuItemMnemonic = aboutMenuItemMnemonic;
		this.setChanged();
	}

	/**
	 * @param renderMenuItemAccelerator
	 *            the renderMenuItemAccelerator to set
	 */
	protected void setRenderMenuItemAccelerator(
			KeyStroke renderMenuItemAccelerator) {
		this.renderMenuItemAccelerator = renderMenuItemAccelerator;
		this.setChanged();
	}

	/**
	 * @param quitMenuItemAccelerator
	 *            the quitMenuItemAccelerator to set
	 */
	protected void setQuitMenuItemAccelerator(KeyStroke quitMenuItemAccelerator) {
		this.quitMenuItemAccelerator = quitMenuItemAccelerator;
		this.setChanged();
	}

	/**
	 * @param helpMenuItemAccelerator
	 *            the helpMenuItemAccelerator to set
	 */
	protected void setHelpMenuItemAccelerator(KeyStroke helpMenuItemAccelerator) {
		this.helpMenuItemAccelerator = helpMenuItemAccelerator;
		this.setChanged();
	}

	/**
	 * @param aboutMenuItemAccelerator
	 *            the aboutMenuItemAccelerator to set
	 */
	protected void setAboutMenuItemAccelerator(
			KeyStroke aboutMenuItemAccelerator) {
		this.aboutMenuItemAccelerator = aboutMenuItemAccelerator;
		this.setChanged();
	}

	/**
	 * @param fileMenuEnabled
	 *            the fileMenuEnabled to set
	 */
	protected void setFileMenuEnabled(boolean fileMenuEnabled) {
		this.fileMenuEnabled = fileMenuEnabled;
		this.setChanged();
	}

	/**
	 * @param importAlgorithmMenuItemEnabled
	 *            the importAlgorithmMenuItemEnabled to set
	 */
	protected void setImportAlgorithmMenuItemEnabled(
			boolean importAlgorithmMenuItemEnabled) {
		this.importAlgorithmMenuItemEnabled = importAlgorithmMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param deleteAlgorithmMenuItemEnabled
	 *            the deleteAlgorithmMenuItemEnabled to set
	 */
	protected void setDeleteAlgorithmMenuItemEnabled(
			boolean deleteAlgorithmMenuItemEnabled) {
		this.deleteAlgorithmMenuItemEnabled = deleteAlgorithmMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param importGraphMenuItemEnabled
	 *            the importGraphMenuItemEnabled to set
	 */
	protected void setImportGraphMenuItemEnabled(
			boolean importGraphMenuItemEnabled) {
		this.importGraphMenuItemEnabled = importGraphMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param saveGraphEnabled
	 *            the saveGraphEnabled to set
	 */
	protected void setSaveGraphEnabled(boolean saveGraphEnabled) {
		this.saveGraphEnabled = saveGraphEnabled;
		this.setChanged();
	}

	/**
	 * @param exportGraphMenuItemEnabled
	 *            the exportGraphMenuItemEnabled to set
	 */
	protected void setExportGraphMenuItemEnabled(
			boolean exportGraphMenuItemEnabled) {
		this.exportGraphMenuItemEnabled = exportGraphMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param deleteGraphMenuItemEnabled
	 *            the deleteGraphMenuItemEnabled to set
	 */
	protected void setDeleteGraphMenuItemEnabled(
			boolean deleteGraphMenuItemEnabled) {
		this.deleteGraphMenuItemEnabled = deleteGraphMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param renderMenuItemEnabled
	 *            the renderMenuItemEnabled to set
	 */
	protected void setRenderMenuItemEnabled(boolean renderMenuItemEnabled) {
		this.renderMenuItemEnabled = renderMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param quitMenuItemEnabled
	 *            the quitMenuItemEnabled to set
	 */
	protected void setQuitMenuItemEnabled(boolean quitMenuItemEnabled) {
		this.quitMenuItemEnabled = quitMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param i18nMenuEnabled
	 *            the i18nMenuEnabled to set
	 */
	protected void setI18nMenuEnabled(boolean i18nMenuEnabled) {
		this.i18nMenuEnabled = i18nMenuEnabled;
		this.setChanged();
	}

	/**
	 * @param deDEMenuItemEnabled
	 *            the deDEMenuItemEnabled to set
	 */
	protected void setDeDEMenuItemEnabled(boolean deDEMenuItemEnabled) {
		this.deDEMenuItemEnabled = deDEMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param frFRMenuItemEnabled
	 *            the frFRMenuItemEnabled to set
	 */
	protected void setFrFRMenuItemEnabled(boolean frFRMenuItemEnabled) {
		this.frFRMenuItemEnabled = frFRMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param enUSMenuItemEnabled
	 *            the enUSMenuItemEnabled to set
	 */
	protected void setEnUSMenuItemEnabled(boolean enUSMenuItemEnabled) {
		this.enUSMenuItemEnabled = enUSMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param infoMenuEnabled
	 *            the infoMenuEnabled to set
	 */
	protected void setInfoMenuEnabled(boolean infoMenuEnabled) {
		this.infoMenuEnabled = infoMenuEnabled;
		this.setChanged();
	}

	/**
	 * @param helpMenuItemEnabled
	 *            the helpMenuItemEnabled to set
	 */
	protected void setHelpMenuItemEnabled(boolean helpMenuItemEnabled) {
		this.helpMenuItemEnabled = helpMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param aboutMenuItemEnabled
	 *            the aboutMenuItemEnabled to set
	 */
	protected void setAboutMenuItemEnabled(boolean aboutMenuItemEnabled) {
		this.aboutMenuItemEnabled = aboutMenuItemEnabled;
		this.setChanged();
	}

	/**
	 * @param renderPanelLabel
	 *            the renderPanelLabel to set
	 */
	protected void setRenderPanelLabel(String renderPanelLabel) {
		this.renderPanelLabel = renderPanelLabel;
		this.setChanged();
	}

	/**
	 * @param algorithmLabel
	 *            the algorithmLabel to set
	 */
	protected void setAlgorithmLabel(String algorithmLabel) {
		this.algorithmLabel = algorithmLabel;
		this.setChanged();
	}

	/**
	 * @param graphLabel
	 *            the graphLabel to set
	 */
	protected void setGraphLabel(String graphLabel) {
		this.graphLabel = graphLabel;
		this.setChanged();
	}

	/**
	 * @param graphComboModel
	 *            the graphComboModel to set
	 */
	protected void setGraphComboModel(String[] graphComboModel) {
		this.graphComboModel = graphComboModel;
		this.setChanged();
	}

	/**
	 * @param algorithmComboModel
	 *            the algorithmComboModel to set
	 */
	protected void setAlgorithmComboModel(String[] algorithmComboModel) {
		this.algorithmComboModel = algorithmComboModel;
		this.setChanged();
	}

	/**
	 * @param algorithmSelected
	 *            the algorithmSelected to set
	 */
	protected void setAlgorithmSelected(int algorithmSelected) {
		this.algorithmSelected = algorithmSelected;
		this.setChanged();
	}

	/**
	 * @param graphSelected
	 *            the graphSelected to set
	 */
	protected void setGraphSelected(int graphSelected) {
		this.graphSelected = graphSelected;
		this.setChanged();
	}

	/**
	 * @param algorithmEnabled
	 *            the algorithmEnabled to set
	 */
	protected void setAlgorithmEnabled(boolean algorithmEnabled) {
		this.algorithmEnabled = algorithmEnabled;
		this.setChanged();
	}

	/**
	 * @param graphEnabled
	 *            the graphEnabled to set
	 */
	protected void setGraphEnabled(boolean graphEnabled) {
		this.graphEnabled = graphEnabled;
		this.setChanged();
	}

	/**
	 * @param visualizationPanelLabel
	 *            the visualizationPanelLabel to set
	 */
	protected void setVisualizationPanelLabel(String visualizationPanelLabel) {
		this.visualizationPanelLabel = visualizationPanelLabel;
		this.setChanged();
	}

	/**
	 * @param playerPanelLabel
	 *            the playerPanelLabel to set
	 */
	protected void setPlayerPanelLabel(String playerPanelLabel) {
		this.playerPanelLabel = playerPanelLabel;
		this.setChanged();
	}

	/**
	 * @param delayLabel
	 *            the delayLabel to set
	 */
	protected void setDelayLabel(String delayLabel) {
		this.delayLabel = delayLabel;
		this.setChanged();
	}

	/**
	 * @param delayValue
	 *            the delayValue to set
	 */
	protected void setDelayValue(int delayValue) {
		this.delayValue = delayValue;
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
	 * @param stepLabel
	 *            the stepLabel to set
	 */
	protected void setStepLabel(String stepLabel) {
		this.stepLabel = stepLabel;
		this.setChanged();
	}

	/**
	 * @param stepValue
	 *            the stepValue to set
	 */
	protected void setStepValue(int stepValue) {
		this.stepValue = stepValue;
		this.setChanged();
	}

	/**
	 * @param stepEnabled
	 *            the stepEnabled to set
	 */
	protected void setStepEnabled(boolean stepEnabled) {
		this.stepEnabled = stepEnabled;
		this.setChanged();
	}

	/**
	 * @param progressLabel
	 *            the progressLabel to set
	 */
	protected void setProgressLabel(String progressLabel) {
		this.progressLabel = progressLabel;
		this.setChanged();
	}

	/**
	 * @param progressValue
	 *            the progressValue to set
	 */
	protected void setProgressValue(int progressValue) {
		this.progressValue = progressValue;
		this.setChanged();
	}

	/**
	 * @param progressValueMaximum
	 *            the progressValueMaximum to set
	 */
	protected void setProgressValueMaximum(int progressValueMaximum) {
		this.progressValueMaximum = progressValueMaximum;
		this.setChanged();
	}

	/**
	 * @param playButtonLabel
	 *            the playButtonLabel to set
	 */
	protected void setPlayButtonLabel(String playButtonLabel) {
		this.playButtonLabel = playButtonLabel;
		this.setChanged();
	}

	/**
	 * @param playButtonEnabled
	 *            the playButtonEnabled to set
	 */
	protected void setPlayButtonEnabled(boolean playButtonEnabled) {
		this.playButtonEnabled = playButtonEnabled;
		this.setChanged();
	}

	/**
	 * @param playAccelerator
	 *            the playAccelerator to set
	 */
	protected void setPlayAccelerator(KeyStroke playAccelerator) {
		this.playAccelerator = playAccelerator;
		this.setChanged();
	}

	/**
	 * @param pauseButtonLabel
	 *            the pauseButtonLabel to set
	 */
	protected void setPauseButtonLabel(String pauseButtonLabel) {
		this.pauseButtonLabel = pauseButtonLabel;
		this.setChanged();
	}

	/**
	 * @param pauseButtonEnabled
	 *            the pauseButtonEnabled to set
	 */
	protected void setPauseButtonEnabled(boolean pauseButtonEnabled) {
		this.pauseButtonEnabled = pauseButtonEnabled;
		this.setChanged();
	}

	/**
	 * @param pauseButtonActionCommand
	 *            the pauseButtonActionCommand to set
	 */
	protected void setPauseButtonActionCommand(String pauseButtonActionCommand) {
		this.pauseButtonActionCommand = pauseButtonActionCommand;
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
	 * @param stopButtonLabel
	 *            the stopButtonLabel to set
	 */
	protected void setStopButtonLabel(String stopButtonLabel) {
		this.stopButtonLabel = stopButtonLabel;
		this.setChanged();
	}

	/**
	 * @param stopButtonEnabled
	 *            the stopButtonEnabled to set
	 */
	protected void setStopButtonEnabled(boolean stopButtonEnabled) {
		this.stopButtonEnabled = stopButtonEnabled;
		this.setChanged();
	}

	/**
	 * @param stopAccelerator
	 *            the stopAccelerator to set
	 */
	protected void setStopAccelerator(KeyStroke stopAccelerator) {
		this.stopAccelerator = stopAccelerator;
		this.setChanged();
	}

	/**
	 * @param homeButtonLabel
	 *            the homeButtonLabel to set
	 */
	protected void setHomeButtonLabel(String homeButtonLabel) {
		this.homeButtonLabel = homeButtonLabel;
		this.setChanged();
	}

	/**
	 * @param homeButtonEnabled
	 *            the homeButtonEnabled to set
	 */
	protected void setHomeButtonEnabled(boolean homeButtonEnabled) {
		this.homeButtonEnabled = homeButtonEnabled;
		this.setChanged();
	}

	/**
	 * @param homeAccelerator
	 *            the homeAccelerator to set
	 */
	protected void setHomeAccelerator(KeyStroke homeAccelerator) {
		this.homeAccelerator = homeAccelerator;
		this.setChanged();
	}

	/**
	 * @param backwardButtonLabel
	 *            the backwardButtonLabel to set
	 */
	protected void setBackwardButtonLabel(String backwardButtonLabel) {
		this.backwardButtonLabel = backwardButtonLabel;
		this.setChanged();
	}

	/**
	 * @param backwardButtonMnemonic
	 *            the backwardButtonMnemonic to set
	 */
	protected void setBackwardButtonMnemonic(char backwardButtonMnemonic) {
		this.backwardButtonMnemonic = backwardButtonMnemonic;
		this.setChanged();
	}

	/**
	 * @param backwardButtonEnabled
	 *            the backwardButtonEnabled to set
	 */
	protected void setBackwardButtonEnabled(boolean backwardButtonEnabled) {
		this.backwardButtonEnabled = backwardButtonEnabled;
		this.setChanged();
	}

	/**
	 * @param backwardAccelerator
	 *            the backwardAccelerator to set
	 */
	protected void setBackwardAccelerator(KeyStroke backwardAccelerator) {
		this.backwardAccelerator = backwardAccelerator;
		this.setChanged();
	}

	/**
	 * @param forwardButtonLabel
	 *            the forwardButtonLabel to set
	 */
	protected void setForwardButtonLabel(String forwardButtonLabel) {
		this.forwardButtonLabel = forwardButtonLabel;
		this.setChanged();
	}

	/**
	 * @param forwardButtonEnabled
	 *            the forwardButtonEnabled to set
	 */
	protected void setForwardButtonEnabled(boolean forwardButtonEnabled) {
		this.forwardButtonEnabled = forwardButtonEnabled;
		this.setChanged();
	}

	/**
	 * @param forwardAccelerator
	 *            the forwardAccelerator to set
	 */
	protected void setForwardAccelerator(KeyStroke forwardAccelerator) {
		this.forwardAccelerator = forwardAccelerator;
		this.setChanged();
	}

	/**
	 * @param endButtonLabel
	 *            the endButtonLabel to set
	 */
	protected void setEndButtonLabel(String endButtonLabel) {
		this.endButtonLabel = endButtonLabel;
		this.setChanged();
	}

	/**
	 * @param endButtonEnabled
	 *            the endButtonEnabled to set
	 */
	protected void setEndButtonEnabled(boolean endButtonEnabled) {
		this.endButtonEnabled = endButtonEnabled;
		this.setChanged();
	}

	/**
	 * @param endAccelerator
	 *            the endAccelerator to set
	 */
	protected void setEndAccelerator(KeyStroke endAccelerator) {
		this.endAccelerator = endAccelerator;
		this.setChanged();
	}

	/**
	 * @param protocolPanelLabel
	 *            the protocolPanelLabel to set
	 */
	protected void setProtocolPanelLabel(String protocolPanelLabel) {
		this.protocolPanelLabel = protocolPanelLabel;
		this.setChanged();
	}

	/**
	 * @param protocolPanelText
	 *            the protocolPanelText to set
	 */
	protected void setProtocolPanelText(String protocolPanelText) {
		this.protocolPanelText = protocolPanelText;
		this.setChanged();
	}

	/**
	 * @param importLabel
	 *            the importLabel to set
	 */
	protected void setImportLabel(String importLabel) {
		this.importLabel = importLabel;
		this.setChanged();
	}

	/**
	 * @param deleteLabel
	 *            the deleteLabel to set
	 */
	protected void setDeleteLabel(String deleteLabel) {
		this.deleteLabel = deleteLabel;
		this.setChanged();
	}

	/**
	 * @param helpMessageLabel
	 *            the helpMessageLabel to set
	 */
	protected void setHelpMessageLabel(String helpMessageLabel) {
		this.helpMessageLabel = helpMessageLabel;
		this.setChanged();
	}

	/**
	 * @param helpMessageText
	 *            the helpMessageText to set
	 */
	protected void setHelpMessageText(String helpMessageText) {
		this.helpMessageText = helpMessageText;
		this.setChanged();
	}

	/**
	 * @param aboutMessageLabel
	 *            the aboutMessageLabel to set
	 */
	protected void setAboutMessageLabel(String aboutMessageLabel) {
		this.aboutMessageLabel = aboutMessageLabel;
		this.setChanged();
	}

	/**
	 * @param aboutMessageText
	 *            the aboutMessageText to set
	 */
	protected void setAboutMessageText(String aboutMessageText) {
		this.aboutMessageText = aboutMessageText;
		this.setChanged();
	}

	/**
	 * @param quitMessageText
	 *            the quitMessageText to set
	 */
	protected void setQuitMessageText(String quitMessageText) {
		this.quitMessageText = quitMessageText;
		this.setChanged();
	}

}
