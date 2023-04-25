package Sorter;

public class SorterService {
    public static Sorter getSorter(int idSorter){
        switch (idSorter) {
            case 1 -> { return new SelectSort(); }
            //case 2 -> { return new InsertSort(); }
            //case 3 -> { return new SelectSort(); }
        }
        return null;
    }
}
