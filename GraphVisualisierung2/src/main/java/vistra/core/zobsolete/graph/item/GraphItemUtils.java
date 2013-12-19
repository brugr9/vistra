package vistra.core.zobsolete.graph.item;

import java.util.Collection;
import java.util.List;

import vistra.core.zobsolete.graph.item.IRestrictedGraphItem.State;
import vistra.core.zobsolete.graph.item.vertex.IRestrictedVertex;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public final class GraphItemUtils {

	/**
	 * A main (no-)constructor.
	 */
	private GraphItemUtils() {
	}

	/**
	 * 
	 * @param item
	 * @param newResult
	 * @param isTagged
	 * @param isStateCommentEnabled
	 * @param newComment
	 */
	public static void setGraphItemValues(IRestrictedGraphItem item,
			double newResult, boolean isTagged, boolean isStateCommentEnabled,
			String newComment) {
		item.setNewResult(newResult);
		item.setTagged(isTagged);
		item.setStateCommentEnabled(isStateCommentEnabled);
		item.setNewComment(newComment);
	}

	/**
	 * 
	 * @param item
	 * @param newResult
	 * @param isTagged
	 * @param isStateCommentEnabled
	 * @param newComment
	 * @param newState
	 */
	public static void setGraphItemValues(IRestrictedGraphItem item,
			double newResult, boolean isTagged, boolean isStateCommentEnabled,
			String newComment, State newState) {
		item.setNewResult(newResult);
		item.setTagged(isTagged);
		item.setStateCommentEnabled(isStateCommentEnabled);
		item.setNewComment(newComment);
		item.setNewState(newState);
	}

	/**
	 * 
	 * @param item
	 * @param newResult
	 * @param isTagged
	 * @param isStateCommentEnabled
	 * @param newState
	 */
	public static void setGraphItemValues(IRestrictedGraphItem item,
			double newResult, boolean isTagged, boolean isStateCommentEnabled,
			State newState) {
		item.setNewResult(newResult);
		item.setTagged(isTagged);
		item.setStateCommentEnabled(isStateCommentEnabled);
		item.setNewState(newState);
	}

	/**
	 * 
	 * @param item
	 * @param isTagged
	 * @param isStateCommentEnabled
	 */
	public static void setGraphItemValues(IRestrictedGraphItem item,
			boolean isTagged, boolean isStateCommentEnabled) {
		item.setTagged(isTagged);
		item.setStateCommentEnabled(isStateCommentEnabled);
	}

	/**
	 * 
	 * @param item
	 * @param newResult
	 * @param isTagged
	 * @param isStateCommentEnabled
	 */
	public static void setGraphItemValues(IRestrictedGraphItem item,
			double newResult, boolean isTagged, boolean isStateCommentEnabled) {
		item.setNewResult(newResult);
		item.setTagged(isTagged);
		item.setStateCommentEnabled(isStateCommentEnabled);
	}

	/**
	 * 
	 * @param item
	 * @param isTagged
	 * @param isStateCommentEnabled
	 * @param newComment
	 */
	public static void setGraphItemValues(IRestrictedGraphItem item,
			boolean isTagged, boolean isStateCommentEnabled, String newComment) {
		item.setTagged(isTagged);
		item.setStateCommentEnabled(isStateCommentEnabled);
		item.setNewComment(newComment);
	}

	/**
	 * 
	 * @param item
	 * @param isTagged
	 * @param isStateCommentEnabled
	 * @param newState
	 */
	public static void setGraphItemValues(IRestrictedGraphItem item,
			boolean isTagged, boolean isStateCommentEnabled, State newState) {
		item.setTagged(isTagged);
		item.setStateCommentEnabled(isStateCommentEnabled);
		item.setNewState(newState);
	}

	/**
	 * @param graphItems
	 * @param itemList
	 * @param value
	 */
	public static void tagGraphItems(
			Collection<? extends IRestrictedVertex> graphItems,
			List<IRestrictedGraphItem> itemList, boolean value) {
		for (IRestrictedVertex item : graphItems) {
			item.setTagged(value);
			itemList.add(item);
		}
	}

	/**
	 * 
	 * @param item
	 * @param isTagged
	 * @param isStateCommentEnabled
	 * @param newComment
	 * @param newState
	 */
	public static void setGraphItemValues(IRestrictedGraphItem item,
			boolean isTagged, boolean isStateCommentEnabled, String newComment,
			State newState) {
		item.setTagged(isTagged);
		item.setStateCommentEnabled(isStateCommentEnabled);
		item.setNewComment(newComment);
		item.setNewState(newState);
	}

}
