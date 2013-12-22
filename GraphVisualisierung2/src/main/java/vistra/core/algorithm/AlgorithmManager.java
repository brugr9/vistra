package vistra.core.algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import vistra.core.algorithm.impl.BFS;
import vistra.core.algorithm.impl.DFS;
import vistra.core.algorithm.impl.DLS;
import vistra.core.algorithm.impl.Default;
import vistra.core.algorithm.impl.Dijkstra;
import vistra.core.algorithm.impl.Kruskal;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm manager.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AlgorithmManager implements IAlgorithmManager {

	/**
	 * A field for a workbench directory.
	 */
	private String workbenchDir;
	/**
	 * A field for a filename extension filter.
	 */
	private FileNameExtensionFilter fileNameExtensionFilter;
	/**
	 * A field for a list of algorithms available.
	 */
	private ArrayList<IAlgorithm> algorithmsAvailable;
	/**
	 * A field for a list of supported algorithms.
	 */
	private ArrayList<IAlgorithm> algorithmsSupported;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the properties
	 */
	public AlgorithmManager(Properties p) {
		super();

		String thisPath = this.getClass().getPackage().getName() + ".";
		this.workbenchDir = thisPath + "workbench";
		// filename filter
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				p.getProperty("extension.algorithm.description"),
				new String[] { p.getProperty("extension.algorithm") });
		this.fileNameExtensionFilter = filter;

		/* supported */
		this.algorithmsSupported = new ArrayList<IAlgorithm>();
		/* available */
		this.algorithmsAvailable = new ArrayList<IAlgorithm>();
		this.addAlgorithmsAvailable();

	}

	/**
	 * Adds all algorithms available.
	 */
	private void addAlgorithmsAvailable() {
		this.algorithmsAvailable.clear();
		this.algorithmsAvailable.add(new Default());
		this.algorithmsAvailable.add(new BFS());
		this.algorithmsAvailable.add(new DFS());
		this.algorithmsAvailable.add(new DLS());
		this.algorithmsAvailable.add(new Dijkstra());
		this.algorithmsAvailable.add(new Kruskal());

		// TODO collect files from workbench
		// DirectoryScanner directoryScanner = new DirectoryScanner();
		// directoryScanner.setIncludes(this.getFilter().getExtensions()[1]);
		// directoryScanner.setCaseSensitive(true);
		// try {
		// directoryScanner.setBasedir(this.getWorkbenchDir());
		// IAlgorithm algorithmToAdd;
		// for (String algorithmClass : directoryScanner.getIncludedFiles()) {
		// algorithmToAdd = this.load(algorithmClass);
		// this.algorithmsAvailable.add(algorithmToAdd);
		// }
		// } catch (Exception e) {
		// JOptionPane.showMessageDialog(null, this.getClass().getName()
		// + ", read files from " + this.getWorkbenchDir()
		// + " failed.\n" + e.toString(), "GRAVIS", 1, null);
		// e.printStackTrace();
		// }

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getNames(EdgeType edgeType) throws Exception {
		try {
			/* update algorithmsSupported */
			this.algorithmsSupported.clear();
			EdgeType[] capabilities;
			for (IAlgorithm a : this.algorithmsAvailable) {
				capabilities = a.getEdgeTypes();
				for (int i = 0; i < capabilities.length; i++) {
					if (capabilities[i] == edgeType) {
						this.algorithmsSupported.add(a);
						break;
					}
				}
			}
			/* get names from algorithmsSupported */
			String[] names = new String[this.algorithmsSupported.size()];
			for (int i = 0; i < names.length; i++) {
				names[i] = this.algorithmsSupported.get(i).getName();
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
			return this.algorithmsSupported.get(index);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getWorkbench() {
		return this.workbenchDir;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType[] add(File file) throws Exception {
		try {
			if (this.compile(file) == 0) {
				IAlgorithm algorithmToAdd = this.load(file.getName());
				this.algorithmsAvailable.add(algorithmToAdd);
				return algorithmToAdd.getEdgeTypes();
			} else
				return null;
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
			// TODO
			// String file = this.getWorkbenchDir() + "." + fileName;
			// this.algorithmsAvailable.remove(fileName);
			// return this.algorithm.remove(file);
			return null;
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
	 * @param algorithmClass
	 *            the algorithm class
	 * @return the algorithm
	 * @throws Exception
	 */
	private IAlgorithm load(String algorithmClass) throws Exception {

		try {
			ClassLoader cl = this.getClass().getClassLoader();
			Class<?> c = cl.loadClass(algorithmClass);
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
	 * {@inheritDoc}
	 */
	@Override
	public FileNameExtensionFilter getFilter() {
		return this.fileNameExtensionFilter;
	}

}
