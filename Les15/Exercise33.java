
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise33 {


    public static void main(String[] args) throws IOException {
        String text = "Раз - 111 два три. три, три! два 222  333 444?\n" +
                "333 456 789 ";
        System.out.println(text);
// записываем файл
        FileWriter writer = null;
        try {
            writer = new FileWriter("text.txt");
//            for (int i = 0; i < text.length(); i++) {
//                writer.write(text.charAt(i));
//            }
            writer.write(text);

            System.out.println("Файл записан.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
//читаем файл

        BufferedReader fileInputStream = new BufferedReader(new FileReader("text.txt"));
        String res = fileInputStream.readLine();

        String text2 = "";

        while (res != null) {
            text2 += res;
            res = fileInputStream.readLine();

        }
        fileInputStream.close();
        System.out.println(text2);

//        FileReader fileInputStream = new FileReader("text.txt");
//        int res = fileInputStream.read();
//        while (res!=-1){
//            System.out.print((char)res);
//            res = fileInputStream.read();
//        }
        System.out.println(" Файл прочитан.");
        fileInputStream.close();


        Map<String, Integer> dictionary = new HashMap<>();
        int count = 0;
        Pattern p = Pattern.compile("[-.,:;!?()]");
        Matcher m = p.matcher(text2);
        while (m.find()) {
            count++;
        }
        System.out.println("Знаков препинания в тексте - " + count);

        StringTokenizer words = new StringTokenizer(text2, " ,.-!?");

        count = 0;
        while (words.hasMoreTokens()) {
            String word = words.nextToken();
            count++;
            if (dictionary.containsKey(word)) {
                int key = dictionary.get(word);
                dictionary.put(word, ++key);
            } else {
                dictionary.put(word, 1);
            }
        }

        System.out.println("Слов в тексте - " + count);
    }
}







