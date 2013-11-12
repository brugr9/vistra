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
	 * Returns the templates directory.
	 * 
	 * @return the templates directory
	 */
	public abstract File getTemplatesDir();

	/**
	 * Returns the workbench directory.
	 * 
	 * @return the workbench directory
	 */
	public abstract File getWorkbenchDir();

	/**
	 * Returns the file name extension filter.
	 * 
	 * @return the file name extension filter
	 */
	public abstract FileNameExtensionFilter getFilter();

	/**
	 * Returns the names of available parameters.
	 * 
	 * @return the names of available parameters
	 * @throws Exception
	 */
	public abstract String[] getNames() throws Exception;

	/**
	 * Adds the file to the parameter list.
	 * 
	 * @param file
	 *            the file to add
	 * @return the names of available parameters
	 * @throws Exception
	 */
	public abstract boolean add(File file) throws Exception;

	/**
	 * Adds a bunch of files.
	 * 
	 * @param files
	 *            the files to add
	 * @return the names of available parameters
	 */
	public abstract String[] putAll(File[] files) throws Exception;

	/**
	 * Returns a file given by index.
	 * 
	 * @param index
	 *            the parameter index
	 * @return the file
	 * @throws Exception
	 */
	public abstract File getFile(int index) throws Exception;

	/**
	 * Removes a file.
	 * 
	 * @param file
	 *            the file to remove
	 * @return <code>true</code> if the file was removed
	 * @throws Exception
	 */
	public abstract boolean remove(File file) throws Exception;

}
