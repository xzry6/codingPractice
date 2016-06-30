package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;

public class Info4 {
	
	class Item{
	    public Integer id;
	    public Double score;
	    
	    Item(){
	    }
	    
	    Item(Integer id, Double score){
	        this.id = id;
	        this.score = score;
	    }
	    
	    @Override  
	    public int hashCode() {  
	        final int prime = 31;  
	        int result = 1;  
	        result = prime * result + score.intValue();  
	        return result;  
	    }  
	  
	    @Override  
	    public boolean equals(Object obj) {  
	        if (this == obj)  
	            return true;  
	        if (obj == null)  
	            return false;  
	        if (getClass() != obj.getClass())  
	            return false;  
	        Item other = (Item) obj;  
	        if (score != other.score)  
	            return false; 
	        return true;  
	    }  
	}
	
	Map<Item, Double> buildMap() {
		Map<Item, Double> input = new HashMap<Item, Double>();
		Random r = new Random();
		for(int i=0; i<50; ++i) {
			Item tmp = new Item(r.nextInt(), Math.round(r.nextDouble()*10)/10.0);
			input.put(tmp, Math.round(r.nextDouble()*10)/10.0);
		}
		return input;
	}
	
	Comparator<Item> comparator = new Comparator<Item>() {
	    @Override
	    public int compare(Item a, Item b) {
	        if(a.score > b.score) return 1;
	        if(a.score < b.score) return -1;
	        else return 0;
	    }
	};
	
	List<Item> sortMap (Map<Item, Double> input) {
	    Iterator<Item> it = input.keySet().iterator();
	    Item[] arr = new Item[input.size()];
	    int count = 0;
	    while(it.hasNext()) {
	        Item tmp = it.next();
	        arr[count++] = tmp;
	    }
	    Arrays.sort(arr, comparator);
	    List<Item> list = new ArrayList<Item>();
	    for(Item tmp:arr) {
	        list.add(tmp);
	    }
	    return list;
	}
	
	void removeItem (Map<Item, Double> input, Double price) {
//	    Iterator<Item> it = input.keySet().iterator();
//	    Item tmp = null;
//	    while(it.hasNext()) {
//	        tmp = it.next();
//	        Double value = input.get(tmp);
//	        if(value.equals(price))
//	        		//it.remove();
//	        		break;
//	    }
//		input.remove(tmp);
		for (Entry<Item, Double> entry: input.entrySet())
		    if (entry.getValue().equals(price))
		        input.remove(entry.getKey());
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.remove();
	}
	
	public static void main(String[] args) {
		Info4 info = new Info4();
		Map<Item, Double> input = info.buildMap();
		info.removeItem(input, 0.1);
		List<Item> list = info.sortMap(input);
		for(Item i:list)
			System.out.println(i.score);
		System.out.println("list size is: "+list.size());
	}
}
