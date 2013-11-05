/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IParameterManager {

	/**
	 * @return the templatesDir
	 */
	public abstract File getTemplatesDir();

	/**
	 * @return the workbenchDir
	 */
	public abstract File getWorkbenchDir();

	/**
	 * @return the filter
	 */
	public abstract FileNameExtensionFilter getFilter();

	/**
	 * Returns the name of a parameter item given by index.
	 * 
	 * @param parameterId
	 * @return the parameter name
	 * @throws Exception
	 * @deprecated
	 */
	public abstract String getName(String parameterId) throws Exception;

	/**
	 * Returns all the names.
	 * 
	 * @return all the names
	 * @throws Exception
	 */
	public abstract String[] getNames() throws Exception;

	/**
	 * Adds a file.
	 * 
	 * @param parameterId
	 *            the parameter ID
	 * @param file
	 *            the file to add
	 * @return the file
	 */
	public abstract File add(String parameterId, File file);

	/**
	 * Adds a bunch of files.
	 * 
	 * @param files
	 *            the files to add
	 * @return <code>true</code> if the files were added
	 */
	public abstract boolean putAll(File[] files) throws Exception;

	/**
	 * Returns a file given by parameter ID.
	 * 
	 * @param parameterId
	 *            the parameter name
	 * @return the file
	 * @throws Exception
	 */
	public abstract File getFile(String parameterId) throws Exception;

	/**
	 * Deletes a file.
	 * 
	 * @param file
	 *            the file to delete
	 * @return <code>true</code> if the file was deleted
	 * @throws Exception
	 */
	public abstract boolean delete(File file) throws Exception;

}
