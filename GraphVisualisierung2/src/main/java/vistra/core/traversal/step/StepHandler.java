package vistra.core.traversal.step;

import java.util.ArrayList;
import java.util.List;

import vistra.core.graph.item.state.command.IItemStateCommand;

/**
 * A step handler is a command handler specialised on item-state-commands.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepHandler implements IStepHandler {

	/**
	 * A field for a list of item-state commands.
	 */
	private List<IItemStateCommand> commands;

	/**
	 * Main constructor.
	 */
	StepHandler() {
		this.commands = new ArrayList<IItemStateCommand>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		for (IItemStateCommand command : this.commands)
			command.execute();
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
	public void addItemStateCommand(IItemStateCommand command) throws Exception {
		this.commands.add(command);
	}

}
