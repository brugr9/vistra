package ch.bfh.bti7301.hs2013.gravis.core.command;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class EmptyStep implements IStep {

	protected EmptyStep() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IStep#execute()
	 */
	@Override
	public String execute() {
		// no operation
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.command.IStep#unExecute()
	 */
	@Override
	public String unExecute() {
		// no operation
		return "";
	}

}
