package string;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0) 
            return sb.toString();

        String[] words = s.split(" ");

        for(String word: words) {
            if(word.equals("")) continue;
            sb.insert(0, " ")
              .insert(0, word);
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }

	public static void main(String[] args) {
		ReverseWordsInAString rwias = new ReverseWordsInAString();
		System.out.println(rwias.reverseWords("   a   b "));
	}
}
