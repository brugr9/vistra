package vistra.core.traversal.step;

import java.util.ArrayList;
import java.util.List;

import vistra.util.ICommand;

/**
 * A step handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class StepHandler implements IStepHandler {

	/**
	 * A field for a list of commands.
	 */
	private List<ICommand> commands;

	/**
	 * Main constructor.
	 */
	StepHandler() {
		this.commands = new ArrayList<ICommand>();
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
	public void addCommand(ICommand command) throws Exception {
		this.commands.add(command);
	}

}
