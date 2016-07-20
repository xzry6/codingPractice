package number;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that
 * looks the same when rotated 180 degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 * 
 * @author Sean
 *
 */
public class StrobogrammaticNumberII {
	/**
     * Rules:
     * 1->1
     * 6->9
     * 8->8
     * 9->6
     * 0->0
     * 
     * n = 1 [1, 8, 0]
     * n = 2 [11, 69, 96, 88]
     * n = 3 [101, 111, 181]
     */
    public List<String> findStrobogrammatic(int n) {
        if(n == 0) return new ArrayList<String>();
        return recursive(n, n);
    }

    private List<String> recursive(int n, int total) {
        List<String> list = new ArrayList<String>();
        if(n == 1) {
            list.add("0");
            list.add("1");
            list.add("8");
            return list;
        }
        if(n == 2) {
            if(n != total) list.add("00");
            list.add("11");
            list.add("69");
            list.add("88");
            list.add("96");
            return list;
        }
        List<String> last = recursive(n - 2, total);
        for(String s:last) {
            if(n != total) list.add("0" + s + "0");
            list.add("1" + s + "1");
            list.add("6" + s + "9");
            list.add("8" + s + "8");
            list.add("9" + s + "6");
        }
        return list;
    }
}
