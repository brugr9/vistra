package vistra.gui.util;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * A FileSystemView class that limits the file selection to a single root.
 * 
 * When used with a JFileChooser the user will only be able to traverse the
 * directories contained within the specified root fill:
 * <ul>
 * <li>The "Look In" combo box will only display the specified root.
 * <li>The "Up One Level" button gets disabled when at the root.
 * </ul>
 * Further, the creation of a new folder is not supported.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class SingleRootFileSystemView extends FileSystemView {

	/**
	 * A field for the root file.
	 */
	File root;

	/**
	 * A field for the root ancestor files.
	 */
	File[] roots = new File[1];

	/**
	 * Main constructor.
	 * 
	 * @param root
	 *            a file to set as root
	 */
	public SingleRootFileSystemView(File root) {
		super();
		this.root = root;
		this.roots[0] = root;
	}

	@Override
	public File createNewFolder(File containingDir) {
		throw new UnsupportedOperationException(
				"Create new folder: operation not supported.");
	}

	@Override
	public File getDefaultDirectory() {
		return root;
	}

	@Override
	public File getHomeDirectory() {
		return root;
	}

	@Override
	public File[] getRoots() {
		return roots;
	}
}
