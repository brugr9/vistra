package ch.bfh.bti7301.hs2013.gravis.core.command;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class EmptyCommand implements ICommand {

	protected EmptyCommand() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.ICommand#execute()
	 */
	@Override
	public void execute() {
		// no operation
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.ICommand#unExecute()
	 */
	@Override
	public void unExecute() {
		// no operation
	}

}
