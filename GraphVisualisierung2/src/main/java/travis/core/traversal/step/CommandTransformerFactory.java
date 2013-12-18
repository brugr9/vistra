package travis.core.traversal.step;

import org.apache.commons.collections15.Transformer;

import travis.core.graph.item.IGraphItem;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public final class CommandTransformerFactory {

	private CommandTransformerFactory() {
	}

	/**
	 * 
	 * @return an instance of Transformer<IGraphItem, IStep>
	 */
	public static Transformer<IGraphItem, IStep> createCommandTransformer() {
		return new CommandTransformer();
	}

}
