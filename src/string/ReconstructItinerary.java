package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
        if(tickets == null || tickets.length == 0) return null;
        Arrays.sort(tickets, comparator);
        
        List<String> list = new ArrayList<String>();
        list.add("JFK");
        
        boolean[] usedTicket = new boolean[tickets.length];
        backtrack(list, usedTicket, tickets);
        return list;
    }
    
    private void backtrack(List<String> list, boolean[] usedTicket, String[][] tickets) {
        String location = list.get(list.size()-1);
        for(int i=0; i<usedTicket.length; ++i) {
            if(usedTicket[i]) {
                continue;
            }
            if(tickets[i][0].equals(location)) {
                usedTicket[i] = true;
                list.add(tickets[i][1]);
                backtrack(list, usedTicket, tickets);
                
                if(list.size() == usedTicket.length+1) {
                    return;
                }
                list.remove(list.size()-1);
                usedTicket[i] = false;
            }
        }
    }
    
    Comparator<String[]> comparator = new Comparator<String[]>() {
        @Override
        public int compare(String[] s1, String[] s2) {
            return s1[1].compareTo(s2[1]);
        }
    };
    
    public static void main(String[] args) {
    		ReconstructItinerary ri = new ReconstructItinerary();
    		String[][] tickets = {
    				{"MUC","LHR"},
    				{"JFK","MUC"},
    				{"SFO","SJC"},
    				{"LHR","SFO"}
    		};
    		Arrays.sort(tickets, ri.comparator);
    		System.out.println(Arrays.deepToString(tickets));
    		System.out.println(Arrays.toString(ri.findItinerary(tickets).toArray()));
    }
    
    public List<String> findItinerary2(String[][] tickets) {
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        visit("JFK");
        return route;
    }

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList();

    void visit(String airport) {
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }
}
