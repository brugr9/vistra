package vistra.core.graph.event;

import java.util.List;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.traversal.step.IStep;

/**
 * A render-graph event listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class RenderGraphEventListener implements
		IRenderGraphEventListener<IVertexLayout, IEdgeLayout> {

	/**
	 * A field for a list of steps.
	 */
	List<IStep> stepList;

	/**
	 * Main constructor.
	 * 
	 * @param stepList
	 *            a list for steps
	 */
	public RenderGraphEventListener(List<IStep> stepList) {
		this.stepList = stepList;
	}

	@Override
	public void handleRenderGraphEvent(
			RenderGraphEvent<IVertexLayout, IEdgeLayout> evt) {

		IStep step = null;

		switch (evt.type) {
		case VISIT_VERTEX:

			break;

		default:
			break;
		}

		this.stepList.add(step);

	}
}
