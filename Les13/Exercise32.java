
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


//частотный словарь

class Exercise32 {

    public static void main(String[] args) {
        String text = "Частотный словарь, Частотный словарь, Частотный словарь, Частотный словарь." +
                " Словарь может Словарь может Словарь может Словарь может " +
                " по алфавиту по алфавиту по алфавиту по алфавиту по алфавиту ";
        Map<String, Integer> dictionary = new HashMap<>();


        StringTokenizer words = new StringTokenizer(text, " ,.");

        System.out.println(words);

        while (words.hasMoreTokens()) {
            String word = words.nextToken();
            if (dictionary.containsKey(word)) {
                int key = dictionary.get(word);
                dictionary.put(word, ++key);
            } else {
                dictionary.put(word,1);
            }
        }

        System.out.println(dictionary);
    }
}


