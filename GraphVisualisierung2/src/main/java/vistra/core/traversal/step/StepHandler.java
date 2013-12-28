package vistra.core.traversal.step;

import java.util.ArrayList;
import java.util.List;

import vistra.core.graph.item.state.command.IItemCommand;

/**
 * A step handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepHandler implements IStepHandler {

	/**
	 * A field for a list of item commands.
	 */
	private List<IItemCommand> commands;

	/**
	 * Main constructor.
	 */
	StepHandler() {
		this.commands = new ArrayList<IItemCommand>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws Exception {
		for (IItemCommand command : this.commands)
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
	public void addCommand(IItemCommand command) throws Exception {
		this.commands.add(command);
	}

}
