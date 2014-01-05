package vistra.framework.graph.item;

import java.util.ArrayList;

import org.apache.commons.collections15.Factory;

import vistra.framework.graph.item.state.IVertexStateHandler;
import vistra.framework.graph.item.state.VertexStateHandler;
import vistra.framework.util.IBidirectIterator;
import vistra.framework.util.ImmutableBidirectIterator;
import vistra.framework.util.Sigma;

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
	// TODO recursion
	private static IBidirectIterator<String> SIGMA;

	/**
	 * 
	 */
	public VertexFactory() {
		ArrayList<String> sigma = new ArrayList<String>();
		String[] alphabet = Sigma.ALPHABET;
		for (int i = 0; i < alphabet.length; i++)
			sigma.add(alphabet[i]);
		SIGMA = new ImmutableBidirectIterator<String>(sigma);
	}

	/**
	 * Creates a vertex.
	 * 
	 * @return the vertex.
	 */
	@Override
	public IVertexLayout create() {
		return createVertexLayout();
	}

	/**
	 * Creates a vertex layout.
	 * 
	 * @return the vertex layout
	 */
	public static IVertexLayout createVertexLayout() {
		IVertexStateHandler vertex = new VertexStateHandler();
		try {
			vertex.handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		((IVertexLayout) vertex).setId(SIGMA.next());
		return (IVertexLayout) vertex;
	}
}
