import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(    "wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }




    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        HashMap<String, Integer> windowMap = new HashMap<>();
        List<Integer> res = new LinkedList<>();

        if(words==null || words.length==0) return res;
        int matchCount = 0;
        int wordLen = words[0].length();
        int allWordLen = words.length * wordLen;
        if (s.length() < allWordLen) return res;

        for (String s1 : words) {
            if (wordsMap.containsKey(s1)) {
                wordsMap.put(s1, wordsMap.get(s1)+1);
            } else {
                wordsMap.put(s1, 1);
            }
        }

        for (int lo = 0; lo <= s.length() - allWordLen; ++lo) {
            windowMap = new HashMap<>();
            matchCount =0;
            for (int j = 0; j < words.length; ++j) {
                String word = s.substring(lo + wordLen * j, lo + wordLen * j + wordLen);
                if (!wordsMap.containsKey(word))
                    break;
                if (windowMap.containsKey(word)) {
                    windowMap.put(word, windowMap.get(word) + 1);
                } else {
                    windowMap.put(word, 1);
                }

                if (windowMap.get(word) <= wordsMap.get(word)) {
                    matchCount++;
                } else {
                    break;
                }
                if (matchCount == words.length) {
                    res.add(lo);
                }
            }

        }
        return res;
    }
}

