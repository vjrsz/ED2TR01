package Service;

import Model.Invoice;
import Utils.CompareValue;

import java.util.List;
import java.util.function.BiFunction;

public class InvoiceService implements BiFunction<Invoice, Invoice, Integer> {

    public static BiFunction<Invoice, Invoice, Integer> bif = new InvoiceService();

    public static Invoice[] createFromCSV(List<String[]> data){
        int len =  3 /*data.size()*/;
        Invoice[] invoices = new Invoice[len - 1];

        // variable i initializes to 1 to skip csv header
        for (int i = 1; i < len; i++) {
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

    @Override
    public Integer apply(Invoice invoice, Invoice invoice2) {
        Class<?> typePrimaryKey = invoice.getPrimaryKeyValue().getClass();

        if ( typePrimaryKey.equals(String.class) ){
            String valueInvoice = (String) invoice.getPrimaryKeyValue();
            String valueInvoice2 = (String) invoice2.getPrimaryKeyValue();

            return CompareValue.compareString(valueInvoice, valueInvoice2);
        } else if ( typePrimaryKey.equals(Integer.class) ) {
            int valueInvoice = (int) invoice.getPrimaryKeyValue();
            int valueInvoice2 = (int) invoice2.getPrimaryKeyValue();

            return CompareValue.compareInteger(valueInvoice, valueInvoice2);
        } else if ( typePrimaryKey.equals(Double.class) ) {
            double valueInvoice = (double) invoice.getPrimaryKeyValue();
            double valueInvoice2 = (double) invoice2.getPrimaryKeyValue();

            return CompareValue.compareDouble(valueInvoice, valueInvoice2);
        }

        return 1;
    }

    public static void test(BiFunction<Invoice, Invoice, Integer> bif, Invoice[] invoices){
        for (int i = 0; i < invoices.length; i++){
            bif.apply(invoices[i], invoices[i]);
        }
    }
}
