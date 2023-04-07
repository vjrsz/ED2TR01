package Service;

import Model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    public static Invoice[] createFromCSV(List<String[]> data){
        Invoice[] invoices = new Invoice[data.size() - 1];

        // variable i initializes to 1 to skip csv header
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);

            String firstName = row[0];
            String lastName = row[1];
            String email = row[2];
            int product_id = Integer.parseInt(row[3]);
            int quantity = Integer.parseInt(row[4]);
            double amount = Double.parseDouble(row[5]);
            String invoiceDate = row[6];
            String address = row[7];
            String city = row[8];
            int stockCode = Integer.parseInt(row[9]);
            String job = row[10];

            invoices[i - 1]  = new Invoice( firstName, lastName, email, product_id, quantity, amount, invoiceDate, address,
                    city, stockCode, job);
        }

        return invoices;
    }
}
