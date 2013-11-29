package ch.bfh.bti7301.hs2013.gravis.core.command;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

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
