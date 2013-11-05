/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.core.util;

import java.io.File;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class FileUtil {

	/**
	 * Main (no-)constructor.
	 */
	private FileUtil() {
	}

	/**
	 * Returns the extension of a file.
	 * 
	 * @param f
	 *            the file
	 * @return the extension
	 */
	public static String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < (s.length() - 1)) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}

	/**
	 * Returns the name of a file without filename extension.
	 * 
	 * @param f
	 *            the file
	 * @return the suffix
	 */
	public static String getSuffix(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < (s.length() - 1)) {
			ext = s.substring(0, i);
		}
		return ext;
	}
}
