import java.util.ArrayList;
import java.util.Iterator;

public class Exercise31 {


    //Создать список оценок учеников с помощью ArrayList, заполнить случайными
//оценками. С помощью итератора найти самую высокую оценку


    public static void main(String[] args) {
        ArrayList<Integer> student1 = new ArrayList<>();
        ArrayList<Integer> student2 = new ArrayList<>();
        ArrayList<Integer> student3 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int j = 1 + (int) (Math.random() * 5);
            student1.add(i, j);
             j = 1 + (int) (Math.random() * 5);
            student2.add(i, j);
              j = 1+(int) (Math.random() * 5);
            student3.add(i, j);
        }
        System.out.println("Все оценки студента 1" + student1);
        System.out.println("Все оценки студента 2" + student2);
        System.out.println("Все оценки студента 3" + student3);


        int i = 0;
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;

        Iterator iterator = student1.iterator();
//        Iterator iterator = student2.iterator();
//        Iterator iterator = student3.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            if ((student1.get(i) > x1)) {
                x1 = student1.get(i);
            }
            if ((student2.get(i) > x2)) {
                x2 = student2.get(i);
            }
            if ((student3.get(i) > x3)) {
                x3 = student3.get(i);
            }
            i++;
        }

        System.out.println("Максимальная оценка первого студента  " + x1);
        System.out.println("Максимальная оценка второго студента  " + x1);
        System.out.println("Максимальная оценка третьего студента  " + x1);

    }
}



