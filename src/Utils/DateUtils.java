package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date createFromFormat(String value, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date invoiceDate = null;
        try {
            invoiceDate = sdf.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return invoiceDate;
    }

    public static String getStringFormat(Date value, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateFormatted = formatter.format(value);
        return dateFormatted;
    }
}
