import java.util.*;

//создать коллекцию. наполнить ее числами, удалить повторяющиеся

public class Exercise30 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int j = 1 + (int) (Math.random() * 5);
            numbers.add(i, j);
        }
        System.out.println("Все оценки" + numbers);

        //добавить содержимое в Set(что не допустит дублирования), а затем добавить Set обратно в ArrayList

        Set<Integer> set = new LinkedHashSet<>(numbers);
        numbers.clear();
        numbers.addAll(set);


        System.out.println("Не повторяющиеся оценки " + numbers);

    }



}
