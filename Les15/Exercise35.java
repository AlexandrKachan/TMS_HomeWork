import java.io.*;


public class Exercise35<a> {
    //        Записать в двоичный файл 20 случайных чисел. Прочитать записанный файл,
//                распечатать числа и их среднее арифметическое.
    public static void main(String[] args) throws IOException {

        int summ = 0;
        int count = 0;

        DataOutputStream dos;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new
                    FileOutputStream("integer.dat")));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        for (int i = 0; i < 20; i++) {
            int rand = (int) (Math.random() * 100 + 1);
            dos.writeInt(rand);
        }
        dos.close();
//**************************************************
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream("integer.dat")));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;

        }
        System.out.print("20 случайных чисел  - ");
        int res = dis.readInt();
        while (true) {
            System.out.print(res + " ");
            summ += res;
            count++;

            try {
                res = dis.readInt();
            } catch (EOFException e) {
                break;
            }
        }
        if (dis != null) {
            dis.close();
        }


        double srAr = (summ * 1.0) / count;
        System.out.println();
        System.out.println("Среднее арифметическое = " + srAr);


    }

}
