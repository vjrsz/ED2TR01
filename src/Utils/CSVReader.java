package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static String deLimiter = ",";

    public static List<String[]> reader(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<String[]> data = new ArrayList<>();
            String line;

            while( (line = br.readLine()) != null) {
                String[] fields = line.split(CSVReader.deLimiter);
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
}

