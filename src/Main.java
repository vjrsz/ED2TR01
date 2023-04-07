import Controller.CSVController;
import Controller.InvoiceController;
import Model.Invoice;
import View.MenuView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuView.divider();
        
        List<String[]> dataInvoices = CSVController.read();

        if ( dataInvoices == null ){ return; }

        Invoice[] invoices = InvoiceController.create(dataInvoices);

        MenuView.divider();
        MenuView.firstChoice();
    }
}