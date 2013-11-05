/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;
import java.util.Map;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IParameterMap extends Map<String, File> {

	/**
	 * 
	 * @param files
	 * @return boolean
	 * @throws Exception
	 */
	public boolean putAll(File[] files) throws Exception;

	/**
	 * 
	 * @param file
	 * @return boolean
	 * @throws Exception
	 */
	public boolean delete(File file) throws Exception;

}
