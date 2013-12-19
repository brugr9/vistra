package vistra.core.zobsolete.traversal.step;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class Step extends EmptyStep {

	private final List<IStep> nestedCommands;

	/**
	 * @param command
	 */
	public Step(IStep command) {
		this();
		this.nestedCommands.add(command);
	}

	public Step() {
		super();
		this.nestedCommands = new ArrayList<>();
	}

	@Override
	public IStepResult execute() {
		StringBuilder totalComment = new StringBuilder();
		IStepResult stepResult = null;

		for (IStep command : this.nestedCommands) {
			stepResult = command.execute();

			if (stepResult.hasComment()) {
				totalComment.append(stepResult.getComment()
						+ System.lineSeparator());
			}
		}

		return new StepResult(totalComment.toString().trim());
	}

	@Override
	public IStepResult undo() {
		StringBuilder totalComment = new StringBuilder();
		IStepResult stepResult = null;

		for (int i = this.nestedCommands.size() - 1; i >= 0; i--) {
			stepResult = this.nestedCommands.get(i).undo();

			if (stepResult.hasComment()) {
				totalComment.append(stepResult.getComment()
						+ System.lineSeparator());
			}
		}

		return new StepResult(totalComment.toString().trim());
	}

	/**
	 * @param command
	 */
	public void add(IStep command) {
		this.nestedCommands.add(command);
	}

}
