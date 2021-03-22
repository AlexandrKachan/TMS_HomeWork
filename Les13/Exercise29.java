
//Создать список оценок учеников с помощью ArrayList, заполнить случайными
//оценками. Удалить неудовлетворительные оценки из списка.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Exercise29 {

    public static void main(String[] args) {
        ArrayList<Integer> ocenki = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int j = 1 + (int) (Math.random() * 10);
            ocenki.add(i, j);
        }
        System.out.println("Все оценки" + ocenki);
        System.out.println("Количество элементов в масиве " + ocenki.size());


        for (int i = 0; i < ocenki.size(); i++) {
            if (ocenki.get(i) <= 5) {
                ocenki.remove(i);
            }
        }

        System.out.println("Хорошие оценки" + ocenki);
        System.out.println("Количество элементов в масиве " + ocenki.size());




    }
}

