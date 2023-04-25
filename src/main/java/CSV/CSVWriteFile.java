package CSV;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriteFile {
    public static <Type extends CSVExportClass> void write(Type[] list, String path){
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            for ( Type e : list) {
                writer.writeNext(e.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
