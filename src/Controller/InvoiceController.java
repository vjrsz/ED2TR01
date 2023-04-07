package Controller;

import Model.Invoice;
import Service.InvoiceService;
import View.InvoiceView;

import java.util.ArrayList;
import java.util.List;

public class InvoiceController {

    public static Invoice[] create(List<String[]> data){
        Invoice[] invoices = InvoiceService.createFromCSV(data);

        InvoiceView.created(invoices.length);

        return invoices;
    }

}
