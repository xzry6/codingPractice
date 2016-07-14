package systemDesign;

import java.util.Iterator;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * 
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * 
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 * 
 * Follow up:
 * - What if you are given k 1d vectors? 
 * - How well can your code be extended to such cases?
 * 
 * @author Sean
 *
 */
public class ZigZagIterator {
	/**
     * Variables.
     */
    List<Integer> l1;
    List<Integer> l2;
    int index;

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        this.l1 = v1;
        this.l2 = v2;
        this.index = 0;
    }

    public int next() {
        int index = this.index;
        this.index ++;

        int s1 = this.l1.size();
        int s2 = this.l2.size();
        if(index/2 >= s1) return this.l2.get(index - s1);
        if(index/2 >= s2) return this.l1.get(index - s2);

        boolean which = index%2 == 0;
        List<Integer> temp = which ? l1 : l2;
        return temp.get(index/2);
    }

    public boolean hasNext() {
        return this.index < this.l1.size() + this.l2.size();
    }
}

class ZigzagIterator {
	/**
     * Variables.
     */
    Iterator<Integer> i;
    Iterator<Integer> j;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if(j.hasNext()) {
            Iterator<Integer> tmp = j;
            j = i;
            i = tmp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}
