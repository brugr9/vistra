package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

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
	 * @param graphItemHistory
	 * @return an instance of ICommandFactory
	 */
	public static Transformer<IGraphItem, ICommand> createCommandTransformer(
			List<IGraphItem> graphItemHistory) {
		return new CommandTransformer(graphItemHistory);
	}

}
