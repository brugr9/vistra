package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ComplexCommand extends EmptyCommand {

	private final List<ICommand> nestedCommands;

	/**
	 * @param predecessorCommand
	 */
	protected ComplexCommand(ICommand command) {
		this.nestedCommands = new ArrayList<>();
		this.nestedCommands.add(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.ICommand#execute()
	 */
	@Override
	public void execute() {
		for (ICommand command : this.nestedCommands) {
			command.execute();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.ICommand#unExecute()
	 */
	@Override
	public void unExecute() {
		for (int i = this.nestedCommands.size() - 1; i >= 0; i--) {
			this.nestedCommands.get(i).unExecute();
		}
	}

	/**
	 * @param command
	 */
	public void add(ICommand command) {
		this.nestedCommands.add(command);
	}

}
