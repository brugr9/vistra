package vistra.core.graph.item.state;

public final class ItemStateStatistics {

	public static StringBuilder getStatistics() {
		StringBuilder sb = new StringBuilder();
		sb.append("Statistics" + System.lineSeparator());
		/**/
		sb.append("Vertices:" + System.lineSeparator());
		int vUnexplored = VertexStateSolution.class.getSigners().length;
		int focussed = VertexStateFocussed.class.getSigners().length;
		int visited = VertexStateVisited.class.getSigners().length;
		int solutionV = VertexStateSolution.class.getSigners().length;
		sb.append(vUnexplored + ", " + focussed + ", " + visited + ", "
				+ solutionV + ", " + System.lineSeparator());
		/**/
		sb.append("Edges:" + System.lineSeparator());
		int eUnexplored = EdgeStateUnexplored.class.getSigners().length;
		int back = EdgeStateBack.class.getSigners().length;
		int forward = EdgeStateForward.class.getSigners().length;
		int cross = EdgeStateCross.class.getSigners().length;
		int discarded = EdgeStateDiscarded.class.getSigners().length;
		int discovery = EdgeStateDiscovery.class.getSigners().length;
		int solutionE = EdgeStateSolution.class.getSigners().length;
		sb.append(eUnexplored + ", " + back + ", " + forward + ", " + cross
				+ ", " + discarded + ", " + discovery + ", " + solutionE + ", "
				+ System.lineSeparator());
		return sb;
	}
}
