package string;

import java.util.HashMap;
import java.util.Map;

public class RearrangeStringKDistanceApart {

	public static void main(String[] args) {
		String str = "aaabc";
		int k = 3;
		System.out.println(rearrangeString(str, k));
	}

	/**
     * minLen = 2 * (maxNum - 1) + 1
     */
    public static String rearrangeString(String str, int k) {
        // Deal with edge cases first.
        if(str == null || str.length() == 0 || k <= 1) return str;

        // Char array.
        char[] arr = str.toCharArray();
        // HashMap.
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        while(i < arr.length) {
            if(map.size() == k) map.remove(arr[i - k]);
            char c = arr[i];
            if(map.containsKey(c)) {
                int index = map.get(c) + k;
                while(index < arr.length && arr[index] == c) index ++;
                if(index >= arr.length) return "";
                arr[i] = arr[index];
                arr[index] = c;
            } else
                map.put(c, i ++);
        }
        return String.valueOf(arr);
    }
}
