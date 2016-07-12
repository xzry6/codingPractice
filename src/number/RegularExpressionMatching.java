package number;

public class RegularExpressionMatching {
	/**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    
	public static void main(String[] args) {
		String s = "aa";
		String p = "aa";
		RegularExpressionMatching rem = new RegularExpressionMatching();
		System.out.print(rem.isMatch(s, p));
	}

    boolean[][] traversed;
    public boolean isMatch(String s, String p) {
        if(s == null) return p == null;
        if(s.isEmpty()) return p.isEmpty();

        traversed = new boolean[s.length()][p.length()];

        return divideConquer(s, p, 0, 0);
    }

    private boolean divideConquer(String s, String p, int x, int y) {
        // Edge cases.
        if(x >= s.length() && y >= p.length()) return true;
        if(x >= s.length() || y >= p.length()) return false;
        if(traversed[x][y]) return false;
        traversed[x][y] = true;
        // Condition and recursion and return.
        
        // Next is not '*'.
        if(y == p.length() - 1 || p.charAt(y + 1) != '*') {
            // Match ? go ahead : return false.
            if(s.charAt(x) != p.charAt(y)) return false;
            return divideConquer(s, p, x + 1, y + 1);
        }

        // Next is '*'.
        // Match ?
        if(s.charAt(x) == p.charAt(y) || p.charAt(y) == '.') {
            // Move x.
            if(divideConquer(s, p, x + 1, y)) return true;
            // Move both x and y.
            if(divideConquer(s, p, x + 1, y + 2)) return true;
        }

        // Move y.
        return divideConquer(s, p, x, y + 2);
    }
}
