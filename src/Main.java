import Controller.CSVController;
import Controller.InvoiceController;
import Controller.MenuController;
import Model.Invoice;

import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String[]> dataInvoices = CSVController.read();
        if (dataInvoices == null) {
            return;
        }

        Invoice[] invoices = InvoiceController.create(dataInvoices);

        MenuController.show();
        int attributeChosen = MenuController.attributeChosen - 1;
        int sorterChosen = MenuController.sorterChosen;
        int orderByChosen = MenuController.orderByChosen;

        InvoiceController.runSorter(invoices, attributeChosen, sorterChosen, orderByChosen);
    }
}