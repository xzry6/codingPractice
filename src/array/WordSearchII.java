package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a 2D board and a list of words from the dictionary,
 * find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * 
 * For example,
 * Given 
 * words = ["oath","pea","eat","rain"] and 
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * 
 * Return ["eat","oath"].
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author Sean
 *
 */
public class WordSearchII {
	public static void main(String[] args) {
		WordSearchII ws2 = new WordSearchII();
		String[] words = {"add", "adc", "bc"};
		char[][] board = {
				{'d', 'a', 'b'},
				{'c', 'b', 'c'}
		};
		List<String> list = ws2.findWords(board, words);
		for(String s:list) System.out.println(s);
	}

	private class WordPiece {
        Map<Character, WordPiece> map;

        public WordPiece() {
            this.map = new HashMap<Character, WordPiece>();
        }
    }

	public List<String> findWords(char[][] board, String[] words) {
        // Deal with edge cases first.
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return new ArrayList<String>();
        // Create the graph.
        Map<Character, WordPiece> map = createGraph(words);
        Set<String> set = new HashSet<String>();
        boolean[][] flag = new boolean[board.length][board[0].length];
        // Find word.
        for(int i = 0; i < board.length; ++ i)
            for(int j = 0; j < board[0].length; ++ j)
                findWord(set, map, flag, board, new StringBuilder(), i, j);
        return new ArrayList<String>(set);
    }

    private void findWord(
        Set<String> set,
        Map<Character, WordPiece> map,
        boolean[][] flag,
        char[][] board,
        StringBuilder cur,
        int i,
        int j) 
    {
        if(
            i < 0
            || i >= flag.length
            || j < 0
            || j >= flag[i].length
            || flag[i][j]
          ) return;
        if(!map.containsKey(board[i][j])) return;
        flag[i][j] = true;

        cur.append(board[i][j]);
        Map<Character, WordPiece> tmp = map.get(board[i][j]).map;
        if(tmp.containsKey('\n')) set.add(cur.toString());
        findWord(set, tmp, flag, board, cur, i + 1, j);
        findWord(set, tmp, flag, board, cur, i - 1, j);
        findWord(set, tmp, flag, board, cur, i, j + 1);
        findWord(set, tmp, flag, board, cur, i, j - 1);

        flag[i][j] = false;
        cur.deleteCharAt(cur.length() - 1);
    }

    private Map<Character, WordPiece> createGraph(String[] words) {
        Map<Character, WordPiece> map = new HashMap<Character, WordPiece>();
        for(String word:words) {
            Map<Character, WordPiece> tmp = map;
            for(int i = 0; i < word.length(); ++ i) {
                char c = word.charAt(i);
                if(!tmp.containsKey(c)) {
                    WordPiece wp = new WordPiece();
                    tmp.put(c, wp);
                }
                tmp = tmp.get(c).map;
                if(i == word.length() - 1) tmp.put('\n', null);
            }
        }
        return map;
    }
}
