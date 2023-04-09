package Controller;

import Utils.CSVUtil;
import View.CSVView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CSVController {
    public static List<String []> read(){
        try {
            List<String[]> data = CSVUtil.reader(System.getProperty("user.dir") + "\\data\\invoices.csv");
            // CSVView.show(data);
            return data;
        }catch (FileNotFoundException e){
            CSVView.fileNotFound(e.getMessage());
            return null;
        }catch (IOException e){
            CSVView.fileReadError(e.getMessage());
            return null;
        }
    }

    public static <Type> void store(Type[] list){
        String path = "result.csv";

        CSVUtil.write(list, path);

        CSVView.stored(path);
    }
}
