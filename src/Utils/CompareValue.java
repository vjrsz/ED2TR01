package Utils;

public class CompareValue {

    public static int compareString(String a, String b){
        int res = a.compareTo(b);

        if ( res < 0 ){ return -1;}
        else if ( res > 0 ){ return 1;}
        else { return 0; }
    }

    public static int compareInteger(int a, int b){
        if ( a < b ){ return -1;}
        else if ( a > b ){ return 1;}
        else { return 0; }
    }

    public static int compareDouble(double a, double b){
        if ( a < b ){ return -1;}
        else if ( a > b ){ return 1;}
        else { return 0; }
    }

}
