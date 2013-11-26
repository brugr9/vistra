/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests the algorithm loader.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
@SuppressWarnings("unused")
public class AlgorithmFactoryTest {

	// parameter
//	private static String pathname;
//	private static String classname;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		pathname = "ch.bfh.bti7301.hs2013.gravis.core.algorithm.test.data";
//		classname = "AlgorithmDefault";
	}

	/**
	 * Tutti paletti: the class can be loaded and implements the interface
	 * <code>IAlgorithm</code>.
	 * <p>
	 * Test method for
	 * {@link ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmFactory#createAlgorithm(java.io.File)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testNewInstanceSuccess() throws Exception {
		// pathname = "ch.bfh.bti7301.hs2013.gravis.core.algorithm";
		// File file = new File(pathname + "." + classname);
		// IAlgorithm expected = new AlgorithmDefault();
		// IAlgorithm actual = AlgorithmFactory.createAlgorithm(file);
		// assertEquals(expected.getClass(), actual.getClass());
	}

	/**
	 * Parameter: wrong path.
	 * <p>
	 * Test method for
	 * {@link ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmFactory#createAlgorithm(java.io.File)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test(expected = ClassNotFoundException.class)
	public final void testNewInstanceFailurePath() throws Exception {
//		pathname = "wrong.path";
//		File file = new File(pathname + "." + classname);
//		IAlgorithm a = AlgorithmFactory.createAlgorithm(file);
	}

	/**
	 * Parameter: wrong filename.
	 * <p>
	 * Test method for
	 * {@link ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmFactory#createAlgorithm(java.io.File)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test(expected = ClassNotFoundException.class)
	public final void testNewInstanceFailureFilename() throws Exception {
		// classname = "WrongFileName";
		// File file = new File(pathname + "." + classname);
		// IAlgorithm a = AlgorithmFactory.createAlgorithm(file);
	}

	/**
	 * File: abstract class.
	 * <p>
	 * Test method for
	 * {@link ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmFactory#createAlgorithm(java.io.File)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test(expected = InstantiationException.class)
	public final void testNewInstanceFailureInstantiation() throws Exception {
		// classname = "AlgorithmIsAbstract";
		// File file = new File(pathname + "." + classname);
		// IAlgorithm a = AlgorithmFactory.createAlgorithm(file);
	}

	/**
	 * File: private constructor.
	 * <p>
	 * Test method for
	 * {@link ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmFactory#createAlgorithm(java.io.File)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test(expected = IllegalAccessException.class)
	public final void testNewInstanceFailureAccess() throws Exception {
		// classname = "AlgorithmNoConstructor";
		// File file = new File(pathname + "." + classname);
		// IAlgorithm a = AlgorithmFactory.createAlgorithm(file);
	}

	/**
	 * File: interface not implemented.
	 * <p>
	 * Test method for
	 * {@link ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmFactory#createAlgorithm(java.io.File)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test(expected = ClassCastException.class)
	public final void testNewInstanceFailureInterface() throws Exception {
		// classname = "AlgorithmNoInterface";
		// File file = new File(pathname + "." + classname);
		// IAlgorithm a = AlgorithmFactory.createAlgorithm(file);
	}

}
