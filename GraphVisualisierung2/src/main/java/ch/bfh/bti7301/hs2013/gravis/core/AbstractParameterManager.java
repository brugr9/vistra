/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;
import java.util.ArrayList;
import java.util.SortedSet;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AbstractParameterManager implements IParameterManager {

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
	 * A field for a list of parameters.
	 * TODO sorted set
	 */
	private ArrayList<File> parameters;

	/**
	 * Main constructor.
	 */
	public AbstractParameterManager(File templatesDir, File workbenchDir,
			FileNameExtensionFilter filter) {
		this.templatesDir = templatesDir;
		this.workbenchDir = workbenchDir;
		this.filter = filter;
		this.parameters = new ArrayList<File>();
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
	public String[] getNames() throws Exception {
		return this.parameters.toArray(new String[0]);
	}

	@Override
	public boolean add(File file) throws Exception {
		return this.parameters.add(file);
	}

	@Override
	public String[] putAll(File[] files) throws Exception {
		for (File file : files)
			this.parameters.add(file);
		return this.getNames();
	}

	@Override
	public File getFile(int index) throws Exception {
		return this.parameters.get(index);
	}

	@Override
	public boolean remove(File file) throws Exception {
		return this.parameters.remove(file);
	}

}
