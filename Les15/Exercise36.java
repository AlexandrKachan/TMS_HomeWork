import java.io.File;
//вывести список файлов и каталогов отдельно

public class Exercise36 {
    public static void main(String[] args) {

        File[] files = new File("c:/TMS").listFiles();


        for (File tipe : files) {
            if (tipe.isDirectory()) {
                System.out.println("Dir: " + tipe);
                tipe.listFiles();
            } else {
                System.out.println("File: " + tipe);

            }
        }
    }
}