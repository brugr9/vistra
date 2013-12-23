package vistra.core.traversal.step.handler;

import java.util.ArrayList;
import java.util.List;
import vistra.util.ICommand;

/**
 * An abstract step command.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractStepHandler implements IStepHandler {

	/**
	 * A field for a description.
	 */
	private String description;

	/**
	 * A field for a list of commands.
	 */
	private List<ICommand> commands;

	/**
	 * Main constructor.
	 */
	AbstractStepHandler() {
		this.description = "";
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
}
