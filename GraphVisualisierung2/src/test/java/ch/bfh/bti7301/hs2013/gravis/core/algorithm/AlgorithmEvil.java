package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.io.File;

import org.apache.commons.io.FileUtils;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph;

/**
 * A dummy algorithm implementing the interface <code>IAlgorithm</code>.
 * <p>
 * Tries to behave <b>evil</b> >8=§~ on execute().
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AlgorithmEvil implements IAlgorithm {

	/**
	 * Constructor.
	 */
	public AlgorithmEvil() {
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public void execute(IImmutableGraph graph) throws Exception {
		try {
			// TODO behave evil
			// FileUtils.deleteQuietly(graph);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public GraphType[] getGraphTypes() {
		return null;
	}

}
