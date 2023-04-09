package Controller;

import Model.Invoice;
import Model.Sorter;
import Service.InvoiceService;
import View.InvoiceView;

import java.util.List;

public class InvoiceController {
    public static Invoice[] create(List<String[]> data){
        Invoice[] invoices = InvoiceService.createFromCSV(data);

        InvoiceView.created(invoices.length);

        return invoices;
    }

    public static void runSorter(Invoice[] invoices, int attributeChoice, int sorterChoice, int orderByChoice){
        Sorter<Invoice> sorter = SorterController.create( Invoice.class, invoices, sorterChoice, orderByChoice );

        Invoice.setPrimaryKey(attributeChoice);

        InvoiceView.running(sorter.getName());

        sorter.sort(InvoiceService.bif);

        CSVController.store(sorter.getList(), sorter.getName());
        //InvoiceView.show(sorter.getList());
        //InvoiceService.test(InvoiceService.bif, invoices);
    }
}
