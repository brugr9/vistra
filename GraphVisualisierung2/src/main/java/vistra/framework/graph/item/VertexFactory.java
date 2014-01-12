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
public class VertexFactory implements Factory<IVertexLayout> {

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
	 * Creates a labeled vertex.
	 * 
	 * @return the vertex.
	 */
	@Override
	public IVertexLayout create() {
		return createLabeledVertex();
	}

	/**
	 * Creates a labeled vertex.
	 * 
	 * @return the vertex
	 */
	public static IVertexLayout createLabeledVertex() {
		IVertexLayout vertex = createVertex();
		if (!SIGMA.hasNext())
			resetSigma();
		vertex.setId(SIGMA.next());
		return vertex;
	}

	/**
	 * Creates a vertex.
	 * 
	 * @return the vertex
	 */
	public static IVertexLayout createVertex() {
		return (IVertexLayout) new VertexStateHandler();
	}

	/**
	 * Resets the sigma used for labeled vertex.
	 */
	public static void resetSigma() {
		ArrayList<String> sigma = new ArrayList<String>();
		String[] alphabet = SigmaPalette.alphabet;
		for (int i = 0; i < alphabet.length; i++)
			sigma.add(alphabet[i]);
		SIGMA = new ImmutableBidirectIterator<String>(sigma);
	}

}
