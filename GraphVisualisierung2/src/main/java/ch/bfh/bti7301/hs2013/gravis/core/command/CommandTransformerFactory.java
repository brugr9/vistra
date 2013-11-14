package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.List;

import javax.swing.event.ChangeListener;

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
	 * @param graphItemHistory
	 * @param changeListener
	 * @return an instance of Transformer<IGraphItem, ICommand>
	 */
	public static Transformer<IGraphItem, ICommand> createCommandTransformer(
			List<IGraphItem> graphItemHistory, ChangeListener changeListener) {
		return new CommandTransformer(graphItemHistory, changeListener);
	}

}
