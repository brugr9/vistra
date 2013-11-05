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
public abstract class AbstractParameterManager implements IParameterManager {

	/**
	 * A field for a parameter map.
	 */
	private final ParameterMap parameterMap;

	/**
	 * A field for a templates directory.
	 */
	private final File templatesDir;

	/**
	 * A field for a workbench directory.
	 */
	private final File workbenchDir;

	/**
	 * A field for a filename extension filter.
	 */
	private final FileNameExtensionFilter filter;

	/**
	 * Main constructor.
	 */
	public AbstractParameterManager(File templatesDir, File workbenchDir,
			FileNameExtensionFilter filter) {
		this.parameterMap = new ParameterMap();
		this.templatesDir = templatesDir;
		this.workbenchDir = workbenchDir;
		this.filter = filter;
	}

	@Override
	public File getTemplatesDir() {
		return this.templatesDir;
	}

	@Override
	public File getWorkbenchDir() {
		return this.workbenchDir;
	}

	@Override
	public FileNameExtensionFilter getFilter() {
		return this.filter;
	}

	@Override
	public String getName(String parameterId) throws Exception {
		return parameterId;
	}

	@Override
	public String[] getNames() throws Exception {
		return this.parameterMap.keySet().toArray(new String[0]);
	}

	@Override
	public File add(String parameterId, File file) {
		return this.parameterMap.put(parameterId, file);
	}

	@Override
	public boolean putAll(File[] files) throws Exception {
		return this.parameterMap.putAll(files);
	}

	@Override
	public File getFile(String parameterId) throws Exception {
		return this.parameterMap.get(parameterId);
	}

	@Override
	public boolean delete(File file) throws Exception {
		return this.parameterMap.delete(file);
	}

}
