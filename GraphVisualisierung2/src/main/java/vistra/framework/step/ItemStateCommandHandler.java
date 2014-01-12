package vistra.framework.step;

import java.util.ArrayList;
import java.util.List;

import vistra.framework.graph.item.state.command.IItemStateCommand;


/**
 * An item-state-command handler (macro command). A {@code ICommandHandler}
 * specialized on {@code IItemStateCommand}s.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ItemStateCommandHandler implements IItemStateCommandHandler {

	/**
	 * A field for a list of item-state commands.
	 */
	private List<IItemStateCommand> commands;

	/**
	 * Main constructor.
	 */
	ItemStateCommandHandler() {
		this.commands = new ArrayList<IItemStateCommand>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		for (IItemStateCommand c : this.commands)
			c.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		for (int i = this.commands.size() - 1; i >= 0; i--) {
			this.commands.get(i).undo();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCommand(IItemStateCommand c) throws Exception {
		this.commands.add(c);
	}

}
