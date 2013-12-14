package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.commons.collections15.map.HashedMap;
import org.apache.maven.shared.utils.io.DirectoryScanner;

import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm manager.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AlgorithmManager implements IAlgorithmManager {

	/**
	 * A field for a templates directory.
	 */
	private String templatesDir;

	/**
	 * A field for a workbench directory.
	 */
	private String workbenchDir;

	/**
	 * A field for a filename extension filter.
	 */
	private FileNameExtensionFilter fileNameExtensionFilter;

	/**
	 * A field for a default name.
	 */
	private String defaultName;

	/**
	 * A field for a list of algorithms.
	 */
	private ArrayList<String> algorithms;

	/**
	 * A field for an algorithm map: maps an algorithm-path to an array of edge
	 * types (the capabilities of the algorithms).
	 */
	private HashedMap<String, EdgeType[]> algorithmMap;

	/**
	 * Main constructor.
	 * 
	 * @param root
	 *            the application root directory
	 * @param p
	 *            the properties
	 */
	public AlgorithmManager(File root, Properties p) {
		super();

		/* directories */
		String thisPath = this.getClass().getPackage().getName() + ".";
		this.templatesDir = thisPath + "templates";
		this.workbenchDir = thisPath + "workbench";

		/* filename filter */
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				p.getProperty("extension.algorithm.description"),
				new String[] { p.getProperty("extension.algorithm") });
		this.fileNameExtensionFilter = filter;

		/* default name */
		this.defaultName = p.getProperty("noparameter");

		/* algorithm */
		this.algorithms = new ArrayList<String>();
		this.algorithms.add(this.defaultName);
		this.algorithmMap = new HashedMap<String, EdgeType[]>();

		/* collect files */
		DirectoryScanner directoryScanner = new DirectoryScanner();
		directoryScanner.setIncludes(this.getFilter().getExtensions());
		directoryScanner.setCaseSensitive(true);
		try {
			// templates
			directoryScanner.setBasedir(this.getTemplatesDir());
			this.addAll(directoryScanner.getIncludedFiles());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, this.getClass().getName()
					+ ", read files from " + this.getTemplatesDir()
					+ " failed.\n" + e.toString(), "GRAVIS", 1, null);
			e.printStackTrace();
		}
		try {
			// workbench
			directoryScanner.setBasedir(this.getWorkbenchDir());
			this.addAll(directoryScanner.getIncludedFiles());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, this.getClass().getName()
					+ ", read files from " + this.getWorkbenchDir()
					+ " failed.\n" + e.toString(), "GRAVIS", 1, null);
			e.printStackTrace();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getNames(EdgeType edgeType) throws Exception {
		try {
			this.updateAlgorithms(edgeType);
			String parameter, name;
			int first, length;
			int size = this.algorithms.size();
			String[] names = new String[size + 1];
			names[0] = this.defaultName;
			for (int index = 1; index < size; index++) {
				parameter = this.algorithms.get(index);
				first = parameter.lastIndexOf('.') + 1;
				length = parameter.length();
				name = parameter.subSequence(first, length).toString();
				names[index + 1] = name;
			}
			return names;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IAlgorithm select(int index) throws Exception {
		try {
			if (index == 0) {
				return null;
			} else {
				String fileName = this.algorithms.get(index);
				return this.load(fileName);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTemplatesDir() {
		return this.templatesDir;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getWorkbenchDir() {
		return this.workbenchDir;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType[] add(File file) throws Exception {
		try {
			// compile
			this.compile(file);
			// load
			IAlgorithm algorithmToAdd = this.load(file.getName());
			// put
			EdgeType[] edgeTypeToAdd = algorithmToAdd.getEdgeTypes();
			return this.algorithmMap.put(file.getName(), edgeTypeToAdd);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Adds a bunch of files to the list of parameter files.
	 * 
	 * @param fileNames
	 * @return
	 * @throws Exception
	 */
	private boolean addAll(String[] fileNames) throws Exception {
		try {
			// TODO return value
			for (String fileName : fileNames) {
				IAlgorithm algorithmToAdd = this.load(fileName);
				// put
				EdgeType[] edgeTypeToAdd = algorithmToAdd.getEdgeTypes();
				this.algorithmMap.put(fileName, edgeTypeToAdd);
			}
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType[] remove(String fileName) throws Exception {
		try {
			String file = this.getWorkbenchDir() + "." + fileName;
			this.algorithms.remove(file);
			return this.algorithmMap.remove(file);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Compiles a *.java file into a *.class file.
	 * 
	 * @param file
	 *            the file to compile
	 * @return 0 for success, nonzero otherwise
	 * @throws Exception
	 * 
	 */
	private int compile(File file) throws Exception {
		// TODO
		try {
			String fileToCompile = "test" + java.io.File.separator
					+ "MyClass.java";
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			int compilationResult = compiler.run(null, null, null,
					fileToCompile);
			if (compilationResult == 0) {
				System.out.println("Compilation is successful");
			} else {
				System.out.println("Compilation Failed");
			}
			return compilationResult;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * TODO Loads an algorithm *.class in runtime, the *.class has to implement
	 * <code>IAlgorithm</code>.
	 * 
	 * @param file
	 *            the algorithm file
	 * @return the algorithm
	 * @throws Exception
	 */
	private IAlgorithm load(String file) throws Exception {

		try {
			ClassLoader cl = this.getClass().getClassLoader();
			Class<?> c = cl.loadClass(file.replace(".", File.separator));
			return (IAlgorithm) c.newInstance();

		} catch (SecurityException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (IllegalAccessException e) {
			throw e;
		} catch (InstantiationException e) {
			throw e;
		} catch (ExceptionInInitializerError e) {
			throw e;
		} catch (ClassCastException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Collects the algorithms out of algorithmMap which have the capability to
	 * handle an edge type as given an creates the list of algorithms.
	 * 
	 * @throws Exception
	 */
	private void updateAlgorithms(EdgeType edgeType) throws Exception {
		// TODO return value?

		try {
			this.algorithms.clear();
			this.algorithms.add(this.defaultName);
			Set<String> filesAvailable = this.algorithmMap.keySet();
			EdgeType[] capabilities;
			for (String file : filesAvailable) {
				// capabilities = new
				// EdgeType[this.algorithmMap.get(file).length];
				capabilities = this.algorithmMap.get(file);
				for (int i = 0; i < capabilities.length; i++) {
					if (capabilities[i] == edgeType) {
						this.algorithms.add(file);
						break;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileNameExtensionFilter getFilter() {
		return this.fileNameExtensionFilter;
	}

}
