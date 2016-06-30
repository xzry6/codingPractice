package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
	public String[] topKFrequentWords(String[] words, int k) {
        class Word {
            int num;
            String word;
            Word(int num, String word) {
                this.word = word;
                this.num = num;
            }
        }
        
        Comparator<Word> c = new Comparator<Word>() {
            public int compare(Word w1, Word w2) {
                if(w1.num != w2.num)
                    return w1.num-w2.num;
                else return w2.word.compareTo(w1.word);
            }  
        };
        // Write your code here
        if(words == null || words.length == 0) return null;
        int min = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Queue<Word> queue = new PriorityQueue<Word>(k, c);
        for(String word: words) {
            if(map.containsKey(word)) {
                int num = map.get(word)+1;
                map.put(word, num);
                
            }
            else map.put(word, 1);
        }
        
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
        		String key = it.next();
        		if(map.get(key) >= min) {
        			queue.add(new Word(map.get(key), key));
        			if(queue.size() > k) {
        				queue.poll();
        				min = queue.peek().num;
        			}
            }
        }
        
        String[] result = new String[k];
        for(int i=k-1; i>=0; --i) {
            result[i] = queue.poll().word;
        }
        return result;
    }
	
	public static void main(String[] args) {
		TopKFrequentWords tkfw = new TopKFrequentWords();
		String[] words = {"yes", "lint", "code",
			    "yes", "code", "baby",
			    "you", "baby", "chrome",
			    "safari", "lint", "code",
			    "body", "lint", "code"};
		System.out.println(Arrays.toString(tkfw.topKFrequentWords(words, 3)));
	}

	public static List<Integer> topKFrequent2(int[] nums, int k) {
		// Declare a class.
		class Number {
			int value;
			int count;
			Number(int value, int count) {
				this.value = value;
				this.count = count;
			}
		}

		// Declare a comparing scheme.
		Comparator<Number> comparator = new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				return o2.count - o1.count;
			}
		};
		// Create an empty list.
		List<Integer> list = new ArrayList<Integer>();
		// Return empty list if input is not ripe.
		if(nums == null || nums.length == 0 || k == 0) return list;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n:nums) {
			if(map.containsKey(n)) {
				map.put(n, map.get(n)+1);
			} else {
				map.put(n, 1);
			}
		}

		// Create a priority queue.
		Queue<Number> queue = new PriorityQueue<Number>(comparator);
		Iterator<Integer> i1 = map.keySet().iterator();
		while(i1.hasNext()) {
			int key = i1.next();
			queue.offer(new Number(key, map.get(key)));
		}

		// Poll top frequency number out.
		for(int i=0; i<k; ++i) {
			list.add(queue.poll().value);
		}

		return list;
	}
}
