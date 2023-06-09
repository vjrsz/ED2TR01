package View;

import java.util.List;

public class CSVView {
    public static void fileNotFound(String path){
        IView.divider();

        System.out.printf("File CSV (%s) was not found!\n", path);
    }
    public static void fileReadError(String path){
        IView.divider();

        System.out.printf("File CSV (%s) cannot be read!\n", path);
    }
    public static void show(List<String[]> data){
        IView.divider();

        for (String[] row : data) {
            for (String field : row) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }

    public static void stored(String path){
        IView.divider();

        System.out.printf("File CSV (%s) stored!\n", path);
    }
}
