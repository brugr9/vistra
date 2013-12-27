package vistra.core.traversal.step;

import java.util.ArrayList;
import java.util.List;

import vistra.core.graph.item.state.command.IItemStateCommand;

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
		for (int i = 0; i < commands.size(); i++) {
			commands.get(i).execute();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() throws Exception {
		for (int i = commands.size() - 1; i >= 0; i--) {
			commands.get(i).undo();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCommand(IItemStateCommand command) throws Exception {
		this.commands.add(command);
	}

}
