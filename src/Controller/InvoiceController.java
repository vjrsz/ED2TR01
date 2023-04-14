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

    public static void runSorter(Invoice[] invoices, int attributeChosen, int sorterChosen, int orderByChosen){
        Sorter<Invoice> sorter = SorterController.create( Invoice.class, invoices, sorterChosen, orderByChosen );

        Invoice.setPrimaryKey(attributeChosen);

        InvoiceView.running(sorter.getName());

        long timeInit, timeEnd;

        timeInit = System.currentTimeMillis();
        sorter.sort(InvoiceService.bif);
        timeEnd = System.currentTimeMillis();

        InvoiceView.finalized(timeInit, timeEnd);

        CSVController.store(sorter.getList(), sorter.getName());

        //InvoiceView.show(sorter.getList());
        //InvoiceService.test(InvoiceService.bif, invoices);
    }
}
