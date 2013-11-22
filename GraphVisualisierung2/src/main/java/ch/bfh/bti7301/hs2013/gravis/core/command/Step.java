package ch.bfh.bti7301.hs2013.gravis.core.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class Step extends EmptyStep {

	private final List<IStep> nestedCommands;

	/**
	 * @param predecessorCommand
	 */
	protected Step(IStep command) {
		this();
		this.nestedCommands.add(command);
	}

	public Step() {
		super();
		this.nestedCommands = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IStep#execute()
	 */
	@Override
	public String execute() {
		StringBuilder totalComment = new StringBuilder();
		String commandComment = "";
		
		for (IStep command : this.nestedCommands) {
			commandComment = command.execute().trim();
			
			if (!commandComment.isEmpty()) {
				totalComment.append(commandComment + System.lineSeparator());
			}
		}
		
		return totalComment.toString().trim();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IStep#unExecute()
	 */
	@Override
	public String unExecute() {
		StringBuilder totalComment = new StringBuilder();
		String commandComment = "";
		
		for (int i = this.nestedCommands.size() - 1; i >= 0; i--) {
			commandComment = this.nestedCommands.get(i).unExecute().trim();
			
			if (!commandComment.isEmpty()) {
				totalComment.append(commandComment + System.lineSeparator());
			}
		}
		
		return totalComment.toString().trim();
	}

	/**
	 * @param command
	 */
	public void add(IStep command) {
		this.nestedCommands.add(command);
	}

}
