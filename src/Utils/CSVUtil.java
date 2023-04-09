package Utils;

import Model.Invoice;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVUtil <Type> {
    private static String deLimiter = ",";

    public static List<String[]> reader(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<String[]> data = new ArrayList<>();
            String line;

            while( (line = br.readLine()) != null) {
                String[] fields = line.split(CSVUtil.deLimiter);
                data.add(fields);
            }

            return data;
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException( path );
        }
        catch (IOException e) {
            throw new IOException( path );
        }
    }

    public static <Type> void write(Type[] list, String path){
        try {
            FileWriter file = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(file);

            for(Type item : list){
                Field[] attributes = item.getClass().getDeclaredFields();

                int i = 0;
                for(Field attr : attributes){
                    attr.setAccessible(true);
                    try {
                        Object value = attr.get(item);
                        if ( value.getClass().equals(Date.class) ){
                            printWriter.print(DateUtils.getStringFormat((Date) value, "dd/MM/yyyy"));

                        } else{  printWriter.print(value.toString()); }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    if (i != attributes.length - 1) {
                        printWriter.print(",");
                    }else{
                        printWriter.print("\n");
                    }
                    i++;
                }
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

