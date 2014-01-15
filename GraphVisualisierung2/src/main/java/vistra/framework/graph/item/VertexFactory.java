package vistra.framework.graph.item;

import java.util.ArrayList;

import org.apache.commons.collections15.Factory;

import vistra.framework.graph.item.state.VertexStateHandler;
import vistra.framework.util.IBidirectIterator;
import vistra.framework.util.ImmutableBidirectIterator;
import vistra.framework.util.palette.SigmaPalette;

/**
 * A vertex factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFactory implements Factory<ILayoutVertex> {

	/**
	 * A field for some signs.
	 */
	private static IBidirectIterator<String> SIGMA;

	/**
	 * Main constructor.
	 */
	public VertexFactory() {
		resetSigma();
	}

	/**
	 * Creates a labeled layout vertex.
	 * 
	 * @return the vertex.
	 */
	@Override
	public ILayoutVertex create() {
		return createLabeledVertex();
	}

	/**
	 * Creates a labeled layout vertex.
	 * 
	 * @return the vertex
	 */
	public static ILayoutVertex createLabeledVertex() {
		ILayoutVertex vertex = createVertex();
		vertex.setId(nextSigma());
		return vertex;
	}

	/**
	 * Creates a layout vertex.
	 * 
	 * @return the vertex
	 */
	public static ILayoutVertex createVertex() {
		return (ILayoutVertex) new VertexStateHandler();
	}

	/**
	 * Returns the next sigma.
	 * 
	 * @return the next sigma
	 */
	public static String nextSigma() {
		if (!SIGMA.hasNext())
			resetSigma();
		return SIGMA.next();
	}

	/**
	 * Resets the sigma used for the layout vertex.
	 */
	public static void resetSigma() {
		ArrayList<String> sigma = new ArrayList<String>();
		String[] alphabet = SigmaPalette.alphabet;
		for (int i = 0; i < alphabet.length; i++)
			sigma.add(alphabet[i]);
		SIGMA = new ImmutableBidirectIterator<String>(sigma);
	}

}
