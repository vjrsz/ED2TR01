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
        int attributeChoice = MenuController.attributeChosen - 1;
        int sorterChoice = MenuController.sorterChosen;
        int orderByChoice = MenuController.orderByChosen;

        InvoiceController.runSorter(invoices, attributeChoice, sorterChoice, orderByChoice);
    }
}