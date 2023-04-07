import Controller.CSVController;
import Controller.InvoiceController;
import Model.Invoice;
import Model.Sorter;
import Service.InvoiceService;
import Service.SorterService;
import View.MenuView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuView.divider();

        List<String[]> dataInvoices = CSVController.read();
        if (dataInvoices == null) {
            return;
        }

        Invoice[] invoices = InvoiceController.create(dataInvoices);

        MenuView.divider();
        int attributeChoice = MenuView.firstChoice();
        MenuView.divider();
        int sorterChoice = MenuView.secondChoice();
        MenuView.divider();
        int orderByChoice = MenuView.thirdChoice();
        MenuView.divider();

        Sorter<Invoice> sorter = SorterService.getSorter(sorterChoice);
        sorter.setList(invoices);
        sorter.setType(Invoice.class);
        sorter.setOrderBy(orderByChoice);
        sorter.sort(InvoiceService.bif);


    }
}