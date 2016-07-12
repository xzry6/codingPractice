package treeStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * 
 * Example 1:
	     3
	    / \
	   2   3
	    \   \ 
	     3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * Example 2:
	     3
	    / \
	   4   5
	  / \   \ 
	 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * @author Sean
 *
 */
public class HouseRobberIII {

    // Global Variables.
    Map<TreeNode, Integer> trues;
    Map<TreeNode, Integer> falses;

    public int rob(TreeNode root) {
        // Deal with null first.
        if(root == null) return 0;
        // Initialization.
        trues = new HashMap<TreeNode, Integer>();
        falses = new HashMap<TreeNode, Integer>();
        // Divide Conquer.
        return divideConquer(root, false);
    }

    /**
     * Divide and conquer and calculate robbed value.
     * 
     * @param {TreeNode} node - current node.
     * @param {boolean} isRobbed - if parent node been robbed.
     * @return {int} maximum robbed value.
     */
    private int divideConquer(TreeNode node, boolean isRobbed) {
        if(node == null) return 0;
        if(isRobbed && trues.containsKey(node)) return trues.get(node);
        if(!isRobbed && falses.containsKey(node)) return falses.get(node);

        int subMax = divideConquer(node.left, false) + divideConquer(node.right, false);
        if(isRobbed) {
            trues.put(node, subMax);
            return subMax;
        }
        else {
            int max = Math.max(subMax, divideConquer(node.left, true)
                                     + divideConquer(node.right, true)
                                     + node.val);
            falses.put(node, max);
            return max;
        }
    }
}
